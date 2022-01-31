package com.tencent.qqmini.sdk.core.plugins;

import android.text.Editable;
import android.text.TextWatcher;
import bdcy;
import bdfz;
import bdnw;
import org.json.JSONException;
import org.json.JSONObject;

class InputJsPlugin$5
  implements TextWatcher
{
  InputJsPlugin$5(InputJsPlugin paramInputJsPlugin, bdfz parambdfz) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("value", paramEditable.toString());
      this.val$req.a.a("onKeyboardInput", localJSONObject.toString(), 0);
      return;
    }
    catch (JSONException paramEditable)
    {
      bdnw.d("NetworkJsPlugin", "afterTextChanged callback exception", paramEditable);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.InputJsPlugin.5
 * JD-Core Version:    0.7.0.1
 */