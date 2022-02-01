package com.tencent.mobileqq.kandian.biz.playfeeds;

import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.UGDownloadInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class VideoFeedsDiversionHandler$handleDiversionPriority$5
  extends Lambda
  implements Function0<Unit>
{
  VideoFeedsDiversionHandler$handleDiversionPriority$5(VideoInfo paramVideoInfo)
  {
    super(0);
  }
  
  public final void invoke()
  {
    UGDownloadInfo localUGDownloadInfo1 = this.$videoInfo.a;
    UGDownloadInfo localUGDownloadInfo2 = this.$videoInfo.b;
    VideoFeedsDiversionHandler.a(VideoFeedsDiversionHandler.a, this.$videoInfo);
    VideoInfo localVideoInfo = this.$videoInfo;
    localVideoInfo.a = localUGDownloadInfo1;
    localVideoInfo.b = localUGDownloadInfo2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsDiversionHandler.handleDiversionPriority.5
 * JD-Core Version:    0.7.0.1
 */