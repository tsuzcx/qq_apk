package com.tencent.qqmini.sdk.core.plugins;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import bgho;
import bgjw;
import bgkd;
import bgkk;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.utils.MD5Utils;
import org.json.JSONObject;

class PayJsPlugin$2
  implements AsyncResult
{
  PayJsPlugin$2(PayJsPlugin paramPayJsPlugin, JSONObject paramJSONObject, bgkd parambgkd) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      int i = paramJSONObject.optInt("result");
      String str1 = paramJSONObject.optString("errMsg");
      String str3 = paramJSONObject.optString("firstRefer");
      String str4 = paramJSONObject.optString("firstVia");
      if (i == 1)
      {
        localActivity = this.this$0.mMiniAppContext.a();
        if (localActivity != null)
        {
          try
          {
            localMiniAppInfo = this.this$0.mMiniAppInfo;
            str2 = "";
            str1 = "";
            paramJSONObject = str2;
            if (localMiniAppInfo != null)
            {
              paramJSONObject = str2;
              if (localMiniAppInfo.launchParam != null) {
                paramJSONObject = String.valueOf(localMiniAppInfo.launchParam.scene);
              }
            }
            if (localMiniAppInfo != null) {
              str1 = localMiniAppInfo.via;
            }
            PayJsPlugin.access$100(this.this$0, this.val$jsonObject, this.this$0.mMiniAppInfo.appId, str3, str4, paramJSONObject, str1);
            i = this.val$jsonObject.optInt("setEnv", 0);
            this.val$jsonObject.put("setMidasEnv", i);
            if (localMiniAppInfo != null)
            {
              paramJSONObject = this.this$0.mApkgInfo.appId + "_" + localMiniAppInfo.verType;
              str1 = MD5Utils.encodeHexStr(paramJSONObject);
              this.this$0.mContext.getSharedPreferences("keyMiniGamePayEnv", 4).edit().putString("keyMiniGamePayEnvAppidVertype", str1).commit();
              this.val$jsonObject.put("miniAppVertypeStr", paramJSONObject);
            }
          }
          catch (Exception paramJSONObject)
          {
            for (;;)
            {
              QMLog.i("PayJsPlugin", "setEnv error", paramJSONObject);
            }
          }
          this.this$0.handleRechargeGame(this.val$req, localActivity, this.val$jsonObject.toString(), String.valueOf(this.val$req.b), false);
        }
      }
      while ((i != 0) && (i != 2))
      {
        Activity localActivity;
        MiniAppInfo localMiniAppInfo;
        String str2;
        return;
        PayJsPlugin.access$200(this.this$0, this.val$req, null, "activity is null");
        return;
      }
      bgkk.a(new PayJsPlugin.2.1(this, str1));
      QMLog.e("PayJsPlugin", "handleNativeRequest result = " + i);
      PayJsPlugin.access$200(this.this$0, this.val$req, null, str1);
      return;
    }
    QMLog.e("PayJsPlugin", "checkOfferId isSuc = " + paramBoolean);
    PayJsPlugin.access$200(this.this$0, this.val$req, null, "checkOfferId fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.PayJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */