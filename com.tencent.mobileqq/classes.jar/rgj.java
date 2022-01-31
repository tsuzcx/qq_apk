import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;

public class rgj
  implements View.OnClickListener
{
  public rgj(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a != null)
    {
      this.a.getWindow().setSoftInputMode(2);
      this.a.a.hideSoftInputFromWindow(AddFriendVerifyActivity.a(this.a).getWindowToken(), 0);
      AddFriendVerifyActivity.a(this.a).clearFocus();
    }
    if (AddFriendVerifyActivity.a(this.a).getText().toString().length() > 90)
    {
      paramView = new Dialog(this.a, 2131624515);
      paramView.setContentView(2130971460);
      ((TextView)paramView.findViewById(2131362758)).setText(this.a.getString(2131434767));
      ((ProgressBar)paramView.findViewById(2131362757)).setVisibility(8);
      ((ImageView)paramView.findViewById(2131374062)).setImageResource(2130838748);
      paramView.show();
    }
    do
    {
      return;
      this.a.a(AddFriendVerifyActivity.a(this.a).getText().toString(), true);
      if (!NetworkUtil.d(this.a)) {
        break;
      }
      AddFriendVerifyActivity.a(this.a, AddFriendVerifyActivity.a(this.a), AddFriendVerifyActivity.a(this.a).getText().toString(), this.a.getIntent().getIntExtra("stat_option", 0));
    } while (!"d2g".equals(this.a.getIntent().getStringExtra("jump_from")));
    ReportController.b(this.a.app, "P_CliOper", "Grp_discuss", "", "discuss_set", "send_ask", 0, 0, AddFriendVerifyActivity.a(this.a), "", "", "");
    return;
    QQToast.a(this.a, 1, 2131434794, 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rgj
 * JD-Core Version:    0.7.0.1
 */