import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.qphone.base.util.QLog;

public class paq
  implements Runnable
{
  public paq(AbsBaseWebViewActivity paramAbsBaseWebViewActivity, boolean paramBoolean) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewBase", 2, "start request: " + this.jdField_a_of_type_Boolean);
    }
    WebProcessManager.a(true);
    SwiftWebViewUtils.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     paq
 * JD-Core Version:    0.7.0.1
 */