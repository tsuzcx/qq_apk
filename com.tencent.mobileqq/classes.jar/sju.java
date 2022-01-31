import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.DialogActivity;

public class sju
  implements DialogInterface.OnDismissListener
{
  public sju(DialogActivity paramDialogActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sju
 * JD-Core Version:    0.7.0.1
 */