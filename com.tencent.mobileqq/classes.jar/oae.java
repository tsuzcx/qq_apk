import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;

public class oae
  implements CompoundButton.OnCheckedChangeListener
{
  public oae(ReadInJoySettingActivity paramReadInJoySettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    ReadInJoySettingActivity.c(this.a, paramBoolean);
    int i;
    label51:
    QQAppInterface localQQAppInterface;
    if (paramBoolean)
    {
      QQToast.a(this.a.getBaseContext(), 2, 2131719051, 2000).a();
      ReadInJoySettingActivity.a(this.a).setText(2131719050);
      if (!paramBoolean) {
        break label149;
      }
      i = 1;
      bkbq.e(i);
      bkbq.a(paramBoolean);
      bkbq.a(true);
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
      nrt.a(localQQAppInterface, "CliOper", "", "", paramCompoundButton, str, 0, 1, "", "", "", "", false);
      return;
      QQToast.a(this.a.getBaseContext(), 2, 2131719049, 2000).a();
      ReadInJoySettingActivity.a(this.a).setText(2131719053);
      break;
      i = 0;
      break label51;
      paramCompoundButton = "0X8008235";
      break label80;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     oae
 * JD-Core Version:    0.7.0.1
 */