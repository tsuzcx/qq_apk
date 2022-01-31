import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.av.VideoController;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoControlUI;

public class jph
  implements DialogInterface.OnDismissListener
{
  public jph(AVActivity paramAVActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
    {
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().r = false;
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.l(true);
      this.a.jdField_a_of_type_ComTencentAvUiVoiceChangeChooseDialog = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jph
 * JD-Core Version:    0.7.0.1
 */