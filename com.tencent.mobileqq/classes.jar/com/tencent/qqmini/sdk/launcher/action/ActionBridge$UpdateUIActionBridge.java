package com.tencent.qqmini.sdk.launcher.action;

import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;

public class ActionBridge$UpdateUIActionBridge
  extends ActionBridge<Boolean>
{
  public static final int TOGGLE_DEBUG_PANEL = 2;
  public static final int TOGGLE_MONITOR_PANEL = 1;
  public static final int UPDATE_RED_DOT = 3;
  
  public static UpdateUIActionBridge obtain(int paramInt)
  {
    UpdateUIActionBridge localUpdateUIActionBridge = new UpdateUIActionBridge();
    localUpdateUIActionBridge.setRealAction(obtain("UpdateUIAction", paramInt, null));
    return localUpdateUIActionBridge;
  }
  
  public static Boolean toggleDebugPanel(IMiniAppContext paramIMiniAppContext)
  {
    return (Boolean)paramIMiniAppContext.performAction(obtain(2));
  }
  
  public static Boolean toggleMonitorPanel(IMiniAppContext paramIMiniAppContext)
  {
    return (Boolean)paramIMiniAppContext.performAction(obtain(1));
  }
  
  public static Boolean updateRedDot(IMiniAppContext paramIMiniAppContext)
  {
    return (Boolean)paramIMiniAppContext.performAction(obtain(3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.action.ActionBridge.UpdateUIActionBridge
 * JD-Core Version:    0.7.0.1
 */