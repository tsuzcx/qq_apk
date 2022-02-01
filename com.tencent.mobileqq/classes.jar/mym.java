import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenPermission;

class mym
  implements DialogInterface.OnClickListener
{
  mym(myl parammyl, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = BaseApplicationImpl.getContext();
    bcef.b(null, "dc00898", "", "", "0X800B038", "0X800B038", 0, 0, "", "", "", "");
    if (FloatingScreenPermission.requestPermission(paramDialogInterface))
    {
      this.jdField_a_of_type_Myl.c = true;
      return;
    }
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mym
 * JD-Core Version:    0.7.0.1
 */