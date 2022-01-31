package com.tencent.mobileqq.minigame.jsapi.webaudio;

import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.triton.audio.AudioHandleThread;
import org.json.JSONException;
import org.json.JSONObject;

class WebAudioManager$6
  implements Runnable
{
  WebAudioManager$6(WebAudioManager paramWebAudioManager, JsRuntime paramJsRuntime, int paramInt) {}
  
  public void run()
  {
    int i = AudioNativeManager.onAudioProcess(-2);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("bufferId", i);
      if (this.val$jsRuntime != null) {
        this.val$jsRuntime.evaluateSubcribeJS("onWebAudioScriptProcessorAudioProcess", localJSONObject.toString(), 0);
      }
      AudioHandleThread.getInstance().postDelayed(this, this.val$interval);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.webaudio.WebAudioManager.6
 * JD-Core Version:    0.7.0.1
 */