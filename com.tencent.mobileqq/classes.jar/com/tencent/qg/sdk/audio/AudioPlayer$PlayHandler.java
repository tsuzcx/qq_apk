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
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      this.this$0.handlePlay();
      return;
    case 2: 
      this.this$0.handleStop();
      return;
    case 3: 
      this.this$0.handlePause();
      return;
    }
    this.this$0.handleSeekTo(((Integer)paramMessage.obj).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.qg.sdk.audio.AudioPlayer.PlayHandler
 * JD-Core Version:    0.7.0.1
 */