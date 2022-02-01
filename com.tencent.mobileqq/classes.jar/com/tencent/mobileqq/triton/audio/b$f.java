package com.tencent.mobileqq.triton.audio;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mobileqq.triton.engine.TTLog;
import com.tencent.mobileqq.triton.sdk.audio.IAudioStateChangeListener;

class b$f
  implements MediaPlayer.OnCompletionListener
{
  b$f(b paramb) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    TTLog.c("[audio] InnerAudioPlayer", String.format("onCompletion audioId=%d path=%s, duration=%d", new Object[] { Integer.valueOf(this.a.getAudioId()), this.a.getAudioPath(), Integer.valueOf(this.a.getDuration()) }));
    paramMediaPlayer = this.a;
    paramMediaPlayer = new b.n(paramMediaPlayer, paramMediaPlayer.getAudioId(), this.a.getAudioPath());
    if (this.a.getDuration() < 500) {
      a.a().a(paramMediaPlayer, this.a.getDuration() * 2);
    }
    for (;;)
    {
      if (this.a.getStateChangeListener() != null) {
        this.a.getStateChangeListener().onEnded();
      }
      return;
      paramMediaPlayer.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.audio.b.f
 * JD-Core Version:    0.7.0.1
 */