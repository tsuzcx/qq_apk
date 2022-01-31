import android.os.Handler;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.ui.VoiceChangeChooseDialog;

public class kdc
  implements Runnable
{
  public kdc(VoiceChangeChooseDialog paramVoiceChangeChooseDialog) {}
  
  public void run()
  {
    if ((VoiceChangeChooseDialog.a(this.a) == 1) && (!this.a.jdField_a_of_type_Boolean))
    {
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(2131429599);
      VoiceChangeChooseDialog.a(this.a, 2);
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().aB = true;
      this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(this.a.jdField_a_of_type_JavaLangRunnable, 10000L);
    }
    while (VoiceChangeChooseDialog.a(this.a) != 2) {
      return;
    }
    this.a.jdField_a_of_type_AndroidWidgetTextView.setText(2131429598);
    VoiceChangeChooseDialog.a(this.a, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kdc
 * JD-Core Version:    0.7.0.1
 */