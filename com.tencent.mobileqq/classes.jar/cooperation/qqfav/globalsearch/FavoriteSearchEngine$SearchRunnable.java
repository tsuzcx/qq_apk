package cooperation.qqfav.globalsearch;

import bcmd;
import bcmq;
import bmln;
import java.util.List;

class FavoriteSearchEngine$SearchRunnable
  implements Runnable
{
  bcmd<bmln> jdField_a_of_type_Bcmd;
  bcmq jdField_a_of_type_Bcmq;
  
  private FavoriteSearchEngine$SearchRunnable(FavoriteSearchEngine paramFavoriteSearchEngine) {}
  
  public void run()
  {
    bcmq localbcmq = this.jdField_a_of_type_Bcmq;
    String str = this.jdField_a_of_type_Bcmq.a;
    List localList = this.this$0.a(localbcmq);
    try
    {
      if ((this.jdField_a_of_type_Bcmd != null) && (localbcmq == this.jdField_a_of_type_Bcmq) && (str.equals(this.jdField_a_of_type_Bcmq.a))) {
        this.jdField_a_of_type_Bcmd.a(localList, 1);
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