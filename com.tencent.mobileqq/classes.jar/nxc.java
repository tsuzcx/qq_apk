import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class nxc
  implements CompoundButton.OnCheckedChangeListener
{
  public nxc(ReadInJoySettingActivity paramReadInJoySettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    ReadInJoySettingActivity.c(this.a, paramBoolean);
    int i;
    label51:
    QQAppInterface localQQAppInterface;
    if (paramBoolean)
    {
      bcpw.a(this.a.getBaseContext(), 2, 2131718571, 2000).a();
      ReadInJoySettingActivity.a(this.a).setText(2131718570);
      if (!paramBoolean) {
        break label149;
      }
      i = 1;
      bhvh.e(i);
      bhvh.a(paramBoolean);
      bhvh.a(true);
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
      noo.a(localQQAppInterface, "CliOper", "", "", paramCompoundButton, str, 0, 1, "", "", "", "", false);
      return;
      bcpw.a(this.a.getBaseContext(), 2, 2131718569, 2000).a();
      ReadInJoySettingActivity.a(this.a).setText(2131718573);
      break;
      i = 0;
      break label51;
      paramCompoundButton = "0X8008235";
      break label80;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nxc
 * JD-Core Version:    0.7.0.1
 */