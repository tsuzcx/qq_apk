import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class nlz
  implements DialogInterface.OnClickListener
{
  nlz(nlx paramnlx, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    if (this.jdField_a_of_type_Nlx.a()) {}
    do
    {
      return;
      paramDialogInterface = this.jdField_a_of_type_Nlx.a();
      QLog.w(this.jdField_a_of_type_Nlx.a, 1, "showPermissionNormalDialog.gotoSetting, seq[" + this.jdField_a_of_type_Long + "], activity[" + paramDialogInterface + "]");
    } while (paramDialogInterface == null);
    nqf.a(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nlz
 * JD-Core Version:    0.7.0.1
 */