package com.tencent.ttpic.voicechanger.common.audio;

import com.qq.wx.voice.recognizer.VoiceRecognizer;
import com.tencent.ttpic.baseutils.log.LogUtils;

class VoiceTextRecognizer$2
  implements Runnable
{
  VoiceTextRecognizer$2(VoiceTextRecognizer paramVoiceTextRecognizer) {}
  
  public void run()
  {
    if (VoiceTextRecognizer.access$400(this.this$0) != 1) {
      return;
    }
    if (VoiceRecognizer.shareInstance().startReceiving() < 0)
    {
      LogUtils.e(VoiceTextRecognizer.access$200(), "启动语音识别失败");
      return;
    }
    VoiceTextRecognizer.access$402(this.this$0, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.voicechanger.common.audio.VoiceTextRecognizer.2
 * JD-Core Version:    0.7.0.1
 */