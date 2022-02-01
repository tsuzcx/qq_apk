import com.tencent.biz.pubaccount.Advertisement.view.VideoCoverView.5;
import com.tencent.biz.pubaccount.Advertisement.view.VideoCoverView.5.1.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;
import mqq.os.MqqHandler;

public class nyu
  implements TVK_SDKMgr.InstallListener
{
  public nyu(VideoCoverView.5 param5) {}
  
  public void onInstallProgress(float paramFloat) {}
  
  public void onInstalledFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoCoverView", 2, "installSDK onInstalledFailed arg0=" + paramInt);
    }
    this.a.this$0.b = false;
  }
  
  public void onInstalledSuccessed()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoCoverView", 2, "installSDK onInstalledSuccessed");
    }
    this.a.this$0.b = true;
    ThreadManager.getUIHandler().post(new VideoCoverView.5.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nyu
 * JD-Core Version:    0.7.0.1
 */