package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.miniapp.widget.media.MiniAppAudioPlayer.OnPreparedListener;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import org.json.JSONException;
import org.json.JSONObject;

class AudioJsPlugin$2
  implements MiniAppAudioPlayer.OnPreparedListener
{
  AudioJsPlugin$2(AudioJsPlugin paramAudioJsPlugin, JSONObject paramJSONObject, RequestEvent paramRequestEvent) {}
  
  public void onPrepared()
  {
    JSONObject localJSONObject = AudioJsPlugin.access$1600(this.this$0, this.val$jsonObject).getAudioContext();
    AudioJsPlugin.InnerAudioManager localInnerAudioManager = AudioJsPlugin.access$1600(this.this$0, this.val$jsonObject);
    int i = AudioJsPlugin.InnerAudioManager.access$1400(localInnerAudioManager);
    double d = AudioJsPlugin.InnerAudioManager.access$1500(localInnerAudioManager);
    boolean bool = AudioJsPlugin.InnerAudioManager.access$1100(localInnerAudioManager);
    try
    {
      localJSONObject.put("duration", i);
      localJSONObject.put("currentTime", d);
      localJSONObject.put("paused", bool);
      localJSONObject.put("buffered", i);
      this.val$req.ok(localJSONObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.AudioJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */