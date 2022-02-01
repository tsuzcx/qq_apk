package com.tencent.qqmini.sdk.plugins;

import android.app.Activity;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONObject;

@JsPlugin
public class NativePageJsPlugin
  extends BaseJsPlugin
{
  private static final String TAG = "NativePageJsPlugin";
  
  private String getAppId()
  {
    if (this.mMiniAppContext.getMiniAppInfo() != null) {
      return this.mMiniAppContext.getMiniAppInfo().appId;
    }
    return "";
  }
  
  private Activity getAttachedActivity()
  {
    return this.mMiniAppContext.getAttachedActivity();
  }
  
  @JsEvent({"openNativePage"})
  public void openNativePage(RequestEvent paramRequestEvent)
  {
    Activity localActivity = getAttachedActivity();
    if (localActivity == null) {
      return;
    }
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject(paramRequestEvent.jsonParams);
        if (((JSONObject)localObject1).has("api_name"))
        {
          ((JSONObject)localObject1).optString("api_name");
          Object localObject2 = ((JSONObject)localObject1).optJSONObject("data");
          localObject1 = ((JSONObject)localObject2).optString("card_type");
          if (((String)localObject1).equals("public_account"))
          {
            i = 1;
          }
          else
          {
            if (!((String)localObject1).equals("group")) {
              break label187;
            }
            i = 2;
          }
          localObject2 = ((JSONObject)localObject2).optString("uin");
          String str = getAppId();
          ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).checkBindingState(str, (String)localObject2, i, new NativePageJsPlugin.1(this, localActivity, str, (String)localObject2, (String)localObject1, paramRequestEvent));
        }
        else
        {
          paramRequestEvent.fail("params error.");
          return;
        }
      }
      catch (Exception localException)
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramRequestEvent.event);
        ((StringBuilder)localObject1).append(" error.");
        QMLog.e("NativePageJsPlugin", ((StringBuilder)localObject1).toString(), localException);
        return;
      }
      label187:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.NativePageJsPlugin
 * JD-Core Version:    0.7.0.1
 */