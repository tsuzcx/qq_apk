import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;

class lek
  extends BroadcastReceiver
{
  lek(lej paramlej) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && ("com.tencent.process.exit".equals(paramIntent.getAction())))
    {
      paramContext = paramIntent.getExtras().getStringArrayList("procNameList");
      paramIntent = paramIntent.getExtras().getString("verify");
      if ((lej.a(this.a, paramIntent, paramContext)) && (lej.a(this.a, paramContext)))
      {
        paramContext = lej.a(this.a).a();
        if ((paramContext == null) || (paramContext.a().f()))
        {
          if (paramContext != null) {
            paramContext.A();
          }
          QLog.d("GKillProcessMonitor", 1, "qqExitBroadcastReceiver");
          Process.killProcess(Process.myPid());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lek
 * JD-Core Version:    0.7.0.1
 */