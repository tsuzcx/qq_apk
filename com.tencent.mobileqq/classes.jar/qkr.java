import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class qkr
  implements DialogInterface.OnDismissListener
{
  qkr(qko paramqko) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (qko.a(this.a) != null) {
      qko.a(this.a).a(qko.a(this.a), qko.b(this.a), false, false);
    }
    qko.a(this.a, true);
    qko.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qkr
 * JD-Core Version:    0.7.0.1
 */