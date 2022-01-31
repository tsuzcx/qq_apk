import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qphone.base.util.QLog;

class lyq
  implements DialogInterface.OnDismissListener
{
  lyq(lyn paramlyn, long paramLong) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    QLog.w("ShareChat", 1, "ActionSheet.onDismiss, mChoosedLinkType[" + this.jdField_a_of_type_Lyn.b + "], mIHandle[" + this.jdField_a_of_type_Lyn.jdField_a_of_type_Lys + "], seq[" + this.jdField_a_of_type_Long + "]");
    if ((this.jdField_a_of_type_Lyn.b == -1) && (this.jdField_a_of_type_Lyn.jdField_a_of_type_Lys != null)) {
      this.jdField_a_of_type_Lyn.a(this.jdField_a_of_type_Lyn.jdField_a_of_type_Int, this.jdField_a_of_type_Lyn.b, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lyq
 * JD-Core Version:    0.7.0.1
 */