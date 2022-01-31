package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.text.TextUtils;
import azgu;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class ContactJsPlugin$3
  implements MiniAppCmdInterface
{
  ContactJsPlugin$3(ContactJsPlugin paramContactJsPlugin, JsRuntime paramJsRuntime, String paramString, int paramInt) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramBoolean) && (paramJSONObject != null))
    {
      Object localObject = paramJSONObject.opt("robotUin");
      if (((localObject instanceof String)) && (!TextUtils.isEmpty((String)localObject)))
      {
        azgu.a(this.this$0.jsPluginEngine.appBrandRuntime.activity, null, (String)localObject);
        this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$eventName, paramJSONObject, this.val$callbackId);
        return;
      }
      this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$eventName, null, "batchGetContact failed.", this.val$callbackId);
      return;
    }
    QLog.e(ContactJsPlugin.access$100(), 1, "getRobotUin failed: ");
    this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$eventName, null, "batchGetContact failed.", this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.ContactJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */