import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.tencent.av.smallscreen.SmallScreenService;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class loo
  extends BroadcastReceiver
{
  public loo(SmallScreenService paramSmallScreenService) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    long l = AudioHelper.b();
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.w("SmallScreenService", 1, "onReceive, action[" + paramContext + "], seq[" + l + "]");
    }
    if (paramContext.equals("android.intent.action.NEW_OUTGOING_CALL"))
    {
      paramContext = paramIntent.getStringExtra("android.intent.extra.PHONE_NUMBER");
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenService", 2, "onReceive NEW_OUTGOING_CALL phoneNumber = " + paramContext);
      }
    }
    while ((!paramContext.equals("tencent.video.q2v.ACTION_SELECT_MEMBER_ACTIVITY_IS_RESUME_CHANGED")) || (this.a.a == null)) {
      return;
    }
    this.a.a().removeCallbacks(this.a.a);
    this.a.a.a = l;
    this.a.a().postDelayed(this.a.a, 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     loo
 * JD-Core Version:    0.7.0.1
 */