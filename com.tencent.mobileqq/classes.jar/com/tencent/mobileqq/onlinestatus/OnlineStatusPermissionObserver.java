package com.tencent.mobileqq.onlinestatus;

import android.os.Bundle;
import mqq.observer.BusinessObserver;

public class OnlineStatusPermissionObserver
  implements BusinessObserver
{
  public void a(boolean paramBoolean, Bundle paramBundle) {}
  
  public void b(boolean paramBoolean, Bundle paramBundle) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt == 1)
    {
      a(paramBoolean, paramBundle);
      return;
    }
    if (paramInt == 2) {
      b(paramBoolean, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionObserver
 * JD-Core Version:    0.7.0.1
 */