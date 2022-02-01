import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.view.Window;

class nxv
  implements DialogInterface.OnShowListener
{
  nxv(nxr paramnxr) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    nxr.a(this.a).getWindow().clearFlags(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nxv
 * JD-Core Version:    0.7.0.1
 */