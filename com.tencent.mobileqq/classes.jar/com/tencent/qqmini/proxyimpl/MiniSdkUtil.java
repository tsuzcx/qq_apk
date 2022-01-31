package com.tencent.qqmini.proxyimpl;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import aoom;
import bgod;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MiniSdkUtil
{
  private static final String TAG = "MiniSdkUtil";
  private static boolean hasMiniAppDecide;
  private static boolean hasMiniGameDecide;
  private static boolean lastMiniAppDecide;
  private static boolean lastMiniGameDecide;
  
  public static ApkgInfo convert(bgod parambgod, MiniAppConfig paramMiniAppConfig)
  {
    if ((parambgod == null) || (paramMiniAppConfig == null)) {
      return null;
    }
    return new ApkgInfo(parambgod.apkgFolderPath, paramMiniAppConfig);
  }
  
  public static com.tencent.mobileqq.mini.apkg.ExtConfigInfo convert(com.tencent.qqmini.sdk.launcher.model.ExtConfigInfo paramExtConfigInfo)
  {
    if (paramExtConfigInfo == null) {
      return null;
    }
    com.tencent.mobileqq.mini.apkg.ExtConfigInfo localExtConfigInfo = new com.tencent.mobileqq.mini.apkg.ExtConfigInfo();
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
        localObject2 = (com.tencent.qqmini.sdk.launcher.model.UserAuthScope)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          com.tencent.mobileqq.mini.apkg.UserAuthScope localUserAuthScope = new com.tencent.mobileqq.mini.apkg.UserAuthScope();
          localExtConfigInfo.userAuthScopes.add(localUserAuthScope);
          localUserAuthScope.scope = ((com.tencent.qqmini.sdk.launcher.model.UserAuthScope)localObject2).scope;
          localUserAuthScope.authType = ((com.tencent.qqmini.sdk.launcher.model.UserAuthScope)localObject2).authType;
          localUserAuthScope.desc = ((com.tencent.qqmini.sdk.launcher.model.UserAuthScope)localObject2).desc;
          localUserAuthScope.settingPageTitle = ((com.tencent.qqmini.sdk.launcher.model.UserAuthScope)localObject2).settingPageTitle;
        }
      }
    }
    if (paramExtConfigInfo.apiScopeEntries != null)
    {
      localExtConfigInfo.apiScopeEntries = new ArrayList();
      paramExtConfigInfo = paramExtConfigInfo.apiScopeEntries.iterator();
      while (paramExtConfigInfo.hasNext())
      {
        localObject1 = (com.tencent.qqmini.sdk.launcher.model.ApiScopeEntry)paramExtConfigInfo.next();
        if (localObject1 != null)
        {
          localObject2 = new com.tencent.mobileqq.mini.apkg.ApiScopeEntry();
          localExtConfigInfo.apiScopeEntries.add(localObject2);
          ((com.tencent.mobileqq.mini.apkg.ApiScopeEntry)localObject2).scope = ((com.tencent.qqmini.sdk.launcher.model.ApiScopeEntry)localObject1).scope;
          ((com.tencent.mobileqq.mini.apkg.ApiScopeEntry)localObject2).eventName = ((com.tencent.qqmini.sdk.launcher.model.ApiScopeEntry)localObject1).eventName;
          ((com.tencent.mobileqq.mini.apkg.ApiScopeEntry)localObject2).apiName = ((com.tencent.qqmini.sdk.launcher.model.ApiScopeEntry)localObject1).apiName;
        }
      }
    }
    return localExtConfigInfo;
  }
  
  public static com.tencent.mobileqq.mini.apkg.MiniAppInfo convert(com.tencent.qqmini.sdk.launcher.model.MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {
      return null;
    }
    com.tencent.mobileqq.mini.apkg.MiniAppInfo localMiniAppInfo = new com.tencent.mobileqq.mini.apkg.MiniAppInfo();
    localMiniAppInfo.topType = paramMiniAppInfo.topType;
    localMiniAppInfo.extraData = paramMiniAppInfo.extraData;
    localMiniAppInfo.recommend = paramMiniAppInfo.recommend;
    localMiniAppInfo.isSupportOffline = paramMiniAppInfo.isSupportOffline;
    localMiniAppInfo.openId = paramMiniAppInfo.openId;
    localMiniAppInfo.tinyId = paramMiniAppInfo.tinyId;
    localMiniAppInfo.position = paramMiniAppInfo.position;
    localMiniAppInfo.isSupportBlueBar = paramMiniAppInfo.isSupportBlueBar;
    localMiniAppInfo.recommendAppIconUrl = paramMiniAppInfo.recommendAppIconUrl;
    localMiniAppInfo.extendData = paramMiniAppInfo.extendData;
    localMiniAppInfo.clearAuths = paramMiniAppInfo.clearAuths;
    localMiniAppInfo.appStoreAnimPicUrl = paramMiniAppInfo.appStoreAnimPicUrl;
    localMiniAppInfo.setEngineType(paramMiniAppInfo.getEngineType());
    localMiniAppInfo.setReportType(paramMiniAppInfo.getReportType());
    if (paramMiniAppInfo.commonExt != null)
    {
      localMiniAppInfo.commonExt = new byte[paramMiniAppInfo.commonExt.length];
      System.arraycopy(paramMiniAppInfo.commonExt, 0, localMiniAppInfo.commonExt, 0, paramMiniAppInfo.commonExt.length);
    }
    Object localObject1;
    Object localObject2;
    if (paramMiniAppInfo.motionPics != null)
    {
      localMiniAppInfo.motionPics = new ArrayList();
      localObject1 = paramMiniAppInfo.motionPics.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localMiniAppInfo.motionPics.add(localObject2);
      }
    }
    if (paramMiniAppInfo.extConfigInfoList != null)
    {
      localMiniAppInfo.extConfigInfoList = new ArrayList();
      localObject1 = paramMiniAppInfo.extConfigInfoList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.qqmini.sdk.launcher.model.ExtConfigInfo)((Iterator)localObject1).next();
        localMiniAppInfo.extConfigInfoList.add(convert((com.tencent.qqmini.sdk.launcher.model.ExtConfigInfo)localObject2));
      }
    }
    if (paramMiniAppInfo.preCacheList != null)
    {
      localMiniAppInfo.preCacheList = new ArrayList();
      localObject1 = paramMiniAppInfo.preCacheList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.qqmini.sdk.launcher.model.PreCacheInfo)((Iterator)localObject1).next();
        localObject2 = new com.tencent.mobileqq.mini.apkg.PreCacheInfo(((com.tencent.qqmini.sdk.launcher.model.PreCacheInfo)localObject2).getDataUrl, ((com.tencent.qqmini.sdk.launcher.model.PreCacheInfo)localObject2).preCacheKey, ((com.tencent.qqmini.sdk.launcher.model.PreCacheInfo)localObject2).expireTime, 0, 0);
        localMiniAppInfo.preCacheList.add(localObject2);
      }
    }
    localMiniAppInfo.appId = paramMiniAppInfo.appId;
    localMiniAppInfo.name = paramMiniAppInfo.name;
    localMiniAppInfo.iconUrl = paramMiniAppInfo.iconUrl;
    localMiniAppInfo.downloadUrl = paramMiniAppInfo.downloadUrl;
    localMiniAppInfo.version = paramMiniAppInfo.version;
    localMiniAppInfo.versionId = paramMiniAppInfo.versionId;
    localMiniAppInfo.desc = paramMiniAppInfo.desc;
    localMiniAppInfo.verType = paramMiniAppInfo.verType;
    localMiniAppInfo.timestamp = paramMiniAppInfo.timestamp;
    localMiniAppInfo.baselibMiniVersion = paramMiniAppInfo.baselibMiniVersion;
    localMiniAppInfo.fileSize = paramMiniAppInfo.fileSize;
    localMiniAppInfo.developerDesc = paramMiniAppInfo.developerDesc;
    localMiniAppInfo.skipDomainCheck = paramMiniAppInfo.skipDomainCheck;
    localMiniAppInfo.usrFileSizeLimit = paramMiniAppInfo.usrFileSizeLimit;
    localMiniAppInfo.noNeedRealRecommend = paramMiniAppInfo.noNeedRealRecommend;
    localMiniAppInfo.versionUpdateTime = paramMiniAppInfo.versionUpdateTime;
    localMiniAppInfo.engineType = paramMiniAppInfo.engineType;
    localMiniAppInfo.shareId = paramMiniAppInfo.shareId;
    localMiniAppInfo.via = paramMiniAppInfo.via;
    if (paramMiniAppInfo.whiteList != null)
    {
      localMiniAppInfo.whiteList = new ArrayList();
      localMiniAppInfo.whiteList.addAll(paramMiniAppInfo.whiteList);
    }
    if (paramMiniAppInfo.blackList != null)
    {
      localMiniAppInfo.blackList = new ArrayList();
      localMiniAppInfo.blackList.addAll(paramMiniAppInfo.blackList);
    }
    if (paramMiniAppInfo.requestDomainList != null)
    {
      localMiniAppInfo.requestDomainList = new ArrayList();
      localMiniAppInfo.requestDomainList.addAll(paramMiniAppInfo.requestDomainList);
    }
    if (paramMiniAppInfo.socketDomainList != null)
    {
      localMiniAppInfo.socketDomainList = new ArrayList();
      localMiniAppInfo.socketDomainList.addAll(paramMiniAppInfo.socketDomainList);
    }
    if (paramMiniAppInfo.uploadFileDomainList != null)
    {
      localMiniAppInfo.uploadFileDomainList = new ArrayList();
      localMiniAppInfo.uploadFileDomainList.addAll(paramMiniAppInfo.uploadFileDomainList);
    }
    if (paramMiniAppInfo.downloadFileDomainList != null)
    {
      localMiniAppInfo.downloadFileDomainList = new ArrayList();
      localMiniAppInfo.downloadFileDomainList.addAll(paramMiniAppInfo.downloadFileDomainList);
    }
    if (paramMiniAppInfo.businessDomainList != null)
    {
      localMiniAppInfo.businessDomainList = new ArrayList();
      localMiniAppInfo.businessDomainList.addAll(paramMiniAppInfo.businessDomainList);
    }
    if (paramMiniAppInfo.udpIpList != null) {
      localMiniAppInfo.udpIpList.addAll(paramMiniAppInfo.udpIpList);
    }
    if (paramMiniAppInfo.debugInfo != null)
    {
      localMiniAppInfo.debugInfo = new com.tencent.mobileqq.mini.apkg.DebugInfo();
      localMiniAppInfo.debugInfo.roomId = paramMiniAppInfo.debugInfo.roomId;
      localMiniAppInfo.debugInfo.wsUrl = paramMiniAppInfo.debugInfo.wsUrl;
    }
    if (paramMiniAppInfo.subpkgs != null)
    {
      localMiniAppInfo.subpkgs = new ArrayList();
      paramMiniAppInfo = paramMiniAppInfo.subpkgs.iterator();
      while (paramMiniAppInfo.hasNext())
      {
        localObject1 = (com.tencent.qqmini.sdk.launcher.model.SubPkgInfo)paramMiniAppInfo.next();
        localObject2 = new com.tencent.mobileqq.mini.apkg.SubPkgInfo();
        ((com.tencent.mobileqq.mini.apkg.SubPkgInfo)localObject2).downloadUrl = ((com.tencent.qqmini.sdk.launcher.model.SubPkgInfo)localObject1).downloadUrl;
        ((com.tencent.mobileqq.mini.apkg.SubPkgInfo)localObject2).fileSize = ((com.tencent.qqmini.sdk.launcher.model.SubPkgInfo)localObject1).fileSize;
        ((com.tencent.mobileqq.mini.apkg.SubPkgInfo)localObject2).independent = ((com.tencent.qqmini.sdk.launcher.model.SubPkgInfo)localObject1).independent;
        ((com.tencent.mobileqq.mini.apkg.SubPkgInfo)localObject2).subPkgName = ((com.tencent.qqmini.sdk.launcher.model.SubPkgInfo)localObject1).subPkgName;
        localMiniAppInfo.subpkgs.add(localObject2);
      }
    }
    return localMiniAppInfo;
  }
  
  public static com.tencent.mobileqq.mini.sdk.EntryModel convert(com.tencent.qqmini.sdk.launcher.model.EntryModel paramEntryModel)
  {
    if (paramEntryModel == null) {
      return null;
    }
    com.tencent.mobileqq.mini.sdk.EntryModel localEntryModel = new com.tencent.mobileqq.mini.sdk.EntryModel(paramEntryModel.type, paramEntryModel.uin, paramEntryModel.name, paramEntryModel.isAdmin);
    localEntryModel.reportData = paramEntryModel.reportData;
    return localEntryModel;
  }
  
  public static com.tencent.mobileqq.mini.sdk.LaunchParam convert(com.tencent.qqmini.sdk.launcher.model.LaunchParam paramLaunchParam)
  {
    if (paramLaunchParam == null) {
      return null;
    }
    com.tencent.mobileqq.mini.sdk.LaunchParam localLaunchParam = new com.tencent.mobileqq.mini.sdk.LaunchParam();
    localLaunchParam.scene = paramLaunchParam.scene;
    localLaunchParam.miniAppId = paramLaunchParam.miniAppId;
    localLaunchParam.extraKey = paramLaunchParam.extraKey;
    localLaunchParam.entryPath = paramLaunchParam.entryPath;
    localLaunchParam.navigateExtData = paramLaunchParam.navigateExtData;
    localLaunchParam.fromMiniAppId = paramLaunchParam.fromMiniAppId;
    localLaunchParam.launchClickTimeMillis = paramLaunchParam.launchClickTimeMillis;
    localLaunchParam.tempState = paramLaunchParam.tempState;
    localLaunchParam.timestamp = paramLaunchParam.timestamp;
    localLaunchParam.shareTicket = paramLaunchParam.shareTicket;
    localLaunchParam.envVersion = paramLaunchParam.envVersion;
    localLaunchParam.reportData = paramLaunchParam.reportData;
    localLaunchParam.extendData = paramLaunchParam.extendData;
    localLaunchParam.entryModel = convert(paramLaunchParam.entryModel);
    localLaunchParam.fromBackToMiniApp = paramLaunchParam.fromBackToMiniApp;
    return localLaunchParam;
  }
  
  public static com.tencent.qqmini.sdk.launcher.model.EntryModel convert(com.tencent.mobileqq.mini.sdk.EntryModel paramEntryModel)
  {
    if (paramEntryModel == null) {
      return null;
    }
    com.tencent.qqmini.sdk.launcher.model.EntryModel localEntryModel = new com.tencent.qqmini.sdk.launcher.model.EntryModel(paramEntryModel.type, paramEntryModel.uin, paramEntryModel.name, paramEntryModel.isAdmin);
    localEntryModel.reportData = paramEntryModel.reportData;
    return localEntryModel;
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
  
  public static com.tencent.qqmini.sdk.launcher.model.LaunchParam convert(com.tencent.mobileqq.mini.sdk.LaunchParam paramLaunchParam)
  {
    if (paramLaunchParam == null) {
      return null;
    }
    com.tencent.qqmini.sdk.launcher.model.LaunchParam localLaunchParam = new com.tencent.qqmini.sdk.launcher.model.LaunchParam();
    localLaunchParam.scene = paramLaunchParam.scene;
    localLaunchParam.miniAppId = paramLaunchParam.miniAppId;
    localLaunchParam.extraKey = paramLaunchParam.extraKey;
    localLaunchParam.entryPath = paramLaunchParam.entryPath;
    localLaunchParam.navigateExtData = paramLaunchParam.navigateExtData;
    localLaunchParam.fromMiniAppId = paramLaunchParam.fromMiniAppId;
    localLaunchParam.launchClickTimeMillis = paramLaunchParam.launchClickTimeMillis;
    localLaunchParam.tempState = paramLaunchParam.tempState;
    localLaunchParam.timestamp = paramLaunchParam.timestamp;
    localLaunchParam.shareTicket = paramLaunchParam.shareTicket;
    localLaunchParam.envVersion = paramLaunchParam.envVersion;
    localLaunchParam.reportData = paramLaunchParam.reportData;
    localLaunchParam.extendData = paramLaunchParam.extendData;
    localLaunchParam.entryModel = convert(paramLaunchParam.entryModel);
    localLaunchParam.fromBackToMiniApp = paramLaunchParam.fromBackToMiniApp;
    return localLaunchParam;
  }
  
  public static com.tencent.qqmini.sdk.launcher.model.MiniAppInfo convert(com.tencent.mobileqq.mini.apkg.MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {
      return null;
    }
    com.tencent.qqmini.sdk.launcher.model.MiniAppInfo localMiniAppInfo = new com.tencent.qqmini.sdk.launcher.model.MiniAppInfo();
    localMiniAppInfo.topType = paramMiniAppInfo.topType;
    localMiniAppInfo.extraData = paramMiniAppInfo.extraData;
    localMiniAppInfo.recommend = paramMiniAppInfo.recommend;
    localMiniAppInfo.isSupportOffline = paramMiniAppInfo.isSupportOffline;
    localMiniAppInfo.openId = paramMiniAppInfo.openId;
    localMiniAppInfo.tinyId = paramMiniAppInfo.tinyId;
    localMiniAppInfo.position = paramMiniAppInfo.position;
    localMiniAppInfo.isSupportBlueBar = paramMiniAppInfo.isSupportBlueBar;
    localMiniAppInfo.recommendAppIconUrl = paramMiniAppInfo.recommendAppIconUrl;
    localMiniAppInfo.extendData = paramMiniAppInfo.extendData;
    localMiniAppInfo.clearAuths = paramMiniAppInfo.clearAuths;
    localMiniAppInfo.appStoreAnimPicUrl = paramMiniAppInfo.appStoreAnimPicUrl;
    localMiniAppInfo.setEngineType(paramMiniAppInfo.getEngineType());
    localMiniAppInfo.setReportType(paramMiniAppInfo.getReportType());
    if (paramMiniAppInfo.commonExt != null)
    {
      localMiniAppInfo.commonExt = new byte[paramMiniAppInfo.commonExt.length];
      System.arraycopy(paramMiniAppInfo.commonExt, 0, localMiniAppInfo.commonExt, 0, paramMiniAppInfo.commonExt.length);
    }
    Object localObject1;
    Object localObject2;
    if (paramMiniAppInfo.motionPics != null)
    {
      localMiniAppInfo.motionPics = new ArrayList();
      localObject1 = paramMiniAppInfo.motionPics.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localMiniAppInfo.motionPics.add(localObject2);
      }
    }
    if (paramMiniAppInfo.extConfigInfoList != null)
    {
      localMiniAppInfo.extConfigInfoList = new ArrayList();
      localObject1 = paramMiniAppInfo.extConfigInfoList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mobileqq.mini.apkg.ExtConfigInfo)((Iterator)localObject1).next();
        localMiniAppInfo.extConfigInfoList.add(convert((com.tencent.mobileqq.mini.apkg.ExtConfigInfo)localObject2));
      }
    }
    if (paramMiniAppInfo.preCacheList != null)
    {
      localMiniAppInfo.preCacheList = new ArrayList();
      localObject1 = paramMiniAppInfo.preCacheList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mobileqq.mini.apkg.PreCacheInfo)((Iterator)localObject1).next();
        localObject2 = new com.tencent.qqmini.sdk.launcher.model.PreCacheInfo(((com.tencent.mobileqq.mini.apkg.PreCacheInfo)localObject2).getDataUrl, ((com.tencent.mobileqq.mini.apkg.PreCacheInfo)localObject2).preCacheKey, ((com.tencent.mobileqq.mini.apkg.PreCacheInfo)localObject2).expireTime);
        localMiniAppInfo.preCacheList.add(localObject2);
      }
    }
    localMiniAppInfo.appId = paramMiniAppInfo.appId;
    localMiniAppInfo.name = paramMiniAppInfo.name;
    localMiniAppInfo.iconUrl = paramMiniAppInfo.iconUrl;
    localMiniAppInfo.downloadUrl = paramMiniAppInfo.downloadUrl;
    localMiniAppInfo.version = paramMiniAppInfo.version;
    localMiniAppInfo.versionId = paramMiniAppInfo.versionId;
    localMiniAppInfo.desc = paramMiniAppInfo.desc;
    localMiniAppInfo.verType = paramMiniAppInfo.verType;
    localMiniAppInfo.timestamp = paramMiniAppInfo.timestamp;
    localMiniAppInfo.baselibMiniVersion = paramMiniAppInfo.baselibMiniVersion;
    localMiniAppInfo.fileSize = paramMiniAppInfo.fileSize;
    localMiniAppInfo.developerDesc = paramMiniAppInfo.developerDesc;
    localMiniAppInfo.skipDomainCheck = paramMiniAppInfo.skipDomainCheck;
    localMiniAppInfo.usrFileSizeLimit = paramMiniAppInfo.usrFileSizeLimit;
    localMiniAppInfo.noNeedRealRecommend = paramMiniAppInfo.noNeedRealRecommend;
    localMiniAppInfo.versionUpdateTime = paramMiniAppInfo.versionUpdateTime;
    localMiniAppInfo.engineType = paramMiniAppInfo.engineType;
    localMiniAppInfo.shareId = paramMiniAppInfo.shareId;
    localMiniAppInfo.via = paramMiniAppInfo.via;
    if (paramMiniAppInfo.whiteList != null)
    {
      localMiniAppInfo.whiteList = new ArrayList();
      localMiniAppInfo.whiteList.addAll(paramMiniAppInfo.whiteList);
    }
    if (paramMiniAppInfo.blackList != null)
    {
      localMiniAppInfo.blackList = new ArrayList();
      localMiniAppInfo.blackList.addAll(paramMiniAppInfo.blackList);
    }
    if (paramMiniAppInfo.requestDomainList != null)
    {
      localMiniAppInfo.requestDomainList = new ArrayList();
      localMiniAppInfo.requestDomainList.addAll(paramMiniAppInfo.requestDomainList);
    }
    if (paramMiniAppInfo.socketDomainList != null)
    {
      localMiniAppInfo.socketDomainList = new ArrayList();
      localMiniAppInfo.socketDomainList.addAll(paramMiniAppInfo.socketDomainList);
    }
    if (paramMiniAppInfo.uploadFileDomainList != null)
    {
      localMiniAppInfo.uploadFileDomainList = new ArrayList();
      localMiniAppInfo.uploadFileDomainList.addAll(paramMiniAppInfo.uploadFileDomainList);
    }
    if (paramMiniAppInfo.downloadFileDomainList != null)
    {
      localMiniAppInfo.downloadFileDomainList = new ArrayList();
      localMiniAppInfo.downloadFileDomainList.addAll(paramMiniAppInfo.downloadFileDomainList);
    }
    if (paramMiniAppInfo.businessDomainList != null)
    {
      localMiniAppInfo.businessDomainList = new ArrayList();
      localMiniAppInfo.businessDomainList.addAll(paramMiniAppInfo.businessDomainList);
    }
    if (paramMiniAppInfo.udpIpList != null)
    {
      localMiniAppInfo.udpIpList = new ArrayList();
      localMiniAppInfo.udpIpList.addAll(paramMiniAppInfo.udpIpList);
    }
    if (paramMiniAppInfo.debugInfo != null)
    {
      localMiniAppInfo.debugInfo = new com.tencent.qqmini.sdk.launcher.model.DebugInfo();
      localMiniAppInfo.debugInfo.roomId = paramMiniAppInfo.debugInfo.roomId;
      localMiniAppInfo.debugInfo.wsUrl = paramMiniAppInfo.debugInfo.wsUrl;
    }
    if (paramMiniAppInfo.subpkgs != null)
    {
      localMiniAppInfo.subpkgs = new ArrayList();
      paramMiniAppInfo = paramMiniAppInfo.subpkgs.iterator();
      while (paramMiniAppInfo.hasNext())
      {
        localObject1 = (com.tencent.mobileqq.mini.apkg.SubPkgInfo)paramMiniAppInfo.next();
        localObject2 = new com.tencent.qqmini.sdk.launcher.model.SubPkgInfo();
        ((com.tencent.qqmini.sdk.launcher.model.SubPkgInfo)localObject2).downloadUrl = ((com.tencent.mobileqq.mini.apkg.SubPkgInfo)localObject1).downloadUrl;
        ((com.tencent.qqmini.sdk.launcher.model.SubPkgInfo)localObject2).fileSize = ((com.tencent.mobileqq.mini.apkg.SubPkgInfo)localObject1).fileSize;
        ((com.tencent.qqmini.sdk.launcher.model.SubPkgInfo)localObject2).independent = ((com.tencent.mobileqq.mini.apkg.SubPkgInfo)localObject1).independent;
        ((com.tencent.qqmini.sdk.launcher.model.SubPkgInfo)localObject2).subPkgName = ((com.tencent.mobileqq.mini.apkg.SubPkgInfo)localObject1).subPkgName;
        localMiniAppInfo.subpkgs.add(localObject2);
      }
    }
    return localMiniAppInfo;
  }
  
  public static ArrayList<com.tencent.mobileqq.mini.apkg.ExtConfigInfo> convert(ArrayList<com.tencent.qqmini.sdk.launcher.model.ExtConfigInfo> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localArrayList.add(convert((com.tencent.qqmini.sdk.launcher.model.ExtConfigInfo)paramArrayList.next()));
    }
    return localArrayList;
  }
  
  public static com.tencent.mobileqq.mini.sdk.EntryModel convertFromSdk(com.tencent.qqmini.sdk.launcher.model.EntryModel paramEntryModel)
  {
    if (paramEntryModel == null) {
      return null;
    }
    com.tencent.mobileqq.mini.sdk.EntryModel localEntryModel = new com.tencent.mobileqq.mini.sdk.EntryModel(paramEntryModel.type, paramEntryModel.uin, paramEntryModel.name, paramEntryModel.isAdmin);
    localEntryModel.reportData = paramEntryModel.reportData;
    return localEntryModel;
  }
  
  public static MiniAppConfig convertSDK2QQConfig(com.tencent.qqmini.sdk.launcher.model.MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {
      return null;
    }
    MiniAppConfig localMiniAppConfig = new MiniAppConfig(convert(paramMiniAppInfo));
    localMiniAppConfig.entryPath = paramMiniAppInfo.launchParam.entryPath;
    localMiniAppConfig.linkType = paramMiniAppInfo.linkType;
    localMiniAppConfig.link = paramMiniAppInfo.link;
    localMiniAppConfig.isFromShowInfo = false;
    localMiniAppConfig.forceReroad = paramMiniAppInfo.forceReroad;
    localMiniAppConfig.launchParam = convert(paramMiniAppInfo.launchParam);
    if (paramMiniAppInfo.baseLibInfo != null) {
      localMiniAppConfig.baseLibInfo = new com.tencent.mobileqq.mini.sdk.BaseLibInfo(paramMiniAppInfo.baseLibInfo.baseLibUrl, paramMiniAppInfo.baseLibInfo.baseLibKey, paramMiniAppInfo.baseLibInfo.baseLibVersion, paramMiniAppInfo.baseLibInfo.baseLibDesc, paramMiniAppInfo.baseLibInfo.baseLibType);
    }
    return localMiniAppConfig;
  }
  
  private static boolean isMiniProcessLive(Context paramContext)
  {
    try
    {
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (paramContext.hasNext())
      {
        String str = ((ActivityManager.RunningAppProcessInfo)paramContext.next()).processName;
        if ((!"com.tencent.mobileqq:mini3".equals(str)) && (!"com.tencent.mobileqq:mini4".equals(str)))
        {
          boolean bool = "com.tencent.mobileqq:mini5".equals(str);
          if (!bool) {
            break;
          }
        }
        else
        {
          return true;
        }
      }
    }
    catch (Exception paramContext)
    {
      QLog.e("MiniSdkUtil", 1, "getProcessInfos fail ", paramContext);
    }
    return false;
  }
  
  private static boolean needJumpToMiniApp()
  {
    if (hasMiniAppDecide)
    {
      QLog.e("MiniSdkUtil", 1, "needJumpToMiniSDK hasMiniAppDecide lastMiniAppDecide = " + lastMiniAppDecide);
      return lastMiniAppDecide;
    }
    hasMiniAppDecide = true;
    for (;;)
    {
      try
      {
        if (QzoneConfig.getInstance().getConfig("qqminiapp", "newnativesdkenable", 0) > 0)
        {
          bool = true;
          lastMiniAppDecide = bool;
          QLog.e("MiniSdkUtil", 1, "needJumpToMiniApp getConfig isOn = " + bool);
          return bool;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("MiniSdkUtil", 1, "needJumpToMiniApp ", localThrowable);
        lastMiniAppDecide = false;
        return false;
      }
      boolean bool = false;
    }
  }
  
  private static boolean needJumpToMiniGame()
  {
    if (hasMiniGameDecide)
    {
      QLog.e("MiniSdkUtil", 1, "needJumpToMiniSDK hasMiniGameDecide lastMiniGameDecide = " + lastMiniGameDecide);
      return lastMiniGameDecide;
    }
    hasMiniGameDecide = true;
    for (;;)
    {
      try
      {
        if (isMiniProcessLive(BaseApplicationImpl.getContext()))
        {
          int i = BaseApplicationImpl.getContext().getSharedPreferences("sdk_conf", 4).getInt("usersdk", 1);
          if (i != 1) {
            break label178;
          }
          bool = true;
          lastMiniGameDecide = bool;
          QLog.e("MiniSdkUtil", 1, "needJumpToMiniSDK isMiniProcessLive useSDK = " + i);
          return lastMiniAppDecide;
        }
        if (aoom.a("newsdkenable", 0) > 0)
        {
          bool = true;
          lastMiniGameDecide = bool;
          QLog.e("MiniSdkUtil", 1, "needJumpToMiniGame getConfig isOn = " + bool);
          return bool;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("MiniSdkUtil", 1, "needJumpToMiniGame ", localThrowable);
        lastMiniGameDecide = false;
        return false;
      }
      boolean bool = false;
      continue;
      label178:
      bool = false;
    }
  }
  
  public static boolean needJumpToMiniSDK(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        paramBoolean = needJumpToMiniApp();
        return paramBoolean;
      }
      finally {}
      paramBoolean = needJumpToMiniGame();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniSdkUtil
 * JD-Core Version:    0.7.0.1
 */