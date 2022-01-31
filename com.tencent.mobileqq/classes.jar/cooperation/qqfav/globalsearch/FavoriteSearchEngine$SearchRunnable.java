package cooperation.qqfav.globalsearch;

import avva;
import avvn;
import bfik;
import java.util.List;

class FavoriteSearchEngine$SearchRunnable
  implements Runnable
{
  avva<bfik> jdField_a_of_type_Avva;
  avvn jdField_a_of_type_Avvn;
  
  private FavoriteSearchEngine$SearchRunnable(FavoriteSearchEngine paramFavoriteSearchEngine) {}
  
  public void run()
  {
    avvn localavvn = this.jdField_a_of_type_Avvn;
    String str = this.jdField_a_of_type_Avvn.a;
    List localList = this.this$0.a(localavvn);
    try
    {
      if ((this.jdField_a_of_type_Avva != null) && (localavvn == this.jdField_a_of_type_Avvn) && (str.equals(this.jdField_a_of_type_Avvn.a))) {
        this.jdField_a_of_type_Avva.a(localList, 1);
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