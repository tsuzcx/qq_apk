package cooperation.qwallet.plugin;

import android.app.Activity;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.qroute.QRoute;

final class QWalletPayBridge$1
  implements Runnable
{
  QWalletPayBridge$1(AppInterface paramAppInterface, Activity paramActivity) {}
  
  public void run()
  {
    try
    {
      if ((this.val$appInterface.isLogin()) && (!((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isFollowUin(this.val$appInterface, "2711679534")))
      {
        ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).followUin(this.val$appInterface, this.val$activity, "2711679534", null, false, 6);
        QWalletTools.a(QWalletTools.a(), "wallet", "wallet.pubacc.follow");
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qwallet.plugin.QWalletPayBridge.1
 * JD-Core Version:    0.7.0.1
 */