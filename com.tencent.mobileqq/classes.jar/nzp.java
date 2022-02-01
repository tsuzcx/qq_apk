import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.view.Window;

class nzp
  implements DialogInterface.OnShowListener
{
  nzp(nzl paramnzl) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    nzl.a(this.a).getWindow().clearFlags(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nzp
 * JD-Core Version:    0.7.0.1
 */