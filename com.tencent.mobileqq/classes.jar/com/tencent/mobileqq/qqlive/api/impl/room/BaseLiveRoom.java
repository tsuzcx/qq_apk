package com.tencent.mobileqq.qqlive.api.impl.room;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.datareport.IDataReportModule;
import com.tencent.mobileqq.qqlive.api.gift.IQQLiveGiftService;
import com.tencent.mobileqq.qqlive.api.heart.IQQLiveFloatHeartService;
import com.tencent.mobileqq.qqlive.api.impl.gift.QQLiveGiftServiceImpl;
import com.tencent.mobileqq.qqlive.api.impl.lottery.QQLiveLotteryServiceImpl;
import com.tencent.mobileqq.qqlive.api.impl.message.QQLiveAnnounceMsgServiceImpl;
import com.tencent.mobileqq.qqlive.api.impl.message.QQLiveChatMsgServiceImpl;
import com.tencent.mobileqq.qqlive.api.impl.message.QQLiveEnterRoomServiceImpl;
import com.tencent.mobileqq.qqlive.api.impl.message.QQLiveFloatHeartServiceImpl;
import com.tencent.mobileqq.qqlive.api.impl.message.QQLiveFollowMsgServiceImpl;
import com.tencent.mobileqq.qqlive.api.impl.message.QQLivePushCmdServiceImpl;
import com.tencent.mobileqq.qqlive.api.impl.message.QQLiveSystemMsgServiceImpl;
import com.tencent.mobileqq.qqlive.api.impl.room.report.QQLiveRoomBizReportHelper;
import com.tencent.mobileqq.qqlive.api.login.IQQLiveModuleLogin;
import com.tencent.mobileqq.qqlive.api.lottery.IQQLiveLotteryService;
import com.tencent.mobileqq.qqlive.api.message.IQQLiveAnnounceMsgService;
import com.tencent.mobileqq.qqlive.api.message.IQQLiveChatMsgService;
import com.tencent.mobileqq.qqlive.api.message.IQQLiveEnterRoomService;
import com.tencent.mobileqq.qqlive.api.message.IQQLiveFollowMsgService;
import com.tencent.mobileqq.qqlive.api.message.IQQLivePushCmdService;
import com.tencent.mobileqq.qqlive.api.message.IQQLiveSystemMsgService;
import com.tencent.mobileqq.qqlive.api.room.ILiveRoom;
import com.tencent.mobileqq.qqlive.callback.announce.IQQLiveAnnouncePushListener;
import com.tencent.mobileqq.qqlive.callback.announce.IQQLiveGetAnnounceCallback;
import com.tencent.mobileqq.qqlive.callback.announce.IQQLiveSetAnnounceCallback;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveReceiveFollowListener;
import com.tencent.mobileqq.qqlive.callback.gift.ReceiveGiftMessageListener;
import com.tencent.mobileqq.qqlive.callback.lottery.IQQLiveLotteryCallback;
import com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback;
import com.tencent.mobileqq.qqlive.callback.message.IQQLiveMessageCallback;
import com.tencent.mobileqq.qqlive.callback.message.IQQLiveReceiveMessageListener;
import com.tencent.mobileqq.qqlive.callback.room.RoomAudienceInfoListener;
import com.tencent.mobileqq.qqlive.callback.room.audience.ExitRoomCallback;
import com.tencent.mobileqq.qqlive.callback.room.audience.GetRoomInfoCallback;
import com.tencent.mobileqq.qqlive.callback.room.audience.LiveRoomStatusListener;
import com.tencent.mobileqq.qqlive.data.heart.FloatHeart;
import com.tencent.mobileqq.qqlive.data.message.LiveMessageData.ExtData;
import com.tencent.mobileqq.qqlive.data.room.BaseAnchorInfo;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;
import com.tencent.mobileqq.qqlive.listener.heart.OnReceiveFloatHeartListener;
import com.tencent.mobileqq.qqlive.push.api.IQQLiveRoomPushService;
import com.tencent.mobileqq.qqlive.report.IQQLiveReportCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Map;

