import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.readinjoy.ReadInJoyHelper;

public class rpz
  implements CompoundButton.OnCheckedChangeListener
{
  public rpz(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i;
    label83:
    QQAppInterface localQQAppInterface;
    if (paramBoolean)
    {
      i = 1;
      ReadInJoyHelper.a("local_kd_tab_switch", Integer.valueOf(i));
      ReadInJoyHelper.a(this.a.app, "local_kd_tab_switch", Boolean.valueOf(paramBoolean));
      ReadInJoyHelper.a(this.a.app, "local_kd_tab_has_set", Boolean.valueOf(true));
      if (!paramBoolean) {
        break label138;
      }
      AssistantSettingActivity.a(this.a).setText(2131433568);
      QQToast.a(this.a.getBaseContext(), 2, 2131439123, 2000).a();
      localQQAppInterface = this.a.app;
      if (!paramBoolean) {
        break label173;
      }
      paramCompoundButton = "0X8008236";
      label99:
      if (!paramBoolean) {
        break label179;
      }
    }
    label138:
    label173:
    label179:
    for (String str = "0X8008236";; str = "0X8008235")
    {
      PublicAccountReportUtils.a(localQQAppInterface, "CliOper", "", "", paramCompoundButton, str, 0, 1, "", "", "", "", false);
      return;
      i = 0;
      break;
      AssistantSettingActivity.a(this.a).setText(2131433567);
      QQToast.a(this.a.getBaseContext(), 2, 2131439124, 2000).a();
      break label83;
      paramCompoundButton = "0X8008235";
      break label99;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rpz
 * JD-Core Version:    0.7.0.1
 */