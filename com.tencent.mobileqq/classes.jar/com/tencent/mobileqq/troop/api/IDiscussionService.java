package com.tencent.mobileqq.troop.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface IDiscussionService
  extends IRuntimeService
{
  public abstract Object findDiscussionInfoByID(String paramString);
  
  public abstract Object findDiscussionInfoByID(String paramString, boolean paramBoolean);
  
  public abstract Object getDiscussList();
  
  public abstract int getDiscussionManager_COLLECT_MAX_Value();
  
  public abstract Object getDiscussionMemberInfo(String paramString1, String paramString2);
  
  public abstract Object getDiscussionMemberInfoListByUin(String paramString);
  
  public abstract Object getDiscussionMemberInfoMapByUin(String paramString);
  
  public abstract Object getDiscussionMemberMapByUins(String[] paramArrayOfString);
  
  public abstract String getDiscussionMemberName(String paramString1, String paramString2);
  
  public abstract String getDiscussionMemberNickName(AppRuntime paramAppRuntime, String paramString1, String paramString2);
  
  public abstract int getDiscussionMemberNum(String paramString);
  
  public abstract String getDiscussionName(Context paramContext, String paramString);
  
  public abstract String getDiscussionName(String paramString);
  
  public abstract int getFavoriteCount();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.IDiscussionService
 * JD-Core Version:    0.7.0.1
 */