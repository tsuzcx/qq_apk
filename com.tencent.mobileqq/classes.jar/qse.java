import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.view.Window;

class qse
  implements DialogInterface.OnShowListener
{
  qse(qrw paramqrw) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    qrw.a(this.a, "mShareActionSheet onShow()");
    this.a.a.a.a().clearFlags(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qse
 * JD-Core Version:    0.7.0.1
 */