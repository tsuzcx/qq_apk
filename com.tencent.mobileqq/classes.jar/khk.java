import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.utils.SensorReport;
import com.tencent.beacon.event.UserAction;
import java.util.HashMap;

public final class khk
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (paramIntent.getAction() == null)) {}
    while (!SensorReport.a.equals(paramIntent.getAction())) {
      return;
    }
    paramContext = (HashMap)paramIntent.getSerializableExtra("params");
    UserAction.onUserAction(SensorReport.a, true, -1L, -1L, paramContext, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     khk
 * JD-Core Version:    0.7.0.1
 */