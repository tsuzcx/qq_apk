package com.tencent.qqmini.proxyimpl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class MiniSdkUtil
{
  private static boolean a = false;
  private static boolean b = false;
  private static boolean c = false;
  private static boolean d = false;
  
  public static com.tencent.mobileqq.mini.apkg.ExtConfigInfo a(com.tencent.qqmini.sdk.launcher.model.ExtConfigInfo paramExtConfigInfo)
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
  
  public static MiniAppConfig a(com.tencent.qqmini.sdk.launcher.model.MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {
      return null;
    }
    MiniAppConfig localMiniAppConfig = new MiniAppConfig(a(paramMiniAppInfo));
    localMiniAppConfig.entryPath = paramMiniAppInfo.launchParam.entryPath;
    localMiniAppConfig.linkType = paramMiniAppInfo.linkType;
    localMiniAppConfig.link = paramMiniAppInfo.link;
    localMiniAppConfig.isFromShowInfo = false;
    localMiniAppConfig.forceReroad = paramMiniAppInfo.forceReroad;
    localMiniAppConfig.launchParam = a(paramMiniAppInfo.launchParam);
    if (paramMiniAppInfo.baseLibInfo != null) {
      localMiniAppConfig.baseLibInfo = new com.tencent.mobileqq.mini.sdk.BaseLibInfo(paramMiniAppInfo.baseLibInfo.baseLibUrl, paramMiniAppInfo.baseLibInfo.baseLibKey, paramMiniAppInfo.baseLibInfo.baseLibVersion, paramMiniAppInfo.baseLibInfo.baseLibDesc, paramMiniAppInfo.baseLibInfo.baseLibType);
    }
    return localMiniAppConfig;
  }
  
  public static com.tencent.mobileqq.mini.apkg.MiniAppInfo a(com.tencent.qqmini.sdk.launcher.model.MiniAppInfo paramMiniAppInfo)
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
        localMiniAppInfo.extConfigInfoList.add(a((com.tencent.qqmini.sdk.launcher.model.ExtConfigInfo)localObject2));
      }
    }
    if (paramMiniAppInfo.preCacheList != null)
    {
      localMiniAppInfo.preCacheList = new ArrayList();
      localObject1 = paramMiniAppInfo.preCacheList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.qqmini.sdk.launcher.model.PreCacheInfo)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          localObject2 = new com.tencent.mobileqq.mini.apkg.PreCacheInfo(((com.tencent.qqmini.sdk.launcher.model.PreCacheInfo)localObject2).getDataUrl, ((com.tencent.qqmini.sdk.launcher.model.PreCacheInfo)localObject2).preCacheKey, ((com.tencent.qqmini.sdk.launcher.model.PreCacheInfo)localObject2).expireTime, 0, 0);
          localMiniAppInfo.preCacheList.add(localObject2);
        }
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
  
  public static com.tencent.mobileqq.mini.sdk.EntryModel a(com.tencent.qqmini.sdk.launcher.model.EntryModel paramEntryModel)
  {
    if (paramEntryModel == null) {
      return null;
    }
    com.tencent.mobileqq.mini.sdk.EntryModel localEntryModel = new com.tencent.mobileqq.mini.sdk.EntryModel(paramEntryModel.type, paramEntryModel.uin, paramEntryModel.name, paramEntryModel.isAdmin);
    localEntryModel.reportData = paramEntryModel.reportData;
    localEntryModel.dwGroupClassExt = paramEntryModel.dwGroupClassExt;
    return localEntryModel;
  }
  
  public static com.tencent.mobileqq.mini.sdk.LaunchParam a(com.tencent.qqmini.sdk.launcher.model.LaunchParam paramLaunchParam)
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
    localLaunchParam.entryModel = a(paramLaunchParam.entryModel);
    localLaunchParam.fromBackToMiniApp = paramLaunchParam.fromBackToMiniApp;
    return localLaunchParam;
  }
  
  public static com.tencent.qqmini.sdk.launcher.model.ExtConfigInfo a(com.tencent.mobileqq.mini.apkg.ExtConfigInfo paramExtConfigInfo)
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
  
  public static com.tencent.qqmini.sdk.launcher.model.MiniAppInfo a(com.tencent.mobileqq.mini.apkg.MiniAppInfo paramMiniAppInfo)
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
        localMiniAppInfo.extConfigInfoList.add(a((com.tencent.mobileqq.mini.apkg.ExtConfigInfo)localObject2));
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
  
  public static ArrayList<com.tencent.mobileqq.mini.apkg.ExtConfigInfo> a(ArrayList<com.tencent.qqmini.sdk.launcher.model.ExtConfigInfo> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localArrayList.add(a((com.tencent.qqmini.sdk.launcher.model.ExtConfigInfo)paramArrayList.next()));
    }
    return localArrayList;
  }
  
  public static void a(boolean paramBoolean)
  {
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("setMiniAppSdkDowngrade ");
      ((StringBuilder)localObject1).append(paramBoolean);
      QLog.e("MiniSdkUtil", 1, ((StringBuilder)localObject1).toString());
      StringBuilder localStringBuilder;
      if (paramBoolean)
      {
        localObject1 = BaseApplicationImpl.getApplication();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(BaseApplicationImpl.getApplication().getRuntime().getAccount());
        localStringBuilder.append("_user_sdk_miniapp_");
        ((BaseApplicationImpl)localObject1).getSharedPreferences(localStringBuilder.toString(), 4).edit().putInt("miniapp_sdk__downgrade", 1).commit();
      }
      else
      {
        localObject1 = BaseApplicationImpl.getApplication();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(BaseApplicationImpl.getApplication().getRuntime().getAccount());
        localStringBuilder.append("_user_sdk_miniapp_");
        ((BaseApplicationImpl)localObject1).getSharedPreferences(localStringBuilder.toString(), 4).edit().putInt("miniapp_sdk__downgrade", 0).commit();
      }
      return;
    }
    finally {}
  }
  
  public static boolean a()
  {
    try
    {
      BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(BaseApplicationImpl.getApplication().getRuntime().getAccount());
      localStringBuilder.append("_user_sdk_miniapp_");
      int i = localBaseApplicationImpl.getSharedPreferences(localStringBuilder.toString(), 4).getInt("miniapp_sdk__downgrade", -1);
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean a(boolean paramBoolean)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniSdkUtil
 * JD-Core Version:    0.7.0.1
 */