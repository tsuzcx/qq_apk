package com.tencent.mobileqq.qqguildsdk.api.impl;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.callback.IAppAuthorizationCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IBindAppRoleCallback;
import com.tencent.mobileqq.qqguildsdk.callback.ICheckSelfRealNameVerifiedCallback;
import com.tencent.mobileqq.qqguildsdk.callback.ICheckUserBannedSpeakInChannelCallback;
import com.tencent.mobileqq.qqguildsdk.callback.ICreateChannelCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IDealNoticeCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IEnterAudioChannelCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchAudioChannelUserListCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchChannelListForGuestCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchEnterChannelPermissionCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchGuestGuildCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchGuildInfoByAppIdentityCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchGuildInfoCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchInviteInfoCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchIsLiveChannelOpenCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchIsVoiceChannelOpenCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchLiveChannelAnchorListCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchLiveChannelBannedUserListCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchLiveRoomInfoCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchLiveSecurityTipsCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchNoticeRedPointCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchRemainAtAllCountSink;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchShareInfoCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchVisibleMemberListByTinyIdCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IGetAddGuildOptionCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IGetAppAuthorizationInfoCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IGetAppRoleListCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IGetAudioChannelMemberInfosListCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IGetChannelCategoryCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IGetClientInfoListCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IGetGProUserListPaginationCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IGetInvisibleMemberListCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IGetMoreNoticeListCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IGetUserInfoCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IGetUserListCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IGetVisibleMemberCountCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IGetVisibleMemberListCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IInitGetNoticeListCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IKickChannelMemberCallback;
import com.tencent.mobileqq.qqguildsdk.callback.ILoadUserProfileInfoCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IQueryTinyIdByLiveUIDCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IResultCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IResultWithSecurityCallback;
import com.tencent.mobileqq.qqguildsdk.callback.ISearchSink;
import com.tencent.mobileqq.qqguildsdk.callback.ISearchVisibleMemberListCallback;
import com.tencent.mobileqq.qqguildsdk.callback.ISetChannelAdminMsgNotifyTypeCallback;
import com.tencent.mobileqq.qqguildsdk.callback.ISetChannelMsgNotifyTypeCallback;
import com.tencent.mobileqq.qqguildsdk.callback.ISetChannelNameCallback;
import com.tencent.mobileqq.qqguildsdk.callback.ISetChannelTalkPermissionCallback;
import com.tencent.mobileqq.qqguildsdk.callback.ISetGuildClientIdCallback;
import com.tencent.mobileqq.qqguildsdk.callback.ISetGuildInfoCallback;
import com.tencent.mobileqq.qqguildsdk.callback.ISetGuildTopCallback;
import com.tencent.mobileqq.qqguildsdk.callback.ISwitchPresenceArchiveCallback;
import com.tencent.mobileqq.qqguildsdk.data.AddGuildOption;
import com.tencent.mobileqq.qqguildsdk.data.CategoryChannelSortInfo;
import com.tencent.mobileqq.qqguildsdk.data.ChannelCreateInfo;
import com.tencent.mobileqq.qqguildsdk.data.FocusChannelReqInfo;
import com.tencent.mobileqq.qqguildsdk.data.GuildIdentityInfo;
import com.tencent.mobileqq.qqguildsdk.data.GuildMsgNode;
import com.tencent.mobileqq.qqguildsdk.data.GuildSourceId;
import com.tencent.mobileqq.qqguildsdk.data.GuildSourceInfo;
import com.tencent.mobileqq.qqguildsdk.data.GuildUserAvatar;
import com.tencent.mobileqq.qqguildsdk.data.IAudioChannelMemberInfos;
import com.tencent.mobileqq.qqguildsdk.data.ICategoryInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProClientIdentityInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.MsgRouttingHead;
import com.tencent.mobileqq.qqguildsdk.data.appchannel.IAppChnnPreInfo;
import com.tencent.mobileqq.qqguildsdk.data.appchannel.IAppInfo;
import com.tencent.mobileqq.qqguildsdk.engine.GPSAsynManagerEngine;
import com.tencent.mobileqq.qqguildsdk.engine.GPSManagerEngine;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;
import com.tencent.mobileqq.qqguildsdk.util.GProUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

