package com.tencent.webbundle.sdk;

import android.os.MessageQueue.IdleHandler;
import java.util.List;

class HybridIdleTaskHelper$1
  implements MessageQueue.IdleHandler
{
  HybridIdleTaskHelper$1(HybridIdleTaskHelper paramHybridIdleTaskHelper) {}
  
  public boolean queueIdle()
  {
    Object localObject;
    int i;
    if (!HybridIdleTaskHelper.access$000(this.this$0).isEmpty())
    {
      localObject = (HybridIdleTaskHelper.IdleTask)HybridIdleTaskHelper.access$000(this.this$0).remove(0);
      i = ((HybridIdleTaskHelper.IdleTask)localObject).run();
      if (2 == i) {
        HybridIdleTaskHelper.access$000(this.this$0).add(localObject);
      }
    }
    else
    {
      label56:
      localObject = this.this$0;
      if (HybridIdleTaskHelper.access$000(this.this$0).isEmpty()) {
        break label93;
      }
    }
    label93:
    for (boolean bool = true;; bool = false)
    {
      ((HybridIdleTaskHelper)localObject).sIsIdleHandlerInQueue = bool;
      return bool;
      if (1 != i) {
        break;
      }
      break label56;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.webbundle.sdk.HybridIdleTaskHelper.1
 * JD-Core Version:    0.7.0.1
 */