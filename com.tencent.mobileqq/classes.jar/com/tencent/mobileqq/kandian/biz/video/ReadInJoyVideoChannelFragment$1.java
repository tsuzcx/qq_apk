package com.tencent.mobileqq.kandian.biz.video;

import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter;
import com.tencent.mobileqq.qroute.QRoute;

class ReadInJoyVideoChannelFragment$1
  implements Runnable
{
  ReadInJoyVideoChannelFragment$1(ReadInJoyVideoChannelFragment paramReadInJoyVideoChannelFragment) {}
  
  public void run()
  {
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007C41", "0X8007C41", 0, 0, "0", "0", "", VideoReporter.a(56, null), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.ReadInJoyVideoChannelFragment.1
 * JD-Core Version:    0.7.0.1
 */