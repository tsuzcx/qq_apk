package com.tencent.mobileqq.kandian.biz.gifvideo.base.video;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class VideoPlayController$executeOnMainThread$1
  implements Runnable
{
  VideoPlayController$executeOnMainThread$1(VideoPlayController paramVideoPlayController, Function0 paramFunction0) {}
  
  public final void run()
  {
    VideoView localVideoView = this.this$0.a();
    if (localVideoView != null) {
      try
      {
        this.a.invoke();
        Unit localUnit = Unit.INSTANCE;
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.gifvideo.base.video.VideoPlayController.executeOnMainThread.1
 * JD-Core Version:    0.7.0.1
 */