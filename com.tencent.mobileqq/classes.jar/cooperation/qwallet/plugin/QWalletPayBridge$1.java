package cooperation.qwallet.plugin;

import android.app.Activity;
import com.tencent.common.app.AppInterface;
import sgj;

final class QWalletPayBridge$1
  implements Runnable
{
  QWalletPayBridge$1(AppInterface paramAppInterface, Activity paramActivity) {}
  
  public void run()
  {
    try
    {
      if ((this.val$appInterface.isLogin()) && (!sgj.a(this.val$appInterface, "2711679534"))) {
        sgj.a(this.val$appInterface, this.val$activity, "2711679534", null, false, 6);
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
 * Qualified Name:     cooperation.qwallet.plugin.QWalletPayBridge.1
 * JD-Core Version:    0.7.0.1
 */