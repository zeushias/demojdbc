package demojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class DemoJdbc {

	public static void main(String[] args) {
		// 
		///sauverEnBase("Fatima");
		lireEnBase();
	}

	// sauvegarder dans la base mysql
	public static void sauverEnBase(String personne) {

		
		// déclaration des informations d'accès à la bd
		String url = "jdbc:mysql://localhost/formation";
		String login = "root";
		String password = "";
		Connection cn = null;
		Statement st = null;
		
		// 
		
		try {
			
			// etape 1 chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			
			// etape 2 récupération de la connexion
			cn = DriverManager.getConnection(url, login, password);
			
			// etape 3 création de statement
			st = cn.createStatement();
			String sql = "Insert into `javadb` (`personne`) values ('"+ personne +"')";
			
			// etape 4 exécuter la requête
			st.executeUpdate(sql);
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				// etape 5 liberer les ressources
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	// lire dans la base mysql
		public static void lireEnBase() {

			
			// déclaration des informations d'accès à la bd
			String url = "jdbc:mysql://localhost/formation";
			String login = "root";
			String password = "";
			Connection cn = null;
			Statement st = null;
			ResultSet rs = null;
			
			// 
			
			try {
				
				// etape 1 chargement du driver
				Class.forName("com.mysql.jdbc.Driver");
				
				// etape 2 récupération de la connexion
				cn = DriverManager.getConnection(url, login, password);
				
				// etape 3 création de statement
				st = cn.createStatement();
				String sql = "select * from  javadb";
				
				// etape 4 exécuter la requête
				rs= st.executeQuery(sql);
				
				//etape5 parcours du resultSet
				while (rs.next()) {
					System.out.println(rs.getString("personne"));
				}
				
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
			}finally {
				try {
					// etape 5 liberer les ressources
					cn.close();
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		}
}


	
