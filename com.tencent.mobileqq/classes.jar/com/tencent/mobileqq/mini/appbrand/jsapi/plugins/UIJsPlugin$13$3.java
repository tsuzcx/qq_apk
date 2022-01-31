package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.view.View;
import bfol;
import bfoq;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class UIJsPlugin$13$3
  implements bfoq
{
  UIJsPlugin$13$3(UIJsPlugin.13 param13, bfol parambfol) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    try
    {
      paramView = new JSONObject();
      paramView.put("tapIndex", paramInt);
      this.this$1.this$0.jsPluginEngine.callbackJsEventOK(this.this$1.val$webview, this.this$1.val$event, paramView, this.this$1.val$callbackId);
      this.val$actionSheet.dismiss();
      return;
    }
    catch (JSONException paramView)
    {
      QLog.e("[mini] UIJsPlugin", 1, this.this$1.val$event + " error.", paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.UIJsPlugin.13.3
 * JD-Core Version:    0.7.0.1
 */