public abstract class BaseLiveRoom
  implements ILiveRoom
{
  private static final String TAG = "BaseLiveRoom";
  private IQQLiveAnnounceMsgService announceMsgService = new QQLiveAnnounceMsgServiceImpl();
  protected String appId;
  private IQQLiveChatMsgService chatMsgService = new QQLiveChatMsgServiceImpl();
  protected int commonRoomHeartInterval = 30000;
  private IQQLiveEnterRoomService enterRoomService = new QQLiveEnterRoomServiceImpl();
  private IQQLiveFloatHeartService floatHeartService = new QQLiveFloatHeartServiceImpl();
  private IQQLiveFollowMsgService followMsgService = new QQLiveFollowMsgServiceImpl();
  private final RoomGetInfoModule getInfoModule = new RoomGetInfoModule();
  private IQQLiveGiftService giftService = new QQLiveGiftServiceImpl();
  protected Handler heartHandler;
  protected HandlerThread heartThread;
  protected boolean isDestroy = false;
  protected boolean isExitRoom = false;
  protected boolean isInited = false;
  private IQQLiveLotteryService liveLotteryService = new QQLiveLotteryServiceImpl();
  protected IQQLiveSDK liveSDK = null;
  private IQQLivePushCmdService pushCmdService = new QQLivePushCmdServiceImpl();
  QQLiveRoomBizReportHelper reportHelper = new QQLiveRoomBizReportHelper();
  LiveRoomStatusService roomStatusService = new LiveRoomStatusService();
  private final long startTimeStamp = NetConnInfoCenter.getServerTimeMillis();
  private IQQLiveSystemMsgService systemMsgService = new QQLiveSystemMsgServiceImpl();
  
  private void doGetRoomRealTimeInfo(GetRoomInfoCallback paramGetRoomInfoCallback)
  {
    if (getRoomInfo() == null)
    {
      paramGetRoomInfoCallback.a(5106, "please enterRoom first");
      return;
    }
    this.getInfoModule.getRoomRealTimeInfo(getRoomInfo().getRoomId(), getRoomInfo().getProgramId(), this.liveSDK, paramGetRoomInfoCallback);
  }
  
  private void sendCommonHeart(int paramInt)
  {
    if (this.isDestroy) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseLiveRoom", 1, "send Audience heart");
    }
    Handler localHandler = this.heartHandler;
    if (localHandler == null) {
      return;
    }
    localHandler.postDelayed(new BaseLiveRoom.1(this), paramInt);
  }
  
  public void clearReportCallback()
  {
    QQLiveRoomBizReportHelper localQQLiveRoomBizReportHelper = this.reportHelper;
    if (localQQLiveRoomBizReportHelper != null) {
      localQQLiveRoomBizReportHelper.clearReportCallback();
    }
  }
  
  public void destroy()
  {
    QLog.i("BaseLiveRoom", 1, "destroy");
    Object localObject = (IQQLiveRoomPushService)this.liveSDK.getExtModule("roomPush");
    BaseRoomInfo localBaseRoomInfo = getRoomInfo();
    if ((localBaseRoomInfo != null) && (localObject != null) && (((IQQLiveRoomPushService)localObject).b() == localBaseRoomInfo.getRoomId())) {
      ((IQQLiveRoomPushService)localObject).reset();
    }
    localObject = this.chatMsgService;
    if (localObject != null)
    {
      ((IQQLiveChatMsgService)localObject).destroy();
      this.chatMsgService = null;
    }
    localObject = this.systemMsgService;
    if (localObject != null)
    {
      ((IQQLiveSystemMsgService)localObject).destroy();
      this.systemMsgService = null;
    }
    localObject = this.enterRoomService;
    if (localObject != null)
    {
      ((IQQLiveEnterRoomService)localObject).destroy();
      this.enterRoomService = null;
    }
    localObject = this.floatHeartService;
    if (localObject != null)
    {
      ((IQQLiveFloatHeartService)localObject).destroy();
      this.floatHeartService = null;
    }
    localObject = this.giftService;
    if (localObject != null)
    {
      ((IQQLiveGiftService)localObject).destroy();
      this.giftService = null;
    }
    localObject = this.followMsgService;
    if (localObject != null)
    {
      ((IQQLiveFollowMsgService)localObject).destroy();
      this.followMsgService = null;
    }
    localObject = this.roomStatusService;
    if (localObject != null)
    {
      ((LiveRoomStatusService)localObject).destroy();
      this.roomStatusService = null;
    }
    localObject = this.announceMsgService;
    if (localObject != null)
    {
      ((IQQLiveAnnounceMsgService)localObject).destroy();
      this.announceMsgService = null;
    }
    localObject = this.pushCmdService;
    if (localObject != null)
    {
      ((IQQLivePushCmdService)localObject).destroy();
      this.pushCmdService = null;
    }
    stopHeart();
    this.isDestroy = true;
    localObject = this.reportHelper;
    if (localObject != null) {
      ((QQLiveRoomBizReportHelper)localObject).destroy();
    }
  }
  
  public void exitRoom(ExitRoomCallback paramExitRoomCallback)
  {
    this.isExitRoom = true;
    paramExitRoomCallback = this.reportHelper;
    if (paramExitRoomCallback != null) {
      paramExitRoomCallback.onExitRoom();
    }
    reset();
  }
  
  public long getEnterRoomTime()
  {
    QQLiveRoomBizReportHelper localQQLiveRoomBizReportHelper = this.reportHelper;
    if (localQQLiveRoomBizReportHelper != null) {
      return localQQLiveRoomBizReportHelper.getEnterRoomTime();
    }
    return 0L;
  }
  
  public void getLotteryPendant(long paramLong1, long paramLong2, String paramString, Map<String, String> paramMap, IQQLiveLotteryCallback paramIQQLiveLotteryCallback)
  {
    if (this.isDestroy) {
      return;
    }
    this.liveLotteryService.getLotteryPendant(paramLong1, paramLong2, paramString, paramMap, paramIQQLiveLotteryCallback);
  }
  
  public void getRoomAnnounce(long paramLong, IQQLiveGetAnnounceCallback paramIQQLiveGetAnnounceCallback)
  {
    if (this.isDestroy) {
      return;
    }
    this.announceMsgService.getRoomAnnounce(paramLong, paramIQQLiveGetAnnounceCallback);
  }
  
  public void getRoomRealTimeInfo(GetRoomInfoCallback paramGetRoomInfoCallback)
  {
    if (this.isDestroy) {
      return;
    }
    IQQLiveModuleLogin localIQQLiveModuleLogin = this.liveSDK.getLoginModule();
    if ((localIQQLiveModuleLogin.getLoginStatus() != 3) && (localIQQLiveModuleLogin.getLoginStatus() != 0))
    {
      if (localIQQLiveModuleLogin.getLoginStatus() == 2)
      {
        QLog.i("BaseLiveRoom", 1, "getRoomRealTimeInfo waiting login");
        localIQQLiveModuleLogin.registerLoginStateCallback(new BaseLiveRoom.2(this, localIQQLiveModuleLogin, paramGetRoomInfoCallback));
        return;
      }
      doGetRoomRealTimeInfo(paramGetRoomInfoCallback);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getRoomRealTimeInfo failed loginStatus is ");
    localStringBuilder.append(localIQQLiveModuleLogin.getLoginStatus());
    QLog.e("BaseLiveRoom", 1, localStringBuilder.toString());
    paramGetRoomInfoCallback.a(5105, "login failed");
  }
  
  public void init(IQQLiveSDK paramIQQLiveSDK)
  {
    this.liveSDK = paramIQQLiveSDK;
    if (this.liveSDK.getSDKConfig() != null) {
      this.appId = this.liveSDK.getAppId();
    }
    String str = this.appId;
    Object localObject = str;
    if (str == null) {
      localObject = "";
    }
    this.appId = ((String)localObject);
    localObject = this.reportHelper;
    if (localObject != null) {
      ((QQLiveRoomBizReportHelper)localObject).init(paramIQQLiveSDK, this);
    }
  }
  
  public boolean isDestroyed()
  {
    return this.isDestroy;
  }
  
  public boolean isExitRoom()
  {
    return this.isExitRoom;
  }
  
  public boolean isInited()
  {
    return this.isInited;
  }
  
  protected void onEnterRoom()
  {
    if (this.isDestroy) {
      return;
    }
    ((IQQLiveRoomPushService)this.liveSDK.getExtModule("roomPush")).a(0L, getRoomInfo().getRoomId());
    this.chatMsgService.init(this.liveSDK);
    this.systemMsgService.init(this.liveSDK);
    this.enterRoomService.init(this.liveSDK);
    this.enterRoomService.bindRoom(this);
    this.floatHeartService.init(this.liveSDK);
    this.giftService.init(this.liveSDK);
    this.followMsgService.init(this.liveSDK);
    this.announceMsgService.init(this.liveSDK);
    this.pushCmdService.init(this.liveSDK);
    this.liveLotteryService.init(this.liveSDK);
    this.roomStatusService.init(this.liveSDK);
    if (isAnchorRoom()) {
      startHeart();
    }
    this.liveSDK.getDataReportModule().setRoomInfo(getRoomInfo());
    QQLiveRoomBizReportHelper localQQLiveRoomBizReportHelper = this.reportHelper;
    if (localQQLiveRoomBizReportHelper != null) {
      localQQLiveRoomBizReportHelper.onEnterRoom();
    }
  }
  
  public void registerAnnounceMessageListener(IQQLiveAnnouncePushListener paramIQQLiveAnnouncePushListener)
  {
    if (this.isDestroy) {
      return;
    }
    this.announceMsgService.addAnnounceMessageListener(paramIQQLiveAnnouncePushListener);
  }
  
  public void registerAudienceInfoListener(RoomAudienceInfoListener paramRoomAudienceInfoListener)
  {
    if (this.isDestroy) {
      return;
    }
    this.enterRoomService.addEnterRoomMessageListener(paramRoomAudienceInfoListener);
  }
  
  public void registerFollowMessageListener(IQQLiveReceiveFollowListener paramIQQLiveReceiveFollowListener)
  {
    if (this.isDestroy) {
      return;
    }
    this.followMsgService.addFollowMessageListener(paramIQQLiveReceiveFollowListener);
  }
  
  public void registerHighPriorityListener(int paramInt, IQQCmdPushCallback paramIQQCmdPushCallback)
  {
    if (this.isDestroy) {
      return;
    }
    this.pushCmdService.registerHighPriorityListener(paramInt, paramIQQCmdPushCallback);
  }
  
  public void registerLowPriorityListener(int paramInt, IQQCmdPushCallback paramIQQCmdPushCallback)
  {
    if (this.isDestroy) {
      return;
    }
    this.pushCmdService.registerLowPriorityListener(paramInt, paramIQQCmdPushCallback);
  }
  
  public void registerOnReceiveFloatHeartListener(OnReceiveFloatHeartListener paramOnReceiveFloatHeartListener)
  {
    if (this.isDestroy) {
      return;
    }
    this.floatHeartService.addOnReceiveFloatHeartListener(paramOnReceiveFloatHeartListener);
  }
  
  public void registerReceiveGiftMessageListener(ReceiveGiftMessageListener paramReceiveGiftMessageListener)
  {
    if (this.isDestroy) {
      return;
    }
    this.giftService.addReceiveGiftMessageListener(paramReceiveGiftMessageListener);
  }
  
  public void registerReportCallback(IQQLiveReportCallback paramIQQLiveReportCallback)
  {
    QQLiveRoomBizReportHelper localQQLiveRoomBizReportHelper = this.reportHelper;
    if (localQQLiveRoomBizReportHelper != null) {
      localQQLiveRoomBizReportHelper.registerReportCallback(paramIQQLiveReportCallback);
    }
  }
  
  public void registerRoomChatMsgListener(IQQLiveReceiveMessageListener paramIQQLiveReceiveMessageListener)
  {
    if (this.isDestroy) {
      return;
    }
    this.chatMsgService.addChatMessageListener(paramIQQLiveReceiveMessageListener);
  }
  
  public void registerRoomStatusListener(LiveRoomStatusListener paramLiveRoomStatusListener)
  {
    if (this.isDestroy) {
      return;
    }
    this.roomStatusService.registerRoomInfoListener(paramLiveRoomStatusListener);
  }
  
  public void registerSystemMsgListener(IQQLiveReceiveMessageListener paramIQQLiveReceiveMessageListener)
  {
    if (this.isDestroy) {
      return;
    }
    this.systemMsgService.addSystemMessageListener(paramIQQLiveReceiveMessageListener);
  }
  
  public void reset()
  {
    QLog.i("BaseLiveRoom", 1, "reset");
    Object localObject = this.reportHelper;
    if (localObject != null) {
      ((QQLiveRoomBizReportHelper)localObject).reset();
    }
    try
    {
      if (this.isDestroy) {
        return;
      }
      localObject = (IQQLiveRoomPushService)this.liveSDK.getExtModule("roomPush");
      BaseRoomInfo localBaseRoomInfo = getRoomInfo();
      if ((localBaseRoomInfo != null) && (((IQQLiveRoomPushService)localObject).b() == localBaseRoomInfo.getRoomId())) {
        ((IQQLiveRoomPushService)localObject).reset();
      }
      if (this.chatMsgService != null) {
        this.chatMsgService.reset();
      }
      if (this.systemMsgService != null) {
        this.systemMsgService.reset();
      }
      if (this.enterRoomService != null) {
        this.enterRoomService.reset();
      }
      if (this.floatHeartService != null) {
        this.floatHeartService.reset();
      }
      if (this.giftService != null) {
        this.giftService.reset();
      }
      if (this.followMsgService != null) {
        this.followMsgService.reset();
      }
      if (this.roomStatusService != null) {
        this.roomStatusService.reset();
      }
      if (this.announceMsgService != null) {
        this.announceMsgService.reset();
      }
      if (this.pushCmdService != null) {
        this.pushCmdService.reset();
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("BaseLiveRoom", 1, localThrowable.getMessage());
    }
    stopHeart();
  }
  
  public void sendFloatHeart()
  {
    if (this.isDestroy) {
      return;
    }
    FloatHeart localFloatHeart = new FloatHeart();
    localFloatHeart.anchorUid = getAnchorInfo().getAnchorUid();
    localFloatHeart.roomId = getRoomInfo().getRoomId();
    localFloatHeart.freeLoves = new ArrayList();
    localFloatHeart.subRoomId = getRoomInfo().getRoomId();
    localFloatHeart.programId = getRoomInfo().getProgramId();
    this.floatHeartService.sendFloatHeart(localFloatHeart);
  }
  
  public void sendMessage(String paramString, ArrayList<LiveMessageData.ExtData> paramArrayList, IQQLiveMessageCallback paramIQQLiveMessageCallback)
  {
    if (this.isDestroy) {
      return;
    }
    this.chatMsgService.sendMessage(paramString, paramArrayList, paramIQQLiveMessageCallback);
  }
  
  public void setEnterRoomTime(long paramLong)
  {
    QQLiveRoomBizReportHelper localQQLiveRoomBizReportHelper = this.reportHelper;
    if (localQQLiveRoomBizReportHelper != null) {
      localQQLiveRoomBizReportHelper.setEnterRoomTime(paramLong);
    }
  }
  
  public void setRoomAnnounce(long paramLong1, long paramLong2, String paramString, IQQLiveSetAnnounceCallback paramIQQLiveSetAnnounceCallback)
  {
    if (this.isDestroy) {
      return;
    }
    this.announceMsgService.setRoomAnnounce(paramLong1, paramLong2, paramString, paramIQQLiveSetAnnounceCallback);
  }
  
  public void setRoomAnnounce(long paramLong1, long paramLong2, String paramString, Map<Integer, String> paramMap, IQQLiveSetAnnounceCallback paramIQQLiveSetAnnounceCallback)
  {
    if (this.isDestroy) {
      return;
    }
    this.announceMsgService.setRoomAnnounce(paramLong1, paramLong2, paramString, paramMap, paramIQQLiveSetAnnounceCallback);
  }
  
  public void setSeq(String paramString1, String paramString2, long paramLong)
  {
    QQLiveRoomBizReportHelper localQQLiveRoomBizReportHelper = this.reportHelper;
    if (localQQLiveRoomBizReportHelper != null) {
      localQQLiveRoomBizReportHelper.setSeq(paramString1, paramString2, paramLong);
    }
  }
  
  protected void startHeart()
  {
    if (this.isDestroy) {
      return;
    }
    if (this.heartHandler == null)
    {
      this.heartThread = new HandlerThread("room-heart");
      this.heartThread.start();
      this.heartHandler = new Handler(this.heartThread.getLooper());
    }
    sendCommonHeart(0);
  }
  
  public void startRoomTimer(long paramLong)
  {
    QQLiveRoomBizReportHelper localQQLiveRoomBizReportHelper = this.reportHelper;
    if (localQQLiveRoomBizReportHelper != null) {
      localQQLiveRoomBizReportHelper.startRoomHeartForBiz(paramLong);
    }
  }
  
  protected void stopHeart()
  {
    try
    {
      if (this.heartHandler != null)
      {
        this.heartHandler = null;
        this.heartThread.quit();
        this.heartThread = null;
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("stopHeart error: ");
      localStringBuilder.append(localThrowable.getMessage());
      QLog.e("BaseLiveRoom", 1, localStringBuilder.toString());
    }
  }
  
  public void stopRoomTimer()
  {
    QQLiveRoomBizReportHelper localQQLiveRoomBizReportHelper = this.reportHelper;
    if (localQQLiveRoomBizReportHelper != null) {
      localQQLiveRoomBizReportHelper.stopRoomHeartForBiz();
    }
  }
  
  public void unRegisterAnnounceMessageListener(IQQLiveAnnouncePushListener paramIQQLiveAnnouncePushListener)
  {
    if (this.isDestroy) {
      return;
    }
    this.announceMsgService.delAnnounceMessageListener(paramIQQLiveAnnouncePushListener);
  }
  
  public void unRegisterAudienceInfoListener(RoomAudienceInfoListener paramRoomAudienceInfoListener)
  {
    if (this.isDestroy) {
      return;
    }
    this.enterRoomService.delEnterRoomMessageListener(paramRoomAudienceInfoListener);
  }
  
  public void unRegisterFollowMessageListener(IQQLiveReceiveFollowListener paramIQQLiveReceiveFollowListener)
  {
    if (this.isDestroy) {
      return;
    }
    this.followMsgService.delFollowMessageListener(paramIQQLiveReceiveFollowListener);
  }
  
  public void unRegisterHighPriorityListener(int paramInt, IQQCmdPushCallback paramIQQCmdPushCallback)
  {
    if (this.isDestroy) {
      return;
    }
    this.pushCmdService.unRegisterHighPriorityListener(paramInt, paramIQQCmdPushCallback);
  }
  
  public void unRegisterLowPriorityListener(int paramInt, IQQCmdPushCallback paramIQQCmdPushCallback)
  {
    if (this.isDestroy) {
      return;
    }
    this.pushCmdService.unRegisterLowPriorityListener(paramInt, paramIQQCmdPushCallback);
  }
  
  public void unRegisterOnReceiveFloatHeartListener(OnReceiveFloatHeartListener paramOnReceiveFloatHeartListener)
  {
    if (this.isDestroy) {
      return;
    }
    this.floatHeartService.removeOnReceiveFloatHeartListener(paramOnReceiveFloatHeartListener);
  }
  
  public void unRegisterReceiveGiftMessageListener(ReceiveGiftMessageListener paramReceiveGiftMessageListener)
  {
    if (this.isDestroy) {
      return;
    }
    this.giftService.delReceiveGiftMessageListener(paramReceiveGiftMessageListener);
  }
  
  public void unRegisterReportCallback(IQQLiveReportCallback paramIQQLiveReportCallback)
  {
    QQLiveRoomBizReportHelper localQQLiveRoomBizReportHelper = this.reportHelper;
    if (localQQLiveRoomBizReportHelper != null) {
      localQQLiveRoomBizReportHelper.unRegisterReportCallback(paramIQQLiveReportCallback);
    }
  }
  
  public void unRegisterRoomChatMsgListener(IQQLiveReceiveMessageListener paramIQQLiveReceiveMessageListener)
  {
    if (this.isDestroy) {
      return;
    }
    this.chatMsgService.delChatMessageListener(paramIQQLiveReceiveMessageListener);
  }
  
  public void unRegisterRoomStatusListener(LiveRoomStatusListener paramLiveRoomStatusListener)
  {
    if (this.isDestroy) {
      return;
    }
    this.roomStatusService.unRegisterRoomInfoListener(paramLiveRoomStatusListener);
  }
  
  public void unRegisterSystemMsgListener(IQQLiveReceiveMessageListener paramIQQLiveReceiveMessageListener)
  {
    if (this.isDestroy) {
      return;
    }
    this.systemMsgService.delSystemMessageListener(paramIQQLiveReceiveMessageListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.room.BaseLiveRoom
 * JD-Core Version:    0.7.0.1
 */