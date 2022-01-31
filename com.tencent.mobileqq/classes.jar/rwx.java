import android.content.Context;
import android.content.Intent;
import android.widget.TextView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.qphone.base.util.QLog;

public class rwx
  implements Runnable
{
  public rwx(BaseChatPie paramBaseChatPie, boolean paramBoolean, Intent paramIntent1, Intent paramIntent2) {}
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("forward", 1, "updateSession_forwardType, postDelayed Run! needToBottom=" + this.jdField_a_of_type_Boolean);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.f(this.jdField_a_of_type_AndroidContentIntent);
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.O();
    }
    if (this.b.getBooleanExtra("isFromShare", false))
    {
      this.b.removeExtra("forward_type");
      this.b.removeExtra("isFromShare");
      String str2 = this.b.getStringExtra("leftBackText");
      String str1;
      if (str2 != null)
      {
        str1 = str2;
        if (!"".equals(str2)) {}
      }
      else
      {
        str1 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getString(2131433712);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidWidgetTextView.setText(str1);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.aJ();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rwx
 * JD-Core Version:    0.7.0.1
 */