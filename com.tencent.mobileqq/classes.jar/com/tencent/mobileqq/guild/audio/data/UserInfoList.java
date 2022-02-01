package com.tencent.mobileqq.guild.audio.data;

import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class UserInfoList
{
  public volatile List<UserInfo> a = Collections.synchronizedList(new ArrayList());
  
  public UserInfo a(String paramString)
  {
    if (paramString.isEmpty()) {
      return null;
    }
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      UserInfo localUserInfo = (UserInfo)localIterator.next();
      if (paramString.equals(localUserInfo.h)) {
        return localUserInfo;
      }
    }
    return null;
  }
  
  public UserInfoList a()
  {
    UserInfoList localUserInfoList = new UserInfoList();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      UserInfo localUserInfo = (UserInfo)localIterator.next();
      localUserInfoList.a.add(localUserInfo.c());
    }
    return localUserInfoList;
  }
  
  public void a(TRTCUserInfoList paramTRTCUserInfoList)
  {
    paramTRTCUserInfoList = paramTRTCUserInfoList.a().iterator();
    while (paramTRTCUserInfoList.hasNext())
    {
      TRTCUserInfo localTRTCUserInfo = (TRTCUserInfo)paramTRTCUserInfoList.next();
      UserInfo localUserInfo = a(localTRTCUserInfo.a);
      if (localUserInfo != null) {
        localUserInfo.a(localTRTCUserInfo);
      }
    }
  }
  
  public void a(IGProUserInfo paramIGProUserInfo)
  {
    Object localObject = this.a.iterator();
    while (((Iterator)localObject).hasNext())
    {
      UserInfo localUserInfo = (UserInfo)((Iterator)localObject).next();
      if (localUserInfo.h.equals(paramIGProUserInfo.a()))
      {
        localUserInfo.a(paramIGProUserInfo);
        return;
      }
    }
    localObject = new UserInfo();
    ((UserInfo)localObject).a(paramIGProUserInfo);
    this.a.add(localObject);
  }
  
  public void b(String paramString)
  {
    int i = 0;
    while (i < this.a.size())
    {
      if (((UserInfo)this.a.get(i)).h.equals(paramString))
      {
        this.a.remove(i);
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.data.UserInfoList
 * JD-Core Version:    0.7.0.1
 */