import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.AuthDevActivity;

public class rnj
  implements DialogInterface.OnDismissListener
{
  public rnj(AuthDevActivity paramAuthDevActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (paramDialogInterface == AuthDevActivity.a(this.a)) {
      AuthDevActivity.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rnj
 * JD-Core Version:    0.7.0.1
 */