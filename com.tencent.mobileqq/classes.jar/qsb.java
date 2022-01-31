import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.view.Window;

class qsb
  implements DialogInterface.OnShowListener
{
  qsb(qrt paramqrt) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    qrt.a(this.a, "mShareActionSheet onShow()");
    this.a.a.a.a().clearFlags(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qsb
 * JD-Core Version:    0.7.0.1
 */