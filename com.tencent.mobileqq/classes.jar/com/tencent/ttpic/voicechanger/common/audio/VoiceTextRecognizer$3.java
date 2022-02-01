package com.tencent.ttpic.voicechanger.common.audio;

import com.qq.wx.voice.recognizer.VoiceRecognizer;

class VoiceTextRecognizer$3
  implements Runnable
{
  VoiceTextRecognizer$3(VoiceTextRecognizer paramVoiceTextRecognizer) {}
  
  public void run()
  {
    VoiceRecognizer.shareInstance().destroy();
    VoiceTextRecognizer.access$402(this.this$0, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.voicechanger.common.audio.VoiceTextRecognizer.3
 * JD-Core Version:    0.7.0.1
 */