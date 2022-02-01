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
    if (paramInt == 1) {
      b(paramBoolean, paramBundle);
    }
    while (paramInt != 2) {
      return;
    }
    a(paramBoolean, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionObserver
 * JD-Core Version:    0.7.0.1
 */