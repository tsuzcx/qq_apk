package com.tencent.qqmini.sdk.minigame.webaudio;

import bgkd;
import bgwp;
import com.tencent.mobileqq.triton.sdk.audio.IAudioNativeManager;

public class WebAudioManager$1
  implements Runnable
{
  public WebAudioManager$1(bgwp parambgwp, int paramInt1, int paramInt2, bgkd parambgkd, int paramInt3) {}
  
  public void run()
  {
    if (bgwp.a(this.this$0) != null)
    {
      bgwp.a(this.this$0).play(this.jdField_a_of_type_Int, this.b);
      bgwp.a(this.this$0, this.jdField_a_of_type_Bgkd, this.jdField_a_of_type_Int, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.webaudio.WebAudioManager.1
 * JD-Core Version:    0.7.0.1
 */