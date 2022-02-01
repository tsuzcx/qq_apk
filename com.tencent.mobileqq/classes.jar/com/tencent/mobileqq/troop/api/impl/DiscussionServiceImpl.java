package com.tencent.mobileqq.troop.api.impl;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.troop.api.IDiscussionService;
import com.tencent.mobileqq.utils.ContactUtils;
import mqq.app.AppRuntime;

public class DiscussionServiceImpl
  implements IDiscussionService
{
  private AppInterface app;
  private DiscussionManager mManager;
  
  public Object findDiscussionInfoByID(String paramString)
  {
    DiscussionManager localDiscussionManager = this.mManager;
    if (localDiscussionManager != null) {
      localDiscussionManager.d(paramString);
    }
    return null;
  }
  
  public Object findDiscussionInfoByID(String paramString, boolean paramBoolean)
  {
    return this.mManager.a(paramString, paramBoolean);
  }
  
  public Object getDiscussList()
  {
    return this.mManager.b();
  }
  
  public int getDiscussionManager_COLLECT_MAX_Value()
  {
    return 80;
  }
  
  public Object getDiscussionMemberInfo(String paramString1, String paramString2)
  {
    return this.mManager.b(paramString1, String.valueOf(paramString2));
  }
  
  public Object getDiscussionMemberInfoListByUin(String paramString)
  {
    return ((DiscussionManager)this.app.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a(paramString);
  }
  
  public Object getDiscussionMemberInfoMapByUin(String paramString)
  {
    return ((DiscussionManager)this.app.getManager(QQManagerFactory.DISCUSSION_MANAGER)).b(paramString);
  }
  
  public Object getDiscussionMemberMapByUins(String[] paramArrayOfString)
  {
    return ((DiscussionManager)this.app.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a(paramArrayOfString);
  }
  
  public String getDiscussionMemberName(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      if (!TextUtils.isEmpty(paramString2)) {
        return "";
      }
      DiscussionManager localDiscussionManager = this.mManager;
      if (localDiscussionManager != null)
      {
        paramString1 = localDiscussionManager.b(paramString1, String.valueOf(paramString2));
        if (paramString1 != null) {
          return paramString1.getDiscussionMemberName();
        }
      }
    }
    return "";
  }
  
  public String getDiscussionMemberNickName(AppRuntime paramAppRuntime, String paramString1, String paramString2)
  {
    if ((paramAppRuntime != null) && (paramString1 != null) && (paramString2 != null))
    {
      paramAppRuntime = this.mManager;
      if (paramAppRuntime == null) {
        return "";
      }
      paramAppRuntime = paramAppRuntime.b(paramString1, paramString2);
      if (paramAppRuntime != null)
      {
        if (!TextUtils.isEmpty(paramAppRuntime.memberName)) {
          return paramAppRuntime.memberName;
        }
        return paramAppRuntime.inteRemark;
      }
    }
    return "";
  }
  
  public int getDiscussionMemberNum(String paramString)
  {
    return this.mManager.c(paramString);
  }
  
  public String getDiscussionName(Context paramContext, String paramString)
  {
    AppInterface localAppInterface = this.app;
    if ((localAppInterface instanceof QQAppInterface)) {
      return ContactUtils.a((QQAppInterface)localAppInterface, paramContext, paramString);
    }
    return "";
  }
  
  public String getDiscussionName(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return "";
    }
    DiscussionManager localDiscussionManager = this.mManager;
    if (localDiscussionManager != null)
    {
      paramString = localDiscussionManager.d(paramString);
      if (paramString != null) {
        return paramString.discussionName;
      }
    }
    return "";
  }
  
  public int getFavoriteCount()
  {
    return ((DiscussionManager)this.app.getManager(QQManagerFactory.DISCUSSION_MANAGER)).c();
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof AppInterface))
    {
      this.app = ((AppInterface)paramAppRuntime);
      this.mManager = ((DiscussionManager)paramAppRuntime.getManager(QQManagerFactory.DISCUSSION_MANAGER));
    }
  }
  
  public void onDestroy()
  {
    this.mManager = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.impl.DiscussionServiceImpl
 * JD-Core Version:    0.7.0.1
 */