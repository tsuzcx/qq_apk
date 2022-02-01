package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

class InternalJSPlugin$5
  implements AsyncResult
{
  InternalJSPlugin$5(InternalJSPlugin paramInternalJSPlugin, String paramString1, RequestEvent paramRequestEvent, String paramString2, String paramString3) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      String str1 = paramJSONObject.optString("appName");
      String str2 = paramJSONObject.optString("packageName");
      String str3 = paramJSONObject.optString("nativeAppId");
      String str4 = paramJSONObject.optString("downloadUrl");
      int i = paramJSONObject.optInt("onlyOpen");
      InternalJSPlugin.access$600(this.this$0, InternalJSPlugin.access$500(this.this$0).getAttachedActivity(), str3, str2, str1, str4, i, this.val$appParameter, this.val$req);
      return;
    }
    paramJSONObject = InternalJSPlugin.access$700(this.this$0, 2);
    this.val$req.fail(paramJSONObject, "jump check failed.");
    QMLog.w("InternalJSPlugin", String.format("jump native app check failed, appid:%s, packageName:%s", new Object[] { this.val$appConnectId, this.val$packageName }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.InternalJSPlugin.5
 * JD-Core Version:    0.7.0.1
 */