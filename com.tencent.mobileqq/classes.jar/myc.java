import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class myc
  implements DialogInterface.OnDismissListener
{
  myc(mya parammya, Activity paramActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (!this.jdField_a_of_type_Mya.c)
    {
      if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
        this.jdField_a_of_type_AndroidAppActivity.finish();
      }
      return;
    }
    this.jdField_a_of_type_Mya.c = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     myc
 * JD-Core Version:    0.7.0.1
 */