package com.tencent.qqmini.sdk.runtime;

import java.util.Observable;
import java.util.Observer;

public abstract class AppRuntimeEventCenter$RuntimeStateObserver
  implements Observer
{
  public abstract void onStateChange(AppRuntimeEventCenter.MiniAppStateMessage paramMiniAppStateMessage);
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof AppRuntimeEventCenter.MiniAppStateMessage)) {
      onStateChange((AppRuntimeEventCenter.MiniAppStateMessage)paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.AppRuntimeEventCenter.RuntimeStateObserver
 * JD-Core Version:    0.7.0.1
 */