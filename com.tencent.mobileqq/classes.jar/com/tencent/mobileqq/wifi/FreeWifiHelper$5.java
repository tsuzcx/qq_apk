package com.tencent.mobileqq.wifi;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

final class FreeWifiHelper$5
  implements Runnable
{
  FreeWifiHelper$5(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnClickListener paramOnClickListener3, int paramInt) {}
  
  public void run()
  {
    String str = this.a.getString(2131889635);
    DialogUtil.a(this.a, 0, this.b, this.c, this.d, this.e, str, this.f, this.g, this.h).show();
    int j = this.i;
    if (j == 1)
    {
      FreeWifiHelper.b(this.a, 398667);
      FreeWifiHelper.a("0X80094F2");
      return;
    }
    if ((j != 2) && (j != 5))
    {
      if (j == 3)
      {
        FreeWifiHelper.b(this.a, 398670);
        FreeWifiHelper.a("0X80094F3");
        return;
      }
      if (j == 4)
      {
        FreeWifiHelper.b(this.a, 398689);
        FreeWifiHelper.a("0X80094F1");
      }
    }
    else
    {
      FreeWifiHelper.b(this.a, 398667);
      FreeWifiHelper.a("0X80094F1");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wifi.FreeWifiHelper.5
 * JD-Core Version:    0.7.0.1
 */