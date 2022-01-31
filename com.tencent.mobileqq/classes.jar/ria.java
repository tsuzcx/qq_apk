import android.view.View;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.mobileqq.ark.ArkAppDataReport;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomArkDialog.AppInfo;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class ria
  implements ActionSheet.OnButtonClickListener
{
  public ria(ArkFullScreenAppActivity paramArkFullScreenAppActivity, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (ArkFullScreenAppActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityArkFullScreenAppActivity) != null)
    {
      ArkAppDataReport.c(this.jdField_a_of_type_ComTencentMobileqqActivityArkFullScreenAppActivity.app, ArkFullScreenAppActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityArkFullScreenAppActivity).jdField_a_of_type_JavaLangString, ArkAppDataReport.d);
      ArkAppDataReport.l(this.jdField_a_of_type_ComTencentMobileqqActivityArkFullScreenAppActivity.app, ArkFullScreenAppActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityArkFullScreenAppActivity).jdField_a_of_type_JavaLangString);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("share click:");
      if (ArkFullScreenAppActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityArkFullScreenAppActivity) == null)
      {
        paramView = "none";
        QLog.d("ArkFullScreenAppActivity", 2, paramView);
      }
    }
    else
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityArkFullScreenAppActivity.a(ArkFullScreenAppActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityArkFullScreenAppActivity).jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer);
      if (paramView == null) {
        break label153;
      }
      ForwardBaseOption.a(this.jdField_a_of_type_ComTencentMobileqqActivityArkFullScreenAppActivity, paramView, 100);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      paramView = ArkFullScreenAppActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityArkFullScreenAppActivity).jdField_a_of_type_JavaLangString;
      break;
      label153:
      if (QLog.isColorLevel()) {
        QLog.i("ArkFullScreenAppActivity", 2, "showActionSheet share: intent == null");
      }
      DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityArkFullScreenAppActivity, 230, "提示", "无法分享该页面。", new rib(this), null).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ria
 * JD-Core Version:    0.7.0.1
 */