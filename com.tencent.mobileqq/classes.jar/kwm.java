import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.qphone.base.util.QLog;

public class kwm
  implements Runnable
{
  public kwm(CustomWebView paramCustomWebView) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CustomWebView", 2, "webview real destroy now");
    }
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kwm
 * JD-Core Version:    0.7.0.1
 */