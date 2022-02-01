package cooperation.qqfav.globalsearch;

import bclx;
import bcmk;
import bmbc;
import java.util.List;

class FavoriteSearchEngine$SearchRunnable
  implements Runnable
{
  bclx<bmbc> jdField_a_of_type_Bclx;
  bcmk jdField_a_of_type_Bcmk;
  
  private FavoriteSearchEngine$SearchRunnable(FavoriteSearchEngine paramFavoriteSearchEngine) {}
  
  public void run()
  {
    bcmk localbcmk = this.jdField_a_of_type_Bcmk;
    String str = this.jdField_a_of_type_Bcmk.a;
    List localList = this.this$0.a(localbcmk);
    try
    {
      if ((this.jdField_a_of_type_Bclx != null) && (localbcmk == this.jdField_a_of_type_Bcmk) && (str.equals(this.jdField_a_of_type_Bcmk.a))) {
        this.jdField_a_of_type_Bclx.a(localList, 1);
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