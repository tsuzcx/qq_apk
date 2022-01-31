import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.AutoCompleteTextView;
import com.tencent.mobileqq.activity.AddAccountActivity;
import com.tencent.mobileqq.activity.LoginPhoneNumActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.Locale;

public class rmd
  implements ActionSheet.OnButtonClickListener
{
  public rmd(AddAccountActivity paramAddAccountActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (AddAccountActivity.a(this.a)) {
      return;
    }
    if (paramInt == 0)
    {
      ReportController.a(this.a.app, "dc00898", "", "", "0X8007353", "0X8007353", 0, 0, "", "", "", "");
      paramView = null;
      if (this.a.a != null) {
        paramView = this.a.a.getText().toString();
      }
      if (TextUtils.isEmpty(paramView)) {
        break label292;
      }
    }
    label292:
    for (paramView = String.format(Locale.getDefault(), "%s&account=%s", new Object[] { "https://aq.qq.com/cn2/findpsw/mobile_web_find_input_account?source_id=2756", paramView });; paramView = "https://aq.qq.com/cn2/findpsw/mobile_web_find_input_account?source_id=2756")
    {
      Intent localIntent = new Intent(this.a, QQBrowserActivity.class);
      localIntent.putExtra("uin", this.a.app.getCurrentAccountUin());
      localIntent.putExtra("reqType", 3);
      localIntent.putExtra("url", paramView);
      this.a.startActivity(localIntent);
      for (;;)
      {
        AddAccountActivity.b(this.a, true);
        AddAccountActivity.a(this.a).dismiss();
        return;
        if (paramInt == 1)
        {
          ReportController.a(this.a.app, "dc00898", "", "", "0X8007354", "0X8007354", 0, 0, "", "", "", "");
          ReportController.b(this.a.app, "CliOper", "", "", "Mobile_signup", "Clk_ems_login", 0, 0, "", "", "", "");
          boolean bool = this.a.getIntent().getBooleanExtra("login_from_account_change", false);
          paramView = new Intent(this.a, LoginPhoneNumActivity.class);
          paramView.putExtra("login_from_account_change", bool);
          this.a.startActivity(paramView);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rmd
 * JD-Core Version:    0.7.0.1
 */