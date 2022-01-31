package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.widget.TimePickerView.OnConfirmListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class UIJsPlugin$8$1
  implements TimePickerView.OnConfirmListener
{
  UIJsPlugin$8$1(UIJsPlugin.8 param8) {}
  
  public void onTimeCancel()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      this.this$1.this$0.jsPluginEngine.callbackJsEventCancel(this.this$1.val$webview, this.this$1.val$event, localJSONObject, this.this$1.val$callbackId);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("[mini] UIJsPlugin", 1, this.this$1.val$event + " error.", localException);
    }
  }
  
  public void onTimeConfirm(String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("value", paramString1 + ":" + paramString2);
      this.this$1.this$0.jsPluginEngine.callbackJsEventOK(this.this$1.val$webview, this.this$1.val$event, localJSONObject, this.this$1.val$callbackId);
      return;
    }
    catch (JSONException paramString1)
    {
      QLog.e("[mini] UIJsPlugin", 1, this.this$1.val$event + " error.", paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.UIJsPlugin.8.1
 * JD-Core Version:    0.7.0.1
 */