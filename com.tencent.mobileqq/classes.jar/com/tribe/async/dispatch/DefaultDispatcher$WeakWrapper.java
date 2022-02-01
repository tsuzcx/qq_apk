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
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof WeakWrapper)) {
      return false;
    }
    Object localObject = (WeakWrapper)paramObject;
    paramObject = get();
    localObject = ((WeakWrapper)localObject).get();
    if ((paramObject == null) && (localObject == null)) {
      return true;
    }
    if (paramObject != null) {
      return paramObject.equals(localObject);
    }
    return false;
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
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.mHashCode);
      ((StringBuilder)localObject).append("");
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = localObject.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WeakWrapper_");
    localStringBuilder.append((String)localObject);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tribe.async.dispatch.DefaultDispatcher.WeakWrapper
 * JD-Core Version:    0.7.0.1
 */