import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.readinjoy.ReadInJoyHelper;

public class lhf
  implements CompoundButton.OnCheckedChangeListener
{
  public lhf(ReadInJoySettingActivity paramReadInJoySettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    ReadInJoySettingActivity.c(this.a, paramBoolean);
    int i;
    label92:
    QQAppInterface localQQAppInterface;
    if (paramBoolean)
    {
      i = 1;
      ReadInJoyHelper.a("local_kd_tab_switch", Integer.valueOf(i));
      ReadInJoyHelper.a(this.a.a, "local_kd_tab_switch", Boolean.valueOf(paramBoolean));
      ReadInJoyHelper.a(this.a.a, "local_kd_tab_has_set", Boolean.valueOf(true));
      if (!paramBoolean) {
        break label147;
      }
      QQToast.a(this.a.getBaseContext(), 2, 2131439123, 2000).a();
      ReadInJoySettingActivity.a(this.a).setText(2131433568);
      localQQAppInterface = this.a.a;
      if (!paramBoolean) {
        break label182;
      }
      paramCompoundButton = "0X8008236";
      label108:
      if (!paramBoolean) {
        break label188;
      }
    }
    label147:
    label182:
    label188:
    for (String str = "0X8008236";; str = "0X8008235")
    {
      PublicAccountReportUtils.a(localQQAppInterface, "CliOper", "", "", paramCompoundButton, str, 0, 1, "", "", "", "", false);
      return;
      i = 0;
      break;
      QQToast.a(this.a.getBaseContext(), 2, 2131439124, 2000).a();
      ReadInJoySettingActivity.a(this.a).setText(2131433567);
      break label92;
      paramCompoundButton = "0X8008235";
      break label108;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lhf
 * JD-Core Version:    0.7.0.1
 */