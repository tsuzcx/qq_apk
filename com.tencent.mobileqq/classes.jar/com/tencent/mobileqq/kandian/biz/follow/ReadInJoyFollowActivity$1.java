package com.tencent.mobileqq.kandian.biz.follow;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyChannelViewController;

class ReadInJoyFollowActivity$1
  implements View.OnClickListener
{
  ReadInJoyFollowActivity$1(ReadInJoyFollowActivity paramReadInJoyFollowActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.a.a(true);
    ThreadManager.executeOnSubThread(new ReadInJoyFollowActivity.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.follow.ReadInJoyFollowActivity.1
 * JD-Core Version:    0.7.0.1
 */