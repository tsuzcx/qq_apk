import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyArticleBottomVideoView;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyArticleBottomVideoView.WeakReferenceRunnable;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;

public class ocn
  implements TVK_SDKMgr.InstallListener
{
  public ocn(ReadInJoyArticleBottomVideoView paramReadInJoyArticleBottomVideoView) {}
  
  public void onInstallProgress(float paramFloat)
  {
    yxp.a("ReadInJoyArticleBottomVideoView", "installSDK onInstallProgress arg0=");
  }
  
  public void onInstalledFailed(int paramInt)
  {
    yxp.a("ReadInJoyArticleBottomVideoView", "installSDK onInstalledFailed arg0=");
  }
  
  public void onInstalledSuccessed()
  {
    yxp.a("ReadInJoyArticleBottomVideoView", "installSDK onInstalledSuccessed");
    if ((ReadInJoyArticleBottomVideoView.b()) && (ReadInJoyArticleBottomVideoView.a(this.a) != null)) {
      ReadInJoyArticleBottomVideoView.a(this.a).post(new ReadInJoyArticleBottomVideoView.WeakReferenceRunnable(this.a, 4));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ocn
 * JD-Core Version:    0.7.0.1
 */