package com.tencent.mobileqq.onlinestatus.observer;

import android.os.Bundle;
import mqq.observer.BusinessObserver;

public class OnAutoStatusBannerObserver
  implements BusinessObserver
{
  public void a() {}
  
  public void a(int paramInt) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt == 26372)
    {
      a(paramBundle.getInt("StatusId"));
      return;
    }
    if (paramInt == 26373) {
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.observer.OnAutoStatusBannerObserver
 * JD-Core Version:    0.7.0.1
 */