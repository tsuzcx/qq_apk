import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.qphone.base.util.QLog;

public class mjf
  implements DialogInterface.OnClickListener
{
  public mjf(VideoControlUI paramVideoControlUI, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.g()) {
      return;
    }
    QLog.w(this.jdField_a_of_type_ComTencentAvUiVideoControlUI.c, 1, "showPermissionNormalDialog.gotoSetting, seq[" + this.jdField_a_of_type_Long + "]");
    muc.a(this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mjf
 * JD-Core Version:    0.7.0.1
 */