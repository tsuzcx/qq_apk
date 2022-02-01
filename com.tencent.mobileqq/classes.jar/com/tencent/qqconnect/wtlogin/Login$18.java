package com.tencent.qqconnect.wtlogin;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.Locale;

class Login$18
  implements ActionSheet.OnButtonClickListener
{
  Login$18(Login paramLogin) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = null;
    if (Login.a(this.a)) {
      return;
    }
    if (paramInt == 0)
    {
      ReportController.a(null, "dc00898", "", "", "0X800B291", "0X800B291", 0, 0, "", "", "", "");
      if (this.a.jdField_a_of_type_AndroidWidgetEditText != null) {
        paramView = this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
      }
      if (TextUtils.isEmpty(paramView)) {
        break label231;
      }
    }
    label231:
    for (paramView = String.format(Locale.getDefault(), "%s&account=%s", new Object[] { "https://ti.qq.com/safe/forgetpw?source_id=2756", paramView });; paramView = "https://ti.qq.com/safe/forgetpw?source_id=2756")
    {
      Intent localIntent = new Intent(this.a, QQBrowserActivity.class);
      localIntent.putExtra("uin", this.a.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getCurrentAccountUin());
      localIntent.putExtra("reqType", 3);
      localIntent.putExtra("url", paramView);
      this.a.startActivity(localIntent);
      for (;;)
      {
        Login.b(this.a, true);
        Login.a(this.a).dismiss();
        return;
        if (paramInt == 1)
        {
          ReportController.a(null, "dc00898", "", "", "0X800AFE5", "0X800AFE5", 0, 0, "", "", "", "");
          paramView = new Intent();
          paramView.putExtra("entrance", "fromLogin");
          RouteUtils.a(this.a, paramView, "/base/safe/loginPhoneNumActivity", 10000);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqconnect.wtlogin.Login.18
 * JD-Core Version:    0.7.0.1
 */