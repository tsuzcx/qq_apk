package com.tencent.qqmini.sdk.minigame.webaudio;

import android.os.Build.VERSION;
import android.os.Environment;
import begy;
import beka;
import bekq;
import bexd;
import bexf;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class WebAudioManager$5
  implements Runnable
{
  public WebAudioManager$5(bexf parambexf, byte[] paramArrayOfByte, int paramInt, beka parambeka) {}
  
  public void run()
  {
    bexd localbexd = new bexd();
    Object localObject = null;
    int j;
    int k;
    if (Build.VERSION.SDK_INT >= 23)
    {
      localObject = localbexd.a(this.jdField_a_of_type_ArrayOfByte);
      j = AudioNativeManager.loadRawData((byte[])localObject, localbexd.a(), localbexd.b(), localbexd.c());
      k = localbexd.a();
      if (localObject == null) {
        break label269;
      }
    }
    label269:
    for (int i = localObject.length;; i = 0)
    {
      int m = localbexd.b();
      int n = localbexd.c() / 8;
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
        if (this.jdField_a_of_type_Beka != null) {
          this.jdField_a_of_type_Beka.a.a("onDecodeWebAudioDataDone", ((JSONObject)localObject).toString(), 0);
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
      bekq.a(this.jdField_a_of_type_ArrayOfByte, str);
      localObject = localbexd.a(str);
      bekq.a(str);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.webaudio.WebAudioManager.5
 * JD-Core Version:    0.7.0.1
 */