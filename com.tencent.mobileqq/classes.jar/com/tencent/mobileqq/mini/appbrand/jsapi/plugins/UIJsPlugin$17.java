package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import ajjy;
import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.AppBrandPageContainer;
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
    for (;;)
    {
      String str;
      int j;
      try
      {
        Object localObject = new JSONObject(this.val$jsonParams);
        boolean bool = ((JSONObject)localObject).optBoolean("__skipDomainCheck__", false);
        int i = ((JSONObject)localObject).optInt("htmlId");
        str = ((JSONObject)localObject).optString("src", "");
        j = this.this$0.jsPluginEngine.appBrandRuntime.getApkgInfo().getURLOpenType(str);
        if (j == 0)
        {
          localObject = ((AppBrandPageContainer)this.this$0.jsPluginEngine.appBrandRuntime.getContainer()).getPageByWebViewId(this.val$webview.getPageWebViewId());
          if (localObject == null) {
            break label325;
          }
          localObject = ((AbsAppBrandPage)localObject).getCurrentWebviewContainer();
          if (localObject == null) {
            break;
          }
          if ((!TextUtils.isEmpty(str)) && (this.this$0.jsPluginEngine.appBrandRuntime.getApkgInfo().isDomainValid(bool, str, 4)))
          {
            ((WebviewContainer)localObject).updateHTMLWebView(i, str);
            this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, null, this.val$callbackId);
            return;
          }
          this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$event, null, ajjy.a(2131650063), this.val$callbackId);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        QLog.e("[mini] UIJsPlugin", 1, this.val$event + " error.", localJSONException);
        return;
      }
      if (1 != j) {
        break;
      }
      Intent localIntent = new Intent(this.this$0.jsPluginEngine.appBrandRuntime.activity, QQBrowserActivity.class);
      localIntent.putExtra("selfSet_leftViewText", ajjy.a(2131650060));
      localIntent.putExtra("hide_more_button", true);
      localIntent.putExtra("hide_operation_bar", true);
      localIntent.putExtra("url", str);
      this.this$0.jsPluginEngine.appBrandRuntime.activity.startActivity(localIntent);
      return;
      label325:
      localIntent = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.UIJsPlugin.17
 * JD-Core Version:    0.7.0.1
 */