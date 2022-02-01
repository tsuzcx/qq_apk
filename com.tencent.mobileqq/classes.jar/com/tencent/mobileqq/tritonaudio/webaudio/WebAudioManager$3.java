package com.tencent.mobileqq.tritonaudio.webaudio;

import com.tencent.mobileqq.triton.script.Argument;
import com.tencent.mobileqq.tritonaudio.TritonAudioThreadPool;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

class WebAudioManager$3
  implements Runnable
{
  WebAudioManager$3(WebAudioManager paramWebAudioManager, int paramInt1, int paramInt2, Argument paramArgument) {}
  
  public void run()
  {
    if (AudioNativeManager.isSourceStopped(this.val$sourceId))
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("audioId", this.val$audioId);
        localJSONObject.put("channelId", this.val$sourceId);
        if (this.val$argument != null)
        {
          this.val$argument.subscribe("onWebAudioSourceEnded", localJSONObject.toString());
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
    TritonAudioThreadPool.getAudioThreadPool().schedule(this, 1000L, TimeUnit.MILLISECONDS);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tritonaudio.webaudio.WebAudioManager.3
 * JD-Core Version:    0.7.0.1
 */