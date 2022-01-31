import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.AppRuntime.Status;

public class rhf
  implements View.OnClickListener
{
  public rhf(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    AppRuntime.Status localStatus = AppRuntime.Status.online;
    int i = paramView.getId();
    if (i == 2131362761)
    {
      ReportController.b(this.a.app, "CliOper", "", "", "0X800403A", "0X800403A", 0, 0, "", "", "", "");
      paramView = AppRuntime.Status.online;
    }
    for (;;)
    {
      this.a.a(paramView);
      if (((paramView == AppRuntime.Status.online) || (paramView == AppRuntime.Status.invisiable) || (paramView == AppRuntime.Status.away)) && (paramView != this.a.app.getOnlineStatus()))
      {
        if (!NetworkUtil.d(this.a.getApplication())) {
          break;
        }
        this.a.app.a(this.a.a(paramView), true);
      }
      return;
      if (i == 2131361826)
      {
        ReportController.b(this.a.app, "CliOper", "", "", "0X800403B", "0X800403B", 0, 0, "", "", "", "");
        paramView = AppRuntime.Status.invisiable;
      }
      else
      {
        paramView = localStatus;
        if (i == 2131362762) {
          paramView = AppRuntime.Status.away;
        }
      }
    }
    Toast.makeText(BaseApplication.getContext(), 2131433255, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rhf
 * JD-Core Version:    0.7.0.1
 */