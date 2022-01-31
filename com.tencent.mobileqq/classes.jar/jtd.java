import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.ui.DoubleVideoMeetingCtrlUI;
import com.tencent.av.ui.QavInOutAnimation.QavOutAnimationListener;
import com.tencent.av.utils.TraeHelper;
import com.tencent.mobileqq.statistics.ReportController;

public class jtd
  implements QavInOutAnimation.QavOutAnimationListener
{
  public jtd(DoubleVideoMeetingCtrlUI paramDoubleVideoMeetingCtrlUI) {}
  
  public void a()
  {
    this.a.l = true;
    this.a.ah();
  }
  
  public void b()
  {
    TraeHelper.a().a("DoubleVideoMeetingCtrlUI.onOutAnimationEnd_1");
    if (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().Q) {
      DoubleVideoMeetingCtrlUI.a(this.a);
    }
    this.a.jdField_a_of_type_Boolean = true;
    this.a.jdField_a_of_type_ComTencentAvVideoController.a(this.a.jdField_a_of_type_Long, true, 0);
    DoubleVideoMeetingCtrlUI.b(this.a);
    this.a.d(true);
    ReportController.b(null, "CliOper", "", "", "0X8005206", "0X8005206", 0, 0, "", "", "", "");
    this.a.l = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jtd
 * JD-Core Version:    0.7.0.1
 */