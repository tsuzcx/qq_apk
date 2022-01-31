import android.os.Handler;
import android.widget.TextView;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.ui.VoiceChangeAdapter.ICallback;
import com.tencent.av.ui.VoiceChangeChooseDialog;
import com.tencent.av.ui.VoiceChangeDataReport;

public class ket
  implements VoiceChangeAdapter.ICallback
{
  public ket(VoiceChangeChooseDialog paramVoiceChangeChooseDialog) {}
  
  public void a(int paramInt)
  {
    AVLog.d("VoiceChangeChooseDialog", "onItemSelected| voiceType=" + paramInt);
    if (this.a.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      AVLog.e("VoiceChangeChooseDialog", "onItemSelected mVideoController is null!!");
      return;
    }
    if (paramInt == 0)
    {
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(2131429603);
      this.a.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
      VoiceChangeChooseDialog.a(this.a, 0);
    }
    while (this.a.jdField_a_of_type_ComTencentAvVideoController.a() != null)
    {
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().S = paramInt;
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().T = 0;
      this.a.jdField_a_of_type_ComTencentAvVideoController.K();
      VoiceChangeDataReport.a(this.a.jdField_a_of_type_ComTencentAvVideoController.a(), paramInt);
      return;
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(2131429604);
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.a() != null)
      {
        if ((!this.a.jdField_a_of_type_ComTencentAvVideoController.a().aB) && (VoiceChangeChooseDialog.a(this.a) == 0) && (!this.a.jdField_a_of_type_Boolean))
        {
          this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(this.a.jdField_a_of_type_JavaLangRunnable, 5000L);
          VoiceChangeChooseDialog.a(this.a, 1);
        }
      }
      else {
        AVLog.e("VoiceChangeChooseDialog", "mVideoController.getSessionInfo() == null");
      }
    }
    AVLog.e("VoiceChangeChooseDialog", "mVideoController.getSessionInfo() == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ket
 * JD-Core Version:    0.7.0.1
 */