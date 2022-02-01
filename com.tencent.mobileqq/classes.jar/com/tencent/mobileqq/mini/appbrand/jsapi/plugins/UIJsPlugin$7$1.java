package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.text.TextUtils;
import com.tencent.mobileqq.mini.widget.DatePickerView.OnConfirmListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class UIJsPlugin$7$1
  implements DatePickerView.OnConfirmListener
{
  UIJsPlugin$7$1(UIJsPlugin.7 param7) {}
  
  public void onDateCancel()
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
  
  public void onDateConfirm(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (TextUtils.isEmpty(this.this$1.val$fields)) {
        paramString1 = paramString1 + "-" + paramString2 + "-" + paramString3;
      }
      for (;;)
      {
        localJSONObject.put("value", paramString1);
        this.this$1.this$0.jsPluginEngine.callbackJsEventOK(this.this$1.val$webview, this.this$1.val$event, localJSONObject, this.this$1.val$callbackId);
        return;
        if ("year".equals(this.this$1.val$fields)) {
          paramString1 = paramString1 + "";
        } else if ("month".equals(this.this$1.val$fields)) {
          paramString1 = paramString1 + "-" + paramString2;
        } else {
          paramString1 = paramString1 + "-" + paramString2 + "-" + paramString3;
        }
      }
      return;
    }
    catch (JSONException paramString1)
    {
      QLog.e("[mini] UIJsPlugin", 1, this.this$1.val$event + " error.", paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.UIJsPlugin.7.1
 * JD-Core Version:    0.7.0.1
 */