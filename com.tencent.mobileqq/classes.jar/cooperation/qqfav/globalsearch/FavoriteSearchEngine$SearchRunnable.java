package cooperation.qqfav.globalsearch;

import awuv;
import awvi;
import bgqt;
import java.util.List;

class FavoriteSearchEngine$SearchRunnable
  implements Runnable
{
  awuv<bgqt> jdField_a_of_type_Awuv;
  awvi jdField_a_of_type_Awvi;
  
  private FavoriteSearchEngine$SearchRunnable(FavoriteSearchEngine paramFavoriteSearchEngine) {}
  
  public void run()
  {
    awvi localawvi = this.jdField_a_of_type_Awvi;
    String str = this.jdField_a_of_type_Awvi.a;
    List localList = this.this$0.a(localawvi);
    try
    {
      if ((this.jdField_a_of_type_Awuv != null) && (localawvi == this.jdField_a_of_type_Awvi) && (str.equals(this.jdField_a_of_type_Awvi.a))) {
        this.jdField_a_of_type_Awuv.a(localList, 1);
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qqfav.globalsearch.FavoriteSearchEngine.SearchRunnable
 * JD-Core Version:    0.7.0.1
 */