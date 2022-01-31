import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.statistics.ReportController;

public class rma
  implements CompoundButton.OnCheckedChangeListener
{
  public rma(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton = this.a.app;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      ReportController.b(paramCompoundButton, "CliOper", "", "", "Setting_tab", "Enter_sendmsg", 0, i, "", "", "", "");
      SettingCloneUtil.writeValue(this.a, null, this.a.getString(2131433626), "qqsetting_enter_sendmsg_key", paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rma
 * JD-Core Version:    0.7.0.1
 */