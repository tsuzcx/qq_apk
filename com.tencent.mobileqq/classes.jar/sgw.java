import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.DialogActivity;

public class sgw
  implements DialogInterface.OnDismissListener
{
  public sgw(DialogActivity paramDialogActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sgw
 * JD-Core Version:    0.7.0.1
 */