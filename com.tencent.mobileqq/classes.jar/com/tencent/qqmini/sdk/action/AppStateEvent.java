package com.tencent.qqmini.sdk.action;

import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.Action;

public class AppStateEvent
  implements Action
{
  private Object obj;
  private int what;
  
  public static AppStateEvent obtain(int paramInt)
  {
    return obtain(paramInt, null);
  }
  
  public static AppStateEvent obtain(int paramInt, Object paramObject)
  {
    AppStateEvent localAppStateEvent = new AppStateEvent();
    localAppStateEvent.what = paramInt;
    localAppStateEvent.obj = paramObject;
    return localAppStateEvent;
  }
  
  public void notifyRuntime(IMiniAppContext paramIMiniAppContext)
  {
    if (paramIMiniAppContext != null) {
      paramIMiniAppContext.performAction(this);
    }
  }
  
  public Object perform(BaseRuntime paramBaseRuntime)
  {
    paramBaseRuntime.notifyRuntimeMsgObserver(this.what, this.obj);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.action.AppStateEvent
 * JD-Core Version:    0.7.0.1
 */