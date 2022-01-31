package cooperation.qqfav.globalsearch;

import awut;
import awvg;
import bgqc;
import java.util.List;

class FavoriteSearchEngine$SearchRunnable
  implements Runnable
{
  awut<bgqc> jdField_a_of_type_Awut;
  awvg jdField_a_of_type_Awvg;
  
  private FavoriteSearchEngine$SearchRunnable(FavoriteSearchEngine paramFavoriteSearchEngine) {}
  
  public void run()
  {
    awvg localawvg = this.jdField_a_of_type_Awvg;
    String str = this.jdField_a_of_type_Awvg.a;
    List localList = this.this$0.a(localawvg);
    try
    {
      if ((this.jdField_a_of_type_Awut != null) && (localawvg == this.jdField_a_of_type_Awvg) && (str.equals(this.jdField_a_of_type_Awvg.a))) {
        this.jdField_a_of_type_Awut.a(localList, 1);
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