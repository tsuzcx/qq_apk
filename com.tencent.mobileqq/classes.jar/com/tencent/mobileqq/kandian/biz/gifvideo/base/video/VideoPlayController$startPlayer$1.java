package com.tencent.mobileqq.kandian.biz.gifvideo.base.video;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class VideoPlayController$startPlayer$1
  extends Lambda
  implements Function0<Unit>
{
  VideoPlayController$startPlayer$1(VideoPlayController paramVideoPlayController, Function0 paramFunction0)
  {
    super(0);
  }
  
  public final void invoke()
  {
    if (this.this$0.q())
    {
      VideoPlayController.b(this.this$0);
      VideoPlayListener localVideoPlayListener = this.this$0.e();
      if (localVideoPlayListener != null) {
        localVideoPlayListener.a();
      }
      this.$runnable.invoke();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.gifvideo.base.video.VideoPlayController.startPlayer.1
 * JD-Core Version:    0.7.0.1
 */