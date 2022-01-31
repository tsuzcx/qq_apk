import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import com.tencent.av.VideoController;
import com.tencent.av.app.GKillProcessMonitor;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;

public class jer
  extends BroadcastReceiver
{
  public jer(GKillProcessMonitor paramGKillProcessMonitor) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && ("com.tencent.process.exit".equals(paramIntent.getAction())))
    {
      paramContext = paramIntent.getExtras().getStringArrayList("procNameList");
      paramIntent = paramIntent.getExtras().getString("verify");
      if ((GKillProcessMonitor.a(this.a, paramIntent, paramContext)) && (GKillProcessMonitor.a(this.a, paramContext)))
      {
        paramContext = GKillProcessMonitor.a(this.a).a();
        if ((paramContext == null) || (paramContext.a().a()))
        {
          if (paramContext != null) {
            paramContext.L();
          }
          QLog.d("GKillProcessMonitor", 1, "qqExitBroadcastReceiver");
          Process.killProcess(Process.myPid());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jer
 * JD-Core Version:    0.7.0.1
 */