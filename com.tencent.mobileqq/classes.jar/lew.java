import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class lew
  implements ActionSheet.OnButtonClickListener
{
  public lew(ReadInJoySettingActivity paramReadInJoySettingActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      ReadInJoySettingActivity.a(this.a).cancel();
      return;
      ReadInJoySettingActivity.a(this.a, false);
      ReadInJoySettingActivity.b(this.a, ReadInJoySettingActivity.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lew
 * JD-Core Version:    0.7.0.1
 */