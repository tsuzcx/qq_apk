import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyArticleBottomVideoView;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyArticleBottomVideoView.WeakReferenceRunnable;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;

public class ogg
  implements TVK_SDKMgr.InstallListener
{
  public ogg(ReadInJoyArticleBottomVideoView paramReadInJoyArticleBottomVideoView) {}
  
  public void onInstallProgress(float paramFloat)
  {
    aanp.a("ReadInJoyArticleBottomVideoView", "installSDK onInstallProgress arg0=");
  }
  
  public void onInstalledFailed(int paramInt)
  {
    aanp.a("ReadInJoyArticleBottomVideoView", "installSDK onInstalledFailed arg0=");
  }
  
  public void onInstalledSuccessed()
  {
    aanp.a("ReadInJoyArticleBottomVideoView", "installSDK onInstalledSuccessed");
    if ((ReadInJoyArticleBottomVideoView.b()) && (ReadInJoyArticleBottomVideoView.a(this.a) != null)) {
      ReadInJoyArticleBottomVideoView.a(this.a).post(new ReadInJoyArticleBottomVideoView.WeakReferenceRunnable(this.a, 4));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ogg
 * JD-Core Version:    0.7.0.1
 */