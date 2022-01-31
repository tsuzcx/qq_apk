import com.tencent.biz.pubaccount.PublicAccountBrowser.PublicAccountBrowserFragment;
import com.tencent.biz.pubaccount.subscript.SubscriptRecommendController;
import com.tencent.qphone.base.util.QLog;

public class kxx
  implements Runnable
{
  public kxx(PublicAccountBrowser.PublicAccountBrowserFragment paramPublicAccountBrowserFragment) {}
  
  public void run()
  {
    try
    {
      boolean bool = SubscriptRecommendController.a(this.a.a, false, this.a.g);
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewFragment", 2, "set subscribe full recommend switch = false , result : " + bool);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kxx
 * JD-Core Version:    0.7.0.1
 */