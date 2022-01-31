import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;

class lhk
  extends BroadcastReceiver
{
  lhk(lhj paramlhj) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && ("com.tencent.process.exit".equals(paramIntent.getAction())))
    {
      paramContext = paramIntent.getExtras().getStringArrayList("procNameList");
      paramIntent = paramIntent.getExtras().getString("verify");
      if ((lhj.a(this.a, paramIntent, paramContext)) && (lhj.a(this.a, paramContext)))
      {
        paramContext = lhj.a(this.a).a();
        if ((paramContext == null) || (paramContext.a().e()))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lhk
 * JD-Core Version:    0.7.0.1
 */