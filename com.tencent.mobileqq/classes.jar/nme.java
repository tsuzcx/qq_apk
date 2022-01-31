import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.view.Window;

class nme
  implements DialogInterface.OnShowListener
{
  nme(nma paramnma) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    nma.a(this.a).getWindow().clearFlags(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nme
 * JD-Core Version:    0.7.0.1
 */