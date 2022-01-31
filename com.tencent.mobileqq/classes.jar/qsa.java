import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.view.Window;

class qsa
  implements DialogInterface.OnShowListener
{
  qsa(qrw paramqrw, bfol parambfol) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    qrw.a(this.jdField_a_of_type_Qrw, "mShareActionSheet onShow()");
    this.jdField_a_of_type_Bfol.getWindow().clearFlags(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qsa
 * JD-Core Version:    0.7.0.1
 */