import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.dataline.util.PrinterSessionAdapter;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.PrinterHandler;
import com.tencent.mobileqq.data.PrinterItemMsgRecord;

class dj
  implements DialogInterface.OnClickListener
{
  dj(di paramdi) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqDataPrinterItemMsgRecord.status < 10) {
      this.a.jdField_a_of_type_ComDatalineUtilPrinterSessionAdapter.a.a(0, this.a.jdField_a_of_type_ComTencentMobileqqDataPrinterItemMsgRecord.uSessionID, true);
    }
    this.a.jdField_a_of_type_ComDatalineUtilPrinterSessionAdapter.a.a.a(this.a.jdField_a_of_type_ComTencentMobileqqDataPrinterItemMsgRecord);
    this.a.jdField_a_of_type_ComDatalineUtilPrinterSessionAdapter.b();
    this.a.jdField_a_of_type_ComDatalineUtilPrinterSessionAdapter.notifyDataSetChanged();
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     dj
 * JD-Core Version:    0.7.0.1
 */