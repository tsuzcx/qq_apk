package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class AppJsPlugin$3
  implements AppJsPlugin.IWaldlCallback
{
  AppJsPlugin$3(AppJsPlugin paramAppJsPlugin, String paramString1, JsRuntime paramJsRuntime, int paramInt, String paramString2, boolean paramBoolean, String paramString3, String paramString4, String paramString5) {}
  
  public void onResult(boolean paramBoolean, Object paramObject)
  {
    QLog.i("AppJsPlugin", 1, "queryApkDownloadInfo succ=" + paramBoolean + " result=" + paramObject);
    if ((!paramBoolean) || (paramObject == null) || (!(paramObject instanceof JSONObject)))
    {
      paramObject = ApiUtil.wrapCallbackFail(this.val$eventName, null);
      this.val$webview.evaluateCallbackJs(this.val$callbackId, paramObject.toString());
      return;
    }
    paramObject = (JSONObject)paramObject;
    AppJsPlugin.access$000(this.this$0).startDownload(this.val$appid, paramObject, this.val$autoInstall, new AppJsPlugin.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.AppJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */