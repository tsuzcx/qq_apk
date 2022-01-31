import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class lgx
  implements ActionSheet.OnButtonClickListener
{
  public lgx(ReadInJoySettingActivity paramReadInJoySettingActivity) {}
  
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
 * Qualified Name:     lgx
 * JD-Core Version:    0.7.0.1
 */