package com.tencent.qqmini.sdk.core.plugins;

import bglv;
import bgok;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

class InternalJSPlugin$4
  implements AsyncResult
{
  InternalJSPlugin$4(InternalJSPlugin paramInternalJSPlugin, String paramString1, bgok parambgok, String paramString2, String paramString3) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      String str1 = paramJSONObject.optString("appName");
      String str2 = paramJSONObject.optString("packageName");
      String str3 = paramJSONObject.optString("nativeAppId");
      String str4 = paramJSONObject.optString("downloadUrl");
      int i = paramJSONObject.optInt("onlyOpen");
      InternalJSPlugin.access$100(this.this$0, this.this$0.mMiniAppContext.a(), str3, str2, str1, str4, i, this.val$appParameter, this.val$req);
      return;
    }
    this.val$req.a("jump check failed.");
    QMLog.w("InternalJSPlugin", String.format("jump native app check failed, appid:%s, packageName:%s", new Object[] { this.val$appConnectId, this.val$packageName }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.InternalJSPlugin.4
 * JD-Core Version:    0.7.0.1
 */