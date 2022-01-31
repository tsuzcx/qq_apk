package com.tribe.async.dispatch;

import android.support.annotation.NonNull;
import com.tribe.async.log.SLog;
import java.lang.ref.WeakReference;

public abstract class QQUIEventReceiver<T extends IEventReceiver, EVENT extends Dispatcher.Dispatchable>
  extends Subscriber.SingleEventSubscriberNoRefect<EVENT>
{
  protected String TAG;
  private String mDebugInfo;
  protected WeakReference<T> mRef;
  
  public QQUIEventReceiver(@NonNull T paramT)
  {
    this.mDebugInfo = (paramT.getClass().getSimpleName() + System.identityHashCode(paramT));
    this.mRef = new WeakReference(paramT);
    this.TAG = (paramT.getClass().getSimpleName() + ":UIEventReceiver");
  }
  
  protected final void onDispatch2(@NonNull EVENT paramEVENT)
  {
    IEventReceiver localIEventReceiver = (IEventReceiver)this.mRef.get();
    if (localIEventReceiver == null)
    {
      SLog.w(this.TAG, "onDispatch2 ignore because weak reference is released : " + this.mDebugInfo);
      return;
    }
    if (!localIEventReceiver.isValidate())
    {
      SLog.w(this.TAG, String.format("ignore receiver one event %s for ui %s is invalidate", new Object[] { paramEVENT, localIEventReceiver }));
      return;
    }
    onEvent(localIEventReceiver, paramEVENT);
  }
  
  public abstract void onEvent(@NonNull T paramT, @NonNull EVENT paramEVENT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tribe.async.dispatch.QQUIEventReceiver
 * JD-Core Version:    0.7.0.1
 */