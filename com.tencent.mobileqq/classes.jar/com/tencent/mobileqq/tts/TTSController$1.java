package com.tencent.mobileqq.tts;

import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;

class TTSController$1
  implements SilkStreamPlayer.OnSilkStreamPlay
{
  TTSController$1(TTSController paramTTSController) {}
  
  public void a(String paramString)
  {
    TTSController.a(this.a).sendEmptyMessage(0);
  }
  
  public void b()
  {
    TTSController.a(this.a).sendEmptyMessage(1);
  }
  
  public void b(String paramString)
  {
    if (TTSController.a(this.a) != null)
    {
      TTSController.a(this.a).b();
      QQAudioUtils.a(BaseApplicationImpl.getContext(), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tts.TTSController.1
 * JD-Core Version:    0.7.0.1
 */