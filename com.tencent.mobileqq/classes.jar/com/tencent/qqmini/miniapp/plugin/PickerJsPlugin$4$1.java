package com.tencent.qqmini.miniapp.plugin;

import android.text.TextUtils;
import com.tencent.qqmini.miniapp.widget.DatePickerView.OnConfirmListener;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

class PickerJsPlugin$4$1
  implements DatePickerView.OnConfirmListener
{
  PickerJsPlugin$4$1(PickerJsPlugin.4 param4) {}
  
  public void onDateCancel()
  {
    try
    {
      this.this$1.val$req.cancel();
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("PickerJsPlugin", "showDatePickerView onDateCancel error.", localException);
      this.this$1.val$req.fail();
    }
  }
  
  public void onDateConfirm(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      boolean bool = TextUtils.isEmpty(this.this$1.val$fields);
      StringBuilder localStringBuilder;
      if (bool)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString1);
        localStringBuilder.append("-");
        localStringBuilder.append(paramString2);
        localStringBuilder.append("-");
        localStringBuilder.append(paramString3);
        paramString1 = localStringBuilder.toString();
      }
      else if ("year".equals(this.this$1.val$fields))
      {
        paramString2 = new StringBuilder();
        paramString2.append(paramString1);
        paramString2.append("");
        paramString1 = paramString2.toString();
      }
      else if ("month".equals(this.this$1.val$fields))
      {
        paramString3 = new StringBuilder();
        paramString3.append(paramString1);
        paramString3.append("-");
        paramString3.append(paramString2);
        paramString1 = paramString3.toString();
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString1);
        localStringBuilder.append("-");
        localStringBuilder.append(paramString2);
        localStringBuilder.append("-");
        localStringBuilder.append(paramString3);
        paramString1 = localStringBuilder.toString();
      }
      localJSONObject.put("value", paramString1);
      this.this$1.val$req.ok(localJSONObject);
      return;
    }
    catch (JSONException paramString1)
    {
      QMLog.e("PickerJsPlugin", "showDatePickerView onDateConfirm error.", paramString1);
      this.this$1.val$req.fail();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.PickerJsPlugin.4.1
 * JD-Core Version:    0.7.0.1
 */