package com.tribe.async.dispatch;

import android.support.annotation.NonNull;
import com.tribe.async.log.SLog;
import java.lang.ref.WeakReference;

public abstract class UIEventReceiver<T extends IEventReceiver, EVENT extends Dispatcher.Dispatchable>
  extends Subscriber.SingleEventSubscriber<EVENT>
{
  protected String TAG;
  private String mDebugInfo;
  protected WeakReference<T> mRef;
  
  public UIEventReceiver(@NonNull T paramT)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramT.getClass().getSimpleName());
    localStringBuilder.append(System.identityHashCode(paramT));
    this.mDebugInfo = localStringBuilder.toString();
    this.mRef = new WeakReference(paramT);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramT.getClass().getSimpleName());
    localStringBuilder.append(":UIEventReceiver");
    this.TAG = localStringBuilder.toString();
  }
  
  protected final void onDispatch2(@NonNull EVENT paramEVENT)
  {
    Object localObject = (IEventReceiver)this.mRef.get();
    if (localObject == null)
    {
      paramEVENT = this.TAG;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDispatch2 ignore because weak reference is released : ");
      ((StringBuilder)localObject).append(this.mDebugInfo);
      SLog.w(paramEVENT, ((StringBuilder)localObject).toString());
      return;
    }
    if (!((IEventReceiver)localObject).isValidate())
    {
      SLog.w(this.TAG, String.format("ignore receiver one event %s for ui %s is invalidate", new Object[] { paramEVENT, localObject }));
      return;
    }
    onEvent((IEventReceiver)localObject, paramEVENT);
  }
  
  public abstract void onEvent(@NonNull T paramT, @NonNull EVENT paramEVENT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tribe.async.dispatch.UIEventReceiver
 * JD-Core Version:    0.7.0.1
 */