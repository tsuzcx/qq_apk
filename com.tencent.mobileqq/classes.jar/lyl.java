import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qphone.base.util.QLog;

class lyl
  implements DialogInterface.OnDismissListener
{
  lyl(lyh paramlyh, long paramLong) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    QLog.w("ShareChat", 1, "ActionSheet.onDismiss, mChoosedLinkType[" + this.jdField_a_of_type_Lyh.b + "], mIHandle[" + this.jdField_a_of_type_Lyh.jdField_a_of_type_Lym + "], seq[" + this.jdField_a_of_type_Long + "]");
    if ((this.jdField_a_of_type_Lyh.b == -1) && (this.jdField_a_of_type_Lyh.jdField_a_of_type_Lym != null)) {
      this.jdField_a_of_type_Lyh.a(this.jdField_a_of_type_Lyh.jdField_a_of_type_Int, this.jdField_a_of_type_Lyh.b, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lyl
 * JD-Core Version:    0.7.0.1
 */