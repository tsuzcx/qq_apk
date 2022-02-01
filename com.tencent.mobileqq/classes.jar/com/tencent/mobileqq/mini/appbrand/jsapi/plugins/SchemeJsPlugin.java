package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.ui.AppBrandLaunchUI;
import com.tencent.mobileqq.mini.util.JSONUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;
import org.json.JSONObject;

public class SchemeJsPlugin
  extends BaseJsPlugin
{
  private static final Set<String> S_EVENT_MAP = new SchemeJsPlugin.1();
  private static final String TAG = "SchemeJsPlugin";
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    Intent localIntent = null;
    QLog.d("SchemeJsPlugin", 2, "[handleNativeRequest] event=" + paramString1 + ", jsonParams=" + paramString2 + ", callbackId=" + paramInt);
    if ("openScheme".equals(paramString1)) {}
    for (;;)
    {
      try
      {
        paramString2 = new JSONObject(paramString2);
        if (!paramString2.has("api_name")) {
          continue;
        }
        String str = paramString2.optString("api_name");
        JSONObject localJSONObject = paramString2.optJSONObject("data");
        paramString2 = localIntent;
        if (localJSONObject != null) {
          paramString2 = JSONUtil.json2Params(localJSONObject);
        }
        paramString2 = str + "?" + paramString2;
        localIntent = new Intent(this.jsPluginEngine.appBrandRuntime.activity, AppBrandLaunchUI.class);
        localIntent.putExtra("from", "SchemeJsPlugin");
        localIntent.putExtra("scheme", paramString2);
        localIntent.putExtra("result_receiver", new SchemeJsPlugin.2(this, new Handler(Looper.getMainLooper()), paramJsRuntime, paramString1, paramInt, paramString2));
        this.jsPluginEngine.appBrandRuntime.activity.startActivity(localIntent);
      }
      catch (Exception paramString2)
      {
        QLog.e("SchemeJsPlugin", 1, paramString1 + " error.", paramString2);
        continue;
      }
      return "";
      this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, "params error.", paramInt);
    }
  }
  
  public Set<String> supportedEvents()
  {
    return S_EVENT_MAP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.SchemeJsPlugin
 * JD-Core Version:    0.7.0.1
 */