package com.tencent.qqmini.miniapp.widget.media;

import android.os.Handler;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class MiniAppAudioPlayer$2
  implements Runnable
{
  MiniAppAudioPlayer$2(MiniAppAudioPlayer paramMiniAppAudioPlayer) {}
  
  public void run()
  {
    int i = this.this$0.getCurrentPosition();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("position:");
    localStringBuilder.append(i);
    localStringBuilder.append("duration:");
    localStringBuilder.append(MiniAppAudioPlayer.access$400(this.this$0));
    localStringBuilder.append(" ");
    localStringBuilder.append(this);
    QMLog.d("MiniAppAudioPlayer", localStringBuilder.toString());
    MiniAppAudioPlayer.access$500(this.this$0, i);
    if ((MiniAppAudioPlayer.access$600(this.this$0) != null) && (this.this$0.getState() == 2)) {
      MiniAppAudioPlayer.access$600(this.this$0).postDelayed(this, 100L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.media.MiniAppAudioPlayer.2
 * JD-Core Version:    0.7.0.1
 */