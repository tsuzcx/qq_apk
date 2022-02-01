package com.tencent.mobileqq.newfriend.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface INewFriendVerificationService
  extends IRuntimeService
{
  public abstract void clearRedPointAtNewFriendBanner();
  
  public abstract void getAddFriendBlockedList(String paramString);
  
  public abstract void getAddFriendBlockedRedPoint(String paramString);
  
  public abstract int getEntranceType();
  
  public abstract boolean isShowRedPoint();
  
  public abstract boolean isShowRedPointAtNewFriendBanner();
  
  public abstract void leaveNewFriend();
  
  public abstract void reportAddFriendBlocked(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.api.INewFriendVerificationService
 * JD-Core Version:    0.7.0.1
 */