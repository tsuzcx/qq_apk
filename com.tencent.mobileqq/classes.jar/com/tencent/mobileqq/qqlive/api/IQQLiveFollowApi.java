package com.tencent.mobileqq.qqlive.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQQLiveFollowApi
  extends QRouteApi
{
  public abstract void addWebFollowStateChangeListener(IQQLiveFollowApi.IQQLiveFollowStateListener paramIQQLiveFollowStateListener);
  
  public abstract void removeWebFollowStateChangeListener(IQQLiveFollowApi.IQQLiveFollowStateListener paramIQQLiveFollowStateListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.IQQLiveFollowApi
 * JD-Core Version:    0.7.0.1
 */