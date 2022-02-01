package com.tencent.mobileqq.shortvideo.util;

import android.media.MediaPlayer;
import com.tencent.sveffects.Logger;
import com.tencent.sveffects.SdkContext;

class SimpleAudioPlayer$AmrPlayerThread
  extends Thread
{
  private SimpleAudioPlayer$AmrPlayerThread(SimpleAudioPlayer paramSimpleAudioPlayer) {}
  
  public void run()
  {
    if (SdkContext.getInstance().getLogger().isEnable()) {
      SdkContext.getInstance().getLogger().d("SimpleAudioPlayer", "playSimpleAudio " + SimpleAudioPlayer.access$100(this.this$0));
    }
    try
    {
      if (SimpleAudioPlayer.access$200(this.this$0) != SimpleAudioPlayer.INVALID_AUDIO_STREAM) {
        SimpleAudioPlayer.access$300(this.this$0).setAudioStreamType(SimpleAudioPlayer.access$200(this.this$0));
      }
      SimpleAudioPlayer.access$300(this.this$0).prepare();
      SimpleAudioPlayer.access$300(this.this$0).start();
      if (SimpleAudioPlayer.access$400(this.this$0) > 0) {
        SimpleAudioPlayer.access$300(this.this$0).seekTo(SimpleAudioPlayer.access$400(this.this$0));
      }
      return;
    }
    catch (Exception localException)
    {
      SdkContext.getInstance().getLogger().e("SimpleAudioPlayer", "playSimpleAudio " + SimpleAudioPlayer.access$100(this.this$0) + "error: " + localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.SimpleAudioPlayer.AmrPlayerThread
 * JD-Core Version:    0.7.0.1
 */