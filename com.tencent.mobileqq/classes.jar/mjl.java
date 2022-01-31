import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.qphone.base.util.QLog;

public class mjl
  implements DialogInterface.OnClickListener
{
  public mjl(VideoControlUI paramVideoControlUI, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a != null) {
      QLog.w(this.jdField_a_of_type_ComTencentAvUiVideoControlUI.c, 1, "showPermissionDialog.Cancel, seq[" + this.jdField_a_of_type_Long + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mjl
 * JD-Core Version:    0.7.0.1
 */