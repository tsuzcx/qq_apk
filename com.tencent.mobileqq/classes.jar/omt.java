import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class omt
  implements CompoundButton.OnCheckedChangeListener
{
  public omt(ReadInJoySettingActivity paramReadInJoySettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    String str2 = bkwm.a();
    if (paramBoolean) {}
    for (String str1 = "1";; str1 = "0")
    {
      odq.a(null, "CliOper", "", "", "0X800AFEB", "0X800AFEB", 0, 0, str2, str1, "", pay.f(), false);
      bkwm.a((QQAppInterface)this.a.getAppInterface(), paramBoolean, new onb(this.a, paramBoolean));
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     omt
 * JD-Core Version:    0.7.0.1
 */