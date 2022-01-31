package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class UIJsPlugin$12$2
  implements DialogInterface.OnClickListener
{
  UIJsPlugin$12$2(UIJsPlugin.12 param12) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("cancel", true);
      this.this$1.this$0.jsPluginEngine.callbackJsEventOK(this.this$1.val$webview, this.this$1.val$event, localJSONObject, this.this$1.val$callbackId);
      if (paramDialogInterface != null) {
        paramDialogInterface.dismiss();
      }
      return;
    }
    catch (Exception paramDialogInterface)
    {
      QLog.e("[mini] UIJsPlugin", 1, "show modalView error." + paramDialogInterface);
      this.this$1.this$0.jsPluginEngine.callbackJsEventFail(this.this$1.val$webview, this.this$1.val$event, null, this.this$1.val$callbackId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.UIJsPlugin.12.2
 * JD-Core Version:    0.7.0.1
 */