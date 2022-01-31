package com.tencent.mobileqq.triton.bridge.plugins;

import com.tencent.mobileqq.triton.audio.TTAudioPlayerManager;
import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.engine.TTLog;
import org.json.JSONObject;

class AudioPlugin$6
  implements Runnable
{
  AudioPlugin$6(AudioPlugin paramAudioPlugin, String paramString) {}
  
  public void run()
  {
    int i;
    try
    {
      Object localObject = new JSONObject(this.val$jsonParams);
      i = ((JSONObject)localObject).optInt("audioId", -1);
      if (i == -1) {
        return;
      }
      if (((JSONObject)localObject).has("src"))
      {
        localObject = ((JSONObject)localObject).getString("src");
        AudioPlugin.access$000(this.this$0).setMusicPath(this.this$0.getTritonEngine().getMiniGameInfo(), i, (String)localObject);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      TTLog.e("[audio] AudioPlugin", "API_SET_AUDIO_STATE exception:", localThrowable);
      return;
    }
    boolean bool;
    if (localThrowable.has("autoplay"))
    {
      bool = localThrowable.getBoolean("autoplay");
      AudioPlugin.access$000(this.this$0).setAutoplay(i, bool);
      return;
    }
    double d;
    if (localThrowable.has("startTime"))
    {
      d = localThrowable.getDouble("startTime");
      AudioPlugin.access$000(this.this$0).setStartTime(i, (float)d);
      return;
    }
    if (localThrowable.has("loop"))
    {
      bool = localThrowable.getBoolean("loop");
      AudioPlugin.access$000(this.this$0).setLoop(i, bool);
      return;
    }
    if (localThrowable.has("volume"))
    {
      d = localThrowable.getDouble("volume");
      AudioPlugin.access$000(this.this$0).setVolume(i, (float)d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.bridge.plugins.AudioPlugin.6
 * JD-Core Version:    0.7.0.1
 */