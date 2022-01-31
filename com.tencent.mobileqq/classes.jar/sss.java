import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardAbility.ForwardAbilityType;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.open.agent.report.ReportCenter;

public class sss
  implements View.OnClickListener
{
  public sss(ForwardRecentActivity paramForwardRecentActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Bundle();
    paramView.putString("uin", String.valueOf(AppConstants.y));
    paramView.putInt("uintype", -1);
    paramView.putBoolean("forward_report_confirm", true);
    paramView.putString("forward_report_confirm_action_name", "0X8005A13");
    paramView.putString("forward_report_confirm_reverse2", "0");
    this.a.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.f.intValue(), paramView);
    ReportController.b(this.a.app, "CliOper", "", "", "0X8004051", "0X8004051", 0, 0, "", "", "", "");
    if (this.a.jdField_a_of_type_Boolean) {
      ReportCenter.a().a(this.a.app.getAccount(), "", this.a.b, "1000", "34", "0", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     sss
 * JD-Core Version:    0.7.0.1
 */