package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack;

import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scale.ScaleCalculator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "currentPx", "", "sourceTime", "invoke", "com/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackDataTransHelperKt$transVideoTrackModelToClipModel$1$getTime$1"}, k=3, mv={1, 1, 16})
final class VideoTrackDataTransHelperKt$transVideoTrackModelToClipModel$$inlined$run$lambda$1
  extends Lambda
  implements Function2<Integer, Long, Long>
{
  VideoTrackDataTransHelperKt$transVideoTrackModelToClipModel$$inlined$run$lambda$1(boolean paramBoolean, ScaleCalculator paramScaleCalculator)
  {
    super(2);
  }
  
  public final long invoke(int paramInt, long paramLong)
  {
    if (this.$scaleCalculator$inlined.b(paramLong) == paramInt) {
      return paramLong;
    }
    return this.$scaleCalculator$inlined.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.VideoTrackDataTransHelperKt.transVideoTrackModelToClipModel..inlined.run.lambda.1
 * JD-Core Version:    0.7.0.1
 */