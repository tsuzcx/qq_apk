import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.lebasearch.Utils;
import com.tencent.mobileqq.app.BusinessObserver;

public final class nyq
  implements DialogInterface.OnClickListener
{
  public nyq(int paramInt, BusinessObserver paramBusinessObserver, Context paramContext, aady paramaady, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      if (this.jdField_a_of_type_Int == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver.onUpdate(17, false, null);
        paramDialogInterface.dismiss();
        return;
      }
      Utils.sendPluginSetMessage(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Aady, this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver, this.jdField_a_of_type_Long, false);
      return;
    }
    if (this.jdField_a_of_type_Int == 1)
    {
      Utils.sendPluginSetMessage(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Aady, this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver, this.jdField_a_of_type_Long, true);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver.onUpdate(17, false, null);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nyq
 * JD-Core Version:    0.7.0.1
 */