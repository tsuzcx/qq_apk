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
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    Argument localArgument = this.val$argument;
    if (localArgument != null) {
      localArgument.subscribe("onWebAudioScriptProcessorAudioProcess", localJSONObject.toString());
    }
    TritonAudioThreadPool.getAudioThreadPool().schedule(this, this.val$interval, TimeUnit.MILLISECONDS);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.tritonaudio.webaudio.WebAudioManager.6
 * JD-Core Version:    0.7.0.1
 */