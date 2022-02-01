package com.tencent.mobileqq.qqlive.callback.follow;

import com.tencent.mobileqq.qqlive.data.follow.FollowListUser;
import java.util.ArrayList;

public abstract interface IQQLiveGetFollowListCallback
{
  public abstract void a(int paramInt, String paramString);
  
  public abstract void a(String paramString, boolean paramBoolean, ArrayList<FollowListUser> paramArrayList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.callback.follow.IQQLiveGetFollowListCallback
 * JD-Core Version:    0.7.0.1
 */