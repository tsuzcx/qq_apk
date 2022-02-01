package com.tencent.qqmini.sdk.plugins;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.JSONUtil;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

@JsPlugin
public class SchemeJsPlugin
  extends BaseJsPlugin
{
  private static final String TAG = "SchemeJsPlugin";
  
  @JsEvent({"openScheme"})
  public void openScheme(RequestEvent paramRequestEvent)
  {
    Object localObject2 = this.mMiniAppContext.getAttachedActivity();
    if (localObject2 == null) {
      return;
    }
    try
    {
      Object localObject1 = new JSONObject(paramRequestEvent.jsonParams);
      if (((JSONObject)localObject1).has("api_name"))
      {
        String str = ((JSONObject)localObject1).optString("api_name");
        Object localObject3 = ((JSONObject)localObject1).optJSONObject("data");
        localObject1 = null;
        if (localObject3 != null) {
          localObject1 = JSONUtil.json2Params((JSONObject)localObject3);
        }
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(str);
        ((StringBuilder)localObject3).append("?");
        ((StringBuilder)localObject3).append((String)localObject1);
        localObject1 = ((StringBuilder)localObject3).toString();
        ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).openSchema((Context)localObject2, (String)localObject1, -1, new SchemeJsPlugin.1(this, new Handler(Looper.getMainLooper()), paramRequestEvent, (String)localObject1));
        return;
      }
      paramRequestEvent.fail("params error.");
      return;
    }
    catch (Exception localException)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramRequestEvent.event);
      ((StringBuilder)localObject2).append(" error.");
      QMLog.e("SchemeJsPlugin", ((StringBuilder)localObject2).toString(), localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.SchemeJsPlugin
 * JD-Core Version:    0.7.0.1
 */