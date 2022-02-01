package com.tencent.qqmini.sdk.action;

import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.ICapsuleButton;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

@MiniKeep
public class UpdateUIAction
  implements Action<Boolean>
{
  private static final String TAG = "UpdateUIEvent";
  public static final int TOGGLE_DEBUG_PANEL = 2;
  public static final int TOGGLE_MONITOR_PANEL = 1;
  public static final int UPDATE_RED_DOT = 3;
  private int what;
  
  private static UpdateUIAction obtain(int paramInt)
  {
    UpdateUIAction localUpdateUIAction = new UpdateUIAction();
    localUpdateUIAction.what = paramInt;
    return localUpdateUIAction;
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
  
  public Boolean perform(BaseRuntime paramBaseRuntime)
  {
    paramBaseRuntime = paramBaseRuntime.getPage();
    if (paramBaseRuntime == null)
    {
      QMLog.e("UpdateUIEvent", "Failed to perform " + this + ". page is null");
      return Boolean.valueOf(false);
    }
    switch (this.what)
    {
    default: 
      return Boolean.valueOf(false);
    case 2: 
      return Boolean.valueOf(paramBaseRuntime.toggleDebugPanel());
    case 1: 
      return Boolean.valueOf(paramBaseRuntime.toggleMonitorPanel());
    }
    paramBaseRuntime = paramBaseRuntime.getCapsuleButton();
    if (paramBaseRuntime != null) {
      paramBaseRuntime.updateRedDotVisible();
    }
    return Boolean.valueOf(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.action.UpdateUIAction
 * JD-Core Version:    0.7.0.1
 */