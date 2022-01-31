import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class tdz
  implements CompoundButton.OnCheckedChangeListener
{
  public tdz(NotifyPushSettingActivity paramNotifyPushSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (NotifyPushSettingActivity.a())
    {
      NotifyPushSettingActivity.a(this.a).setChecked(false);
      NotifyPushSettingActivity.a(this.a).setVisibility(8);
      SettingCloneUtil.writeValue(this.a, this.a.a, this.a.getString(2131434202), "qqsetting_notify_showcontent_key", paramBoolean);
      if (!paramBoolean) {
        break label127;
      }
    }
    label127:
    for (int i = 1;; i = 0)
    {
      ReportController.b(this.a.app, "CliOper", "", "", "Setting_tab", "Clk_hide_text", 0, i, String.valueOf(i), "", "", "");
      return;
      if (paramBoolean)
      {
        NotifyPushSettingActivity.a(this.a).setVisibility(0);
        break;
      }
      NotifyPushSettingActivity.a(this.a).setVisibility(8);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tdz
 * JD-Core Version:    0.7.0.1
 */