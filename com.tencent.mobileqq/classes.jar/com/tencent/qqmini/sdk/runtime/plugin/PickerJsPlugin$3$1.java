package com.tencent.qqmini.sdk.runtime.plugin;

import android.text.TextUtils;
import beka;
import besl;
import bfed;
import org.json.JSONException;
import org.json.JSONObject;

class PickerJsPlugin$3$1
  implements bfed
{
  PickerJsPlugin$3$1(PickerJsPlugin.3 param3) {}
  
  public void onDateCancel()
  {
    try
    {
      this.this$1.val$req.c();
      return;
    }
    catch (Exception localException)
    {
      besl.d("PickerJsPlugin", "showDatePickerView onDateCancel error.", localException);
      this.this$1.val$req.b();
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
        this.this$1.val$req.a(localJSONObject);
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
      besl.d("PickerJsPlugin", "showDatePickerView onDateConfirm error.", paramString1);
      this.this$1.val$req.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.PickerJsPlugin.3.1
 * JD-Core Version:    0.7.0.1
 */