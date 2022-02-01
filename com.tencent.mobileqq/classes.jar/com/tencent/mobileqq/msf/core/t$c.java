package com.tencent.mobileqq.msf.core;

import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;

class t$c
  extends PhoneStateListener
{
  private t$c(t paramt) {}
  
  public void onSignalStrengthsChanged(SignalStrength paramSignalStrength)
  {
    super.onSignalStrengthsChanged(paramSignalStrength);
    int i = paramSignalStrength.getCdmaDbm();
    this.a.g = i;
    int j = paramSignalStrength.getGsmSignalStrength();
    i = j;
    if (j == 99) {
      i = -3;
    }
    paramSignalStrength = this.a;
    paramSignalStrength.f = i;
    paramSignalStrength.D();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.t.c
 * JD-Core Version:    0.7.0.1
 */