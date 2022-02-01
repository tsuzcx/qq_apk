package com.tencent.mobileqq.ptt.player;

import android.media.MediaPlayer;
import azts;
import bkgm;
import com.tencent.qphone.base.util.QLog;

class AmrPlayer$AmrPlayerThread
  extends Thread
{
  private AmrPlayer$AmrPlayerThread(AmrPlayer paramAmrPlayer) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AmrPlayer", 2, "playAmr AmrPlayerThread " + AmrPlayer.a(this.this$0));
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("AmrPlayer", 2, "playAmr AmrPlayerThread onPlayThreadStart");
      }
      AmrPlayer.a(this.this$0).f();
      if (QLog.isColorLevel()) {
        QLog.d("AmrPlayer", 2, "playAmr AmrPlayerThread start");
      }
      AmrPlayer.a(this.this$0).start();
      if (AmrPlayer.a(this.this$0, AmrPlayer.a(this.this$0) - 1000) > 0) {
        AmrPlayer.a(this.this$0).seekTo(AmrPlayer.a(this.this$0));
      }
      return;
    }
    catch (Exception localException)
    {
      while (AmrPlayer.a(this.this$0) == null) {}
      AmrPlayer.a(this.this$0).sendEmptyMessage(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.player.AmrPlayer.AmrPlayerThread
 * JD-Core Version:    0.7.0.1
 */