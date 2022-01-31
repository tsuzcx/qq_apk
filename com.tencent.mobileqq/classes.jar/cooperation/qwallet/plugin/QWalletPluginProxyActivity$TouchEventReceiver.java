package cooperation.qwallet.plugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import java.lang.ref.WeakReference;

public class QWalletPluginProxyActivity$TouchEventReceiver
  extends BroadcastReceiver
{
  private WeakReference<QWalletPluginProxyActivity> activityWeakReference;
  
  public QWalletPluginProxyActivity$TouchEventReceiver(QWalletPluginProxyActivity paramQWalletPluginProxyActivity)
  {
    this.activityWeakReference = new WeakReference(paramQWalletPluginProxyActivity);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = (QWalletPluginProxyActivity)this.activityWeakReference.get();
    if ((paramContext == null) || (paramIntent == null) || (paramContext.isFinishing()) || (paramContext.mIsStop)) {}
    do
    {
      String str;
      do
      {
        do
        {
          return;
          str = paramIntent.getAction();
          if (!"action_touch_event".equals(str)) {
            break;
          }
          paramIntent = (MotionEvent)paramIntent.getParcelableExtra("extra_key_event");
        } while (paramIntent == null);
        paramContext.dispatchTouchEvent(paramIntent);
        return;
      } while (!"action_key_event".equals(str));
      paramIntent = (KeyEvent)paramIntent.getParcelableExtra("extra_key_event");
    } while (paramIntent == null);
    paramContext.dispatchKeyEvent(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qwallet.plugin.QWalletPluginProxyActivity.TouchEventReceiver
 * JD-Core Version:    0.7.0.1
 */