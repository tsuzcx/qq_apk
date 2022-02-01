package com.tribe.async.dispatch;

import android.os.Looper;
import android.support.annotation.NonNull;
import java.util.List;

public abstract class Subscriber$SingleEventSubscriberNoRefect<EVENT extends Dispatcher.Dispatchable>
  extends Subscriber.LooperSubscriber
{
  public Subscriber$SingleEventSubscriberNoRefect()
  {
    super(Looper.getMainLooper());
  }
  
  public void accept(@NonNull List<Class<? extends Dispatcher.Dispatchable>> paramList)
  {
    paramList.add(acceptEventClass());
  }
  
  public abstract Class acceptEventClass();
  
  public final void onDispatch(@NonNull Dispatcher.Dispatchable paramDispatchable)
  {
    onDispatch2(paramDispatchable);
  }
  
  protected abstract void onDispatch2(@NonNull EVENT paramEVENT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tribe.async.dispatch.Subscriber.SingleEventSubscriberNoRefect
 * JD-Core Version:    0.7.0.1
 */