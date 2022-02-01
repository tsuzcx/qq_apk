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
    boolean bool1 = paramObject instanceof SubscriberKey;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    Class localClass = this.dispatchClass;
    paramObject = (SubscriberKey)paramObject;
    bool1 = bool2;
    if (localClass.equals(paramObject.dispatchClass))
    {
      bool1 = bool2;
      if (this.group.equals(paramObject.group)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return this.dispatchClass.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SubscriberKey{dispatchClass=");
    localStringBuilder.append(this.dispatchClass);
    localStringBuilder.append(", group=");
    localStringBuilder.append(this.group);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tribe.async.dispatch.DefaultDispatcher.SubscriberKey
 * JD-Core Version:    0.7.0.1
 */