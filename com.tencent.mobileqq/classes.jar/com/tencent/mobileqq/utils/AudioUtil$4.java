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
    if (AudioUtil.c() == 0)
    {
      if (this.a != null)
      {
        paramMediaPlayer = this.b;
        if ((paramMediaPlayer != null) && (paramMediaPlayer.getLooper() != Looper.myLooper()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("AudioUtil", 2, "MediaPlayerStart, onCompletion, onCompletion branch 2");
          }
          AudioUtil.b();
          this.b.post(new AudioUtil.4.1(this));
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("AudioUtil", 2, "MediaPlayerStart, onCompletion, onCompletion branch 1");
        }
        this.a.onCompletion(AudioUtil.c);
        return;
      }
      AudioUtil.b();
      return;
    }
    AudioUtil.d();
    AudioUtil.c.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.AudioUtil.4
 * JD-Core Version:    0.7.0.1
 */