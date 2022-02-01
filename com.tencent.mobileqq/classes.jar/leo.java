import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class leo
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      return;
      paramContext = paramIntent.getAction();
      if (paramContext.equals("android.intent.action.SCREEN_ON"))
      {
        QLog.d("GScreenActionMonitor", 1, "avideo ACTION_SCREEN_ON");
        return;
      }
      if (paramContext.equals("android.intent.action.SCREEN_OFF"))
      {
        QLog.d("GScreenActionMonitor", 1, "avideo ACTION_SCREEN_OFF");
        lii.a(19, 1L);
        return;
      }
      if (paramContext.equals("android.intent.action.USER_PRESENT"))
      {
        QLog.d("GScreenActionMonitor", 1, "avideACTION_USER_PRESENT");
        lii.a(19, 2L);
        return;
      }
    } while (!paramContext.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
    paramContext = paramIntent.getStringExtra("reason");
    QLog.d("GScreenActionMonitor", 1, "avideo ACTION_CLOSE_SYSTEM_DIALOGS, reason[" + paramContext + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     leo
 * JD-Core Version:    0.7.0.1
 */