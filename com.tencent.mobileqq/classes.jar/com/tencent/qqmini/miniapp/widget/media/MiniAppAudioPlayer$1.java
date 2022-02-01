package com.tencent.qqmini.miniapp.widget.media;

import android.media.MediaPlayer;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class MiniAppAudioPlayer$1
  implements Runnable
{
  MiniAppAudioPlayer$1(MiniAppAudioPlayer paramMiniAppAudioPlayer) {}
  
  public void run()
  {
    if (MiniAppAudioPlayer.access$000(this.this$0) == null) {
      return;
    }
    try
    {
      MiniAppAudioPlayer.access$000(this.this$0).start();
      MiniAppAudioPlayer.access$100(this.this$0, 2);
      if (MiniAppAudioPlayer.access$200(this.this$0) > 0)
      {
        this.this$0.seekTo(MiniAppAudioPlayer.access$200(this.this$0));
        return;
      }
    }
    catch (Exception localException)
    {
      MiniAppAudioPlayer.access$300(this.this$0, 1, 0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mStartRunnable.....");
      localStringBuilder.append(localException);
      QMLog.d("MiniAppAudioPlayer", localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.media.MiniAppAudioPlayer.1
 * JD-Core Version:    0.7.0.1
 */