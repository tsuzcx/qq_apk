import android.widget.TextView;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.funchat.record.QavRecordButtonView;

public class jpi
  implements Runnable
{
  public jpi(AVActivity paramAVActivity, SessionInfo paramSessionInfo) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentAvUiAVActivity.a == null) || (this.jdField_a_of_type_ComTencentAvUiAVActivity.e) || (this.jdField_a_of_type_ComTencentAvUiAVActivity.c == null)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvUiAVActivity.a.getVisibility() != 0)
    {
      this.jdField_a_of_type_ComTencentAvUiAVActivity.c.clearAnimation();
      this.jdField_a_of_type_ComTencentAvUiAVActivity.c.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentAvAppSessionInfo.aD = true;
    if (this.jdField_a_of_type_ComTencentAvAppSessionInfo.U == 0)
    {
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.V = Math.max(1, this.jdField_a_of_type_ComTencentAvAppSessionInfo.V + 1);
      this.jdField_a_of_type_ComTencentAvUiAVActivity.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.V);
    }
    this.jdField_a_of_type_ComTencentAvUiAVActivity.a(600, -40);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jpi
 * JD-Core Version:    0.7.0.1
 */