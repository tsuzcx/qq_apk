package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import bjtz;
import com.tencent.mobileqq.mini.MiniAppInterface;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.app.AppLoaderFactory;
import com.tencent.mobileqq.mini.app.BaseAppLoaderManager;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class PayJsPlugin$4
  implements MiniAppCmdInterface
{
  PayJsPlugin$4(PayJsPlugin paramPayJsPlugin, JSONObject paramJSONObject, String paramString, int paramInt) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      int i = paramJSONObject.optInt("result");
      String str1 = paramJSONObject.optString("errMsg");
      String str3 = paramJSONObject.optString("firstRefer");
      String str4 = paramJSONObject.optString("firstVia");
      if (i == 1)
      {
        try
        {
          MiniAppInfo localMiniAppInfo = this.this$0.jsPluginEngine.getAppInfo();
          String str2 = "";
          str1 = "";
          paramJSONObject = str2;
          if (this.this$0.jsPluginEngine != null)
          {
            paramJSONObject = str2;
            if (this.this$0.jsPluginEngine.appBrandRuntime != null)
            {
              paramJSONObject = str2;
              if (this.this$0.jsPluginEngine.appBrandRuntime.getApkgInfo() != null)
              {
                paramJSONObject = str2;
                if (this.this$0.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig != null)
                {
                  paramJSONObject = str2;
                  if (this.this$0.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig.launchParam != null) {
                    paramJSONObject = String.valueOf(this.this$0.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig.launchParam.scene);
                  }
                }
              }
            }
          }
          if (localMiniAppInfo != null) {
            str1 = localMiniAppInfo.via;
          }
          PayJsPlugin.access$100(this.this$0, this.val$jsonObject, this.this$0.jsPluginEngine.appBrandRuntime.appId, str3, str4, paramJSONObject, str1);
          i = this.val$jsonObject.optInt("setEnv", 0);
          this.val$jsonObject.put("setMidasEnv", i);
          if (localMiniAppInfo != null)
          {
            paramJSONObject = this.this$0.jsPluginEngine.appBrandRuntime.appId + "_" + localMiniAppInfo.verType;
            str1 = bjtz.b(paramJSONObject);
            AppLoaderFactory.getAppLoaderManager().getMiniAppInterface().getApp().getSharedPreferences("keyMiniGamePayEnv", 4).edit().putString("keyMiniGamePayEnvAppidVertype", str1).commit();
            this.val$jsonObject.put("miniAppVertypeStr", paramJSONObject);
          }
        }
        catch (Exception paramJSONObject)
        {
          for (;;)
          {
            QLog.e("PayJsPlugin", 2, "setEnv error", paramJSONObject);
          }
        }
        this.this$0.handleRechargeGame(this.this$0.jsPluginEngine.getActivityContext(), this.val$eventName, this.val$jsonObject.toString(), String.valueOf(this.val$callbackId), this.val$callbackId, false);
      }
      while ((i != 0) && (i != 2)) {
        return;
      }
      AppBrandTask.runTaskOnUiThread(new PayJsPlugin.4.1(this, str1));
      QLog.e("PayJsPlugin", 1, "handleNativeRequest result = " + i);
      PayJsPlugin.access$200(this.this$0, this.val$callbackId, this.val$eventName, null, str1);
      return;
    }
    QLog.e("PayJsPlugin", 1, "checkOfferId isSuc = " + paramBoolean);
    PayJsPlugin.access$200(this.this$0, this.val$callbackId, this.val$eventName, null, "checkOfferId fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.PayJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */