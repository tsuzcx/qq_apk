package com.tencent.qqmini.sdk.manager;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.manager.WxapkgUnpacker;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.FirstPageInfo;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniGamePluginInfo;
import com.tencent.qqmini.sdk.launcher.model.SubPkgInfo;
import com.tencent.qqmini.sdk.launcher.utils.MD5Utils;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import com.tencent.qqmini.sdk.report.MiniAppStartState;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class ApkgManager
{
  public static final String MINI_APP_MAIN_PKG = "/__APP__/";
  public static final String MINI_GAME_PERSISTENT_SP_KEY = "persistent";
  public static final String MINI_GAME_PERSISTENT_SP_NAME = "persistent_debug_version_";
  public static final String SUFFIX_WXAPKG = ".qapkg";
  private static final String TAG = "ApkgManager";
  public static volatile long downloadDuration = 0L;
  private static volatile ApkgManager sInstance;
  
  private void deleteOldPkg(MiniAppInfo paramMiniAppInfo, String paramString)
  {
    ThreadManager.executeOnDiskIOThreadPool(new ApkgManager.4(this, paramMiniAppInfo, paramString));
  }
  
  private void doDownload(ApkgInfo paramApkgInfo, MiniAppInfo paramMiniAppInfo, String paramString1, ApkgManager.OnInitApkgListener paramOnInitApkgListener, String paramString2, String paramString3, String paramString4)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      MiniReportManager.reportEventType(paramMiniAppInfo, 613, paramString1, null, null, 0, "0", 0L, null);
      ((DownloaderProxy)ProxyManager.get(DownloaderProxy.class)).download(paramString2, null, paramString4, 60, new ApkgManager.5(this, paramOnInitApkgListener, paramApkgInfo, paramString3, paramString2, paramString4, paramMiniAppInfo, paramString1));
      return;
    }
    QMLog.d("ApkgManager", "downloadSubPack fail because subPackDownloadUrl is null!");
    paramOnInitApkgListener.onInitApkgInfo(1, paramApkgInfo, null);
  }
  
  private void downloadApkgByResumableDownloader(MiniAppInfo paramMiniAppInfo, boolean paramBoolean, ApkgManager.OnGetApkgInfoListener paramOnGetApkgInfoListener, String paramString)
  {
    String str;
    Object localObject2;
    Object localObject1;
    Object localObject3;
    if (paramMiniAppInfo.firstPage != null)
    {
      str = paramMiniAppInfo.firstPage.subPkgName;
      localObject2 = paramMiniAppInfo.subpkgs.iterator();
      localObject1 = null;
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (SubPkgInfo)((Iterator)localObject2).next();
        if ((localObject3 != null) && (((SubPkgInfo)localObject3).subPkgName != null) && (((SubPkgInfo)localObject3).subPkgName.equals(str))) {
          if (((SubPkgInfo)localObject3).independent == 1)
          {
            localObject3 = ((SubPkgInfo)localObject3).downloadUrl;
            localObject2 = localObject1;
            localObject1 = localObject3;
          }
        }
      }
    }
    for (;;)
    {
      localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = paramMiniAppInfo.downloadUrl;
      }
      downloadApkgByResumableDownloader(paramMiniAppInfo, paramBoolean, paramOnGetApkgInfoListener, paramString, (String)localObject3, (String)localObject2, str);
      return;
      localObject1 = paramMiniAppInfo.firstPage.pagePath;
      for (;;)
      {
        break;
      }
      str = null;
      localObject2 = localObject1;
      localObject1 = null;
      continue;
      str = null;
      localObject2 = null;
      localObject1 = null;
    }
  }
  
  private void downloadApkgByResumableDownloader(MiniAppInfo paramMiniAppInfo, boolean paramBoolean, ApkgManager.OnGetApkgInfoListener paramOnGetApkgInfoListener, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    String str = ApkgManager.RootPath.getAppPkgRoot() + paramMiniAppInfo.appId + '_' + paramMiniAppInfo.version + ".qapkg";
    long l = System.currentTimeMillis();
    if (TextUtils.isEmpty(paramString2)) {
      if (paramOnGetApkgInfoListener != null)
      {
        paramOnGetApkgInfoListener.onGetApkgInfo(null, 1, "apkUrl is Null!");
        QMLog.e("ApkgManager", "downloadApkgByResumableDownloader apkUrl is null!");
      }
    }
    do
    {
      return;
      MiniReportManager.reportEventType(paramMiniAppInfo, 619, "0");
      ((DownloaderProxy)ProxyManager.get(DownloaderProxy.class)).download(paramString2, null, str, 60, new ApkgManager.2(this, paramOnGetApkgInfoListener, paramMiniAppInfo, paramString2, paramString1, str, paramString3, paramString4, l));
    } while (!paramBoolean);
    deleteOldPkg(paramMiniAppInfo, paramString1);
  }
  
  public static String getApkgFolderPath(MiniAppInfo paramMiniAppInfo)
  {
    if ((paramMiniAppInfo == null) || (TextUtils.isEmpty(paramMiniAppInfo.appId))) {
      return "";
    }
    if (paramMiniAppInfo.verType == 3) {
      return getPkgRoot(paramMiniAppInfo) + MD5Utils.toMD5(paramMiniAppInfo.appId) + "_" + paramMiniAppInfo.versionId;
    }
    return getPkgRoot(paramMiniAppInfo) + paramMiniAppInfo.appId + "_debug";
  }
  
  private void getApkgInfoByConfig(MiniAppInfo paramMiniAppInfo, boolean paramBoolean, ApkgManager.OnGetApkgInfoListener paramOnGetApkgInfoListener)
  {
    if (paramMiniAppInfo == null) {}
    String str1;
    for (;;)
    {
      return;
      str1 = paramMiniAppInfo.version;
      QMLog.d("ApkgManager", "getApkgInfoByConfig version:" + str1);
      str1 = getApkgFolderPath(paramMiniAppInfo);
      if (paramMiniAppInfo.verType != 3)
      {
        QMLog.d("ApkgManager", "verType is not online, delete unPackFolderPath." + paramMiniAppInfo.verType);
        if (new File(str1).exists()) {
          FileUtils.delete(str1, false);
        }
      }
      if (paramMiniAppInfo.launchParam.isFlutterMode) {
        try
        {
          String str2 = str1 + "_maintmp";
          if (new File(str2).exists())
          {
            ApkgInfo localApkgInfo = ApkgInfo.loadApkgInfoFromFolderPath(str2, null, paramMiniAppInfo);
            if (localApkgInfo == null) {
              continue;
            }
            QMLog.i("ApkgManager", "apkg has download in main process. folder:" + str2);
            MiniAppStartState.setApkgDownload(paramMiniAppInfo.appId, true);
            if (paramOnGetApkgInfoListener == null) {
              continue;
            }
            paramOnGetApkgInfoListener.onGetApkgInfo(localApkgInfo, 0, "加载成功");
          }
        }
        catch (Throwable localThrowable)
        {
          QMLog.e("ApkgManager", "", localThrowable);
        }
      }
    }
    loadApkgInfo(paramMiniAppInfo, paramBoolean, paramOnGetApkgInfoListener, str1);
  }
  
  public static String getGpkgPluginFolderPath(MiniGamePluginInfo paramMiniGamePluginInfo)
  {
    return ApkgManager.RootPath.getGamePkgRoot() + MD5Utils.toMD5(paramMiniGamePluginInfo.id) + "_plugin_" + paramMiniGamePluginInfo.version;
  }
  
  public static ApkgManager getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new ApkgManager();
      }
      return sInstance;
    }
    finally {}
  }
  
  public static String getPkgRoot(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo.isEngineTypeMiniGame()) {
      return ApkgManager.RootPath.getGamePkgRoot();
    }
    if (paramMiniAppInfo.launchParam.isFlutterMode) {
      return ApkgManager.RootPath.getTissuePkgRoot();
    }
    return ApkgManager.RootPath.getAppPkgRoot();
  }
  
  private String getSubPkgDownloadUrl(MiniAppInfo paramMiniAppInfo, String paramString)
  {
    paramMiniAppInfo = paramMiniAppInfo.subpkgs;
    if ((paramMiniAppInfo != null) && (paramMiniAppInfo.size() > 0) && (!TextUtils.isEmpty(paramString)))
    {
      paramMiniAppInfo = paramMiniAppInfo.iterator();
      while (paramMiniAppInfo.hasNext())
      {
        SubPkgInfo localSubPkgInfo = (SubPkgInfo)paramMiniAppInfo.next();
        if (paramString.equals(localSubPkgInfo.subPkgName)) {
          return localSubPkgInfo.downloadUrl;
        }
      }
    }
    return null;
  }
  
  private void handleApkgDownloadSuccess(String paramString1, String paramString2, MiniAppInfo paramMiniAppInfo, String paramString3, String paramString4, ApkgManager.OnGetApkgInfoListener paramOnGetApkgInfoListener)
  {
    boolean bool1 = false;
    int i = 0;
    MiniAppStartState.setApkgDownload(paramMiniAppInfo.appId, false);
    File localFile = new File(paramString1);
    boolean bool2 = paramMiniAppInfo.launchParam.isFlutterMode;
    if (paramMiniAppInfo.launchParam.isFlutterMode)
    {
      MiniReportManager.reportEventType(paramMiniAppInfo, 621, "0");
      bool1 = WxapkgUnpacker.unpackSync(localFile.getAbsolutePath(), paramString2);
      if (bool1)
      {
        MiniReportManager.reportEventType(paramMiniAppInfo, 622, null, null, null, i);
        label80:
        if ((!bool1) && (bool2)) {
          break label196;
        }
        handleDownloadSubPack(paramString2, paramMiniAppInfo, paramString3, paramString4, paramOnGetApkgInfoListener);
      }
    }
    label196:
    while (paramOnGetApkgInfoListener == null)
    {
      return;
      i = 1;
      break;
      if (!FileUtils.copyFile(paramString1, paramString2 + "/mini" + ".qapkg"))
      {
        QMLog.e("ApkgManager", "copyFile to " + paramString1 + paramString2 + "/mini" + ".qapkg" + " err");
        return;
      }
      FileUtils.deleteFile(paramString1);
      break label80;
    }
    paramOnGetApkgInfoListener.onGetApkgInfo(null, 3, "解包失败");
  }
  
  private void handleDownloadSubPack(String paramString1, MiniAppInfo paramMiniAppInfo, String paramString2, String paramString3, ApkgManager.OnGetApkgInfoListener paramOnGetApkgInfoListener)
  {
    Object localObject = null;
    try
    {
      paramString1 = ApkgInfo.loadApkgInfoFromFolderPath(paramString1, paramString3, paramMiniAppInfo);
      if ((paramString2 != null) && (paramString1 != null))
      {
        downloadSubPack(paramString1, paramMiniAppInfo, paramString2, new ApkgManager.3(this, paramOnGetApkgInfoListener));
        return;
      }
    }
    catch (Throwable paramString1)
    {
      do
      {
        for (;;)
        {
          QMLog.e("ApkgManager", "exception when loadApkgInfoFromFolderPath.", paramString1);
          paramString1 = localObject;
        }
      } while (paramOnGetApkgInfoListener == null);
      if (paramString1 != null)
      {
        paramOnGetApkgInfoListener.onGetApkgInfo(paramString1, 0, "");
        return;
      }
      paramOnGetApkgInfoListener.onGetApkgInfo(paramString1, 1, "apkginfo is null");
    }
  }
  
  private boolean isApkgInfoValid(ApkgInfo paramApkgInfo)
  {
    if (paramApkgInfo == null) {
      return false;
    }
    if (TextUtils.isEmpty(paramApkgInfo.mConfigStr))
    {
      QMLog.e("ApkgManager", "apkgInfo.mConfigStr is null!");
      return false;
    }
    return true;
  }
  
  private void loadApkgInfo(MiniAppInfo paramMiniAppInfo, boolean paramBoolean, ApkgManager.OnGetApkgInfoListener paramOnGetApkgInfoListener, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (new File(paramString).exists()) {}
    for (;;)
    {
      try
      {
        localObject1 = ApkgInfo.loadApkgInfoFromFolderPath(paramString, null, paramMiniAppInfo);
        boolean bool;
        QMLog.e("ApkgManager", "exception when loadApkgInfoFromFolderPath.", localThrowable1);
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          bool = isApkgInfoValid((ApkgInfo)localObject1);
          if (bool) {
            break label110;
          }
          localObject1 = localObject2;
          if (localObject1 == null) {
            break;
          }
          if (paramOnGetApkgInfoListener != null) {
            paramOnGetApkgInfoListener.onGetApkgInfo((ApkgInfo)localObject1, 0, "");
          }
          if (paramMiniAppInfo.launchParam == null) {
            break label113;
          }
          paramOnGetApkgInfoListener = paramMiniAppInfo.launchParam.entryPath;
          MiniAppReportManager2.reportPageView("cache_apkg_hit", "hit", paramOnGetApkgInfoListener, paramMiniAppInfo);
          return;
        }
        catch (Throwable localThrowable2)
        {
          break label100;
        }
        localThrowable1 = localThrowable1;
        localObject1 = null;
      }
      label100:
      label110:
      continue;
      label113:
      paramOnGetApkgInfoListener = "";
    }
    downloadApkgByResumableDownloader(paramMiniAppInfo, paramBoolean, paramOnGetApkgInfoListener, paramString);
    if (paramMiniAppInfo.launchParam != null) {}
    for (paramOnGetApkgInfoListener = paramMiniAppInfo.launchParam.entryPath;; paramOnGetApkgInfoListener = "")
    {
      MiniAppReportManager2.reportPageView("cache_apkg_hit", "unhit", paramOnGetApkgInfoListener, paramMiniAppInfo);
      return;
    }
  }
  
  private void onInitApkgInfo(ApkgManager.OnInitApkgListener paramOnInitApkgListener, int paramInt, ApkgInfo paramApkgInfo, String paramString)
  {
    QMLog.d("ApkgManager", "onInitApkgInfo :" + paramInt + "|" + paramString);
    if (paramOnInitApkgListener != null) {
      paramOnInitApkgListener.onInitApkgInfo(paramInt, paramApkgInfo, paramString);
    }
  }
  
  public static boolean pkgExists(MiniAppInfo paramMiniAppInfo)
  {
    return new File(getApkgFolderPath(paramMiniAppInfo)).exists();
  }
  
  public void downloadSubPack(ApkgInfo paramApkgInfo, MiniAppInfo paramMiniAppInfo, String paramString, ApkgManager.OnInitApkgListener paramOnInitApkgListener)
  {
    String str2;
    String str1;
    if ("/__APP__/".equals(paramString))
    {
      str2 = "";
      str1 = paramMiniAppInfo.downloadUrl;
      QMLog.d("ApkgManager", "downloadSubPack | downPage=" + paramString + "; subPackDownloadUrl=" + str1);
      if (!TextUtils.isEmpty(str1)) {
        break label119;
      }
      QMLog.e("ApkgManager", "subPackDownloadUrl is null, return.");
      if (paramOnInitApkgListener != null) {
        paramOnInitApkgListener.onInitApkgInfo(1, paramApkgInfo, null);
      }
    }
    label119:
    String str4;
    label248:
    do
    {
      do
      {
        return;
        if (paramApkgInfo == null)
        {
          QMLog.e("ApkgManager", "apkgInfo is null");
          return;
        }
        str2 = paramApkgInfo.getRootPath(paramString);
        str1 = getSubPkgDownloadUrl(paramMiniAppInfo, str2);
        break;
        String str3 = str2.replaceAll("/", "");
        str4 = getApkgFolderPath(paramMiniAppInfo) + File.separator + str3 + ".qapkg";
        boolean bool = paramMiniAppInfo.launchParam.isFlutterMode;
        if ((!new File(str4).exists()) || (bool)) {
          break label248;
        }
        QMLog.d("ApkgManager", "downloadSubPack | subRoot=" + str3 + " has downloaded. path=" + str4);
      } while (paramOnInitApkgListener == null);
      paramOnInitApkgListener.onInitApkgInfo(0, paramApkgInfo, null);
      return;
      if (!"/__APP__/".equals(paramString)) {
        break label273;
      }
    } while (paramOnInitApkgListener == null);
    paramOnInitApkgListener.onInitApkgInfo(0, paramApkgInfo, null);
    return;
    label273:
    doDownload(paramApkgInfo, paramMiniAppInfo, paramString, paramOnInitApkgListener, str1, str2, str4);
  }
  
  public void getApkgInfoByConfig(MiniAppInfo paramMiniAppInfo, ApkgManager.OnInitApkgListener paramOnInitApkgListener)
  {
    getApkgInfoByConfig(paramMiniAppInfo, true, paramOnInitApkgListener);
  }
  
  public void getApkgInfoByConfig(MiniAppInfo paramMiniAppInfo, boolean paramBoolean, ApkgManager.OnInitApkgListener paramOnInitApkgListener)
  {
    long l = System.currentTimeMillis();
    MiniReportManager.reportEventType(paramMiniAppInfo, 12, null, null, null, 0);
    getApkgInfoByConfig(paramMiniAppInfo, paramBoolean, new ApkgManager.1(this, paramOnInitApkgListener, l, paramMiniAppInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.ApkgManager
 * JD-Core Version:    0.7.0.1
 */