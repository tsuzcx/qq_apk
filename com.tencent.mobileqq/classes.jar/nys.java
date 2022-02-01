import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;

public final class nys
  implements DialogInterface.OnClickListener
{
  public nys(Handler paramHandler) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.sendEmptyMessage(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nys
 * JD-Core Version:    0.7.0.1
 */