package com.tencent.mobileqq.wifi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class FreeWifiHelper$4
  implements DialogInterface.OnClickListener
{
  FreeWifiHelper$4(FreeWifiDialogListener paramFreeWifiDialogListener, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWifiFreeWifiDialogListener.a(3);
    paramDialogInterface.dismiss();
    if (this.jdField_a_of_type_Int == 1) {
      FreeWifiHelper.a("0X80094FB");
    }
    do
    {
      return;
      if ((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 4) || (this.jdField_a_of_type_Int == 5))
      {
        FreeWifiHelper.a("0X80094FA");
        return;
      }
    } while (this.jdField_a_of_type_Int != 3);
    FreeWifiHelper.a("0X80094FC");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.wifi.FreeWifiHelper.4
 * JD-Core Version:    0.7.0.1
 */