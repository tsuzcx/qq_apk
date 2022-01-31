import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class qko
  implements DialogInterface.OnDismissListener
{
  qko(qkl paramqkl) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (qkl.a(this.a) != null) {
      qkl.a(this.a).a(qkl.a(this.a), qkl.b(this.a), false, false);
    }
    qkl.a(this.a, true);
    qkl.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qko
 * JD-Core Version:    0.7.0.1
 */