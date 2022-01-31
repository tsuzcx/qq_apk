import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementVideoPreloadManager.2;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;

public class njh
  implements TVK_SDKMgr.InstallListener
{
  public njh(AdvertisementVideoPreloadManager.2 param2) {}
  
  public void onInstallProgress(float paramFloat) {}
  
  public void onInstalledFailed(int paramInt)
  {
    njf.c("installSDK onInstalledFailed arg0=" + paramInt);
  }
  
  public void onInstalledSuccessed()
  {
    njf.c("installSDK onInstalledSuccessed");
    njf.a(this.a.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     njh
 * JD-Core Version:    0.7.0.1
 */