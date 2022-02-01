package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.util.JSONUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.mini.widget.MutiPickerView;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class UIJsPlugin$6
  implements Runnable
{
  UIJsPlugin$6(UIJsPlugin paramUIJsPlugin, String paramString1, JsRuntime paramJsRuntime, String paramString2, int paramInt) {}
  
  public void run()
  {
    try
    {
      Object localObject = new JSONObject(this.val$jsonParams);
      int[] arrayOfInt = JSONUtil.jsonArrayToIntArray(((JSONObject)localObject).optJSONArray("current"));
      localObject = JSONUtil.jsonArrayToMutiStringArray((JSONObject)localObject, "array");
      if (UIJsPlugin.access$200(this.this$0) == null) {
        UIJsPlugin.access$202(this.this$0, new MutiPickerView(this.this$0.jsPluginEngine.getActivityContext()));
      }
      UIJsPlugin.access$200(this.this$0).setDisplayedValues((String[][])localObject);
      UIJsPlugin.access$200(this.this$0).setCurrentIndex(arrayOfInt);
      UIJsPlugin.access$200(this.this$0).setOnConfirmListener(new UIJsPlugin.6.1(this));
      UIJsPlugin.access$200(this.this$0).show();
      return;
    }
    catch (JSONException localJSONException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("[mini] UIJsPlugin", 2, localJSONException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.UIJsPlugin.6
 * JD-Core Version:    0.7.0.1
 */