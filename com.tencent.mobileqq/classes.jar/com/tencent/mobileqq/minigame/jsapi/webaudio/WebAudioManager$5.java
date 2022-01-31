package com.tencent.mobileqq.minigame.jsapi.webaudio;

import android.os.Build.VERSION;
import android.os.Environment;
import bbdx;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

class WebAudioManager$5
  implements Runnable
{
  WebAudioManager$5(WebAudioManager paramWebAudioManager, byte[] paramArrayOfByte, int paramInt, JsRuntime paramJsRuntime) {}
  
  public void run()
  {
    AudioDecoder localAudioDecoder = new AudioDecoder();
    Object localObject = null;
    int j;
    int k;
    if (Build.VERSION.SDK_INT >= 23)
    {
      localObject = localAudioDecoder.decodeInMemory(this.val$audioData);
      j = AudioNativeManager.loadRawData((byte[])localObject, localAudioDecoder.getSampleRate(), localAudioDecoder.getChannelCount(), localAudioDecoder.getBitsPerChannel());
      k = localAudioDecoder.getSampleRate();
      if (localObject == null) {
        break label266;
      }
    }
    label266:
    for (int i = localObject.length;; i = 0)
    {
      int m = localAudioDecoder.getChannelCount();
      int n = localAudioDecoder.getBitsPerChannel() / 8;
      n = i / m / n / k;
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("bufferId", j);
        ((JSONObject)localObject).put("sampleRate", k);
        ((JSONObject)localObject).put("length", i);
        ((JSONObject)localObject).put("duration", n);
        ((JSONObject)localObject).put("numberOfChannels", m);
        ((JSONObject)localObject).put("decodeId", this.val$decodeId);
        ((JSONObject)localObject).put("status", "ok");
        if (this.val$jsRuntime != null) {
          this.val$jsRuntime.evaluateSubcribeJS("onDecodeWebAudioDataDone", ((JSONObject)localObject).toString(), 0);
        }
        return;
      }
      catch (JSONException localJSONException)
      {
        String str;
        localJSONException.printStackTrace();
      }
      if (Build.VERSION.SDK_INT < 16) {
        break;
      }
      str = Environment.getExternalStorageDirectory().getPath() + "/minigame/audio_" + System.currentTimeMillis();
      bbdx.a(this.val$audioData, str);
      localObject = localAudioDecoder.decodeByPath(str);
      bbdx.d(str);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.webaudio.WebAudioManager.5
 * JD-Core Version:    0.7.0.1
 */