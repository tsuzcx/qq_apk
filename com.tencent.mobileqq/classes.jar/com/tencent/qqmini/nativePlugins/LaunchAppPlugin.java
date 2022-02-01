package com.tencent.qqmini.nativePlugins;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.service.gamecenter.AppLaucherHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import org.json.JSONObject;

@JsPlugin(secondary=true)
public class LaunchAppPlugin
  extends BaseJsPlugin
{
  @JsEvent({"launchApp"})
  public void launchApp(RequestEvent paramRequestEvent)
  {
    try
    {
      Object localObject = new JSONObject(paramRequestEvent.jsonParams).optJSONObject("data");
      paramRequestEvent = ((JSONObject)localObject).optString("gameAppID");
      String str1 = ((JSONObject)localObject).optString("packageName");
      String str2 = ((JSONObject)localObject).optString("flags");
      localObject = ((JSONObject)localObject).optString("paramsStr");
      AppLaucherHelper localAppLaucherHelper = new AppLaucherHelper();
      int j = 268435456;
      try
      {
        int k = Integer.parseInt(str2);
        if ((k & 0x4000000) == 67108864) {
          j = 335544320;
        }
        int i = j;
        if ((k & 0x20000000) == 536870912) {
          i = j | 0x20000000;
        }
        j = i;
        if ((k & 0x400000) == 4194304) {
          j = i | 0x400000;
        }
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("doAction error: ");
        localStringBuilder.append(localThrowable.getMessage());
        QLog.e("LaunchAppPlugin", 1, localStringBuilder.toString());
        j = 268435456;
      }
      localAppLaucherHelper.a(((BaseActivity)this.mMiniAppContext.getAttachedActivity()).getAppInterface(), this.mContext, paramRequestEvent, (String)localObject, str1, j);
      return;
    }
    catch (Throwable paramRequestEvent)
    {
      QLog.e("LaunchAppPlugin", 1, paramRequestEvent.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.LaunchAppPlugin
 * JD-Core Version:    0.7.0.1
 */