package cooperation.qwallet.plugin;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public abstract class QWalletPayBridge
{
  public static boolean getWalletDataByService(Context paramContext, AppInterface paramAppInterface, Bundle paramBundle)
  {
    if ((paramContext == null) || (paramBundle == null)) {}
    do
    {
      return false;
      if (paramAppInterface != null) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.e("Q.qwallet.pay", 2, "getWalletDataByService appInterface == null :" + TimeFormatterUtils.a(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss SSS"));
    return false;
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.qwallet.pay", 2, "" + System.currentTimeMillis() + " getWalletDataByService PayPlugin");
    }
    QWalletHelper.launchPayBridgeService(paramContext, paramAppInterface, paramBundle);
    return true;
  }
  
  public static boolean launchService(Activity paramActivity, AppInterface paramAppInterface, Bundle paramBundle)
  {
    return launchService(paramActivity, paramAppInterface, paramBundle, null);
  }
  
  public static boolean launchService(Activity paramActivity, AppInterface paramAppInterface, Bundle paramBundle, Dialog paramDialog)
  {
    if ((paramActivity == null) || (paramBundle == null)) {}
    do
    {
      return false;
      if (paramAppInterface != null) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.e("Q.qwallet.pay", 2, "launchService appInterface == null :" + TimeFormatterUtils.a(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss SSS"));
    return false;
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.qwallet.pay", 2, "" + System.currentTimeMillis() + " Launch PayPlugin");
    }
    QWalletHelper.launchPayBridgeAct(paramActivity, paramAppInterface, paramBundle, paramDialog, 0L);
    ThreadManager.getSubThreadHandler().post(new QWalletPayBridge.1(paramAppInterface, paramActivity));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qwallet.plugin.QWalletPayBridge
 * JD-Core Version:    0.7.0.1
 */