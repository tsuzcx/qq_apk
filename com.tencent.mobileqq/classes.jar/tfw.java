import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SecSvcHandler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class tfw
  implements ActionSheet.OnButtonClickListener
{
  public tfw(PhoneUnityBindInfoActivity paramPhoneUnityBindInfoActivity, String paramString1, String paramString2, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = paramView.getContext();
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.app, "CliOper", "", "", "0X8005B7C", "0X8005B7C", 0, 0, "", "", "", "");
      if (!NetworkUtil.d(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity, this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.getString(2131433009), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.getTitleBarHeight());
        return;
      }
      paramView = (SecSvcHandler)this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.app.a(34);
      if (paramView != null) {
        paramView.a(3, this.jdField_a_of_type_JavaLangString, this.b);
      }
      PhoneUnityBindInfoActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity);
      PhoneUnityBindInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity, 2131434453, 1000L, true);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.b = false;
      return;
    case 1: 
      if (!NetworkUtil.d(paramView))
      {
        PhoneUnityBindInfoActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity, 2131434613);
        return;
      }
      paramView = new Intent(paramView, BindNumberActivity.class);
      paramView.putExtra("cmd_param_is_from_uni", true);
      paramView.putExtra("cmd_param_is_from_change_bind", true);
      paramView.putExtra("kNeedUnbind", true);
      paramView.putExtra("kUnityOther", true);
      paramView.putExtra("kSrouce", this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.a);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.startActivityForResult(paramView, 1004);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.app, "CliOper", "", "", "0X8005B7D", "0X8005B7D", 0, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.b = false;
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.app, "CliOper", "", "", "0X8005B7E", "0X8005B7E", 0, 0, "", "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.b = true;
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhoneUnityBindInfoActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tfw
 * JD-Core Version:    0.7.0.1
 */