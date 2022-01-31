import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.gamecenter.appointment.GameCenterBroadcastReceiver;
import com.tencent.gamecenter.appointment.GameCenterCheck;
import com.tencent.open.wadl.WLog;
import com.tencent.qphone.base.util.QLog;

public final class qnw
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext == null) {}
    do
    {
      do
      {
        return;
        if ("android.intent.action.SCREEN_OFF".equals(paramContext))
        {
          if (QLog.isColorLevel()) {
            WLog.b("GameCenterBroadcastReceiver", "mScreenOff = true");
          }
          GameCenterCheck.b();
          return;
        }
      } while (!"android.intent.action.BATTERY_CHANGED".equals(paramContext));
      GameCenterBroadcastReceiver.a = paramIntent.getIntExtra("level", 0) * 100 / paramIntent.getIntExtra("scale", 100);
    } while (!QLog.isColorLevel());
    WLog.b("GameCenterBroadcastReceiver", "battery cap= " + GameCenterBroadcastReceiver.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     qnw
 * JD-Core Version:    0.7.0.1
 */