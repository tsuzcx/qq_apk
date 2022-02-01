package com.tencent.mobileqq.onlinestatus.weather;

import android.os.Bundle;
import mqq.observer.BusinessObserver;

public class WeatherObserver
  implements BusinessObserver
{
  public void a(boolean paramBoolean, Bundle paramBundle) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt == 1) {
      a(paramBoolean, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.weather.WeatherObserver
 * JD-Core Version:    0.7.0.1
 */