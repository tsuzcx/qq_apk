package com.tencent.mobileqq.qqguildsdk.wrapper;

import android.os.Handler;
import com.tencent.common.config.AppSetting;
import com.tencent.gprosdk.GProAvatarInfo;
import com.tencent.gprosdk.GProCategoryChannelIdList;
import com.tencent.gprosdk.GProChannel;
import com.tencent.gprosdk.GProClientIdentity;
import com.tencent.gprosdk.GProGuild;
import com.tencent.gprosdk.GProGuildInit;
import com.tencent.gprosdk.GProGuildMemberCountInfo;
import com.tencent.gprosdk.GProGuildUserProfile;
import com.tencent.gprosdk.GProMember;
import com.tencent.gprosdk.GProMemberNickNameInfo;
import com.tencent.gprosdk.GProNoticeRedPoint;
import com.tencent.gprosdk.GProUser;
import com.tencent.gprosdk.IGProSdkListener;
import com.tencent.gprosdk.IGProSdkWrapper;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.util.WeakReference;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

class GProSdkWrapperImpl$GProSdkListenerImpl
  implements IGProSdkListener
{
  private WeakReference<AppRuntime> b;
  
  public GProSdkWrapperImpl$GProSdkListenerImpl(GProSdkWrapperImpl paramGProSdkWrapperImpl, AppRuntime paramAppRuntime)
  {
    this.b = new WeakReference(paramAppRuntime);
  }
  
  public void onBatchGetUserAvatarUrl(ArrayList<GProAvatarInfo> paramArrayList)
  {
    GProSdkWrapperImpl.b(this.a).post(new GProSdkWrapperImpl.GProSdkListenerImpl.17(this, paramArrayList));
  }
  
  public void onBatchGuildMemberNameUpdate(long paramLong, ArrayList<GProMemberNickNameInfo> paramArrayList)
  {
    GProSdkWrapperImpl.b(this.a).post(new GProSdkWrapperImpl.GProSdkListenerImpl.20(this, paramArrayList, paramLong));
  }
  
  public void onBatchGuildUserNickUpdate(ArrayList<GProMemberNickNameInfo> paramArrayList)
  {
    GProSdkWrapperImpl.b(this.a).post(new GProSdkWrapperImpl.GProSdkListenerImpl.19(this, paramArrayList));
  }
  
  public void onChannelInfoUpdated(int paramInt, String paramString, GProChannel paramGProChannel)
  {
    GProSdkWrapperImpl.b(this.a).post(new GProSdkWrapperImpl.GProSdkListenerImpl.4(this, paramInt, paramString, paramGProChannel));
  }
  
  public void onChannelListUpdated(int paramInt, String paramString, long paramLong, HashMap<Long, GProChannel> paramHashMap, GProCategoryChannelIdList paramGProCategoryChannelIdList, ArrayList<GProCategoryChannelIdList> paramArrayList)
  {
    GProSdkWrapperImpl.b(this.a).post(new GProSdkWrapperImpl.GProSdkListenerImpl.2(this, paramInt, paramString, paramHashMap, paramLong, paramGProCategoryChannelIdList, paramArrayList));
  }
  
  public void onGetGuildUserAvatarUrl(long paramLong1, String paramString, int paramInt, long paramLong2)
  {
    GProSdkWrapperImpl.b(this.a).post(new GProSdkWrapperImpl.GProSdkListenerImpl.15(this, paramLong1, paramString, paramInt, paramLong2));
  }
  
  public void onGetSelfTinyId(long paramLong)
  {
    GProSdkWrapperImpl.b(this.a).post(new GProSdkWrapperImpl.GProSdkListenerImpl.35(this, paramLong));
  }
  
  public long onGetSrvCalTime()
  {
    return MessageCache.c() * 1000L;
  }
  
  public void onGuildInfoUpdated(int paramInt, String paramString, GProGuild paramGProGuild, boolean paramBoolean)
  {
    GProSdkWrapperImpl.b(this.a).post(new GProSdkWrapperImpl.GProSdkListenerImpl.3(this, paramInt, paramString, paramGProGuild, paramBoolean));
  }
  
  public void onGuildListUpdated(int paramInt, String paramString, boolean paramBoolean, ArrayList<Long> paramArrayList, ArrayList<GProGuild> paramArrayList1)
  {
    GProSdkWrapperImpl.b(this.a).post(new GProSdkWrapperImpl.GProSdkListenerImpl.1(this, paramInt, paramString, paramBoolean, paramArrayList1, paramArrayList));
  }
  
  public void onGuildMemberClientIdentityUpdate(long paramLong1, long paramLong2, GProClientIdentity paramGProClientIdentity)
  {
    GProSdkWrapperImpl.b(this.a).post(new GProSdkWrapperImpl.GProSdkListenerImpl.36(this, paramLong1, paramLong2, paramGProClientIdentity));
  }
  
  public void onGuildMemberNameUpdate(long paramLong1, long paramLong2, String paramString)
  {
    GProSdkWrapperImpl.b(this.a).post(new GProSdkWrapperImpl.GProSdkListenerImpl.18(this, paramLong1, paramLong2, paramString));
  }
  
  public void onGuildUserNickUpdate(long paramLong, String paramString)
  {
    GProSdkWrapperImpl.b(this.a).post(new GProSdkWrapperImpl.GProSdkListenerImpl.16(this, paramLong, paramString));
  }
  
  public void onLog(int paramInt, String paramString)
  {
    if ((paramInt != 0) && (paramInt != 1))
    {
      if (paramInt == 2)
      {
        GProLog.c("GProSdkWrapperImpl", 1, "so", paramString);
        return;
      }
      if (paramInt == 3)
      {
        GProLog.a("GProSdkWrapperImpl", 1, "so", paramString);
        return;
      }
      if (paramInt == 4)
      {
        GProLog.b("GProSdkWrapperImpl", 1, "so", paramString);
        return;
      }
      GProLog.c("GProSdkWrapperImpl", 1, "so", paramString);
      return;
    }
    GProLog.a("GProSdkWrapperImpl", 4, paramString);
  }
  
  public void onMemberCountUpdate(GProGuildMemberCountInfo paramGProGuildMemberCountInfo)
  {
    GProSdkWrapperImpl.b(this.a).post(new GProSdkWrapperImpl.GProSdkListenerImpl.33(this, paramGProGuildMemberCountInfo));
  }
  
  public void onNoticeListUpdate(GProNoticeRedPoint paramGProNoticeRedPoint, byte[] paramArrayOfByte)
  {
    GProSdkWrapperImpl.b(this.a).post(new GProSdkWrapperImpl.GProSdkListenerImpl.34(this, paramGProNoticeRedPoint, paramArrayOfByte));
  }
  
  public void onPushAdminChanged(long paramLong1, boolean paramBoolean, long paramLong2, long paramLong3)
  {
    GProSdkWrapperImpl.b(this.a).post(new GProSdkWrapperImpl.GProSdkListenerImpl.13(this, paramLong1, paramLong2, paramLong3, paramBoolean));
  }
  
  public void onPushAudioChannelUserEnter(long paramLong1, long paramLong2, GProUser paramGProUser)
  {
    GProSdkWrapperImpl.b(this.a).post(new GProSdkWrapperImpl.GProSdkListenerImpl.22(this, paramLong1, paramLong2, paramGProUser));
  }
  
  public void onPushAudioChannelUserExit(long paramLong1, long paramLong2, long paramLong3)
  {
    GProSdkWrapperImpl.b(this.a).post(new GProSdkWrapperImpl.GProSdkListenerImpl.23(this, paramLong1, paramLong2, paramLong3));
  }
  
  public void onPushAudioChannelUserPlatSwitch(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2)
  {
    GProSdkWrapperImpl.b(this.a).post(new GProSdkWrapperImpl.GProSdkListenerImpl.24(this, paramLong1, paramLong2, paramLong3));
  }
  
  public void onPushChannelCategoryChanged(GProGuildInit paramGProGuildInit)
  {
    GProSdkWrapperImpl.b(this.a).post(new GProSdkWrapperImpl.GProSdkListenerImpl.32(this, paramGProGuildInit));
  }
  
  public void onPushChannelCreated(long paramLong1, long paramLong2, GProGuildInit paramGProGuildInit)
  {
    GProSdkWrapperImpl.b(this.a).post(new GProSdkWrapperImpl.GProSdkListenerImpl.11(this, paramGProGuildInit, paramLong1));
  }
  
  public void onPushChannelDestroy(long paramLong1, ArrayList<Long> paramArrayList, long paramLong2)
  {
    GProSdkWrapperImpl.b(this.a).post(new GProSdkWrapperImpl.GProSdkListenerImpl.12(this, paramLong1, paramArrayList));
  }
  
  public void onPushChannelVisibleChanged(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    GProSdkWrapperImpl.b(this.a).post(new GProSdkWrapperImpl.GProSdkListenerImpl.39(this, paramLong1, paramLong2, paramInt1, paramInt2));
  }
  
  public void onPushCreateGuild(long paramLong, GProGuild paramGProGuild, HashMap<Long, GProChannel> paramHashMap, GProCategoryChannelIdList paramGProCategoryChannelIdList, ArrayList<GProCategoryChannelIdList> paramArrayList)
  {
    GProSdkWrapperImpl.b(this.a).post(new GProSdkWrapperImpl.GProSdkListenerImpl.6(this, paramLong, paramGProGuild, paramHashMap, paramGProCategoryChannelIdList, paramArrayList));
  }
  
  public void onPushDestroyGuild(long paramLong)
  {
    GProSdkWrapperImpl.b(this.a).post(new GProSdkWrapperImpl.GProSdkListenerImpl.7(this, paramLong));
  }
  
  public void onPushJoinChannel(long paramLong1, long paramLong2, ArrayList<Long> paramArrayList)
  {
    GProSdkWrapperImpl.b(this.a).post(new GProSdkWrapperImpl.GProSdkListenerImpl.37(this, paramLong1, paramLong2, paramArrayList));
  }
  
  public void onPushJoinGuild(long paramLong1, long paramLong2, long paramLong3, int paramInt, GProGuild paramGProGuild, HashMap<Long, GProChannel> paramHashMap, GProCategoryChannelIdList paramGProCategoryChannelIdList, ArrayList<GProCategoryChannelIdList> paramArrayList)
  {
    GProSdkWrapperImpl.b(this.a).post(new GProSdkWrapperImpl.GProSdkListenerImpl.8(this, paramLong1, paramGProGuild, paramHashMap, paramGProCategoryChannelIdList, paramArrayList));
  }
  
  public void onPushKickOffGuild(long paramLong1, long paramLong2, long paramLong3, int paramInt)
  {
    GProSdkWrapperImpl.b(this.a).post(new GProSdkWrapperImpl.GProSdkListenerImpl.9(this, paramLong1, paramLong3, paramInt));
  }
  
  public void onPushKickOutAudioChannel(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt, String paramString)
  {
    GProSdkWrapperImpl.b(this.a).post(new GProSdkWrapperImpl.GProSdkListenerImpl.25(this, paramLong1, paramLong2, paramLong4, paramLong3, paramInt, paramString));
  }
  
  public void onPushLeaveChannel(long paramLong1, long paramLong2, ArrayList<Long> paramArrayList)
  {
    GProSdkWrapperImpl.b(this.a).post(new GProSdkWrapperImpl.GProSdkListenerImpl.38(this, paramLong1, paramLong2, paramArrayList));
  }
  
  public void onPushLiveChannelAnchorIdentityChange(long paramLong1, long paramLong2, int paramInt)
  {
    GProSdkWrapperImpl.b(this.a).post(new GProSdkWrapperImpl.GProSdkListenerImpl.28(this, paramLong1, paramLong2, paramInt));
  }
  
  public void onPushLiveRoomStatusChangeMsg(long paramLong1, long paramLong2, long paramLong3, String paramString, long paramLong4, int paramInt)
  {
    GProSdkWrapperImpl.b(this.a).post(new GProSdkWrapperImpl.GProSdkListenerImpl.29(this, paramLong4, paramInt, paramLong1, paramLong2, paramLong3, paramString));
  }
  
  public void onPushMsgRecvTypeChanged(long paramLong1, long paramLong2, long paramLong3, int paramInt)
  {
    GProSdkWrapperImpl.b(this.a).post(new GProSdkWrapperImpl.GProSdkListenerImpl.14(this, paramLong1, paramLong2, paramInt));
  }
  
  public void onPushQuitGuild(long paramLong1, long paramLong2)
  {
    GProSdkWrapperImpl.b(this.a).post(new GProSdkWrapperImpl.GProSdkListenerImpl.10(this, paramLong1, paramLong2));
  }
  
  public void onPushSelfBannedSpeakChange(long paramLong1, long paramLong2, long paramLong3, int paramInt)
  {
    GProSdkWrapperImpl.b(this.a).post(new GProSdkWrapperImpl.GProSdkListenerImpl.31(this, paramLong1, paramLong2, paramLong3, paramInt));
  }
  
  public void onPushSetUserVoicelessToMe(long paramLong, boolean paramBoolean)
  {
    GProSdkWrapperImpl.b(this.a).post(new GProSdkWrapperImpl.GProSdkListenerImpl.27(this, paramLong, paramBoolean));
  }
  
  public void onPushSwitchLiveRoom(long paramLong1, long paramLong2, ArrayList<GProMember> paramArrayList, int paramInt)
  {
    GProSdkWrapperImpl.b(this.a).post(new GProSdkWrapperImpl.GProSdkListenerImpl.30(this, paramArrayList, paramInt, paramLong1, paramLong2));
  }
  
  public void onPushUserMuteSeatInGuild(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    GProSdkWrapperImpl.b(this.a).post(new GProSdkWrapperImpl.GProSdkListenerImpl.26(this, paramLong1, paramLong2, paramBoolean));
  }
  
  public void onRefreshGuildUserProfileInfo(int paramInt, String paramString, long paramLong1, long paramLong2, GProGuildUserProfile paramGProGuildUserProfile)
  {
    GProSdkWrapperImpl.b(this.a).post(new GProSdkWrapperImpl.GProSdkListenerImpl.21(this, paramInt, paramString, paramLong1, paramLong2, paramGProGuildUserProfile));
  }
  
  public void onSecurityError(long paramLong, int paramInt)
  {
    GProSdkWrapperImpl.b(this.a).post(new GProSdkWrapperImpl.GProSdkListenerImpl.40(this));
  }
  
  public void onSendPbRequest(long paramLong, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("requestId : ");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(", cmd : ");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(", serviceType : ");
    ((StringBuilder)localObject).append(paramInt1);
    GProLog.b("GProSdkWrapperImpl", false, "network", "onSendPbRequest", "", ((StringBuilder)localObject).toString());
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("requestId : ");
      paramArrayOfByte.append(paramLong);
      paramArrayOfByte.append(", isSuccess: ");
      paramArrayOfByte.append(false);
      paramArrayOfByte.append(", cmd : ");
      paramArrayOfByte.append(paramInt2);
      paramArrayOfByte.append(", result : ");
      paramArrayOfByte.append(-93);
      paramArrayOfByte.append(", errorMsg : ");
      paramArrayOfByte.append("目前没有网络，请稍后再试!");
      GProLog.b("GProSdkWrapperImpl", true, "network", "onReceive", "", paramArrayOfByte.toString());
      GProSdkWrapperImpl.a(this.a).onSendPbReply(paramLong, paramInt2, -93, "目前没有网络，请稍后再试!", new byte[0]);
      return;
    }
    localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(paramInt2);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(paramInt1);
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    ((oidb_sso.OIDBSSOPkg)localObject).str_client_version.set(AppSetting.h());
    paramArrayOfByte = this.b;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.get() != null))
    {
      paramArrayOfByte = (AppRuntime)this.b.get();
      NewIntent localNewIntent = new NewIntent(paramArrayOfByte.getApplicationContext(), GProServlet.class);
      localNewIntent.putExtra("cmd", String.format("OidbSvcTrpcTcp.0x%1$x_%2$d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) }));
      localNewIntent.putExtra("cmd_int", paramInt2);
      localNewIntent.putExtra("data", ((oidb_sso.OIDBSSOPkg)localObject).toByteArray());
      localNewIntent.putExtra("type", 0);
      localNewIntent.putExtra("requestId", paramLong);
      localNewIntent.setObserver(new GProSdkWrapperImpl.GProSdkObserver(this.a));
      paramArrayOfByte.startServlet(localNewIntent);
    }
  }
  
  public void onSendSSORequest(long paramLong, String paramString, byte[] paramArrayOfByte)
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("requestId : ");
      paramArrayOfByte.append(paramLong);
      paramArrayOfByte.append(", isSuccess: ");
      paramArrayOfByte.append(false);
      paramArrayOfByte.append(", ssoCmd : ");
      paramArrayOfByte.append(paramString);
      paramArrayOfByte.append(", result : ");
      paramArrayOfByte.append(-93);
      paramArrayOfByte.append(", errorMsg : ");
      paramArrayOfByte.append("目前没有网络，请稍后再试!");
      GProLog.b("GProSdkWrapperImpl", true, "network", "onReceive", "", paramArrayOfByte.toString());
      GProSdkWrapperImpl.a(this.a).onSendSSOReply(paramLong, paramString, -93, "目前没有网络，请稍后再试!", new byte[0]);
      return;
    }
    Object localObject = this.b;
    if ((localObject != null) && (((WeakReference)localObject).get() != null))
    {
      localObject = (AppRuntime)this.b.get();
      NewIntent localNewIntent = new NewIntent(((AppRuntime)localObject).getApplicationContext(), GProServlet.class);
      localNewIntent.putExtra("cmd", paramString);
      localNewIntent.putExtra("data", paramArrayOfByte);
      localNewIntent.putExtra("type", 1);
      localNewIntent.putExtra("requestId", paramLong);
      localNewIntent.setObserver(new GProSdkWrapperImpl.GProSdkObserver(this.a));
      ((AppRuntime)localObject).startServlet(localNewIntent);
    }
  }
  
  public void onUserListFetchFinish(int paramInt, String paramString, long paramLong)
  {
    GProSdkWrapperImpl.b(this.a).post(new GProSdkWrapperImpl.GProSdkListenerImpl.5(this, paramInt, paramString, paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProSdkWrapperImpl.GProSdkListenerImpl
 * JD-Core Version:    0.7.0.1
 */