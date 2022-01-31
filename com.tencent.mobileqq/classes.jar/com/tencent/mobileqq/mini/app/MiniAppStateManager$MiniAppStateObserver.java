package com.tencent.mobileqq.mini.app;

import java.util.Observable;
import java.util.Observer;

public class MiniAppStateManager$MiniAppStateObserver
  implements Observer
{
  public void onStateChange(MiniAppStateManager.MiniAppStateMsg paramMiniAppStateMsg) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof MiniAppStateManager.MiniAppStateMsg)) {
      onStateChange((MiniAppStateManager.MiniAppStateMsg)paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.MiniAppStateManager.MiniAppStateObserver
 * JD-Core Version:    0.7.0.1
 */