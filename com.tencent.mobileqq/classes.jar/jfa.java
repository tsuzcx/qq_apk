import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.VideoController;
import com.tencent.av.app.GAudioExitMonitor;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;

public class jfa
  extends BroadcastReceiver
{
  public jfa(GAudioExitMonitor paramGAudioExitMonitor) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && ("com.tencent.av.EXIT_VIDEO_PROCESS".equals(paramIntent.getAction())))
    {
      paramContext = GAudioExitMonitor.a(this.a).a();
      if (paramContext != null)
      {
        paramContext.a(false, 0, new int[] { paramContext.a().D });
        paramContext.b(202);
        paramContext.d(1011);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jfa
 * JD-Core Version:    0.7.0.1
 */