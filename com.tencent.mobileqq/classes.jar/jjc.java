import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.GaInviteLockActivity;
import com.tencent.av.ui.QavInOutAnimation;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class jjc
  extends BroadcastReceiver
{
  public jjc(GaInviteLockActivity paramGaInviteLockActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS"))
    {
      paramContext = paramIntent.getStringExtra("reason");
      if ((paramContext != null) && (paramContext.equals("homekey")))
      {
        ReportController.b(null, "CliOper", "", "", "0X8004210", "0X8004210", 0, 0, "", "", "", "");
        this.a.g();
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (!paramContext.equals("tencent.notify.cancel.videorequest")) {
            break;
          }
          paramContext = paramIntent.getStringExtra("selfUin");
          paramIntent = paramIntent.getStringExtra("sendUin");
          if (QLog.isColorLevel()) {
            QLog.d(this.a.jdField_b_of_type_JavaLangString, 2, "recv cancel audio request");
          }
        } while ((this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin() != null) && ((!this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin().equals(paramContext)) || (!paramIntent.equals(Long.valueOf(this.a.jdField_b_of_type_Long)))));
        if (this.a.jdField_a_of_type_ComTencentAvUiQavInOutAnimation != null)
        {
          this.a.jdField_a_of_type_ComTencentAvUiQavInOutAnimation.a(new jjd(this));
          return;
        }
        GaInviteLockActivity.b(this.a);
        return;
      } while (!paramContext.equals("android.intent.action.SCREEN_OFF"));
      ReportController.b(null, "CliOper", "", "", "0X800420C", "0X800420C", 0, 0, "", "", "", "");
    } while (!QLog.isColorLevel());
    QLog.d(this.a.jdField_b_of_type_JavaLangString, 2, "ACTION_SCREEN_OFF");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jjc
 * JD-Core Version:    0.7.0.1
 */