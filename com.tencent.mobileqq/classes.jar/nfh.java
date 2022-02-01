import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class nfh
  implements DialogInterface.OnClickListener
{
  nfh(nff paramnff, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    if (this.jdField_a_of_type_Nff.a()) {}
    do
    {
      return;
      paramDialogInterface = this.jdField_a_of_type_Nff.a();
      QLog.w(this.jdField_a_of_type_Nff.a, 1, "showPermissionNormalDialog.gotoSetting, seq[" + this.jdField_a_of_type_Long + "], activity[" + paramDialogInterface + "]");
    } while (paramDialogInterface == null);
    njh.a(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nfh
 * JD-Core Version:    0.7.0.1
 */