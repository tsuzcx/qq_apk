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

class Login$17
  implements ActionSheet.OnButtonClickListener
{
  Login$17(Login paramLogin) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (Login.access$500(this.a)) {
      return;
    }
    if (paramInt == 0)
    {
      ReportController.a(null, "dc00898", "", "", "0X800B291", "0X800B291", 0, 0, "", "", "", "");
      paramView = null;
      if (this.a.name != null) {
        paramView = this.a.name.getText().toString();
      }
      String str = "https://ti.qq.com/safe/forgetpw?source_id=2756";
      if (!TextUtils.isEmpty(paramView)) {
        str = String.format(Locale.getDefault(), "%s&account=%s", new Object[] { "https://ti.qq.com/safe/forgetpw?source_id=2756", paramView });
      }
      paramView = new Intent(this.a, QQBrowserActivity.class);
      paramView.putExtra("uin", this.a.app.getCurrentAccountUin());
      paramView.putExtra("reqType", 3);
      paramView.putExtra("url", str);
      this.a.startActivity(paramView);
    }
    else if (paramInt == 1)
    {
      ReportController.a(null, "dc00898", "", "", "0X800AFE5", "0X800AFE5", 0, 0, "", "", "", "");
      paramView = new Intent();
      paramView.putExtra("entrance", "fromLogin");
      RouteUtils.a(this.a, paramView, "/base/safe/loginPhoneNumActivity", 10000);
    }
    Login.access$502(this.a, true);
    Login.access$600(this.a).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqconnect.wtlogin.Login.17
 * JD-Core Version:    0.7.0.1
 */