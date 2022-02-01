package com.tencent.mobileqq.relation.api;

import android.os.Bundle;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IContactUtilsApi
  extends QRouteApi
{
  public abstract String getBuddyName(String paramString, boolean paramBoolean);
  
  public abstract String getDateNickName(String paramString);
  
  public abstract String getDiscussionMemberShowName(String paramString1, String paramString2);
  
  public abstract String getFriendName(String paramString);
  
  public abstract String getFriendShowName(String paramString);
  
  public abstract String getGrayBarShowName(String paramString1, String paramString2);
  
  public abstract String getStatusName(Friends paramFriends);
  
  public abstract String getTroopNickName(String paramString1, String paramString2, String paramString3, boolean paramBoolean, Bundle paramBundle);
  
  public abstract boolean isContactShown();
  
  public abstract boolean isSelfNetworkStatusVisible(Friends paramFriends);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.relation.api.IContactUtilsApi
 * JD-Core Version:    0.7.0.1
 */