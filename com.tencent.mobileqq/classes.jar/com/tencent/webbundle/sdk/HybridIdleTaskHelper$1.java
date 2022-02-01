package com.tencent.webbundle.sdk;

import android.os.MessageQueue.IdleHandler;
import java.util.List;

class HybridIdleTaskHelper$1
  implements MessageQueue.IdleHandler
{
  HybridIdleTaskHelper$1(HybridIdleTaskHelper paramHybridIdleTaskHelper) {}
  
  public boolean queueIdle()
  {
    int i;
    do
    {
      if (HybridIdleTaskHelper.access$000(this.this$0).isEmpty()) {
        break;
      }
      localObject = (HybridIdleTaskHelper.IdleTask)HybridIdleTaskHelper.access$000(this.this$0).remove(0);
      i = ((HybridIdleTaskHelper.IdleTask)localObject).run();
      if (2 == i)
      {
        HybridIdleTaskHelper.access$000(this.this$0).add(localObject);
        break;
      }
    } while (1 != i);
    Object localObject = this.this$0;
    boolean bool = true ^ HybridIdleTaskHelper.access$000((HybridIdleTaskHelper)localObject).isEmpty();
    ((HybridIdleTaskHelper)localObject).sIsIdleHandlerInQueue = bool;
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.webbundle.sdk.HybridIdleTaskHelper.1
 * JD-Core Version:    0.7.0.1
 */