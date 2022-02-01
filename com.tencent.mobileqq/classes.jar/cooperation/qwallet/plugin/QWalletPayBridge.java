package cooperation.qwallet.plugin;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.qwallet.temp.IQWalletApiProxy;
import com.tencent.mobileqq.qroute.QRoute;

public abstract class QWalletPayBridge
{
  public static final String TAG = "Q.qwallet.pay.QWalletPayBridge";
  
  public static boolean launchBackground(Context paramContext, Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.putInt("launch_type", 1);
    }
    return ((IQWalletApiProxy)QRoute.api(IQWalletApiProxy.class)).launchPlugin(paramContext, paramBundle);
  }
  
  public static boolean launchForeground(Activity paramActivity, Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.putInt("launch_type", 0);
    }
    return ((IQWalletApiProxy)QRoute.api(IQWalletApiProxy.class)).launchPlugin(paramActivity, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qwallet.plugin.QWalletPayBridge
 * JD-Core Version:    0.7.0.1
 */