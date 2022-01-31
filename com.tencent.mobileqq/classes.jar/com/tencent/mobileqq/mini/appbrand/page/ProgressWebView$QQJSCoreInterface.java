package com.tencent.mobileqq.mini.appbrand.page;

import android.webkit.JavascriptInterface;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.JsPluginEngine;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

class ProgressWebView$QQJSCoreInterface
{
  private ProgressWebView$QQJSCoreInterface(ProgressWebView paramProgressWebView) {}
  
  @JavascriptInterface
  public String invokeHandler(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProgressWebView", 2, "invokeHandler : " + paramString1 + "; jsonParams : " + paramString2 + "； callbackId ： " + paramInt);
    }
    if ("preVerifyJSAPI".equals(paramString1)) {
      ProgressWebView.access$800(this.this$0, paramString1, null, paramInt);
    }
    for (;;)
    {
      return "";
      if ("invokeMiniProgramAPI".equals(paramString1))
      {
        try
        {
          paramString2 = new JSONObject(paramString2);
          if (ProgressWebView.access$100(this.this$0) == null) {
            break label143;
          }
          ProgressWebView.access$100(this.this$0).evaluateServiceSubcribeJS("onWebInvokeAppService", paramString2.toString());
          ProgressWebView.access$800(this.this$0, paramString1, null, paramInt);
        }
        catch (Exception paramString2)
        {
          ProgressWebView.access$900(this.this$0, paramString1, null, null, paramInt);
        }
        continue;
        label143:
        ProgressWebView.access$900(this.this$0, paramString1, null, null, paramInt);
      }
      else if ("checkJsApi".equals(paramString1))
      {
        try
        {
          Object localObject = new JSONObject(paramString2);
          paramString2 = new JSONObject();
          JSONObject localJSONObject = new JSONObject();
          localObject = ((JSONObject)localObject).optJSONArray("jsApiList");
          if (((JSONArray)localObject).length() > 0)
          {
            int i = 0;
            while (i < ((JSONArray)localObject).length())
            {
              localJSONObject.put(((JSONArray)localObject).get(i).toString(), true);
              i += 1;
            }
          }
          paramString2.put("checkResult", localJSONObject.toString());
          ProgressWebView.access$800(this.this$0, paramString1, paramString2, paramInt);
        }
        catch (Exception paramString2)
        {
          ProgressWebView.access$900(this.this$0, paramString1, null, null, paramInt);
        }
      }
      else if (ProgressWebView.access$100(this.this$0) != null)
      {
        ProgressWebView.access$100(this.this$0).jsPluginEngine.handleNativeRequest(paramString1, paramString2, (JsRuntime)ProgressWebView.access$500(this.this$0), paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.ProgressWebView.QQJSCoreInterface
 * JD-Core Version:    0.7.0.1
 */