package com.tencent.mobileqq.video;

import android.os.SystemClock;
import bdvn;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

public class VipVideoPlayActivity$VideoPlayerPreparedListener$1
  implements Runnable
{
  public VipVideoPlayActivity$VideoPlayerPreparedListener$1(bdvn parambdvn) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.video.VipVideoPlayActivity.VideoPlayerPreparedListener.1
 * JD-Core Version:    0.7.0.1
 */