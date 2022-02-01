package cooperation.qwallet.plugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import java.lang.ref.WeakReference;

public class QWalletPluginProxyActivity$TouchEventStartReceiver
  extends BroadcastReceiver
{
  private WeakReference<QWalletPluginProxyActivity> activityWeakReference;
  
  public QWalletPluginProxyActivity$TouchEventStartReceiver(QWalletPluginProxyActivity paramQWalletPluginProxyActivity)
  {
    this.activityWeakReference = new WeakReference(paramQWalletPluginProxyActivity);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = (QWalletPluginProxyActivity)this.activityWeakReference.get();
    if ((paramContext == null) || (paramContext.mRealActivity == null) || (paramIntent == null) || (paramContext.isFinishing()) || (paramContext.mIsStop)) {}
    for (;;)
    {
      return;
      if (((paramContext.mRealActivity instanceof BasePluginActivity)) && ("action_touch_start".equals(paramIntent.getAction()))) {
        try
        {
          paramIntent = paramIntent.getStringExtra("url");
          if (!TextUtils.isEmpty(paramIntent))
          {
            paramContext.mIsStartTouchEvent = true;
            QWalletPluginProxyActivity.openUrl((BasePluginActivity)paramContext.mRealActivity, paramIntent);
            if (paramContext.touchEventReceiver == null)
            {
              paramContext.touchEventReceiver = new QWalletPluginProxyActivity.TouchEventReceiver(paramContext);
              paramIntent = new IntentFilter();
              paramIntent.addAction("action_touch_event");
              paramContext.registerReceiver(paramContext.touchEventReceiver, paramIntent);
              return;
            }
          }
        }
        catch (Exception paramContext)
        {
          paramContext.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qwallet.plugin.QWalletPluginProxyActivity.TouchEventStartReceiver
 * JD-Core Version:    0.7.0.1
 */