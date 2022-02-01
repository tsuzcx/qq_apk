import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class olh
  implements CompoundButton.OnCheckedChangeListener
{
  public olh(ReadInJoySettingActivity paramReadInJoySettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    String str2 = bnrf.a();
    if (paramBoolean) {}
    for (String str1 = "1";; str1 = "0")
    {
      ocd.a(null, "CliOper", "", "", "0X800AFEB", "0X800AFEB", 0, 0, str2, str1, "", ozs.e(), false);
      bnrf.a((QQAppInterface)this.a.getAppInterface(), paramBoolean, new olq(this.a, paramBoolean));
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     olh
 * JD-Core Version:    0.7.0.1
 */