package com.tencent.mobileqq.mini.widget.media;

import android.os.Handler;
import com.tencent.qphone.base.util.QLog;

class MiniAppAudioPlayer$3
  implements Runnable
{
  MiniAppAudioPlayer$3(MiniAppAudioPlayer paramMiniAppAudioPlayer) {}
  
  public void run()
  {
    int i = this.this$0.getCurrentPosition();
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppAudioPlayer", 2, "position:" + i + "duration:" + MiniAppAudioPlayer.access$400(this.this$0) + " " + this);
    }
    MiniAppAudioPlayer.access$500(this.this$0, i);
    if ((MiniAppAudioPlayer.access$600(this.this$0) != null) && (this.this$0.getState() == 2)) {
      MiniAppAudioPlayer.access$600(this.this$0).postDelayed(this, 100L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.MiniAppAudioPlayer.3
 * JD-Core Version:    0.7.0.1
 */