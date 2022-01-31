package com.tencent.mobileqq.mini.widget.media;

import android.media.MediaPlayer;
import com.tencent.qphone.base.util.QLog;

class MiniAppAudioPlayer$2
  implements Runnable
{
  MiniAppAudioPlayer$2(MiniAppAudioPlayer paramMiniAppAudioPlayer) {}
  
  public void run()
  {
    if (MiniAppAudioPlayer.access$000(this.this$0) == null) {}
    do
    {
      for (;;)
      {
        return;
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
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("MiniAppAudioPlayer", 2, "mStartRunnable....." + localException);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.MiniAppAudioPlayer.2
 * JD-Core Version:    0.7.0.1
 */