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
    ??? = new StringBuilder();
    ((StringBuilder)???).append("content://qq.favorites/global_search/");
    ((StringBuilder)???).append(FavoriteSearchEngine.a(this.this$0).getAccount());
    ??? = Uri.parse(((StringBuilder)???).toString());
    Object localObject2;
    try
    {
      String str = this.jdField_a_of_type_JavaLangString;
      Object localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append("");
      ((StringBuilder)localObject5).append(this.jdField_a_of_type_Int);
      localObject5 = ((StringBuilder)localObject5).toString();
      Object localObject6 = new StringBuilder();
      ((StringBuilder)localObject6).append("");
      ((StringBuilder)localObject6).append(this.jdField_a_of_type_Long);
      localObject6 = ((StringBuilder)localObject6).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      localObject1 = ((ContentResolver)localObject1).query((Uri)???, null, null, new String[] { str, localObject5, localObject6, localStringBuilder.toString() }, null);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      localObject2 = null;
    }
    synchronized (FavoriteSearchEngine.a(this.this$0))
    {
      if (FavoriteSearchEngine.a(this.this$0) == Thread.currentThread())
      {
        this.jdField_a_of_type_AndroidDatabaseCursor = localObject2;
        FavoriteSearchEngine.a(this.this$0).notify();
      }
      else if (localObject2 != null)
      {
        localObject2.close();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqfav.globalsearch.FavoriteSearchEngine.QueryRunnable
 * JD-Core Version:    0.7.0.1
 */