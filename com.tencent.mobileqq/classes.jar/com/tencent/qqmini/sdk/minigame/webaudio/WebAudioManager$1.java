package com.tencent.qqmini.sdk.minigame.webaudio;

import beka;
import bexf;

public class WebAudioManager$1
  implements Runnable
{
  public WebAudioManager$1(bexf parambexf, int paramInt1, int paramInt2, beka parambeka) {}
  
  public void run()
  {
    AudioNativeManager.play(this.jdField_a_of_type_Int, this.b);
    bexf.a(this.this$0, this.jdField_a_of_type_Beka, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.webaudio.WebAudioManager.1
 * JD-Core Version:    0.7.0.1
 */