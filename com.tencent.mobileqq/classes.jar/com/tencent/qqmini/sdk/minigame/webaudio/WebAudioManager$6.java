package com.tencent.qqmini.sdk.minigame.webaudio;

import begy;
import beka;
import bexf;
import com.tencent.mobileqq.triton.audio.AudioHandleThread;
import org.json.JSONException;
import org.json.JSONObject;

public class WebAudioManager$6
  implements Runnable
{
  public WebAudioManager$6(bexf parambexf, beka parambeka, int paramInt) {}
  
  public void run()
  {
    int i = AudioNativeManager.onAudioProcess(-2);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("bufferId", i);
      if (this.jdField_a_of_type_Beka != null) {
        this.jdField_a_of_type_Beka.a.a("onWebAudioScriptProcessorAudioProcess", localJSONObject.toString(), 0);
      }
      i = this.jdField_a_of_type_Int * 2 * 60 / 44100;
      AudioHandleThread.getInstance().postDelayed(this, i);
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
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.webaudio.WebAudioManager.6
 * JD-Core Version:    0.7.0.1
 */