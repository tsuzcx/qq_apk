package com.tribe.async.dispatch;

import android.os.Looper;
import android.support.annotation.NonNull;
import com.tribe.async.utils.AssertUtils;
import java.util.List;

public class Subscriber$SubscriberWrapper
  extends Subscriber.LooperSubscriber
{
  private final Subscriber mSubscriber;
  
  public Subscriber$SubscriberWrapper(Looper paramLooper, Subscriber paramSubscriber)
  {
    super(paramLooper);
    AssertUtils.checkNotNull(paramSubscriber);
    this.mSubscriber = paramSubscriber;
  }
  
  public void accept(@NonNull List<Class<? extends Dispatcher.Dispatchable>> paramList)
  {
    this.mSubscriber.accept(paramList);
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof SubscriberWrapper))
    {
      paramObject = (SubscriberWrapper)paramObject;
      return (paramObject.mSubscriber.equals(this.mSubscriber)) && (paramObject.getLooper().equals(getLooper()));
    }
    if ((paramObject instanceof Subscriber.LooperSubscriber)) {
      return (paramObject.equals(this.mSubscriber)) && (((Subscriber.LooperSubscriber)paramObject).getLooper().equals(getLooper()));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tribe.async.dispatch.Subscriber.SubscriberWrapper
 * JD-Core Version:    0.7.0.1
 */