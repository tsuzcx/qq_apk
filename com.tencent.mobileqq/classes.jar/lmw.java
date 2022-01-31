import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport;
import com.tencent.qphone.base.util.QLog;

public class lmw
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.intent.action.SCREEN_OFF"))
    {
      QLog.d("ReadinjoySPEventReport", 2, "receive screen off broadcast");
      ReadinjoySPEventReport.b(false);
    }
    do
    {
      return;
      if (paramIntent.getAction().equals("android.intent.action.SCREEN_ON"))
      {
        QLog.d("ReadinjoySPEventReport", 2, "receive screen on broadcast");
        ReadinjoySPEventReport.b(true);
        return;
      }
    } while (!paramIntent.getAction().equals("com.tencent.plugin.state.change"));
    int i = paramIntent.getIntExtra("key_plugin_state", -1);
    QLog.d("ReadinjoySPEventReport", 2, "ACTION_PLUGIN_STATE_CHANGE " + i);
    switch (i)
    {
    case 0: 
    default: 
      return;
    }
    ReadinjoySPEventReport.a(System.currentTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lmw
 * JD-Core Version:    0.7.0.1
 */