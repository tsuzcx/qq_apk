import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qphone.base.util.QLog;

class lyv
  implements DialogInterface.OnDismissListener
{
  lyv(lys paramlys, long paramLong) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    QLog.w("ShareChat", 1, "ActionSheet.onDismiss, mChoosedLinkType[" + this.jdField_a_of_type_Lys.b + "], mIHandle[" + this.jdField_a_of_type_Lys.jdField_a_of_type_Lyx + "], seq[" + this.jdField_a_of_type_Long + "]");
    if ((this.jdField_a_of_type_Lys.b == -1) && (this.jdField_a_of_type_Lys.jdField_a_of_type_Lyx != null)) {
      this.jdField_a_of_type_Lys.a(this.jdField_a_of_type_Lys.jdField_a_of_type_Int, this.jdField_a_of_type_Lys.b, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lyv
 * JD-Core Version:    0.7.0.1
 */