import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qphone.base.util.QLog;

class lza
  implements DialogInterface.OnDismissListener
{
  lza(lyw paramlyw, long paramLong) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    QLog.w("ShareChat", 1, "ActionSheet.onDismiss, mChoosedLinkType[" + this.jdField_a_of_type_Lyw.b + "], mIHandle[" + this.jdField_a_of_type_Lyw.jdField_a_of_type_Lzb + "], seq[" + this.jdField_a_of_type_Long + "]");
    if ((this.jdField_a_of_type_Lyw.b == -1) && (this.jdField_a_of_type_Lyw.jdField_a_of_type_Lzb != null)) {
      this.jdField_a_of_type_Lyw.a(this.jdField_a_of_type_Lyw.jdField_a_of_type_Int, this.jdField_a_of_type_Lyw.b, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lza
 * JD-Core Version:    0.7.0.1
 */