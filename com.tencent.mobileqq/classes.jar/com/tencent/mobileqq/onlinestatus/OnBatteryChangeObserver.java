package com.tencent.mobileqq.onlinestatus;

import android.os.Bundle;
import mqq.observer.BusinessObserver;

public class OnBatteryChangeObserver
  implements BusinessObserver
{
  public void a(int paramInt) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt == 26364)
    {
      paramInt = 0;
      if (paramBundle != null) {
        paramInt = paramBundle.getInt("KEY_BATTERY", 0);
      }
      a(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnBatteryChangeObserver
 * JD-Core Version:    0.7.0.1
 */