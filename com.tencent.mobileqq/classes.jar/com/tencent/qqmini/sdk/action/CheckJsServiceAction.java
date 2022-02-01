package com.tencent.qqmini.sdk.action;

import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.Action;

public class CheckJsServiceAction
  implements Action<Boolean>
{
  private static final int IS_PAGEWEBVIEW_CALL = 1;
  private static final int IS_SERVICE_OR_MAINCONTEXT_CALL = 2;
  private int action = -1;
  private IJsService mJsService;
  private IMiniAppContext mMiniAppContext;
  
  public static CheckJsServiceAction obtain(IMiniAppContext paramIMiniAppContext)
  {
    CheckJsServiceAction localCheckJsServiceAction = new CheckJsServiceAction();
    localCheckJsServiceAction.mMiniAppContext = paramIMiniAppContext;
    return localCheckJsServiceAction;
  }
  
  public boolean isPageWebviewCall(IJsService paramIJsService)
  {
    this.mJsService = paramIJsService;
    this.action = 1;
    return ((Boolean)this.mMiniAppContext.performAction(this)).booleanValue();
  }
  
  public boolean isServiceOrMainContext(IJsService paramIJsService)
  {
    this.mJsService = paramIJsService;
    this.action = 2;
    return ((Boolean)this.mMiniAppContext.performAction(this)).booleanValue();
  }
  
  public Boolean perform(BaseRuntime paramBaseRuntime)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramBaseRuntime = paramBaseRuntime.getJsService();
    switch (this.action)
    {
    default: 
      return Boolean.valueOf(false);
    case 1: 
      if (this.mJsService != paramBaseRuntime) {}
      for (;;)
      {
        return Boolean.valueOf(bool1);
        bool1 = false;
      }
    }
    if (this.mJsService == paramBaseRuntime) {}
    for (bool1 = bool2;; bool1 = false) {
      return Boolean.valueOf(bool1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.action.CheckJsServiceAction
 * JD-Core Version:    0.7.0.1
 */