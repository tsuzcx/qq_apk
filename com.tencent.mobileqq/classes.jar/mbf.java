import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qphone.base.util.QLog;

class mbf
  implements DialogInterface.OnDismissListener
{
  mbf(mbc parammbc, long paramLong) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    QLog.w("ShareChat", 1, "ActionSheet.onDismiss, mChoosedLinkType[" + this.jdField_a_of_type_Mbc.b + "], mIHandle[" + this.jdField_a_of_type_Mbc.jdField_a_of_type_Mbh + "], seq[" + this.jdField_a_of_type_Long + "]");
    if ((this.jdField_a_of_type_Mbc.b == -1) && (this.jdField_a_of_type_Mbc.jdField_a_of_type_Mbh != null)) {
      this.jdField_a_of_type_Mbc.a(this.jdField_a_of_type_Mbc.jdField_a_of_type_Int, this.jdField_a_of_type_Mbc.b, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mbf
 * JD-Core Version:    0.7.0.1
 */