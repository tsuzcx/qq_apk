import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class mxd
  implements DialogInterface.OnDismissListener
{
  mxd(mxb parammxb, Activity paramActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (!this.jdField_a_of_type_Mxb.c)
    {
      if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
        this.jdField_a_of_type_AndroidAppActivity.finish();
      }
      return;
    }
    this.jdField_a_of_type_Mxb.c = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mxd
 * JD-Core Version:    0.7.0.1
 */