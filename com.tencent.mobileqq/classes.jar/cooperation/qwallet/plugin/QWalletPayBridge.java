package cooperation.qwallet.plugin;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public abstract class QWalletPayBridge
{
  public static final String TAG = "Q.qwallet.pay.QWalletPayBridge";
  
  public static boolean launchBackground(Context paramContext, AppInterface paramAppInterface, Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.putInt("launch_type", 1);
    }
    return launchPlugin(paramContext, paramAppInterface, paramBundle);
  }
  
  public static boolean launchForeground(Activity paramActivity, AppInterface paramAppInterface, Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.putInt("launch_type", 0);
    }
    return launchPlugin(paramActivity, paramAppInterface, paramBundle);
  }
  
  private static boolean launchPlugin(Context paramContext, AppInterface paramAppInterface, Bundle paramBundle)
  {
    if ((paramContext == null) || (paramBundle == null) || (paramAppInterface == null)) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.pay.QWalletPayBridge", 2, "launchPlugin comeFrom = " + paramBundle.getInt("comeForm"));
    }
    QWalletHelper.launchPayBridgeService(paramContext, paramAppInterface, paramBundle);
    if ((paramBundle.getInt("launch_type", 0) == 0) && ((paramContext instanceof Activity)))
    {
      paramContext = (Activity)paramContext;
      ThreadManager.getSubThreadHandler().post(new QWalletPayBridge.1(paramAppInterface, paramContext));
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qwallet.plugin.QWalletPayBridge
 * JD-Core Version:    0.7.0.1
 */