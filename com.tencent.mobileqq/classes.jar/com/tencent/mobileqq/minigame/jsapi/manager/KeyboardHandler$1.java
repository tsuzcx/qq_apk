package com.tencent.mobileqq.minigame.jsapi.manager;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.minigame.jsapi.callbacks.PluginResultCallback;
import com.tencent.mobileqq.minigame.utils.GameLog;
import org.json.JSONException;
import org.json.JSONObject;

class KeyboardHandler$1
  implements TextWatcher
{
  KeyboardHandler$1(KeyboardHandler paramKeyboardHandler, PluginResultCallback paramPluginResultCallback) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("value", paramEditable.toString());
      this.val$pluginResultCallback.subscribeCallback("onKeyboardInput", localJSONObject.toString());
      return;
    }
    catch (JSONException paramEditable)
    {
      GameLog.getInstance().e("KeyboardHandler", "afterTextChanged callback exception", paramEditable);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.manager.KeyboardHandler.1
 * JD-Core Version:    0.7.0.1
 */