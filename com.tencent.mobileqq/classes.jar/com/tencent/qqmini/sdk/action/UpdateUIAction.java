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
    Object localObject = paramBaseRuntime.getPage();
    paramBaseRuntime = Boolean.valueOf(false);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Failed to perform ");
      ((StringBuilder)localObject).append(this);
      ((StringBuilder)localObject).append(". page is null");
      QMLog.e("UpdateUIEvent", ((StringBuilder)localObject).toString());
      return paramBaseRuntime;
    }
    int i = this.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return paramBaseRuntime;
        }
        paramBaseRuntime = ((IPage)localObject).getCapsuleButton();
        if (paramBaseRuntime != null) {
          paramBaseRuntime.updateRedDotVisible();
        }
        return Boolean.valueOf(true);
      }
      return Boolean.valueOf(((IPage)localObject).toggleDebugPanel());
    }
    return Boolean.valueOf(((IPage)localObject).toggleMonitorPanel());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.action.UpdateUIAction
 * JD-Core Version:    0.7.0.1
 */