package com.tencent.qqmini.sdk.action;

import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.plugins.engine.JsPluginEngine;

public class PhoneNumberAction
  implements Action<Boolean>
{
  private PhoneNumberAction.PhoneNumberActionCallback callback;
  private RequestEvent req;
  
  public static PhoneNumberAction obtain(RequestEvent paramRequestEvent, PhoneNumberAction.PhoneNumberActionCallback paramPhoneNumberActionCallback)
  {
    PhoneNumberAction localPhoneNumberAction = new PhoneNumberAction();
    localPhoneNumberAction.callback = paramPhoneNumberActionCallback;
    localPhoneNumberAction.req = paramRequestEvent;
    return localPhoneNumberAction;
  }
  
  public Boolean perform(BaseRuntime paramBaseRuntime)
  {
    paramBaseRuntime = paramBaseRuntime.getJsPluginEngine();
    if ((paramBaseRuntime instanceof JsPluginEngine))
    {
      ((JsPluginEngine)paramBaseRuntime).showRequestPermissionDialog(this.req, this.callback);
      return Boolean.valueOf(true);
    }
    return Boolean.valueOf(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.action.PhoneNumberAction
 * JD-Core Version:    0.7.0.1
 */