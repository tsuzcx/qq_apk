package cooperation.qqfav.globalsearch;

import aypy;
import ayql;
import birs;
import java.util.List;

class FavoriteSearchEngine$SearchRunnable
  implements Runnable
{
  aypy<birs> jdField_a_of_type_Aypy;
  ayql jdField_a_of_type_Ayql;
  
  private FavoriteSearchEngine$SearchRunnable(FavoriteSearchEngine paramFavoriteSearchEngine) {}
  
  public void run()
  {
    ayql localayql = this.jdField_a_of_type_Ayql;
    String str = this.jdField_a_of_type_Ayql.a;
    List localList = this.this$0.a(localayql);
    try
    {
      if ((this.jdField_a_of_type_Aypy != null) && (localayql == this.jdField_a_of_type_Ayql) && (str.equals(this.jdField_a_of_type_Ayql.a))) {
        this.jdField_a_of_type_Aypy.a(localList, 1);
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