import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.AddAccountActivity;

public class rhk
  implements DialogInterface.OnDismissListener
{
  public rhk(AddAccountActivity paramAddAccountActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    AddAccountActivity.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rhk
 * JD-Core Version:    0.7.0.1
 */