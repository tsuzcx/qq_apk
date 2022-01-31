import com.tencent.av.ui.DoubleVideoMeetingCtrlUI;
import com.tencent.qphone.base.util.QLog;

public class jvj
  implements Runnable
{
  public String a;
  
  public jvj(DoubleVideoMeetingCtrlUI paramDoubleVideoMeetingCtrlUI) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_ComTencentAvUiDoubleVideoMeetingCtrlUI.c, 2, "QueryPeerVideoRunnable-->Function Name = " + this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentAvUiDoubleVideoMeetingCtrlUI.D();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jvj
 * JD-Core Version:    0.7.0.1
 */