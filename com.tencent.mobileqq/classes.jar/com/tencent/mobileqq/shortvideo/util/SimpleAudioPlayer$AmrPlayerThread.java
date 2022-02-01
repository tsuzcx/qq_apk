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
    Object localObject;
    if (SdkContext.getInstance().getLogger().isEnable())
    {
      Logger localLogger = SdkContext.getInstance().getLogger();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("playSimpleAudio ");
      ((StringBuilder)localObject).append(SimpleAudioPlayer.access$100(this.this$0));
      localLogger.d("SimpleAudioPlayer", ((StringBuilder)localObject).toString());
    }
    try
    {
      if (SimpleAudioPlayer.access$200(this.this$0) != SimpleAudioPlayer.INVALID_AUDIO_STREAM) {
        SimpleAudioPlayer.access$300(this.this$0).setAudioStreamType(SimpleAudioPlayer.access$200(this.this$0));
      }
      SimpleAudioPlayer.access$300(this.this$0).prepare();
      SimpleAudioPlayer.access$300(this.this$0).start();
      if (SimpleAudioPlayer.access$400(this.this$0) > 0)
      {
        SimpleAudioPlayer.access$300(this.this$0).seekTo(SimpleAudioPlayer.access$400(this.this$0));
        return;
      }
    }
    catch (Exception localException)
    {
      localObject = SdkContext.getInstance().getLogger();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("playSimpleAudio ");
      localStringBuilder.append(SimpleAudioPlayer.access$100(this.this$0));
      localStringBuilder.append("error: ");
      localStringBuilder.append(localException.toString());
      ((Logger)localObject).e("SimpleAudioPlayer", localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.SimpleAudioPlayer.AmrPlayerThread
 * JD-Core Version:    0.7.0.1
 */