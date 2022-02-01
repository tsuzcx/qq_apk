import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.beacon.event.UserAction;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

final class mtr
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (paramIntent.getAction() == null)) {}
    while (!mtq.a.equals(paramIntent.getAction())) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.w("SensorReport", 1, "H264_decode");
    }
    HashMap localHashMap = (HashMap)paramIntent.getSerializableExtra("params");
    paramIntent = paramIntent.getStringExtra("key");
    paramContext = paramIntent;
    if (paramIntent == null) {
      paramContext = mtq.a;
    }
    UserAction.onUserAction(paramContext, true, -1L, -1L, localHashMap, true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mtr
 * JD-Core Version:    0.7.0.1
 */