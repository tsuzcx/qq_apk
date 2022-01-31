import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementVideoPreloadManager.2;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;

public class nmd
  implements TVK_SDKMgr.InstallListener
{
  public nmd(AdvertisementVideoPreloadManager.2 param2) {}
  
  public void onInstallProgress(float paramFloat) {}
  
  public void onInstalledFailed(int paramInt)
  {
    nmb.c("installSDK onInstalledFailed arg0=" + paramInt);
  }
  
  public void onInstalledSuccessed()
  {
    nmb.c("installSDK onInstalledSuccessed");
    nmb.a(this.a.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nmd
 * JD-Core Version:    0.7.0.1
 */