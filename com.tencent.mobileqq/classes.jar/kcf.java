import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.QavInOutAnimation;
import com.tencent.av.ui.VideoInviteFull;
import com.tencent.av.ui.VideoInviteLock;
import com.tencent.av.utils.TraeHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class kcf
  extends BroadcastReceiver
{
  private int jdField_a_of_type_Int = -1;
  
  public kcf(VideoInviteFull paramVideoInviteFull, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    switch (this.jdField_a_of_type_Int)
    {
    }
    do
    {
      do
      {
        for (;;)
        {
          return;
          if (paramIntent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS"))
          {
            paramContext = paramIntent.getStringExtra("reason");
            if (paramContext != null)
            {
              TraeHelper.a(this.jdField_a_of_type_ComTencentAvUiVideoInviteFull.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
              if (paramContext.equals("homekey"))
              {
                if (this.jdField_a_of_type_ComTencentAvUiVideoInviteFull.b) {
                  ReportController.b(null, "CliOper", "", "", "0X8004399", "0X8004399", 0, 0, Integer.toString(this.jdField_a_of_type_ComTencentAvUiVideoInviteFull.jdField_c_of_type_Int), Integer.toString(this.jdField_a_of_type_ComTencentAvUiVideoInviteFull.jdField_h_of_type_Int), Integer.toString(this.jdField_a_of_type_ComTencentAvUiVideoInviteFull.i), "");
                }
                while (this.jdField_a_of_type_ComTencentAvUiVideoInviteFull.jdField_a_of_type_ComTencentAvVideoController != null)
                {
                  this.jdField_a_of_type_ComTencentAvUiVideoInviteFull.jdField_a_of_type_ComTencentAvVideoController.a("backgroundReason", "1");
                  com.tencent.av.VideoConstants.ProcessInfo.a = "1";
                  return;
                  ReportController.b(null, "CliOper", "", "", "0X80043F8", "0X80043F8", 0, 0, Integer.toString(this.jdField_a_of_type_ComTencentAvUiVideoInviteFull.jdField_c_of_type_Int), Integer.toString(this.jdField_a_of_type_ComTencentAvUiVideoInviteFull.jdField_h_of_type_Int), Integer.toString(this.jdField_a_of_type_ComTencentAvUiVideoInviteFull.i), "");
                }
              }
            }
          }
        }
      } while (!"android.intent.action.SCREEN_OFF".equals(paramIntent.getAction()));
      if (this.jdField_a_of_type_ComTencentAvUiVideoInviteFull.jdField_a_of_type_ComTencentAvVideoController != null)
      {
        this.jdField_a_of_type_ComTencentAvUiVideoInviteFull.jdField_a_of_type_ComTencentAvVideoController.a("backgroundReason", "4");
        com.tencent.av.VideoConstants.ProcessInfo.a = "4";
      }
      this.jdField_a_of_type_ComTencentAvUiVideoInviteFull.jdField_c_of_type_Boolean = true;
      paramContext = new Intent(this.jdField_a_of_type_ComTencentAvUiVideoInviteFull, VideoInviteLock.class);
      paramContext.addFlags(268435456);
      paramContext.putExtra("uinType", this.jdField_a_of_type_ComTencentAvUiVideoInviteFull.d);
      paramContext.putExtra("peerUin", this.jdField_a_of_type_ComTencentAvUiVideoInviteFull.jdField_c_of_type_JavaLangString);
      paramContext.putExtra("extraUin", this.jdField_a_of_type_ComTencentAvUiVideoInviteFull.e);
      paramContext.putExtra("isAudioMode", this.jdField_a_of_type_ComTencentAvUiVideoInviteFull.b);
      paramContext.putExtra("curUserStatus", this.jdField_a_of_type_ComTencentAvUiVideoInviteFull.jdField_c_of_type_Int);
      paramContext.putExtra("powerKey", this.jdField_a_of_type_ComTencentAvUiVideoInviteFull.jdField_c_of_type_Boolean);
      paramContext.putExtra("isDoubleVideoMeeting", this.jdField_a_of_type_ComTencentAvUiVideoInviteFull.jdField_h_of_type_Boolean);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteFull.startActivity(paramContext);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteFull.finish();
      return;
      paramContext = paramIntent.getStringExtra("selfUin");
      paramIntent = paramIntent.getStringExtra("sendUin");
      if (QLog.isColorLevel()) {
        QLog.d("VideoInviteFull", 2, "recv cancel video request");
      }
    } while ((this.jdField_a_of_type_ComTencentAvUiVideoInviteFull.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin() != null) && ((!this.jdField_a_of_type_ComTencentAvUiVideoInviteFull.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin().equals(paramContext)) || (!paramIntent.equals(this.jdField_a_of_type_ComTencentAvUiVideoInviteFull.jdField_c_of_type_JavaLangString))));
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteFull.jdField_a_of_type_ComTencentAvUiQavInOutAnimation != null)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoInviteFull.jdField_a_of_type_ComTencentAvUiQavInOutAnimation.a(new kcg(this));
      return;
    }
    VideoInviteFull.b(this.jdField_a_of_type_ComTencentAvUiVideoInviteFull);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kcf
 * JD-Core Version:    0.7.0.1
 */