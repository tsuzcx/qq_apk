import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenPermission;

class mxc
  implements DialogInterface.OnClickListener
{
  mxc(mxb parammxb, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = BaseApplicationImpl.getContext();
    bcst.b(null, "dc00898", "", "", "0X800B038", "0X800B038", 0, 0, "", "", "", "");
    if (FloatingScreenPermission.requestPermission(paramDialogInterface))
    {
      this.jdField_a_of_type_Mxb.c = true;
      return;
    }
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mxc
 * JD-Core Version:    0.7.0.1
 */