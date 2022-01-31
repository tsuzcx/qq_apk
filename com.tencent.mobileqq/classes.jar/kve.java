import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;
import mqq.os.MqqHandler;

class kve
  implements TVK_SDKMgr.InstallListener
{
  kve(kvd paramkvd) {}
  
  public void onInstallProgress(float paramFloat) {}
  
  public void onInstalledFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoCoverView", 2, "installSDK onInstalledFailed arg0=" + paramInt);
    }
    this.a.a.b = false;
  }
  
  public void onInstalledSuccessed()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoCoverView", 2, "installSDK onInstalledSuccessed");
    }
    this.a.a.b = true;
    ThreadManager.getUIHandler().post(new kvf(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kve
 * JD-Core Version:    0.7.0.1
 */