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
    int i = 0;
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
    label246:
    for (;;)
    {
      int j;
      try
      {
        String[] arrayOfString = paramSignalStrength.toString().split(" ");
        j = ((TelephonyManager)localObject).getNetworkType();
        if ((j == 13) && (arrayOfString.length > 9))
        {
          if (arrayOfString[9].startsWith("ber="))
          {
            TPReportManager.access$3402(this.this$0, i);
            return;
          }
          i = TPCommonUtils.optInt(arrayOfString[9], 0);
          continue;
          localObject = ((TelephonyManager)localObject).getNetworkOperator();
          if ((localObject != null) && (!((String)localObject).startsWith("46000")) && (!((String)localObject).startsWith("46002")))
          {
            if (((String)localObject).startsWith("46007"))
            {
              i = 0;
              break label246;
            }
            if (((String)localObject).equals("46001"))
            {
              i = paramSignalStrength.getCdmaDbm();
              break label246;
            }
            if (((String)localObject).equals("46003"))
            {
              i = paramSignalStrength.getEvdoDbm();
              break label246;
              i = paramSignalStrength.getGsmSignalStrength();
              i = i * 2 - 113;
              continue;
            }
          }
          i = 0;
        }
      }
      catch (Throwable paramSignalStrength)
      {
        return;
      }
      if ((j != 8) && (j != 10) && (j != 9)) {
        if (j == 3) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.tplayer.plugins.report.TPReportManager.1
 * JD-Core Version:    0.7.0.1
 */