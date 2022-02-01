package com.tencent.mobileqq.kandian.biz.video;

import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;

class VideoUIManager$8
  implements Runnable
{
  VideoUIManager$8(VideoUIManager paramVideoUIManager) {}
  
  public void run()
  {
    if ((VideoUIManager.a(this.this$0) != null) && (VideoUIManager.a(this.this$0).a != null)) {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8008ACF", "0X8008ACF", 0, 0, "", "", "", VideoReporter.a(VideoUIManager.a(this.this$0).a.mVideoVid, VideoUIManager.a(this.this$0).a.innerUniqueID, (int)VideoUIManager.a(this.this$0).a.mChannelID, null), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.VideoUIManager.8
 * JD-Core Version:    0.7.0.1
 */