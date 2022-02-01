package com.tencent.mobileqq.guild.api;

import com.tencent.mobileqq.qqguildsdk.data.ICategoryInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.HashMap;
import java.util.List;
import mqq.app.api.IRuntimeService;

@Service(process={"all"})
public abstract interface IGuildAdapterService
  extends IRuntimeService
{
  public abstract List<ICategoryInfo> getCategoryInfoList(String paramString, int paramInt);
  
  public abstract List<IGProChannelInfo> getChannelList(String paramString, boolean paramBoolean);
  
  public abstract List<IGProChannelInfo> getChannelList(String paramString, boolean paramBoolean, int paramInt);
  
  @Deprecated
  public abstract HashMap<String, List<IGProChannelInfo>> getChannelMap(String paramString, boolean paramBoolean);
  
  public abstract IGProGuildInfo getGuildInfo(String paramString, int paramInt);
  
  public abstract void setVisitorGuildCardInfo(String paramString, IGProGuildInfo paramIGProGuildInfo, List<ICategoryInfo> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.api.IGuildAdapterService
 * JD-Core Version:    0.7.0.1
 */