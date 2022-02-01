package cooperation.qqfav.globalsearch;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.MobileQQ;

class FavoriteSearchEngine$QueryRunnable
  implements Runnable
{
  protected int a;
  protected long a;
  protected Cursor a;
  protected String a;
  protected boolean a;
  
  private FavoriteSearchEngine$QueryRunnable(FavoriteSearchEngine paramFavoriteSearchEngine) {}
  
  public void run()
  {
    Object localObject1 = FavoriteSearchEngine.a(this.this$0).getApplication().getContentResolver();
    ??? = Uri.parse("content://qq.favorites/global_search/" + FavoriteSearchEngine.a(this.this$0).getAccount());
    try
    {
      localObject1 = ((ContentResolver)localObject1).query((Uri)???, null, null, new String[] { this.jdField_a_of_type_JavaLangString, "" + this.jdField_a_of_type_Int, "" + this.jdField_a_of_type_Long, "" + this.jdField_a_of_type_Boolean }, null);
    }
    catch (Exception localException)
    {
      synchronized (FavoriteSearchEngine.a(this.this$0))
      {
        if (FavoriteSearchEngine.a(this.this$0) == Thread.currentThread())
        {
          this.jdField_a_of_type_AndroidDatabaseCursor = ((Cursor)localObject1);
          FavoriteSearchEngine.a(this.this$0).notify();
        }
        Object localObject2;
        while (localObject2 == null)
        {
          return;
          localException = localException;
          localException.printStackTrace();
          localObject2 = null;
          break;
        }
        localObject2.close();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqfav.globalsearch.FavoriteSearchEngine.QueryRunnable
 * JD-Core Version:    0.7.0.1
 */