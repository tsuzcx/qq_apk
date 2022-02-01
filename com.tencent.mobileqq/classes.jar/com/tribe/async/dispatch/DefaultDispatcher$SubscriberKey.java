package com.tribe.async.dispatch;

import com.tribe.async.utils.AssertUtils;

class DefaultDispatcher$SubscriberKey
{
  public final Class<? extends Dispatcher.Dispatchable> dispatchClass;
  public final Object group;
  
  public DefaultDispatcher$SubscriberKey(Class<? extends Dispatcher.Dispatchable> paramClass, Object paramObject)
  {
    AssertUtils.checkNotNull(paramClass);
    AssertUtils.checkNotNull(paramObject);
    this.dispatchClass = paramClass;
    this.group = paramObject;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof SubscriberKey)) {
      return false;
    }
    if ((this.dispatchClass.equals(((SubscriberKey)paramObject).dispatchClass)) && (this.group.equals(((SubscriberKey)paramObject).group))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public int hashCode()
  {
    return this.dispatchClass.hashCode();
  }
  
  public String toString()
  {
    return "SubscriberKey{dispatchClass=" + this.dispatchClass + ", group=" + this.group + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tribe.async.dispatch.DefaultDispatcher.SubscriberKey
 * JD-Core Version:    0.7.0.1
 */