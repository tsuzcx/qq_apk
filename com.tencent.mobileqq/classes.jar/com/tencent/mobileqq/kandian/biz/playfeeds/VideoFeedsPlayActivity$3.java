package com.tencent.mobileqq.kandian.biz.playfeeds;

import com.tencent.mobileqq.colornote.IServiceInfo;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNote.Builder;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyLauncher;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.glue.video.VideoResumeManager;

class VideoFeedsPlayActivity$3
  implements IServiceInfo
{
  VideoFeedsPlayActivity$3(VideoFeedsPlayActivity paramVideoFeedsPlayActivity) {}
  
  public ColorNote getColorNote()
  {
    Object localObject1 = VideoFeedsPlayActivity.a(this.a);
    if (localObject1 == null) {
      return null;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(ReadInJoyLauncher.a);
    ((StringBuilder)localObject2).append(((VideoInfo)localObject1).g);
    localObject2 = ((StringBuilder)localObject2).toString();
    Object localObject3 = VideoFeedsPlayActivity.a(this.a);
    long l = 0L;
    if ((localObject3 != null) && (VideoFeedsPlayActivity.a(this.a).getSubType().equals(localObject2)))
    {
      localObject1 = VideoFeedsPlayActivity.a(this.a);
      if (!VideoResumeManager.a.a()) {
        l = VideoFeedsPlayActivity.a(this.a);
      }
      ((ColorNote)localObject1).mExtLong = l;
      return VideoFeedsPlayActivity.a(this.a);
    }
    localObject3 = this.a;
    localObject1 = new ColorNote.Builder().a(16908290).a((String)localObject2).b(((VideoInfo)localObject1).c).c(((VideoInfo)localObject1).k).d(((VideoInfo)localObject1).b).a(VideoFeedsHelper.a((VideoInfo)localObject1));
    if (!VideoResumeManager.a.a()) {
      l = VideoFeedsPlayActivity.a(this.a);
    }
    VideoFeedsPlayActivity.a((VideoFeedsPlayActivity)localObject3, ((ColorNote.Builder)localObject1).a(l).a());
    return VideoFeedsPlayActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsPlayActivity.3
 * JD-Core Version:    0.7.0.1
 */