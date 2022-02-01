package com.tencent.mobileqq.qqlive.api.anchor;

import com.tencent.mobileqq.qqlive.api.IQQLiveModule;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveGetAnchorPageUrlCallback;

public abstract interface IQQLiveAnchorPageService
  extends IQQLiveModule
{
  public abstract void getAnchorPageUrl(long paramLong, IQQLiveGetAnchorPageUrlCallback paramIQQLiveGetAnchorPageUrlCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.anchor.IQQLiveAnchorPageService
 * JD-Core Version:    0.7.0.1
 */