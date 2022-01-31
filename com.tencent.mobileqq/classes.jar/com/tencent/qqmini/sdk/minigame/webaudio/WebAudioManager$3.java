package com.tencent.qqmini.sdk.minigame.webaudio;

import bghn;
import bgkd;
import bgwp;
import com.tencent.mobileqq.triton.audio.AudioHandleThread;
import com.tencent.mobileqq.triton.sdk.audio.IAudioNativeManager;
import org.json.JSONException;
import org.json.JSONObject;

public class WebAudioManager$3
  implements Runnable
{
  public WebAudioManager$3(bgwp parambgwp, int paramInt1, int paramInt2, bgkd parambgkd) {}
  
  public void run()
  {
    if (bgwp.a(this.this$0) == null) {
      return;
    }
    if (bgwp.a(this.this$0).isSourceStopped(this.jdField_a_of_type_Int))
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("audioId", this.b);
        localJSONObject.put("channelId", this.jdField_a_of_type_Int);
        if (this.jdField_a_of_type_Bgkd != null)
        {
          this.jdField_a_of_type_Bgkd.a.a("onWebAudioSourceEnded", localJSONObject.toString(), 0);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
    AudioHandleThread.getInstance().postDelayed(this, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.webaudio.WebAudioManager.3
 * JD-Core Version:    0.7.0.1
 */