package com.tencent.mobileqq.qqlive.api.impl;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qqlive.api.IQQLiveModule;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDKManager;
import com.tencent.mobileqq.qqlive.api.anchor.IQQLiveAnchorFansService;
import com.tencent.mobileqq.qqlive.api.anchor.IQQLiveAnchorPageService;
import com.tencent.mobileqq.qqlive.api.anchor.IQQLiveModuleAnchor;
import com.tencent.mobileqq.qqlive.api.common.IQQLiveUserCard;
import com.tencent.mobileqq.qqlive.api.config.IQQLiveConfigModule;
import com.tencent.mobileqq.qqlive.api.datareport.IDataReportModule;
import com.tencent.mobileqq.qqlive.api.game.IQQLiveGameListService;
import com.tencent.mobileqq.qqlive.api.gift.IQQLiveGiftEntranceService;
import com.tencent.mobileqq.qqlive.api.impl.anchor.QQLiveAnchorFansServiceImpl;
import com.tencent.mobileqq.qqlive.api.impl.anchor.QQLiveAnchorPageServiceImpl;
import com.tencent.mobileqq.qqlive.api.impl.anchor.QQLiveModuleAnchorImpl;
import com.tencent.mobileqq.qqlive.api.impl.common.QQLiveUserCardImpl;
import com.tencent.mobileqq.qqlive.api.impl.datareport.BaseDataReportModule;
import com.tencent.mobileqq.qqlive.api.impl.game.QQLiveGameListServiceImpl;
import com.tencent.mobileqq.qqlive.api.impl.gift.QQLiveGiftEntranceServiceImpl;
import com.tencent.mobileqq.qqlive.api.impl.login.QQLiveModuleLoginImpl;
import com.tencent.mobileqq.qqlive.api.impl.lottery.QQLiveLotteryServiceImpl;
import com.tencent.mobileqq.qqlive.api.impl.message.QQLiveFollowMsgServiceImpl;
import com.tencent.mobileqq.qqlive.api.impl.pendant.QQLiveModulePendant;
import com.tencent.mobileqq.qqlive.api.impl.room.AudienceListImpl;
import com.tencent.mobileqq.qqlive.api.impl.room.AudienceRoomImpl;
import com.tencent.mobileqq.qqlive.api.impl.room.QQLiveModuleReportImpl;
import com.tencent.mobileqq.qqlive.api.impl.supervision.QQLiveBanChatImpl;
import com.tencent.mobileqq.qqlive.api.impl.supervision.QQLiveKickOutImpl;
import com.tencent.mobileqq.qqlive.api.impl.supervision.QQLiveRoomAdminImpl;
import com.tencent.mobileqq.qqlive.api.impl.upload.QQLiveModuleFileUploadImpl;
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
import com.tencent.mobileqq.qqlive.empty.QQLiveSsoModuleEmptyImpl;
import com.tencent.mobileqq.qqlive.push.QQLiveRoomPushServiceImpl;
import com.tencent.mobileqq.qqlive.push.api.IQQLiveRoomPushService;
import com.tencent.mobileqq.qqlive.record.QQLiveRoomRecordManagerProxy;
import com.tencent.mobileqq.qqlive.sso.IQQLiveSsoModule;
import com.tencent.mobileqq.qqlive.sso.QQLiveBusinessHandler;
import com.tencent.mobileqq.qqlive.sso.QQLiveSSOCommomHeader;
import com.tencent.mobileqq.qqlive.sso.QQLiveSsoModuleImpl;
import com.tencent.mobileqq.qqlive.utils.QQLiveCaptureContext;
import com.tencent.mobileqq.qqlive.verified.QQLiveVerifyServiceImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class QQLiveSDKImpl
  implements IQQLiveSDK
{
  private static final String TAG = "QQLiveSDK_Impl";
  private IQQLiveAnchorFansService anchorFansService = new QQLiveAnchorFansServiceImpl();
  private IQQLiveModuleAnchor anchorModule = new QQLiveModuleAnchorImpl();
  private IQQLiveAnchorPageService anchorPageService = new QQLiveAnchorPageServiceImpl();
  private String appId;
  private AppInterface appInterface;
  private IAudienceList audienceList = new AudienceListImpl();
  private IQQLiveBanChat banChatModule = new QQLiveBanChatImpl();
  private IQQLiveConfigModule configModule = new QQLiveConfigModule();
  private IDataReportModule dataReportModule = new BaseDataReportModule();
  private ConcurrentHashMap<String, IQQLiveModule> extModuleMap = new ConcurrentHashMap();
  private IQQLiveModuleFileUpload fileUploadModule = new QQLiveModuleFileUploadImpl();
  private IQQLiveFollowMsgService followMsgService = new QQLiveFollowMsgServiceImpl();
  private IQQLiveGameListService gameListService = new QQLiveGameListServiceImpl();
  private IQQLiveGiftEntranceService giftEntranceService = new QQLiveGiftEntranceServiceImpl();
  private boolean isDestroyed = false;
  private boolean isInited = false;
  private IQQLiveModuleKickOut kickOutModule = new QQLiveKickOutImpl();
  private IQQLiveLotteryService liveLotteryService = new QQLiveLotteryServiceImpl();
  private IQQLiveModuleLogin loginModule = new QQLiveModuleLoginImpl();
  private IQQLiveRoomPushService msgPushModule = new QQLiveRoomPushServiceImpl();
  private IQQLiveModulePendant pendantModule = new QQLiveModulePendant();
  private IQQLiveModuleReport reportModule = new QQLiveModuleReportImpl();
  private IQQLiveRoomAdmin roomAdminModule = new QQLiveRoomAdminImpl();
  private QQLiveSDKConfig sdkConfig;
  private IQQLiveSsoModule ssoModule = new QQLiveSsoModuleImpl();
  private List<QQLiveSwitchRoom> switchRoomList = new ArrayList();
  private final Object switchRoomListSyncObject = new Object();
  private IQQLiveUserCard userCardModule = new QQLiveUserCardImpl();
  private IQQLiveVerifyService verifyService = new QQLiveVerifyServiceImpl();
  
  public QQLiveSDKImpl(String paramString)
  {
    this.appId = paramString;
  }
  
  public void clearFetchRoomList()
  {
    synchronized (this.switchRoomListSyncObject)
    {
      if (this.switchRoomList == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQLiveSDK_Impl", 1, "clearFetchRoomList, switchRoomList is null");
        }
      }
      else
      {
        this.switchRoomList.clear();
        if (QLog.isColorLevel()) {
          QLog.d("QQLiveSDK_Impl", 1, "clearFetchRoomList, switchRoomList clear!");
        }
      }
      return;
    }
  }
  
  public IAudienceRoom createAudienceRoom()
  {
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("create audienceRoom, appId:");
      ((StringBuilder)localObject).append(this.appId);
      QLog.d("QQLiveSDK_Impl", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = new AudienceRoomImpl();
    ((IAudienceRoom)localObject).init(this);
    return localObject;
  }
  
  public IAudienceRoom createAudienceRoom(boolean paramBoolean)
  {
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("create audienceRoom, appId:");
      ((StringBuilder)localObject).append(this.appId);
      QLog.d("QQLiveSDK_Impl", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = new AudienceRoomImpl(Boolean.valueOf(paramBoolean));
    ((IAudienceRoom)localObject).init(this);
    return localObject;
  }
  
  public void destroy()
  {
    if (this.isDestroyed) {
      return;
    }
    this.isDestroyed = true;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sdk destroy, appId:");
      ((StringBuilder)localObject).append(this.appId);
      QLog.d("QQLiveSDK_Impl", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.extModuleMap;
    if ((localObject != null) && (!((ConcurrentHashMap)localObject).isEmpty()))
    {
      localObject = this.extModuleMap.entrySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((IQQLiveModule)((Map.Entry)((Iterator)localObject).next()).getValue()).destroy();
      }
    }
    this.extModuleMap.clear();
    localObject = this.loginModule;
    if (localObject != null) {
      ((IQQLiveModuleLogin)localObject).destroy();
    }
    localObject = this.followMsgService;
    if (localObject != null) {
      ((IQQLiveFollowMsgService)localObject).destroy();
    }
    localObject = this.gameListService;
    if (localObject != null) {
      ((IQQLiveGameListService)localObject).destroy();
    }
    localObject = this.anchorFansService;
    if (localObject != null) {
      ((IQQLiveAnchorFansService)localObject).destroy();
    }
    localObject = this.giftEntranceService;
    if (localObject != null) {
      ((IQQLiveGiftEntranceService)localObject).destroy();
    }
    localObject = this.appInterface;
    if (localObject != null)
    {
      localObject = (QQLiveBusinessHandler)((AppInterface)localObject).getBusinessHandler(QQLiveBusinessHandler.a);
      if (localObject != null) {
        ((QQLiveBusinessHandler)localObject).a(this.appId);
      }
      this.appInterface = null;
    }
    else
    {
      QLog.e("QQLiveSDK_Impl", 1, "[destroy] appInterface is null");
    }
    this.sdkConfig = null;
    if (this.appId != null) {
      ((IQQLiveSDKManager)QRoute.api(IQQLiveSDKManager.class)).removeSDKImpl(this.appId);
    }
  }
  
  public IQQLiveAnchorFansService getAnchorFansService()
  {
    return this.anchorFansService;
  }
  
  public IQQLiveModuleAnchor getAnchorModule()
  {
    return this.anchorModule;
  }
  
  public IQQLiveAnchorPageService getAnchorPageService()
  {
    return this.anchorPageService;
  }
  
  public String getAppId()
  {
    return this.appId;
  }
  
  public AppRuntime getAppRuntime()
  {
    return this.appInterface;
  }
  
  public IAudienceList getAudienceListModule()
  {
    return this.audienceList;
  }
  
  public IQQLiveBanChat getBanChatModule()
  {
    return this.banChatModule;
  }
  
  public IQQLiveConfigModule getConfigModule()
  {
    return this.configModule;
  }
  
  public QQLiveCurRoomInfo getCurRoomInfo()
  {
    return QQLiveRoomRecordManagerProxy.a(this.appId);
  }
  
  public IDataReportModule getDataReportModule()
  {
    return this.dataReportModule;
  }
  
  public IQQLiveModule getExtModule(String paramString)
  {
    IQQLiveModule localIQQLiveModule = (IQQLiveModule)this.extModuleMap.get(paramString);
    if ((localIQQLiveModule == null) && (TextUtils.equals("sso_module", paramString))) {
      return new QQLiveSsoModuleEmptyImpl();
    }
    return localIQQLiveModule;
  }
  
  public List<QQLiveSwitchRoom> getFetchRoomList()
  {
    return this.switchRoomList;
  }
  
  public IQQLiveModuleFileUpload getFileUploadModule()
  {
    return this.fileUploadModule;
  }
  
  public IQQLiveFollowMsgService getFollowMsgService()
  {
    return this.followMsgService;
  }
  
  public IQQLiveGameListService getGameListService()
  {
    return this.gameListService;
  }
  
  public IQQLiveGiftEntranceService getGiftEntranceService()
  {
    return this.giftEntranceService;
  }
  
  public IQQLiveModuleKickOut getKickOutModule()
  {
    return this.kickOutModule;
  }
  
  public IQQLiveModuleLogin getLoginModule()
  {
    return this.loginModule;
  }
  
  public IQQLiveLotteryService getLotteryService()
  {
    return this.liveLotteryService;
  }
  
  public IQQLiveModulePendant getPendantModule()
  {
    return this.pendantModule;
  }
  
  public IQQLiveVerifyService getQQLiveVerifyModule()
  {
    return this.verifyService;
  }
  
  public IQQLiveModuleReport getReportModule()
  {
    return this.reportModule;
  }
  
  public IQQLiveRoomAdmin getRoomAdminModule()
  {
    return this.roomAdminModule;
  }
  
  public QQLiveSDKConfig getSDKConfig()
  {
    return this.sdkConfig;
  }
  
  public IQQLiveUserCard getUserCardModule()
  {
    return this.userCardModule;
  }
  
  public void init(AppRuntime paramAppRuntime, QQLiveSDKConfig paramQQLiveSDKConfig)
  {
    if (QLog.isColorLevel())
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("sdk init:");
      paramAppRuntime.append(this.appId);
      QLog.d("QQLiveSDK_Impl", 1, paramAppRuntime.toString());
    }
    this.appInterface = QQLiveCaptureContext.a();
    this.sdkConfig = paramQQLiveSDKConfig;
    this.configModule.init(this);
    this.configModule.asyncGetConfigData(new QQLiveSDKImpl.1(this));
    paramAppRuntime = this.appInterface;
    if (paramAppRuntime == null)
    {
      QLog.e("QQLiveSDK_Impl", 1, "[init] getAppInterface is null!");
    }
    else
    {
      paramAppRuntime = (QQLiveBusinessHandler)paramAppRuntime.getBusinessHandler(QQLiveBusinessHandler.a);
      if (paramAppRuntime != null) {
        paramAppRuntime.a(this.appId, new QQLiveSSOCommomHeader(this.loginModule, this.sdkConfig, this.configModule.getConfigData()));
      }
    }
    registerExtModule("sso_module", this.ssoModule, true);
    registerExtModule("roomPush", this.msgPushModule, true);
    this.liveLotteryService.init(this);
    this.dataReportModule.init(this);
    this.loginModule.init(this);
    this.anchorModule.init(this);
    this.verifyService.init(this);
    this.audienceList.init(this);
    this.roomAdminModule.init(this);
    this.banChatModule.init(this);
    this.kickOutModule.init(this);
    this.reportModule.init(this);
    this.pendantModule.init(this);
    this.fileUploadModule.init(this);
    this.followMsgService.init(this);
    this.gameListService.init(this);
    this.giftEntranceService.init(this);
    this.anchorFansService.init(this);
    this.anchorPageService.init(this);
    this.userCardModule.init(this);
    this.isInited = true;
  }
  
  public boolean isDestroyed()
  {
    return this.isDestroyed;
  }
  
  public boolean isInited()
  {
    return this.isInited;
  }
  
  public void recordCurRoomInfo(@NonNull QQLiveCurRoomInfo paramQQLiveCurRoomInfo)
  {
    QQLiveRoomRecordManagerProxy.a(this.appId, paramQQLiveCurRoomInfo);
  }
  
  public void recordFetchRoomList(@NonNull List<QQLiveSwitchRoom> paramList)
  {
    synchronized (this.switchRoomListSyncObject)
    {
      this.switchRoomList = paramList;
      return;
    }
  }
  
  public void registerExtModule(String paramString, IQQLiveModule paramIQQLiveModule, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramIQQLiveModule == null) {
        return;
      }
      this.extModuleMap.put(paramString, paramIQQLiveModule);
      if (paramBoolean) {
        paramIQQLiveModule.init(this);
      }
    }
  }
  
  public void removeCurRoomRecord(@NonNull long paramLong)
  {
    QQLiveRoomRecordManagerProxy.a(this.appId, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.QQLiveSDKImpl
 * JD-Core Version:    0.7.0.1
 */