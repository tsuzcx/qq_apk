import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.ui.VideoInviteActivity;

public class kbv
  implements DialogInterface.OnClickListener
{
  int jdField_a_of_type_Int;
  
  public kbv(VideoInviteActivity paramVideoInviteActivity, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a == null) {
      return;
    }
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 0: 
      paramDialogInterface.dismiss();
      if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a.r();
      }
      if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a.l()) {
        this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a.h(false);
      }
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.d = true;
      paramDialogInterface = this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a;
      if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.b) {}
      paramDialogInterface.b(1, false, true);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.f();
      return;
    }
    paramDialogInterface.dismiss();
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a(true);
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kbv
 * JD-Core Version:    0.7.0.1
 */