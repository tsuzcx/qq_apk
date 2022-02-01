package com.tencent.mobileqq.relation.api.impl;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.status.OnlineStatusUtils;
import com.tencent.mobileqq.relation.api.IContactUtilsApi;
import com.tencent.mobileqq.utils.ContactUtils;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class ContactUtilsApiImpl
  implements IContactUtilsApi
{
  public String getBuddyName(String paramString, boolean paramBoolean)
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
    String str = paramString;
    if ((localAppRuntime instanceof QQAppInterface)) {
      str = ContactUtils.a((QQAppInterface)localAppRuntime, paramString, paramBoolean);
    }
    return str;
  }
  
  public String getDateNickName(String paramString)
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
    String str = paramString;
    if ((localAppRuntime instanceof QQAppInterface)) {
      str = ContactUtils.h((QQAppInterface)localAppRuntime, paramString);
    }
    return str;
  }
  
  public String getDiscussionMemberShowName(String paramString1, String paramString2)
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return ContactUtils.a((QQAppInterface)localAppRuntime, paramString1, paramString2);
    }
    return paramString2;
  }
  
  public String getFriendName(String paramString)
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
    String str = paramString;
    if ((localAppRuntime instanceof QQAppInterface)) {
      str = ContactUtils.a((QQAppInterface)localAppRuntime, paramString);
    }
    return str;
  }
  
  public String getFriendShowName(String paramString)
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
    String str = paramString;
    if ((localAppRuntime instanceof QQAppInterface)) {
      str = ContactUtils.g((QQAppInterface)localAppRuntime, paramString);
    }
    return str;
  }
  
  public String getGrayBarShowName(String paramString1, String paramString2)
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return ContactUtils.a((QQAppInterface)localAppRuntime, paramString1, paramString2);
    }
    return paramString2;
  }
  
  public String getStatusName(Friends paramFriends)
  {
    return ContactUtils.b(paramFriends);
  }
  
  public String getTroopNickName(String paramString1, String paramString2, String paramString3, boolean paramBoolean, Bundle paramBundle)
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
    String str = paramString1;
    if ((localAppRuntime instanceof QQAppInterface)) {
      str = ContactUtils.a((QQAppInterface)localAppRuntime, paramString1, paramString2, paramString3, paramBoolean, paramBundle);
    }
    return str;
  }
  
  public boolean isContactShown()
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localBaseActivity != null)
    {
      bool1 = bool2;
      if ((localBaseActivity instanceof SplashActivity))
      {
        bool1 = bool2;
        if (((SplashActivity)localBaseActivity).getCurrentTab() == FrameControllerUtil.c) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean isSelfNetworkStatusVisible(Friends paramFriends)
  {
    return isSelfNetworkStatusVisibleImpl(paramFriends);
  }
  
  public boolean isSelfNetworkStatusVisibleImpl(Friends paramFriends)
  {
    Object localObject = MobileQQ.sMobileQQ.peekAppRuntime();
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(MobileQQ.sMobileQQ);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(MobileQQ.sMobileQQ.getString(2131916669));
    localStringBuilder.append(((AppRuntime)localObject).getCurrentAccountUin());
    localObject = localStringBuilder.toString();
    if (localSharedPreferences.contains((String)localObject)) {
      return localSharedPreferences.getBoolean((String)localObject, true);
    }
    return OnlineStatusUtils.b(paramFriends) ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.relation.api.impl.ContactUtilsApiImpl
 * JD-Core Version:    0.7.0.1
 */