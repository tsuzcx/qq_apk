import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;

public class olm
  implements CompoundButton.OnCheckedChangeListener
{
  public olm(ReadInJoySettingActivity paramReadInJoySettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    ReadInJoySettingActivity localReadInJoySettingActivity = this.a;
    boolean bool;
    if (!paramBoolean)
    {
      bool = true;
      ReadInJoySettingActivity.a(localReadInJoySettingActivity, bool);
      if ((!ReadInJoySettingActivity.a(this.a).isPressed()) || (this.a.c)) {
        break label87;
      }
      if (paramBoolean) {
        break label74;
      }
      ReadInJoySettingActivity.b(this.a, ReadInJoySettingActivity.a(this.a));
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      bool = false;
      break;
      label74:
      ReadInJoySettingActivity.a(this.a).show();
      continue;
      label87:
      this.a.c = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     olm
 * JD-Core Version:    0.7.0.1
 */