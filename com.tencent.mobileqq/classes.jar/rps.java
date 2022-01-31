import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.upgrade.UpgradeController;
import com.tencent.mobileqq.statistics.ReportController;

public class rps
  implements CompoundButton.OnCheckedChangeListener
{
  public rps(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton = this.a.app;
    int i;
    if (paramBoolean)
    {
      i = 1;
      ReportController.b(paramCompoundButton, "CliOper", "", "", "Setting_tab", "Download_new", 0, i, "", "", "", "");
      ((ConfigHandler)this.a.app.a(4)).d();
      ConfigHandler.a(this.a.app, paramBoolean);
      if (!paramBoolean) {
        break label134;
      }
      if (UpgradeController.a().a() != 4) {
        UpgradeController.a().a();
      }
      ReportController.b(null, "CliOper", "", "", "0X8007212", "0X8007212", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      ((MessageHandler)this.a.app.a(0)).f(paramBoolean);
      return;
      i = 0;
      break;
      label134:
      UpgradeController.a().b();
      ReportController.b(null, "CliOper", "", "", "0X8007213", "0X8007213", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rps
 * JD-Core Version:    0.7.0.1
 */