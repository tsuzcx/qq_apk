package com.tencent.qqmini.minigame.webaudio;

import android.os.Handler;
import com.tencent.mobileqq.triton.sdk.audio.IAudioNativeManager;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import org.json.JSONException;
import org.json.JSONObject;

class WebAudioManager$6
  implements Runnable
{
  WebAudioManager$6(WebAudioManager paramWebAudioManager, RequestEvent paramRequestEvent, int paramInt) {}
  
  public void run()
  {
    int i = WebAudioManager.access$000(this.this$0).onAudioProcess(-2);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("bufferId", i);
      if (this.val$req != null) {
        this.val$req.jsService.evaluateSubscribeJS("onWebAudioScriptProcessorAudioProcess", localJSONObject.toString(), 0);
      }
      ThreadManager.getSubThreadHandler().postDelayed(this, this.val$interval);
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
 * Qualified Name:     com.tencent.qqmini.minigame.webaudio.WebAudioManager.6
 * JD-Core Version:    0.7.0.1
 */