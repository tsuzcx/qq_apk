import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.utils.PhoneStatusMonitor.PhoneStatusReceiver.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class msg
  extends BroadcastReceiver
{
  msg(mse parammse) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext.equals("android.intent.action.NEW_OUTGOING_CALL"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhoneStatusMonitor", 2, "onReceive NEW_OUTGOING_CALL");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhoneStatusMonitor", 2, String.format("PhoneStatusReceiver, isCallingRunnable begin,  action[%s]", new Object[] { paramContext }));
    }
    ThreadManager.post(new PhoneStatusMonitor.PhoneStatusReceiver.1(this, paramContext), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     msg
 * JD-Core Version:    0.7.0.1
 */