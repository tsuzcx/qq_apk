import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;

public final class nqi
  implements DialogInterface.OnClickListener
{
  public nqi(Handler paramHandler) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.sendEmptyMessage(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nqi
 * JD-Core Version:    0.7.0.1
 */