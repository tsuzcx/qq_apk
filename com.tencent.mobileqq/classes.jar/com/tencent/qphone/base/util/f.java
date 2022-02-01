package com.tencent.qphone.base.util;

import LBS.Cell;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import java.util.ArrayList;

final class f
  extends PhoneStateListener
{
  private short a = 0;
  
  public void onCellLocationChanged(CellLocation paramCellLocation)
  {
    if (paramCellLocation == null) {
      return;
    }
    try
    {
      if ((paramCellLocation instanceof GsmCellLocation))
      {
        e.a(new ArrayList());
        Cell localCell = new Cell();
        localCell.iLac = ((GsmCellLocation)paramCellLocation).getLac();
        localCell.iCellId = ((GsmCellLocation)paramCellLocation).getCid();
        String str = e.a().getNetworkOperator();
        if (str != null)
        {
          int i = str.length();
          if (i >= 5) {
            try
            {
              localCell.shMcc = Short.valueOf(str.substring(0, 3)).shortValue();
              localCell.shMnc = Short.valueOf(str.substring(3, 5)).shortValue();
            }
            catch (NumberFormatException localNumberFormatException)
            {
              localNumberFormatException.printStackTrace();
            }
          }
        }
        localCell.shRssi = this.a;
        if ((localCell.iLac != -1) && (localCell.iCellId != -1)) {
          e.b().add(0, localCell);
        }
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onCellLocationChanged exception:");
        localStringBuilder.append(localException.getMessage());
        QLog.i("LocationUtil", 2, localStringBuilder.toString());
      }
    }
    super.onCellLocationChanged(paramCellLocation);
  }
  
  public void onSignalStrengthsChanged(SignalStrength paramSignalStrength)
  {
    if (paramSignalStrength.isGsm())
    {
      if (paramSignalStrength.getGsmSignalStrength() != 99) {
        this.a = ((short)(paramSignalStrength.getGsmSignalStrength() * 2 - 113));
      } else {
        this.a = ((short)paramSignalStrength.getGsmSignalStrength());
      }
    }
    else {
      this.a = ((short)paramSignalStrength.getCdmaDbm());
    }
    super.onSignalStrengthsChanged(paramSignalStrength);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qphone.base.util.f
 * JD-Core Version:    0.7.0.1
 */