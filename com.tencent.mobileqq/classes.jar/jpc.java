import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.tencent.av.smallscreen.SmallScreenService;
import com.tencent.qphone.base.util.QLog;

public class jpc
  extends BroadcastReceiver
{
  public jpc(SmallScreenService paramSmallScreenService) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenService", 2, "onReceive action = " + paramContext);
    }
    if (paramContext.equals("android.intent.action.NEW_OUTGOING_CALL"))
    {
      paramContext = paramIntent.getStringExtra("android.intent.extra.PHONE_NUMBER");
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenService", 2, "onReceive NEW_OUTGOING_CALL phoneNumber = " + paramContext);
      }
    }
    while (!paramContext.equals("tencent.video.q2v.ACTION_SELECT_MEMBER_ACTIVITY_IS_RESUME_CHANGED")) {
      return;
    }
    this.a.a().removeCallbacks(this.a.d);
    this.a.a().postDelayed(this.a.d, 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jpc
 * JD-Core Version:    0.7.0.1
 */