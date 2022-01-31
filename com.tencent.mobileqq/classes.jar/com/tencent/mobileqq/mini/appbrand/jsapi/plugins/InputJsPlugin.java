package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;
import org.json.JSONObject;

public class InputJsPlugin
  extends BaseJsPlugin
{
  private static final String EVENT_UPDATE_INPUT = "updateInput";
  private static final String TAG = "[mini] InputJsPlugin";
  Set<String> eventMap = null;
  public long lastShowInputTime;
  
  public InputJsPlugin()
  {
    this.eventMap.add("showKeyboard");
    this.eventMap.add("hideKeyboard");
    this.eventMap.add("updateInput");
    this.eventMap.add("setKeyboardValue");
  }
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    QLog.d("[mini] InputJsPlugin", 2, "handleNativeRequest: " + paramString1 + " |jsonParams: " + paramString2 + " |callbackId:" + paramInt);
    if ("showKeyboard".equals(paramString1)) {}
    for (;;)
    {
      try
      {
        int i = new JSONObject(paramString2).optInt("inputId");
        if (i <= 0) {
          continue;
        }
        AppBrandTask.runTaskOnUiThread(new InputJsPlugin.1(this, paramJsRuntime, i, paramInt));
      }
      catch (Exception paramString2)
      {
        QLog.e("[mini] InputJsPlugin", 2, paramString1 + " error.", paramString2);
        continue;
      }
      return "";
      if (System.currentTimeMillis() - this.lastShowInputTime > 1000L)
      {
        this.lastShowInputTime = System.currentTimeMillis();
        AppBrandTask.runTaskOnUiThreadDelay(new InputJsPlugin.2(this, paramJsRuntime, paramString2, paramInt), 200L);
        continue;
        if ("hideKeyboard".equals(paramString1)) {
          AppBrandTask.runTaskOnUiThread(new InputJsPlugin.3(this, paramString2, paramJsRuntime, paramString1, paramInt));
        } else if ("updateInput".equals(paramString1)) {
          AppBrandTask.runTaskOnUiThread(new InputJsPlugin.4(this, paramString2, paramJsRuntime, paramString1, paramInt));
        } else if ("setKeyboardValue".equals(paramString1)) {
          AppBrandTask.runTaskOnUiThread(new InputJsPlugin.5(this, paramJsRuntime, paramString2, paramInt));
        }
      }
    }
  }
  
  public Set<String> supportedEvents()
  {
    return this.eventMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.InputJsPlugin
 * JD-Core Version:    0.7.0.1
 */