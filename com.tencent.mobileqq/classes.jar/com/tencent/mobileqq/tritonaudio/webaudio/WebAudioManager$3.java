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
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      Argument localArgument = this.val$argument;
      if (localArgument != null)
      {
        localArgument.subscribe("onWebAudioSourceEnded", localJSONObject.toString());
        return;
      }
    }
    TritonAudioThreadPool.getAudioThreadPool().schedule(this, 1000L, TimeUnit.MILLISECONDS);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tritonaudio.webaudio.WebAudioManager.3
 * JD-Core Version:    0.7.0.1
 */