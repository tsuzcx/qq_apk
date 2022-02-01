package com.tribe.async.dispatch;

import android.support.annotation.NonNull;
import com.tribe.async.utils.AssertUtils;
import java.util.List;

public class Subscriber$EventBatchSubscriberWrapper
  extends Subscriber.EventBatchSubscriber
{
  private final Subscriber mSubscriber;
  
  public Subscriber$EventBatchSubscriberWrapper(Subscriber paramSubscriber)
  {
    AssertUtils.checkNotNull(paramSubscriber);
    this.mSubscriber = paramSubscriber;
  }
  
  public void accept(@NonNull List<Class<? extends Dispatcher.Dispatchable>> paramList)
  {
    this.mSubscriber.accept(paramList);
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof Subscriber.SubscriberWrapper)) {
      return Subscriber.SubscriberWrapper.access$000((Subscriber.SubscriberWrapper)paramObject).equals(this.mSubscriber);
    }
    if ((paramObject instanceof Subscriber.LooperSubscriber)) {
      return paramObject.equals(this.mSubscriber);
    }
    if ((paramObject instanceof Subscriber)) {
      return paramObject.equals(this.mSubscriber);
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.mSubscriber.hashCode();
  }
  
  public void onDispatch(@NonNull Dispatcher.Dispatchable paramDispatchable)
  {
    this.mSubscriber.handleDispatch(paramDispatchable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tribe.async.dispatch.Subscriber.EventBatchSubscriberWrapper
 * JD-Core Version:    0.7.0.1
 */