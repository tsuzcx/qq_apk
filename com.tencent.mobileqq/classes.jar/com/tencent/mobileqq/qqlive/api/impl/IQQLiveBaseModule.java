package com.tencent.mobileqq.qqlive.api.impl;

import com.tencent.mobileqq.qqlive.api.IQQLiveModule;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;

public abstract class IQQLiveBaseModule
  implements IQQLiveModule
{
  protected IQQLiveSDK sdkImpl;
  
  public void init(IQQLiveSDK paramIQQLiveSDK)
  {
    this.sdkImpl = paramIQQLiveSDK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.IQQLiveBaseModule
 * JD-Core Version:    0.7.0.1
 */