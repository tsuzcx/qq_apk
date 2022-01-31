import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.av.utils.TipsManager;
import com.tencent.mobileqq.statistics.ReportController;

public class jsq
  implements DialogInterface.OnClickListener
{
  public jsq(DoubleVideoCtrlUI paramDoubleVideoCtrlUI, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvVideoController.j(this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvVideoController.a().c, this.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
        this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(2, true);
      }
    }
    if (this.jdField_a_of_type_Int == 0) {
      ReportController.b(null, "CliOper", "", "", "0X8005CFD", "0X8005CFD", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      paramDialogInterface.dismiss();
      return;
      if (this.jdField_a_of_type_Int == 1) {
        ReportController.b(null, "CliOper", "", "", "0X8005CFF", "0X8005CFF", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jsq
 * JD-Core Version:    0.7.0.1
 */