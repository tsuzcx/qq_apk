package com.tencent.qqmini.sdk.minigame.webaudio;

import android.os.Build.VERSION;
import android.os.Environment;
import behp;
import bekr;
import belh;
import bexu;
import bexw;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class WebAudioManager$5
  implements Runnable
{
  public WebAudioManager$5(bexw parambexw, byte[] paramArrayOfByte, int paramInt, bekr parambekr) {}
  
  public void run()
  {
    bexu localbexu = new bexu();
    Object localObject = null;
    int j;
    int k;
    if (Build.VERSION.SDK_INT >= 23)
    {
      localObject = localbexu.a(this.jdField_a_of_type_ArrayOfByte);
      j = AudioNativeManager.loadRawData((byte[])localObject, localbexu.a(), localbexu.b(), localbexu.c());
      k = localbexu.a();
      if (localObject == null) {
        break label269;
      }
    }
    label269:
    for (int i = localObject.length;; i = 0)
    {
      int m = localbexu.b();
      int n = localbexu.c() / 8;
      n = i / m / n / k;
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("bufferId", j);
        ((JSONObject)localObject).put("sampleRate", k);
        ((JSONObject)localObject).put("length", i);
        ((JSONObject)localObject).put("duration", n);
        ((JSONObject)localObject).put("numberOfChannels", m);
        ((JSONObject)localObject).put("decodeId", this.jdField_a_of_type_Int);
        ((JSONObject)localObject).put("status", "ok");
        if (this.jdField_a_of_type_Bekr != null) {
          this.jdField_a_of_type_Bekr.a.a("onDecodeWebAudioDataDone", ((JSONObject)localObject).toString(), 0);
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
      belh.a(this.jdField_a_of_type_ArrayOfByte, str);
      localObject = localbexu.a(str);
      belh.a(str);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.webaudio.WebAudioManager.5
 * JD-Core Version:    0.7.0.1
 */