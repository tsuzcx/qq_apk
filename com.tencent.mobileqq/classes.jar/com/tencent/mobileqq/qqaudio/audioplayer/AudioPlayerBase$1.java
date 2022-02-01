package com.tencent.mobileqq.qqaudio.audioplayer;

import android.media.AudioManager;
import android.os.Handler;
import android.os.Message;

class AudioPlayerBase$1
  extends Handler
{
  AudioPlayerBase$1(AudioPlayerBase paramAudioPlayerBase) {}
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 1000) && (this.a.c == 0) && (this.a.a()))
    {
      int i = this.a.jdField_a_of_type_AndroidMediaAudioManager.getStreamVolume(this.a.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayerHelper$AudioPlayerParameter.b);
      int j = this.a.jdField_a_of_type_AndroidMediaAudioManager.getStreamMaxVolume(this.a.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayerHelper$AudioPlayerParameter.b);
      if (i / j > 0.18F)
      {
        paramMessage = this.a;
        paramMessage.c = 1;
        if (paramMessage.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayerBase$AudioPlayerListener != null)
        {
          paramMessage = this.a.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerAudioPlayerBase$AudioPlayerListener;
          AudioPlayerBase localAudioPlayerBase = this.a;
          paramMessage.c(localAudioPlayerBase, localAudioPlayerBase.c);
        }
      }
      else
      {
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1000, 200L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase.1
 * JD-Core Version:    0.7.0.1
 */