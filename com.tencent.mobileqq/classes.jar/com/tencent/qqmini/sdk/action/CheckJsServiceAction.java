package com.tencent.qqmini.sdk.action;

import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.Action;

public class CheckJsServiceAction
  implements Action<Boolean>
{
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
    return ((Boolean)this.mMiniAppContext.performAction(this)).booleanValue();
  }
  
  public Boolean perform(BaseRuntime paramBaseRuntime)
  {
    paramBaseRuntime = paramBaseRuntime.getJsService();
    if (this.mJsService != paramBaseRuntime) {}
    for (boolean bool = true;; bool = false) {
      return Boolean.valueOf(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.action.CheckJsServiceAction
 * JD-Core Version:    0.7.0.1
 */