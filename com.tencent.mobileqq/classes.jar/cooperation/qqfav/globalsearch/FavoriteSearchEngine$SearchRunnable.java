package cooperation.qqfav.globalsearch;

import bbff;
import bbfs;
import bkpu;
import java.util.List;

class FavoriteSearchEngine$SearchRunnable
  implements Runnable
{
  bbff<bkpu> jdField_a_of_type_Bbff;
  bbfs jdField_a_of_type_Bbfs;
  
  private FavoriteSearchEngine$SearchRunnable(FavoriteSearchEngine paramFavoriteSearchEngine) {}
  
  public void run()
  {
    bbfs localbbfs = this.jdField_a_of_type_Bbfs;
    String str = this.jdField_a_of_type_Bbfs.a;
    List localList = this.this$0.a(localbbfs);
    try
    {
      if ((this.jdField_a_of_type_Bbff != null) && (localbbfs == this.jdField_a_of_type_Bbfs) && (str.equals(this.jdField_a_of_type_Bbfs.a))) {
        this.jdField_a_of_type_Bbff.a(localList, 1);
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqfav.globalsearch.FavoriteSearchEngine.SearchRunnable
 * JD-Core Version:    0.7.0.1
 */