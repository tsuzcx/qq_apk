package com.tencent.qqmini.sdk.minigame.webaudio;

import bglu;
import bgok;
import bhaw;
import com.tencent.mobileqq.triton.audio.AudioHandleThread;
import com.tencent.mobileqq.triton.sdk.audio.IAudioNativeManager;
import org.json.JSONException;
import org.json.JSONObject;

public class WebAudioManager$6
  implements Runnable
{
  public WebAudioManager$6(bhaw parambhaw, bgok parambgok, int paramInt) {}
  
  public void run()
  {
    int i = bhaw.a(this.this$0).onAudioProcess(-2);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("bufferId", i);
      if (this.jdField_a_of_type_Bgok != null) {
        this.jdField_a_of_type_Bgok.a.a("onWebAudioScriptProcessorAudioProcess", localJSONObject.toString(), 0);
      }
      AudioHandleThread.getInstance().postDelayed(this, this.jdField_a_of_type_Int);
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
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.webaudio.WebAudioManager.6
 * JD-Core Version:    0.7.0.1
 */