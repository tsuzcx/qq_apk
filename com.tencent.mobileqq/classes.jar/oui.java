import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class oui
  implements CompoundButton.OnCheckedChangeListener
{
  public oui(ReadInJoySettingActivity paramReadInJoySettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (!paramCompoundButton.isPressed())
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
    ReadInJoySettingActivity localReadInJoySettingActivity = this.a;
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      ReadInJoySettingActivity.c(localReadInJoySettingActivity, bool);
      ReadInJoySettingActivity.d(this.a, paramBoolean);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oui
 * JD-Core Version:    0.7.0.1
 */