import com.tencent.biz.pubaccount.PublicAccountBrowser.PublicAccountBrowserFragment;
import com.tencent.biz.pubaccount.subscript.SubscriptRecommendController;
import com.tencent.qphone.base.util.QLog;

class kxt
  implements Runnable
{
  kxt(kxs paramkxs) {}
  
  public void run()
  {
    try
    {
      boolean bool = SubscriptRecommendController.a(this.a.a.a, false, this.a.a.g);
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
 * Qualified Name:     kxt
 * JD-Core Version:    0.7.0.1
 */