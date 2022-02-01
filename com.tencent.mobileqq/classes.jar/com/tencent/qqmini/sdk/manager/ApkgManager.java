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
  public static volatile long downloadDuration;
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
    Object localObject2 = paramMiniAppInfo.firstPage;
    Object localObject1 = null;
    Object localObject3 = null;
    if (localObject2 != null)
    {
      localObject2 = paramMiniAppInfo.firstPage.subPkgName;
      localObject4 = paramMiniAppInfo.subpkgs.iterator();
      for (localObject1 = null; ((Iterator)localObject4).hasNext(); localObject1 = paramMiniAppInfo.firstPage.pagePath)
      {
        label40:
        SubPkgInfo localSubPkgInfo = (SubPkgInfo)((Iterator)localObject4).next();
        if ((localSubPkgInfo == null) || (localSubPkgInfo.subPkgName == null) || (!localSubPkgInfo.subPkgName.equals(localObject2))) {
          break label40;
        }
        if (localSubPkgInfo.independent == 1)
        {
          localObject3 = localSubPkgInfo.downloadUrl;
          break label122;
        }
      }
      localObject2 = null;
      label122:
      localObject4 = localObject1;
      localObject1 = localObject3;
      localObject3 = localObject4;
    }
    else
    {
      localObject3 = null;
      localObject2 = localObject3;
    }
    Object localObject4 = localObject1;
    if (localObject1 == null) {
      localObject4 = paramMiniAppInfo.downloadUrl;
    }
    downloadApkgByResumableDownloader(paramMiniAppInfo, paramBoolean, paramOnGetApkgInfoListener, paramString, (String)localObject4, (String)localObject3, (String)localObject2);
  }
  
  private void downloadApkgByResumableDownloader(MiniAppInfo paramMiniAppInfo, boolean paramBoolean, ApkgManager.OnGetApkgInfoListener paramOnGetApkgInfoListener, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(ApkgManager.RootPath.getAppPkgRoot());
    ((StringBuilder)localObject).append(paramMiniAppInfo.appId);
    ((StringBuilder)localObject).append('_');
    ((StringBuilder)localObject).append(paramMiniAppInfo.version);
    ((StringBuilder)localObject).append(".qapkg");
    localObject = ((StringBuilder)localObject).toString();
    long l = System.currentTimeMillis();
    if (TextUtils.isEmpty(paramString2))
    {
      if (paramOnGetApkgInfoListener != null)
      {
        paramOnGetApkgInfoListener.onGetApkgInfo(null, 1, "apkUrl is Null!");
        QMLog.e("ApkgManager", "downloadApkgByResumableDownloader apkUrl is null!");
      }
      return;
    }
    MiniReportManager.reportEventType(paramMiniAppInfo, 619, "0");
    ((DownloaderProxy)ProxyManager.get(DownloaderProxy.class)).download(paramString2, null, (String)localObject, 60, new ApkgManager.2(this, paramOnGetApkgInfoListener, paramMiniAppInfo, paramString2, paramString1, (String)localObject, paramString3, paramString4, l));
    if (paramBoolean)
    {
      deleteOldPkg(paramMiniAppInfo, paramString1);
      return;
    }
  }
  
  public static String getApkgFolderPath(MiniAppInfo paramMiniAppInfo)
  {
    if ((paramMiniAppInfo != null) && (!TextUtils.isEmpty(paramMiniAppInfo.appId)))
    {
      if (paramMiniAppInfo.verType == 3)
      {
        localStringBuilder = new StringBuilder(getPkgRoot(paramMiniAppInfo));
        localStringBuilder.append(MD5Utils.toMD5(paramMiniAppInfo.appId));
        localStringBuilder.append("_");
        localStringBuilder.append(paramMiniAppInfo.versionId);
        return localStringBuilder.toString();
      }
      StringBuilder localStringBuilder = new StringBuilder(getPkgRoot(paramMiniAppInfo));
      localStringBuilder.append(paramMiniAppInfo.appId);
      localStringBuilder.append("_debug");
      return localStringBuilder.toString();
    }
    return "";
  }
  
  private void getApkgInfoByConfig(MiniAppInfo paramMiniAppInfo, boolean paramBoolean, ApkgManager.OnGetApkgInfoListener paramOnGetApkgInfoListener)
  {
    if (paramMiniAppInfo == null) {
      return;
    }
    String str = paramMiniAppInfo.version;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getApkgInfoByConfig version:");
    ((StringBuilder)localObject).append(str);
    QMLog.d("ApkgManager", ((StringBuilder)localObject).toString());
    str = getApkgFolderPath(paramMiniAppInfo);
    if (paramMiniAppInfo.verType != 3)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("verType is not online, delete unPackFolderPath.");
      ((StringBuilder)localObject).append(paramMiniAppInfo.verType);
      QMLog.d("ApkgManager", ((StringBuilder)localObject).toString());
      if (new File(str).exists()) {
        FileUtils.delete(str, false);
      }
    }
    if (paramMiniAppInfo.launchParam.isFlutterMode) {
      try
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append("_maintmp");
        localObject = ((StringBuilder)localObject).toString();
        if (new File((String)localObject).exists())
        {
          ApkgInfo localApkgInfo = ApkgInfo.loadApkgInfoFromFolderPath((String)localObject, null, paramMiniAppInfo);
          if (localApkgInfo != null)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("apkg has download in main process. folder:");
            localStringBuilder.append((String)localObject);
            QMLog.i("ApkgManager", localStringBuilder.toString());
            MiniAppStartState.setApkgDownload(paramMiniAppInfo.appId, true);
            if (paramOnGetApkgInfoListener != null) {
              paramOnGetApkgInfoListener.onGetApkgInfo(localApkgInfo, 0, "加载成功");
            }
          }
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("ApkgManager", "", localThrowable);
      }
    }
    loadApkgInfo(paramMiniAppInfo, paramBoolean, paramOnGetApkgInfoListener, str);
  }
  
  public static String getGpkgPluginFolderPath(MiniGamePluginInfo paramMiniGamePluginInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ApkgManager.RootPath.getGamePkgRoot());
    localStringBuilder.append(MD5Utils.toMD5(paramMiniGamePluginInfo.id));
    localStringBuilder.append("_plugin_");
    localStringBuilder.append(paramMiniGamePluginInfo.version);
    return localStringBuilder.toString();
  }
  
  public static ApkgManager getInstance()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new ApkgManager();
        }
      }
      finally {}
    }
    return sInstance;
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
    Object localObject = paramMiniAppInfo.appId;
    boolean bool1 = false;
    MiniAppStartState.setApkgDownload((String)localObject, false);
    localObject = new File(paramString1);
    boolean bool2 = paramMiniAppInfo.launchParam.isFlutterMode;
    if (paramMiniAppInfo.launchParam.isFlutterMode)
    {
      MiniReportManager.reportEventType(paramMiniAppInfo, 621, "0");
      bool1 = WxapkgUnpacker.unpackSync(((File)localObject).getAbsolutePath(), paramString2);
      MiniReportManager.reportEventType(paramMiniAppInfo, 622, null, null, null, bool1 ^ true);
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append("/mini");
      ((StringBuilder)localObject).append(".qapkg");
      if (!FileUtils.copyFile(paramString1, ((StringBuilder)localObject).toString()))
      {
        paramMiniAppInfo = new StringBuilder();
        paramMiniAppInfo.append("copyFile to ");
        paramMiniAppInfo.append(paramString1);
        paramMiniAppInfo.append(paramString2);
        paramMiniAppInfo.append("/mini");
        paramMiniAppInfo.append(".qapkg");
        paramMiniAppInfo.append(" err");
        QMLog.e("ApkgManager", paramMiniAppInfo.toString());
        return;
      }
      FileUtils.deleteFile(paramString1);
    }
    if ((!bool1) && (bool2))
    {
      if (paramOnGetApkgInfoListener != null) {
        paramOnGetApkgInfoListener.onGetApkgInfo(null, 3, "解包失败");
      }
    }
    else {
      handleDownloadSubPack(paramString2, paramMiniAppInfo, paramString3, paramString4, paramOnGetApkgInfoListener);
    }
  }
  
  private void handleDownloadSubPack(String paramString1, MiniAppInfo paramMiniAppInfo, String paramString2, String paramString3, ApkgManager.OnGetApkgInfoListener paramOnGetApkgInfoListener)
  {
    try
    {
      paramString1 = ApkgInfo.loadApkgInfoFromFolderPath(paramString1, paramString3, paramMiniAppInfo);
    }
    catch (Throwable paramString1)
    {
      QMLog.e("ApkgManager", "exception when loadApkgInfoFromFolderPath.", paramString1);
      paramString1 = null;
    }
    if ((paramString2 != null) && (paramString1 != null))
    {
      downloadSubPack(paramString1, paramMiniAppInfo, paramString2, new ApkgManager.3(this, paramOnGetApkgInfoListener));
      return;
    }
    if (paramOnGetApkgInfoListener != null)
    {
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
    boolean bool = new File(paramString).exists();
    Object localObject4 = null;
    Object localObject2 = null;
    Object localObject1 = localObject4;
    if (bool) {
      try
      {
        localObject1 = ApkgInfo.loadApkgInfoFromFolderPath(paramString, null, paramMiniAppInfo);
        try
        {
          bool = isApkgInfoValid((ApkgInfo)localObject1);
          if (!bool)
          {
            localObject1 = localObject4;
            break label86;
          }
        }
        catch (Throwable localThrowable1) {}
        QMLog.e("ApkgManager", "exception when loadApkgInfoFromFolderPath.", (Throwable)localObject3);
      }
      catch (Throwable localThrowable2)
      {
        localObject1 = localThrowable1;
        localObject3 = localThrowable2;
      }
    }
    label86:
    Object localObject3 = "";
    if (localObject1 != null)
    {
      if (paramOnGetApkgInfoListener != null) {
        paramOnGetApkgInfoListener.onGetApkgInfo((ApkgInfo)localObject1, 0, "");
      }
      if (paramMiniAppInfo.launchParam != null) {
        localObject3 = paramMiniAppInfo.launchParam.entryPath;
      }
      MiniAppReportManager2.reportPageView("cache_apkg_hit", "hit", (String)localObject3, paramMiniAppInfo);
      return;
    }
    downloadApkgByResumableDownloader(paramMiniAppInfo, paramBoolean, paramOnGetApkgInfoListener, paramString);
    if (paramMiniAppInfo.launchParam != null) {
      localObject3 = paramMiniAppInfo.launchParam.entryPath;
    }
    MiniAppReportManager2.reportPageView("cache_apkg_hit", "unhit", (String)localObject3, paramMiniAppInfo);
  }
  
  private void onInitApkgInfo(ApkgManager.OnInitApkgListener paramOnInitApkgListener, int paramInt, ApkgInfo paramApkgInfo, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onInitApkgInfo :");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString);
    QMLog.d("ApkgManager", localStringBuilder.toString());
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
    String str1;
    String str2;
    if ("/__APP__/".equals(paramString))
    {
      str1 = paramMiniAppInfo.downloadUrl;
      str2 = "";
    }
    else
    {
      if (paramApkgInfo == null)
      {
        QMLog.e("ApkgManager", "apkgInfo is null");
        return;
      }
      str2 = paramApkgInfo.getRootPath(paramString);
      str1 = getSubPkgDownloadUrl(paramMiniAppInfo, str2);
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("downloadSubPack | downPage=");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append("; subPackDownloadUrl=");
    ((StringBuilder)localObject1).append(str1);
    QMLog.d("ApkgManager", ((StringBuilder)localObject1).toString());
    if (TextUtils.isEmpty(str1))
    {
      QMLog.e("ApkgManager", "subPackDownloadUrl is null, return.");
      if (paramOnInitApkgListener != null) {
        paramOnInitApkgListener.onInitApkgInfo(5, paramApkgInfo, null);
      }
      return;
    }
    localObject1 = str2.replaceAll("/", "");
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(getApkgFolderPath(paramMiniAppInfo));
    ((StringBuilder)localObject2).append(File.separator);
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(".qapkg");
    localObject2 = ((StringBuilder)localObject2).toString();
    boolean bool = paramMiniAppInfo.launchParam.isFlutterMode;
    if ((new File((String)localObject2).exists()) && (!bool))
    {
      paramMiniAppInfo = new StringBuilder();
      paramMiniAppInfo.append("downloadSubPack | subRoot=");
      paramMiniAppInfo.append((String)localObject1);
      paramMiniAppInfo.append(" has downloaded. path=");
      paramMiniAppInfo.append((String)localObject2);
      QMLog.d("ApkgManager", paramMiniAppInfo.toString());
      if (paramOnInitApkgListener != null) {
        paramOnInitApkgListener.onInitApkgInfo(0, paramApkgInfo, null);
      }
      return;
    }
    if ("/__APP__/".equals(paramString))
    {
      if (paramOnInitApkgListener != null) {
        paramOnInitApkgListener.onInitApkgInfo(0, paramApkgInfo, null);
      }
      return;
    }
    doDownload(paramApkgInfo, paramMiniAppInfo, paramString, paramOnInitApkgListener, str1, str2, (String)localObject2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.ApkgManager
 * JD-Core Version:    0.7.0.1
 */