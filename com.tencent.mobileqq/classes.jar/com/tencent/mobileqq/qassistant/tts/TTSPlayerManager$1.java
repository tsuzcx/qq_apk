package com.tencent.mobileqq.qassistant.tts;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mobileqq.qassistant.listener.IPlayEventListener;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import mqq.app.MobileQQ;

class TTSPlayerManager$1
  implements MediaPlayer.OnCompletionListener
{
  TTSPlayerManager$1(TTSPlayerManager paramTTSPlayerManager, String paramString) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    paramMediaPlayer.release();
    TTSPlayerManager.a(this.b, null);
    if (TTSPlayerManager.a(this.b) != null) {
      TTSPlayerManager.a(this.b).b(this.a);
    }
    QQAudioUtils.a(MobileQQ.sMobileQQ, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.tts.TTSPlayerManager.1
 * JD-Core Version:    0.7.0.1
 */