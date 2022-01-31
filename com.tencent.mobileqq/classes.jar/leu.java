import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;

public class leu
  extends PublicAccountObserver
{
  public leu(ReadInJoySettingActivity paramReadInJoySettingActivity) {}
  
  public void b(boolean paramBoolean, int paramInt)
  {
    Object localObject = this.a;
    ((ReadInJoySettingActivity)localObject).jdField_a_of_type_Int -= 1;
    if ((this.a.jdField_a_of_type_Int == 0) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    boolean bool;
    if (paramInt == this.a.b)
    {
      bool = ReadInJoySettingActivity.a(this.a);
      if (!paramBoolean) {
        break label189;
      }
      localObject = ReadInJoySettingActivity.a(this.a);
      if (bool) {
        break label155;
      }
      paramBoolean = true;
      ((Switch)localObject).setChecked(paramBoolean);
      if (!bool) {
        break label160;
      }
      PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80067D5", "0X80067D5", 0, 0, "", "", "", ReadInJoyUtils.c(), false);
      label135:
      ReadInJoySettingActivity.a(this.a).a(bool);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Boolean = false;
      return;
      label155:
      paramBoolean = false;
      break;
      label160:
      PublicAccountReportUtils.a(null, "CliOper", "", "", "0X800676D", "0X800676D", 0, 0, "", "", "", ReadInJoyUtils.c(), false);
      break label135;
      label189:
      QQToast.a(this.a.getApplicationContext(), 2131428474, 0).a();
      this.a.c = true;
      ReadInJoySettingActivity.a(this.a).setChecked(bool);
      QLog.d("ReadInJoySettingActivity", 1, "handle setkandian recomm failed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     leu
 * JD-Core Version:    0.7.0.1
 */