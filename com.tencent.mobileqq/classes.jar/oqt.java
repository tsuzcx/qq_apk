import com.tencent.biz.qrcode.activity.LoginManagerActivity;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;

public class oqt
  extends DownloadListener
{
  public oqt(LoginManagerActivity paramLoginManagerActivity) {}
  
  public void onCancel(DownloadTask paramDownloadTask)
  {
    LoginManagerActivity.a(this.a, null);
    if (QLog.isColorLevel()) {
      QLog.d("LoginManagerActivity", 2, "downloadTimZipFile cancel");
    }
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    LoginManagerActivity.a(this.a, null);
    if (QLog.isColorLevel()) {
      QLog.d("LoginManagerActivity", 2, "downloadTimZipFile onDone status: " + paramDownloadTask.a() + ", errMsg :" + paramDownloadTask.b + " code :" + paramDownloadTask.a);
    }
    if (paramDownloadTask.a() == 3) {
      this.a.runOnUiThread(new oqu(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oqt
 * JD-Core Version:    0.7.0.1
 */