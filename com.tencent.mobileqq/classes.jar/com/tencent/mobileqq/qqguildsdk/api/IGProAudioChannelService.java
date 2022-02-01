package com.tencent.mobileqq.qqguildsdk.api;

import com.tencent.mobileqq.qqguildsdk.callback.IEnterAudioChannelCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchAudioChannelUserListCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchShareInfoCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IKickChannelMemberCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IResultCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IResultWithSecurityCallback;
import com.tencent.mobileqq.qqguildsdk.data.IAudioChannelMemberInfos;
import java.util.ArrayList;

public abstract interface IGProAudioChannelService
{
  public abstract void addAudioChannel(String paramString1, String paramString2, String paramString3, IEnterAudioChannelCallback paramIEnterAudioChannelCallback);
  
  public abstract void exitAudioChannel(String paramString1, String paramString2, IResultWithSecurityCallback paramIResultWithSecurityCallback);
  
  public abstract void fetchAudioChannelUserList(String paramString1, String paramString2, IFetchAudioChannelUserListCallback paramIFetchAudioChannelUserListCallback);
  
  public abstract void fetchChanelShareInfo(String paramString1, String paramString2, IFetchShareInfoCallback paramIFetchShareInfoCallback);
  
  public abstract IAudioChannelMemberInfos getAudioChannelSimpleInfo(String paramString);
  
  public abstract void kickAudioChannelUsers(String paramString1, String paramString2, ArrayList<String> paramArrayList, IKickChannelMemberCallback paramIKickChannelMemberCallback);
  
  public abstract void setAudioChannelUserLimit(String paramString1, String paramString2, int paramInt, IResultWithSecurityCallback paramIResultWithSecurityCallback);
  
  public abstract void setUserMuteSeatInGuild(String paramString1, String paramString2, String paramString3, boolean paramBoolean, IResultCallback paramIResultCallback);
  
  public abstract void setUserVoicelessToMe(String paramString, boolean paramBoolean, IResultCallback paramIResultCallback);
  
  public abstract void tryRrefreshAllAudioChannelSimpleInfo(String paramString, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.api.IGProAudioChannelService
 * JD-Core Version:    0.7.0.1
 */