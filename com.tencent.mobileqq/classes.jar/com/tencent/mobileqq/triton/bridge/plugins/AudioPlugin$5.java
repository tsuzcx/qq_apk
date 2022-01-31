package com.tencent.mobileqq.triton.bridge.plugins;

import com.tencent.mobileqq.triton.audio.TTAudioPlayerManager;
import com.tencent.mobileqq.triton.engine.TTLog;
import org.json.JSONObject;

class AudioPlugin$5
  implements Runnable
{
  AudioPlugin$5(AudioPlugin paramAudioPlugin, String paramString) {}
  
  public void run()
  {
    int i;
    String str;
    try
    {
      JSONObject localJSONObject = new JSONObject(this.val$jsonParams);
      i = localJSONObject.optInt("audioId", -1);
      str = localJSONObject.optString("operationType");
      if ("play".equals(str))
      {
        if (AudioPlugin.access$100(this.this$0)) {
          return;
        }
        AudioPlugin.access$000(this.this$0).playMusic(i);
        return;
      }
      if ("pause".equals(str))
      {
        AudioPlugin.access$000(this.this$0).pauseMusic(i);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      TTLog.e("[audio] AudioPlugin", "API_OPERATE_AUDIO exception:", localThrowable);
      return;
    }
    if ("stop".equals(str))
    {
      AudioPlugin.access$000(this.this$0).stopMusic(i);
      return;
    }
    if ("seek".equals(str)) {
      AudioPlugin.access$000(this.this$0).seekTo(i, (float)localThrowable.optDouble("currentTime"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.triton.bridge.plugins.AudioPlugin.5
 * JD-Core Version:    0.7.0.1
 */