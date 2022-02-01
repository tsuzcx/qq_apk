package com.tencent.mobileqq.kandian.biz.ugc.voice;

import android.media.AudioManager;
import com.tencent.qphone.base.util.QLog;

class ReadInJoyVoicePlayController$3
  implements Runnable
{
  ReadInJoyVoicePlayController$3(ReadInJoyVoicePlayController paramReadInJoyVoicePlayController) {}
  
  public void run()
  {
    if (ReadInJoyVoicePlayController.a(this.this$0))
    {
      if (ReadInJoyVoicePlayController.a(this.this$0) != null) {
        ReadInJoyVoicePlayController.a(this.this$0).requestAudioFocus(null, 3, 2);
      }
    }
    else if (ReadInJoyVoicePlayController.a(this.this$0) != null) {
      ReadInJoyVoicePlayController.a(this.this$0).abandonAudioFocus(null);
    }
    if (QLog.isColorLevel())
    {
      String str = ReadInJoyVoicePlayController.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mRequestOrAbandonAudioFocusCallBack isFocusAudio:");
      localStringBuilder.append(ReadInJoyVoicePlayController.a(this.this$0));
      QLog.d(str, 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.voice.ReadInJoyVoicePlayController.3
 * JD-Core Version:    0.7.0.1
 */