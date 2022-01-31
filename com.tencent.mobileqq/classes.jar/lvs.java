import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.tencent.av.VideoController;
import com.tencent.av.ui.MultiVideoEnterPageActivity;
import com.tencent.qphone.base.util.QLog;

public class lvs
  implements DialogInterface.OnClickListener
{
  public lvs(MultiVideoEnterPageActivity paramMultiVideoEnterPageActivity, View paramView) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity.b()) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setEnabled(false);
    this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity.b = this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity.c, this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity.f, this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity.jdField_a_of_type_Long);
    QLog.w(this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity.jdField_a_of_type_JavaLangString, 1, "kickOutUsers begin, mGAudioRoomId[" + this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity.b + "]");
    this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity.jdField_a_of_type_ComTencentAvVideoController.a(1, this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity.c, this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity.f, this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity.jdField_a_of_type_Long);
    awqx.b(null, "CliOper", "", "", "0X8009E2A", "0X8009E2A", 0, 0, "", "", "", "");
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lvs
 * JD-Core Version:    0.7.0.1
 */