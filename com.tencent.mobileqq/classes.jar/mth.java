import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.beacon.event.UserAction;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

final class mth
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (paramIntent.getAction() == null)) {}
    while (!mtg.a.equals(paramIntent.getAction())) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.w("SensorReport", 1, "H264_decode");
    }
    HashMap localHashMap = (HashMap)paramIntent.getSerializableExtra("params");
    paramIntent = paramIntent.getStringExtra("key");
    paramContext = paramIntent;
    if (paramIntent == null) {
      paramContext = mtg.a;
    }
    UserAction.onUserAction(paramContext, true, -1L, -1L, localHashMap, true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mth
 * JD-Core Version:    0.7.0.1
 */