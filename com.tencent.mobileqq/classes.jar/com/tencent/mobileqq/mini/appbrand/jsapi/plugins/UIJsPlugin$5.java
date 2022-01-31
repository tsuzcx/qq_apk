package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.util.JSONUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.mini.widget.PickerView;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class UIJsPlugin$5
  implements Runnable
{
  UIJsPlugin$5(UIJsPlugin paramUIJsPlugin, String paramString1, JsRuntime paramJsRuntime, String paramString2, int paramInt) {}
  
  public void run()
  {
    try
    {
      Object localObject2 = new JSONObject(this.val$jsonParams);
      Object localObject1 = ((JSONObject)localObject2).optJSONArray("array");
      int i = ((JSONObject)localObject2).optInt("current", 0);
      localObject2 = new PickerView(this.this$0.jsPluginEngine.getActivityContext());
      localObject1 = JSONUtil.jsonArrayToStringArray((JSONArray)localObject1);
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        ((PickerView)localObject2).setDisplayedValues((String[])localObject1);
        ((PickerView)localObject2).setMinValue(0);
        ((PickerView)localObject2).setMaxValues(localObject1.length - 1);
        ((PickerView)localObject2).setValue(i);
        ((PickerView)localObject2).init(i, new UIJsPlugin.5.1(this));
      }
      ((PickerView)localObject2).show();
      return;
    }
    catch (JSONException localJSONException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("[mini] UIJsPlugin", 2, localJSONException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.UIJsPlugin.5
 * JD-Core Version:    0.7.0.1
 */