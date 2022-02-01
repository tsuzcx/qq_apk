package com.tribe.async.dispatch;

import android.support.annotation.NonNull;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;

public abstract class Subscriber$EventBatchSubscriber
  implements Subscriber, Subscriber.IDispatchableListener<Dispatcher.Dispatchable>
{
  public final void handleDispatch(@NonNull Dispatcher.Dispatchable paramDispatchable)
  {
    Bosses.get().postLightWeightJob(new Subscriber.EventBatchSubscriber.InnerJob(this, paramDispatchable), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tribe.async.dispatch.Subscriber.EventBatchSubscriber
 * JD-Core Version:    0.7.0.1
 */