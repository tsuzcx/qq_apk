package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.miniapp.widget.TimePickerView.OnConfirmListener;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

class PickerJsPlugin$4$1
  implements TimePickerView.OnConfirmListener
{
  PickerJsPlugin$4$1(PickerJsPlugin.4 param4) {}
  
  public void onTimeCancel()
  {
    try
    {
      this.this$1.val$req.cancel();
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("PickerJsPlugin", "showDatePickerView onTimeCancel error.", localException);
    }
  }
  
  public void onTimeConfirm(String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("value", paramString1 + ":" + paramString2);
      this.this$1.val$req.ok(localJSONObject);
      return;
    }
    catch (JSONException paramString1)
    {
      QMLog.e("PickerJsPlugin", "showDatePickerView onTimeConfirm error.", paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.PickerJsPlugin.4.1
 * JD-Core Version:    0.7.0.1
 */