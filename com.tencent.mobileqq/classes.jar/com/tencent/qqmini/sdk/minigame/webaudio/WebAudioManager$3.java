package com.tencent.qqmini.sdk.minigame.webaudio;

import behp;
import bekr;
import bexw;
import com.tencent.mobileqq.triton.audio.AudioHandleThread;

public class WebAudioManager$3
  implements Runnable
{
  public WebAudioManager$3(bexw parambexw, int paramInt, bekr parambekr) {}
  
  public void run()
  {
    if ((AudioNativeManager.isSourceStopped(this.jdField_a_of_type_Int)) && (this.jdField_a_of_type_Bekr != null))
    {
      this.jdField_a_of_type_Bekr.a.a("onWebAudioSourceEnded", null, 0);
      return;
    }
    AudioHandleThread.getInstance().postDelayed(this, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.webaudio.WebAudioManager.3
 * JD-Core Version:    0.7.0.1
 */