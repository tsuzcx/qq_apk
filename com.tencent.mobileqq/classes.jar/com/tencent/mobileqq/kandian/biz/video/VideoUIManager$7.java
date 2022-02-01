package com.tencent.mobileqq.kandian.biz.video;

import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;

class VideoUIManager$7
  implements Runnable
{
  VideoUIManager$7(VideoUIManager paramVideoUIManager) {}
  
  public void run()
  {
    if ((VideoUIManager.s(this.this$0) != null) && (VideoUIManager.s(this.this$0).D != null)) {
      PublicAccountReportUtils.a(null, "", "0X8008ACD", "0X8008ACD", 0, 0, "", "", "", VideoReporter.a(VideoUIManager.s(this.this$0).D.mVideoVid, VideoUIManager.s(this.this$0).D.innerUniqueID, (int)VideoUIManager.s(this.this$0).D.mChannelID, null), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.VideoUIManager.7
 * JD-Core Version:    0.7.0.1
 */