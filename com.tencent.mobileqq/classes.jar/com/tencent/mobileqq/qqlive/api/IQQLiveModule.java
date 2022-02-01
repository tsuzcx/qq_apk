package com.tencent.mobileqq.qqlive.api;

public abstract interface IQQLiveModule
{
  public abstract void destroy();
  
  public abstract void init(IQQLiveSDK paramIQQLiveSDK);
  
  public abstract void reset();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.IQQLiveModule
 * JD-Core Version:    0.7.0.1
 */