import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

final class rtk
  implements DialogInterface.OnDismissListener
{
  rtk(DialogInterface.OnDismissListener paramOnDismissListener) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.onDismiss(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rtk
 * JD-Core Version:    0.7.0.1
 */