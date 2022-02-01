import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.view.Window;

class smk
  implements DialogInterface.OnShowListener
{
  smk(smg paramsmg, bkzi parambkzi) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    smg.a(this.jdField_a_of_type_Smg, "mShareActionSheet onShow()");
    this.jdField_a_of_type_Bkzi.getWindow().clearFlags(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     smk
 * JD-Core Version:    0.7.0.1
 */