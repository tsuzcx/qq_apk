package com.tencent.mobileqq.triton.audio;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mobileqq.triton.engine.TTLog;
import com.tencent.mobileqq.triton.sdk.audio.IAudioStateChangeListener;

class b$h
  implements MediaPlayer.OnErrorListener
{
  b$h(b paramb) {}
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    TTLog.b("[audio] InnerAudioPlayer", String.format("onError audioId=%d path=%s errCode=%d extra=%d", new Object[] { Integer.valueOf(this.a.getAudioId()), this.a.getAudioPath(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    this.a.b();
    b.a(this.a, false);
    if (this.a.getStateChangeListener() != null) {
      this.a.getStateChangeListener().onError(paramInt1);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.audio.b.h
 * JD-Core Version:    0.7.0.1
 */