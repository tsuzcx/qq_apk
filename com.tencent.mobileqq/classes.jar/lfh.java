import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;

class lfh
  extends BroadcastReceiver
{
  lfh(lfg paramlfg) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && ("com.tencent.process.exit".equals(paramIntent.getAction())))
    {
      paramContext = paramIntent.getExtras().getStringArrayList("procNameList");
      paramIntent = paramIntent.getExtras().getString("verify");
      if ((lfg.a(this.a, paramIntent, paramContext)) && (lfg.a(this.a, paramContext)))
      {
        paramContext = lfg.a(this.a).a();
        if ((paramContext == null) || (paramContext.a().d()))
        {
          if (paramContext != null) {
            paramContext.B();
          }
          QLog.d("GKillProcessMonitor", 1, "qqExitBroadcastReceiver");
          Process.killProcess(Process.myPid());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lfh
 * JD-Core Version:    0.7.0.1
 */