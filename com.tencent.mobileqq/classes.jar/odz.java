import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class odz
  implements DialogInterface.OnClickListener
{
  odz(DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.onClick(paramDialogInterface, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     odz
 * JD-Core Version:    0.7.0.1
 */