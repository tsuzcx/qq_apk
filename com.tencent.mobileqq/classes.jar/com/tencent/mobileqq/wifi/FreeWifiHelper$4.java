package com.tencent.mobileqq.wifi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class FreeWifiHelper$4
  implements DialogInterface.OnClickListener
{
  FreeWifiHelper$4(FreeWifiHelper.FreeWifiDialogListener paramFreeWifiDialogListener, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a(3);
    paramDialogInterface.dismiss();
    paramInt = this.b;
    if (paramInt == 1)
    {
      FreeWifiHelper.a("0X80094FB");
      return;
    }
    if ((paramInt != 2) && (paramInt != 4) && (paramInt != 5))
    {
      if (paramInt == 3) {
        FreeWifiHelper.a("0X80094FC");
      }
    }
    else {
      FreeWifiHelper.a("0X80094FA");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wifi.FreeWifiHelper.4
 * JD-Core Version:    0.7.0.1
 */