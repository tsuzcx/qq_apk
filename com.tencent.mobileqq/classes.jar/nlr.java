import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class nlr
  implements CompoundButton.OnCheckedChangeListener
{
  public nlr(ReadInJoySettingActivity paramReadInJoySettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    ReadInJoySettingActivity.c(this.a, paramBoolean);
    int i;
    label51:
    QQAppInterface localQQAppInterface;
    if (paramBoolean)
    {
      bbmy.a(this.a.getBaseContext(), 2, 2131652746, 2000).a();
      ReadInJoySettingActivity.a(this.a).setText(2131652745);
      if (!paramBoolean) {
        break label149;
      }
      i = 1;
      bgmq.e(i);
      bgmq.a(paramBoolean);
      bgmq.a(true);
      localQQAppInterface = this.a.a;
      if (!paramBoolean) {
        break label154;
      }
      paramCompoundButton = "0X8008236";
      label80:
      if (!paramBoolean) {
        break label160;
      }
    }
    label149:
    label154:
    label160:
    for (String str = "0X8008236";; str = "0X8008235")
    {
      ndn.a(localQQAppInterface, "CliOper", "", "", paramCompoundButton, str, 0, 1, "", "", "", "", false);
      return;
      bbmy.a(this.a.getBaseContext(), 2, 2131652744, 2000).a();
      ReadInJoySettingActivity.a(this.a).setText(2131652748);
      break;
      i = 0;
      break label51;
      paramCompoundButton = "0X8008235";
      break label80;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nlr
 * JD-Core Version:    0.7.0.1
 */