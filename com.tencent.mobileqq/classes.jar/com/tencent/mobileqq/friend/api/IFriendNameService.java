package com.tencent.mobileqq.friend.api;

import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={"all"})
public abstract interface IFriendNameService
  extends IRuntimeService
{
  public abstract String getBuddyName(String paramString, boolean paramBoolean);
  
  public abstract String getFriendAlias(String paramString);
  
  public abstract String getFriendName(String paramString);
  
  public abstract String getFriendName(String paramString, boolean paramBoolean);
  
  public abstract String getFriendNick(String paramString);
  
  public abstract String getFriendRemark(String paramString);
  
  public abstract String getPhoneContactName(String paramString);
  
  public abstract Friends saveFriendRemark(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.friend.api.IFriendNameService
 * JD-Core Version:    0.7.0.1
 */