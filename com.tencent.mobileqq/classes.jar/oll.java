import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class oll
  implements CompoundButton.OnCheckedChangeListener
{
  public oll(ReadInJoySettingActivity paramReadInJoySettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    ReadInJoySettingActivity.c(this.a, paramBoolean);
    int i;
    label51:
    QQAppInterface localQQAppInterface;
    String str1;
    if (paramBoolean)
    {
      QQToast.a(this.a.getBaseContext(), 2, 2131717297, 2000).a();
      ReadInJoySettingActivity.a(this.a).setText(2131717296);
      if (!paramBoolean) {
        break label159;
      }
      i = 1;
      bnrf.d(i);
      bnrf.a(paramBoolean);
      bnrf.a(true);
      localQQAppInterface = this.a.a;
      if (!paramBoolean) {
        break label164;
      }
      str1 = "0X8008236";
      label81:
      if (!paramBoolean) {
        break label171;
      }
    }
    label159:
    label164:
    label171:
    for (String str2 = "0X8008236";; str2 = "0X8008235")
    {
      ocd.a(localQQAppInterface, "CliOper", "", "", str1, str2, 0, 1, "", "", "", "", false);
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      QQToast.a(this.a.getBaseContext(), 2, 2131717295, 2000).a();
      ReadInJoySettingActivity.a(this.a).setText(2131717299);
      break;
      i = 0;
      break label51;
      str1 = "0X8008235";
      break label81;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oll
 * JD-Core Version:    0.7.0.1
 */