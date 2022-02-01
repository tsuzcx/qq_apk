import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementVideoPreloadManager.2;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;

public class off
  implements TVK_SDKMgr.InstallListener
{
  public off(AdvertisementVideoPreloadManager.2 param2) {}
  
  public void onInstallProgress(float paramFloat) {}
  
  public void onInstalledFailed(int paramInt)
  {
    ofd.c("installSDK onInstalledFailed arg0=" + paramInt);
  }
  
  public void onInstalledSuccessed()
  {
    ofd.c("installSDK onInstalledSuccessed");
    ofd.a(this.a.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     off
 * JD-Core Version:    0.7.0.1
 */