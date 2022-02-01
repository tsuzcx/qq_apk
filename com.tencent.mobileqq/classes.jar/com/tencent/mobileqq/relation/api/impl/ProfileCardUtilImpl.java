package com.tencent.mobileqq.relation.api.impl;

import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.relation.api.IProfileCardUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import mqq.app.AppRuntime;

public class ProfileCardUtilImpl
  implements IProfileCardUtil
{
  public Card findFriendCardByUin(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof QQAppInterface))
    {
      paramAppRuntime = (QQAppInterface)paramAppRuntime;
      FriendsManager localFriendsManager = (FriendsManager)paramAppRuntime.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (localFriendsManager != null) {
        return localFriendsManager.a(paramAppRuntime.getCurrentAccountUin());
      }
    }
    return null;
  }
  
  public Card initCard(AppRuntime paramAppRuntime, String paramString)
  {
    return ProfileCardUtil.a((QQAppInterface)paramAppRuntime, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.relation.api.impl.ProfileCardUtilImpl
 * JD-Core Version:    0.7.0.1
 */