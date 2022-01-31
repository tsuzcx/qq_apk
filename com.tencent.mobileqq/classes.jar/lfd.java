import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;

class lfd
  extends BroadcastReceiver
{
  lfd(lfc paramlfc) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && ("com.tencent.av.EXIT_VIDEO_PROCESS".equals(paramIntent.getAction())))
    {
      long l = mtm.a(paramIntent);
      QLog.w("GAudioExitMonitor", 1, "onReceive.EXIT_VIDEO_ACTION, seq[" + l + "]");
      paramContext = lfc.a(this.a).a();
      if (paramContext != null)
      {
        paramContext.a(false, 202, new int[] { paramContext.a().C });
        paramContext.b(202);
        paramContext.d(1011);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lfd
 * JD-Core Version:    0.7.0.1
 */