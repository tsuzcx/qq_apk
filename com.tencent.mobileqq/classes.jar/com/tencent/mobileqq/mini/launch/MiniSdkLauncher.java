package com.tencent.mobileqq.mini.launch;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import bdcr;
import bdct;
import bdgc;
import bdgd;
import bdle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.tissue.TissueEnvImpl;
import com.tencent.mobileqq.minigame.ui.GameActivity1;
import com.tencent.qqmini.sdk.launcher.shell.ProcessType;
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
      localMiniAppInfo.firstPage.pagePath = paramMiniAppInfo.firstPage.jdField_a_of_type_JavaLangString;
      localMiniAppInfo.firstPage.subPkgName = paramMiniAppInfo.firstPage.jdField_b_of_type_JavaLangString;
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
      localMiniAppInfo.debugInfo.roomId = paramMiniAppInfo.debugInfo.jdField_a_of_type_JavaLangString;
      localMiniAppInfo.debugInfo.wsUrl = paramMiniAppInfo.debugInfo.jdField_b_of_type_JavaLangString;
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
      localMiniAppInfo.renderInfo.renderMode = paramMiniAppInfo.renderInfo.jdField_a_of_type_Int;
      if (paramMiniAppInfo.renderInfo.jdField_a_of_type_JavaUtilMap != null) {
        localMiniAppInfo.renderInfo.renderMaterialMap.putAll(paramMiniAppInfo.renderInfo.jdField_a_of_type_JavaUtilMap);
      }
    }
    if (paramMiniAppInfo.appMode != null)
    {
      localMiniAppInfo.appMode = new com.tencent.mobileqq.mini.apkg.AppMode();
      localMiniAppInfo.appMode.interMode = paramMiniAppInfo.appMode.jdField_a_of_type_Boolean;
      localMiniAppInfo.appMode.authoritySilent = paramMiniAppInfo.appMode.b;
      localMiniAppInfo.appMode.keepOffPullList = paramMiniAppInfo.appMode.c;
      localMiniAppInfo.appMode.closeTopRightCapsule = paramMiniAppInfo.appMode.d;
      localMiniAppInfo.appMode.openNativeApi = paramMiniAppInfo.appMode.e;
      localMiniAppInfo.appMode.hideAppSearch = paramMiniAppInfo.appMode.f;
      localMiniAppInfo.appMode.isAppStore = paramMiniAppInfo.appMode.g;
      localMiniAppInfo.appMode.isWangKa = paramMiniAppInfo.appMode.h;
      localMiniAppInfo.appMode.isInterLoading = paramMiniAppInfo.appMode.i;
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
    localMiniAppInfo.launchParam.jdField_a_of_type_Int = paramMiniAppConfig.launchParam.scene;
    localMiniAppInfo.launchParam.jdField_a_of_type_Boolean = paramMiniAppConfig.isFromShowInfo;
    localMiniAppInfo.launchParam.jdField_a_of_type_JavaLangString = paramMiniAppConfig.launchParam.miniAppId;
    localMiniAppInfo.launchParam.jdField_b_of_type_JavaLangString = paramMiniAppConfig.launchParam.extraKey;
    localMiniAppInfo.launchParam.jdField_c_of_type_JavaLangString = paramMiniAppConfig.launchParam.entryPath;
    localMiniAppInfo.launchParam.d = paramMiniAppConfig.launchParam.extendData;
    localMiniAppInfo.launchParam.e = paramMiniAppConfig.launchParam.navigateExtData;
    localMiniAppInfo.launchParam.f = paramMiniAppConfig.launchParam.fromMiniAppId;
    localMiniAppInfo.launchParam.g = paramMiniAppConfig.launchParam.fakeUrl;
    localMiniAppInfo.launchParam.jdField_a_of_type_Long = paramMiniAppConfig.launchParam.timestamp;
    localMiniAppInfo.launchParam.jdField_b_of_type_Long = paramMiniAppConfig.launchParam.launchClickTimeMillis;
    localMiniAppInfo.launchParam.h = paramMiniAppConfig.launchParam.shareTicket;
    localMiniAppInfo.launchParam.i = paramMiniAppConfig.launchParam.envVersion;
    localMiniAppInfo.launchParam.jdField_a_of_type_JavaUtilMap = paramMiniAppConfig.launchParam.reportData;
    localMiniAppInfo.launchParam.jdField_a_of_type_ComTencentQqminiSdkLauncherModelEntryModel = convertEntryModel(paramMiniAppConfig.launchParam.entryModel);
    localMiniAppInfo.launchParam.jdField_b_of_type_Int = paramMiniAppConfig.launchParam.fromBackToMiniApp;
    localMiniAppInfo.launchParam.j = paramMiniAppConfig.launchParam.fromEnvVersion;
    localMiniAppInfo.launchParam.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo = convert(paramMiniAppConfig.launchParam.fromMiniAppInfo);
    localMiniAppInfo.launchParam.jdField_c_of_type_Int = paramMiniAppConfig.launchParam.tempState;
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
      localMiniAppInfo.firstPage.jdField_a_of_type_JavaLangString = paramMiniAppInfo.firstPage.pagePath;
      localMiniAppInfo.firstPage.jdField_b_of_type_JavaLangString = paramMiniAppInfo.firstPage.subPkgName;
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
      localMiniAppInfo.debugInfo.jdField_a_of_type_JavaLangString = paramMiniAppInfo.debugInfo.roomId;
      localMiniAppInfo.debugInfo.jdField_b_of_type_JavaLangString = paramMiniAppInfo.debugInfo.wsUrl;
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
      localMiniAppInfo.renderInfo.jdField_a_of_type_Int = paramMiniAppInfo.renderInfo.renderMode;
      if (paramMiniAppInfo.renderInfo.renderMaterialMap != null) {
        localMiniAppInfo.renderInfo.jdField_a_of_type_JavaUtilMap.putAll(paramMiniAppInfo.renderInfo.renderMaterialMap);
      }
    }
    if (paramMiniAppInfo.appMode != null)
    {
      localMiniAppInfo.appMode = new com.tencent.qqmini.sdk.launcher.model.AppMode();
      localMiniAppInfo.appMode.jdField_a_of_type_Boolean = paramMiniAppInfo.appMode.interMode;
      localMiniAppInfo.appMode.b = paramMiniAppInfo.appMode.authoritySilent;
      localMiniAppInfo.appMode.c = paramMiniAppInfo.appMode.keepOffPullList;
      localMiniAppInfo.appMode.d = paramMiniAppInfo.appMode.closeTopRightCapsule;
      localMiniAppInfo.appMode.e = paramMiniAppInfo.appMode.openNativeApi;
      localMiniAppInfo.appMode.f = paramMiniAppInfo.appMode.hideAppSearch;
      localMiniAppInfo.appMode.g = paramMiniAppInfo.appMode.isAppStore;
      localMiniAppInfo.appMode.h = paramMiniAppInfo.appMode.isWangKa;
      localMiniAppInfo.appMode.i = paramMiniAppInfo.appMode.isInterLoading;
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
    localEntryModel.jdField_a_of_type_JavaUtilMap = paramEntryModel.reportData;
    return localEntryModel;
  }
  
  private static boolean enableFlutter()
  {
    return QzoneConfig.getInstance().getConfig("qqminiapp", "mini_flutter_enable", 1) == 1;
  }
  
  public static void initSDK(Context paramContext)
  {
    bdct.a(paramContext, new bdcr(paramContext).a(true).a(paramContext.getPackageName() + ":mini6", GameActivity1.class, bdle.a().a("com.tencent.qqmini.sdk.receiver.AppBrandMainReceiver1"), ProcessType.MINI_GAME).a(paramContext.getPackageName() + ":mini7", bdle.a().a("com.tencent.mobileqq.mini.appbrand.ui.AppBrandUI3"), bdle.a().a("com.tencent.mobileqq.mini.app.AppBrandTaskPreloadReceiver7"), ProcessType.MINI_APP).a());
    sSdkInited = true;
  }
  
  public static void preloadMiniApp(Context paramContext)
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
        boolean bool = enableFlutter();
        if (bool)
        {
          if (bdgd.a == null) {
            bdgd.a = new TissueEnvImpl();
          }
          if ((!TextUtils.isEmpty(bdgd.a.getNativeLibDir())) && (bdgd.a(bdgd.a.getNativeLibDir())))
          {
            if ((bool) && (i != 0)) {
              bdct.a(paramContext);
            }
            return;
          }
          i = 0;
          continue;
        }
        i = 0;
      }
      finally {}
    }
  }
  
  public static void startMiniApp(Activity paramActivity, MiniAppConfig paramMiniAppConfig, Bundle paramBundle)
  {
    if ((paramMiniAppConfig == null) || (paramMiniAppConfig.config == null)) {
      return;
    }
    if (paramActivity != null) {}
    for (Object localObject = paramActivity.getApplicationContext();; localObject = BaseApplicationImpl.getApplication())
    {
      if (!sSdkInited)
      {
        sSdkInited = true;
        initSDK((Context)localObject);
      }
      bdct.a(paramActivity, convert(paramMiniAppConfig), paramBundle, null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.launch.MiniSdkLauncher
 * JD-Core Version:    0.7.0.1
 */