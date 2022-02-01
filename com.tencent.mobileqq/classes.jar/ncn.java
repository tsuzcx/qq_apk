import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class ncn
  implements DialogInterface.OnClickListener
{
  ncn(ncl paramncl, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    if (this.jdField_a_of_type_Ncl.a()) {
      return;
    }
    QLog.w(this.jdField_a_of_type_Ncl.a, 1, "showPermissionNormalDialog.gotoSetting, seq[" + this.jdField_a_of_type_Long + "]");
    nfx.a(this.jdField_a_of_type_Ncl.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ncn
 * JD-Core Version:    0.7.0.1
 */