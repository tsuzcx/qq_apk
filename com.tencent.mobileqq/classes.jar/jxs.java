import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.MultiVideoEnterPageActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class jxs
  implements DialogInterface.OnClickListener
{
  int jdField_a_of_type_Int;
  
  public jxs(MultiVideoEnterPageActivity paramMultiVideoEnterPageActivity, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity.jdField_a_of_type_JavaLangString, 2, "DialogInterfaceOnClickListener-->Wrong type.mode=" + this.jdField_a_of_type_Int);
      }
      paramDialogInterface.dismiss();
      return;
    case 0: 
      this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(new Intent("com.gvideo.com.tencent.av.EXIT_GROUP_VIDEO"));
      paramDialogInterface.dismiss();
      if (this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity.jdField_a_of_type_ComTencentAvVideoController.l()) {
        this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity.jdField_a_of_type_ComTencentAvVideoController.h(true);
      }
      this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity.jdField_a_of_type_ComTencentAvVideoController.a().F, this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity.jdField_a_of_type_ComTencentAvVideoController.a().f, 81);
      this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity.e(this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity.f);
      return;
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jxs
 * JD-Core Version:    0.7.0.1
 */