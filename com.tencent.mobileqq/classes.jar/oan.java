import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class oan
  implements DialogInterface.OnClickListener
{
  oan(DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.onClick(paramDialogInterface, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oan
 * JD-Core Version:    0.7.0.1
 */