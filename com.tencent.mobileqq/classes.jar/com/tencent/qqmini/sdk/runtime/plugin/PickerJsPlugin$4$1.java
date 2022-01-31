package com.tencent.qqmini.sdk.runtime.plugin;

import bdfz;
import bdnw;
import bdxu;
import org.json.JSONException;
import org.json.JSONObject;

class PickerJsPlugin$4$1
  implements bdxu
{
  PickerJsPlugin$4$1(PickerJsPlugin.4 param4) {}
  
  public void onTimeCancel()
  {
    try
    {
      this.this$1.val$req.c();
      return;
    }
    catch (Exception localException)
    {
      bdnw.d("PickerJsPlugin", "showDatePickerView onTimeCancel error.", localException);
    }
  }
  
  public void onTimeConfirm(String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("value", paramString1 + ":" + paramString2);
      this.this$1.val$req.a(localJSONObject);
      return;
    }
    catch (JSONException paramString1)
    {
      bdnw.d("PickerJsPlugin", "showDatePickerView onTimeConfirm error.", paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.PickerJsPlugin.4.1
 * JD-Core Version:    0.7.0.1
 */