package com.tribe.async.dispatch;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tribe.async.log.SLog;
import java.util.concurrent.atomic.AtomicInteger;

class AbsEventBatcher$LightWeightHandler
  extends Handler
{
  public AbsEventBatcher$LightWeightHandler(AbsEventBatcher paramAbsEventBatcher, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message arg1)
  {
    if (???.what != 1) {
      return;
    }
    if (!AbsEventBatcher.access$000(this.this$0).compareAndSet(2, 3))
    {
      ??? = new StringBuilder();
      ???.append("Threre should not be STATE_BATCHING state. state = ");
      ???.append(AbsEventBatcher.access$000(this.this$0));
      SLog.w("async.dispatch.LightWeightExecutor", ???.toString());
      AbsEventBatcher.access$000(this.this$0).set(3);
    }
    long l1 = SystemClock.uptimeMillis();
    synchronized (this.this$0)
    {
      do
      {
        Object localObject1 = AbsEventBatcher.access$100(this.this$0).poll();
        if (localObject1 == null)
        {
          if (!AbsEventBatcher.access$000(this.this$0).compareAndSet(3, 1))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("The state should be STATE_EXECUTING, state = ");
            ((StringBuilder)localObject1).append(AbsEventBatcher.access$000(this.this$0));
            SLog.d("async.dispatch.LightWeightExecutor", ((StringBuilder)localObject1).toString());
            AbsEventBatcher.access$000(this.this$0).set(1);
          }
          return;
        }
        AbsEventBatcher.access$210(this.this$0);
        long l2 = SystemClock.uptimeMillis();
        this.this$0.handleItem(localObject1);
        l2 = SystemClock.uptimeMillis() - l2;
        if (l2 > 50L) {
          SLog.w("async.dispatch.LightWeightExecutor", "handle item %d ms!, item = %s", new Object[] { Long.valueOf(l2), localObject1 });
        }
      } while (SystemClock.uptimeMillis() - l1 < AbsEventBatcher.access$300(this.this$0));
      if (sendEmptyMessage(1)) {
        return;
      }
      throw new DispatcherException("Could not send handler message");
    }
    for (;;)
    {
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tribe.async.dispatch.AbsEventBatcher.LightWeightHandler
 * JD-Core Version:    0.7.0.1
 */