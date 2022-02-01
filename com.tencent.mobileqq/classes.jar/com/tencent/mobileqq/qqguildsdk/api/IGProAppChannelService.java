package com.tencent.mobileqq.qqguildsdk.api;

import com.tencent.mobileqq.qqguildsdk.data.appchannel.IAppChnnPreInfo;
import com.tencent.mobileqq.qqguildsdk.data.appchannel.IAppInfo;
import java.util.List;

public abstract interface IGProAppChannelService
{
  public abstract IAppChnnPreInfo getAppChnnPreInfo(String paramString1, String paramString2);
  
  public abstract List<IAppChnnPreInfo> getAppChnnPreInfos(String paramString);
  
  public abstract List<IAppInfo> getAppInfoList();
  
  public abstract void refreshAppInfoList();
  
  public abstract void tryRrefreshAllAppChnnPreInfo(String paramString, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.api.IGProAppChannelService
 * JD-Core Version:    0.7.0.1
 */