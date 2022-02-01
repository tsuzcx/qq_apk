import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPluginInstall.SDKInstallListener.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class sps
  implements stt
{
  private Handler a;
  
  public sps(Handler paramHandler)
  {
    this.a = paramHandler;
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    ThreadManager.excute(new VideoPluginInstall.SDKInstallListener.1(this, paramBoolean, paramInt), 16, null, true);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "onInstalledSuccessed: ");
    }
    a(true, 0);
    if (this.a != null) {
      this.a.sendEmptyMessage(0);
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "onInstalledFailed: code=" + paramInt);
    }
    a(false, paramInt);
    if (this.a != null) {
      this.a.sendEmptyMessage(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sps
 * JD-Core Version:    0.7.0.1
 */