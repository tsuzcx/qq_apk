package com.tencent.mobileqq.triton.audio;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.webkit.URLUtil;
import com.tencent.mobileqq.triton.engine.TTLog;

class b$i
  implements MediaPlayer.OnPreparedListener
{
  b$i(b paramb) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    try
    {
      TTLog.c("[audio] InnerAudioPlayer", String.format("onPrepared audioId=%d path=%s", new Object[] { Integer.valueOf(this.a.getAudioId()), this.a.getAudioPath() }));
      b.a(this.a, true);
      if (!URLUtil.isNetworkUrl(this.a.getAudioPath())) {
        b.a(this.a, this.a.getDuration());
      }
      b.a(this.a);
      boolean bool = this.a.getAutoPlay();
      if (bool)
      {
        TTLog.c("[audio] InnerAudioPlayer", String.format("onPrepared:autoplay after prepared. audioId=%d path=%s", new Object[] { Integer.valueOf(this.a.getAudioId()), this.a.getAudioPath() }));
        this.a.play();
      }
      return;
    }
    finally
    {
      TTLog.b("[audio] InnerAudioPlayer", String.format("onPrepared error. audioId=%d path=%s", new Object[] { Integer.valueOf(this.a.getAudioId()), this.a.getAudioPath() }), paramMediaPlayer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.audio.b.i
 * JD-Core Version:    0.7.0.1
 */