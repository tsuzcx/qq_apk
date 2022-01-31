import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import mqq.app.MobileQQ;

public class tbf
  implements CompoundButton.OnCheckedChangeListener
{
  public tbf(NotifyPushSettingActivity paramNotifyPushSettingActivity, CardHandler paramCardHandler) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (AppSetting.b) {
      NotifyPushSettingActivity.g(this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity).setContentDescription("PC离线时自动启动QQ手机版");
    }
    QQAppInterface localQQAppInterface;
    int i;
    if (!NotifyPushSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity))
    {
      if (paramBoolean) {
        ReportController.b(null, "CliOper", "", "", "0X8004972", "0X8004972", 0, 1, "", "", "", "");
      }
    }
    else
    {
      if ((!NetworkUtil.g(this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity.getApplicationContext())) || (!NotifyPushSettingActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity))) {
        break label182;
      }
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity.app;
      if (!paramBoolean) {
        break label171;
      }
      i = 1;
      label94:
      if (!paramBoolean) {
        break label176;
      }
    }
    label171:
    label176:
    for (paramCompoundButton = "1";; paramCompoundButton = "0")
    {
      ReportController.b(localQQAppInterface, "CliOper", "", "", "Setting_tab", "PC_active", 0, i, paramCompoundButton, "", "", "");
      if (!NotifyPushSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity)) {
        this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.b(paramBoolean);
      }
      return;
      ReportController.b(null, "CliOper", "", "", "0X8004972", "0X8004972", 0, 0, "", "", "", "");
      break;
      i = 0;
      break label94;
    }
    label182:
    NotifyPushSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity, false);
    paramCompoundButton = NotifyPushSettingActivity.g(this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity);
    if (!NotifyPushSettingActivity.g(this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity).a()) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramCompoundButton.setChecked(paramBoolean);
      NotifyPushSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity, true);
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity, this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity.app.getApplication().getString(2131437513), 0).b(5);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tbf
 * JD-Core Version:    0.7.0.1
 */