package com.tencent.qqmini.sdk.plugins;

import android.app.Activity;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

class NativePageJsPlugin$1
  implements AsyncResult
{
  NativePageJsPlugin$1(NativePageJsPlugin paramNativePageJsPlugin, Activity paramActivity, String paramString1, String paramString2, String paramString3, RequestEvent paramRequestEvent) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean) {
      try
      {
        localObject = new JSONObject();
        int i = paramJSONObject.optInt("key_check_State");
        ((JSONObject)localObject).put("bindingState", i);
        if (i != 0)
        {
          ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).openNativePage(this.val$activity, this.val$appId, this.val$uin, this.val$cardType);
          this.val$req.ok((JSONObject)localObject);
          return;
        }
        this.val$req.fail(paramJSONObject, "fail no permission");
        return;
      }
      catch (Throwable paramJSONObject)
      {
        QMLog.e("NativePageJsPlugin", "handleCheckBindingState exception: ", paramJSONObject);
        ApiUtil.wrapCallbackFail(this.val$req.event, null);
        return;
      }
    }
    long l = paramJSONObject.optLong("retCode");
    Object localObject = paramJSONObject.optString("errMsg");
    QMLog.e("NativePageJsPlugin", "handleCheckBindingState fail, retCode: " + l + "; errMsg : " + (String)localObject);
    this.val$req.fail(paramJSONObject, "null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.NativePageJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */