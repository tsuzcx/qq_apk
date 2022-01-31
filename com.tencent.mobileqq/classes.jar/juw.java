import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.utils.TipsManager;
import com.tencent.qphone.base.util.QLog;

public class juw
  implements Runnable
{
  public juw(DoubleVideoCtrlUI paramDoubleVideoCtrlUI) {}
  
  public void run()
  {
    if ((this.a.jdField_a_of_type_ComTencentAvVideoController == null) || (this.a.jdField_a_of_type_ComTencentAvUiQavPanel == null) || (this.a.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131365404)) || (this.a.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131365396))) {
      return;
    }
    if ((this.a.jdField_a_of_type_ComTencentAvVideoController.c()) && (VcSystemInfo.b())) {
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().d == 1)
      {
        this.a.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365404, true);
        this.a.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365404, true);
      }
    }
    for (;;)
    {
      this.a.D();
      if (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Boolean) {
        break;
      }
      this.a.jdField_a_of_type_ComTencentAvVideoController.a(true, this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString);
      return;
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().d == 1)
      {
        this.a.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365404, false);
        this.a.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365404, false);
      }
      if ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 1) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.a.jdField_c_of_type_JavaLangString, 2, "FixTerSwitchStatus ,switch to pc ,local close camera");
        }
        this.a.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365404, false);
        this.a.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365404, false);
        this.a.w();
        this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106) });
        this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(24, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     juw
 * JD-Core Version:    0.7.0.1
 */