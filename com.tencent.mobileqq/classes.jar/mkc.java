import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.qphone.base.util.QLog;

public class mkc
  implements DialogInterface.OnClickListener
{
  public mkc(VideoControlUI paramVideoControlUI, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a != null) {
      QLog.w(this.jdField_a_of_type_ComTencentAvUiVideoControlUI.d, 1, "showPermissionDialog.Cancel, seq[" + this.jdField_a_of_type_Long + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mkc
 * JD-Core Version:    0.7.0.1
 */