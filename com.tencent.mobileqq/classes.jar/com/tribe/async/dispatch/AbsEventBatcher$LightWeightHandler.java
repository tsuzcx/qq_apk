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
    if (???.what != 1) {}
    do
    {
      return;
      if (!AbsEventBatcher.access$000(this.this$0).compareAndSet(2, 3))
      {
        SLog.w("async.dispatch.LightWeightExecutor", "Threre should not be STATE_BATCHING state. state = " + AbsEventBatcher.access$000(this.this$0));
        AbsEventBatcher.access$000(this.this$0).set(3);
      }
      long l1 = SystemClock.uptimeMillis();
      do
      {
        synchronized (this.this$0)
        {
          Object localObject1 = AbsEventBatcher.access$100(this.this$0).poll();
          if (localObject1 == null)
          {
            if (!AbsEventBatcher.access$000(this.this$0).compareAndSet(3, 1))
            {
              SLog.d("async.dispatch.LightWeightExecutor", "The state should be STATE_EXECUTING, state = " + AbsEventBatcher.access$000(this.this$0));
              AbsEventBatcher.access$000(this.this$0).set(1);
            }
            return;
          }
        }
        AbsEventBatcher.access$210(this.this$0);
        long l2 = SystemClock.uptimeMillis();
        this.this$0.handleItem(localObject2);
        l2 = SystemClock.uptimeMillis() - l2;
        if (l2 > 50L) {
          SLog.w("async.dispatch.LightWeightExecutor", "handle item %d ms!, item = %s", new Object[] { Long.valueOf(l2), localObject2 });
        }
      } while (SystemClock.uptimeMillis() - l1 < AbsEventBatcher.access$300(this.this$0));
    } while (sendEmptyMessage(1));
    throw new DispatcherException("Could not send handler message");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tribe.async.dispatch.AbsEventBatcher.LightWeightHandler
 * JD-Core Version:    0.7.0.1
 */