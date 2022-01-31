import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.readinjoy.ReadInJoyHelper;

public class lfe
  implements CompoundButton.OnCheckedChangeListener
{
  public lfe(ReadInJoySettingActivity paramReadInJoySettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    ReadInJoySettingActivity.c(this.a, paramBoolean);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      ReadInJoyHelper.a("local_kd_tab_switch", Integer.valueOf(i));
      ReadInJoyHelper.a(this.a.a, "local_kd_tab_switch", Boolean.valueOf(paramBoolean));
      ReadInJoyHelper.a(this.a.a, "local_kd_tab_has_set", Boolean.valueOf(true));
      if (!paramBoolean) {
        break;
      }
      QQToast.a(this.a.getBaseContext(), 2, 2131439068, 2000).a();
      ReadInJoySettingActivity.a(this.a).setText(2131433537);
      return;
    }
    QQToast.a(this.a.getBaseContext(), 2, 2131439069, 2000).a();
    ReadInJoySettingActivity.a(this.a).setText(2131433536);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lfe
 * JD-Core Version:    0.7.0.1
 */