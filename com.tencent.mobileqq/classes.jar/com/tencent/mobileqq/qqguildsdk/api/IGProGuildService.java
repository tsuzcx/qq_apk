package com.tencent.mobileqq.qqguildsdk.api;

import com.tencent.mobileqq.qqguildsdk.callback.IFetchGuildInfoCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IGetAddGuildOptionCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IResultCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IResultWithSecurityCallback;
import com.tencent.mobileqq.qqguildsdk.callback.ISetGuildInfoCallback;
import com.tencent.mobileqq.qqguildsdk.callback.ISetGuildTopCallback;
import com.tencent.mobileqq.qqguildsdk.data.AddGuildOption;
import com.tencent.mobileqq.qqguildsdk.data.GuildSourceId;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import java.util.List;

public abstract interface IGProGuildService
{
  public abstract void addGuild(String paramString1, GuildSourceId paramGuildSourceId, String paramString2, IResultWithSecurityCallback paramIResultWithSecurityCallback);
  
  public abstract void addGuildWithOption(String paramString1, GuildSourceId paramGuildSourceId, String paramString2, String paramString3, String paramString4, IResultWithSecurityCallback paramIResultWithSecurityCallback);
  
  public abstract void destroyGuild(String paramString, IResultCallback paramIResultCallback);
  
  public abstract void fetchGuildInfo(String paramString, IFetchGuildInfoCallback paramIFetchGuildInfoCallback);
  
  public abstract void getAddGuildOption(String paramString, IGetAddGuildOptionCallback paramIGetAddGuildOptionCallback);
  
  public abstract String getGuildAvatarUrl(String paramString, int paramInt);
  
  public abstract IGProGuildInfo getGuildInfo(String paramString);
  
  public abstract List<IGProGuildInfo> getGuildList();
  
  public abstract String getGuildName(String paramString);
  
  public abstract void queryApplyAddGuildStatus(String paramString, IResultWithSecurityCallback paramIResultWithSecurityCallback);
  
  public abstract void refleshGuildInfo(String paramString);
  
  public abstract void refreshGuildList(boolean paramBoolean);
  
  public abstract void removeGuild(String paramString, IResultWithSecurityCallback paramIResultWithSecurityCallback);
  
  public abstract void setAddGuildOption(String paramString, AddGuildOption paramAddGuildOption, IResultWithSecurityCallback paramIResultWithSecurityCallback);
  
  public abstract void setGuildAdmin(String paramString1, String paramString2, boolean paramBoolean, IResultWithSecurityCallback paramIResultWithSecurityCallback);
  
  public abstract void setGuildName(String paramString1, String paramString2, ISetGuildInfoCallback paramISetGuildInfoCallback);
  
  public abstract void setGuildProfile(String paramString1, String paramString2, IResultWithSecurityCallback paramIResultWithSecurityCallback);
  
  public abstract void setGuildTop(String paramString, boolean paramBoolean, ISetGuildTopCallback paramISetGuildTopCallback);
  
  public abstract void setOnLogin();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.api.IGProGuildService
 * JD-Core Version:    0.7.0.1
 */