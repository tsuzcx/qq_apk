package com.tencent.qqmini.sdk.action;

import com.tencent.qqmini.sdk.auth.AuthState;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.plugins.engine.JsPluginEngine;

public class CheckLocationAction
  implements Action<Boolean>
{
  private CheckLocationAction.CheckLocationPermissionCallback a;
  
  public static CheckLocationAction a(CheckLocationAction.CheckLocationPermissionCallback paramCheckLocationPermissionCallback)
  {
    CheckLocationAction localCheckLocationAction = new CheckLocationAction();
    localCheckLocationAction.a = paramCheckLocationPermissionCallback;
    return localCheckLocationAction;
  }
  
  public Boolean a(BaseRuntime paramBaseRuntime)
  {
    int i = MiniAppEnv.g().getAuthSate(paramBaseRuntime.getMiniAppInfo().appId).getAuthFlag("scope.userLocation");
    Boolean localBoolean = Boolean.valueOf(true);
    if (i == 2)
    {
      this.a.onCheckLocationPermissionAction(true);
      return localBoolean;
    }
    paramBaseRuntime = paramBaseRuntime.getJsPluginEngine();
    if ((paramBaseRuntime instanceof JsPluginEngine))
    {
      RequestEvent localRequestEvent = new RequestEvent();
      localRequestEvent.callbackId = this.a.hashCode();
      localRequestEvent.event = "getLocation";
      ((JsPluginEngine)paramBaseRuntime).showRequestPermissionDialog(localRequestEvent, new CheckLocationAction.1(this));
    }
    return localBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.action.CheckLocationAction
 * JD-Core Version:    0.7.0.1
 */