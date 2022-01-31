package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.text.TextUtils;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class UIJsPlugin$17
  implements Runnable
{
  UIJsPlugin$17(UIJsPlugin paramUIJsPlugin, String paramString1, JsRuntime paramJsRuntime, String paramString2, int paramInt) {}
  
  public void run()
  {
    JSONObject localJSONObject = null;
    for (;;)
    {
      try
      {
        Object localObject2 = new JSONObject(this.val$jsonParams);
        int i = ((JSONObject)localObject2).optInt("htmlId");
        if (!((JSONObject)localObject2).has("src")) {
          break label272;
        }
        String str = ((JSONObject)localObject2).optString("src", "");
        if (((JSONObject)localObject2).has("position")) {
          localJSONObject = ((JSONObject)localObject2).optJSONObject("position");
        }
        boolean bool = ((JSONObject)localObject2).optBoolean("__skipDomainCheck__", false);
        localObject2 = this.this$0.jsPluginEngine.getWebviewContainer(this.val$webview);
        if (localObject2 != null)
        {
          if (!TextUtils.isEmpty(str))
          {
            if (this.this$0.jsPluginEngine.appBrandRuntime.getApkgInfo().isDomainValid(bool, str, 4)) {
              ((WebviewContainer)localObject2).updateHTMLWebView(i, str);
            }
          }
          else
          {
            if (localJSONObject != null) {
              ((WebviewContainer)localObject2).updateHTMLWebView(i, localJSONObject);
            }
            this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, null, this.val$callbackId);
            return;
          }
          QLog.e("[mini] UIJsPlugin", 1, "updateHTMLWebView domain valid : " + str);
          this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$event, null, "domain valid", this.val$callbackId);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        QLog.e("[mini] UIJsPlugin", 1, this.val$event + " error.", localJSONException);
        return;
      }
      this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$event, null, this.val$callbackId);
      return;
      label272:
      Object localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.UIJsPlugin.17
 * JD-Core Version:    0.7.0.1
 */