import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.webview.WebViewTitleStyleHelper;

public class tfj
  implements Runnable
{
  public tfj(QQBrowserActivity paramQQBrowserActivity) {}
  
  public void run()
  {
    WebViewTitleStyleHelper.a().a(BaseApplicationImpl.sApplication.waitAppRuntime(null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tfj
 * JD-Core Version:    0.7.0.1
 */