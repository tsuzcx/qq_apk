import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class pyr
  implements DialogInterface.OnDismissListener
{
  pyr(pyo parampyo) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (pyo.a(this.a) != null) {
      pyo.a(this.a).a(pyo.a(this.a), pyo.b(this.a), false, false);
    }
    pyo.a(this.a, true);
    pyo.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pyr
 * JD-Core Version:    0.7.0.1
 */