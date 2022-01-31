package com.tencent.qqmini.proxyimpl;

import bejy;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class MiniSdkUtil
{
  private static final String TAG = "MiniSdkUtil";
  private static String sCurrentAppid;
  private static boolean sIsLoad;
  
  public static ApkgInfo convert(bejy parambejy, MiniAppConfig paramMiniAppConfig)
  {
    if ((parambejy == null) || (paramMiniAppConfig == null)) {
      return null;
    }
    return new ApkgInfo(parambejy.jdField_a_of_type_JavaLangString, paramMiniAppConfig);
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
        com.tencent.mobileqq.mini.apkg.UserAuthScope localUserAuthScope = new com.tencent.mobileqq.mini.apkg.UserAuthScope();
        localExtConfigInfo.userAuthScopes.add(localUserAuthScope);
        localUserAuthScope.scope = ((com.tencent.qqmini.sdk.launcher.model.UserAuthScope)localObject2).scope;
        localUserAuthScope.authType = ((com.tencent.qqmini.sdk.launcher.model.UserAuthScope)localObject2).authType;
        localUserAuthScope.desc = ((com.tencent.qqmini.sdk.launcher.model.UserAuthScope)localObject2).desc;
        localUserAuthScope.settingPageTitle = ((com.tencent.qqmini.sdk.launcher.model.UserAuthScope)localObject2).settingPageTitle;
      }
    }
    if (paramExtConfigInfo.apiScopeEntries != null)
    {
      localExtConfigInfo.apiScopeEntries = new ArrayList();
      paramExtConfigInfo = paramExtConfigInfo.apiScopeEntries.iterator();
      while (paramExtConfigInfo.hasNext())
      {
        localObject1 = (com.tencent.qqmini.sdk.launcher.model.ApiScopeEntry)paramExtConfigInfo.next();
        localObject2 = new com.tencent.mobileqq.mini.apkg.ApiScopeEntry();
        localExtConfigInfo.apiScopeEntries.add(localObject2);
        ((com.tencent.mobileqq.mini.apkg.ApiScopeEntry)localObject2).scope = ((com.tencent.qqmini.sdk.launcher.model.ApiScopeEntry)localObject1).scope;
        ((com.tencent.mobileqq.mini.apkg.ApiScopeEntry)localObject2).eventName = ((com.tencent.qqmini.sdk.launcher.model.ApiScopeEntry)localObject1).eventName;
        ((com.tencent.mobileqq.mini.apkg.ApiScopeEntry)localObject2).apiName = ((com.tencent.qqmini.sdk.launcher.model.ApiScopeEntry)localObject1).apiName;
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
        localObject2 = new com.tencent.mobileqq.mini.apkg.PreCacheInfo(((com.tencent.qqmini.sdk.launcher.model.PreCacheInfo)localObject2).jdField_a_of_type_JavaLangString, ((com.tencent.qqmini.sdk.launcher.model.PreCacheInfo)localObject2).jdField_b_of_type_JavaLangString, ((com.tencent.qqmini.sdk.launcher.model.PreCacheInfo)localObject2).jdField_a_of_type_Long);
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
      localMiniAppInfo.debugInfo.roomId = paramMiniAppInfo.debugInfo.jdField_a_of_type_JavaLangString;
      localMiniAppInfo.debugInfo.wsUrl = paramMiniAppInfo.debugInfo.jdField_b_of_type_JavaLangString;
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
    Object localObject;
    if (paramEntryModel == null) {
      localObject = null;
    }
    com.tencent.mobileqq.mini.sdk.EntryModel localEntryModel;
    do
    {
      return localObject;
      localEntryModel = new com.tencent.mobileqq.mini.sdk.EntryModel(paramEntryModel.jdField_a_of_type_Int, paramEntryModel.jdField_a_of_type_Long, paramEntryModel.jdField_a_of_type_JavaLangString, paramEntryModel.jdField_a_of_type_Boolean);
      localObject = localEntryModel;
    } while (paramEntryModel.jdField_a_of_type_JavaUtilMap == null);
    if (localEntryModel.reportData == null) {
      localEntryModel.reportData = new HashMap();
    }
    Iterator localIterator = paramEntryModel.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    for (;;)
    {
      localObject = localEntryModel;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (String)localIterator.next();
      localEntryModel.reportData.put(localObject, paramEntryModel.jdField_a_of_type_JavaUtilMap.get(localObject));
    }
  }
  
  public static com.tencent.mobileqq.mini.sdk.LaunchParam convert(com.tencent.qqmini.sdk.launcher.model.LaunchParam paramLaunchParam)
  {
    if (paramLaunchParam == null) {
      return null;
    }
    com.tencent.mobileqq.mini.sdk.LaunchParam localLaunchParam = new com.tencent.mobileqq.mini.sdk.LaunchParam();
    localLaunchParam.scene = paramLaunchParam.jdField_a_of_type_Int;
    localLaunchParam.miniAppId = paramLaunchParam.jdField_a_of_type_JavaLangString;
    localLaunchParam.extraKey = paramLaunchParam.jdField_b_of_type_JavaLangString;
    localLaunchParam.entryPath = paramLaunchParam.jdField_c_of_type_JavaLangString;
    localLaunchParam.navigateExtData = paramLaunchParam.e;
    localLaunchParam.fromMiniAppId = paramLaunchParam.f;
    localLaunchParam.launchClickTimeMillis = paramLaunchParam.jdField_b_of_type_Long;
    localLaunchParam.tempState = paramLaunchParam.jdField_c_of_type_Int;
    localLaunchParam.timestamp = paramLaunchParam.jdField_a_of_type_Long;
    localLaunchParam.shareTicket = paramLaunchParam.h;
    localLaunchParam.envVersion = paramLaunchParam.i;
    if (paramLaunchParam.jdField_a_of_type_JavaUtilMap != null)
    {
      if (localLaunchParam.reportData == null) {
        localLaunchParam.reportData = new HashMap();
      }
      Iterator localIterator = paramLaunchParam.jdField_a_of_type_JavaUtilMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localLaunchParam.reportData.put(str, paramLaunchParam.jdField_a_of_type_JavaUtilMap.get(str));
      }
    }
    localLaunchParam.extendData = paramLaunchParam.d;
    localLaunchParam.entryModel = convert(paramLaunchParam.jdField_a_of_type_ComTencentQqminiSdkLauncherModelEntryModel);
    localLaunchParam.fromBackToMiniApp = paramLaunchParam.jdField_b_of_type_Int;
    return localLaunchParam;
  }
  
  public static com.tencent.qqmini.sdk.launcher.model.EntryModel convert(com.tencent.mobileqq.mini.sdk.EntryModel paramEntryModel)
  {
    Object localObject;
    if (paramEntryModel == null) {
      localObject = null;
    }
    com.tencent.qqmini.sdk.launcher.model.EntryModel localEntryModel;
    do
    {
      return localObject;
      localEntryModel = new com.tencent.qqmini.sdk.launcher.model.EntryModel(paramEntryModel.type, paramEntryModel.uin, paramEntryModel.name, paramEntryModel.isAdmin);
      localObject = localEntryModel;
    } while (paramEntryModel.reportData == null);
    if (localEntryModel.jdField_a_of_type_JavaUtilMap == null) {
      localEntryModel.jdField_a_of_type_JavaUtilMap = new HashMap();
    }
    Iterator localIterator = paramEntryModel.reportData.keySet().iterator();
    for (;;)
    {
      localObject = localEntryModel;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (String)localIterator.next();
      localEntryModel.jdField_a_of_type_JavaUtilMap.put(localObject, paramEntryModel.reportData.get(localObject));
    }
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
        com.tencent.qqmini.sdk.launcher.model.UserAuthScope localUserAuthScope = new com.tencent.qqmini.sdk.launcher.model.UserAuthScope();
        localExtConfigInfo.userAuthScopes.add(localUserAuthScope);
        localUserAuthScope.scope = ((com.tencent.mobileqq.mini.apkg.UserAuthScope)localObject2).scope;
        localUserAuthScope.authType = ((com.tencent.mobileqq.mini.apkg.UserAuthScope)localObject2).authType;
        localUserAuthScope.desc = ((com.tencent.mobileqq.mini.apkg.UserAuthScope)localObject2).desc;
        localUserAuthScope.settingPageTitle = ((com.tencent.mobileqq.mini.apkg.UserAuthScope)localObject2).settingPageTitle;
      }
    }
    if (paramExtConfigInfo.apiScopeEntries != null)
    {
      localExtConfigInfo.apiScopeEntries = new ArrayList();
      paramExtConfigInfo = paramExtConfigInfo.apiScopeEntries.iterator();
      while (paramExtConfigInfo.hasNext())
      {
        localObject1 = (com.tencent.mobileqq.mini.apkg.ApiScopeEntry)paramExtConfigInfo.next();
        localObject2 = new com.tencent.qqmini.sdk.launcher.model.ApiScopeEntry();
        localExtConfigInfo.apiScopeEntries.add(localObject2);
        ((com.tencent.qqmini.sdk.launcher.model.ApiScopeEntry)localObject2).scope = ((com.tencent.mobileqq.mini.apkg.ApiScopeEntry)localObject1).scope;
        ((com.tencent.qqmini.sdk.launcher.model.ApiScopeEntry)localObject2).eventName = ((com.tencent.mobileqq.mini.apkg.ApiScopeEntry)localObject1).eventName;
        ((com.tencent.qqmini.sdk.launcher.model.ApiScopeEntry)localObject2).apiName = ((com.tencent.mobileqq.mini.apkg.ApiScopeEntry)localObject1).apiName;
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
    localLaunchParam.jdField_a_of_type_Int = paramLaunchParam.scene;
    localLaunchParam.jdField_a_of_type_JavaLangString = paramLaunchParam.miniAppId;
    localLaunchParam.jdField_b_of_type_JavaLangString = paramLaunchParam.extraKey;
    localLaunchParam.jdField_c_of_type_JavaLangString = paramLaunchParam.entryPath;
    localLaunchParam.e = paramLaunchParam.navigateExtData;
    localLaunchParam.f = paramLaunchParam.fromMiniAppId;
    localLaunchParam.jdField_b_of_type_Long = paramLaunchParam.launchClickTimeMillis;
    localLaunchParam.jdField_c_of_type_Int = paramLaunchParam.tempState;
    localLaunchParam.jdField_a_of_type_Long = paramLaunchParam.timestamp;
    localLaunchParam.h = paramLaunchParam.shareTicket;
    localLaunchParam.i = paramLaunchParam.envVersion;
    if (paramLaunchParam.reportData != null)
    {
      if (localLaunchParam.jdField_a_of_type_JavaUtilMap == null) {
        localLaunchParam.jdField_a_of_type_JavaUtilMap = new HashMap();
      }
      Iterator localIterator = paramLaunchParam.reportData.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localLaunchParam.jdField_a_of_type_JavaUtilMap.put(str, paramLaunchParam.reportData.get(str));
      }
    }
    localLaunchParam.d = paramLaunchParam.extendData;
    localLaunchParam.jdField_a_of_type_ComTencentQqminiSdkLauncherModelEntryModel = convert(paramLaunchParam.entryModel);
    localLaunchParam.jdField_b_of_type_Int = paramLaunchParam.fromBackToMiniApp;
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
      localMiniAppInfo.debugInfo.jdField_a_of_type_JavaLangString = paramMiniAppInfo.debugInfo.roomId;
      localMiniAppInfo.debugInfo.jdField_b_of_type_JavaLangString = paramMiniAppInfo.debugInfo.wsUrl;
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
    Object localObject;
    if (paramEntryModel == null) {
      localObject = null;
    }
    com.tencent.mobileqq.mini.sdk.EntryModel localEntryModel;
    do
    {
      return localObject;
      localEntryModel = new com.tencent.mobileqq.mini.sdk.EntryModel(paramEntryModel.jdField_a_of_type_Int, paramEntryModel.jdField_a_of_type_Long, paramEntryModel.jdField_a_of_type_JavaLangString, paramEntryModel.jdField_a_of_type_Boolean);
      localObject = localEntryModel;
    } while (paramEntryModel.jdField_a_of_type_JavaUtilMap == null);
    if (localEntryModel.reportData == null) {
      localEntryModel.reportData = new HashMap();
    }
    Iterator localIterator = paramEntryModel.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    for (;;)
    {
      localObject = localEntryModel;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (String)localIterator.next();
      localEntryModel.reportData.put(localObject, paramEntryModel.jdField_a_of_type_JavaUtilMap.get(localObject));
    }
  }
  
  public static MiniAppConfig convertSDK2QQConfig(com.tencent.qqmini.sdk.launcher.model.MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {
      return null;
    }
    MiniAppConfig localMiniAppConfig = new MiniAppConfig(convert(paramMiniAppInfo));
    localMiniAppConfig.entryPath = paramMiniAppInfo.launchParam.jdField_c_of_type_JavaLangString;
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
  
  public static boolean needJumpToMiniSDK(String paramString)
  {
    boolean bool = true;
    int i;
    label218:
    do
    {
      for (;;)
      {
        try
        {
          Object localObject = QzoneConfig.getInstance().getConfig("qqtriton", "newsdkgrayappid", "1108197111|1108196450|1109298876|1109149265|1108149561|1109836759|363|1108996570|1109609286").split("\\|");
          ArrayList localArrayList = new ArrayList();
          localArrayList.addAll(Arrays.asList((Object[])localObject));
          localArrayList.add("1108327904");
          localArrayList.add("1105821066");
          localArrayList.add("1108617468");
          localArrayList.add("1108802591");
          localArrayList.add("1108136456");
          localObject = localArrayList.iterator();
          i = 0;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          if (!paramString.equals((String)((Iterator)localObject).next())) {
            break label218;
          }
          i = 1;
        }
        catch (Throwable paramString)
        {
          QLog.e("MiniSdkUtil", 1, "sneedJumpToMiniSDK", paramString);
          return false;
        }
        if (sCurrentAppid != null)
        {
          if (sCurrentAppid.equals(paramString)) {
            return bool;
          }
          return false;
        }
        i = QzoneConfig.getInstance().getConfig("qqtriton", "newsdksamplerate", 100);
        if (new Random(System.currentTimeMillis()).nextInt(100) < i)
        {
          bool = true;
          sIsLoad = bool;
          if (sIsLoad) {
            sCurrentAppid = paramString;
          }
          bool = sIsLoad;
          return bool;
        }
        bool = false;
      }
    } while (i != 0);
    bool = false;
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniSdkUtil
 * JD-Core Version:    0.7.0.1
 */