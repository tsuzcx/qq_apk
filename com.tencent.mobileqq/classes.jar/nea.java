import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class nea
  implements DialogInterface.OnClickListener
{
  nea(ndy paramndy, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    if (this.jdField_a_of_type_Ndy.a()) {
      return;
    }
    QLog.w(this.jdField_a_of_type_Ndy.a, 1, "showPermissionNormalDialog.gotoSetting, seq[" + this.jdField_a_of_type_Long + "]");
    nhs.a(this.jdField_a_of_type_Ndy.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     nea
 * JD-Core Version:    0.7.0.1
 */