import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.av.share.AVSchema;

public class lye
  implements DialogInterface.OnDismissListener
{
  public lye(AVSchema paramAVSchema) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (paramDialogInterface == this.a.a) {
      this.a.a = null;
    }
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lye
 * JD-Core Version:    0.7.0.1
 */