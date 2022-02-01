import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenPermission;

class ndy
  implements DialogInterface.OnClickListener
{
  ndy(ndx paramndx, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = BaseApplicationImpl.getContext();
    bdla.b(null, "dc00898", "", "", "0X800B038", "0X800B038", 0, 0, "", "", "", "");
    if (FloatingScreenPermission.requestPermission(paramDialogInterface))
    {
      this.jdField_a_of_type_Ndx.c = true;
      return;
    }
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ndy
 * JD-Core Version:    0.7.0.1
 */