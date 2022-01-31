package com.tribe.async.dispatch;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import com.tribe.async.log.SLog;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class AbsEventBatcher<EVENT>
{
  private static final boolean DEBUG = false;
  private static final int MAX_BATCHING_TIME = 30;
  private static final int MSG_POST = 1;
  private static final int STATE_BATCHING = 2;
  private static final int STATE_EXECUTING = 3;
  private static final int STATE_WAIT_EVENT = 1;
  private static final String TAG = "async.dispatch.LightWeightExecutor";
  private int mEnqueueSize;
  private final Handler mHandler;
  private final int mMaxMillisInsideHandleMessage;
  private final SimpleQueue<EVENT> mQueue;
  private AtomicInteger mState = new AtomicInteger(1);
  
  public AbsEventBatcher(Looper paramLooper, SimpleQueue<EVENT> paramSimpleQueue, int paramInt)
  {
    this.mQueue = paramSimpleQueue;
    this.mHandler = new LightWeightHandler(paramLooper);
    this.mMaxMillisInsideHandleMessage = paramInt;
  }
  
  public void dumpAllEvent()
  {
    try
    {
      this.mQueue.dump();
      return;
    }
    finally {}
  }
  
  public void enqueue(@NonNull EVENT paramEVENT)
  {
    try
    {
      this.mQueue.enqueue(paramEVENT);
      this.mEnqueueSize += 1;
      if ((this.mState.compareAndSet(1, 2)) && (!this.mHandler.sendEmptyMessageDelayed(1, 30L))) {
        throw new RuntimeException("Could not send handler message");
      }
    }
    finally {}
  }
  
  public int getCurState()
  {
    return this.mState.get();
  }
  
  public int getEnqueueSize()
  {
    return this.mEnqueueSize;
  }
  
  protected abstract void handleItem(EVENT paramEVENT);
  
  private class LightWeightHandler
    extends Handler
  {
    public LightWeightHandler(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message arg1)
    {
      if (???.what != 1) {}
      do
      {
        return;
        if (!AbsEventBatcher.this.mState.compareAndSet(2, 3))
        {
          SLog.w("async.dispatch.LightWeightExecutor", "Threre should not be STATE_BATCHING state. state = " + AbsEventBatcher.this.mState);
          AbsEventBatcher.this.mState.set(3);
        }
        long l1 = SystemClock.uptimeMillis();
        do
        {
          synchronized (AbsEventBatcher.this)
          {
            Object localObject1 = AbsEventBatcher.this.mQueue.poll();
            if (localObject1 == null)
            {
              if (!AbsEventBatcher.this.mState.compareAndSet(3, 1))
              {
                SLog.d("async.dispatch.LightWeightExecutor", "The state should be STATE_EXECUTING, state = " + AbsEventBatcher.this.mState);
                AbsEventBatcher.this.mState.set(1);
              }
              return;
            }
          }
          AbsEventBatcher.access$210(AbsEventBatcher.this);
          long l2 = SystemClock.uptimeMillis();
          AbsEventBatcher.this.handleItem(localObject2);
          l2 = SystemClock.uptimeMillis() - l2;
          if (l2 > 50L) {
            SLog.w("async.dispatch.LightWeightExecutor", "handle item %d ms!, item = %s", new Object[] { Long.valueOf(l2), localObject2 });
          }
        } while (SystemClock.uptimeMillis() - l1 < AbsEventBatcher.this.mMaxMillisInsideHandleMessage);
      } while (sendEmptyMessage(1));
      throw new DispatcherException("Could not send handler message");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tribe.async.dispatch.AbsEventBatcher
 * JD-Core Version:    0.7.0.1
 */