package com.tencent.qqmini.sdk.plugins;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

class InputJsPlugin$6
  implements TextWatcher
{
  InputJsPlugin$6(InputJsPlugin paramInputJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("value", paramEditable.toString());
      this.val$req.jsService.evaluateSubscribeJS("onKeyboardInput", localJSONObject.toString(), 0);
      return;
    }
    catch (JSONException paramEditable)
    {
      QMLog.e("InputJsPlugin", "afterTextChanged callback exception", paramEditable);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.InputJsPlugin.6
 * JD-Core Version:    0.7.0.1
 */