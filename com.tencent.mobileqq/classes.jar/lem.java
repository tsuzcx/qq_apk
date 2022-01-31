import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnDismissListener;

public class lem
  implements ActionSheet.OnDismissListener
{
  public lem(ReadInJoySettingActivity paramReadInJoySettingActivity) {}
  
  public void onDismiss()
  {
    ReadInJoySettingActivity.b(this.a).cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lem
 * JD-Core Version:    0.7.0.1
 */