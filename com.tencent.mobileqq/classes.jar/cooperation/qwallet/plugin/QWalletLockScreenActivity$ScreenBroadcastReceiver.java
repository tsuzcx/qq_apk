package cooperation.qwallet.plugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class QWalletLockScreenActivity$ScreenBroadcastReceiver
  extends BroadcastReceiver
{
  private String action;
  
  private QWalletLockScreenActivity$ScreenBroadcastReceiver(QWalletLockScreenActivity paramQWalletLockScreenActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    this.action = paramIntent.getAction();
    if ("android.intent.action.SCREEN_ON".equals(this.action)) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qwallet.push", 2, "QWalletLockScreenActivity ACTION_SCREEN_ON");
      }
    }
    do
    {
      do
      {
        return;
        if (!"android.intent.action.SCREEN_OFF".equals(this.action)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.qwallet.push", 2, "QWalletLockScreenActivity ACTION_SCREEN_OFF");
      return;
    } while ((!"android.intent.action.USER_PRESENT".equals(this.action)) || (!QLog.isColorLevel()));
    QLog.d("Q.qwallet.push", 2, "QWalletLockScreenActivity ACTION_USER_PRESENT");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qwallet.plugin.QWalletLockScreenActivity.ScreenBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */