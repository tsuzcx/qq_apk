package com.tribe.async.dispatch;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
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
    this.mHandler = new AbsEventBatcher.LightWeightHandler(this, paramLooper);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tribe.async.dispatch.AbsEventBatcher
 * JD-Core Version:    0.7.0.1
 */