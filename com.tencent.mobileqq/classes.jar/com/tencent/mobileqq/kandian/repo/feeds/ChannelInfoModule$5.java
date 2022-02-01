package com.tencent.mobileqq.kandian.repo.feeds;

import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import java.util.List;

class ChannelInfoModule$5
  implements Runnable
{
  ChannelInfoModule$5(ChannelInfoModule paramChannelInfoModule, boolean paramBoolean1, boolean paramBoolean2, List paramList1, List paramList2) {}
  
  public void run()
  {
    if (!this.a)
    {
      ReadInJoyLogicEngineEventDispatcher.a().c(false, null);
      return;
    }
    if (this.b)
    {
      ReadInJoyLogicEngineEventDispatcher.a().c(true, this.c);
      return;
    }
    ChannelInfoModule.a(this.this$0, true);
    this.this$0.a(this.c, true);
    this.this$0.g(this.d);
    if (!RIJQQAppInterfaceUtil.g())
    {
      Object localObject = this.this$0.e(this.c);
      SpecialChannelFilter.a().a(this.d);
      SpecialChannelFilter.a().b((List)localObject);
      localObject = this.this$0.m();
      if (!this.d.equals(localObject))
      {
        localObject = this.this$0;
        ((ChannelInfoModule)localObject).f(((ChannelInfoModule)localObject).m());
      }
    }
    ReadInJoyLogicEngineEventDispatcher.a().b(true, this.this$0.i());
    if (!RIJQQAppInterfaceUtil.g())
    {
      ReadInJoyLogicEngineEventDispatcher.a().c(true, this.this$0.j());
      return;
    }
    ReadInJoyLogicEngineEventDispatcher.a().c(true, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.ChannelInfoModule.5
 * JD-Core Version:    0.7.0.1
 */