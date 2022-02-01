import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qphone.base.util.QLog;

class lyy
  implements DialogInterface.OnDismissListener
{
  lyy(lyx paramlyx) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.w("ShareChat", 1, "ShareActionSheetBuilder.onDismiss, mChoosedChannel[" + this.a.jdField_a_of_type_Int + "], mIHandle[" + this.a.jdField_a_of_type_Lyz + "]");
    }
    if ((this.a.jdField_a_of_type_Int == -1) && (this.a.jdField_a_of_type_Lyz != null)) {
      this.a.a(this.a.jdField_a_of_type_Int, this.a.b, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     lyy
 * JD-Core Version:    0.7.0.1
 */