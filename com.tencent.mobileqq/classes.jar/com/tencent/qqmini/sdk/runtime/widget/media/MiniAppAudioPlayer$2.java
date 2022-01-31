package com.tencent.qqmini.sdk.runtime.widget.media;

import android.media.MediaPlayer;
import bhge;
import com.tencent.qqmini.sdk.log.QMLog;

public class MiniAppAudioPlayer$2
  implements Runnable
{
  public MiniAppAudioPlayer$2(bhge parambhge) {}
  
  public void run()
  {
    if (bhge.a(this.this$0) == null) {}
    for (;;)
    {
      return;
      try
      {
        bhge.a(this.this$0).start();
        bhge.a(this.this$0, 2);
        if (bhge.a(this.this$0) > 0)
        {
          this.this$0.b(bhge.a(this.this$0));
          return;
        }
      }
      catch (Exception localException)
      {
        bhge.a(this.this$0, 1, 0);
        QMLog.d("MiniAppAudioPlayer", "mStartRunnable....." + localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.widget.media.MiniAppAudioPlayer.2
 * JD-Core Version:    0.7.0.1
 */