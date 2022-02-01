import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;

class mxh
  implements DialogInterface.OnClickListener
{
  mxh(mxc parammxc, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      paramDialogInterface = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
      paramDialogInterface.setData(Uri.fromParts("package", this.jdField_a_of_type_AndroidAppActivity.getPackageName(), null));
      this.jdField_a_of_type_AndroidAppActivity.startActivity(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mxh
 * JD-Core Version:    0.7.0.1
 */