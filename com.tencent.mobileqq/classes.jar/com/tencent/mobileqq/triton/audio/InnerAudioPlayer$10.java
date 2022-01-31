package com.tencent.mobileqq.triton.audio;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mobileqq.triton.engine.TTLog;
import com.tencent.mobileqq.triton.sdk.audio.IAudioStateChangeListener;

class InnerAudioPlayer$10
  implements MediaPlayer.OnCompletionListener
{
  InnerAudioPlayer$10(InnerAudioPlayer paramInnerAudioPlayer) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    TTLog.i("[audio] InnerAudioPlayer", String.format("onCompletion audioId=%d path=%s, duration=%d", new Object[] { Integer.valueOf(this.this$0.getAudioId()), this.this$0.getAudioPath(), Integer.valueOf(this.this$0.getDuration()) }));
    paramMediaPlayer = new InnerAudioPlayer.ResetTask(this.this$0, this.this$0.getAudioId(), this.this$0.getAudioPath());
    if (this.this$0.getDuration() < 500) {
      AudioHandleThread.getInstance().postDelayed(paramMediaPlayer, this.this$0.getDuration() * 2);
    }
    for (;;)
    {
      if (this.this$0.getStateChangeListener() != null) {
        this.this$0.getStateChangeListener().onEnded();
      }
      return;
      paramMediaPlayer.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.triton.audio.InnerAudioPlayer.10
 * JD-Core Version:    0.7.0.1
 */