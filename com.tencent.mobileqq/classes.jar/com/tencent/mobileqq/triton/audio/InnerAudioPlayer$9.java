package com.tencent.mobileqq.triton.audio;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mobileqq.triton.engine.TTLog;
import com.tencent.mobileqq.triton.sdk.audio.IAudioStateChangeListener;

class InnerAudioPlayer$9
  implements MediaPlayer.OnErrorListener
{
  InnerAudioPlayer$9(InnerAudioPlayer paramInnerAudioPlayer) {}
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    TTLog.e("[audio] InnerAudioPlayer", String.format("onError audioId=%d path=%s errCode=%d extra=%d", new Object[] { Integer.valueOf(this.this$0.getAudioId()), this.this$0.getAudioPath(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    this.this$0.reset();
    InnerAudioPlayer.access$002(this.this$0, false);
    if (this.this$0.getStateChangeListener() != null) {
      this.this$0.getStateChangeListener().onError(paramInt1);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.audio.InnerAudioPlayer.9
 * JD-Core Version:    0.7.0.1
 */