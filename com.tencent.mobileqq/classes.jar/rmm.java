import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class rmm
  implements DialogInterface.OnDismissListener
{
  rmm(rmj paramrmj) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (rmj.a(this.a) != null) {
      rmj.a(this.a).a(rmj.a(this.a), rmj.b(this.a), false, false);
    }
    rmj.a(this.a, true);
    rmj.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rmm
 * JD-Core Version:    0.7.0.1
 */