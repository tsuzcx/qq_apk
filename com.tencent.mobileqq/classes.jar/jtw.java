import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.ui.DoubleVideoMeetingCtrlUI;
import com.tencent.av.utils.TipsManager;
import com.tencent.qphone.base.util.QLog;

public class jtw
  implements Runnable
{
  public jtw(DoubleVideoMeetingCtrlUI paramDoubleVideoMeetingCtrlUI) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.a.c, 2, "RequestVideoTimeoutRunnale-->VideoControl is null");
      }
      return;
    }
    this.a.jdField_a_of_type_ComTencentAvVideoController.f();
    this.a.h(true);
    if (this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager != null)
    {
      TipsManager.c(103);
      TipsManager.c(106);
      this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(106);
      this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(106);
    }
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().a(this.a.b, true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jtw
 * JD-Core Version:    0.7.0.1
 */