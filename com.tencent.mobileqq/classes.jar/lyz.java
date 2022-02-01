import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qphone.base.util.QLog;

class lyz
  implements DialogInterface.OnDismissListener
{
  lyz(lyw paramlyw) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.w("ShareChat", 1, "ShareActionSheetBuilder.onDismiss, mChoosedChannel[" + this.a.jdField_a_of_type_Int + "], mIHandle[" + this.a.jdField_a_of_type_Lzb + "]");
    }
    if ((this.a.jdField_a_of_type_Int == -1) && (this.a.jdField_a_of_type_Lzb != null)) {
      this.a.a(this.a.jdField_a_of_type_Int, this.a.b, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lyz
 * JD-Core Version:    0.7.0.1
 */