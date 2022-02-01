package com.tencent.mobileqq.wifi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class FreeWifiHelper$3
  implements DialogInterface.OnClickListener
{
  FreeWifiHelper$3(FreeWifiHelper.FreeWifiDialogListener paramFreeWifiDialogListener, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWifiFreeWifiHelper$FreeWifiDialogListener.a(2);
    paramDialogInterface.dismiss();
    paramInt = this.jdField_a_of_type_Int;
    if (paramInt == 1)
    {
      FreeWifiHelper.a("0X80094F8");
      return;
    }
    if ((paramInt != 2) && (paramInt != 4) && (paramInt != 5))
    {
      if (paramInt == 3) {
        FreeWifiHelper.a("0X80094F9");
      }
    }
    else {
      FreeWifiHelper.a("0X80094F7");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.wifi.FreeWifiHelper.3
 * JD-Core Version:    0.7.0.1
 */