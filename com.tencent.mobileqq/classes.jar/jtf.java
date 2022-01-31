import com.tencent.av.ui.DoubleVideoMeetingCtrlUI;
import com.tencent.qphone.base.util.QLog;

public class jtf
  implements Runnable
{
  public String a;
  
  public jtf(DoubleVideoMeetingCtrlUI paramDoubleVideoMeetingCtrlUI) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_ComTencentAvUiDoubleVideoMeetingCtrlUI.c, 2, "QueryPeerVideoRunnable-->Function Name = " + this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentAvUiDoubleVideoMeetingCtrlUI.D();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jtf
 * JD-Core Version:    0.7.0.1
 */