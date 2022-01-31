import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qphone.base.util.QLog;

class lod
  implements DialogInterface.OnDismissListener
{
  lod(loa paramloa, long paramLong) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    QLog.w("ShareChat", 1, "ActionSheet.onDismiss, mChoosedLinkType[" + this.jdField_a_of_type_Loa.b + "], mIHandle[" + this.jdField_a_of_type_Loa.jdField_a_of_type_Lof + "], seq[" + this.jdField_a_of_type_Long + "]");
    if ((this.jdField_a_of_type_Loa.b == -1) && (this.jdField_a_of_type_Loa.jdField_a_of_type_Lof != null)) {
      this.jdField_a_of_type_Loa.a(this.jdField_a_of_type_Loa.jdField_a_of_type_Int, this.jdField_a_of_type_Loa.b, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lod
 * JD-Core Version:    0.7.0.1
 */