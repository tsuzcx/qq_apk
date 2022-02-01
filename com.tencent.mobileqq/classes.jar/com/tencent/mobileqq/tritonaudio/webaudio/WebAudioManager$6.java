package com.tencent.mobileqq.tritonaudio.webaudio;

import com.tencent.mobileqq.triton.script.Argument;
import com.tencent.mobileqq.tritonaudio.TritonAudioThreadPool;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

class WebAudioManager$6
  implements Runnable
{
  WebAudioManager$6(WebAudioManager paramWebAudioManager, Argument paramArgument, int paramInt) {}
  
  public void run()
  {
    int i = AudioNativeManager.onAudioProcess(-2);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("bufferId", i);
      if (this.val$argument != null) {
        this.val$argument.subscribe("onWebAudioScriptProcessorAudioProcess", localJSONObject.toString());
      }
      TritonAudioThreadPool.getAudioThreadPool().schedule(this, this.val$interval, TimeUnit.MILLISECONDS);
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
 * Qualified Name:     com.tencent.mobileqq.tritonaudio.webaudio.WebAudioManager.6
 * JD-Core Version:    0.7.0.1
 */