import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.qphone.base.util.QLog;

public class rnv
  extends BroadcastReceiver
{
  public rnv(BaseChatPie paramBaseChatPie) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("tencent.av.v2q.StartVideoChat".equals(paramContext))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "receive action_recv_video_request");
      }
      this.a.f(2);
    }
    do
    {
      return;
      if ("android.intent.action.PHONE_STATE".equals(paramContext))
      {
        paramContext = (TelephonyManager)this.a.jdField_a_of_type_AndroidContentContext.getSystemService("phone");
        if (paramContext.getCallState() == 1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.aio.BaseChatPie", 2, "receive action_phone_state_changed|call_state_ringing");
          }
          this.a.f(2);
        }
        if (paramContext.getCallState() == 1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.aio.BaseChatPie", 2, "receive action_phone_state_changed|call_state_ringing");
          }
          paramIntent = MediaPlayerManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          if (paramIntent.b()) {
            paramIntent.a(false);
          }
        }
        this.a.a(paramContext.getCallState());
        return;
      }
    } while ((BaseChatPie.h() != 1) || (!"vivo_smart_shot_enter".equals(paramContext)));
    if (QLog.isColorLevel()) {
      QLog.d("vivo", 2, "receive action_vivo_smart_shot_enter");
    }
    BaseChatPie.a(this.a, Boolean.valueOf(false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rnv
 * JD-Core Version:    0.7.0.1
 */