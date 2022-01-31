import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.QavInOutAnimation;
import com.tencent.av.ui.VideoInviteLock;
import com.tencent.av.utils.PhoneStatusTools;
import com.tencent.av.utils.TraeHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class kbu
  extends BroadcastReceiver
{
  public kbu(VideoInviteLock paramVideoInviteLock) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS"))
    {
      paramContext = paramIntent.getStringExtra("reason");
      if ((paramContext != null) && (paramContext.equals("homekey")))
      {
        this.a.jdField_a_of_type_ComTencentAvVideoController.a(this.a.jdField_c_of_type_JavaLangString, 1, false);
        this.a.jdField_a_of_type_ComTencentAvVideoController.a(this.a.jdField_c_of_type_JavaLangString, 0);
        this.a.jdField_a_of_type_ComTencentAvVideoController.b(253);
        this.a.jdField_a_of_type_ComTencentAvVideoController.c(this.a.jdField_c_of_type_JavaLangString, 1);
        this.a.finish();
        if (!this.a.b) {
          break label168;
        }
        ReportController.b(null, "CliOper", "", "", "0X80041FF", "0X80041FF", 0, 0, Integer.toString(this.a.jdField_c_of_type_Int), Integer.toString(this.a.jdField_h_of_type_Int), Integer.toString(this.a.i), "");
      }
    }
    label168:
    do
    {
      do
      {
        return;
        ReportController.b(null, "CliOper", "", "", "0X8004203", "0X8004203", 0, 0, Integer.toString(this.a.jdField_c_of_type_Int), Integer.toString(this.a.jdField_h_of_type_Int), Integer.toString(this.a.i), "");
        return;
        if (!paramContext.equals("tencent.notify.cancel.videorequest")) {
          break;
        }
        paramContext = paramIntent.getStringExtra("selfUin");
        paramIntent = paramIntent.getStringExtra("sendUin");
        if (QLog.isColorLevel()) {
          QLog.d(VideoInviteLock.g, 2, "recv cancel video request");
        }
      } while ((this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin() != null) && ((!this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin().equals(paramContext)) || (!paramIntent.equals(this.a.jdField_c_of_type_JavaLangString))));
      if (this.a.jdField_a_of_type_ComTencentAvUiQavInOutAnimation != null)
      {
        this.a.jdField_a_of_type_ComTencentAvUiQavInOutAnimation.a(new kbv(this));
        return;
      }
      VideoInviteLock.c(this.a);
      return;
      if (paramContext.equals("android.intent.action.SCREEN_OFF"))
      {
        if (QLog.isColorLevel()) {
          QLog.d(VideoInviteLock.g, 2, "ACTION_SCREEN_OFF");
        }
        if (this.a.jdField_a_of_type_ComTencentAvVideoController != null)
        {
          this.a.jdField_a_of_type_ComTencentAvVideoController.a("backgroundReason", "4");
          com.tencent.av.VideoConstants.ProcessInfo.a = "4";
        }
        if (PhoneStatusTools.b(this.a))
        {
          if (TraeHelper.a() != null) {
            TraeHelper.a().a("VideoInviteLock.ACTION_SCREEN_OFF");
          }
          if ((this.a.jdField_a_of_type_ComTencentAvVideoController != null) && (TraeHelper.a() != null) && (!this.a.jdField_a_of_type_ComTencentAvVideoController.e)) {
            TraeHelper.a().b();
          }
        }
        TraeHelper.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, false);
        if (this.a.b)
        {
          ReportController.b(null, "CliOper", "", "", "0X8004208", "0X8004208", 0, 0, Integer.toString(this.a.jdField_c_of_type_Int), Integer.toString(this.a.jdField_h_of_type_Int), Integer.toString(this.a.i), "");
          return;
        }
        ReportController.b(null, "CliOper", "", "", "0X8004209", "0X8004209", 0, 0, Integer.toString(this.a.jdField_c_of_type_Int), Integer.toString(this.a.jdField_h_of_type_Int), Integer.toString(this.a.i), "");
        return;
      }
    } while (!paramContext.equals("android.intent.action.SCREEN_ON"));
    if (QLog.isColorLevel()) {
      QLog.d(VideoInviteLock.g, 2, "ACTION_SCREEN_ON");
    }
    if ((this.a.b) && (!this.a.jdField_h_of_type_Boolean)) {
      TraeHelper.a().a("DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
    }
    for (;;)
    {
      VideoInviteLock.a(this.a, "VideoInviteLock.onReceive");
      return;
      TraeHelper.a().a("DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kbu
 * JD-Core Version:    0.7.0.1
 */