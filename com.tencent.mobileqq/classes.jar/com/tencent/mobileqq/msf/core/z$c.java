package com.tencent.mobileqq.msf.core;

import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;

class z$c
  extends PhoneStateListener
{
  private z$c(z paramz) {}
  
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
    this.a.f = i;
    this.a.D();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.z.c
 * JD-Core Version:    0.7.0.1
 */