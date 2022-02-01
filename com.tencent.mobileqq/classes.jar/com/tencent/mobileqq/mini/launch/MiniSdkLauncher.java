package com.tencent.mobileqq.mini.launch;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;
import com.tencent.mobileqq.mini.apkg.BaseLibManager;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.tissue.TissueEnvImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.MiniSDK;
import com.tencent.qqmini.sdk.launcher.dynamic.MiniDynamicManager;
import com.tencent.qqmini.sdk.launcher.model.ResourcePreCacheInfo;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class MiniSdkLauncher
{
  private static final String TAG = "MiniSdkLauncher";
  private static volatile boolean sIsMiniAppCheckinPreLaunched = false;
  private static volatile boolean sSdkInited = false;
  
  public static com.tencent.mobileqq.mini.apkg.MiniAppInfo convert(com.tencent.qqmini.sdk.launcher.model.MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {
      return null;
    }
    com.tencent.mobileqq.mini.apkg.MiniAppInfo localMiniAppInfo = new com.tencent.mobileqq.mini.apkg.MiniAppInfo();
    localMiniAppInfo.appId = paramMiniAppInfo.appId;
    localMiniAppInfo.name = paramMiniAppInfo.name;
    localMiniAppInfo.iconUrl = paramMiniAppInfo.iconUrl;
    localMiniAppInfo.downloadUrl = paramMiniAppInfo.downloadUrl;
    localMiniAppInfo.setReportType(paramMiniAppInfo.getReportType());
    localMiniAppInfo.version = paramMiniAppInfo.version;
    localMiniAppInfo.versionId = paramMiniAppInfo.versionId;
    localMiniAppInfo.desc = paramMiniAppInfo.desc;
    localMiniAppInfo.verType = paramMiniAppInfo.verType;
    localMiniAppInfo.timestamp = paramMiniAppInfo.timestamp;
    localMiniAppInfo.baselibMiniVersion = paramMiniAppInfo.baselibMiniVersion;
    Iterator localIterator;
    Object localObject1;
    Object localObject2;
    if (paramMiniAppInfo.subpkgs != null)
    {
      localMiniAppInfo.subpkgs = new ArrayList();
      localIterator = paramMiniAppInfo.subpkgs.iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (com.tencent.qqmini.sdk.launcher.model.SubPkgInfo)localIterator.next();
        localObject2 = new com.tencent.mobileqq.mini.apkg.SubPkgInfo();
        ((com.tencent.mobileqq.mini.apkg.SubPkgInfo)localObject2).subPkgName = ((com.tencent.qqmini.sdk.launcher.model.SubPkgInfo)localObject1).subPkgName;
        ((com.tencent.mobileqq.mini.apkg.SubPkgInfo)localObject2).downloadUrl = ((com.tencent.qqmini.sdk.launcher.model.SubPkgInfo)localObject1).downloadUrl;
        ((com.tencent.mobileqq.mini.apkg.SubPkgInfo)localObject2).independent = ((com.tencent.qqmini.sdk.launcher.model.SubPkgInfo)localObject1).independent;
        ((com.tencent.mobileqq.mini.apkg.SubPkgInfo)localObject2).fileSize = ((com.tencent.qqmini.sdk.launcher.model.SubPkgInfo)localObject1).fileSize;
        localMiniAppInfo.subpkgs.add(localObject2);
      }
    }
    if (paramMiniAppInfo.firstPage != null)
    {
      localMiniAppInfo.firstPage = new com.tencent.mobileqq.mini.apkg.FirstPageInfo();
      localMiniAppInfo.firstPage.pagePath = paramMiniAppInfo.firstPage.pagePath;
      localMiniAppInfo.firstPage.subPkgName = paramMiniAppInfo.firstPage.subPkgName;
    }
    if (paramMiniAppInfo.preCacheList != null)
    {
      localMiniAppInfo.preCacheList = new ArrayList();
      localIterator = paramMiniAppInfo.preCacheList.iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (com.tencent.qqmini.sdk.launcher.model.PreCacheInfo)localIterator.next();
        if (localObject1 != null) {
          localMiniAppInfo.preCacheList.add(new com.tencent.mobileqq.mini.apkg.PreCacheInfo(((com.tencent.qqmini.sdk.launcher.model.PreCacheInfo)localObject1).getDataUrl, ((com.tencent.qqmini.sdk.launcher.model.PreCacheInfo)localObject1).preCacheKey, ((com.tencent.qqmini.sdk.launcher.model.PreCacheInfo)localObject1).expireTime, ((com.tencent.qqmini.sdk.launcher.model.PreCacheInfo)localObject1).cacheType, ((com.tencent.qqmini.sdk.launcher.model.PreCacheInfo)localObject1).useProxy));
        }
      }
    }
    if (paramMiniAppInfo.resourcePreCacheInfo != null)
    {
      localMiniAppInfo.resourcePreCacheInfo = new ArrayList();
      localIterator = paramMiniAppInfo.resourcePreCacheInfo.iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (ResourcePreCacheInfo)localIterator.next();
        if (localObject1 != null) {
          localMiniAppInfo.resourcePreCacheInfo.add(new ResourcePreCacheInfo(((ResourcePreCacheInfo)localObject1).getDataUrl));
        }
      }
    }
    localMiniAppInfo.whiteList = paramMiniAppInfo.whiteList;
    localMiniAppInfo.blackList = paramMiniAppInfo.blackList;
    if (paramMiniAppInfo.secondApiRightInfoList != null)
    {
      localMiniAppInfo.secondApiRightInfoList = new ArrayList();
      localIterator = paramMiniAppInfo.secondApiRightInfoList.iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (com.tencent.qqmini.sdk.launcher.model.SecondApiRightInfo)localIterator.next();
        localObject2 = new com.tencent.mobileqq.mini.apkg.SecondApiRightInfo();
        ((com.tencent.mobileqq.mini.apkg.SecondApiRightInfo)localObject2).apiName = ((com.tencent.qqmini.sdk.launcher.model.SecondApiRightInfo)localObject1).apiName;
        ((com.tencent.mobileqq.mini.apkg.SecondApiRightInfo)localObject2).secondName = ((com.tencent.qqmini.sdk.launcher.model.SecondApiRightInfo)localObject1).secondName;
        ((com.tencent.mobileqq.mini.apkg.SecondApiRightInfo)localObject2).right = ((com.tencent.qqmini.sdk.launcher.model.SecondApiRightInfo)localObject1).right;
        localMiniAppInfo.secondApiRightInfoList.add(localObject2);
      }
    }
    if (paramMiniAppInfo.debugInfo != null)
    {
      localMiniAppInfo.debugInfo = new com.tencent.mobileqq.mini.apkg.DebugInfo();
      localMiniAppInfo.debugInfo.roomId = paramMiniAppInfo.debugInfo.roomId;
      localMiniAppInfo.debugInfo.wsUrl = paramMiniAppInfo.debugInfo.wsUrl;
    }
    localMiniAppInfo.requestDomainList = paramMiniAppInfo.requestDomainList;
    localMiniAppInfo.socketDomainList = paramMiniAppInfo.socketDomainList;
    localMiniAppInfo.uploadFileDomainList = paramMiniAppInfo.uploadFileDomainList;
    localMiniAppInfo.downloadFileDomainList = paramMiniAppInfo.downloadFileDomainList;
    localMiniAppInfo.businessDomainList = paramMiniAppInfo.businessDomainList;
    if (paramMiniAppInfo.udpIpList != null) {
      localMiniAppInfo.udpIpList.addAll(paramMiniAppInfo.udpIpList);
    }
    localMiniAppInfo.fileSize = paramMiniAppInfo.fileSize;
    localMiniAppInfo.developerDesc = paramMiniAppInfo.developerDesc;
    localMiniAppInfo.skipDomainCheck = paramMiniAppInfo.skipDomainCheck;
    localMiniAppInfo.usrFileSizeLimit = paramMiniAppInfo.usrFileSizeLimit;
    localMiniAppInfo.noNeedRealRecommend = paramMiniAppInfo.noNeedRealRecommend;
    localMiniAppInfo.versionUpdateTime = paramMiniAppInfo.versionUpdateTime;
    localMiniAppInfo.engineType = paramMiniAppInfo.engineType;
    if (paramMiniAppInfo.renderInfo != null)
    {
      localMiniAppInfo.renderInfo = new com.tencent.mobileqq.mini.apkg.RenderInfo();
      localMiniAppInfo.renderInfo.renderMode = paramMiniAppInfo.renderInfo.renderMode;
      if (paramMiniAppInfo.renderInfo.renderMaterialMap != null) {
        localMiniAppInfo.renderInfo.renderMaterialMap.putAll(paramMiniAppInfo.renderInfo.renderMaterialMap);
      }
    }
    if (paramMiniAppInfo.appMode != null)
    {
      localMiniAppInfo.appMode = new com.tencent.mobileqq.mini.apkg.AppMode();
      localMiniAppInfo.appMode.interMode = paramMiniAppInfo.appMode.interMode;
      localMiniAppInfo.appMode.authoritySilent = paramMiniAppInfo.appMode.authoritySilent;
      localMiniAppInfo.appMode.keepOffPullList = paramMiniAppInfo.appMode.keepOffPullList;
      localMiniAppInfo.appMode.closeTopRightCapsule = paramMiniAppInfo.appMode.closeTopRightCapsule;
      localMiniAppInfo.appMode.openNativeApi = paramMiniAppInfo.appMode.openNativeApi;
      localMiniAppInfo.appMode.hideAppSearch = paramMiniAppInfo.appMode.hideAppSearch;
      localMiniAppInfo.appMode.isAppStore = paramMiniAppInfo.appMode.isAppStore;
      localMiniAppInfo.appMode.isWangKa = paramMiniAppInfo.appMode.isWangKa;
      localMiniAppInfo.appMode.isInterLoading = paramMiniAppInfo.appMode.interLoading;
      localMiniAppInfo.appMode.isLimitedAccess = paramMiniAppInfo.appMode.isLimitedAccess;
      localMiniAppInfo.appMode.isPayForFriend = paramMiniAppInfo.appMode.isPayForFriend;
      localMiniAppInfo.appMode.useAppInfoWhenNavigate = paramMiniAppInfo.appMode.useAppInfoWhenNavigate;
      localMiniAppInfo.appMode.disableAddToMyApp = paramMiniAppInfo.appMode.disableAddToMyApp;
      localMiniAppInfo.appMode.disableAddToMyFavor = paramMiniAppInfo.appMode.disableAddToMyFavor;
      localMiniAppInfo.appMode.reloadWithFirstPageChange = paramMiniAppInfo.appMode.reloadWithFirstPageChange;
      localMiniAppInfo.appMode.unlimitedApiRight = paramMiniAppInfo.appMode.unlimitedApiRight;
      localMiniAppInfo.appMode.disableShareToAIO = paramMiniAppInfo.appMode.disableShareToAIO;
      localMiniAppInfo.appMode.disableShareToQZone = paramMiniAppInfo.appMode.disableShareToQZone;
      localMiniAppInfo.appMode.disableShareToWeChat = paramMiniAppInfo.appMode.disableShareToWeChat;
    }
    localMiniAppInfo.shareId = paramMiniAppInfo.shareId;
    localMiniAppInfo.via = paramMiniAppInfo.via;
    localMiniAppInfo.gameCopyrightInfo = paramMiniAppInfo.gameCopyrightInfo;
    localMiniAppInfo.gamePublicationNumber = paramMiniAppInfo.gamePublicationNumber;
    localMiniAppInfo.gamePublicationCompany = paramMiniAppInfo.gamePublicationCompany;
    localMiniAppInfo.gameApprovalNumber = paramMiniAppInfo.gameApprovalNumber;
    localMiniAppInfo.gameOperatingCompany = paramMiniAppInfo.gameOperatingCompany;
    return localMiniAppInfo;
  }
  
  public static com.tencent.qqmini.sdk.launcher.model.ExtConfigInfo convert(com.tencent.mobileqq.mini.apkg.ExtConfigInfo paramExtConfigInfo)
  {
    if (paramExtConfigInfo == null) {
      return null;
    }
    com.tencent.qqmini.sdk.launcher.model.ExtConfigInfo localExtConfigInfo = new com.tencent.qqmini.sdk.launcher.model.ExtConfigInfo();
    localExtConfigInfo.configKey = paramExtConfigInfo.configKey;
    localExtConfigInfo.configVersion = paramExtConfigInfo.configVersion;
    Object localObject1;
    Object localObject2;
    if (paramExtConfigInfo.userAuthScopes != null)
    {
      localExtConfigInfo.userAuthScopes = new ArrayList();
      localObject1 = paramExtConfigInfo.userAuthScopes.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mobileqq.mini.apkg.UserAuthScope)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          com.tencent.qqmini.sdk.launcher.model.UserAuthScope localUserAuthScope = new com.tencent.qqmini.sdk.launcher.model.UserAuthScope();
          localExtConfigInfo.userAuthScopes.add(localUserAuthScope);
          localUserAuthScope.scope = ((com.tencent.mobileqq.mini.apkg.UserAuthScope)localObject2).scope;
          localUserAuthScope.authType = ((com.tencent.mobileqq.mini.apkg.UserAuthScope)localObject2).authType;
          localUserAuthScope.desc = ((com.tencent.mobileqq.mini.apkg.UserAuthScope)localObject2).desc;
          localUserAuthScope.settingPageTitle = ((com.tencent.mobileqq.mini.apkg.UserAuthScope)localObject2).settingPageTitle;
        }
      }
    }
    if (paramExtConfigInfo.apiScopeEntries != null)
    {
      localExtConfigInfo.apiScopeEntries = new ArrayList();
      paramExtConfigInfo = paramExtConfigInfo.apiScopeEntries.iterator();
      while (paramExtConfigInfo.hasNext())
      {
        localObject1 = (com.tencent.mobileqq.mini.apkg.ApiScopeEntry)paramExtConfigInfo.next();
        if (localObject1 != null)
        {
          localObject2 = new com.tencent.qqmini.sdk.launcher.model.ApiScopeEntry();
          localExtConfigInfo.apiScopeEntries.add(localObject2);
          ((com.tencent.qqmini.sdk.launcher.model.ApiScopeEntry)localObject2).scope = ((com.tencent.mobileqq.mini.apkg.ApiScopeEntry)localObject1).scope;
          ((com.tencent.qqmini.sdk.launcher.model.ApiScopeEntry)localObject2).eventName = ((com.tencent.mobileqq.mini.apkg.ApiScopeEntry)localObject1).eventName;
          ((com.tencent.qqmini.sdk.launcher.model.ApiScopeEntry)localObject2).apiName = ((com.tencent.mobileqq.mini.apkg.ApiScopeEntry)localObject1).apiName;
        }
      }
    }
    return localExtConfigInfo;
  }
  
  public static com.tencent.qqmini.sdk.launcher.model.MiniAppInfo convert(MiniAppConfig paramMiniAppConfig)
  {
    if ((paramMiniAppConfig != null) && (paramMiniAppConfig.config != null))
    {
      com.tencent.qqmini.sdk.launcher.model.MiniAppInfo localMiniAppInfo = convert(paramMiniAppConfig.config);
      if (localMiniAppInfo != null)
      {
        localMiniAppInfo.baseLibInfo = convertBaselibInfo(paramMiniAppConfig.baseLibInfo);
        localMiniAppInfo.forceReroad = paramMiniAppConfig.forceReroad;
        if (paramMiniAppConfig.launchParam != null)
        {
          localMiniAppInfo.launchParam.scene = paramMiniAppConfig.launchParam.scene;
          localMiniAppInfo.launchParam.isFakeAppInfo = paramMiniAppConfig.isFromShowInfo;
          localMiniAppInfo.launchParam.miniAppId = paramMiniAppConfig.launchParam.miniAppId;
          localMiniAppInfo.launchParam.extraKey = paramMiniAppConfig.launchParam.extraKey;
          localMiniAppInfo.launchParam.entryPath = paramMiniAppConfig.launchParam.entryPath;
          localMiniAppInfo.launchParam.extendData = paramMiniAppConfig.launchParam.extendData;
          localMiniAppInfo.launchParam.navigateExtData = paramMiniAppConfig.launchParam.navigateExtData;
          localMiniAppInfo.launchParam.fromMiniAppId = paramMiniAppConfig.launchParam.fromMiniAppId;
          localMiniAppInfo.launchParam.fakeUrl = paramMiniAppConfig.launchParam.fakeUrl;
          localMiniAppInfo.launchParam.timestamp = paramMiniAppConfig.launchParam.timestamp;
          localMiniAppInfo.launchParam.launchClickTimeMillis = paramMiniAppConfig.launchParam.launchClickTimeMillis;
          localMiniAppInfo.launchParam.shareTicket = paramMiniAppConfig.launchParam.shareTicket;
          localMiniAppInfo.launchParam.envVersion = paramMiniAppConfig.launchParam.envVersion;
          localMiniAppInfo.launchParam.reportData = paramMiniAppConfig.launchParam.reportData;
          localMiniAppInfo.launchParam.entryModel = convertEntryModel(paramMiniAppConfig.launchParam.entryModel);
          localMiniAppInfo.launchParam.fromBackToMiniApp = paramMiniAppConfig.launchParam.fromBackToMiniApp;
          localMiniAppInfo.launchParam.fromEnvVersion = paramMiniAppConfig.launchParam.fromEnvVersion;
          localMiniAppInfo.launchParam.fromMiniAppInfo = convert(paramMiniAppConfig.launchParam.fromMiniAppInfo);
          localMiniAppInfo.launchParam.tempState = paramMiniAppConfig.launchParam.tempState;
          localMiniAppInfo.launchParam.privateExtraData = paramMiniAppConfig.launchParam.privateExtraData;
        }
        if (paramMiniAppConfig.isFromShowInfo)
        {
          localMiniAppInfo.link = paramMiniAppConfig.link;
          localMiniAppInfo.linkType = paramMiniAppConfig.linkType;
          localMiniAppInfo.firstPath = paramMiniAppConfig.entryPath;
        }
      }
      return localMiniAppInfo;
    }
    return null;
  }
  
  public static com.tencent.qqmini.sdk.launcher.model.MiniAppInfo convert(com.tencent.mobileqq.mini.apkg.MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {
      return null;
    }
    com.tencent.qqmini.sdk.launcher.model.MiniAppInfo localMiniAppInfo = new com.tencent.qqmini.sdk.launcher.model.MiniAppInfo();
    localMiniAppInfo.appId = paramMiniAppInfo.appId;
    localMiniAppInfo.name = paramMiniAppInfo.name;
    localMiniAppInfo.iconUrl = paramMiniAppInfo.iconUrl;
    localMiniAppInfo.downloadUrl = paramMiniAppInfo.downloadUrl;
    localMiniAppInfo.topType = paramMiniAppInfo.topType;
    localMiniAppInfo.version = paramMiniAppInfo.version;
    localMiniAppInfo.versionId = paramMiniAppInfo.versionId;
    localMiniAppInfo.desc = paramMiniAppInfo.desc;
    localMiniAppInfo.verType = paramMiniAppInfo.verType;
    localMiniAppInfo.timestamp = paramMiniAppInfo.timestamp;
    localMiniAppInfo.baselibMiniVersion = paramMiniAppInfo.baselibMiniVersion;
    Iterator localIterator;
    Object localObject1;
    Object localObject2;
    if (paramMiniAppInfo.subpkgs != null)
    {
      localMiniAppInfo.subpkgs = new ArrayList();
      localIterator = paramMiniAppInfo.subpkgs.iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (com.tencent.mobileqq.mini.apkg.SubPkgInfo)localIterator.next();
        localObject2 = new com.tencent.qqmini.sdk.launcher.model.SubPkgInfo();
        ((com.tencent.qqmini.sdk.launcher.model.SubPkgInfo)localObject2).subPkgName = ((com.tencent.mobileqq.mini.apkg.SubPkgInfo)localObject1).subPkgName;
        ((com.tencent.qqmini.sdk.launcher.model.SubPkgInfo)localObject2).downloadUrl = ((com.tencent.mobileqq.mini.apkg.SubPkgInfo)localObject1).downloadUrl;
        ((com.tencent.qqmini.sdk.launcher.model.SubPkgInfo)localObject2).independent = ((com.tencent.mobileqq.mini.apkg.SubPkgInfo)localObject1).independent;
        ((com.tencent.qqmini.sdk.launcher.model.SubPkgInfo)localObject2).fileSize = ((com.tencent.mobileqq.mini.apkg.SubPkgInfo)localObject1).fileSize;
        localMiniAppInfo.subpkgs.add(localObject2);
      }
    }
    if (paramMiniAppInfo.firstPage != null)
    {
      localMiniAppInfo.firstPage = new com.tencent.qqmini.sdk.launcher.model.FirstPageInfo();
      localMiniAppInfo.firstPage.pagePath = paramMiniAppInfo.firstPage.pagePath;
      localMiniAppInfo.firstPage.subPkgName = paramMiniAppInfo.firstPage.subPkgName;
    }
    localMiniAppInfo.appType = paramMiniAppInfo.getReportType();
    localMiniAppInfo.engineType = paramMiniAppInfo.engineType;
    localMiniAppInfo.setReportType(paramMiniAppInfo.getReportType());
    localMiniAppInfo.whiteList = paramMiniAppInfo.whiteList;
    localMiniAppInfo.blackList = paramMiniAppInfo.blackList;
    if (paramMiniAppInfo.secondApiRightInfoList != null)
    {
      localMiniAppInfo.secondApiRightInfoList = new ArrayList();
      localIterator = paramMiniAppInfo.secondApiRightInfoList.iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (com.tencent.mobileqq.mini.apkg.SecondApiRightInfo)localIterator.next();
        localObject2 = new com.tencent.qqmini.sdk.launcher.model.SecondApiRightInfo();
        ((com.tencent.qqmini.sdk.launcher.model.SecondApiRightInfo)localObject2).apiName = ((com.tencent.mobileqq.mini.apkg.SecondApiRightInfo)localObject1).apiName;
        ((com.tencent.qqmini.sdk.launcher.model.SecondApiRightInfo)localObject2).secondName = ((com.tencent.mobileqq.mini.apkg.SecondApiRightInfo)localObject1).secondName;
        ((com.tencent.qqmini.sdk.launcher.model.SecondApiRightInfo)localObject2).right = ((com.tencent.mobileqq.mini.apkg.SecondApiRightInfo)localObject1).right;
        localMiniAppInfo.secondApiRightInfoList.add(localObject2);
      }
    }
    if (paramMiniAppInfo.debugInfo != null)
    {
      localMiniAppInfo.debugInfo = new com.tencent.qqmini.sdk.launcher.model.DebugInfo();
      localMiniAppInfo.debugInfo.roomId = paramMiniAppInfo.debugInfo.roomId;
      localMiniAppInfo.debugInfo.wsUrl = paramMiniAppInfo.debugInfo.wsUrl;
    }
    localMiniAppInfo.requestDomainList = paramMiniAppInfo.requestDomainList;
    localMiniAppInfo.socketDomainList = paramMiniAppInfo.socketDomainList;
    localMiniAppInfo.uploadFileDomainList = paramMiniAppInfo.uploadFileDomainList;
    localMiniAppInfo.downloadFileDomainList = paramMiniAppInfo.downloadFileDomainList;
    localMiniAppInfo.businessDomainList = paramMiniAppInfo.businessDomainList;
    localMiniAppInfo.udpIpList = paramMiniAppInfo.udpIpList;
    localMiniAppInfo.fileSize = paramMiniAppInfo.fileSize;
    localMiniAppInfo.developerDesc = paramMiniAppInfo.developerDesc;
    localMiniAppInfo.extraData = paramMiniAppInfo.extraData;
    localMiniAppInfo.recommend = paramMiniAppInfo.recommend;
    localMiniAppInfo.isSupportOffline = paramMiniAppInfo.isSupportOffline;
    localMiniAppInfo.openId = paramMiniAppInfo.openId;
    localMiniAppInfo.tinyId = paramMiniAppInfo.tinyId;
    localMiniAppInfo.reportData = paramMiniAppInfo.reportData;
    if (paramMiniAppInfo.appMode != null)
    {
      localMiniAppInfo.appMode = new com.tencent.qqmini.sdk.launcher.model.AppMode();
      localMiniAppInfo.appMode.interMode = paramMiniAppInfo.appMode.interMode;
      localMiniAppInfo.appMode.authoritySilent = paramMiniAppInfo.appMode.authoritySilent;
      localMiniAppInfo.appMode.keepOffPullList = paramMiniAppInfo.appMode.keepOffPullList;
      localMiniAppInfo.appMode.closeTopRightCapsule = paramMiniAppInfo.appMode.closeTopRightCapsule;
      localMiniAppInfo.appMode.openNativeApi = paramMiniAppInfo.appMode.openNativeApi;
      localMiniAppInfo.appMode.hideAppSearch = paramMiniAppInfo.appMode.hideAppSearch;
      localMiniAppInfo.appMode.isAppStore = paramMiniAppInfo.appMode.isAppStore;
      localMiniAppInfo.appMode.isWangKa = paramMiniAppInfo.appMode.isWangKa;
      localMiniAppInfo.appMode.interLoading = paramMiniAppInfo.appMode.isInterLoading;
      localMiniAppInfo.appMode.isLimitedAccess = paramMiniAppInfo.appMode.isLimitedAccess;
      localMiniAppInfo.appMode.isPayForFriend = paramMiniAppInfo.appMode.isPayForFriend;
      localMiniAppInfo.appMode.useAppInfoWhenNavigate = paramMiniAppInfo.appMode.useAppInfoWhenNavigate;
      localMiniAppInfo.appMode.disableAddToMyApp = paramMiniAppInfo.appMode.disableAddToMyApp;
      localMiniAppInfo.appMode.disableAddToMyFavor = paramMiniAppInfo.appMode.disableAddToMyFavor;
      localMiniAppInfo.appMode.reloadWithFirstPageChange = paramMiniAppInfo.appMode.reloadWithFirstPageChange;
      localMiniAppInfo.appMode.unlimitedApiRight = paramMiniAppInfo.appMode.unlimitedApiRight;
      localMiniAppInfo.appMode.disableShareToAIO = paramMiniAppInfo.appMode.disableShareToAIO;
      localMiniAppInfo.appMode.disableShareToQZone = paramMiniAppInfo.appMode.disableShareToQZone;
      localMiniAppInfo.appMode.disableShareToWeChat = paramMiniAppInfo.appMode.disableShareToWeChat;
    }
    localMiniAppInfo.skipDomainCheck = paramMiniAppInfo.skipDomainCheck;
    localMiniAppInfo.position = paramMiniAppInfo.position;
    localMiniAppInfo.isSupportBlueBar = paramMiniAppInfo.isSupportBlueBar;
    localMiniAppInfo.recommendAppIconUrl = paramMiniAppInfo.recommendAppIconUrl;
    localMiniAppInfo.extendData = paramMiniAppInfo.extendData;
    localMiniAppInfo.clearAuths = paramMiniAppInfo.clearAuths;
    localMiniAppInfo.prepayId = paramMiniAppInfo.prepayId;
    localMiniAppInfo.commonExt = paramMiniAppInfo.commonExt;
    if (paramMiniAppInfo.extConfigInfoList != null)
    {
      localMiniAppInfo.extConfigInfoList = new ArrayList();
      localMiniAppInfo.extConfigInfoList = new ArrayList();
      localIterator = paramMiniAppInfo.extConfigInfoList.iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (com.tencent.mobileqq.mini.apkg.ExtConfigInfo)localIterator.next();
        localMiniAppInfo.extConfigInfoList.add(convert((com.tencent.mobileqq.mini.apkg.ExtConfigInfo)localObject1));
      }
    }
    localMiniAppInfo.appStoreAnimPicUrl = paramMiniAppInfo.appStoreAnimPicUrl;
    localMiniAppInfo.motionPics = paramMiniAppInfo.motionPics;
    localMiniAppInfo.usrFileSizeLimit = paramMiniAppInfo.usrFileSizeLimit;
    if (paramMiniAppInfo.preCacheList != null)
    {
      localMiniAppInfo.preCacheList = new ArrayList();
      localIterator = paramMiniAppInfo.preCacheList.iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (com.tencent.mobileqq.mini.apkg.PreCacheInfo)localIterator.next();
        localMiniAppInfo.preCacheList.add(new com.tencent.qqmini.sdk.launcher.model.PreCacheInfo(((com.tencent.mobileqq.mini.apkg.PreCacheInfo)localObject1).getDataUrl, ((com.tencent.mobileqq.mini.apkg.PreCacheInfo)localObject1).preCacheKey, ((com.tencent.mobileqq.mini.apkg.PreCacheInfo)localObject1).expireTime, ((com.tencent.mobileqq.mini.apkg.PreCacheInfo)localObject1).cacheType, ((com.tencent.mobileqq.mini.apkg.PreCacheInfo)localObject1).useProxy));
      }
    }
    if (paramMiniAppInfo.resourcePreCacheInfo != null)
    {
      localMiniAppInfo.resourcePreCacheInfo = new ArrayList();
      localIterator = paramMiniAppInfo.resourcePreCacheInfo.iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (ResourcePreCacheInfo)localIterator.next();
        localMiniAppInfo.resourcePreCacheInfo.add(new ResourcePreCacheInfo(((ResourcePreCacheInfo)localObject1).getDataUrl));
      }
    }
    localMiniAppInfo.versionUpdateTime = paramMiniAppInfo.versionUpdateTime;
    localMiniAppInfo.noNeedRealRecommend = paramMiniAppInfo.noNeedRealRecommend;
    if (paramMiniAppInfo.miniGamePluginInfo != null) {
      localMiniAppInfo.miniGamePluginInfo = new com.tencent.qqmini.sdk.launcher.model.MiniGamePluginInfo(paramMiniAppInfo.miniGamePluginInfo.name, paramMiniAppInfo.miniGamePluginInfo.id, paramMiniAppInfo.miniGamePluginInfo.version, paramMiniAppInfo.miniGamePluginInfo.url, paramMiniAppInfo.miniGamePluginInfo.packageSize);
    }
    if (paramMiniAppInfo.renderInfo != null)
    {
      localMiniAppInfo.renderInfo = new com.tencent.qqmini.sdk.launcher.model.RenderInfo();
      localMiniAppInfo.renderInfo.renderMode = paramMiniAppInfo.renderInfo.renderMode;
      if (paramMiniAppInfo.renderInfo.renderMaterialMap != null) {
        localMiniAppInfo.renderInfo.renderMaterialMap.putAll(paramMiniAppInfo.renderInfo.renderMaterialMap);
      }
    }
    localMiniAppInfo.qualifications = paramMiniAppInfo.qualifications;
    localMiniAppInfo.gameCopyrightInfo = paramMiniAppInfo.gameCopyrightInfo;
    localMiniAppInfo.gamePublicationNumber = paramMiniAppInfo.gamePublicationCompany;
    localMiniAppInfo.gamePublicationCompany = paramMiniAppInfo.gamePublicationCompany;
    localMiniAppInfo.gameApprovalNumber = paramMiniAppInfo.gameApprovalNumber;
    localMiniAppInfo.gameOperatingCompany = paramMiniAppInfo.gameOperatingCompany;
    localMiniAppInfo.shareId = paramMiniAppInfo.shareId;
    localMiniAppInfo.via = paramMiniAppInfo.via;
    localMiniAppInfo.amsAdInfo = paramMiniAppInfo.amsAdInfo;
    localMiniAppInfo.enableLoadingAd = paramMiniAppInfo.enableLoadingAd;
    localMiniAppInfo.friendMessageQuery = paramMiniAppInfo.friendMessageQuery;
    localMiniAppInfo.apngUrl = paramMiniAppInfo.apngUrl;
    localMiniAppInfo.ideScene = paramMiniAppInfo.ide_scene;
    localMiniAppInfo.ideExtraAppid = paramMiniAppInfo.ide_extraAppid;
    localMiniAppInfo.ideExtraData = paramMiniAppInfo.ide_extraData;
    localMiniAppInfo.tianshuAdId = paramMiniAppInfo.tianshuAdId;
    localMiniAppInfo.deviceOrientation = paramMiniAppInfo.deviceOrientation;
    localMiniAppInfo.showStatusBar = paramMiniAppInfo.showStatusBar;
    return localMiniAppInfo;
  }
  
  public static com.tencent.qqmini.sdk.launcher.model.BaseLibInfo convertBaselibInfo(com.tencent.mobileqq.mini.sdk.BaseLibInfo paramBaseLibInfo)
  {
    if (paramBaseLibInfo == null) {
      return null;
    }
    com.tencent.qqmini.sdk.launcher.model.BaseLibInfo localBaseLibInfo = new com.tencent.qqmini.sdk.launcher.model.BaseLibInfo();
    localBaseLibInfo.baseLibUrl = paramBaseLibInfo.baseLibUrl;
    localBaseLibInfo.baseLibKey = paramBaseLibInfo.baseLibKey;
    localBaseLibInfo.baseLibVersion = paramBaseLibInfo.baseLibVersion;
    localBaseLibInfo.baseLibDesc = paramBaseLibInfo.baseLibDesc;
    localBaseLibInfo.baseLibType = paramBaseLibInfo.baseLibType;
    return localBaseLibInfo;
  }
  
  public static com.tencent.qqmini.sdk.launcher.model.EntryModel convertEntryModel(com.tencent.mobileqq.mini.sdk.EntryModel paramEntryModel)
  {
    if (paramEntryModel == null) {
      return null;
    }
    com.tencent.qqmini.sdk.launcher.model.EntryModel localEntryModel = new com.tencent.qqmini.sdk.launcher.model.EntryModel(paramEntryModel.type, paramEntryModel.uin, paramEntryModel.name, paramEntryModel.isAdmin, paramEntryModel.dwGroupClassExt, paramEntryModel.reportData);
    localEntryModel.reportData = paramEntryModel.reportData;
    return localEntryModel;
  }
  
  private static boolean enableFlutter()
  {
    QzoneConfig localQzoneConfig = QzoneConfig.getInstance();
    boolean bool = false;
    if (localQzoneConfig.getConfig("qqminiapp", "mini_flutter_enable", 0) == 1) {
      bool = true;
    }
    return bool;
  }
  
  public static void initSDK(Context paramContext)
  {
    MiniSDK.init(paramContext);
    sSdkInited = true;
  }
  
  public static void notifyPeriodicCacheUpdate(Context paramContext, MiniAppConfig paramMiniAppConfig)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("notifyPeriodicCacheUpdate, MiniAppInfo = ");
    localStringBuilder.append(paramMiniAppConfig);
    QLog.i("MiniSdkLauncher", 1, localStringBuilder.toString());
    MiniSDK.init(paramContext);
    MiniSDK.notifyPeriodicCacheUpdate(paramContext, convert(paramMiniAppConfig));
  }
  
  public static void onDexConfigUpdate(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDexConfigUpdate:");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("MiniSdkLauncher", 1, ((StringBuilder)localObject).toString());
      paramString = new JSONObject(paramString);
      localObject = paramString.optString("ver");
      String str = paramString.optString("minjs");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramString.putOpt("app_version", "8.7.0.5295");
      }
      MiniDynamicManager.g().updateDexConfig(paramString.toString());
      if (!TextUtils.isEmpty(str))
      {
        BaseLibManager.g().forceUpdateBaseLib(null);
        return;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("MiniSdkLauncher", 1, "", paramString);
    }
  }
  
  public static void preLaunchMiniApp(Context paramContext, MiniAppConfig paramMiniAppConfig)
  {
    if (paramMiniAppConfig != null) {
      if (paramMiniAppConfig.config == null) {
        return;
      }
    }
    for (;;)
    {
      try
      {
        i = MiniAppConfProcessor.a("mini_sdk_prelaunch_enable", 1);
        int j = 0;
        if (i != 1) {
          break label225;
        }
        i = 1;
        if (i == 0)
        {
          QLog.i("MiniSdkLauncher", 1, "preLaunchMiniApp disable");
          return;
        }
        if (!sSdkInited)
        {
          sSdkInited = true;
          initSDK(paramContext);
        }
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("preLaunchMiniApp ");
        ((StringBuilder)localObject).append(paramMiniAppConfig.config.appId);
        QLog.i("MiniSdkLauncher", 1, ((StringBuilder)localObject).toString());
        if ((paramMiniAppConfig.isEngineTypeMiniGame() ^ true))
        {
          localObject = new Bundle();
          ((Bundle)localObject).putString("mini_key_preload_type", "preload_app");
          ((Bundle)localObject).putParcelable("mini_appinfo", convert(paramMiniAppConfig));
          ((Bundle)localObject).putBoolean("sdk_mode", true);
          boolean bool = enableFlutter();
          if (bool)
          {
            i = j;
            if (!TextUtils.isEmpty(TissueEnvImpl.getNativeLibDir()))
            {
              i = j;
              if (TissueEnvImpl.verifyTissueEngine(TissueEnvImpl.getNativeLibDir())) {
                i = 1;
              }
            }
            if ((bool) && (i != 0)) {
              ((Bundle)localObject).putString("tissuenativelibdir", TissueEnvImpl.getNativeLibDir());
            }
          }
          MiniSDK.preloadMiniApp(paramContext, (Bundle)localObject);
          return;
        }
      }
      catch (Throwable paramContext)
      {
        QLog.e("MiniSdkLauncher", 1, "startMiniApp exception!", paramContext);
      }
      return;
      label225:
      int i = 0;
    }
  }
  
  public static void preLaunchMiniAppCheckinFromLeba()
  {
    for (;;)
    {
      try
      {
        if (QzoneConfig.getInstance().getConfig("qqminiapp", "mini_flutter_prelaunch_checkin_enable", 1) == 1)
        {
          bool = true;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("preLaunchMiniAppCheckinFromLeba ");
          localStringBuilder.append(sIsMiniAppCheckinPreLaunched);
          localStringBuilder.append(", ");
          localStringBuilder.append(bool);
          QLog.d("MiniSdkLauncher", 1, localStringBuilder.toString());
          if ((!sIsMiniAppCheckinPreLaunched) && (bool))
          {
            if (shouldForbidLowPerf()) {
              return;
            }
            ThreadManagerV2.executeOnSubThread(new MiniSdkLauncher.1());
            return;
          }
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        QLog.i("MiniSdkLauncher", 1, "preLaunchMiniAppCheckinFromLeba", localException);
        return;
      }
      boolean bool = false;
    }
  }
  
  /* Error */
  public static void preloadMiniApp(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 854	com/tencent/mobileqq/mini/launch/MiniSdkLauncher:sSdkInited	Z
    //   6: ifne +11 -> 17
    //   9: iconst_1
    //   10: putstatic 854	com/tencent/mobileqq/mini/launch/MiniSdkLauncher:sSdkInited	Z
    //   13: aload_0
    //   14: invokestatic 951	com/tencent/mobileqq/mini/launch/MiniSdkLauncher:initSDK	(Landroid/content/Context;)V
    //   17: iload_1
    //   18: ifeq +96 -> 114
    //   21: invokestatic 981	com/tencent/mobileqq/mini/launch/MiniSdkLauncher:enableFlutter	()Z
    //   24: istore_1
    //   25: iconst_0
    //   26: istore_3
    //   27: iload_3
    //   28: istore_2
    //   29: iload_1
    //   30: ifeq +27 -> 57
    //   33: iload_3
    //   34: istore_2
    //   35: invokestatic 986	com/tencent/mobileqq/mini/tissue/TissueEnvImpl:getNativeLibDir	()Ljava/lang/String;
    //   38: invokestatic 892	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   41: ifne +16 -> 57
    //   44: iload_3
    //   45: istore_2
    //   46: invokestatic 986	com/tencent/mobileqq/mini/tissue/TissueEnvImpl:getNativeLibDir	()Ljava/lang/String;
    //   49: invokestatic 990	com/tencent/mobileqq/mini/tissue/TissueEnvImpl:verifyTissueEngine	(Ljava/lang/String;)Z
    //   52: ifeq +5 -> 57
    //   55: iconst_1
    //   56: istore_2
    //   57: new 958	android/os/Bundle
    //   60: dup
    //   61: invokespecial 959	android/os/Bundle:<init>	()V
    //   64: astore 4
    //   66: aload 4
    //   68: ldc_w 961
    //   71: ldc_w 963
    //   74: invokevirtual 967	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   77: aload 4
    //   79: ldc_w 975
    //   82: iconst_1
    //   83: invokevirtual 979	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   86: iload_1
    //   87: ifeq +18 -> 105
    //   90: iload_2
    //   91: ifeq +14 -> 105
    //   94: aload 4
    //   96: ldc_w 992
    //   99: invokestatic 986	com/tencent/mobileqq/mini/tissue/TissueEnvImpl:getNativeLibDir	()Ljava/lang/String;
    //   102: invokevirtual 967	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   105: aload_0
    //   106: aload 4
    //   108: invokestatic 996	com/tencent/qqmini/sdk/MiniSDK:preloadMiniApp	(Landroid/content/Context;Landroid/os/Bundle;)V
    //   111: goto +47 -> 158
    //   114: new 958	android/os/Bundle
    //   117: dup
    //   118: invokespecial 959	android/os/Bundle:<init>	()V
    //   121: astore 4
    //   123: aload 4
    //   125: ldc_w 961
    //   128: ldc_w 1034
    //   131: invokevirtual 967	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   134: aload_0
    //   135: aload 4
    //   137: invokestatic 996	com/tencent/qqmini/sdk/MiniSDK:preloadMiniApp	(Landroid/content/Context;Landroid/os/Bundle;)V
    //   140: goto +18 -> 158
    //   143: astore_0
    //   144: goto +18 -> 162
    //   147: astore_0
    //   148: ldc 8
    //   150: iconst_1
    //   151: ldc_w 998
    //   154: aload_0
    //   155: invokestatic 938	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   158: ldc 2
    //   160: monitorexit
    //   161: return
    //   162: ldc 2
    //   164: monitorexit
    //   165: aload_0
    //   166: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	167	0	paramContext	Context
    //   0	167	1	paramBoolean	boolean
    //   28	63	2	i	int
    //   26	19	3	j	int
    //   64	72	4	localBundle	Bundle
    // Exception table:
    //   from	to	target	type
    //   3	17	143	finally
    //   21	25	143	finally
    //   35	44	143	finally
    //   46	55	143	finally
    //   57	86	143	finally
    //   94	105	143	finally
    //   105	111	143	finally
    //   114	140	143	finally
    //   148	158	143	finally
    //   3	17	147	java/lang/Throwable
    //   21	25	147	java/lang/Throwable
    //   35	44	147	java/lang/Throwable
    //   46	55	147	java/lang/Throwable
    //   57	86	147	java/lang/Throwable
    //   94	105	147	java/lang/Throwable
    //   105	111	147	java/lang/Throwable
    //   114	140	147	java/lang/Throwable
  }
  
  private static boolean shouldForbidLowPerf()
  {
    int i = DeviceInfoUtils.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("shouldForbidLowPerf ");
    localStringBuilder.append(i);
    QLog.d("MiniSdkLauncher", 1, localStringBuilder.toString());
    return i == 3;
  }
  
  public static void startMiniApp(Activity paramActivity, MiniAppConfig paramMiniAppConfig, Bundle paramBundle)
  {
    startMiniApp(paramActivity, paramMiniAppConfig, paramBundle, null);
  }
  
  public static void startMiniApp(Activity paramActivity, MiniAppConfig paramMiniAppConfig, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    if (paramMiniAppConfig != null)
    {
      if (paramMiniAppConfig.config == null) {
        return;
      }
      if (paramActivity != null) {}
      try
      {
        Object localObject = paramActivity.getApplicationContext();
        break label30;
        localObject = BaseApplicationImpl.getApplication();
        label30:
        if (!sSdkInited)
        {
          sSdkInited = true;
          initSDK((Context)localObject);
        }
        MiniSDK.startMiniApp(paramActivity, convert(paramMiniAppConfig), paramBundle, paramResultReceiver);
        return;
      }
      catch (Throwable paramActivity)
      {
        QLog.e("MiniSdkLauncher", 1, "startMiniApp exception!", paramActivity);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.launch.MiniSdkLauncher
 * JD-Core Version:    0.7.0.1
 */