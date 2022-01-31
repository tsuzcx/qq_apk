import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity;

public class nwu
  implements bfph
{
  public nwu(ReadInJoySettingActivity paramReadInJoySettingActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    ReadInJoySettingActivity.c(this.a).d(paramInt);
    ((TextView)this.a.findViewById(2131371651)).setText(ReadInJoySettingActivity.a(this.a)[paramInt]);
    onh.a(Integer.toString(paramInt));
    nol.a(null, "", "0X8007416", "0X8007416", 0, 0, Integer.toString(paramInt), "", "", "", false);
    ReadInJoySettingActivity.c(this.a).cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nwu
 * JD-Core Version:    0.7.0.1
 */