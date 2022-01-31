import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.data.PrinterItemMsgRecord;

class gj
  implements DialogInterface.OnClickListener
{
  gj(gi paramgi) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqDataPrinterItemMsgRecord.status < 10) {
      this.a.jdField_a_of_type_Ge.a.a(0, this.a.jdField_a_of_type_ComTencentMobileqqDataPrinterItemMsgRecord.uSessionID, true);
    }
    this.a.jdField_a_of_type_Ge.a.a.a(this.a.jdField_a_of_type_ComTencentMobileqqDataPrinterItemMsgRecord);
    this.a.jdField_a_of_type_Ge.b();
    this.a.jdField_a_of_type_Ge.notifyDataSetChanged();
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     gj
 * JD-Core Version:    0.7.0.1
 */