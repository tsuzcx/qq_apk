import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qphone.base.util.QLog;

class lye
  implements DialogInterface.OnDismissListener
{
  lye(lya paramlya, long paramLong) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    QLog.w("ShareChat", 1, "ActionSheet.onDismiss, mChoosedLinkType[" + this.jdField_a_of_type_Lya.b + "], mIHandle[" + this.jdField_a_of_type_Lya.jdField_a_of_type_Lyf + "], seq[" + this.jdField_a_of_type_Long + "]");
    if ((this.jdField_a_of_type_Lya.b == -1) && (this.jdField_a_of_type_Lya.jdField_a_of_type_Lyf != null)) {
      this.jdField_a_of_type_Lya.a(this.jdField_a_of_type_Lya.jdField_a_of_type_Int, this.jdField_a_of_type_Lya.b, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lye
 * JD-Core Version:    0.7.0.1
 */