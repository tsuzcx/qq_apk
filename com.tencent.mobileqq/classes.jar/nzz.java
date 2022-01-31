import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity;

public class nzz
  implements bhqd
{
  public nzz(ReadInJoySettingActivity paramReadInJoySettingActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    ReadInJoySettingActivity.c(this.a).d(paramInt);
    ((TextView)this.a.findViewById(2131371968)).setText(ReadInJoySettingActivity.a(this.a)[paramInt]);
    ors.a(Integer.toString(paramInt));
    nrt.a(null, "", "0X8007416", "0X8007416", 0, 0, Integer.toString(paramInt), "", "", "", false);
    ReadInJoySettingActivity.c(this.a).cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nzz
 * JD-Core Version:    0.7.0.1
 */