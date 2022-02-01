package com.tencent.mobileqq.kandian.biz.share;

import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelInfo;

class TopicShareHelper$5
  implements Runnable
{
  TopicShareHelper$5(TopicShareHelper paramTopicShareHelper, String paramString) {}
  
  public void run()
  {
    PublicAccountReportUtils.a(null, "", "0X80088B4", "0X80088B4", 0, 0, "", this.a, "", VideoReporter.a(TopicShareHelper.f(this.this$0).mChannelID, null), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.TopicShareHelper.5
 * JD-Core Version:    0.7.0.1
 */