public class GPSServiceImpl
  implements IGPSService
{
  public static final String TAG = "【gpro_sdk】";
  private AppRuntime mApp;
  private GPSAsynManagerEngine mEngine;
  
  private boolean isRun()
  {
    GPSAsynManagerEngine localGPSAsynManagerEngine = this.mEngine;
    if (localGPSAsynManagerEngine == null)
    {
      GProLog.b("【gpro_sdk】", true, "sdk interface", "mEngine is null");
      return false;
    }
    if (this.mApp == null)
    {
      GProLog.b("【gpro_sdk】", true, "sdk interface", "mApp is null");
      return false;
    }
    if (localGPSAsynManagerEngine.i() == null)
    {
      GProLog.b("【gpro_sdk】", true, "sdk interface", "mEngine.getCurrentUin() is null");
      return false;
    }
    if (!this.mEngine.i().equals(this.mApp.getCurrentUin()))
    {
      GProLog.b("【gpro_sdk】", true, "sdk interface", "mEngine.getCurrentUin() is not equal mApp.getCurrentUin()");
      return false;
    }
    return true;
  }
  
  public void addAudioChannel(String paramString1, String paramString2, String paramString3, IEnterAudioChannelCallback paramIEnterAudioChannelCallback)
  {
    if ((paramIEnterAudioChannelCallback != null) && (isRun())) {
      this.mEngine.a(paramString1, paramString2, paramString3, paramIEnterAudioChannelCallback);
    }
  }
  
  public void addGuild(String paramString1, GuildSourceId paramGuildSourceId, String paramString2, IResultWithSecurityCallback paramIResultWithSecurityCallback)
  {
    if ((paramIResultWithSecurityCallback != null) && (isRun()))
    {
      if (GProUtil.a(paramString1))
      {
        paramIResultWithSecurityCallback.a(-90, "传参数错误", null);
        paramGuildSourceId = new StringBuilder();
        paramGuildSourceId.append("guildId : ");
        paramGuildSourceId.append(paramString1);
        GProLog.a("【gpro_sdk】", "addGuild", paramGuildSourceId.toString());
        return;
      }
      this.mEngine.a(paramString1, paramGuildSourceId, paramString2, paramIResultWithSecurityCallback);
    }
  }
  
  public void addGuildWithOption(String paramString1, GuildSourceId paramGuildSourceId, String paramString2, String paramString3, String paramString4, IResultWithSecurityCallback paramIResultWithSecurityCallback)
  {
    if ((paramIResultWithSecurityCallback != null) && (isRun()))
    {
      if (GProUtil.a(paramString1))
      {
        paramGuildSourceId = new StringBuilder();
        paramGuildSourceId.append("guildId : ");
        paramGuildSourceId.append(paramString1);
        GProLog.a("【gpro_sdk】", "addGuildWithOption", paramGuildSourceId.toString());
        paramIResultWithSecurityCallback.a(-90, "传参数错误", null);
        return;
      }
      this.mEngine.a(paramString1, paramGuildSourceId, paramString2, paramString3, paramString4, paramIResultWithSecurityCallback);
    }
  }
  
  public void addGuildWithSource(String paramString1, GuildSourceId paramGuildSourceId, String paramString2, GuildSourceInfo paramGuildSourceInfo, IResultWithSecurityCallback paramIResultWithSecurityCallback)
  {
    if ((paramIResultWithSecurityCallback != null) && (isRun()))
    {
      if (GProUtil.a(paramString1))
      {
        paramIResultWithSecurityCallback.a(-90, "传参数错误", null);
        paramGuildSourceId = new StringBuilder();
        paramGuildSourceId.append("guildId : ");
        paramGuildSourceId.append(paramString1);
        GProLog.a("【gpro_sdk】", "addGuildWithSource", paramGuildSourceId.toString());
        return;
      }
      this.mEngine.a(paramString1, paramGuildSourceId, paramString2, paramGuildSourceInfo, paramIResultWithSecurityCallback);
    }
  }
  
  public void addObserver(GPServiceObserver paramGPServiceObserver)
  {
    if ((isRun()) && (paramGPServiceObserver != null)) {
      this.mEngine.addObserver(paramGPServiceObserver);
    }
  }
  
  public void appAuthorization(String paramString, IAppAuthorizationCallback paramIAppAuthorizationCallback)
  {
    if ((paramIAppAuthorizationCallback != null) && (isRun())) {
      this.mEngine.a(paramString, paramIAppAuthorizationCallback);
    }
  }
  
  public void bindAppRole(String paramString1, String paramString2, int paramInt, IBindAppRoleCallback paramIBindAppRoleCallback)
  {
    if ((paramIBindAppRoleCallback != null) && (isRun())) {
      this.mEngine.a(paramString1, paramString2, paramInt, paramIBindAppRoleCallback);
    }
  }
  
  public void changeChannelCategoryName(String paramString1, long paramLong, String paramString2, IGetChannelCategoryCallback paramIGetChannelCategoryCallback)
  {
    if ((paramIGetChannelCategoryCallback != null) && (isRun()))
    {
      if (!GProUtil.a(paramString1, paramLong, paramString2))
      {
        paramIGetChannelCategoryCallback.a(-90, "传参数错误", null);
        return;
      }
      this.mEngine.a(paramString1, paramLong, paramString2, paramIGetChannelCategoryCallback);
    }
  }
  
  public void checkSelfRealNameVerified(ICheckSelfRealNameVerifiedCallback paramICheckSelfRealNameVerifiedCallback)
  {
    if ((paramICheckSelfRealNameVerifiedCallback != null) && (isRun())) {
      this.mEngine.a(paramICheckSelfRealNameVerifiedCallback);
    }
  }
  
  public void checkUserBannedSpeakInChannel(String paramString1, String paramString2, String paramString3, ICheckUserBannedSpeakInChannelCallback paramICheckUserBannedSpeakInChannelCallback)
  {
    if ((paramICheckUserBannedSpeakInChannelCallback != null) && (isRun()))
    {
      if ((!GProUtil.a(paramString1)) && (!GProUtil.a(paramString2)) && (!GProUtil.a(paramString3)))
      {
        this.mEngine.a(paramString1, paramString2, paramString3, paramICheckUserBannedSpeakInChannelCallback);
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("guildId：");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" channelId:");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" tinyId:");
      localStringBuilder.append(paramString3);
      GProLog.a("【gpro_sdk】", "checkUserBannedSpeakInChannel", localStringBuilder.toString());
      paramICheckUserBannedSpeakInChannelCallback.a(-90, "传参数错误", 0);
    }
  }
  
  public void clearNoticeRedPoint(int paramInt, IResultCallback paramIResultCallback)
  {
    if (isRun()) {
      this.mEngine.a(paramInt, paramIResultCallback);
    }
  }
  
  public void createChannel(String paramString, ChannelCreateInfo paramChannelCreateInfo, long paramLong, ICreateChannelCallback paramICreateChannelCallback)
  {
    if ((paramICreateChannelCallback != null) && (isRun()))
    {
      if ((!GProUtil.a(paramString)) && (paramChannelCreateInfo != null) && (!TextUtils.isEmpty(paramChannelCreateInfo.b())))
      {
        this.mEngine.a(paramString, paramChannelCreateInfo, paramLong, paramICreateChannelCallback);
        return;
      }
      paramICreateChannelCallback.a(-90, "传参数错误", null, null);
      paramChannelCreateInfo = new StringBuilder();
      paramChannelCreateInfo.append("guildId : ");
      paramChannelCreateInfo.append(paramString);
      GProLog.a("【gpro_sdk】", "createChannelWithId", paramChannelCreateInfo.toString());
    }
  }
  
  public void createChannelCategory(String paramString1, String paramString2, IGetChannelCategoryCallback paramIGetChannelCategoryCallback)
  {
    if ((paramIGetChannelCategoryCallback != null) && (isRun()))
    {
      if (!GProUtil.a(paramString1, paramString2))
      {
        paramIGetChannelCategoryCallback.a(-90, "传参数错误", null);
        return;
      }
      this.mEngine.a(paramString1, paramString2, paramIGetChannelCategoryCallback);
    }
  }
  
  public void dealNotice(String paramString1, String paramString2, IDealNoticeCallback paramIDealNoticeCallback)
  {
    if (isRun()) {
      this.mEngine.a(paramString1, paramString2, paramIDealNoticeCallback);
    }
  }
  
  public void deleteObserver(GPServiceObserver paramGPServiceObserver)
  {
    if ((isRun()) && (paramGPServiceObserver != null)) {
      this.mEngine.deleteObserver(paramGPServiceObserver);
    }
  }
  
  public void destroyGuild(String paramString, IResultCallback paramIResultCallback)
  {
    if ((paramIResultCallback != null) && (isRun()))
    {
      if (GProUtil.a(paramString))
      {
        paramIResultCallback.onResult(-90, "传参数错误");
        paramIResultCallback = new StringBuilder();
        paramIResultCallback.append("guildId : ");
        paramIResultCallback.append(paramString);
        GProLog.a("【gpro_sdk】", "destroyGuild", paramIResultCallback.toString());
        return;
      }
      this.mEngine.a(paramString, paramIResultCallback);
    }
  }
  
  public void exitAudioChannel(String paramString1, String paramString2, IResultWithSecurityCallback paramIResultWithSecurityCallback)
  {
    if ((paramIResultWithSecurityCallback != null) && (isRun())) {
      this.mEngine.b(paramString1, paramString2, paramIResultWithSecurityCallback);
    }
  }
  
  public void fetchAudioChannelUserList(String paramString1, String paramString2, IFetchAudioChannelUserListCallback paramIFetchAudioChannelUserListCallback)
  {
    if ((paramIFetchAudioChannelUserListCallback != null) && (isRun()))
    {
      if ((!GProUtil.a(paramString1)) && (!GProUtil.a(paramString2)))
      {
        this.mEngine.a(paramString1, paramString2, paramIFetchAudioChannelUserListCallback);
        return;
      }
      paramIFetchAudioChannelUserListCallback.a(-90, "传参数错误", null);
    }
  }
  
  public void fetchAudioChannelUserListForGuest(String paramString, List<String> paramList, IGetAudioChannelMemberInfosListCallback paramIGetAudioChannelMemberInfosListCallback)
  {
    if ((paramIGetAudioChannelMemberInfosListCallback != null) && (isRun()))
    {
      if ((!GProUtil.a(paramString)) && (!GProUtil.a(paramList)))
      {
        this.mEngine.a(paramString, paramList, paramIGetAudioChannelMemberInfosListCallback);
        return;
      }
      paramIGetAudioChannelMemberInfosListCallback.a(-90, "传参数错误", null);
    }
  }
  
  public void fetchChanelShareInfo(String paramString1, String paramString2, IFetchShareInfoCallback paramIFetchShareInfoCallback)
  {
    if ((paramIFetchShareInfoCallback != null) && (isRun()))
    {
      if ((!GProUtil.a(paramString1)) && (!GProUtil.a(paramString2)))
      {
        this.mEngine.a(paramString1, paramString2, paramIFetchShareInfoCallback);
        return;
      }
      paramIFetchShareInfoCallback.a(-90, "传参数错误", null, null, null);
    }
  }
  
  public void fetchChannelListForGuest(String paramString, IFetchChannelListForGuestCallback paramIFetchChannelListForGuestCallback)
  {
    if ((paramIFetchChannelListForGuestCallback != null) && (isRun()))
    {
      if (GProUtil.a(paramString))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("guildId：");
        localStringBuilder.append(paramString);
        GProLog.a("【gpro_sdk】", "fetchChannelListForGuest", localStringBuilder.toString());
        paramIFetchChannelListForGuestCallback.a(-90, "传参数错误", null);
        return;
      }
      this.mEngine.a(paramString, paramIFetchChannelListForGuestCallback);
    }
  }
  
  public void fetchEnterChannelPermission(String paramString1, String paramString2, IFetchEnterChannelPermissionCallback paramIFetchEnterChannelPermissionCallback)
  {
    if ((paramIFetchEnterChannelPermissionCallback != null) && (isRun()))
    {
      if ((!GProUtil.a(paramString1)) && (!GProUtil.a(paramString2)))
      {
        this.mEngine.a(paramString1, paramString2, paramIFetchEnterChannelPermissionCallback);
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("guildId：");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", channelId: ");
      localStringBuilder.append(paramString2);
      GProLog.a("【gpro_sdk】", "fetchEnterChannelPermission", localStringBuilder.toString());
      paramIFetchEnterChannelPermissionCallback.a(-90, "传参数错误", null);
    }
  }
  
  public void fetchGuestGuild(String paramString, IFetchGuestGuildCallback paramIFetchGuestGuildCallback)
  {
    if ((paramIFetchGuestGuildCallback != null) && (isRun()))
    {
      if (GProUtil.a(paramString))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("guildId：");
        localStringBuilder.append(paramString);
        GProLog.a("【gpro_sdk】", "fetchGuestGuild", localStringBuilder.toString());
        paramIFetchGuestGuildCallback.a(-90, "传参数错误", null, null);
        return;
      }
      this.mEngine.a(paramString, paramIFetchGuestGuildCallback);
    }
  }
  
  public void fetchGuildInfo(String paramString, IFetchGuildInfoCallback paramIFetchGuildInfoCallback)
  {
    if (isRun())
    {
      if (GProUtil.a(paramString))
      {
        paramIFetchGuildInfoCallback = new StringBuilder();
        paramIFetchGuildInfoCallback.append("guildId : ");
        paramIFetchGuildInfoCallback.append(paramString);
        GProLog.a("【gpro_sdk】", "fetchGuildInfo", paramIFetchGuildInfoCallback.toString());
        return;
      }
      this.mEngine.a(paramString, true, paramIFetchGuildInfoCallback);
    }
  }
  
  public void fetchGuildInfoByAppIdentity(GuildIdentityInfo paramGuildIdentityInfo, String paramString1, String paramString2, IFetchGuildInfoByAppIdentityCallback paramIFetchGuildInfoByAppIdentityCallback)
  {
    if ((paramIFetchGuildInfoByAppIdentityCallback != null) && (isRun()))
    {
      if (!paramGuildIdentityInfo.d())
      {
        GProLog.a("【gpro_sdk】", "fetchGuildInfoByAppIdentity", "identity need both appid and orgID");
        paramIFetchGuildInfoByAppIdentityCallback.a(-90, "传参数错误", null, null);
        return;
      }
      this.mEngine.a(paramGuildIdentityInfo, paramString1, paramString2, paramIFetchGuildInfoByAppIdentityCallback);
    }
  }
  
  public void fetchGuildInfoByInviteCode(String paramString, IFetchInviteInfoCallback paramIFetchInviteInfoCallback)
  {
    if ((paramIFetchInviteInfoCallback != null) && (isRun()))
    {
      if (TextUtils.isEmpty(paramString))
      {
        paramIFetchInviteInfoCallback.a(-90, "传参数错误", null, null);
        paramIFetchInviteInfoCallback = new StringBuilder();
        paramIFetchInviteInfoCallback.append("inviteCode: ");
        paramIFetchInviteInfoCallback.append(paramString);
        GProLog.a("【gpro_sdk】", "fetchGuildInfoByInviteCode", paramIFetchInviteInfoCallback.toString());
        return;
      }
      this.mEngine.a(paramString, paramIFetchInviteInfoCallback);
    }
  }
  
  public void fetchGuildInfoForGuest(String paramString, IFetchGuildInfoCallback paramIFetchGuildInfoCallback)
  {
    if ((paramIFetchGuildInfoCallback != null) && (isRun()))
    {
      if (GProUtil.a(paramString))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("guildId：");
        localStringBuilder.append(paramString);
        GProLog.a("【gpro_sdk】", "fetchGuildInfoForGuest", localStringBuilder.toString());
        paramIFetchGuildInfoCallback.a(-90, "传参数错误", null);
        return;
      }
      this.mEngine.a(paramString, paramIFetchGuildInfoCallback);
    }
  }
  
  public void fetchIsLiveChannelOpen(String paramString, IFetchIsLiveChannelOpenCallback paramIFetchIsLiveChannelOpenCallback)
  {
    if ((paramIFetchIsLiveChannelOpenCallback != null) && (isRun()))
    {
      if (GProUtil.a(paramString))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("guildId：");
        localStringBuilder.append(paramString);
        GProLog.a("【gpro_sdk】", "fetchIsLiveChannelOpen", localStringBuilder.toString());
        paramIFetchIsLiveChannelOpenCallback.a(-90, "传参数错误", 0);
        return;
      }
      this.mEngine.a(paramString, paramIFetchIsLiveChannelOpenCallback);
    }
  }
  
  public void fetchIsVoiceChannelOpen(String paramString, IFetchIsVoiceChannelOpenCallback paramIFetchIsVoiceChannelOpenCallback)
  {
    if ((paramIFetchIsVoiceChannelOpenCallback != null) && (isRun()))
    {
      if (GProUtil.a(paramString))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("guildId：");
        localStringBuilder.append(paramString);
        GProLog.a("【gpro_sdk】", "fetchIsVoiceChannelOpen", localStringBuilder.toString());
        paramIFetchIsVoiceChannelOpenCallback.a(-90, "传参数错误", 0);
        return;
      }
      this.mEngine.a(paramString, paramIFetchIsVoiceChannelOpenCallback);
    }
  }
  
  public void fetchLiveChannelAnchorList(String paramString1, String paramString2, IFetchLiveChannelAnchorListCallback paramIFetchLiveChannelAnchorListCallback)
  {
    if ((paramIFetchLiveChannelAnchorListCallback != null) && (isRun()))
    {
      if ((!GProUtil.a(paramString1)) && (!GProUtil.a(paramString2)))
      {
        this.mEngine.a(paramString1, paramString2, paramIFetchLiveChannelAnchorListCallback);
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("guildId：");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", channelId: ");
      localStringBuilder.append(paramString2);
      GProLog.a("【gpro_sdk】", "fetchLiveChannelAnchorList", localStringBuilder.toString());
      paramIFetchLiveChannelAnchorListCallback.a(-90, "传参数错误", new ArrayList());
    }
  }
  
  public void fetchLiveChannelBannedUserList(String paramString1, String paramString2, String paramString3, IFetchLiveChannelBannedUserListCallback paramIFetchLiveChannelBannedUserListCallback)
  {
    if ((paramIFetchLiveChannelBannedUserListCallback != null) && (isRun()))
    {
      if ((!GProUtil.a(paramString1)) && (!GProUtil.a(paramString2)) && (!GProUtil.a(paramString3)))
      {
        this.mEngine.a(paramString1, paramString2, paramString3, paramIFetchLiveChannelBannedUserListCallback);
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("guildId：");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" channelId:");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" roomId:");
      localStringBuilder.append(paramString3);
      GProLog.a("【gpro_sdk】", "fetchLiveChannelBannedUserList", localStringBuilder.toString());
      paramIFetchLiveChannelBannedUserListCallback.a(-90, "传参数错误", new ArrayList());
    }
  }
  
  public void fetchLiveRoomInfoByChannelIds(String paramString, List<String> paramList, IFetchLiveRoomInfoCallback paramIFetchLiveRoomInfoCallback)
  {
    if ((paramIFetchLiveRoomInfoCallback != null) && (isRun()))
    {
      if ((!GProUtil.a(paramString)) && (!paramList.isEmpty()))
      {
        this.mEngine.a(paramString, paramList, paramIFetchLiveRoomInfoCallback);
        return;
      }
      paramList = new StringBuilder();
      paramList.append("guildId：");
      paramList.append(paramString);
      paramList.append(" or channelIdList is empty");
      GProLog.a("【gpro_sdk】", "fetchLiveRoomInfoByChannelIds", paramList.toString());
      paramIFetchLiveRoomInfoCallback.a(-90, "传参数错误", new ArrayList(), new ArrayList(), 0);
    }
  }
  
  public void fetchLiveRoomInfoByRoomIds(List<String> paramList, IFetchLiveRoomInfoCallback paramIFetchLiveRoomInfoCallback)
  {
    if (paramList.isEmpty())
    {
      GProLog.a("【gpro_sdk】", "fetchLiveRoomInfoByRoomIds", "roomIdList is empty");
      paramIFetchLiveRoomInfoCallback.a(-90, "传参数错误", new ArrayList(), new ArrayList(), 0);
      return;
    }
    this.mEngine.a(paramList, paramIFetchLiveRoomInfoCallback);
  }
  
  public void fetchLiveSecurityTips(IFetchLiveSecurityTipsCallback paramIFetchLiveSecurityTipsCallback)
  {
    if ((paramIFetchLiveSecurityTipsCallback != null) && (isRun())) {
      this.mEngine.a(paramIFetchLiveSecurityTipsCallback);
    }
  }
  
  public void fetchNoticeRedPoint(IFetchNoticeRedPointCallback paramIFetchNoticeRedPointCallback)
  {
    if (isRun()) {
      this.mEngine.a(paramIFetchNoticeRedPointCallback);
    }
  }
  
  public void fetchRemainAtAllCount(String paramString, IFetchRemainAtAllCountSink paramIFetchRemainAtAllCountSink)
  {
    if ((paramIFetchRemainAtAllCountSink != null) && (isRun()))
    {
      if (GProUtil.a(paramString))
      {
        paramIFetchRemainAtAllCountSink.onFetchRemainAtAllCountResult(-90, "传参数错误", paramString, 0, 0);
        paramIFetchRemainAtAllCountSink = new StringBuilder();
        paramIFetchRemainAtAllCountSink.append("guildId : ");
        paramIFetchRemainAtAllCountSink.append(paramString);
        GProLog.a("【gpro_sdk】", "fetchRemainAtAllCount", paramIFetchRemainAtAllCountSink.toString());
        return;
      }
      this.mEngine.a(paramString, paramIFetchRemainAtAllCountSink);
    }
  }
  
  public void fetchShareInfo(String paramString, IFetchShareInfoCallback paramIFetchShareInfoCallback)
  {
    if ((paramIFetchShareInfoCallback != null) && (isRun()))
    {
      if (GProUtil.a(paramString))
      {
        paramIFetchShareInfoCallback.a(-90, "传参数错误", null, null, null);
        paramIFetchShareInfoCallback = new StringBuilder();
        paramIFetchShareInfoCallback.append("guildId : ");
        paramIFetchShareInfoCallback.append(paramString);
        GProLog.a("【gpro_sdk】", "fetchGuildInviteUrl", paramIFetchShareInfoCallback.toString());
        return;
      }
      this.mEngine.a(paramString, "0", paramIFetchShareInfoCallback);
    }
  }
  
  public void fetchUserInfo(String paramString, List<String> paramList, boolean paramBoolean, IGetUserInfoCallback paramIGetUserInfoCallback)
  {
    if ((paramIGetUserInfoCallback != null) && (isRun()))
    {
      if ((!GProUtil.a(paramString)) && (!GProUtil.a(paramList)))
      {
        this.mEngine.a(paramString, paramList, paramBoolean, paramIGetUserInfoCallback);
        return;
      }
      paramIGetUserInfoCallback.onGetUserInfo(-90, "传参数错误", null, null);
      paramList = new StringBuilder();
      paramList.append("guildId : ");
      paramList.append(paramString);
      GProLog.a("【gpro_sdk】", "fetchUserInfo", paramList.toString());
    }
  }
  
  public void fetchVisibleMemberListByTinyId(String paramString1, String paramString2, @NonNull List<String> paramList, @NonNull IFetchVisibleMemberListByTinyIdCallback paramIFetchVisibleMemberListByTinyIdCallback)
  {
    if (!isRun()) {
      return;
    }
    if ((!GProUtil.a(paramString1)) && (!GProUtil.a(paramString2)))
    {
      this.mEngine.a(paramString1, paramString2, paramList, paramIFetchVisibleMemberListByTinyIdCallback);
      return;
    }
    paramList = new StringBuilder();
    paramList.append("guildId: ");
    paramList.append(paramString1);
    paramList.append(", channelId: ");
    paramList.append(paramString2);
    GProLog.a("【gpro_sdk】", "getChannelMemberList", paramList.toString());
    paramIFetchVisibleMemberListByTinyIdCallback.onFetchVisibleMemberListByTinyId(-90, "传参数错误", Collections.emptyList(), Collections.emptyList());
  }
  
  public void getAddGuildOption(String paramString, IGetAddGuildOptionCallback paramIGetAddGuildOptionCallback)
  {
    if (isRun())
    {
      if (GProUtil.a(paramString))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("guildId:");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" param err");
        GProLog.a("【gpro_sdk】", "getAddGuildOption", localStringBuilder.toString());
        paramIGetAddGuildOptionCallback.a(-90, "传参数错误", null);
        return;
      }
      this.mEngine.a(paramString, paramIGetAddGuildOptionCallback);
    }
  }
  
  public void getAppAuthorizationInfo(String paramString, int paramInt, IGetAppAuthorizationInfoCallback paramIGetAppAuthorizationInfoCallback)
  {
    if ((paramIGetAppAuthorizationInfoCallback != null) && (isRun())) {
      this.mEngine.a(paramString, paramInt, paramIGetAppAuthorizationInfoCallback);
    }
  }
  
  public IAppChnnPreInfo getAppChnnPreInfo(String paramString1, String paramString2)
  {
    if (isRun())
    {
      if ((!GProUtil.a(paramString1)) && (!GProUtil.a(paramString2))) {
        return this.mEngine.h(paramString1, paramString2);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("guildId：");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" channelId:");
      localStringBuilder.append(paramString2);
      GProLog.a("【gpro_sdk】", "getAppChnnPreInfo", localStringBuilder.toString());
    }
    return null;
  }
  
  public List<IAppChnnPreInfo> getAppChnnPreInfos(String paramString)
  {
    if (isRun())
    {
      if (GProUtil.a(paramString))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("guildId：");
        localStringBuilder.append(paramString);
        GProLog.a("【gpro_sdk】", "getAppChnnPreInfos", localStringBuilder.toString());
        return null;
      }
      return this.mEngine.q(paramString);
    }
    return null;
  }
  
  public List<IAppChnnPreInfo> getAppChnnPreInfos(String paramString, List<String> paramList)
  {
    if (isRun())
    {
      if ((!GProUtil.a(paramString)) && (!GProUtil.a(paramList))) {
        return this.mEngine.c(paramString, paramList);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("guildId：");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" channelIds:");
      localStringBuilder.append(paramList);
      GProLog.a("【gpro_sdk】", "getAppChnnPreInfos", localStringBuilder.toString());
    }
    return null;
  }
  
  public List<IAppInfo> getAppInfoList()
  {
    if (isRun()) {
      return this.mEngine.l();
    }
    return null;
  }
  
  public void getAppRoleList(String paramString, IGetAppRoleListCallback paramIGetAppRoleListCallback)
  {
    if ((paramIGetAppRoleListCallback != null) && (isRun())) {
      this.mEngine.a(paramString, paramIGetAppRoleListCallback);
    }
  }
  
  public IAudioChannelMemberInfos getAudioChannelSimpleInfo(String paramString)
  {
    if (isRun())
    {
      if (GProUtil.a(paramString))
      {
        GProLog.a("【gpro_sdk】", "getAudioChannelSimpleInfo", "channelUin is error");
        return null;
      }
      return this.mEngine.k(paramString);
    }
    return null;
  }
  
  public List<String> getCategoryList(String paramString)
  {
    if (isRun())
    {
      if (GProUtil.a(paramString))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("guildId：");
        localStringBuilder.append(paramString);
        GProLog.a("【gpro_sdk】", "getCategoryList", localStringBuilder.toString());
        return null;
      }
      return this.mEngine.m(paramString);
    }
    return null;
  }
  
  public List<ICategoryInfo> getChannelCategoryList(String paramString)
  {
    if (isRun())
    {
      if (GProUtil.a(paramString))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("guildId：");
        localStringBuilder.append(paramString);
        GProLog.a("【gpro_sdk】", "getChannelCategoryList", localStringBuilder.toString());
        return null;
      }
      return this.mEngine.l(paramString);
    }
    return new ArrayList();
  }
  
  public List<ICategoryInfo> getChannelCategoryListForGuest(String paramString)
  {
    if (isRun())
    {
      if (GProUtil.a(paramString))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("guildId：");
        localStringBuilder.append(paramString);
        GProLog.a("【gpro_sdk】", "getChannelCategoryListForGuest", localStringBuilder.toString());
        return null;
      }
      return this.mEngine.n(paramString);
    }
    return null;
  }
  
  public IGProChannelInfo getChannelInfo(String paramString)
  {
    if (isRun())
    {
      if (!GProUtil.a(paramString)) {
        return this.mEngine.h(paramString);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getChannelInfo with error channelUin：");
      localStringBuilder.append(paramString);
      GProLog.b("【gpro_sdk】", true, "sdk interface", localStringBuilder.toString());
    }
    return null;
  }
  
  public IGProChannelInfo getChannelInfoForGuest(String paramString1, String paramString2)
  {
    if (isRun())
    {
      if ((!GProUtil.a(paramString1)) && (!GProUtil.a(paramString2))) {
        return this.mEngine.f(paramString1, paramString2);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("guildId：");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", channelUin：");
      localStringBuilder.append(paramString2);
      GProLog.a("【gpro_sdk】", "getChannelInfoForGuest", localStringBuilder.toString());
    }
    return null;
  }
  
  @NotNull
  public List<IGProChannelInfo> getChannelList(String paramString)
  {
    if (isRun()) {
      return this.mEngine.f(paramString);
    }
    return new ArrayList();
  }
  
  public void getClientInfoList(int paramInt, IGetClientInfoListCallback paramIGetClientInfoListCallback)
  {
    if ((paramIGetClientInfoListCallback != null) && (isRun())) {
      this.mEngine.a(paramInt, paramIGetClientInfoListCallback);
    }
  }
  
  public String getFullAvatarUrl(GuildUserAvatar paramGuildUserAvatar, int paramInt)
  {
    if (isRun())
    {
      if (paramGuildUserAvatar == null)
      {
        GProLog.a("【gpro_sdk】", "getFullAvatarUrl", "avatar is null");
        return null;
      }
      return GPSManagerEngine.a(paramGuildUserAvatar.c(), paramGuildUserAvatar.b(), paramGuildUserAvatar.d(), paramInt);
    }
    return "";
  }
  
  public String getGuildAvatarUrl(String paramString, int paramInt)
  {
    if (isRun()) {
      return this.mEngine.e(paramString, paramInt);
    }
    return null;
  }
  
  public String getGuildIdOf(String paramString)
  {
    if (isRun()) {
      return this.mEngine.e(paramString);
    }
    return "";
  }
  
  public IGProGuildInfo getGuildInfo(String paramString)
  {
    if (isRun()) {
      return this.mEngine.g(paramString);
    }
    return null;
  }
  
  public IGProGuildInfo getGuildInfoForGuest(String paramString)
  {
    if (isRun())
    {
      if (GProUtil.a(paramString))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("guildId：");
        localStringBuilder.append(paramString);
        GProLog.a("【gpro_sdk】", "getGuildInfoForGuest", localStringBuilder.toString());
        return null;
      }
      return this.mEngine.o(paramString);
    }
    return null;
  }
  
  public List<IGProGuildInfo> getGuildList()
  {
    if (isRun()) {
      return this.mEngine.k();
    }
    return null;
  }
  
  public Map<String, IGProClientIdentityInfo> getGuildMemberClientIdentities(String paramString1, String paramString2, List<String> paramList)
  {
    if (isRun())
    {
      if ((!GProUtil.a(paramString1)) && (!GProUtil.a(paramList))) {
        return this.mEngine.c(paramString1, paramString2, paramList);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("guildId:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", clientId:");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", tinyIds:");
      localStringBuilder.append(paramList);
      GProLog.a("【gpro_sdk】", "getGuildMemberClientIdentities", localStringBuilder.toString());
    }
    return null;
  }
  
  public IGProClientIdentityInfo getGuildMemberClientIdentity(String paramString1, String paramString2, String paramString3)
  {
    if (isRun())
    {
      if ((!GProUtil.a(paramString1)) && (!GProUtil.a(paramString3))) {
        return this.mEngine.d(paramString1, paramString2, paramString3);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("guildId:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", clientId:");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", tinyId:");
      localStringBuilder.append(paramString3);
      GProLog.a("【gpro_sdk】", "getGuildMemberClientIdentity", localStringBuilder.toString());
    }
    return null;
  }
  
  public String getGuildMemberName(String paramString1, String paramString2)
  {
    if (isRun())
    {
      if ((!GProUtil.a(paramString1)) && (!GProUtil.a(paramString2))) {
        return this.mEngine.g(paramString1, paramString2);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("guildId:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", tinyId:");
      localStringBuilder.append(paramString2);
      GProLog.a("【gpro_sdk】", "getGuildMemberName", localStringBuilder.toString());
      return null;
    }
    return "";
  }
  
  public Map<String, String> getGuildMemberNames(String paramString, List<String> paramList)
  {
    if (isRun())
    {
      if ((!GProUtil.a(paramString)) && (!GProUtil.a(paramList))) {
        return this.mEngine.b(paramString, paramList);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("guildId:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", tinyIds:");
      localStringBuilder.append(paramList);
      GProLog.a("【gpro_sdk】", "getGuildMemberNames", localStringBuilder.toString());
    }
    return null;
  }
  
  public String getGuildName(String paramString)
  {
    if (isRun()) {
      return this.mEngine.r(paramString);
    }
    return null;
  }
  
  public String getGuildUserNick(String paramString)
  {
    if (isRun())
    {
      if (GProUtil.a(paramString))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("tinyId:");
        localStringBuilder.append(paramString);
        GProLog.a("【gpro_sdk】", "getGuildUsersNick", localStringBuilder.toString());
        return null;
      }
      return this.mEngine.b(paramString);
    }
    return "";
  }
  
  public GuildUserAvatar getGuildUsersAvatarUrl(String paramString)
  {
    if (isRun())
    {
      if (GProUtil.a(paramString))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("tinyId : ");
        localStringBuilder.append(paramString);
        GProLog.a("【gpro_sdk】", "getGuildUsersAvatarUrl", localStringBuilder.toString());
        return null;
      }
      return this.mEngine.c(paramString);
    }
    return null;
  }
  
  public Map<String, GuildUserAvatar> getGuildUsersAvatarUrls(List<String> paramList)
  {
    if (isRun())
    {
      if (GProUtil.a(paramList))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("tinyIdList:");
        localStringBuilder.append(paramList);
        GProLog.a("【gpro_sdk】", "getGuildUsersAvatarUrls", localStringBuilder.toString());
        return null;
      }
      return this.mEngine.d(paramList);
    }
    return null;
  }
  
  public Map<String, String> getGuildUsersNicks(List<String> paramList)
  {
    if (isRun())
    {
      if (GProUtil.a(paramList))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("tinyIdList:");
        localStringBuilder.append(paramList);
        GProLog.a("【gpro_sdk】", "getGuildUsersNicks", localStringBuilder.toString());
        return null;
      }
      return this.mEngine.c(paramList);
    }
    return null;
  }
  
  public void getInvisibleMemberList(String paramString1, String paramString2, int paramInt, boolean paramBoolean, @NonNull IGetInvisibleMemberListCallback paramIGetInvisibleMemberListCallback)
  {
    if (!isRun()) {
      return;
    }
    if ((!GProUtil.a(paramString1)) && (!GProUtil.a(paramString2)) && (paramInt > 0))
    {
      this.mEngine.a(paramString1, paramString2, paramInt, paramBoolean, paramIGetInvisibleMemberListCallback);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("guildId: ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", channelId: ");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(", count: ");
    localStringBuilder.append(paramInt);
    GProLog.a("【gpro_sdk】", "getChannelMemberList", localStringBuilder.toString());
    paramIGetInvisibleMemberListCallback.a(-90, "传参数错误", false, Collections.emptyList());
  }
  
  public void getMoreNoticeList(int paramInt, IGetMoreNoticeListCallback paramIGetMoreNoticeListCallback)
  {
    if (isRun()) {
      this.mEngine.a(paramInt, paramIGetMoreNoticeListCallback);
    }
  }
  
  public String getSelfGuildMemberName(String paramString)
  {
    if (isRun())
    {
      if (GProUtil.a(paramString))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("guildId:");
        localStringBuilder.append(paramString);
        GProLog.a("【gpro_sdk】", "getSelfGuildMemberName", localStringBuilder.toString());
        return "";
      }
      return this.mEngine.p(paramString);
    }
    return "";
  }
  
  public String getSelfTinyId()
  {
    if (isRun()) {
      return this.mEngine.m();
    }
    return "";
  }
  
  public void getUserList(String paramString, long paramLong, boolean paramBoolean, IGetUserListCallback paramIGetUserListCallback)
  {
    if ((paramIGetUserListCallback != null) && (isRun()))
    {
      if (GProUtil.a(paramString))
      {
        paramIGetUserListCallback.onGetUserList(paramString, -90, "传参数错误", null, null, null, null);
        paramIGetUserListCallback = new StringBuilder();
        paramIGetUserListCallback.append("guildId : ");
        paramIGetUserListCallback.append(paramString);
        GProLog.a("【gpro_sdk】", "getUserList", paramIGetUserListCallback.toString());
        return;
      }
      this.mEngine.a(paramString, paramLong, paramBoolean, paramIGetUserListCallback);
    }
  }
  
  public void getUserList(String paramString, Object paramObject, boolean paramBoolean, @NonNull IGetGProUserListPaginationCallback paramIGetGProUserListPaginationCallback)
  {
    if (!isRun()) {
      return;
    }
    this.mEngine.a(paramString, paramObject, paramBoolean, paramIGetGProUserListPaginationCallback);
  }
  
  public void getVisibleMemberCount(@NonNull String paramString1, @NonNull String paramString2, @NonNull IGetVisibleMemberCountCallback paramIGetVisibleMemberCountCallback)
  {
    if (!isRun()) {
      return;
    }
    if ((!GProUtil.a(paramString1)) && (!GProUtil.a(paramString2)))
    {
      this.mEngine.a(paramString1, paramString2, paramIGetVisibleMemberCountCallback);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("guildId: ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", channelId: ");
    localStringBuilder.append(paramString2);
    GProLog.a("【gpro_sdk】", "getChannelMemberList", localStringBuilder.toString());
    paramIGetVisibleMemberCountCallback.onGetVisibleMemberCount(-90, "传参数错误", 0);
  }
  
  public void getVisibleMemberList(String paramString1, String paramString2, int paramInt, boolean paramBoolean, @NonNull IGetVisibleMemberListCallback paramIGetVisibleMemberListCallback)
  {
    if (!isRun()) {
      return;
    }
    if ((!GProUtil.a(paramString1)) && (!GProUtil.a(paramString2)))
    {
      this.mEngine.a(paramString1, paramString2, paramInt, paramBoolean, paramIGetVisibleMemberListCallback);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("guildId: ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", channelId: ");
    localStringBuilder.append(paramString2);
    GProLog.a("【gpro_sdk】", "getVisibleMemberList", localStringBuilder.toString());
    paramIGetVisibleMemberListCallback.a(-90, "传参数错误", 0, false, Collections.emptyList());
  }
  
  public void initGetNoticeList(boolean paramBoolean, IInitGetNoticeListCallback paramIInitGetNoticeListCallback)
  {
    if (isRun()) {
      this.mEngine.a(paramBoolean, paramIInitGetNoticeListCallback);
    }
  }
  
  public void kickAudioChannelUsers(String paramString1, String paramString2, ArrayList<String> paramArrayList, IKickChannelMemberCallback paramIKickChannelMemberCallback)
  {
    if ((paramIKickChannelMemberCallback != null) && (isRun()))
    {
      if ((GProUtil.a(paramString1)) && (GProUtil.a(paramArrayList)))
      {
        paramIKickChannelMemberCallback.a(-90, "传参数错误", null, null);
        return;
      }
      this.mEngine.a(paramString1, paramString2, paramArrayList, paramIKickChannelMemberCallback);
    }
  }
  
  public void kickGuildUsers(String paramString, List<String> paramList, boolean paramBoolean, IResultWithSecurityCallback paramIResultWithSecurityCallback)
  {
    if ((paramIResultWithSecurityCallback != null) && (isRun()))
    {
      if (GProUtil.a(paramList))
      {
        paramIResultWithSecurityCallback.a(-90, "传参数错误", null);
        paramList = new StringBuilder();
        paramList.append("guildId : ");
        paramList.append(paramString);
        GProLog.a("【gpro_sdk】", "kickGuildUsers", paramList.toString());
        return;
      }
      this.mEngine.a(paramString, paramList, paramBoolean, paramIResultWithSecurityCallback);
    }
  }
  
  public void loadGProUserProfileInfo(String paramString1, String paramString2, ILoadUserProfileInfoCallback paramILoadUserProfileInfoCallback)
  {
    if ((paramILoadUserProfileInfoCallback != null) && (isRun()))
    {
      if ((!GProUtil.a(paramString1)) && (!GProUtil.a(paramString2)))
      {
        this.mEngine.a(paramString1, paramString2, paramILoadUserProfileInfoCallback);
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("guildId : ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", tinyId:");
      localStringBuilder.append(paramString2);
      GProLog.a("【gpro_sdk】", "loadGProUserProfileInfo", localStringBuilder.toString());
      paramILoadUserProfileInfoCallback.onLoadUserProfileInfo(-90, "传参数错误", null);
    }
  }
  
  public byte[] lz4DecompressBuf(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      GPSAsynManagerEngine localGPSAsynManagerEngine = this.mEngine;
      return GPSAsynManagerEngine.a(paramArrayOfByte);
    }
    return null;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = paramAppRuntime;
    this.mEngine = new GPSAsynManagerEngine(paramAppRuntime);
  }
  
  public void onDestroy()
  {
    GPSAsynManagerEngine localGPSAsynManagerEngine = this.mEngine;
    if (localGPSAsynManagerEngine != null)
    {
      localGPSAsynManagerEngine.deleteObservers();
      this.mEngine.n();
      this.mEngine = null;
    }
  }
  
  public void onGuildMsg(List<GuildMsgNode> paramList)
  {
    if ((isRun()) && (paramList != null)) {
      this.mEngine.e(paramList);
    }
  }
  
  public void onSrvPushMsg(int paramInt1, int paramInt2, MsgRouttingHead paramMsgRouttingHead, byte[] paramArrayOfByte)
  {
    if ((isRun()) && (paramMsgRouttingHead != null)) {
      this.mEngine.a(paramInt1, paramInt2, paramMsgRouttingHead, paramArrayOfByte);
    }
  }
  
  public void queryApplyAddGuildStatus(String paramString, IResultWithSecurityCallback paramIResultWithSecurityCallback)
  {
    if ((paramIResultWithSecurityCallback != null) && (isRun()))
    {
      if (GProUtil.a(paramString))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("guildId : ");
        localStringBuilder.append(paramString);
        GProLog.a("【gpro_sdk】", "queryApplyAddGuildStatus", localStringBuilder.toString());
        paramIResultWithSecurityCallback.a(-90, "传参数错误", null);
        return;
      }
      this.mEngine.b(paramString, paramIResultWithSecurityCallback);
    }
  }
  
  public void queryTinyIdByLiveUID(List<String> paramList, IQueryTinyIdByLiveUIDCallback paramIQueryTinyIdByLiveUIDCallback)
  {
    if ((paramIQueryTinyIdByLiveUIDCallback != null) && (isRun()))
    {
      if (GProUtil.a(paramList))
      {
        GProLog.a("【gpro_sdk】", "queryTinyIdByLiveUID", "uidList is empty");
        paramIQueryTinyIdByLiveUIDCallback.a(-90, "传参数错误", new HashMap());
        return;
      }
      this.mEngine.a(paramList, paramIQueryTinyIdByLiveUIDCallback);
    }
  }
  
  public void refleshGuildInfo(String paramString)
  {
    if (isRun())
    {
      if (GProUtil.a(paramString))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("guildId : ");
        localStringBuilder.append(paramString);
        GProLog.a("【gpro_sdk】", "refleshGuildInfo", localStringBuilder.toString());
        return;
      }
      this.mEngine.j(paramString);
    }
  }
  
  public void refreshAppInfoList()
  {
    if (isRun()) {
      this.mEngine.a();
    }
  }
  
  public void refreshGuildList(boolean paramBoolean)
  {
    if (isRun()) {
      this.mEngine.a(paramBoolean);
    }
  }
  
  public void refreshGuildUserProfileInfo(String paramString1, String paramString2)
  {
    if (isRun())
    {
      if ((!GProUtil.a(paramString1)) && (!GProUtil.a(paramString2)))
      {
        this.mEngine.i(paramString1, paramString2);
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("guildId : ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", tinyId:");
      localStringBuilder.append(paramString2);
      GProLog.a("【gpro_sdk】", "refreshGuildUserProfileInfo", localStringBuilder.toString());
    }
  }
  
  public void removeChannel(String paramString1, String paramString2, IResultWithSecurityCallback paramIResultWithSecurityCallback)
  {
    if ((paramIResultWithSecurityCallback != null) && (isRun()))
    {
      if ((!GProUtil.a(paramString1)) && (!GProUtil.a(paramString2)))
      {
        this.mEngine.a(paramString1, paramString2, paramIResultWithSecurityCallback);
        return;
      }
      paramIResultWithSecurityCallback.a(-90, "传参数错误", null);
      paramIResultWithSecurityCallback = new StringBuilder();
      paramIResultWithSecurityCallback.append(" guildId ： ");
      paramIResultWithSecurityCallback.append(paramString1);
      paramIResultWithSecurityCallback.append(", channelUin: ");
      paramIResultWithSecurityCallback.append(paramString2);
      GProLog.a("【gpro_sdk】", "removeChannel", paramIResultWithSecurityCallback.toString());
    }
  }
  
  public void removeChannelCategory(String paramString, long paramLong, boolean paramBoolean, IGetChannelCategoryCallback paramIGetChannelCategoryCallback)
  {
    if ((paramIGetChannelCategoryCallback != null) && (isRun()))
    {
      if (!GProUtil.a(paramString, paramLong))
      {
        paramIGetChannelCategoryCallback.a(-90, "传参数错误", null);
        return;
      }
      this.mEngine.a(paramString, paramLong, paramBoolean, paramIGetChannelCategoryCallback);
    }
  }
  
  public void removeGuild(String paramString, IResultWithSecurityCallback paramIResultWithSecurityCallback)
  {
    if ((paramIResultWithSecurityCallback != null) && (isRun()))
    {
      if (GProUtil.a(paramString))
      {
        paramIResultWithSecurityCallback.a(-90, "传参数错误", null);
        paramIResultWithSecurityCallback = new StringBuilder();
        paramIResultWithSecurityCallback.append("guildId : ");
        paramIResultWithSecurityCallback.append(paramString);
        GProLog.a("【gpro_sdk】", "removeGuild", paramIResultWithSecurityCallback.toString());
        return;
      }
      this.mEngine.a(paramString, paramIResultWithSecurityCallback);
    }
  }
  
  public void reportShareInfo(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, IResultCallback paramIResultCallback)
  {
    if ((paramIResultCallback != null) && (isRun()))
    {
      if ((!GProUtil.a(paramString1)) && (!GProUtil.a(paramString2)))
      {
        this.mEngine.a(paramString1, paramString2, paramInt1, paramString3, paramInt2, paramIResultCallback);
        return;
      }
      paramString3 = new StringBuilder();
      paramString3.append("guildId：");
      paramString3.append(paramString1);
      paramString3.append(" channelId:");
      paramString3.append(paramString2);
      GProLog.a("【gpro_sdk】", "reportShareInfo", paramString3.toString());
      paramIResultCallback.onResult(-90, "传参数错误");
    }
  }
  
  public void requestBeginBroadcast(String paramString1, String paramString2, String paramString3, IResultCallback paramIResultCallback)
  {
    if ((paramIResultCallback != null) && (isRun()))
    {
      if ((!GProUtil.a(paramString1)) && (!GProUtil.a(paramString2)) && (!GProUtil.a(paramString3)))
      {
        this.mEngine.a(paramString1, paramString2, paramString3, paramIResultCallback);
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("guildId：");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", channelId: ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", roomId:");
      localStringBuilder.append(paramString3);
      GProLog.a("【gpro_sdk】", "requestBeginBroadcast", localStringBuilder.toString());
      paramIResultCallback.onResult(-90, "传参数错误");
    }
  }
  
  public void searchGuildByName(String paramString, ISearchSink<IGProGuildInfo> paramISearchSink)
  {
    if ((paramISearchSink != null) && (isRun()))
    {
      if (TextUtils.isEmpty(paramString))
      {
        paramISearchSink.onSearchResult(-90, "传参数错误", null, false);
        paramISearchSink = new StringBuilder();
        paramISearchSink.append("keyWord:");
        paramISearchSink.append(paramString);
        GProLog.a("【gpro_sdk】", "searchGuildByName", paramISearchSink.toString());
        return;
      }
      this.mEngine.a(paramString, paramISearchSink);
    }
  }
  
  public void searchGuildByShowNumber(String paramString, ISearchSink<IGProGuildInfo> paramISearchSink)
  {
    if ((paramISearchSink != null) && (isRun()))
    {
      if (GProUtil.a(paramString))
      {
        paramISearchSink.onSearchResult(-90, "传参数错误", null, false);
        paramISearchSink = new StringBuilder();
        paramISearchSink.append("keyWord:");
        paramISearchSink.append(paramString);
        GProLog.a("【gpro_sdk】", "searchGuildByShowNumber", paramISearchSink.toString());
        return;
      }
      this.mEngine.b(paramString, paramISearchSink);
    }
  }
  
  public void searchGuildUser(String paramString1, String paramString2, ISearchSink<IGProUserInfo> paramISearchSink)
  {
    if ((paramISearchSink != null) && (isRun()))
    {
      if ((!GProUtil.a(paramString1)) && (!TextUtils.isEmpty(paramString2)))
      {
        this.mEngine.a(paramString1, paramString2, paramISearchSink);
        return;
      }
      paramISearchSink.onSearchResult(-90, "传参数错误", null, false);
      paramISearchSink = new StringBuilder();
      paramISearchSink.append("guildId : ");
      paramISearchSink.append(paramString1);
      paramISearchSink.append("， key ： ");
      paramISearchSink.append(paramString2);
      GProLog.a("【gpro_sdk】", "searchGuildUser", paramISearchSink.toString());
    }
  }
  
  public void searchGuildUserByGuildNickname(String paramString1, String paramString2, int paramInt, ISearchSink<IGProUserInfo> paramISearchSink)
  {
    if ((paramISearchSink != null) && (isRun()))
    {
      if ((!GProUtil.a(paramString1)) && (!TextUtils.isEmpty(paramString2)))
      {
        this.mEngine.b(paramString1, paramString2, paramInt, paramISearchSink);
        return;
      }
      paramISearchSink.onSearchResult(-90, "传参数错误", null, false);
      paramISearchSink = new StringBuilder();
      paramISearchSink.append("guildId : ");
      paramISearchSink.append(paramString1);
      paramISearchSink.append("， key ： ");
      paramISearchSink.append(paramString2);
      GProLog.a("【gpro_sdk】", "searchGuildUserByGuildNickname", paramISearchSink.toString());
    }
  }
  
  public void searchSrvGuildByShowNumber(String paramString, ISearchSink<IGProGuildInfo> paramISearchSink)
  {
    if ((paramISearchSink != null) && (isRun()))
    {
      if (GProUtil.a(paramString))
      {
        paramISearchSink.onSearchResult(-90, "传参数错误", null, false);
        paramISearchSink = new StringBuilder();
        paramISearchSink.append("keyWord:");
        paramISearchSink.append(paramString);
        GProLog.a("【gpro_sdk】", "searchSrvGuildByShowNumber", paramISearchSink.toString());
        return;
      }
      this.mEngine.c(paramString, paramISearchSink);
    }
  }
  
  public void searchVisibleMemberList(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, ISearchVisibleMemberListCallback paramISearchVisibleMemberListCallback)
  {
    if (!isRun()) {
      return;
    }
    if (TextUtils.isEmpty(paramString3.trim())) {
      return;
    }
    if ((!GProUtil.a(paramString1)) && (!GProUtil.a(paramString2)))
    {
      this.mEngine.a(paramString1, paramString2, paramInt1, paramString3, paramInt2, paramISearchVisibleMemberListCallback);
      return;
    }
    paramString3 = new StringBuilder();
    paramString3.append("guildId: ");
    paramString3.append(paramString1);
    paramString3.append(", channelId: ");
    paramString3.append(paramString2);
    GProLog.a("【gpro_sdk】", "getChannelMemberList", paramString3.toString());
    paramISearchVisibleMemberListCallback.onSearchVisibleMemberList(-90, "传参数错误", Collections.emptyList());
  }
  
  public void setAddGuildOption(String paramString, AddGuildOption paramAddGuildOption, IResultWithSecurityCallback paramIResultWithSecurityCallback)
  {
    if (isRun())
    {
      if ((!GProUtil.a(paramString)) && (paramAddGuildOption != null))
      {
        this.mEngine.a(paramString, paramAddGuildOption, paramIResultWithSecurityCallback);
        return;
      }
      paramAddGuildOption = new StringBuilder();
      paramAddGuildOption.append("guildId:");
      paramAddGuildOption.append(paramString);
      paramAddGuildOption.append(" param err");
      GProLog.a("【gpro_sdk】", "setAddGuildOption", paramAddGuildOption.toString());
      paramIResultWithSecurityCallback.a(-90, "传参数错误", null);
    }
  }
  
  public void setAdminMsgNotifyType(String paramString1, String paramString2, int paramInt, ISetChannelAdminMsgNotifyTypeCallback paramISetChannelAdminMsgNotifyTypeCallback)
  {
    if ((paramISetChannelAdminMsgNotifyTypeCallback != null) && (isRun()))
    {
      if ((!GProUtil.a(paramString1)) && (!GProUtil.a(paramString2)))
      {
        this.mEngine.a(paramString1, paramString2, paramInt, paramISetChannelAdminMsgNotifyTypeCallback);
        return;
      }
      paramISetChannelAdminMsgNotifyTypeCallback.a(-90, null, "传参数错误", null);
      paramISetChannelAdminMsgNotifyTypeCallback = new StringBuilder();
      paramISetChannelAdminMsgNotifyTypeCallback.append(" guildId ： ");
      paramISetChannelAdminMsgNotifyTypeCallback.append(paramString1);
      paramISetChannelAdminMsgNotifyTypeCallback.append(", channelUin: ");
      paramISetChannelAdminMsgNotifyTypeCallback.append(paramString2);
      GProLog.a("【gpro_sdk】", "setChannelMsgNotifyType", paramISetChannelAdminMsgNotifyTypeCallback.toString());
    }
  }
  
  public void setAudioChannelUserLimit(String paramString1, String paramString2, int paramInt, IResultWithSecurityCallback paramIResultWithSecurityCallback)
  {
    if ((paramIResultWithSecurityCallback != null) && (isRun()))
    {
      if ((GProUtil.a(paramString1)) && (GProUtil.a(paramString2)))
      {
        paramIResultWithSecurityCallback.a(-90, "传参数错误", null);
        return;
      }
      this.mEngine.b(paramString1, paramString2, paramInt, paramIResultWithSecurityCallback);
    }
  }
  
  public void setChannelBannedSpeak(String paramString, int paramInt, IResultWithSecurityCallback paramIResultWithSecurityCallback)
  {
    if ((paramIResultWithSecurityCallback != null) && (isRun()))
    {
      String str = getGuildIdOf(paramString);
      if ((!GProUtil.a(str)) && (!GProUtil.a(paramString)))
      {
        this.mEngine.a(str, paramString, paramInt, paramIResultWithSecurityCallback);
        return;
      }
      paramIResultWithSecurityCallback.a(-90, "传参数错误", null);
      paramIResultWithSecurityCallback = new StringBuilder();
      paramIResultWithSecurityCallback.append(" guildId ： ");
      paramIResultWithSecurityCallback.append(str);
      paramIResultWithSecurityCallback.append(", channelUin: ");
      paramIResultWithSecurityCallback.append(paramString);
      GProLog.a("【gpro_sdk】", "setChannelBannedSpeak", paramIResultWithSecurityCallback.toString());
    }
  }
  
  public void setChannelCategory(String paramString1, String paramString2, long paramLong, IGetChannelCategoryCallback paramIGetChannelCategoryCallback)
  {
    if ((paramIGetChannelCategoryCallback != null) && (isRun()))
    {
      if ((!GProUtil.a(paramString1)) && (!GProUtil.a(paramString2)))
      {
        this.mEngine.a(paramString1, paramString2, paramLong, paramIGetChannelCategoryCallback);
        return;
      }
      paramIGetChannelCategoryCallback.a(-90, "传参数错误", null);
    }
  }
  
  public void setChannelCategoryInfo(String paramString, CategoryChannelSortInfo paramCategoryChannelSortInfo, ArrayList<CategoryChannelSortInfo> paramArrayList, IGetChannelCategoryCallback paramIGetChannelCategoryCallback)
  {
    if ((paramIGetChannelCategoryCallback != null) && (isRun()))
    {
      if (!GProUtil.a(paramString, paramCategoryChannelSortInfo, paramArrayList))
      {
        paramIGetChannelCategoryCallback.a(-90, "传参数错误", null);
        return;
      }
      this.mEngine.a(paramString, paramCategoryChannelSortInfo, paramArrayList, paramIGetChannelCategoryCallback);
    }
  }
  
  public void setChannelCategoryOrder(String paramString, ArrayList<Long> paramArrayList, IGetChannelCategoryCallback paramIGetChannelCategoryCallback)
  {
    if ((paramIGetChannelCategoryCallback != null) && (isRun()))
    {
      if (!GProUtil.a(paramString, paramArrayList))
      {
        paramIGetChannelCategoryCallback.a(-90, "传参数错误", null);
        return;
      }
      this.mEngine.a(paramString, paramArrayList, paramIGetChannelCategoryCallback);
    }
  }
  
  public void setChannelName(String paramString1, String paramString2, String paramString3, ISetChannelNameCallback paramISetChannelNameCallback)
  {
    if ((paramISetChannelNameCallback != null) && (isRun()))
    {
      if ((!GProUtil.a(paramString1)) && (!GProUtil.a(paramString2)))
      {
        this.mEngine.a(paramString1, paramString2, paramString3, paramISetChannelNameCallback);
        return;
      }
      paramISetChannelNameCallback.a(-90, null, "传参数错误", null);
      paramString3 = new StringBuilder();
      paramString3.append(" guildId ： ");
      paramString3.append(paramString1);
      paramString3.append(", channelUin: ");
      paramString3.append(paramString2);
      GProLog.a("【gpro_sdk】", "setChannelName", paramString3.toString());
    }
  }
  
  public void setChannelTalkPermission(String paramString, int paramInt, ISetChannelTalkPermissionCallback paramISetChannelTalkPermissionCallback)
  {
    if ((paramISetChannelTalkPermissionCallback != null) && (isRun()))
    {
      String str = getGuildIdOf(paramString);
      if ((!GProUtil.a(str)) && (!GProUtil.a(paramString)))
      {
        this.mEngine.a(str, paramString, paramInt, paramISetChannelTalkPermissionCallback);
        return;
      }
      paramISetChannelTalkPermissionCallback.a(-90, null, "传参数错误", null);
      paramISetChannelTalkPermissionCallback = new StringBuilder();
      paramISetChannelTalkPermissionCallback.append(" guildId ： ");
      paramISetChannelTalkPermissionCallback.append(str);
      paramISetChannelTalkPermissionCallback.append(", channelUin: ");
      paramISetChannelTalkPermissionCallback.append(paramString);
      GProLog.a("【gpro_sdk】", "setChannelSpeakerPerm", paramISetChannelTalkPermissionCallback.toString());
    }
  }
  
  public void setChannelVisible(String paramString1, String paramString2, int paramInt, @Nullable List<String> paramList, @NonNull IResultWithSecurityCallback paramIResultWithSecurityCallback)
  {
    if (!isRun()) {
      return;
    }
    if ((!GProUtil.a(paramString1)) && (!GProUtil.a(paramString2)))
    {
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        if (paramInt != 2)
        {
          paramString1 = new StringBuilder();
          paramString1.append(" type: ");
          paramString1.append(paramInt);
          paramString1.append(", userList: ");
          paramString1.append(paramList.size());
          GProLog.a("【gpro_sdk】", "setChannelVisible", paramString1.toString());
          paramIResultWithSecurityCallback.a(-90, "传参数错误", null);
          return;
        }
        if (GProUtil.a(paramList))
        {
          paramString1 = new StringBuilder();
          paramString1.append(" userList: ");
          paramString1.append(paramList);
          GProLog.a("【gpro_sdk】", "setChannelVisible", paramString1.toString());
          paramIResultWithSecurityCallback.a(-90, "传参数错误", null);
          return;
        }
      }
      this.mEngine.a(paramString1, paramString2, paramInt, paramList, paramIResultWithSecurityCallback);
      return;
    }
    paramList = new StringBuilder();
    paramList.append(" guildId: ");
    paramList.append(paramString1);
    paramList.append(", channelUin: ");
    paramList.append(paramString2);
    GProLog.a("【gpro_sdk】", "setChannelVisible", paramList.toString());
    paramIResultWithSecurityCallback.a(-90, "传参数错误", null);
  }
  
  public void setChannelVisibleMembers(String paramString1, String paramString2, @Nullable List<String> paramList1, @Nullable List<String> paramList2, @NonNull IResultWithSecurityCallback paramIResultWithSecurityCallback)
  {
    if (!isRun()) {
      return;
    }
    if ((!GProUtil.a(paramString1)) && (!GProUtil.a(paramString2)))
    {
      this.mEngine.a(paramString1, paramString2, paramList1, paramList2, paramIResultWithSecurityCallback);
      return;
    }
    paramList1 = new StringBuilder();
    paramList1.append(" guildId: ");
    paramList1.append(paramString1);
    paramList1.append(", channelUin: ");
    paramList1.append(paramString2);
    GProLog.a("【gpro_sdk】", "setChannelVisibleMembers", paramList1.toString());
    paramIResultWithSecurityCallback.a(-90, "传参数错误", null);
  }
  
  public void setFocusChannel(List<FocusChannelReqInfo> paramList, IResultCallback paramIResultCallback)
  {
    if ((paramIResultCallback != null) && (isRun())) {
      this.mEngine.a(paramList, paramIResultCallback);
    }
  }
  
  public void setGuildAdmin(String paramString1, String paramString2, boolean paramBoolean, IResultWithSecurityCallback paramIResultWithSecurityCallback)
  {
    if ((paramIResultWithSecurityCallback != null) && (isRun()))
    {
      if ((!GProUtil.a(paramString1)) && (!GProUtil.a(paramString2)))
      {
        this.mEngine.a(paramString1, paramString2, paramBoolean, paramIResultWithSecurityCallback);
        return;
      }
      paramIResultWithSecurityCallback.a(-90, "传参数错误", null);
      paramIResultWithSecurityCallback = new StringBuilder();
      paramIResultWithSecurityCallback.append("guildId : ");
      paramIResultWithSecurityCallback.append(paramString1);
      paramIResultWithSecurityCallback.append("， userTinyId ： ");
      paramIResultWithSecurityCallback.append(paramString2);
      GProLog.a("【gpro_sdk】", "setGuildName", paramIResultWithSecurityCallback.toString());
    }
  }
  
  public void setGuildClientId(String paramString1, String paramString2, ISetGuildClientIdCallback paramISetGuildClientIdCallback)
  {
    if ((paramISetGuildClientIdCallback != null) && (isRun()))
    {
      if (GProUtil.a(paramString1))
      {
        paramISetGuildClientIdCallback = new StringBuilder();
        paramISetGuildClientIdCallback.append("guildId:");
        paramISetGuildClientIdCallback.append(paramString1);
        paramISetGuildClientIdCallback.append(", clientId:");
        paramISetGuildClientIdCallback.append(paramString2);
        GProLog.a("【gpro_sdk】", "setGuildClientId", paramISetGuildClientIdCallback.toString());
        return;
      }
      this.mEngine.a(paramString1, paramString2, paramISetGuildClientIdCallback);
    }
  }
  
  public void setGuildMemberName(String paramString1, String paramString2, IResultWithSecurityCallback paramIResultWithSecurityCallback)
  {
    if ((paramIResultWithSecurityCallback != null) && (isRun()))
    {
      if (GProUtil.a(paramString1))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("guildId：");
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append(", memberName: ");
        ((StringBuilder)localObject).append(paramString2);
        GProLog.a("【gpro_sdk】", "setGuildMemberName", ((StringBuilder)localObject).toString());
        paramIResultWithSecurityCallback.a(-90, "传参数错误", null);
        return;
      }
      Object localObject = this.mEngine;
      if (paramString2 == null) {
        paramString2 = "";
      }
      ((GPSAsynManagerEngine)localObject).c(paramString1, paramString2, paramIResultWithSecurityCallback);
    }
  }
  
  public void setGuildName(String paramString1, String paramString2, ISetGuildInfoCallback paramISetGuildInfoCallback)
  {
    if ((paramISetGuildInfoCallback != null) && (isRun()))
    {
      if ((!GProUtil.a(paramString1)) && (!TextUtils.isEmpty(paramString2)))
      {
        this.mEngine.a(paramString1, paramString2, paramISetGuildInfoCallback);
        return;
      }
      paramISetGuildInfoCallback.a(-90, null, "传参数错误", null);
      paramISetGuildInfoCallback = new StringBuilder();
      paramISetGuildInfoCallback.append("guildId ： ");
      paramISetGuildInfoCallback.append(paramString1);
      paramISetGuildInfoCallback.append(", name: ");
      paramISetGuildInfoCallback.append(paramString2);
      GProLog.a("【gpro_sdk】", "setGuildName", paramISetGuildInfoCallback.toString());
    }
  }
  
  public void setGuildProfile(String paramString1, String paramString2, IResultWithSecurityCallback paramIResultWithSecurityCallback)
  {
    if ((paramIResultWithSecurityCallback != null) && (isRun()))
    {
      if (GProUtil.a(paramString1))
      {
        paramIResultWithSecurityCallback.a(-90, "传参数错误", null);
        paramIResultWithSecurityCallback = new StringBuilder();
        paramIResultWithSecurityCallback.append("guildId : ");
        paramIResultWithSecurityCallback.append(paramString1);
        paramIResultWithSecurityCallback.append("， profile ： ");
        paramIResultWithSecurityCallback.append(paramString2);
        GProLog.a("【gpro_sdk】", "setGuildProfile", paramIResultWithSecurityCallback.toString());
        return;
      }
      GPSAsynManagerEngine localGPSAsynManagerEngine = this.mEngine;
      if (paramString2 == null) {
        paramString2 = "";
      }
      localGPSAsynManagerEngine.d(paramString1, paramString2, paramIResultWithSecurityCallback);
    }
  }
  
  public void setGuildTop(String paramString, boolean paramBoolean, ISetGuildTopCallback paramISetGuildTopCallback)
  {
    if ((paramISetGuildTopCallback != null) && (isRun()))
    {
      if (GProUtil.a(paramString))
      {
        paramISetGuildTopCallback.a(-90, null, "传参数错误");
        paramISetGuildTopCallback = new StringBuilder();
        paramISetGuildTopCallback.append("guildId : ");
        paramISetGuildTopCallback.append(paramString);
        GProLog.a("【gpro_sdk】", "setGuildTop", paramISetGuildTopCallback.toString());
        return;
      }
      this.mEngine.a(paramString, paramBoolean, paramISetGuildTopCallback);
    }
  }
  
  public void setLiveChannelAnchorList(String paramString1, String paramString2, List<String> paramList1, List<String> paramList2, IResultCallback paramIResultCallback)
  {
    if ((paramIResultCallback != null) && (isRun()))
    {
      if ((!GProUtil.a(paramString1)) && (!GProUtil.a(paramString2)))
      {
        this.mEngine.a(paramString1, paramString2, paramList1, paramList2, paramIResultCallback);
        return;
      }
      paramList1 = new StringBuilder();
      paramList1.append("guildId：");
      paramList1.append(paramString1);
      paramList1.append(", channelId: ");
      paramList1.append(paramString2);
      GProLog.a("【gpro_sdk】", "setLiveChannelAnchorList", paramList1.toString());
      paramIResultCallback.onResult(-90, "传参数错误");
    }
  }
  
  public void setLiveChannelBannedUser(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, IResultCallback paramIResultCallback)
  {
    if ((paramIResultCallback != null) && (isRun()))
    {
      if ((!GProUtil.a(paramString1)) && (!GProUtil.a(paramString2)) && (!GProUtil.a(paramString3)) && (!GProUtil.a(paramString4)))
      {
        this.mEngine.a(paramString1, paramString2, paramString3, paramString4, paramInt, paramIResultCallback);
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("guildId：");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" channelId:");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" roomId:");
      localStringBuilder.append(paramString3);
      localStringBuilder.append(" bannedUser:");
      localStringBuilder.append(paramString4);
      GProLog.a("【gpro_sdk】", "setLiveChannelBannedUser", localStringBuilder.toString());
      paramIResultCallback.onResult(-90, "传参数错误");
    }
  }
  
  public void setMemberClientIdentityForMsg(String paramString1, String paramString2, IGProClientIdentityInfo paramIGProClientIdentityInfo, long paramLong)
  {
    if (isRun())
    {
      if ((!GProUtil.a(paramString1)) && (!GProUtil.a(paramString2)))
      {
        this.mEngine.a(paramString1, paramString2, paramIGProClientIdentityInfo, paramLong);
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("guildId:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", tinyId:");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", clientIdentity:");
      localStringBuilder.append(paramIGProClientIdentityInfo);
      localStringBuilder.append(", time:");
      localStringBuilder.append(paramLong);
      GProLog.a("【gpro_sdk】", "setMemberClientIdentityForMsg", localStringBuilder.toString());
    }
  }
  
  public void setMemberNameForMsg(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    if (isRun())
    {
      if ((!GProUtil.a(paramString1)) && (!GProUtil.a(paramString2)))
      {
        this.mEngine.a(paramString1, paramString2, paramString3, paramString4, paramLong);
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("guildId:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", tinyId:");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", nickName: ");
      localStringBuilder.append(paramString3);
      localStringBuilder.append(", memberName: ");
      localStringBuilder.append(paramString4);
      localStringBuilder.append(", time: ");
      localStringBuilder.append(paramLong);
      GProLog.a("【gpro_sdk】", "setMemberNameForMsg", localStringBuilder.toString());
    }
  }
  
  public void setMyMsgNotifyType(String paramString1, String paramString2, int paramInt, ISetChannelMsgNotifyTypeCallback paramISetChannelMsgNotifyTypeCallback)
  {
    if ((paramISetChannelMsgNotifyTypeCallback != null) && (isRun()))
    {
      if ((!GProUtil.a(paramString1)) && (!GProUtil.a(paramString2)))
      {
        this.mEngine.a(paramString1, paramString2, paramInt, paramISetChannelMsgNotifyTypeCallback);
        return;
      }
      paramISetChannelMsgNotifyTypeCallback.a(-90, null, "传参数错误");
      paramISetChannelMsgNotifyTypeCallback = new StringBuilder();
      paramISetChannelMsgNotifyTypeCallback.append(" guildId ： ");
      paramISetChannelMsgNotifyTypeCallback.append(paramString1);
      paramISetChannelMsgNotifyTypeCallback.append(", channelUin: ");
      paramISetChannelMsgNotifyTypeCallback.append(paramString2);
      GProLog.a("【gpro_sdk】", "setMyMsgNotifyType", paramISetChannelMsgNotifyTypeCallback.toString());
    }
  }
  
  public void setOnLogin()
  {
    if (isRun()) {
      this.mEngine.a(true);
    }
  }
  
  public void setSelfTinyId(String paramString)
  {
    if (isRun())
    {
      if (GProUtil.a(paramString))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("tinyId:");
        localStringBuilder.append(paramString);
        GProLog.a("【gpro_sdk】", "setSelfTinyId", localStringBuilder.toString());
        return;
      }
      this.mEngine.s(paramString);
    }
  }
  
  public void setShowArchive(String paramString, boolean paramBoolean, ISwitchPresenceArchiveCallback paramISwitchPresenceArchiveCallback)
  {
    if ((paramISwitchPresenceArchiveCallback != null) && (isRun())) {
      this.mEngine.b(paramString, paramBoolean, paramISwitchPresenceArchiveCallback);
    }
  }
  
  public void setShowPresence(String paramString, boolean paramBoolean, ISwitchPresenceArchiveCallback paramISwitchPresenceArchiveCallback)
  {
    if ((paramISwitchPresenceArchiveCallback != null) && (isRun())) {
      this.mEngine.a(paramString, paramBoolean, paramISwitchPresenceArchiveCallback);
    }
  }
  
  public void setUserMuteSeatInGuild(String paramString1, String paramString2, String paramString3, boolean paramBoolean, IResultCallback paramIResultCallback)
  {
    if ((paramIResultCallback != null) && (isRun()))
    {
      if ((!GProUtil.a(paramString1)) && (!GProUtil.a(paramString2)) && (!GProUtil.a(paramString3)))
      {
        this.mEngine.a(paramString1, paramString2, paramString3, paramBoolean, paramIResultCallback);
        return;
      }
      paramIResultCallback.onResult(-90, "传参数错误");
    }
  }
  
  public void setUserVoicelessToMe(String paramString, boolean paramBoolean, IResultCallback paramIResultCallback)
  {
    if ((paramIResultCallback != null) && (isRun()))
    {
      if (GProUtil.a(paramString))
      {
        paramIResultCallback.onResult(-90, "传参数错误");
        return;
      }
      this.mEngine.a(paramString, paramBoolean, paramIResultCallback);
    }
  }
  
  public void startGProSdk(String paramString, int paramInt)
  {
    if (isRun()) {
      this.mEngine.a(paramString, paramInt);
    }
  }
  
  public void stopGProSdk()
  {
    if (isRun()) {
      this.mEngine.n();
    }
  }
  
  public void tryRrefreshAllAppChnnPreInfo(String paramString, boolean paramBoolean)
  {
    if (isRun())
    {
      if (GProUtil.a(paramString))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("guildId：");
        localStringBuilder.append(paramString);
        GProLog.a("【gpro_sdk】", "tryRrefreshAllAppChnnPreInfo", localStringBuilder.toString());
        return;
      }
      this.mEngine.b(paramString, paramBoolean);
    }
  }
  
  public void tryRrefreshAllAppChnnPreInfoForGuest(String paramString, List<String> paramList, boolean paramBoolean)
  {
    if (isRun())
    {
      if ((!GProUtil.a(paramString)) && (!GProUtil.a(paramList)))
      {
        this.mEngine.a(paramString, paramList, paramBoolean);
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("guildId：");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" reqChannelIds：");
      localStringBuilder.append(paramList);
      GProLog.a("【gpro_sdk】", "tryRrefreshAllAppChnnPreInfoForGuest", localStringBuilder.toString());
    }
  }
  
  public void tryRrefreshAllAudioChannelSimpleInfo(String paramString, boolean paramBoolean)
  {
    if (isRun())
    {
      if (GProUtil.a(paramString))
      {
        GProLog.a("【gpro_sdk】", "tryRrefreshAllAudioChannelSimpleInfo", "guildId is error");
        return;
      }
      this.mEngine.a(paramString, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.api.impl.GPSServiceImpl
 * JD-Core Version:    0.7.0.1
 */