package com.tencent.qqmini.sdk.runtime.plugin;

import bekr;
import betc;
import bffa;
import org.json.JSONException;
import org.json.JSONObject;

class PickerJsPlugin$1$1
  implements bffa
{
  PickerJsPlugin$1$1(PickerJsPlugin.1 param1) {}
  
  public void onValCancel()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      this.this$1.val$req.b(localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      betc.d("PickerJsPlugin", "showPickerView error.", localException);
    }
  }
  
  public void onValConfirm(int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("index", paramInt);
      this.this$1.val$req.a(localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      betc.d("PickerJsPlugin", "showPickerView error.", localJSONException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.PickerJsPlugin.1.1
 * JD-Core Version:    0.7.0.1
 */