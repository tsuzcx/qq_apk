package com.tencent.mobileqq.observer;

import android.os.Bundle;
import mqq.observer.BusinessObserver;

public class GameCenterObserver
  implements BusinessObserver
{
  protected void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt == 10000) {
      a(paramBoolean, paramBundle.getBoolean("new"), paramBundle.getInt("gc_notify_type", 0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.observer.GameCenterObserver
 * JD-Core Version:    0.7.0.1
 */