package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.mini.widget.MutiPickerView.OnConfirmListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class UIJsPlugin$6$1
  implements MutiPickerView.OnConfirmListener
{
  UIJsPlugin$6$1(UIJsPlugin.6 param6) {}
  
  public void onValCancel()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      this.this$1.this$0.jsPluginEngine.callbackJsEventCancel(this.this$1.val$webview, this.this$1.val$event, localJSONObject, this.this$1.val$callbackId);
      if (UIJsPlugin.access$200(this.this$1.this$0) != null) {
        UIJsPlugin.access$202(this.this$1.this$0, null);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("[mini] UIJsPlugin", 1, this.this$1.val$event + " error.", localException);
      }
    }
  }
  
  public void onValChange(int paramInt1, int paramInt2)
  {
    this.this$1.val$webview.evaluateSubcribeJS("onMultiPickerViewChange", String.format("{\"column\":%d,\"current\":%d}", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), this.this$1.val$webview.getPageWebViewId());
  }
  
  public void onValConfirm(int[] paramArrayOfInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      JSONArray localJSONArray = new JSONArray();
      int j = paramArrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        localJSONArray.put(paramArrayOfInt[i]);
        i += 1;
      }
      localJSONObject.put("current", localJSONArray);
      this.this$1.this$0.jsPluginEngine.callbackJsEventOK(this.this$1.val$webview, this.this$1.val$event, localJSONObject, this.this$1.val$callbackId);
    }
    catch (JSONException paramArrayOfInt)
    {
      for (;;)
      {
        QLog.e("[mini] UIJsPlugin", 1, this.this$1.val$event + " error.", paramArrayOfInt);
      }
    }
    if (UIJsPlugin.access$200(this.this$1.this$0) != null) {
      UIJsPlugin.access$202(this.this$1.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.UIJsPlugin.6.1
 * JD-Core Version:    0.7.0.1
 */