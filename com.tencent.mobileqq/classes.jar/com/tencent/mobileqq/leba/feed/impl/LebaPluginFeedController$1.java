package com.tencent.mobileqq.leba.feed.impl;

import com.tencent.mobileqq.leba.core.LebaShowListManager;
import java.util.List;

class LebaPluginFeedController$1
  implements Runnable
{
  LebaPluginFeedController$1(LebaPluginFeedController paramLebaPluginFeedController, boolean paramBoolean) {}
  
  public void run()
  {
    List localList = LebaShowListManager.a().b(LebaPluginFeedController.a(this.this$0));
    this.this$0.a(localList, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.feed.impl.LebaPluginFeedController.1
 * JD-Core Version:    0.7.0.1
 */