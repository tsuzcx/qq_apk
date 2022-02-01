package com.tencent.mobileqq.qqlive.callback.follow;

import com.tencent.mobileqq.qqlive.data.follow.FollowPushMessage;

public abstract interface IQQLiveReceiveFollowListener
{
  public abstract void a(int paramInt, String paramString);
  
  public abstract void a(FollowPushMessage paramFollowPushMessage);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.callback.follow.IQQLiveReceiveFollowListener
 * JD-Core Version:    0.7.0.1
 */