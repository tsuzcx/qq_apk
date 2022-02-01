package com.tencent.mobileqq.wifi;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class FreeWifiHelper$2
  implements DialogInterface.OnClickListener
{
  FreeWifiHelper$2(int paramInt, Activity paramActivity, FreeWifiHelper.FreeWifiDialogListener paramFreeWifiDialogListener) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    int i = this.jdField_a_of_type_Int;
    paramInt = 2;
    if (i == 1)
    {
      FreeWifiHelper.b(this.jdField_a_of_type_AndroidAppActivity, 398668);
      FreeWifiHelper.a("0X80094F5");
    }
    for (;;)
    {
      paramInt = 1;
      break;
      if ((i != 2) && (i != 5))
      {
        if (i == 3)
        {
          FreeWifiHelper.b(this.jdField_a_of_type_AndroidAppActivity, 398671);
          FreeWifiHelper.a("0X80094F6");
          break;
        }
        if (i == 4)
        {
          FreeWifiHelper.b(this.jdField_a_of_type_AndroidAppActivity, 398690);
          FreeWifiHelper.a("0X80094F4");
        }
      }
      else
      {
        FreeWifiHelper.b(this.jdField_a_of_type_AndroidAppActivity, 398668);
        FreeWifiHelper.a("0X80094F4");
      }
    }
    FreeWifiHelper.c(this.jdField_a_of_type_AndroidAppActivity, paramInt);
    this.jdField_a_of_type_ComTencentMobileqqWifiFreeWifiHelper$FreeWifiDialogListener.a(1);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.wifi.FreeWifiHelper.2
 * JD-Core Version:    0.7.0.1
 */