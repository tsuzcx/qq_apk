package com.tencent.mobileqq.mini.launch;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.tissue.TissueEnvImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.MiniSDK;
import com.tencent.qqmini.sdk.core.tissue.TissueEnv;
import com.tencent.qqmini.sdk.core.tissue.TissueGlobal;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MiniSdkLauncher
{
  private static volatile boolean sSdkInited;
  
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
    }
    localMiniAppInfo.shareId = paramMiniAppInfo.shareId;
    localMiniAppInfo.via = paramMiniAppInfo.via;
    return localMiniAppInfo;
  }
  
  public static com.tencent.qqmini.sdk.launcher.model.MiniAppInfo convert(MiniAppConfig paramMiniAppConfig)
  {
    Object localObject;
    if ((paramMiniAppConfig == null) || (paramMiniAppConfig.config == null)) {
      localObject = null;
    }
    com.tencent.qqmini.sdk.launcher.model.MiniAppInfo localMiniAppInfo;
    do
    {
      do
      {
        return localObject;
        localMiniAppInfo = convert(paramMiniAppConfig.config);
        localMiniAppInfo.baseLibInfo = convertBaselibInfo(paramMiniAppConfig.baseLibInfo);
        localMiniAppInfo.forceReroad = paramMiniAppConfig.forceReroad;
        localObject = localMiniAppInfo;
      } while (localMiniAppInfo == null);
      localObject = localMiniAppInfo;
    } while (paramMiniAppConfig.launchParam == null);
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
    return localMiniAppInfo;
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
    localMiniAppInfo.appType = paramMiniAppInfo.getReportType();
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
    localMiniAppInfo.skipDomainCheck = paramMiniAppInfo.skipDomainCheck;
    localMiniAppInfo.usrFileSizeLimit = paramMiniAppInfo.usrFileSizeLimit;
    localMiniAppInfo.noNeedRealRecommend = paramMiniAppInfo.noNeedRealRecommend;
    localMiniAppInfo.versionUpdateTime = paramMiniAppInfo.versionUpdateTime;
    localMiniAppInfo.engineType = paramMiniAppInfo.engineType;
    if (paramMiniAppInfo.renderInfo != null)
    {
      localMiniAppInfo.renderInfo = new com.tencent.qqmini.sdk.launcher.model.RenderInfo();
      localMiniAppInfo.renderInfo.renderMode = paramMiniAppInfo.renderInfo.renderMode;
      if (paramMiniAppInfo.renderInfo.renderMaterialMap != null) {
        localMiniAppInfo.renderInfo.renderMaterialMap.putAll(paramMiniAppInfo.renderInfo.renderMaterialMap);
      }
    }
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
    }
    if (paramMiniAppInfo.miniGamePluginInfo != null) {
      localMiniAppInfo.miniGamePluginInfo = new com.tencent.qqmini.sdk.launcher.model.MiniGamePluginInfo(paramMiniAppInfo.miniGamePluginInfo.name, paramMiniAppInfo.miniGamePluginInfo.id, paramMiniAppInfo.miniGamePluginInfo.version, paramMiniAppInfo.miniGamePluginInfo.url, paramMiniAppInfo.miniGamePluginInfo.packageSize);
    }
    localMiniAppInfo.shareId = paramMiniAppInfo.shareId;
    localMiniAppInfo.via = paramMiniAppInfo.via;
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
    com.tencent.qqmini.sdk.launcher.model.EntryModel localEntryModel = new com.tencent.qqmini.sdk.launcher.model.EntryModel(paramEntryModel.type, paramEntryModel.uin, paramEntryModel.name, paramEntryModel.isAdmin);
    localEntryModel.reportData = paramEntryModel.reportData;
    return localEntryModel;
  }
  
  private static boolean enableFlutter()
  {
    return QzoneConfig.getInstance().getConfig("qqminiapp", "mini_flutter_enable", 1) == 1;
  }
  
  public static void initSDK(Context paramContext)
  {
    MiniSDK.init(paramContext);
    sSdkInited = true;
  }
  
  public static void preloadMiniApp(Context paramContext, boolean paramBoolean)
  {
    int i = 1;
    for (;;)
    {
      try
      {
        if (!sSdkInited)
        {
          sSdkInited = true;
          initSDK(paramContext);
        }
        if (!paramBoolean) {
          continue;
        }
        paramBoolean = enableFlutter();
        if (!paramBoolean) {
          break label162;
        }
        if (TissueGlobal.tissueEnv == null) {
          TissueGlobal.tissueEnv = new TissueEnvImpl();
        }
        if ((TextUtils.isEmpty(TissueGlobal.tissueEnv.getNativeLibDir())) || (!TissueGlobal.verifyTissueEngine(TissueGlobal.tissueEnv.getNativeLibDir()))) {
          continue;
        }
        if ((paramBoolean) && (i != 0))
        {
          localBundle = new Bundle();
          localBundle.putString("mini_key_preload_type", "preload_app");
          MiniSDK.preloadMiniApp(paramContext, localBundle);
        }
      }
      catch (Throwable paramContext)
      {
        Bundle localBundle;
        QLog.e("MiniSdkLauncher", 1, "startMiniApp exception!", paramContext);
        continue;
      }
      finally {}
      return;
      i = 0;
      continue;
      localBundle = new Bundle();
      localBundle.putString("mini_key_preload_type", "preload_game");
      MiniSDK.preloadMiniApp(paramContext, localBundle);
      continue;
      label162:
      i = 0;
    }
  }
  
  public static void startMiniApp(Activity paramActivity, MiniAppConfig paramMiniAppConfig, Bundle paramBundle)
  {
    if ((paramMiniAppConfig == null) || (paramMiniAppConfig.config == null)) {
      return;
    }
    if (paramActivity != null) {}
    for (;;)
    {
      try
      {
        localObject = paramActivity.getApplicationContext();
        if (!sSdkInited)
        {
          sSdkInited = true;
          initSDK((Context)localObject);
        }
        MiniSDK.startMiniApp(paramActivity, convert(paramMiniAppConfig), paramBundle, null);
        return;
      }
      catch (Throwable paramActivity)
      {
        QLog.e("MiniSdkLauncher", 1, "startMiniApp exception!", paramActivity);
        return;
      }
      Object localObject = BaseApplicationImpl.getApplication();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.launch.MiniSdkLauncher
 * JD-Core Version:    0.7.0.1
 */