import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

final class rhd
  implements DialogInterface.OnDismissListener
{
  rhd(DialogInterface.OnDismissListener paramOnDismissListener) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.onDismiss(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rhd
 * JD-Core Version:    0.7.0.1
 */