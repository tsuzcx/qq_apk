import android.os.Handler;
import android.os.SystemClock;
import com.tencent.biz.qqstory.playvideo.TVKPreloader;
import com.tencent.biz.qqstory.playvideo.TVKPreloader.PreloadItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr.IPreloadCallback;

public final class nol
  implements TVK_ICacheMgr.IPreloadCallback
{
  public void onPreLoadFailed(String paramString1, int paramInt, String paramString2)
  {
    synchronized ()
    {
      SLog.d("Q.qqstory.player.TVKPreloader", "preloadVideo onPreLoadFailed, preloadItem = %s, s = %s, s1 = %s, cost %d ms", new Object[] { TVKPreloader.a(), paramString1, paramString2, Long.valueOf(SystemClock.uptimeMillis() - TVKPreloader.a()) });
      TVKPreloader.PreloadItem localPreloadItem = TVKPreloader.a();
      TVKPreloader.a().post(new non(this, localPreloadItem, paramString1, paramInt, paramString2));
      return;
    }
  }
  
  public void onPreLoadSucess(String paramString1, String paramString2)
  {
    synchronized ()
    {
      SLog.b("Q.qqstory.player.TVKPreloader", "preloadVideo onPreLoadSuccess, preloadItem = %s, s = %s, s1 = %s,  cost %d ms", TVKPreloader.a(), paramString1, paramString2, Long.valueOf(SystemClock.uptimeMillis() - TVKPreloader.a()));
      paramString1 = TVKPreloader.a();
      TVKPreloader.a().post(new nom(this, paramString1));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nol
 * JD-Core Version:    0.7.0.1
 */