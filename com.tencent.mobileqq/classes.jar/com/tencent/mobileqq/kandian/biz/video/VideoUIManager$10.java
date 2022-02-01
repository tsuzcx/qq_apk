package com.tencent.mobileqq.kandian.biz.video;

import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5.Builder;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;

class VideoUIManager$10
  implements Runnable
{
  VideoUIManager$10(VideoUIManager paramVideoUIManager, int paramInt) {}
  
  public void run()
  {
    if ((VideoUIManager.s(this.this$0) != null) && (VideoUIManager.s(this.this$0).D != null))
    {
      VideoR5.Builder localBuilder = new VideoR5.Builder("", "", VideoUIManager.s(this.this$0).D.mVideoVid, VideoUIManager.s(this.this$0).D.innerUniqueID).a((int)VideoUIManager.s(this.this$0).D.mChannelID);
      PublicAccountReportUtils.a(null, "", "0X8008AD0", "0X8008AD0", 0, 0, "", "", "", localBuilder.b().a(), false);
      PublicAccountReportUtils.a(null, "", "0X8009B57", "0X8009B57", 0, 0, String.valueOf(this.a), "", "", localBuilder.b().a(), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.VideoUIManager.10
 * JD-Core Version:    0.7.0.1
 */