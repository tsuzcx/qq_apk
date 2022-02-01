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
    TTSPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqQassistantTtsTTSPlayerManager, null);
    if (TTSPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqQassistantTtsTTSPlayerManager) != null) {
      TTSPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqQassistantTtsTTSPlayerManager).b(this.jdField_a_of_type_JavaLangString);
    }
    QQAudioUtils.a(MobileQQ.sMobileQQ, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.tts.TTSPlayerManager.1
 * JD-Core Version:    0.7.0.1
 */