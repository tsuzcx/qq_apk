package com.tencent.mobileqq.video;

import android.os.SystemClock;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

class VipVideoPlayActivity$VideoPlayerPreparedListener$1
  implements Runnable
{
  VipVideoPlayActivity$VideoPlayerPreparedListener$1(VipVideoPlayActivity.VideoPlayerPreparedListener paramVideoPlayerPreparedListener) {}
  
  public void run()
  {
    long l1 = SystemClock.elapsedRealtime();
    long l2 = VipVideoPlayActivity.a(this.a.a);
    this.a.a.a("play_success", 0, 0, l1 - l2, "");
    if (VipVideoPlayActivity.a(this.a.a) != null) {
      VipVideoPlayActivity.a(this.a.a).start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.video.VipVideoPlayActivity.VideoPlayerPreparedListener.1
 * JD-Core Version:    0.7.0.1
 */