package com.tencent.qqmini.sdk.launcher.action;

import com.tencent.qqmini.sdk.launcher.core.IAppPageRouter;

public class ActionBridge$GetAppPageRouterActionBridge
  extends ActionBridge<IAppPageRouter>
{
  public static GetAppPageRouterActionBridge obtain()
  {
    GetAppPageRouterActionBridge localGetAppPageRouterActionBridge = new GetAppPageRouterActionBridge();
    localGetAppPageRouterActionBridge.setRealAction(obtain("GetAppPageRouterAction", 0, null));
    return localGetAppPageRouterActionBridge;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.action.ActionBridge.GetAppPageRouterActionBridge
 * JD-Core Version:    0.7.0.1
 */