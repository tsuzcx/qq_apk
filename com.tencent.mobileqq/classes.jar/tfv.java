import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;
import com.tencent.widget.ActionSheet.OnDismissListener;

public class tfv
  implements ActionSheet.OnDismissListener
{
  public tfv(PhoneUnityBindInfoActivity paramPhoneUnityBindInfoActivity) {}
  
  public void onDismiss()
  {
    if (this.a.b) {
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tfv
 * JD-Core Version:    0.7.0.1
 */