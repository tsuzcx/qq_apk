import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AboutActivity;
import com.tencent.mobileqq.activity.UpgradeDetailActivity;
import com.tencent.mobileqq.app.upgrade.UpgradeController;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.statistics.ReportController;

public class rcu
  implements View.OnClickListener
{
  public rcu(AboutActivity paramAboutActivity) {}
  
  public void onClick(View paramView)
  {
    if ((AboutActivity.a(this.a) != null) && (AboutActivity.a(this.a).a != null))
    {
      ReportController.b(this.a.app, "CliOper", "", "", "0X8004DB2", "0X8004DB2", 0, 0, "", "", UpgradeController.a(), "");
      UpgradeDetailActivity.a(this.a, UpgradeController.a().a(), false, false, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rcu
 * JD-Core Version:    0.7.0.1
 */