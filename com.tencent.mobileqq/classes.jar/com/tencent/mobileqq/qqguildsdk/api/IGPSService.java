package com.tencent.mobileqq.qqguildsdk.api;

import com.tencent.mobileqq.qqguildsdk.callback.ICheckSelfRealNameVerifiedCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchGuildInfoByAppIdentityCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchInviteInfoCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchRemainAtAllCountSink;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchShareInfoCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IResultCallback;
import com.tencent.mobileqq.qqguildsdk.data.FocusChannelReqInfo;
import com.tencent.mobileqq.qqguildsdk.data.GuildIdentityInfo;
import com.tencent.mobileqq.qqguildsdk.data.GuildMsgNode;
import com.tencent.mobileqq.qqguildsdk.data.MsgRouttingHead;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.List;
import mqq.app.api.IRuntimeService;

@Service(process={"all"})
public abstract interface IGPSService
  extends IGProAppChannelService, IGProAppService, IGProAudioChannelService, IGProChannelCategoryService, IGProChannelService, IGProGuestService, IGProGuildService, IGProLiveChannelService, IGProNoticeService, IGProObserverController, IGProUserService, IRuntimeService
{
  public abstract void checkSelfRealNameVerified(ICheckSelfRealNameVerifiedCallback paramICheckSelfRealNameVerifiedCallback);
  
  public abstract void fetchGuildInfoByAppIdentity(GuildIdentityInfo paramGuildIdentityInfo, String paramString1, String paramString2, IFetchGuildInfoByAppIdentityCallback paramIFetchGuildInfoByAppIdentityCallback);
  
  public abstract void fetchGuildInfoByInviteCode(String paramString, IFetchInviteInfoCallback paramIFetchInviteInfoCallback);
  
  public abstract void fetchRemainAtAllCount(String paramString, IFetchRemainAtAllCountSink paramIFetchRemainAtAllCountSink);
  
  public abstract void fetchShareInfo(String paramString, IFetchShareInfoCallback paramIFetchShareInfoCallback);
  
  public abstract String getSelfTinyId();
  
  public abstract byte[] lz4DecompressBuf(byte[] paramArrayOfByte);
  
  public abstract void onGuildMsg(List<GuildMsgNode> paramList);
  
  public abstract void onSrvPushMsg(int paramInt1, int paramInt2, MsgRouttingHead paramMsgRouttingHead, byte[] paramArrayOfByte);
  
  public abstract void reportShareInfo(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, IResultCallback paramIResultCallback);
  
  public abstract void setFocusChannel(List<FocusChannelReqInfo> paramList, IResultCallback paramIResultCallback);
  
  public abstract void setSelfTinyId(String paramString);
  
  public abstract void startGProSdk(String paramString, int paramInt);
  
  public abstract void stopGProSdk();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.api.IGPSService
 * JD-Core Version:    0.7.0.1
 */