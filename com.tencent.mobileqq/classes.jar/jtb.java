import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.telephony.TelephonyManager;
import com.tencent.av.ui.CallbackWaitingActivity;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.qphone.base.util.QLog;

public class jtb
  extends BroadcastReceiver
{
  public jtb(CallbackWaitingActivity paramCallbackWaitingActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.intent.action.NEW_OUTGOING_CALL")) {
      return;
    }
    switch (((TelephonyManager)paramContext.getSystemService("phone")).getCallState())
    {
    default: 
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(CallbackWaitingActivity.a(), 2, "state is TelephonyManager.CALL_STATE_RINGING");
    }
    AudioUtil.a();
    CallbackWaitingActivity.a(this.a).sendEmptyMessageDelayed(10, 2000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jtb
 * JD-Core Version:    0.7.0.1
 */