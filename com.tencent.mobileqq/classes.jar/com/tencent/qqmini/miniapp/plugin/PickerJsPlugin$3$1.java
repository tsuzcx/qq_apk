package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.miniapp.widget.TimePickerView.OnConfirmListener;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

class PickerJsPlugin$3$1
  implements TimePickerView.OnConfirmListener
{
  PickerJsPlugin$3$1(PickerJsPlugin.3 param3) {}
  
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append(":");
      localStringBuilder.append(paramString2);
      localJSONObject.put("value", localStringBuilder.toString());
      this.this$1.val$req.ok(localJSONObject);
      return;
    }
    catch (JSONException paramString1)
    {
      QMLog.e("PickerJsPlugin", "showDatePickerView onTimeConfirm error.", paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.PickerJsPlugin.3.1
 * JD-Core Version:    0.7.0.1
 */