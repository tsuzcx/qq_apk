import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.forward.ForwardAbility.ForwardAbilityType;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.statistics.ReportController;

public class sst
  implements View.OnClickListener
{
  public sst(ForwardRecentActivity paramForwardRecentActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Bundle();
    paramView.putString("uin", String.valueOf(AppConstants.z));
    paramView.putInt("uintype", -1);
    this.a.a.a(ForwardAbility.ForwardAbilityType.k.intValue(), paramView);
    ReportController.b(this.a.app, "CliOper", "", "", "0X8004051", "0X8004051", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     sst
 * JD-Core Version:    0.7.0.1
 */