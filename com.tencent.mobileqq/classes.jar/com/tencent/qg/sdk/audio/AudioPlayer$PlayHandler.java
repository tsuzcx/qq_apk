package com.tencent.qg.sdk.audio;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class AudioPlayer$PlayHandler
  extends Handler
{
  public AudioPlayer$PlayHandler(AudioPlayer paramAudioPlayer, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return;
          }
          this.this$0.handleSeekTo(((Integer)paramMessage.obj).intValue());
          return;
        }
        this.this$0.handlePause();
        return;
      }
      this.this$0.handleStop();
      return;
    }
    this.this$0.handlePlay();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qg.sdk.audio.AudioPlayer.PlayHandler
 * JD-Core Version:    0.7.0.1
 */