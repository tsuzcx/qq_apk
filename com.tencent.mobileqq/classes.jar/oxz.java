import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class oxz
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      return;
      if (paramIntent.getAction().equals("android.intent.action.SCREEN_OFF"))
      {
        QLog.d("ReadinjoySPEventReport", 2, "receive screen off broadcast");
        oxp.e(false);
        return;
      }
      if (paramIntent.getAction().equals("android.intent.action.SCREEN_ON"))
      {
        QLog.d("ReadinjoySPEventReport", 2, "receive screen on broadcast");
        oxp.e(true);
        return;
      }
      if ("mqq.intent.action.QQ_FOREGROUND".equals(paramIntent.getAction()))
      {
        oxp.c(false);
        oxp.o();
        return;
      }
    } while (!"mqq.intent.action.QQ_BACKGROUND".equals(paramIntent.getAction()));
    oxp.d(false);
    oxp.o();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     oxz
 * JD-Core Version:    0.7.0.1
 */