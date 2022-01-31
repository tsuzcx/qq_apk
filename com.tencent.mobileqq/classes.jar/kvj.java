import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementStatistics;
import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementVideoPreloadManager;
import com.tencent.biz.pubaccount.persistence.entity.PAAdPreloadTask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr.IPreloadCompleteCallback;
import java.io.File;
import java.lang.ref.WeakReference;

public class kvj
  implements TVK_ICacheMgr.IPreloadCompleteCallback
{
  private kvj(AdvertisementVideoPreloadManager paramAdvertisementVideoPreloadManager) {}
  
  public void onComplete(String paramString1, String paramString2)
  {
    for (;;)
    {
      synchronized (AdvertisementVideoPreloadManager.a(this.a))
      {
        AdvertisementVideoPreloadManager.c("onPreloadComplete vid:" + paramString1 + ", detail:" + paramString2);
        paramString2 = new File(AdvertisementVideoPreloadManager.b(paramString1));
        if (paramString2.exists()) {
          paramString2.renameTo(new File(AdvertisementVideoPreloadManager.a(paramString1)));
        }
        ReportController.b(null, "dc00898", "", "", "0X8008F77", "0X8008F77", 0, 0, "", "", AdvertisementVideoPreloadManager.a(this.a).mVideoVid, String.valueOf(AdvertisementVideoPreloadManager.a(this.a).mSource));
        paramString2 = (QQAppInterface)AdvertisementVideoPreloadManager.a(this.a).get();
        if (paramString2 != null)
        {
          paramString2 = paramString2.getCurrentAccountUin();
          AdvertisementStatistics.b(paramString2, paramString1);
          AdvertisementVideoPreloadManager.a(this.a, AdvertisementVideoPreloadManager.a(this.a));
          return;
        }
      }
      paramString2 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kvj
 * JD-Core Version:    0.7.0.1
 */