import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementVideoPreloadManager;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;

class kuy
  implements TVK_SDKMgr.InstallListener
{
  kuy(kux paramkux) {}
  
  public void onInstallProgress(float paramFloat) {}
  
  public void onInstalledFailed(int paramInt)
  {
    AdvertisementVideoPreloadManager.c("installSDK onInstalledFailed arg0=" + paramInt);
  }
  
  public void onInstalledSuccessed()
  {
    AdvertisementVideoPreloadManager.c("installSDK onInstalledSuccessed");
    AdvertisementVideoPreloadManager.a(this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kuy
 * JD-Core Version:    0.7.0.1
 */