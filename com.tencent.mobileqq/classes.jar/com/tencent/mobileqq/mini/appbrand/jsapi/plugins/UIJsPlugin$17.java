package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.text.TextUtils;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import org.json.JSONException;
import org.json.JSONObject;

class UIJsPlugin$17
  implements Runnable
{
  UIJsPlugin$17(UIJsPlugin paramUIJsPlugin, String paramString1, JsRuntime paramJsRuntime, String paramString2, int paramInt) {}
  
  public void run()
  {
    Object localObject2 = null;
    for (;;)
    {
      try
      {
        Object localObject3 = new JSONObject(this.val$jsonParams);
        int i = ((JSONObject)localObject3).optInt("htmlId");
        if (!((JSONObject)localObject3).has("src")) {
          break label352;
        }
        String str = ((JSONObject)localObject3).optString("src", "");
        if (((JSONObject)localObject3).has("position")) {
          localObject2 = ((JSONObject)localObject3).optJSONObject("position");
        }
        boolean bool1 = ((JSONObject)localObject3).optBoolean("__skipDomainCheck__", false);
        WebviewContainer localWebviewContainer = this.this$0.jsPluginEngine.getWebviewContainer(this.val$webview);
        if (localWebviewContainer != null)
        {
          if (!TextUtils.isEmpty(str))
          {
            boolean bool2 = AppBrandUtil.isOpenUrlFilter(str);
            if ((this.this$0.jsPluginEngine.appBrandRuntime.getApkgInfo().isDomainValid(bool1, str, 4)) && (!bool2)) {
              localWebviewContainer.updateHTMLWebView(i, str);
            }
          }
          else
          {
            if (localObject2 != null) {
              localWebviewContainer.updateHTMLWebView(i, (JSONObject)localObject2);
            }
            this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, null, this.val$callbackId);
            return;
          }
          localObject3 = QzoneConfig.getInstance().getConfig("qqminiapp", "https://m.q.qq.com/webview/error?url={url}&appid={appid}", "https://m.q.qq.com/webview/error?url={url}&appid={appid}");
          localObject2 = localObject3;
          if (!TextUtils.isEmpty((CharSequence)localObject3)) {
            localObject2 = ((String)localObject3).replace("{url}", str).replace("{appid}", this.this$0.jsPluginEngine.appBrandRuntime.appId);
          }
          localWebviewContainer.updateHTMLWebView(i, (String)localObject2);
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
      label352:
      Object localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.UIJsPlugin.17
 * JD-Core Version:    0.7.0.1
 */