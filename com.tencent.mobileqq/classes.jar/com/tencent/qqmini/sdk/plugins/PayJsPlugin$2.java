package com.tencent.qqmini.sdk.plugins;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.utils.MD5Utils;
import org.json.JSONObject;

class PayJsPlugin$2
  implements AsyncResult
{
  PayJsPlugin$2(PayJsPlugin paramPayJsPlugin, JSONObject paramJSONObject, RequestEvent paramRequestEvent) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    int i;
    String str1;
    String str2;
    String str3;
    Activity localActivity;
    if (paramBoolean)
    {
      i = paramJSONObject.optInt("result");
      str1 = paramJSONObject.optString("errMsg");
      str2 = paramJSONObject.optString("firstRefer");
      str3 = paramJSONObject.optString("firstVia");
      if (i == 1)
      {
        localActivity = PayJsPlugin.access$100(this.this$0).getAttachedActivity();
        if (localActivity == null) {}
      }
    }
    for (;;)
    {
      try
      {
        MiniAppInfo localMiniAppInfo = PayJsPlugin.access$200(this.this$0);
        str1 = "";
        if ((localMiniAppInfo == null) || (localMiniAppInfo.launchParam == null)) {
          break label433;
        }
        paramJSONObject = String.valueOf(localMiniAppInfo.launchParam.scene);
        if (localMiniAppInfo != null) {
          str1 = localMiniAppInfo.via;
        }
        PayJsPlugin.access$400(this.this$0, this.val$jsonObject, PayJsPlugin.access$300(this.this$0).appId, str2, str3, paramJSONObject, str1);
        i = this.val$jsonObject.optInt("setEnv", 0);
        this.val$jsonObject.put("setMidasEnv", i);
        if (localMiniAppInfo != null)
        {
          paramJSONObject = new StringBuilder();
          paramJSONObject.append(PayJsPlugin.access$500(this.this$0).appId);
          paramJSONObject.append("_");
          paramJSONObject.append(localMiniAppInfo.verType);
          paramJSONObject = paramJSONObject.toString();
          str1 = MD5Utils.encodeHexStr(paramJSONObject);
          PayJsPlugin.access$600(this.this$0).getSharedPreferences("keyMiniGamePayEnv", 4).edit().putString("keyMiniGamePayEnvAppidVertype", str1).commit();
          this.val$jsonObject.put("miniAppVertypeStr", paramJSONObject);
        }
      }
      catch (Exception paramJSONObject)
      {
        QMLog.i("PayJsPlugin", "setEnv error", paramJSONObject);
      }
      this.this$0.handleRechargeGame(this.val$req, localActivity, this.val$jsonObject.toString(), String.valueOf(this.val$req.callbackId), false);
      return;
      PayJsPlugin.access$700(this.this$0, this.val$req, null, "activity is null");
      return;
      if ((i == 0) || (i == 2))
      {
        AppBrandTask.runTaskOnUiThread(new PayJsPlugin.2.1(this, str1));
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("handleNativeRequest result = ");
        paramJSONObject.append(i);
        QMLog.e("PayJsPlugin", paramJSONObject.toString());
        PayJsPlugin.access$700(this.this$0, this.val$req, null, str1);
        return;
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("checkOfferId isSuc = ");
        paramJSONObject.append(paramBoolean);
        QMLog.e("PayJsPlugin", paramJSONObject.toString());
        PayJsPlugin.access$700(this.this$0, this.val$req, null, "checkOfferId fail");
      }
      return;
      label433:
      paramJSONObject = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.PayJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */