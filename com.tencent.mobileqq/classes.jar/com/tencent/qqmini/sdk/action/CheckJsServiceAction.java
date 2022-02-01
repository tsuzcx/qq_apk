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
    paramBaseRuntime = paramBaseRuntime.getJsService();
    int i = this.action;
    boolean bool2 = false;
    boolean bool1 = false;
    if (i != 1)
    {
      if (i != 2) {
        return Boolean.valueOf(false);
      }
      if (this.mJsService == paramBaseRuntime) {
        bool1 = true;
      }
      return Boolean.valueOf(bool1);
    }
    bool1 = bool2;
    if (this.mJsService != paramBaseRuntime) {
      bool1 = true;
    }
    return Boolean.valueOf(bool1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.action.CheckJsServiceAction
 * JD-Core Version:    0.7.0.1
 */