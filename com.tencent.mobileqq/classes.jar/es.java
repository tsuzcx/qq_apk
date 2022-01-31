import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.data.PrinterItemMsgRecord;

class es
  implements DialogInterface.OnClickListener
{
  es(er paramer) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqDataPrinterItemMsgRecord.status < 10) {
      this.a.jdField_a_of_type_En.a.a(0, this.a.jdField_a_of_type_ComTencentMobileqqDataPrinterItemMsgRecord.uSessionID, true);
    }
    this.a.jdField_a_of_type_En.a.a.a(this.a.jdField_a_of_type_ComTencentMobileqqDataPrinterItemMsgRecord);
    this.a.jdField_a_of_type_En.b();
    this.a.jdField_a_of_type_En.notifyDataSetChanged();
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     es
 * JD-Core Version:    0.7.0.1
 */