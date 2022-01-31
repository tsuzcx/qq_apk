package com.tencent.qqmini.sdk.runtime.plugin;

import begy;
import begz;
import bejn;
import beka;
import besl;
import bfeg;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class PickerJsPlugin$2$1
  implements bfeg
{
  PickerJsPlugin$2$1(PickerJsPlugin.2 param2) {}
  
  public void onValCancel()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      this.this$1.val$req.b(localJSONObject);
      if (PickerJsPlugin.access$100(this.this$1.this$0) != null) {
        PickerJsPlugin.access$102(this.this$1.this$0, null);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        besl.d("PickerJsPlugin", "showMultiPickerView error.", localException);
      }
    }
  }
  
  public void onValChange(int paramInt1, int paramInt2)
  {
    int i = ((Integer)PickerJsPlugin.access$300(this.this$1.this$0).a(bejn.a())).intValue();
    this.this$1.val$req.a.a("onMultiPickerViewChange", String.format("{\"column\":%d,\"current\":%d}", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), i);
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
      this.this$1.val$req.a(localJSONObject);
    }
    catch (JSONException paramArrayOfInt)
    {
      for (;;)
      {
        besl.d("PickerJsPlugin", "showMultiPickerView error.", paramArrayOfInt);
      }
    }
    if (PickerJsPlugin.access$100(this.this$1.this$0) != null) {
      PickerJsPlugin.access$102(this.this$1.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.PickerJsPlugin.2.1
 * JD-Core Version:    0.7.0.1
 */