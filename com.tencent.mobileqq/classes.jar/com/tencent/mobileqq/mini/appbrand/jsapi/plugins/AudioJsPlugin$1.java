package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.sdk.BridgeInfo;
import com.tencent.mobileqq.mini.widget.media.MiniAppAudioPlayer.OnPreparedListener;
import org.json.JSONException;
import org.json.JSONObject;

class AudioJsPlugin$1
  implements MiniAppAudioPlayer.OnPreparedListener
{
  AudioJsPlugin$1(AudioJsPlugin paramAudioJsPlugin, JSONObject paramJSONObject, BridgeInfo paramBridgeInfo) {}
  
  public void onPrepared()
  {
    JSONObject localJSONObject = AudioJsPlugin.access$800(this.this$0, this.val$jsonObject).getAudioContext();
    AudioJsPlugin.InnerAudioManager localInnerAudioManager = AudioJsPlugin.access$800(this.this$0, this.val$jsonObject);
    int i = AudioJsPlugin.InnerAudioManager.access$000(localInnerAudioManager);
    double d = AudioJsPlugin.InnerAudioManager.access$100(localInnerAudioManager);
    boolean bool = AudioJsPlugin.InnerAudioManager.access$200(localInnerAudioManager);
    try
    {
      localJSONObject.put("duration", i);
      localJSONObject.put("currentTime", d);
      localJSONObject.put("paused", bool);
      localJSONObject.put("buffered", i);
      AudioJsPlugin.access$900(this.this$0, "setAudioState", this.val$bridgeInfo, localJSONObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.AudioJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */