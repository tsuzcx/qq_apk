import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.qphone.base.util.QLog;

public class mkf
  implements DialogInterface.OnClickListener
{
  public mkf(VideoControlUI paramVideoControlUI, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.h()) {
      return;
    }
    QLog.w(this.jdField_a_of_type_ComTencentAvUiVideoControlUI.d, 1, "showPermissionNormalDialog.gotoSetting, seq[" + this.jdField_a_of_type_Long + "]");
    mvk.a(this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mkf
 * JD-Core Version:    0.7.0.1
 */