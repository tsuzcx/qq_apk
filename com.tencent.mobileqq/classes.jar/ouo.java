import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity;

public class ouo
  implements bkzq
{
  public ouo(ReadInJoySettingActivity paramReadInJoySettingActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    ReadInJoySettingActivity.c(this.a).d(paramInt);
    ((TextView)this.a.findViewById(2131372832)).setText(ReadInJoySettingActivity.a(this.a)[paramInt]);
    pqu.a(Integer.toString(paramInt));
    olh.a(null, "", "0X8007416", "0X8007416", 0, 0, Integer.toString(paramInt), "", "", "", false);
    ReadInJoySettingActivity.c(this.a).cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ouo
 * JD-Core Version:    0.7.0.1
 */