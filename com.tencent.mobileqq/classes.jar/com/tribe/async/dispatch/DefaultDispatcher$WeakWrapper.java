package com.tribe.async.dispatch;

import com.tribe.async.utils.AssertUtils;
import java.lang.ref.WeakReference;

class DefaultDispatcher$WeakWrapper
  implements DefaultDispatcher.Wrapper
{
  private int mHashCode;
  private WeakReference<Subscriber> mSubscriberRef;
  
  public DefaultDispatcher$WeakWrapper(Subscriber paramSubscriber)
  {
    AssertUtils.checkNotNull(paramSubscriber);
    this.mHashCode = paramSubscriber.hashCode();
    this.mSubscriberRef = new WeakReference(paramSubscriber);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    Object localObject;
    do
    {
      do
      {
        return false;
      } while (!(paramObject instanceof WeakWrapper));
      localObject = (WeakWrapper)paramObject;
      paramObject = get();
      localObject = ((WeakWrapper)localObject).get();
      if ((paramObject == null) && (localObject == null)) {
        return true;
      }
    } while (paramObject == null);
    return paramObject.equals(localObject);
  }
  
  public Subscriber get()
  {
    return (Subscriber)this.mSubscriberRef.get();
  }
  
  public int hashCode()
  {
    return this.mHashCode;
  }
  
  public String toString()
  {
    Object localObject = get();
    if (localObject == null) {}
    for (localObject = this.mHashCode + "";; localObject = localObject.toString()) {
      return "WeakWrapper_" + (String)localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tribe.async.dispatch.DefaultDispatcher.WeakWrapper
 * JD-Core Version:    0.7.0.1
 */