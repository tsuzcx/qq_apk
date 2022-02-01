package com.tencent.mobileqq.qqlive.api.message;

import com.tencent.mobileqq.qqlive.api.IQQLiveModule;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveCheckFollowCallback;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveFollowCallback;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveGetFollowListCallback;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveReceiveFollowListener;

public abstract interface IQQLiveFollowMsgService
  extends IQQLiveModule
{
  public abstract void addFollowMessageListener(IQQLiveReceiveFollowListener paramIQQLiveReceiveFollowListener);
  
  public abstract void checkFollowAnchor(long paramLong, IQQLiveCheckFollowCallback paramIQQLiveCheckFollowCallback);
  
  public abstract void delFollowMessageListener(IQQLiveReceiveFollowListener paramIQQLiveReceiveFollowListener);
  
  public abstract void followAnchor(long paramLong1, long paramLong2, IQQLiveFollowCallback paramIQQLiveFollowCallback);
  
  public abstract void getFollowList(String paramString, long paramLong, IQQLiveGetFollowListCallback paramIQQLiveGetFollowListCallback);
  
  public abstract void unFollowAnchor(long paramLong1, long paramLong2, IQQLiveFollowCallback paramIQQLiveFollowCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.message.IQQLiveFollowMsgService
 * JD-Core Version:    0.7.0.1
 */