package com.tribe.async.dispatch;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import com.tribe.async.utils.AssertUtils;

public abstract class Subscriber$LooperSubscriber
  extends Handler
  implements Subscriber, Subscriber.IDispatchableListener<Dispatcher.Dispatchable>
{
  private static final int REQUEST_SUBMIT = 1;
  
  public Subscriber$LooperSubscriber(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleDispatch(@NonNull Dispatcher.Dispatchable paramDispatchable)
  {
    Message.obtain(this, 1, paramDispatchable).sendToTarget();
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return;
    }
    paramMessage = paramMessage.obj;
    AssertUtils.checkNotNull(paramMessage);
    onDispatch((Dispatcher.Dispatchable)paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tribe.async.dispatch.Subscriber.LooperSubscriber
 * JD-Core Version:    0.7.0.1
 */