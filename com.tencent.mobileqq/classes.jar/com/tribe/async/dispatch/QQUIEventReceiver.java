package com.tribe.async.dispatch;

import android.support.annotation.NonNull;
import java.lang.ref.WeakReference;

public abstract class QQUIEventReceiver<T extends IEventReceiver, EVENT extends Dispatcher.Dispatchable>
  extends Subscriber.SingleEventSubscriberNoRefect<EVENT>
{
  protected String TAG = "QQUIEventReceiver";
  protected WeakReference<T> mRef;
  
  public QQUIEventReceiver(@NonNull T paramT)
  {
    this.mRef = new WeakReference(paramT);
  }
  
  protected final void onDispatch2(@NonNull EVENT paramEVENT)
  {
    IEventReceiver localIEventReceiver = (IEventReceiver)this.mRef.get();
    if (localIEventReceiver == null) {
      return;
    }
    if (!localIEventReceiver.isValidate()) {
      return;
    }
    onEvent(localIEventReceiver, paramEVENT);
  }
  
  public abstract void onEvent(@NonNull T paramT, @NonNull EVENT paramEVENT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tribe.async.dispatch.QQUIEventReceiver
 * JD-Core Version:    0.7.0.1
 */