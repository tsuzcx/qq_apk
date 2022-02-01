package com.tencent.mobileqq.mini.apkg;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.downloader.Downloader.DownloadMode;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.launch.MiniSdkLauncher;
import com.tencent.mobileqq.mini.report.MiniAppReportManager2;
import com.tencent.mobileqq.mini.report.MiniAppStartState;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.mini.reuse.MiniappDownloadUtil;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.utils.FileUtils;
import com.tencent.mobileqq.mini.utils.WxapkgUnpacker;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.utils.MD5Utils;
import java.io.File;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.request.Ticket;
import org.json.JSONObject;

public class ApkgManager
{
  public static final String MINI_APP_MAIN_PKG = "/__APP__/";
  public static final String MINI_GAME_PERSISTENT_SP_KEY = "persistent";
  public static final String MINI_GAME_PERSISTENT_SP_NAME = "persistent_debug_version_";
  public static final String PATH_APKG_TISSUE_ROOT;
  public static final String PATH_GAMEPKG_ROOT;
  public static final String PATH_WXAPKG_ROOT;
  public static final String SUFFIX_WXAPKG = ".qapkg";
  private static final String TAG = "ApkgManager";
  public static volatile long downloadDuration;
  private static volatile ApkgManager sInstance;
  private String subRoot = "";
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplicationImpl.getApplication().getFilesDir().getPath());
    localStringBuilder.append("/minigame/");
    PATH_GAMEPKG_ROOT = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplicationImpl.getApplication().getFilesDir().getPath());
    localStringBuilder.append("/mini/");
    PATH_WXAPKG_ROOT = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplicationImpl.getApplication().getFilesDir().getPath());
    localStringBuilder.append("/mini_tissue/");
    PATH_APKG_TISSUE_ROOT = localStringBuilder.toString();
  }
  
  private void deleteOldPkg(MiniAppConfig paramMiniAppConfig, String paramString)
  {
    ThreadManagerV2.executeOnFileThread(new ApkgManager.4(this, paramMiniAppConfig, paramString));
  }
  
  private void downloadApkgByResumableDownloader(MiniAppConfig paramMiniAppConfig, boolean paramBoolean, ApkgManager.OnGetApkgInfoListener paramOnGetApkgInfoListener, String paramString)
  {
    Object localObject2 = paramMiniAppConfig.config.firstPage;
    Object localObject1 = null;
    Object localObject3 = null;
    if (localObject2 != null)
    {
      localObject2 = paramMiniAppConfig.config.firstPage.subPkgName;
      localObject4 = paramMiniAppConfig.config.subpkgs.iterator();
      for (localObject1 = null; ((Iterator)localObject4).hasNext(); localObject1 = paramMiniAppConfig.config.firstPage.pagePath)
      {
        label49:
        SubPkgInfo localSubPkgInfo = (SubPkgInfo)((Iterator)localObject4).next();
        if ((localSubPkgInfo == null) || (localSubPkgInfo.subPkgName == null) || (!((String)localObject2).equals(localSubPkgInfo.subPkgName))) {
          break label49;
        }
        if (localSubPkgInfo.independent == 1)
        {
          localObject3 = localSubPkgInfo.downloadUrl;
          break label134;
        }
      }
      localObject2 = null;
      label134:
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
      localObject4 = paramMiniAppConfig.config.downloadUrl;
    }
    downloadApkgByResumableDownloader(paramMiniAppConfig, paramBoolean, paramOnGetApkgInfoListener, paramString, (String)localObject4, (String)localObject3, (String)localObject2);
  }
  
  private void downloadApkgByResumableDownloader(MiniAppConfig paramMiniAppConfig, boolean paramBoolean, ApkgManager.OnGetApkgInfoListener paramOnGetApkgInfoListener, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(PATH_WXAPKG_ROOT);
    ((StringBuilder)localObject).append(paramMiniAppConfig.config.appId);
    ((StringBuilder)localObject).append('_');
    ((StringBuilder)localObject).append(paramMiniAppConfig.config.version);
    ((StringBuilder)localObject).append(".qapkg");
    localObject = ((StringBuilder)localObject).toString();
    long l = System.currentTimeMillis();
    if (TextUtils.isEmpty(paramString2))
    {
      if (paramOnGetApkgInfoListener != null)
      {
        paramOnGetApkgInfoListener.onGetApkgInfo(null, 1, "apkUrl is Null!");
        QLog.e("ApkgManager", 1, "downloadApkgByResumableDownloader apkUrl is null!");
      }
      return;
    }
    MiniReportManager.reportEventType(paramMiniAppConfig, 619, "0");
    MiniappDownloadUtil.getInstance().downloadApkg(paramMiniAppConfig, false, paramString2, (String)localObject, true, new ApkgManager.6(this, paramOnGetApkgInfoListener, paramMiniAppConfig, (String)localObject, paramString1, paramString3, paramString4, l), Downloader.DownloadMode.StrictMode, -1, 0L, getHeader(paramString2, paramMiniAppConfig), new ApkgManager.7(this, paramOnGetApkgInfoListener));
    if (paramBoolean) {
      deleteOldPkg(paramMiniAppConfig, paramString1);
    }
  }
  
  public static String getApkgFolderPath(MiniAppInfo paramMiniAppInfo)
  {
    if ((paramMiniAppInfo != null) && (!TextUtils.isEmpty(paramMiniAppInfo.appId)))
    {
      if ((paramMiniAppInfo.isEngineTypeMiniGame()) && (GameWnsUtils.enablePersistentDebugVersion()))
      {
        localObject = BaseApplicationImpl.getApplication();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("persistent_debug_version_");
        localStringBuilder.append(BaseApplicationImpl.getApplication().getRuntime().getAccount());
        if (((BaseApplicationImpl)localObject).getSharedPreferences(localStringBuilder.toString(), 4).getBoolean("persistent", false))
        {
          localObject = new StringBuilder(getPkgRoot(paramMiniAppInfo));
          ((StringBuilder)localObject).append(paramMiniAppInfo.appId);
          ((StringBuilder)localObject).append("_debug");
          localObject = ((StringBuilder)localObject).toString();
          if (new File((String)localObject).exists()) {
            return localObject;
          }
        }
      }
      if (paramMiniAppInfo.verType == 3)
      {
        localObject = new StringBuilder(getPkgRoot(paramMiniAppInfo));
        ((StringBuilder)localObject).append(MD5.toMD5(paramMiniAppInfo.appId));
        ((StringBuilder)localObject).append("_");
        ((StringBuilder)localObject).append(paramMiniAppInfo.versionId);
        return ((StringBuilder)localObject).toString();
      }
      Object localObject = new StringBuilder(getPkgRoot(paramMiniAppInfo));
      ((StringBuilder)localObject).append(paramMiniAppInfo.appId);
      ((StringBuilder)localObject).append("_debug");
      return ((StringBuilder)localObject).toString();
    }
    return "";
  }
  
  private void getApkgInfoByConfig(MiniAppConfig paramMiniAppConfig, boolean paramBoolean, ApkgManager.OnGetApkgInfoListener paramOnGetApkgInfoListener)
  {
    if (paramMiniAppConfig != null)
    {
      if (paramMiniAppConfig.config == null) {
        return;
      }
      Object localObject1 = paramMiniAppConfig.config.version;
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getApkgInfoByConfig version:");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("ApkgManager", 2, ((StringBuilder)localObject2).toString());
      }
      String str = getApkgFolderPath(paramMiniAppConfig.config);
      if (paramMiniAppConfig.config.verType != 3)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("verType is not online, delete unPackFolderPath.");
        ((StringBuilder)localObject1).append(paramMiniAppConfig.config.verType);
        QLog.d("ApkgManager", 1, ((StringBuilder)localObject1).toString());
        if (new File(str).exists()) {
          FileUtils.delete(str, false);
        }
      }
      boolean bool = new File(str).exists();
      localObject1 = "";
      if (bool)
      {
        localObject2 = null;
        try
        {
          ApkgInfo localApkgInfo = ApkgInfo.loadApkgInfoFromFolderPath(str, null, paramMiniAppConfig);
          localObject2 = localApkgInfo;
        }
        catch (Throwable localThrowable)
        {
          QLog.e("ApkgManager", 1, "loadApkgInfoFromFolderPath exception!", localThrowable);
        }
        if (localObject2 != null)
        {
          if (paramOnGetApkgInfoListener != null) {
            paramOnGetApkgInfoListener.onGetApkgInfo((ApkgInfo)localObject2, 0, "");
          }
          if (paramMiniAppConfig.launchParam != null) {
            localObject1 = paramMiniAppConfig.launchParam.entryPath;
          }
          MiniAppReportManager2.reportPageView("cache_apkg_hit", "hit", (String)localObject1, paramMiniAppConfig);
          MiniAppStartState.setApkgDownload(paramMiniAppConfig.config.appId, true);
          return;
        }
        FileUtils.delete(str, false);
      }
      downloadApkgByResumableDownloader(paramMiniAppConfig, paramBoolean, paramOnGetApkgInfoListener, str);
      if (paramMiniAppConfig.launchParam != null) {
        localObject1 = paramMiniAppConfig.launchParam.entryPath;
      }
      MiniAppReportManager2.reportPageView("cache_apkg_hit", "unhit", (String)localObject1, paramMiniAppConfig);
      MiniAppStartState.setApkgDownload(paramMiniAppConfig.config.appId, false);
    }
  }
  
  @NonNull
  public static String getGpkgPluginFolderPath(@NonNull MiniGamePluginInfo paramMiniGamePluginInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(PATH_GAMEPKG_ROOT);
    localStringBuilder.append(MD5.toMD5(paramMiniGamePluginInfo.id));
    localStringBuilder.append("_plugin_");
    localStringBuilder.append(paramMiniGamePluginInfo.version);
    return localStringBuilder.toString();
  }
  
  public static JSONObject getHeader(String paramString, MiniAppConfig paramMiniAppConfig)
  {
    if ((paramMiniAppConfig.config.verType != 3) && (!TextUtils.isEmpty(paramString)))
    {
      paramMiniAppConfig = new JSONObject();
      try
      {
        if (!new URL(paramString).getHost().contains(".qq.com")) {
          return null;
        }
        paramString = BaseApplicationImpl.getApplication().getRuntime().getAccount();
        localObject = getSKey();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("uin=");
        localStringBuilder.append("o");
        localStringBuilder.append(paramString);
        localStringBuilder.append(";");
        localStringBuilder.append("skey=");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(";");
        paramMiniAppConfig.put("cookie", localStringBuilder.toString());
        return paramMiniAppConfig;
      }
      catch (Exception paramString)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getHeader error. ");
        ((StringBuilder)localObject).append(paramString);
        QLog.e("ApkgManager", 1, ((StringBuilder)localObject).toString());
        return paramMiniAppConfig;
      }
    }
    return null;
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
      return PATH_GAMEPKG_ROOT;
    }
    return PATH_WXAPKG_ROOT;
  }
  
  private static String getSKey()
  {
    Object localObject2 = BaseApplicationImpl.getApplication().getRuntime();
    String str = "";
    if (localObject2 == null) {
      return "";
    }
    TicketManager localTicketManager = (TicketManager)((AppRuntime)localObject2).getManager(2);
    Object localObject1 = str;
    if (localTicketManager != null)
    {
      localObject2 = localTicketManager.getSkey(((AppRuntime)localObject2).getAccount(), 16L, null);
      localObject1 = str;
      if (localObject2 != null)
      {
        localObject1 = str;
        if (((Ticket)localObject2)._sig != null)
        {
          str = new String(((Ticket)localObject2)._sig);
          localObject1 = str;
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("get skey sucess.: ");
            ((StringBuilder)localObject1).append(str);
            QLog.i("ApkgManager", 2, ((StringBuilder)localObject1).toString());
            localObject1 = str;
          }
        }
      }
    }
    return localObject1;
  }
  
  private String getSubPkgDownloadUrl(ApkgInfo paramApkgInfo, String paramString)
  {
    paramApkgInfo = paramApkgInfo.appConfig.config.subpkgs;
    if ((paramApkgInfo != null) && (paramApkgInfo.size() > 0) && (!TextUtils.isEmpty(paramString)))
    {
      paramApkgInfo = paramApkgInfo.iterator();
      while (paramApkgInfo.hasNext())
      {
        SubPkgInfo localSubPkgInfo = (SubPkgInfo)paramApkgInfo.next();
        if (paramString.equals(localSubPkgInfo.subPkgName)) {
          return localSubPkgInfo.downloadUrl;
        }
      }
    }
    return null;
  }
  
  private void handleApkgDownloadSuccess(String paramString1, String paramString2, MiniAppConfig paramMiniAppConfig, String paramString3, String paramString4, ApkgManager.OnGetApkgInfoListener paramOnGetApkgInfoListener)
  {
    MiniReportManager.reportEventType(paramMiniAppConfig, 621, "0");
    boolean bool = WxapkgUnpacker.unpackSync(new File(paramString1).getAbsolutePath(), paramString2);
    MiniReportManager.reportEventType(paramMiniAppConfig, 622, null, null, null, bool ^ true);
    if (bool)
    {
      paramString1 = ApkgInfo.loadApkgInfoFromFolderPath(paramString2, paramString4, paramMiniAppConfig);
      if ((paramString3 != null) && (paramString1 != null))
      {
        downloadSubPack(paramString1, paramString3, new ApkgManager.3(this, paramOnGetApkgInfoListener));
        return;
      }
      if (paramOnGetApkgInfoListener != null) {
        paramOnGetApkgInfoListener.onGetApkgInfo(paramString1, 0, "");
      }
    }
    else if (paramOnGetApkgInfoListener != null)
    {
      paramOnGetApkgInfoListener.onGetApkgInfo(null, 3, HardCodeUtil.a(2131700508));
    }
  }
  
  private void onInitApkgInfo(ApkgManager.OnInitApkgListener paramOnInitApkgListener, int paramInt, ApkgInfo paramApkgInfo, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onInitApkgInfo :");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("|");
      localStringBuilder.append(paramString);
      QLog.d("ApkgManager", 2, localStringBuilder.toString());
    }
    if (paramOnInitApkgListener != null) {
      paramOnInitApkgListener.onInitApkgInfo(paramInt, paramApkgInfo, paramString);
    }
  }
  
  public static boolean pkgExists(MiniAppInfo paramMiniAppInfo)
  {
    return new File(getApkgFolderPath(paramMiniAppInfo)).exists();
  }
  
  public void downloadSubPack(ApkgInfo paramApkgInfo, String paramString, ApkgManager.OnInitApkgListener paramOnInitApkgListener)
  {
    Object localObject = getApkgFolderPath(paramApkgInfo.appConfig.config);
    String str;
    if ("/__APP__/".equals(paramString))
    {
      this.subRoot = "";
      str = paramApkgInfo.appConfig.config.downloadUrl;
    }
    else
    {
      this.subRoot = paramApkgInfo.getRootPath(paramString);
      str = getSubPkgDownloadUrl(paramApkgInfo, this.subRoot);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("downloadSubPack | downPage=");
    localStringBuilder.append(paramString);
    localStringBuilder.append("; subPackDownloadUrl=");
    localStringBuilder.append(str);
    QLog.d("ApkgManager", 1, localStringBuilder.toString());
    if (TextUtils.isEmpty(str))
    {
      QLog.e("ApkgManager", 1, "subPackDownloadUrl is null, return.");
      if (paramOnInitApkgListener != null) {
        paramOnInitApkgListener.onInitApkgInfo(1, paramApkgInfo, null);
      }
      return;
    }
    if ((!"/__APP__/".equals(paramString)) && (new File((String)localObject, this.subRoot).exists()))
    {
      if (paramOnInitApkgListener != null) {
        paramOnInitApkgListener.onInitApkgInfo(0, paramApkgInfo, null);
      }
      return;
    }
    if (!TextUtils.isEmpty(str))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PATH_WXAPKG_ROOT);
      ((StringBuilder)localObject).append(paramApkgInfo.appConfig.config.appId);
      ((StringBuilder)localObject).append('_');
      ((StringBuilder)localObject).append(paramApkgInfo.appConfig.config.version);
      ((StringBuilder)localObject).append(".qapkg");
      localObject = ((StringBuilder)localObject).toString();
      MiniReportManager.reportEventType(paramApkgInfo.appConfig, 613, paramString, null, null, 0, "0", 0L, null);
      MiniappDownloadUtil.getInstance().downloadApkg(paramApkgInfo.appConfig, true, str, (String)localObject, true, new ApkgManager.5(this, paramOnInitApkgListener, paramApkgInfo, paramString, (String)localObject), Downloader.DownloadMode.StrictMode, getHeader(str, paramApkgInfo.appConfig));
      return;
    }
    paramOnInitApkgListener.onInitApkgInfo(1, paramApkgInfo, null);
  }
  
  public void getApkgInfoByConfig(MiniAppConfig paramMiniAppConfig, ApkgManager.OnInitApkgListener paramOnInitApkgListener)
  {
    getApkgInfoByConfig(paramMiniAppConfig, true, paramOnInitApkgListener, null);
  }
  
  public void getApkgInfoByConfig(MiniAppConfig paramMiniAppConfig, ApkgManager.OnInitApkgListener paramOnInitApkgListener, ApkgManager.OnFakeApkgListener paramOnFakeApkgListener)
  {
    getApkgInfoByConfig(paramMiniAppConfig, true, paramOnInitApkgListener, paramOnFakeApkgListener);
  }
  
  public void getApkgInfoByConfig(MiniAppConfig paramMiniAppConfig, boolean paramBoolean, ApkgManager.OnInitApkgListener paramOnInitApkgListener, ApkgManager.OnFakeApkgListener paramOnFakeApkgListener)
  {
    long l = System.currentTimeMillis();
    MiniReportManager.reportEventType(paramMiniAppConfig, 12, null, null, null, 0);
    if (paramOnFakeApkgListener != null) {
      MiniReportManager.reportEventType(paramMiniAppConfig, 124, null, null, null, 0);
    }
    getApkgInfoByConfig(paramMiniAppConfig, paramBoolean, new ApkgManager.1(this, paramOnInitApkgListener, l, paramMiniAppConfig, paramOnFakeApkgListener));
  }
  
  public void initApkgByConfig(MiniAppConfig paramMiniAppConfig, ApkgManager.OnInitApkgListener paramOnInitApkgListener)
  {
    getApkgInfoByConfig(paramMiniAppConfig, paramOnInitApkgListener);
  }
  
  public void preloadFlutterPkg(MiniAppConfig paramMiniAppConfig, String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("preloadFlutterPkg appid:");
    ((StringBuilder)localObject1).append(paramMiniAppConfig.config.appId);
    ((StringBuilder)localObject1).append(" name:");
    ((StringBuilder)localObject1).append(paramMiniAppConfig.config.name);
    ((StringBuilder)localObject1).append(" url:");
    ((StringBuilder)localObject1).append(paramString);
    QLog.i("ApkgManager", 1, ((StringBuilder)localObject1).toString());
    localObject1 = MiniSdkLauncher.convert(paramMiniAppConfig.config);
    StringBuilder localStringBuilder;
    if (((com.tencent.qqmini.sdk.launcher.model.MiniAppInfo)localObject1).verType == 3)
    {
      localObject2 = new StringBuilder();
      localStringBuilder = new StringBuilder(PATH_APKG_TISSUE_ROOT);
      localStringBuilder.append(MD5Utils.toMD5(((com.tencent.qqmini.sdk.launcher.model.MiniAppInfo)localObject1).appId));
      localStringBuilder.append("_");
      localStringBuilder.append(((com.tencent.qqmini.sdk.launcher.model.MiniAppInfo)localObject1).version);
      ((StringBuilder)localObject2).append(localStringBuilder.toString());
      ((StringBuilder)localObject2).append("_maintmp");
      localObject1 = ((StringBuilder)localObject2).toString();
    }
    else
    {
      localObject2 = new StringBuilder();
      localStringBuilder = new StringBuilder(PATH_APKG_TISSUE_ROOT);
      localStringBuilder.append(((com.tencent.qqmini.sdk.launcher.model.MiniAppInfo)localObject1).appId);
      localStringBuilder.append("_debug");
      ((StringBuilder)localObject2).append(localStringBuilder.toString());
      ((StringBuilder)localObject2).append("_maintmp");
      localObject1 = ((StringBuilder)localObject2).toString();
    }
    if (new File((String)localObject1).exists()) {
      return;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(PATH_WXAPKG_ROOT);
    ((StringBuilder)localObject2).append(paramMiniAppConfig.config.appId);
    ((StringBuilder)localObject2).append('_');
    ((StringBuilder)localObject2).append(paramMiniAppConfig.config.version);
    ((StringBuilder)localObject2).append("_flutter1");
    ((StringBuilder)localObject2).append(".qapkg");
    localObject2 = ((StringBuilder)localObject2).toString();
    MiniappDownloadUtil.getInstance().downloadApkg(paramMiniAppConfig, false, paramString, (String)localObject2, true, new ApkgManager.2(this, paramMiniAppConfig, (String)localObject2, (String)localObject1), Downloader.DownloadMode.StrictMode, getHeader(paramString, paramMiniAppConfig));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.ApkgManager
 * JD-Core Version:    0.7.0.1
 */