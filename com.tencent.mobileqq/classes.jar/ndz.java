import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class ndz
  implements DialogInterface.OnDismissListener
{
  ndz(ndx paramndx, Activity paramActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (!this.jdField_a_of_type_Ndx.c)
    {
      if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
        this.jdField_a_of_type_AndroidAppActivity.finish();
      }
      return;
    }
    this.jdField_a_of_type_Ndx.c = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ndz
 * JD-Core Version:    0.7.0.1
 */