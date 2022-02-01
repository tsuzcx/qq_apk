package com.tencent.mobileqq.utils;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Handler;
import android.os.Looper;
import com.tencent.qphone.base.util.QLog;

final class AudioUtil$4
  implements MediaPlayer.OnCompletionListener
{
  AudioUtil$4(MediaPlayer.OnCompletionListener paramOnCompletionListener, Handler paramHandler) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (AudioUtil.b() == 0)
    {
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener != null)
      {
        if ((this.jdField_a_of_type_AndroidOsHandler == null) || (this.jdField_a_of_type_AndroidOsHandler.getLooper() == Looper.myLooper()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("AudioUtil", 2, "MediaPlayerStart, onCompletion, onCompletion branch 1");
          }
          this.jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener.onCompletion(AudioUtil.a);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("AudioUtil", 2, "MediaPlayerStart, onCompletion, onCompletion branch 2");
        }
        AudioUtil.a();
        this.jdField_a_of_type_AndroidOsHandler.post(new AudioUtil.4.1(this));
        return;
      }
      AudioUtil.a();
      return;
    }
    AudioUtil.c();
    AudioUtil.a.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.AudioUtil.4
 * JD-Core Version:    0.7.0.1
 */