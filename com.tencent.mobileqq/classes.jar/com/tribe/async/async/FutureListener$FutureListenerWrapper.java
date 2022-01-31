package com.tribe.async.async;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import com.tribe.async.utils.AssertUtils;

public class FutureListener$FutureListenerWrapper<Progress, Result>
  extends Handler
  implements FutureListener<Progress, Result>
{
  private static final int REQUEST_CANCEL = 1;
  private static final int REQUEST_DONE = 3;
  private static final int REQUEST_PROGRESS = 2;
  private FutureListener listener;
  
  public FutureListener$FutureListenerWrapper(Looper paramLooper, FutureListener paramFutureListener)
  {
    super(paramLooper);
    this.listener = paramFutureListener;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      this.listener.onFutureCanceled();
      return;
    case 2: 
      AssertUtils.checkNotNull(paramMessage.obj);
      this.listener.onFutureProgress(paramMessage.obj);
      return;
    }
    this.listener.onFutureDone(paramMessage.obj);
  }
  
  public void onFutureCanceled()
  {
    Message.obtain(this, 1).sendToTarget();
  }
  
  public void onFutureDone(Result paramResult)
  {
    Message.obtain(this, 3, paramResult).sendToTarget();
  }
  
  public void onFutureProgress(@NonNull Progress paramProgress)
  {
    Message.obtain(this, 2, paramProgress).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tribe.async.async.FutureListener.FutureListenerWrapper
 * JD-Core Version:    0.7.0.1
 */