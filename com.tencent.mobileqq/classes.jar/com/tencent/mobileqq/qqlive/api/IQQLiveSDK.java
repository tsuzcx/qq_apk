package com.tencent.mobileqq.qqlive.api;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qqlive.api.anchor.IQQLiveAnchorFansService;
import com.tencent.mobileqq.qqlive.api.anchor.IQQLiveAnchorPageService;
import com.tencent.mobileqq.qqlive.api.anchor.IQQLiveModuleAnchor;
import com.tencent.mobileqq.qqlive.api.common.IQQLiveUserCard;
import com.tencent.mobileqq.qqlive.api.config.IQQLiveConfigModule;
import com.tencent.mobileqq.qqlive.api.datareport.IDataReportModule;
import com.tencent.mobileqq.qqlive.api.game.IQQLiveGameListService;
import com.tencent.mobileqq.qqlive.api.gift.IQQLiveGiftEntranceService;
import com.tencent.mobileqq.qqlive.api.login.IQQLiveModuleLogin;
import com.tencent.mobileqq.qqlive.api.lottery.IQQLiveLotteryService;
import com.tencent.mobileqq.qqlive.api.message.IQQLiveFollowMsgService;
import com.tencent.mobileqq.qqlive.api.pendant.IQQLiveModulePendant;
import com.tencent.mobileqq.qqlive.api.room.IAudienceList;
import com.tencent.mobileqq.qqlive.api.room.IAudienceRoom;
import com.tencent.mobileqq.qqlive.api.supervision.IQQLiveBanChat;
import com.tencent.mobileqq.qqlive.api.supervision.IQQLiveModuleKickOut;
import com.tencent.mobileqq.qqlive.api.supervision.IQQLiveModuleReport;
import com.tencent.mobileqq.qqlive.api.supervision.IQQLiveRoomAdmin;
import com.tencent.mobileqq.qqlive.api.upload.IQQLiveModuleFileUpload;
import com.tencent.mobileqq.qqlive.api.verified.IQQLiveVerifyService;
import com.tencent.mobileqq.qqlive.data.config.QQLiveSDKConfig;
import com.tencent.mobileqq.qqlive.data.record.QQLiveCurRoomInfo;
import com.tencent.mobileqq.qqlive.data.record.QQLiveSwitchRoom;
import java.util.List;
import mqq.app.AppRuntime;

public abstract interface IQQLiveSDK
{
  public abstract void clearFetchRoomList();
  
  public abstract IAudienceRoom createAudienceRoom();
  
  @Deprecated
  public abstract IAudienceRoom createAudienceRoom(boolean paramBoolean);
  
  public abstract void destroy();
  
  public abstract IQQLiveAnchorFansService getAnchorFansService();
  
  public abstract IQQLiveModuleAnchor getAnchorModule();
  
  public abstract IQQLiveAnchorPageService getAnchorPageService();
  
  public abstract String getAppId();
  
  public abstract AppRuntime getAppRuntime();
  
  public abstract IAudienceList getAudienceListModule();
  
  public abstract IQQLiveBanChat getBanChatModule();
  
  public abstract IQQLiveConfigModule getConfigModule();
  
  public abstract QQLiveCurRoomInfo getCurRoomInfo();
  
  public abstract IDataReportModule getDataReportModule();
  
  public abstract IQQLiveModule getExtModule(String paramString);
  
  public abstract List<QQLiveSwitchRoom> getFetchRoomList();
  
  public abstract IQQLiveModuleFileUpload getFileUploadModule();
  
  public abstract IQQLiveFollowMsgService getFollowMsgService();
  
  public abstract IQQLiveGameListService getGameListService();
  
  public abstract IQQLiveGiftEntranceService getGiftEntranceService();
  
  public abstract IQQLiveModuleKickOut getKickOutModule();
  
  public abstract IQQLiveModuleLogin getLoginModule();
  
  public abstract IQQLiveLotteryService getLotteryService();
  
  public abstract IQQLiveModulePendant getPendantModule();
  
  public abstract IQQLiveVerifyService getQQLiveVerifyModule();
  
  public abstract IQQLiveModuleReport getReportModule();
  
  public abstract IQQLiveRoomAdmin getRoomAdminModule();
  
  public abstract QQLiveSDKConfig getSDKConfig();
  
  public abstract IQQLiveUserCard getUserCardModule();
  
  public abstract void init(AppRuntime paramAppRuntime, QQLiveSDKConfig paramQQLiveSDKConfig);
  
  public abstract boolean isDestroyed();
  
  public abstract boolean isInited();
  
  public abstract void recordCurRoomInfo(@NonNull QQLiveCurRoomInfo paramQQLiveCurRoomInfo);
  
  public abstract void recordFetchRoomList(@NonNull List<QQLiveSwitchRoom> paramList);
  
  public abstract void registerExtModule(String paramString, IQQLiveModule paramIQQLiveModule, boolean paramBoolean);
  
  public abstract void removeCurRoomRecord(@NonNull long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.IQQLiveSDK
 * JD-Core Version:    0.7.0.1
 */