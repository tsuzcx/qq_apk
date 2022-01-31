package com.tencent.mobileqq.triton.audio;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.webkit.URLUtil;
import com.tencent.mobileqq.triton.engine.TTLog;

class InnerAudioPlayer$11
  implements MediaPlayer.OnPreparedListener
{
  InnerAudioPlayer$11(InnerAudioPlayer paramInnerAudioPlayer) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    try
    {
      TTLog.i("[audio] InnerAudioPlayer", String.format("onPrepared audioId=%d path=%s", new Object[] { Integer.valueOf(this.this$0.getAudioId()), this.this$0.getAudioPath() }));
      InnerAudioPlayer.access$002(this.this$0, true);
      if (!URLUtil.isNetworkUrl(this.this$0.getAudioPath())) {
        InnerAudioPlayer.access$102(this.this$0, this.this$0.getDuration());
      }
      InnerAudioPlayer.access$200(this.this$0);
      if (this.this$0.getAutoPlay())
      {
        TTLog.i("[audio] InnerAudioPlayer", String.format("onPrepared:autoplay after prepared. audioId=%d path=%s", new Object[] { Integer.valueOf(this.this$0.getAudioId()), this.this$0.getAudioPath() }));
        this.this$0.play();
      }
      return;
    }
    catch (Throwable paramMediaPlayer)
    {
      TTLog.e("[audio] InnerAudioPlayer", String.format("onPrepared error. audioId=%d path=%s", new Object[] { Integer.valueOf(this.this$0.getAudioId()), this.this$0.getAudioPath() }), paramMediaPlayer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.triton.audio.InnerAudioPlayer.11
 * JD-Core Version:    0.7.0.1
 */