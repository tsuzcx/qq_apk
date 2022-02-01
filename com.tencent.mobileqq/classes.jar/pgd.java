import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class pgd
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
        pfs.e(false);
        return;
      }
      if (paramIntent.getAction().equals("android.intent.action.SCREEN_ON"))
      {
        QLog.d("ReadinjoySPEventReport", 2, "receive screen on broadcast");
        pfs.e(true);
        return;
      }
      if ("mqq.intent.action.QQ_FOREGROUND".equals(paramIntent.getAction()))
      {
        pfs.c(false);
        pfs.o();
        return;
      }
    } while (!"mqq.intent.action.QQ_BACKGROUND".equals(paramIntent.getAction()));
    pfs.d(false);
    pfs.o();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pgd
 * JD-Core Version:    0.7.0.1
 */