package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

class AppJsPlugin$6
  implements MiniAppCmdInterface
{
  AppJsPlugin$6(AppJsPlugin paramAppJsPlugin, JsRuntime paramJsRuntime, String paramString, int paramInt) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    Object localObject;
    if (paramBoolean)
    {
      localObject = paramJSONObject.optString("packageName");
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$eventName, null, "server error,packageName = null.", this.val$callbackId);
        QLog.w("AppJsPlugin", 1, "server error,packageName = null");
        return;
      }
      Iterator localIterator = this.this$0.jsPluginEngine.activityContext.getPackageManager().getInstalledPackages(0).iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        paramJSONObject = (PackageInfo)localIterator.next();
      } while ((paramJSONObject.packageName == null) || (!paramJSONObject.packageName.equals(localObject)));
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject();
        if (paramJSONObject != null)
        {
          ((JSONObject)localObject).put("installed", 1);
          paramJSONObject = ApiUtil.wrapCallbackOk(this.val$eventName, (JSONObject)localObject);
          this.val$webview.evaluateCallbackJs(this.val$callbackId, paramJSONObject.toString());
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$eventName, null, "isMicroAppInstalled exception\"", this.val$callbackId);
        QLog.w("AppJsPlugin", 1, "isMicroAppInstalled exception");
        return;
      }
      ((JSONObject)localObject).put("installed", 0);
      continue;
      this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$eventName, null, "getNativeAppInfoForJump failed.", this.val$callbackId);
      QLog.w("AppJsPlugin", 1, "getNativeAppInfoForJump failed");
      return;
      paramJSONObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.AppJsPlugin.6
 * JD-Core Version:    0.7.0.1
 */