package com.tencent.mobileqq.kandian.biz.playfeeds;

import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run", "com/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsReporter$doReportOnCenterViewChanged$1$1"}, k=3, mv={1, 1, 16})
final class VideoFeedsReporter$doReportOnCenterViewChanged$$inlined$also$lambda$1
  implements Runnable
{
  VideoFeedsReporter$doReportOnCenterViewChanged$$inlined$also$lambda$1(VideoFeedsReporter paramVideoFeedsReporter, VideoInfo paramVideoInfo, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4) {}
  
  public final void run()
  {
    VideoFeedsReporter localVideoFeedsReporter = this.this$0;
    VideoInfo localVideoInfo = this.a;
    if (localVideoInfo != null)
    {
      VideoFeedsReporter.a(localVideoFeedsReporter, localVideoInfo, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsReporter.doReportOnCenterViewChanged..inlined.also.lambda.1
 * JD-Core Version:    0.7.0.1
 */