import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;

public class rhb
  implements View.OnClickListener
{
  public rhb(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    if (!PhoneNumLoginImpl.a().a(this.a.app, this.a)) {}
    while ((this.a.b != null) && (this.a.b.isShowing())) {
      return;
    }
    AccountManageActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rhb
 * JD-Core Version:    0.7.0.1
 */