import android.os.Handler;
import android.os.SystemClock;
import com.tencent.biz.qqstory.playvideo.TVKPreloader;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr.IPreloadCompleteCallback;

public final class nmw
  implements TVK_ICacheMgr.IPreloadCompleteCallback
{
  public void onComplete(String arg1, String paramString2)
  {
    SLog.b("Q.qqstory.player.TVKPreloader", "preloadVideo onComplete, %s", paramString2);
    synchronized (TVKPreloader.a())
    {
      SLog.b("Q.qqstory.player.TVKPreloader", "preloadVideo onComplete, preloadItem = %s, downloadString = %s,  cost %d ms", TVKPreloader.a(), paramString2, Long.valueOf(SystemClock.uptimeMillis() - TVKPreloader.a()));
      paramString2 = TVKPreloader.a();
      TVKPreloader.a().post(new nmx(this, paramString2));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nmw
 * JD-Core Version:    0.7.0.1
 */