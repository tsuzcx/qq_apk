package com.tencent.thumbplayer.tplayer.plugins.report;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.tencent.thumbplayer.utils.TPCommonUtils;
import com.tencent.thumbplayer.utils.TPLogUtil;

class TPReportManager$1
  extends PhoneStateListener
{
  TPReportManager$1(TPReportManager paramTPReportManager) {}
  
  public void onSignalStrengthsChanged(SignalStrength paramSignalStrength)
  {
    super.onSignalStrengthsChanged(paramSignalStrength);
    if (TPReportManager.access$3300(this.this$0) == null) {
      return;
    }
    Object localObject = (TelephonyManager)TPReportManager.access$3300(this.this$0).getSystemService("phone");
    if (localObject == null)
    {
      TPLogUtil.e("TPReportManager", "getSystemService TELEPHONY_SERVICE err.");
      return;
    }
    for (;;)
    {
      try
      {
        String[] arrayOfString = paramSignalStrength.toString().split(" ");
        i = ((TelephonyManager)localObject).getNetworkType();
        if ((i == 13) && (arrayOfString.length > 9))
        {
          i = TPCommonUtils.optInt(arrayOfString[9], 0);
          TPReportManager.access$3402(this.this$0, i);
          return;
        }
      }
      catch (Throwable paramSignalStrength)
      {
        TPLogUtil.e("TPReportManager", paramSignalStrength);
        return;
      }
      if ((i == 8) || (i == 10) || (i == 9) || (i == 3))
      {
        localObject = ((TelephonyManager)localObject).getNetworkOperator();
        if ((localObject != null) && (!((String)localObject).startsWith("46000")) && (!((String)localObject).startsWith("46002")))
        {
          if (((String)localObject).startsWith("46007"))
          {
            i = 0;
            continue;
          }
          if (((String)localObject).equals("46001"))
          {
            i = paramSignalStrength.getCdmaDbm();
            continue;
          }
          if (((String)localObject).equals("46003")) {
            i = paramSignalStrength.getEvdoDbm();
          }
        }
      }
      else
      {
        i = paramSignalStrength.getGsmSignalStrength();
        i = i * 2 - 113;
        continue;
      }
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.tplayer.plugins.report.TPReportManager.1
 * JD-Core Version:    0.7.0.1
 */