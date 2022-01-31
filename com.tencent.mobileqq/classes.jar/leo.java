import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnDismissListener;

public class leo
  implements ActionSheet.OnDismissListener
{
  public leo(ReadInJoySettingActivity paramReadInJoySettingActivity) {}
  
  public void onDismiss()
  {
    ReadInJoySettingActivity.c(this.a).cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     leo
 * JD-Core Version:    0.7.0.1
 */