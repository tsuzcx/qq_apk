package com.tencent.mobileqq.qqguildsdk.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qqguildsdk.callback.ICreateChannelCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchEnterChannelPermissionCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IResultWithSecurityCallback;
import com.tencent.mobileqq.qqguildsdk.callback.ISetChannelAdminMsgNotifyTypeCallback;
import com.tencent.mobileqq.qqguildsdk.callback.ISetChannelMsgNotifyTypeCallback;
import com.tencent.mobileqq.qqguildsdk.callback.ISetChannelNameCallback;
import com.tencent.mobileqq.qqguildsdk.callback.ISetChannelTalkPermissionCallback;
import com.tencent.mobileqq.qqguildsdk.data.ChannelCreateInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import java.util.List;

public abstract interface IGProChannelService
{
  public abstract void createChannel(String paramString, ChannelCreateInfo paramChannelCreateInfo, long paramLong, ICreateChannelCallback paramICreateChannelCallback);
  
  public abstract void fetchEnterChannelPermission(String paramString1, String paramString2, IFetchEnterChannelPermissionCallback paramIFetchEnterChannelPermissionCallback);
  
  public abstract IGProChannelInfo getChannelInfo(String paramString);
  
  public abstract List<IGProChannelInfo> getChannelList(String paramString);
  
  public abstract String getGuildIdOf(String paramString);
  
  public abstract void removeChannel(String paramString1, String paramString2, IResultWithSecurityCallback paramIResultWithSecurityCallback);
  
  public abstract void setAdminMsgNotifyType(String paramString1, String paramString2, int paramInt, ISetChannelAdminMsgNotifyTypeCallback paramISetChannelAdminMsgNotifyTypeCallback);
  
  public abstract void setChannelBannedSpeak(String paramString, int paramInt, IResultWithSecurityCallback paramIResultWithSecurityCallback);
  
  public abstract void setChannelName(String paramString1, String paramString2, String paramString3, ISetChannelNameCallback paramISetChannelNameCallback);
  
  public abstract void setChannelTalkPermission(String paramString, int paramInt, ISetChannelTalkPermissionCallback paramISetChannelTalkPermissionCallback);
  
  public abstract void setChannelVisible(String paramString1, String paramString2, int paramInt, @Nullable List<String> paramList, @NonNull IResultWithSecurityCallback paramIResultWithSecurityCallback);
  
  public abstract void setChannelVisibleMembers(String paramString1, String paramString2, @Nullable List<String> paramList1, @Nullable List<String> paramList2, @NonNull IResultWithSecurityCallback paramIResultWithSecurityCallback);
  
  public abstract void setMyMsgNotifyType(String paramString1, String paramString2, int paramInt, ISetChannelMsgNotifyTypeCallback paramISetChannelMsgNotifyTypeCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.api.IGProChannelService
 * JD-Core Version:    0.7.0.1
 */