package com.tencent.mobileqq.kandian.repo.feeds;

import java.util.List;

class ChannelInfoModule$4
  implements Runnable
{
  ChannelInfoModule$4(ChannelInfoModule paramChannelInfoModule, boolean paramBoolean, List paramList) {}
  
  public void run()
  {
    if (!this.a)
    {
      ReadInJoyLogicEngineEventDispatcher.a().d(false, null);
      return;
    }
    SpecialChannelFilter.a().a(this.b);
    this.this$0.g(this.b);
    ReadInJoyLogicEngineEventDispatcher.a().d(this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.ChannelInfoModule.4
 * JD-Core Version:    0.7.0.1
 */