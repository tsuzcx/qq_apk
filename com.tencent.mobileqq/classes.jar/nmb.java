import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.view.Window;

class nmb
  implements DialogInterface.OnShowListener
{
  nmb(nlx paramnlx) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    nlx.a(this.a).getWindow().clearFlags(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nmb
 * JD-Core Version:    0.7.0.1
 */