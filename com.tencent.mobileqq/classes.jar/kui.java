import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementVideoPreloadManager;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;

public class kui
  implements Runnable
{
  public kui(AdvertisementVideoPreloadManager paramAdvertisementVideoPreloadManager) {}
  
  public void run()
  {
    try
    {
      TVK_SDKMgr.installPlugin(AdvertisementVideoPreloadManager.a(this.a), new kuj(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      AdvertisementVideoPreloadManager.c("installSDK t==" + localThrowable.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kui
 * JD-Core Version:    0.7.0.1
 */