package com.tencent.mobileqq.kandian.biz.playfeeds;

import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo.ECommerceEntranceInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class VideoFeedsDiversionHandler$handleDiversionPriority$6
  extends Lambda
  implements Function0<Unit>
{
  VideoFeedsDiversionHandler$handleDiversionPriority$6(VideoInfo paramVideoInfo)
  {
    super(0);
  }
  
  public final void invoke()
  {
    VideoInfo.ECommerceEntranceInfo localECommerceEntranceInfo = this.$videoInfo.a;
    VideoFeedsDiversionHandler.b(VideoFeedsDiversionHandler.a, this.$videoInfo);
    this.$videoInfo.a = localECommerceEntranceInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsDiversionHandler.handleDiversionPriority.6
 * JD-Core Version:    0.7.0.1
 */