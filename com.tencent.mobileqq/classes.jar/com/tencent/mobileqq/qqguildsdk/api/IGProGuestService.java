package com.tencent.mobileqq.qqguildsdk.api;

import com.tencent.mobileqq.qqguildsdk.callback.IFetchChannelListForGuestCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchGuestGuildCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchGuildInfoCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IGetAudioChannelMemberInfosListCallback;
import com.tencent.mobileqq.qqguildsdk.data.ICategoryInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import java.util.List;

public abstract interface IGProGuestService
{
  public abstract void fetchAudioChannelUserListForGuest(String paramString, List<String> paramList, IGetAudioChannelMemberInfosListCallback paramIGetAudioChannelMemberInfosListCallback);
  
  public abstract void fetchChannelListForGuest(String paramString, IFetchChannelListForGuestCallback paramIFetchChannelListForGuestCallback);
  
  public abstract void fetchGuestGuild(String paramString, IFetchGuestGuildCallback paramIFetchGuestGuildCallback);
  
  public abstract void fetchGuildInfoForGuest(String paramString, IFetchGuildInfoCallback paramIFetchGuildInfoCallback);
  
  public abstract List<ICategoryInfo> getChannelCategoryListForGuest(String paramString);
  
  public abstract IGProChannelInfo getChannelInfoForGuest(String paramString1, String paramString2);
  
  public abstract IGProGuildInfo getGuildInfoForGuest(String paramString);
  
  public abstract void tryRrefreshAllAppChnnPreInfoForGuest(String paramString, List<String> paramList, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.api.IGProGuestService
 * JD-Core Version:    0.7.0.1
 */