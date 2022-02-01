package com.tencent.mobileqq.qqlive.api.anchor;

import com.tencent.mobileqq.qqlive.api.IQQLiveModule;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorFansGroupCallback;

public abstract interface IQQLiveAnchorFansService
  extends IQQLiveModule
{
  public abstract void getAnchorFansGroupList(long paramLong, IQQLiveAnchorFansGroupCallback paramIQQLiveAnchorFansGroupCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.anchor.IQQLiveAnchorFansService
 * JD-Core Version:    0.7.0.1
 */