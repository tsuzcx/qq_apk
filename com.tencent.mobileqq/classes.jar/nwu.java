import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementVideoPreloadManager.2;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;

public class nwu
  implements TVK_SDKMgr.InstallListener
{
  public nwu(AdvertisementVideoPreloadManager.2 param2) {}
  
  public void onInstallProgress(float paramFloat) {}
  
  public void onInstalledFailed(int paramInt)
  {
    nws.c("installSDK onInstalledFailed arg0=" + paramInt);
  }
  
  public void onInstalledSuccessed()
  {
    nws.c("installSDK onInstalledSuccessed");
    nws.a(this.a.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nwu
 * JD-Core Version:    0.7.0.1
 */