package com.tencent.mobileqq.wifi;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class FreeWifiHelper$2
  implements DialogInterface.OnClickListener
{
  FreeWifiHelper$2(int paramInt, Activity paramActivity, FreeWifiDialogListener paramFreeWifiDialogListener) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramInt = 2;
    if (this.jdField_a_of_type_Int == 1)
    {
      FreeWifiHelper.b(this.jdField_a_of_type_AndroidAppActivity, 398668);
      FreeWifiHelper.a("0X80094F5");
      paramInt = 1;
    }
    for (;;)
    {
      FreeWifiHelper.c(this.jdField_a_of_type_AndroidAppActivity, paramInt);
      this.jdField_a_of_type_ComTencentMobileqqWifiFreeWifiDialogListener.a(1);
      paramDialogInterface.dismiss();
      return;
      if ((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 5))
      {
        FreeWifiHelper.b(this.jdField_a_of_type_AndroidAppActivity, 398668);
        FreeWifiHelper.a("0X80094F4");
        paramInt = 1;
      }
      else if (this.jdField_a_of_type_Int == 3)
      {
        FreeWifiHelper.b(this.jdField_a_of_type_AndroidAppActivity, 398671);
        FreeWifiHelper.a("0X80094F6");
      }
      else
      {
        if (this.jdField_a_of_type_Int == 4)
        {
          FreeWifiHelper.b(this.jdField_a_of_type_AndroidAppActivity, 398690);
          FreeWifiHelper.a("0X80094F4");
        }
        paramInt = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.wifi.FreeWifiHelper.2
 * JD-Core Version:    0.7.0.1
 */