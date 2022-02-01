package com.tencent.mobileqq.guild.util;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.privatechannel.GuildPrivateMemberListAdapter.UserInfoUIData;
import com.tencent.mobileqq.guild.setting.QQGuildMemberListAdapter.UserInfoItem;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.GuildUserAvatar;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class QQGuildAvatarLoader
{
  private AppInterface a;
  private List<QQGuildAvatarLoader.OnAvatarLoadListener> b;
  private HashMap<String, GuildUserAvatar> c = new HashMap();
  private GPServiceObserver d = new QQGuildAvatarLoader.1(this);
  
  public QQGuildAvatarLoader(AppInterface paramAppInterface)
  {
    this.a = paramAppInterface;
    ((IGPSService)this.a.getRuntimeService(IGPSService.class, "")).addObserver(this.d);
    this.b = new ArrayList();
  }
  
  public GuildUserAvatar a(QQGuildMemberListAdapter.UserInfoItem paramUserInfoItem)
  {
    if (paramUserInfoItem != null)
    {
      if (paramUserInfoItem.c == null) {
        return null;
      }
      if (TextUtils.isEmpty(paramUserInfoItem.c.a())) {
        return null;
      }
      try
      {
        if (this.c.containsKey(paramUserInfoItem.c.a()))
        {
          paramUserInfoItem = (GuildUserAvatar)this.c.get(paramUserInfoItem.c.a());
          return paramUserInfoItem;
        }
        return ((IGPSService)this.a.getRuntimeService(IGPSService.class, "")).getGuildUsersAvatarUrl(paramUserInfoItem.c.a());
      }
      finally {}
    }
    return null;
  }
  
  public GuildUserAvatar a(String paramString)
  {
    if (TextUtils.isEmpty(paramString) == true) {
      return null;
    }
    try
    {
      if (this.c.containsKey(paramString))
      {
        paramString = (GuildUserAvatar)this.c.get(paramString);
        return paramString;
      }
      return ((IGPSService)this.a.getRuntimeService(IGPSService.class, "")).getGuildUsersAvatarUrl(paramString);
    }
    finally {}
  }
  
  public void a()
  {
    AppInterface localAppInterface = this.a;
    if (localAppInterface != null) {
      ((IGPSService)localAppInterface.getRuntimeService(IGPSService.class, "")).deleteObserver(this.d);
    }
    this.b.clear();
  }
  
  public void a(QQGuildAvatarLoader.OnAvatarLoadListener paramOnAvatarLoadListener)
  {
    try
    {
      this.b.remove(paramOnAvatarLoadListener);
      this.b.add(paramOnAvatarLoadListener);
      return;
    }
    finally
    {
      paramOnAvatarLoadListener = finally;
      throw paramOnAvatarLoadListener;
    }
  }
  
  public void a(List<QQGuildMemberListAdapter.UserInfoItem> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        QQGuildMemberListAdapter.UserInfoItem localUserInfoItem = (QQGuildMemberListAdapter.UserInfoItem)paramList.next();
        if ((localUserInfoItem.c != null) && (!TextUtils.isEmpty(localUserInfoItem.c.a()))) {
          try
          {
            if (this.c.containsKey(localUserInfoItem.c.a())) {
              continue;
            }
            localArrayList.add(localUserInfoItem.c.a());
            continue;
          }
          finally {}
        } else {
          QLog.e("QQGuildAvatarLoader", 1, "loadAvatar tinyId is null");
        }
      }
      ((IGPSService)this.a.getRuntimeService(IGPSService.class, "")).getGuildUsersAvatarUrls(localArrayList);
    }
  }
  
  public void b(List<GuildPrivateMemberListAdapter.UserInfoUIData> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        GuildPrivateMemberListAdapter.UserInfoUIData localUserInfoUIData = (GuildPrivateMemberListAdapter.UserInfoUIData)paramList.next();
        if ((localUserInfoUIData != null) && (!TextUtils.isEmpty(localUserInfoUIData.mTinyId))) {
          try
          {
            if (this.c.containsKey(localUserInfoUIData.mTinyId)) {
              continue;
            }
            localArrayList.add(localUserInfoUIData.mTinyId);
            continue;
          }
          finally {}
        } else {
          QLog.e("QQGuildAvatarLoader", 1, "loadAvatar tinyId is null");
        }
      }
      ((IGPSService)this.a.getRuntimeService(IGPSService.class, "")).getGuildUsersAvatarUrls(localArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.util.QQGuildAvatarLoader
 * JD-Core Version:    0.7.0.1
 */