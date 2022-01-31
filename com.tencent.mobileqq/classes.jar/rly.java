import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.statistics.ReportController;

public class rly
  implements CompoundButton.OnCheckedChangeListener
{
  public rly(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    SettingCloneUtil.writeValue(this.a, null, this.a.getString(2131433572), "qqsetting_auto_receive_pic_key", paramBoolean);
    paramCompoundButton = this.a.app;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      ReportController.b(paramCompoundButton, "CliOper", "", "", "Setting_tab", "Clk_auto_receive_pic", 0, i, "", "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rly
 * JD-Core Version:    0.7.0.1
 */