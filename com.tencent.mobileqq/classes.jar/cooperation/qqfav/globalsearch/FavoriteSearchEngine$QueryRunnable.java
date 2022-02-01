package cooperation.qqfav.globalsearch;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.MobileQQ;

class FavoriteSearchEngine$QueryRunnable
  implements Runnable
{
  protected String a;
  protected long b;
  protected int c;
  protected boolean d;
  protected Cursor e;
  
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
      String str = this.a;
      Object localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append("");
      ((StringBuilder)localObject5).append(this.c);
      localObject5 = ((StringBuilder)localObject5).toString();
      Object localObject6 = new StringBuilder();
      ((StringBuilder)localObject6).append("");
      ((StringBuilder)localObject6).append(this.b);
      localObject6 = ((StringBuilder)localObject6).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.d);
      localObject1 = ((ContentResolver)localObject1).query((Uri)???, null, null, new String[] { str, localObject5, localObject6, localStringBuilder.toString() }, null);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      localObject2 = null;
    }
    synchronized (FavoriteSearchEngine.b(this.this$0))
    {
      if (FavoriteSearchEngine.c(this.this$0) == Thread.currentThread())
      {
        this.e = localObject2;
        FavoriteSearchEngine.b(this.this$0).notify();
      }
      else if (localObject2 != null)
      {
        localObject2.close();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqfav.globalsearch.FavoriteSearchEngine.QueryRunnable
 * JD-Core Version:    0.7.0.1
 */