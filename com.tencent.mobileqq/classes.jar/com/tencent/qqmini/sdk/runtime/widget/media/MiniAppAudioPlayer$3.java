package com.tencent.qqmini.sdk.runtime.widget.media;

import android.os.Handler;
import bhge;
import com.tencent.qqmini.sdk.log.QMLog;

public class MiniAppAudioPlayer$3
  implements Runnable
{
  public MiniAppAudioPlayer$3(bhge parambhge) {}
  
  public void run()
  {
    int i = this.this$0.c();
    QMLog.d("MiniAppAudioPlayer", "position:" + i + "duration:" + bhge.b(this.this$0) + " " + this);
    bhge.b(this.this$0, i);
    if ((bhge.a(this.this$0) != null) && (this.this$0.a() == 2)) {
      bhge.a(this.this$0).postDelayed(this, 100L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.widget.media.MiniAppAudioPlayer.3
 * JD-Core Version:    0.7.0.1
 */