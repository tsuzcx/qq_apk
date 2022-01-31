package cooperation.qqfav.globalsearch;

import ayuh;
import ayuu;
import bivz;
import java.util.List;

class FavoriteSearchEngine$SearchRunnable
  implements Runnable
{
  ayuh<bivz> jdField_a_of_type_Ayuh;
  ayuu jdField_a_of_type_Ayuu;
  
  private FavoriteSearchEngine$SearchRunnable(FavoriteSearchEngine paramFavoriteSearchEngine) {}
  
  public void run()
  {
    ayuu localayuu = this.jdField_a_of_type_Ayuu;
    String str = this.jdField_a_of_type_Ayuu.a;
    List localList = this.this$0.a(localayuu);
    try
    {
      if ((this.jdField_a_of_type_Ayuh != null) && (localayuu == this.jdField_a_of_type_Ayuu) && (str.equals(this.jdField_a_of_type_Ayuu.a))) {
        this.jdField_a_of_type_Ayuh.a(localList, 1);
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqfav.globalsearch.FavoriteSearchEngine.SearchRunnable
 * JD-Core Version:    0.7.0.1
 */