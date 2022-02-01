package com.tencent.mobileqq.kandian.biz.gifvideo.base.video;

import com.tencent.mobileqq.kandian.base.video.player.api.IPlayer;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class VideoMaskController$seekPlayer$1
  implements Runnable
{
  public final void run()
  {
    IPlayer localIPlayer = this.this$0.a();
    if (localIPlayer != null) {
      localIPlayer.a(this.a * 1000, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.gifvideo.base.video.VideoMaskController.seekPlayer.1
 * JD-Core Version:    0.7.0.1
 */