import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class ley
  implements ActionSheet.OnButtonClickListener
{
  public ley(ReadInJoySettingActivity paramReadInJoySettingActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      ReadInJoySettingActivity.b(this.a).cancel();
      return;
      ReadInJoySettingActivity.d(this.a, false);
      ReadInJoySettingActivity.c(this.a, ReadInJoySettingActivity.c(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ley
 * JD-Core Version:    0.7.0.1
 */