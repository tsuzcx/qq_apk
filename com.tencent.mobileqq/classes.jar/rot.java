import android.content.Context;
import android.os.Build;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.widget.ToastStyleDialog;
import com.tencent.qphone.base.util.QLog;

public class rot
  implements Runnable
{
  public rot(BaseChatPie paramBaseChatPie, int paramInt) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "recorderVolumeChange " + this.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_Int == 1) {
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.j()) {
        QLog.i("Q.aio.BaseChatPie", 1, "volueme state err" + Build.MANUFACTURER + Build.MODEL);
      }
    }
    while (((this.jdField_a_of_type_Int != 2) && (this.jdField_a_of_type_Int != 0)) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog.isShowing()) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog.getWindow() == null))
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog.isShowing()));
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog = new ToastStyleDialog(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getString(2131433376));
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog.show();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog.dismiss();
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rot
 * JD-Core Version:    0.7.0.1
 */