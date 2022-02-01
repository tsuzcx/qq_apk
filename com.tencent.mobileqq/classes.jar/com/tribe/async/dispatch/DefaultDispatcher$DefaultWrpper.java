package com.tribe.async.dispatch;

import com.tribe.async.utils.AssertUtils;

class DefaultDispatcher$DefaultWrpper
  implements DefaultDispatcher.Wrapper
{
  private final Subscriber mSubscriber;
  
  public DefaultDispatcher$DefaultWrpper(Subscriber paramSubscriber)
  {
    AssertUtils.checkNotNull(paramSubscriber);
    this.mSubscriber = paramSubscriber;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof DefaultWrpper)) {
      return false;
    }
    paramObject = (DefaultWrpper)paramObject;
    return this.mSubscriber.equals(paramObject.get());
  }
  
  public Subscriber get()
  {
    return this.mSubscriber;
  }
  
  public int hashCode()
  {
    return this.mSubscriber.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DefaultWrapper_");
    localStringBuilder.append(this.mSubscriber.toString());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tribe.async.dispatch.DefaultDispatcher.DefaultWrpper
 * JD-Core Version:    0.7.0.1
 */