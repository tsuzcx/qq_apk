package com.tencent.tkd.topicsdk.widget.videocrop;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class VideoCropPage$onFramesClipChanged$1
  extends Lambda
  implements Function0<Unit>
{
  VideoCropPage$onFramesClipChanged$1(VideoCropPage paramVideoCropPage, int paramInt1, int paramInt2)
  {
    super(0);
  }
  
  public final void invoke()
  {
    if (VideoCropPage.d(this.this$0).isPlaying()) {
      VideoCropPage.d(this.this$0).pause();
    }
    FixedSizeVideoView localFixedSizeVideoView = VideoCropPage.d(this.this$0);
    int i = this.$startTime;
    localFixedSizeVideoView.setPlayDuration(i, this.$endTime - i);
    VideoCropPage.d(this.this$0).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.videocrop.VideoCropPage.onFramesClipChanged.1
 * JD-Core Version:    0.7.0.1
 */