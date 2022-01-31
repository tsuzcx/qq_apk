import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.AccountManageActivity;

public class rdx
  implements DialogInterface.OnDismissListener
{
  public rdx(AccountManageActivity paramAccountManageActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (paramDialogInterface == this.a.c) {
      this.a.c = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rdx
 * JD-Core Version:    0.7.0.1
 */