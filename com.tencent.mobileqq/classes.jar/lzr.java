import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class lzr
  implements DialogInterface.OnClickListener
{
  int jdField_a_of_type_Int;
  
  public lzr(VideoInviteActivity paramVideoInviteActivity, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return;
    }
    long l = AudioHelper.b();
    QLog.w(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_JavaLangString, 1, "onClick, seq[" + l + "]");
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 0: 
      paramDialogInterface.dismiss();
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a().m();
      if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a().l()) {
        this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a().h(false);
      }
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.d = true;
      paramDialogInterface = this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a();
      if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.b) {}
      for (paramInt = 1;; paramInt = 2)
      {
        paramDialogInterface.a(l, paramInt, false, true);
        this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.e();
        return;
      }
    }
    paramDialogInterface.dismiss();
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a(l, true);
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lzr
 * JD-Core Version:    0.7.0.1
 */