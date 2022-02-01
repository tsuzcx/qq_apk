package com.tencent.mobileqq.kandian.biz.pts.component;

import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;

class ComponentLastRead$2
  implements Runnable
{
  ComponentLastRead$2(ComponentLastRead paramComponentLastRead) {}
  
  public void run()
  {
    if (this.this$0.a.a.s())
    {
      ReadInJoyLogicEngineEventDispatcher.a().a(this.this$0);
      return;
    }
    if (this.this$0.a.a.m() == 0) {
      ReadInJoyLogicEngineEventDispatcher.a().a(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentLastRead.2
 * JD-Core Version:    0.7.0.1
 */