package com.tencent.thumbplayer.tplayer.plugins.report;

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
    int j = 0;
    super.onSignalStrengthsChanged(paramSignalStrength);
    if (TPReportManager.access$3300() == null)
    {
      TPLogUtil.e("TPReportManager", "getSystemService TELEPHONY_SERVICE err.");
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        Object localObject = paramSignalStrength.toString().split(" ");
        i = TPReportManager.access$3300().getNetworkType();
        if ((i == 13) && (localObject.length > 9))
        {
          if (localObject[9].startsWith("ber="))
          {
            i = j;
            TPReportManager.access$3402(i);
            return;
          }
          i = TPCommonUtils.optInt(localObject[9], 0);
          continue;
          localObject = TPReportManager.access$3300().getNetworkOperator();
          i = j;
          if (localObject == null) {
            continue;
          }
          i = j;
          if (((String)localObject).startsWith("46000")) {
            continue;
          }
          i = j;
          if (((String)localObject).startsWith("46002")) {
            continue;
          }
          i = j;
          if (((String)localObject).startsWith("46007")) {
            continue;
          }
          if (((String)localObject).equals("46001"))
          {
            i = paramSignalStrength.getCdmaDbm();
            continue;
          }
          i = j;
          if (!((String)localObject).equals("46003")) {
            continue;
          }
          i = paramSignalStrength.getEvdoDbm();
          continue;
          i = paramSignalStrength.getGsmSignalStrength();
          i = i * 2 - 113;
          continue;
        }
        if (i == 8) {
          continue;
        }
      }
      catch (Throwable paramSignalStrength)
      {
        return;
      }
      if ((i != 10) && (i != 9)) {
        if (i != 3) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.tplayer.plugins.report.TPReportManager.1
 * JD-Core Version:    0.7.0.1
 */