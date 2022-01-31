import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class nwz
  implements CompoundButton.OnCheckedChangeListener
{
  public nwz(ReadInJoySettingActivity paramReadInJoySettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    ReadInJoySettingActivity.c(this.a, paramBoolean);
    int i;
    label51:
    QQAppInterface localQQAppInterface;
    if (paramBoolean)
    {
      bcql.a(this.a.getBaseContext(), 2, 2131718582, 2000).a();
      ReadInJoySettingActivity.a(this.a).setText(2131718581);
      if (!paramBoolean) {
        break label149;
      }
      i = 1;
      bhvy.e(i);
      bhvy.a(paramBoolean);
      bhvy.a(true);
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
      nol.a(localQQAppInterface, "CliOper", "", "", paramCompoundButton, str, 0, 1, "", "", "", "", false);
      return;
      bcql.a(this.a.getBaseContext(), 2, 2131718580, 2000).a();
      ReadInJoySettingActivity.a(this.a).setText(2131718584);
      break;
      i = 0;
      break label51;
      paramCompoundButton = "0X8008235";
      break label80;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nwz
 * JD-Core Version:    0.7.0.1
 */