import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.view.Window;

class qrx
  implements DialogInterface.OnShowListener
{
  qrx(qrt paramqrt, bfpc parambfpc) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    qrt.a(this.jdField_a_of_type_Qrt, "mShareActionSheet onShow()");
    this.jdField_a_of_type_Bfpc.getWindow().clearFlags(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qrx
 * JD-Core Version:    0.7.0.1
 */