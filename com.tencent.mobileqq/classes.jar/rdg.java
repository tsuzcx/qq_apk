import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.activity.AddAccountActivity;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.SubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class rdg
  implements View.OnClickListener
{
  public rdg(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Switch_Account", 2, "add account");
    }
    if (!PhoneNumLoginImpl.a().a(this.a.app, this.a)) {
      return;
    }
    if ((this.a.a != null) && (this.a.a.size() >= 8))
    {
      QQToast.a(this.a, 2131433249, 0).a();
      return;
    }
    AccountManageActivity.a(this.a, SubAccountControll.a(this.a.app));
    paramView = new Intent();
    paramView.setPackage(this.a.getPackageName());
    paramView.setClass(this.a, AddAccountActivity.class);
    this.a.startActivityForResult(paramView, 1000);
    this.a.overridePendingTransition(2131034134, 2131034131);
    SubAccountAssistantForward.c(this.a.app, this.a);
    ReportController.b(this.a.app, "CliOper", "", "", "Setting_tab", "Clk_acc_add", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rdg
 * JD-Core Version:    0.7.0.1
 */