package com.tencent.mobileqq.kandian.biz.feeds.activity;

import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelInfo;

class ReadInJoyVideoSubChannelActivity$8
  implements Runnable
{
  ReadInJoyVideoSubChannelActivity$8(ReadInJoyVideoSubChannelActivity paramReadInJoyVideoSubChannelActivity, ChannelInfo paramChannelInfo, boolean paramBoolean) {}
  
  public void run()
  {
    String str1;
    if ((ReadInJoyVideoSubChannelActivity.e(this.this$0) != 4) && (ReadInJoyVideoSubChannelActivity.e(this.this$0) != 6))
    {
      if (ReadInJoyVideoSubChannelActivity.e(this.this$0) == 8) {
        str1 = "1";
      } else if (ReadInJoyVideoSubChannelActivity.e(this.this$0) == 4) {
        str1 = "2";
      } else {
        str1 = "3";
      }
    }
    else {
      str1 = "0";
    }
    String str2;
    if (this.a.mIsTopic)
    {
      if (this.b) {
        str2 = "1";
      } else {
        str2 = "2";
      }
      PublicAccountReportUtils.a(null, "", "0X80088BC", "0X80088BC", 0, 0, str2, str1, "", VideoReporter.a(ReadInJoyVideoSubChannelActivity.a(this.this$0), null), false);
      return;
    }
    if (this.b) {
      str2 = "1";
    } else {
      str2 = "2";
    }
    PublicAccountReportUtils.a(null, "", "0X8007BFE", "0X8007BFE", 0, 0, str2, str1, "", VideoReporter.a(ReadInJoyVideoSubChannelActivity.a(this.this$0), null), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyVideoSubChannelActivity.8
 * JD-Core Version:    0.7.0.1
 */