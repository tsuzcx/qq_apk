import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AssociatedAccountActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.qphone.base.util.QLog;

public class rjf
  implements View.OnClickListener
{
  public rjf(AssociatedAccountActivity paramAssociatedAccountActivity) {}
  
  public void onClick(View paramView)
  {
    boolean bool = false;
    ReportController.b(this.a.app, "CliOper", "", "", "0X8007144", "0X8007144", 0, 0, "", "", "", "");
    paramView = (SubAccountManager)this.a.app.getManager(60);
    if ((paramView != null) && (paramView.a() >= 2)) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AssociatedAccountActivity", 2, "click top right manage btn underTwo = " + bool);
      }
      AssociatedAccountActivity.a(this.a, bool);
      return;
      bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rjf
 * JD-Core Version:    0.7.0.1
 */