package com.tencent.mobileqq.minigame.jsapi.webaudio;

import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.utils.GameLog;
import com.tencent.mobileqq.triton.audio.AudioHandleThread;
import com.tencent.mobileqq.triton.sdk.audio.IAudioNativeManager;
import org.json.JSONException;
import org.json.JSONObject;

class WebAudioManager$3
  implements Runnable
{
  WebAudioManager$3(WebAudioManager paramWebAudioManager, int paramInt1, int paramInt2, JsRuntime paramJsRuntime) {}
  
  public void run()
  {
    if (WebAudioManager.access$000(this.this$0) == null) {
      return;
    }
    if (WebAudioManager.access$000(this.this$0).isSourceStopped(this.val$sourceId))
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("audioId", this.val$audioId);
        localJSONObject.put("channelId", this.val$sourceId);
        if (this.val$jsRuntime != null)
        {
          GameLog.getInstance().d("WebAudio", "onWebAudioSourceEnded channelId:" + this.val$sourceId);
          this.val$jsRuntime.evaluateSubcribeJS("onWebAudioSourceEnded", localJSONObject.toString(), 0);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
    AudioHandleThread.getInstance().postDelayed(this, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.webaudio.WebAudioManager.3
 * JD-Core Version:    0.7.0.1
 */