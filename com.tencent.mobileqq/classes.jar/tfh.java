import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.qphone.base.util.QLog;

public class tfh
  implements Runnable
{
  public tfh(QQBrowserActivity paramQQBrowserActivity) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_QQBrowserActivity", 2, "start request: " + WebAccelerateHelper.isWebViewCache);
    }
    WebProcessManager.a(true);
    SwiftWebViewUtils.a();
    SwiftWebViewUtils.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tfh
 * JD-Core Version:    0.7.0.1
 */