package com.tencent.mobileqq.wifi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class FreeWifiHelper$3
  implements DialogInterface.OnClickListener
{
  FreeWifiHelper$3(FreeWifiDialogListener paramFreeWifiDialogListener, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWifiFreeWifiDialogListener.a(2);
    paramDialogInterface.dismiss();
    if (this.jdField_a_of_type_Int == 1) {
      FreeWifiHelper.a("0X80094F8");
    }
    do
    {
      return;
      if ((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 4) || (this.jdField_a_of_type_Int == 5))
      {
        FreeWifiHelper.a("0X80094F7");
        return;
      }
    } while (this.jdField_a_of_type_Int != 3);
    FreeWifiHelper.a("0X80094F9");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.wifi.FreeWifiHelper.3
 * JD-Core Version:    0.7.0.1
 */