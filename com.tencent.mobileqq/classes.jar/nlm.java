import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity;

public class nlm
  implements begw
{
  public nlm(ReadInJoySettingActivity paramReadInJoySettingActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    ReadInJoySettingActivity.c(this.a).d(paramInt);
    ((TextView)this.a.findViewById(2131305955)).setText(ReadInJoySettingActivity.a(this.a)[paramInt]);
    obz.a(Integer.toString(paramInt));
    ndn.a(null, "", "0X8007416", "0X8007416", 0, 0, Integer.toString(paramInt), "", "", "", false);
    ReadInJoySettingActivity.c(this.a).cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nlm
 * JD-Core Version:    0.7.0.1
 */