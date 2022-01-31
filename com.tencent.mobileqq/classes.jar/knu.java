import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;

public final class knu
  implements DialogInterface.OnClickListener
{
  public knu(Handler paramHandler) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.sendEmptyMessage(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     knu
 * JD-Core Version:    0.7.0.1
 */