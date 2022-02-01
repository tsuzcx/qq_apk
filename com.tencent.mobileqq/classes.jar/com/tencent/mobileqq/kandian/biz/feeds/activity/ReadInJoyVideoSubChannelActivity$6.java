package com.tencent.mobileqq.kandian.biz.feeds.activity;

import com.tencent.mobileqq.kandian.biz.share.VideoShareListener;
import com.tencent.mobileqq.kandian.glue.video.VideoPlayManager;

class ReadInJoyVideoSubChannelActivity$6
  extends VideoShareListener
{
  ReadInJoyVideoSubChannelActivity$6(ReadInJoyVideoSubChannelActivity paramReadInJoyVideoSubChannelActivity) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (!paramBoolean1)
    {
      ReadInJoyVideoSubChannelActivity.b(this.a, false);
      return;
    }
    if (ReadInJoyVideoSubChannelActivity.b(this.a))
    {
      ReadInJoyVideoSubChannelActivity.c(this.a).v();
      ReadInJoyVideoSubChannelActivity.b(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyVideoSubChannelActivity.6
 * JD-Core Version:    0.7.0.1
 */