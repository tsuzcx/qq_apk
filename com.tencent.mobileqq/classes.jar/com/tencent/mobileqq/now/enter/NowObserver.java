package com.tencent.mobileqq.now.enter;

import android.os.Bundle;
import mqq.observer.BusinessObserver;

public class NowObserver
  implements BusinessObserver
{
  protected void a(boolean paramBoolean) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      a(true);
      return;
    }
    a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.now.enter.NowObserver
 * JD-Core Version:    0.7.0.1
 */