import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class rqj
  extends Handler
{
  public rqj(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    default: 
    case 0: 
    case 1: 
      do
      {
        return;
        if (!this.a.isFinishing())
        {
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(this.a.getString(2131434062));
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.d(2130845604);
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(false);
        }
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 1000L);
        return;
      } while ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) || (!this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()));
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(this.a.getString(2131434061));
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(true);
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(false);
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(true);
      return;
    }
    AssistantSettingActivity.a(this.a).setOnCheckedChangeListener(null);
    FormSwitchItem localFormSwitchItem = AssistantSettingActivity.a(this.a);
    if (!((Boolean)paramMessage.obj).booleanValue()) {}
    for (boolean bool = true;; bool = false)
    {
      localFormSwitchItem.setChecked(bool);
      AssistantSettingActivity.a(this.a).setOnCheckedChangeListener(this.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rqj
 * JD-Core Version:    0.7.0.1
 */