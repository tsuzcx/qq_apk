import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.app.GBatteryMonitor;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.report.VideoNodeManager;
import com.tencent.av.business.manager.report.VideoNodeReporter;

public class jfe
  extends BroadcastReceiver
{
  public jfe(GBatteryMonitor paramGBatteryMonitor) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("level", 0);
    if ((GBatteryMonitor.a(this.a) != null) && (GBatteryMonitor.a(this.a).a != null))
    {
      ((VideoNodeReporter)GBatteryMonitor.a(this.a).a(4)).a(i);
      VideoNodeManager.a(18, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jfe
 * JD-Core Version:    0.7.0.1
 */