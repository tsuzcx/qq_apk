package cooperation.qqfav.globalsearch;

import bbtk;
import bbtx;
import blkk;
import java.util.List;

class FavoriteSearchEngine$SearchRunnable
  implements Runnable
{
  bbtk<blkk> jdField_a_of_type_Bbtk;
  bbtx jdField_a_of_type_Bbtx;
  
  private FavoriteSearchEngine$SearchRunnable(FavoriteSearchEngine paramFavoriteSearchEngine) {}
  
  public void run()
  {
    bbtx localbbtx = this.jdField_a_of_type_Bbtx;
    String str = this.jdField_a_of_type_Bbtx.a;
    List localList = this.this$0.a(localbbtx);
    try
    {
      if ((this.jdField_a_of_type_Bbtk != null) && (localbbtx == this.jdField_a_of_type_Bbtx) && (str.equals(this.jdField_a_of_type_Bbtx.a))) {
        this.jdField_a_of_type_Bbtk.a(localList, 1);
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