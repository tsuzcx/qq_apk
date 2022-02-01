import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.qphone.base.util.QLog;

public class mjz
  implements DialogInterface.OnClickListener
{
  public mjz(VideoControlUI paramVideoControlUI, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.h()) {
      return;
    }
    QLog.w(this.jdField_a_of_type_ComTencentAvUiVideoControlUI.d, 1, "showPermissionNormalDialog.gotoSetting, seq[" + this.jdField_a_of_type_Long + "]");
    mvd.a(this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mjz
 * JD-Core Version:    0.7.0.1
 */