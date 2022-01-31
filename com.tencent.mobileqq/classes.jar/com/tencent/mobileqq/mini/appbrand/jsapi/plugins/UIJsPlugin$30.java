package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.util.JSONUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.mini.widget.MutiPickerView;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

class UIJsPlugin$30
  implements Runnable
{
  UIJsPlugin$30(UIJsPlugin paramUIJsPlugin, String paramString1, JsRuntime paramJsRuntime, String paramString2, int paramInt) {}
  
  public void run()
  {
    if (UIJsPlugin.access$200(this.this$0) != null) {}
    try
    {
      Object localObject = new JSONObject(this.val$jsonParams);
      int i = ((JSONObject)localObject).optInt("column");
      int j = ((JSONObject)localObject).optInt("current");
      localObject = ((JSONObject)localObject).optJSONArray("array");
      UIJsPlugin.access$200(this.this$0).setDisplayedValues(i, j, JSONUtil.jsonArrayToStringArray((JSONArray)localObject));
      this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, null, this.val$callbackId);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("[mini] UIJsPlugin", 1, this.val$event + " error.", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.UIJsPlugin.30
 * JD-Core Version:    0.7.0.1
 */