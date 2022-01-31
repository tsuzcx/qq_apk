package com.tencent.qqmini.sdk.minigame.webaudio;

import begy;
import beka;
import bexf;
import com.tencent.mobileqq.triton.audio.AudioHandleThread;

public class WebAudioManager$3
  implements Runnable
{
  public WebAudioManager$3(bexf parambexf, int paramInt, beka parambeka) {}
  
  public void run()
  {
    if ((AudioNativeManager.isSourceStopped(this.jdField_a_of_type_Int)) && (this.jdField_a_of_type_Beka != null))
    {
      this.jdField_a_of_type_Beka.a.a("onWebAudioSourceEnded", null, 0);
      return;
    }
    AudioHandleThread.getInstance().postDelayed(this, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.webaudio.WebAudioManager.3
 * JD-Core Version:    0.7.0.1
 */