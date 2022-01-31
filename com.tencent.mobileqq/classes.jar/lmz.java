import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport;
import com.tencent.qphone.base.util.QLog;

public class lmz
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.intent.action.SCREEN_OFF"))
    {
      QLog.d("ReadinjoySPEventReport", 2, "receive screen off broadcast");
      ReadinjoySPEventReport.b(false);
    }
    while (!paramIntent.getAction().equals("android.intent.action.SCREEN_ON")) {
      return;
    }
    QLog.d("ReadinjoySPEventReport", 2, "receive screen on broadcast");
    ReadinjoySPEventReport.b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lmz
 * JD-Core Version:    0.7.0.1
 */