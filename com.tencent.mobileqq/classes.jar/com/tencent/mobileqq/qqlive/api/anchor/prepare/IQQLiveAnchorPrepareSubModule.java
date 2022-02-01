package com.tencent.mobileqq.qqlive.api.anchor.prepare;

import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;

public abstract interface IQQLiveAnchorPrepareSubModule
{
  public abstract void destroy();
  
  public abstract void init(IQQLiveSDK paramIQQLiveSDK);
  
  public abstract void onSelected(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.anchor.prepare.IQQLiveAnchorPrepareSubModule
 * JD-Core Version:    0.7.0.1
 */