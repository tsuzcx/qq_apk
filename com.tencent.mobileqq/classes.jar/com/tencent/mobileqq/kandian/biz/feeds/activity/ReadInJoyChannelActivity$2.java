package com.tencent.mobileqq.kandian.biz.feeds.activity;

import com.tencent.mobileqq.kandian.glue.report.ReadInJoyGlobalReporter;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;

class ReadInJoyChannelActivity$2
  implements Runnable
{
  ReadInJoyChannelActivity$2(ReadInJoyChannelActivity paramReadInJoyChannelActivity) {}
  
  public void run()
  {
    ReadInJoyGlobalReporter.a().a(true);
    ReadInJoyGlobalReporter.a().b(this.this$0.app, NetConnInfoCenter.getServerTimeMillis(), -1, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyChannelActivity.2
 * JD-Core Version:    0.7.0.1
 */