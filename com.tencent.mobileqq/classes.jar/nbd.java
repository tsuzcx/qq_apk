import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.view.Window;

class nbd
  implements DialogInterface.OnShowListener
{
  nbd(naz paramnaz) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    naz.a(this.a).getWindow().clearFlags(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nbd
 * JD-Core Version:    0.7.0.1
 */