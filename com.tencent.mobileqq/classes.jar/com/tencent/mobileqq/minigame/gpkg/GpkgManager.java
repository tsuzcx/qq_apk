package com.tencent.mobileqq.minigame.gpkg;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import bace;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.DownloadResult.Content;
import com.tencent.component.network.downloader.DownloadResult.Process;
import com.tencent.component.network.downloader.DownloadResult.Status;
import com.tencent.component.network.downloader.Downloader.DownloadMode;
import com.tencent.mobileqq.mini.apkg.ApkgMainProcessManager;
import com.tencent.mobileqq.mini.apkg.ApkgManager;
import com.tencent.mobileqq.mini.apkg.FirstPageInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.apkg.MiniGamePluginInfo;
import com.tencent.mobileqq.mini.apkg.SubPkgInfo;
import com.tencent.mobileqq.mini.launch.CmdCallback;
import com.tencent.mobileqq.mini.report.MiniAppReportManager2;
import com.tencent.mobileqq.mini.report.MiniAppStartState;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.mini.reuse.MiniappDownloadUtil;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.utils.DebugUtil;
import com.tencent.mobileqq.mini.utils.FileUtils;
import com.tencent.mobileqq.mini.utils.WxapkgUnpacker;
import com.tencent.mobileqq.triton.sdk.game.MiniGameInfo;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class GpkgManager
{
  private static final String KEY_DOWNLOAD_GAME = "key_download_game";
  private static final String KEY_DOWNLOAD_PROGRESS_PERCENT = "key_download_process_percent";
  private static final String KEY_DOWNLOAD_PROGRESS_SIZE = "key_download_progress_size";
  private static final String KEY_DOWNLOAD_RESULT_OBJECT = "key_download_result_object";
  private static final String KEY_DOWNLOAD_RETCODE = "key_download_retcode";
  private static final String KEY_DOWNLOAD_RETSTRING = "key_download_retstring";
  private static final String KEY_DOWNLOAD_SAVEPATH = "key_download_savepath";
  private static final String KEY_DOWNLOAD_URL = "key_download_url";
  public static final String SUFFIX_WXAPKG = ".wxapkg";
  private static final String TAG = "[minigame] GpkgManager";
  private static final int VALUE_DOWNLOAD_CANCEL = 0;
  private static final int VALUE_DOWNLOAD_FAIL = -1;
  private static final int VALUE_DOWNLOAD_PROGRESS = 2;
  private static final int VALUE_DOWNLOAD_SUCC = 1;
  public static volatile long downloadDuration;
  
  private static boolean checkOfflineResourceContent(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString)) {
      paramString = paramString + File.separator + "offlineconfig.json";
    }
    try
    {
      paramString = new File(paramString);
      bool1 = bool2;
      if (paramString.exists())
      {
        paramString = FileUtils.readFileToString(paramString);
        bool1 = bool2;
        if (!TextUtils.isEmpty(paramString)) {
          bool1 = new JSONObject(paramString).optBoolean("offlineResourceReady", false);
        }
      }
      return bool1;
    }
    catch (Throwable paramString)
    {
      QLog.i("[minigame] GpkgManager", 1, "[Gpkg] checkOfflineResourceContent error:" + DebugUtil.getPrintableStackTrace(paramString));
    }
    return false;
  }
  
  private static boolean checkPkgFolderContent(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString + File.separator + "game.js";
      try
      {
        boolean bool = new File(paramString).exists();
        if (bool) {
          return true;
        }
      }
      catch (Throwable paramString)
      {
        QLog.i("[minigame] GpkgManager", 1, "[Gpkg] checkPkgFolderContent error:" + DebugUtil.getPrintableStackTrace(paramString));
      }
    }
    return false;
  }
  
  private static void downloadGpkgByResumableDownloader(MiniAppConfig paramMiniAppConfig, GpkgManager.OnInitGpkgListener paramOnInitGpkgListener, String paramString)
  {
    if ((paramMiniAppConfig == null) || (paramMiniAppConfig.config == null))
    {
      if (paramOnInitGpkgListener != null) {
        paramOnInitGpkgListener.onInitGpkgInfo(2002, null, "downloadGpkgByResumableDownloader fail invalid params, game config null");
      }
      QLog.e("[minigame] GpkgManager", 1, "[Gpkg]downloadGpkgByResumableDownloader fail invalid params, game config null");
      return;
    }
    if (!TextUtils.isEmpty(paramMiniAppConfig.config.appId)) {
      MiniAppStartState.setApkgDownload(paramMiniAppConfig.config.appId, false);
    }
    String str2 = ApkgManager.getPkgRoot(paramMiniAppConfig.config) + paramMiniAppConfig.config.appId + '_' + paramMiniAppConfig.config.version + ".wxapkg";
    long l = System.currentTimeMillis();
    Object localObject1 = null;
    String str1;
    Object localObject2;
    Object localObject3;
    if (paramMiniAppConfig.config.firstPage != null)
    {
      str1 = paramMiniAppConfig.config.firstPage.subPkgName;
      if (paramMiniAppConfig.config.subpkgs != null)
      {
        localObject2 = paramMiniAppConfig.config.subpkgs.iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (SubPkgInfo)((Iterator)localObject2).next();
          if ((localObject3 != null) && (str1 != null) && (str1.equals(((SubPkgInfo)localObject3).subPkgName))) {
            if (((SubPkgInfo)localObject3).independent == 1)
            {
              localObject3 = ((SubPkgInfo)localObject3).downloadUrl;
              localObject2 = localObject1;
              localObject1 = localObject3;
            }
          }
        }
      }
    }
    for (;;)
    {
      localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = paramMiniAppConfig.config.downloadUrl;
      }
      QLog.i("[minigame] GpkgManager", 1, "[Gpkg]download gpkgUrl=" + (String)localObject3 + " ,subApkUrl=" + (String)localObject2 + " ,independentPath=" + str1 + " ,savePath=" + str2);
      MiniReportManager.reportEventType(paramMiniAppConfig, 619, "1");
      MiniappDownloadUtil.getInstance().downloadApkg(paramMiniAppConfig, false, (String)localObject3, str2, true, new GpkgManager.4(paramMiniAppConfig, paramOnInitGpkgListener, l, str2, paramString, (String)localObject2, str1), Downloader.DownloadMode.StrictMode, ApkgManager.getHeader((String)localObject3, paramMiniAppConfig));
      return;
      localObject1 = ((SubPkgInfo)localObject3).downloadUrl;
      for (;;)
      {
        break;
      }
      str1 = null;
      localObject2 = localObject1;
      localObject1 = null;
      continue;
      str1 = null;
      localObject2 = null;
      localObject1 = null;
    }
  }
  
  public static void downloadPkgInMainProcess(MiniAppConfig paramMiniAppConfig, String paramString1, String paramString2, CmdCallback paramCmdCallback)
  {
    if ((paramMiniAppConfig == null) || (paramMiniAppConfig.config == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      QLog.e("[minigame] GpkgManager", 1, "[Gpkg] downloadPkgInMainProcess invalid param, downloadUrl:" + paramString1 + ",savePath:" + paramString2 + ",game config:" + paramMiniAppConfig);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_mini_app_config", paramMiniAppConfig);
    localBundle.putString("key_download_url", paramString1);
    localBundle.putString("key_download_savepath", paramString2);
    ApkgMainProcessManager.checkShouldDownloadInMainProcess(localBundle, new GpkgManager.8(paramCmdCallback), false);
  }
  
  public static void downloadSubPack(MiniGamePkg paramMiniGamePkg, String paramString, GpkgManager.OnInitGpkgListener paramOnInitGpkgListener)
  {
    if ((paramMiniGamePkg == null) || (paramMiniGamePkg.appConfig == null) || (paramMiniGamePkg.appConfig.config == null)) {}
    MiniAppInfo localMiniAppInfo;
    String str1;
    String str2;
    do
    {
      String str3;
      do
      {
        return;
        localMiniAppInfo = paramMiniGamePkg.appConfig.config;
        str1 = paramMiniGamePkg.getRootPath(paramString);
        str2 = getSubPkgDownloadUrl(paramMiniGamePkg, paramString);
        str3 = ApkgManager.getApkgFolderPath(localMiniAppInfo);
        QLog.i("[minigame] GpkgManager subpackage", 1, "[Gpkg] downloadSubPack | downPage(subName)=" + paramString + "; subPackDownloadUrl=" + str2 + "; folder:" + str3);
        if (!TextUtils.isEmpty(str3)) {
          break;
        }
      } while (paramOnInitGpkgListener == null);
      paramOnInitGpkgListener.onInitGpkgInfo(2007, null, "downloadSubPack but pkg folder not exist");
      return;
      if (!new File(str3, str1).exists()) {
        break;
      }
    } while (paramOnInitGpkgListener == null);
    paramOnInitGpkgListener.onInitGpkgInfo(0, paramMiniGamePkg, "downloadSubPack succeed, sub pkg already exist");
    return;
    if (!TextUtils.isEmpty(str2))
    {
      paramString = ApkgManager.getPkgRoot(localMiniAppInfo) + File.separator + localMiniAppInfo.appId + '_' + localMiniAppInfo.version + ".wxapkg";
      MiniReportManager.reportEventType(paramMiniGamePkg.appConfig, 613, "1");
      if (QzoneConfig.getInstance().getConfig("qqminiapp", "mini_game_force_download_in_mainprocess", 0) == 1) {}
      for (int i = 1; i != 0; i = 0)
      {
        downloadSubPkgInMainProcess(paramMiniGamePkg.appConfig, paramMiniGamePkg, str2, paramString, str1, paramOnInitGpkgListener);
        return;
      }
      MiniappDownloadUtil.getInstance().downloadApkg(paramMiniGamePkg.appConfig, false, str2, paramString, true, new GpkgManager.6(paramMiniGamePkg, paramString, str1, paramOnInitGpkgListener), Downloader.DownloadMode.StrictMode, ApkgManager.getHeader(str2, paramMiniGamePkg.appConfig));
      return;
    }
    paramOnInitGpkgListener.onInitGpkgInfo(2008, null, "sub pkg download url empty");
  }
  
  public static void downloadSubPkgInMainProcess(MiniAppConfig paramMiniAppConfig, MiniGamePkg paramMiniGamePkg, String paramString1, String paramString2, String paramString3, GpkgManager.OnInitGpkgListener paramOnInitGpkgListener)
  {
    downloadPkgInMainProcess(paramMiniAppConfig, paramString1, paramString2, new GpkgManager.7(paramMiniGamePkg, paramString2, paramString3, paramOnInitGpkgListener));
  }
  
  public static String getGpkgFolderPath(MiniGameInfo paramMiniGameInfo)
  {
    if ((paramMiniGameInfo == null) || (TextUtils.isEmpty(paramMiniGameInfo.gameId))) {
      return "";
    }
    MiniAppInfo localMiniAppInfo = new MiniAppInfo();
    localMiniAppInfo.appId = paramMiniGameInfo.gameId;
    localMiniAppInfo.version = paramMiniGameInfo.version;
    localMiniAppInfo.verType = paramMiniGameInfo.verType;
    localMiniAppInfo.setEngineType(1);
    return ApkgManager.getApkgFolderPath(localMiniAppInfo);
  }
  
  public static void getGpkgInfoByConfig(MiniAppConfig paramMiniAppConfig, GpkgManager.OnInitGpkgListener paramOnInitGpkgListener)
  {
    if ((paramMiniAppConfig == null) || (paramMiniAppConfig.config == null))
    {
      QLog.e("[minigame] GpkgManager", 1, "[Gpkg] getGpkgInfoByConfig invalid request, game config null");
      if (paramOnInitGpkgListener != null) {
        paramOnInitGpkgListener.onInitGpkgInfo(2002, null, "getGpkgInfoByConfig invalid request, game config null");
      }
      return;
    }
    ApkgMainProcessManager.checkShouldLoadPkgInMainProcess(paramMiniAppConfig, new GpkgManager.1(paramMiniAppConfig, paramOnInitGpkgListener), false);
  }
  
  private static String getSubPkgDownloadUrl(MiniGamePkg paramMiniGamePkg, String paramString)
  {
    paramMiniGamePkg = paramMiniGamePkg.appConfig.config.subpkgs;
    if ((paramMiniGamePkg != null) && (paramMiniGamePkg.size() > 0) && (!TextUtils.isEmpty(paramString)))
    {
      paramMiniGamePkg = paramMiniGamePkg.iterator();
      while (paramMiniGamePkg.hasNext())
      {
        SubPkgInfo localSubPkgInfo = (SubPkgInfo)paramMiniGamePkg.next();
        if (paramString.equals(localSubPkgInfo.subPkgName)) {
          return localSubPkgInfo.downloadUrl;
        }
      }
    }
    return null;
  }
  
  public static void handleDownloadPkgInMainProcess(Bundle paramBundle, CmdCallback paramCmdCallback)
  {
    MiniAppConfig localMiniAppConfig = (MiniAppConfig)paramBundle.getParcelable("key_mini_app_config");
    String str = paramBundle.getString("key_download_url", "");
    paramBundle = paramBundle.getString("key_download_savepath", "");
    if ((localMiniAppConfig == null) || (localMiniAppConfig.config == null) || (TextUtils.isEmpty(str)) || (TextUtils.isEmpty(paramBundle))) {
      return;
    }
    MiniappDownloadUtil.getInstance().downloadApkg(localMiniAppConfig, true, str, paramBundle, true, new GpkgManager.9(paramCmdCallback), Downloader.DownloadMode.StrictMode, ApkgManager.getHeader(str, localMiniAppConfig));
  }
  
  private static void handleDownloadResult(boolean paramBoolean, int paramInt, long paramLong, float paramFloat, String paramString1, DownloadResult paramDownloadResult, MiniGamePkg paramMiniGamePkg, String paramString2, String paramString3, GpkgManager.OnInitGpkgListener paramOnInitGpkgListener)
  {
    if (paramBoolean)
    {
      long l = -1L;
      paramLong = l;
      if (paramDownloadResult != null)
      {
        paramLong = l;
        if (paramDownloadResult.getContent() != null) {
          paramLong = paramDownloadResult.getContent().length;
        }
      }
      MiniReportManager.reportEventType(paramMiniGamePkg.appConfig, 614, String.valueOf(paramLong), "1");
      paramString1 = ApkgManager.getApkgFolderPath(paramMiniGamePkg.appConfig.config);
      paramDownloadResult = new File(paramString2);
      MiniReportManager.reportEventType(paramMiniGamePkg.appConfig, 615, "1");
      paramBoolean = WxapkgUnpacker.unpackSync(paramDownloadResult.getAbsolutePath(), paramString1, paramString3, true);
      paramDownloadResult = paramMiniGamePkg.appConfig;
      if (paramBoolean)
      {
        paramInt = 0;
        MiniReportManager.reportEventType(paramDownloadResult, 616, null, null, null, paramInt, "1", 0L, null);
        if (QLog.isColorLevel()) {
          QLog.d("[minigame] GpkgManager", 1, "downloadSubPack | getResPath :hasUnpack=" + paramBoolean + "; folderPath=" + paramString1 + "; subRoot=" + paramString3);
        }
        if (!paramBoolean) {
          break label216;
        }
        if (paramOnInitGpkgListener != null) {
          paramOnInitGpkgListener.onInitGpkgInfo(0, paramMiniGamePkg, "download sub pkg and unpack succeed");
        }
      }
    }
    label216:
    do
    {
      do
      {
        do
        {
          return;
          paramInt = 1;
          break;
        } while (paramOnInitGpkgListener == null);
        paramOnInitGpkgListener.onInitGpkgInfo(2011, null, "download sub pkg succeed, but unpack sub pkg fail");
        return;
        if (paramInt != 2) {
          break label265;
        }
      } while (paramOnInitGpkgListener == null);
      paramOnInitGpkgListener.onDownloadGpkgProgress(paramMiniGamePkg.appConfig.config, paramFloat, paramLong);
      return;
      if (paramInt != 0) {
        break label343;
      }
      MiniReportManager.reportEventType(paramMiniGamePkg.appConfig, 614, null, null, null, -9999, "1", 0L, null);
    } while (paramOnInitGpkgListener == null);
    label265:
    paramOnInitGpkgListener.onInitGpkgInfo(2009, null, "download sub pkg cancel");
    QLog.d("[minigame] GpkgManager", 2, "onDownloadCanceled() called with: s = [" + paramString1 + "]");
    return;
    label343:
    if (paramInt == -1)
    {
      if ((paramDownloadResult != null) && (paramDownloadResult.getStatus() != null))
      {
        if (paramDownloadResult.getStatus().exception2Code == 0) {
          break label471;
        }
        paramInt = paramDownloadResult.getStatus().exception2Code;
      }
      for (;;)
      {
        MiniReportManager.reportEventType(paramMiniGamePkg.appConfig, 614, null, null, null, paramInt, "1", paramDownloadResult.getProcess().duration, null);
        if (paramOnInitGpkgListener == null) {
          break;
        }
        paramOnInitGpkgListener.onInitGpkgInfo(2010, null, "download sub pkg fail");
        QLog.d("[minigame] GpkgManager", 2, "onDownloadFailed() called with: s = [" + paramString1 + "], downloadResult = [" + paramDownloadResult + "]");
        return;
        if (paramDownloadResult.getStatus().httpStatus > 0) {
          paramInt = paramDownloadResult.getStatus().httpStatus;
        } else {
          paramInt = -99999;
        }
      }
    }
    label471:
    paramOnInitGpkgListener.onInitGpkgInfo(2024, null, "download sub pkg fail");
  }
  
  private static void handleGpkgDownloadSuccess(String paramString1, String paramString2, MiniAppConfig paramMiniAppConfig, GpkgManager.OnInitGpkgListener paramOnInitGpkgListener, String paramString3, String paramString4)
  {
    File localFile = new File(paramString1);
    MiniReportManager.reportEventType(paramMiniAppConfig, 621, "1");
    boolean bool = WxapkgUnpacker.unpackSync(localFile.getAbsolutePath(), paramString2, "", true);
    int i;
    if (bool)
    {
      i = 0;
      MiniReportManager.reportEventType(paramMiniAppConfig, 622, null, null, null, i, "1", 0L, null);
      if (QLog.isColorLevel()) {
        QLog.i("[minigame] GpkgManager", 1, "[Gpkg] handleGpkgDownloadSuccess path:" + paramString1 + ",unpack:" + paramString2 + ",hasUnpack:" + bool);
      }
      if (!bool) {
        break label208;
      }
      paramString1 = MiniGamePkg.loadGamePkgFromFolderPath(paramString2, paramString4, paramMiniAppConfig);
      if (paramString3 == null) {
        break label192;
      }
      QLog.i("[minigame] GpkgManager", 1, "[Gpkg] downloadSubPack after gpk succeed, subApkUrl=" + paramString3);
      MiniReportManager.reportEventType(paramMiniAppConfig, 1029, null, null, null, 0, "1", 0L, null);
      downloadSubPack(paramString1, paramString3, new GpkgManager.5(paramOnInitGpkgListener));
    }
    label192:
    label208:
    do
    {
      do
      {
        return;
        i = 1;
        break;
      } while (paramOnInitGpkgListener == null);
      paramOnInitGpkgListener.onInitGpkgInfo(0, paramString1, "download pkg and unpack succeed");
      return;
      MiniProgramLpReportDC04239.reportPageView(paramMiniAppConfig, "1", null, "load_fail", "unpkg_fail");
      MiniAppReportManager2.reportPageView("2launch_fail", "unpkg_fail", null, paramMiniAppConfig);
      QLog.e("[minigame] GpkgManager", 1, new Object[] { "[Gpkg]", " handleGpkgDownloadSuccess hasUnpack=", Boolean.valueOf(bool) });
    } while (paramOnInitGpkgListener == null);
    paramOnInitGpkgListener.onInitGpkgInfo(2005, null, "download pkg succeed but unpack fail");
  }
  
  public static boolean isGpkgValid(MiniAppConfig paramMiniAppConfig)
  {
    paramMiniAppConfig = getGpkgFolderPath(new MiniGameInfo(paramMiniAppConfig.config.appId, paramMiniAppConfig.config.version, paramMiniAppConfig.config.verType));
    if (new File(paramMiniAppConfig).exists()) {
      return checkPkgFolderContent(paramMiniAppConfig);
    }
    return false;
  }
  
  public static boolean isOfflineResourceReady(MiniAppConfig paramMiniAppConfig)
  {
    paramMiniAppConfig = getGpkgFolderPath(new MiniGameInfo(paramMiniAppConfig.config.appId, paramMiniAppConfig.config.version, paramMiniAppConfig.config.verType));
    if ((new File(paramMiniAppConfig).exists()) && (checkPkgFolderContent(paramMiniAppConfig))) {
      return checkOfflineResourceContent(paramMiniAppConfig);
    }
    return false;
  }
  
  private static void loadGpkgInMiniProcess(MiniAppConfig paramMiniAppConfig, GpkgManager.OnInitGpkgListener paramOnInitGpkgListener)
  {
    ApkgMainProcessManager.queueSubProcessLoadTask(paramMiniAppConfig);
    performGetGpkgInfoByConfig(paramMiniAppConfig, new GpkgManager.2(paramMiniAppConfig, paramOnInitGpkgListener));
  }
  
  private static void performDownloadGpkg(MiniAppConfig paramMiniAppConfig, GpkgManager.OnInitGpkgListener paramOnInitGpkgListener, String paramString)
  {
    if (new File(paramString).exists())
    {
      if (checkPkgFolderContent(paramString))
      {
        QLog.i("[minigame] GpkgManager", 1, "[Gpkg] checkPkgFolderContent success");
        paramString = MiniGamePkg.loadGamePkgFromFolderPath(paramString, null, paramMiniAppConfig);
        if (paramOnInitGpkgListener != null) {
          paramOnInitGpkgListener.onInitGpkgInfo(0, paramString, "gpkg exist, no need download");
        }
        if (!TextUtils.isEmpty(paramMiniAppConfig.config.appId)) {
          MiniAppStartState.setApkgDownload(paramMiniAppConfig.config.appId, true);
        }
        return;
      }
      QLog.i("[minigame] GpkgManager", 1, "[Gpkg] checkPkgFolderContent failed, delete folder:" + paramString);
      bace.a(paramString, false);
      QLog.i("[minigame] GpkgManager", 1, "[Gpkg] download gpkg by url1:" + paramMiniAppConfig.config.downloadUrl);
      downloadGpkgByResumableDownloader(paramMiniAppConfig, paramOnInitGpkgListener, paramString);
      return;
    }
    QLog.i("[minigame] GpkgManager", 1, "[Gpkg] download gpkg by url2:" + paramMiniAppConfig.config.downloadUrl);
    downloadGpkgByResumableDownloader(paramMiniAppConfig, paramOnInitGpkgListener, paramString);
  }
  
  private static void performDownloadGpkgPlugin(@NonNull MiniGamePluginInfo paramMiniGamePluginInfo, GpkgManager.DownloadPluginCallback paramDownloadPluginCallback)
  {
    File localFile1 = new File(ApkgManager.getGpkgPluginFolderPath(paramMiniGamePluginInfo));
    if (localFile1.exists())
    {
      if (new File(localFile1, "plugin.js").exists())
      {
        QLog.i("[minigame] GpkgManager", 1, "[Gpkg] plugin existed:" + localFile1.getAbsolutePath() + " " + paramMiniGamePluginInfo);
        paramDownloadPluginCallback.onPluginDownloadComplete(true, null);
        return;
      }
      QLog.e("[minigame] GpkgManager", 1, "[Gpkg] plugin corrupted:" + localFile1.getAbsolutePath() + " " + paramMiniGamePluginInfo);
    }
    try
    {
      File localFile2 = File.createTempFile("gpkg_plugin_" + paramMiniGamePluginInfo.id, ".wxapkg");
      QLog.i("[minigame] GpkgManager", 1, "[Gpkg] start download plugin to:" + localFile1.getAbsolutePath() + " " + paramMiniGamePluginInfo);
      MiniappDownloadUtil.getInstance().download(paramMiniGamePluginInfo.url, localFile2.getAbsolutePath(), false, new GpkgManager.3(paramDownloadPluginCallback, paramMiniGamePluginInfo, localFile2, localFile1), Downloader.DownloadMode.StrictMode, null);
      return;
    }
    catch (IOException paramMiniGamePluginInfo)
    {
      paramDownloadPluginCallback.onPluginDownloadComplete(false, paramMiniGamePluginInfo);
    }
  }
  
  public static void performGetGpkgInfoByConfig(MiniAppConfig paramMiniAppConfig, GpkgManager.OnInitGpkgListener paramOnInitGpkgListener)
  {
    MiniReportManager.addCostTimeEventAttachInfo(paramMiniAppConfig, 2, "0");
    if ((paramMiniAppConfig == null) || (paramMiniAppConfig.config == null))
    {
      QLog.e("[minigame] GpkgManager", 1, "[Gpkg] getGpkgInfoByConfig invalid request, game config null");
      if (paramOnInitGpkgListener != null) {
        paramOnInitGpkgListener.onInitGpkgInfo(2002, null, "getGpkgInfoByConfig invalid request, game config null");
      }
      return;
    }
    QLog.i("[minigame] GpkgManager", 1, "[Gpkg] getGpkgInfoByConfig version:" + paramMiniAppConfig.config.version + ", appid=" + paramMiniAppConfig.config.appId + ",size=" + paramMiniAppConfig.config.fileSize);
    String str = getGpkgFolderPath(new MiniGameInfo(paramMiniAppConfig.config.appId, paramMiniAppConfig.config.version, paramMiniAppConfig.config.verType));
    QLog.i("[minigame] GpkgManager", 1, "[Gpkg] getGpkgInfoByConfig folderPath:" + str);
    if ((paramMiniAppConfig.config.verType != 3) && ((!paramMiniAppConfig.config.isSupportOffline) || (paramMiniAppConfig.launchParam.scene == 1011)))
    {
      QLog.i("[minigame] GpkgManager", 1, "[Gpkg]verType is not online " + paramMiniAppConfig.config.verType + ", delete path " + str);
      if (new File(str).exists()) {
        bace.a(str, false);
      }
    }
    paramOnInitGpkgListener = new GpkgManager.MergedOnInitListener(paramOnInitGpkgListener);
    performDownloadGpkg(paramMiniAppConfig, paramOnInitGpkgListener, str);
    if (paramMiniAppConfig.config.miniGamePluginInfo != null)
    {
      performDownloadGpkgPlugin(paramMiniAppConfig.config.miniGamePluginInfo, paramOnInitGpkgListener);
      return;
    }
    QLog.i("[minigame] GpkgManager", 1, "[Gpkg] game don't have plugin " + paramMiniAppConfig.config.name + " " + paramMiniAppConfig.config.appId);
    paramOnInitGpkgListener.onPluginDownloadComplete(true, null);
  }
  
  public static boolean pkgExists(MiniAppInfo paramMiniAppInfo)
  {
    return new File(ApkgManager.getApkgFolderPath(paramMiniAppInfo)).exists();
  }
  
  public static void preloadGpkgByConfig(MiniAppConfig paramMiniAppConfig, boolean paramBoolean)
  {
    ApkgMainProcessManager.checkShouldLoadPkgInMainProcess(paramMiniAppConfig, null, paramBoolean);
  }
  
  public static void setOfflineResourceContent(MiniAppConfig paramMiniAppConfig, boolean paramBoolean)
  {
    paramMiniAppConfig = getGpkgFolderPath(new MiniGameInfo(paramMiniAppConfig.config.appId, paramMiniAppConfig.config.version, paramMiniAppConfig.config.verType));
    if (new File(paramMiniAppConfig).exists()) {}
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("offlineResourceReady", paramBoolean);
      localObject = ((JSONObject)localObject).toString().replaceAll("\\\\", "");
      FileUtils.writeFile(new File(paramMiniAppConfig, "offlineconfig.json").getAbsolutePath(), (String)localObject);
      return;
    }
    catch (Throwable paramMiniAppConfig)
    {
      paramMiniAppConfig.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.gpkg.GpkgManager
 * JD-Core Version:    0.7.0.1
 */