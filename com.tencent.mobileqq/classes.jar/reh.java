import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.activity.AssociatedAccountActivity;
import com.tencent.mobileqq.activity.SubAccountBindActivity;
import com.tencent.mobileqq.activity.SubAccountUgActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DBUtils;

public class reh
  implements View.OnClickListener
{
  public reh(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131362740: 
    case 2131362741: 
    default: 
    case 2131362739: 
      do
      {
        return;
        localObject = null;
        if ((paramView.getTag() instanceof String)) {
          localObject = String.valueOf(paramView.getTag());
        }
        if ("0X8004001".equals(localObject))
        {
          ReportController.b(this.a.app, "CliOper", "", "", "0X8004002", "0X8004002", 0, 0, "", "", "", "");
          paramView = new Intent(this.a, SubAccountUgActivity.class);
          paramView.putExtra("fromWhere", AccountManageActivity.class.getSimpleName());
          this.a.startActivity(paramView);
          return;
        }
      } while (!"0X8004456".equals(localObject));
      ReportController.b(this.a.app, "CliOper", "", "", "0X8004457", "0X8004457", 0, 0, "", "", "", "");
      paramView = new Intent(this.a, SubAccountBindActivity.class);
      paramView.putExtra("fromWhere", AccountManageActivity.class.getSimpleName());
      this.a.startActivity(paramView);
      DBUtils.a().a(this.a.app.getCurrentAccountUin(), true);
      return;
    }
    Object localObject = new Intent();
    ((Intent)localObject).setClass(paramView.getContext(), AssociatedAccountActivity.class);
    ((Intent)localObject).putExtra("fromWhere", AccountManageActivity.class.getSimpleName());
    paramView.getContext().startActivity((Intent)localObject);
    ReportController.b(this.a.app, "CliOper", "", "", "0X8004039", "0X8004039", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     reh
 * JD-Core Version:    0.7.0.1
 */