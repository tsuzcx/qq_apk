package com.tencent.mtt.hippy.modules;

public abstract interface Promise
{
  public abstract String getCallId();
  
  public abstract boolean isCallback();
  
  public abstract void reject(Object paramObject);
  
  public abstract void resolve(Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.modules.Promise
 * JD-Core Version:    0.7.0.1
 */