import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity;
import com.tencent.widget.Switch;

public class nlt
  implements CompoundButton.OnCheckedChangeListener
{
  public nlt(ReadInJoySettingActivity paramReadInJoySettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton = this.a;
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      ReadInJoySettingActivity.a(paramCompoundButton, bool);
      if ((!ReadInJoySettingActivity.a(this.a).isPressed()) || (this.a.c)) {
        break label75;
      }
      if (paramBoolean) {
        break;
      }
      ReadInJoySettingActivity.b(this.a, ReadInJoySettingActivity.a(this.a));
      return;
    }
    ReadInJoySettingActivity.a(this.a).show();
    return;
    label75:
    this.a.c = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nlt
 * JD-Core Version:    0.7.0.1
 */