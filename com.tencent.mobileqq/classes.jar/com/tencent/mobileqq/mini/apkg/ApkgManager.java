package com.tencent.mobileqq.mini.apkg;

import ajjy;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import bdyv;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.downloader.Downloader.DownloadMode;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.app.AppLoaderFactory;
import com.tencent.mobileqq.mini.app.BaseAppLoaderManager;
import com.tencent.mobileqq.mini.appbrand.utils.JSUtil;
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
  public static final String PATH_APKG_TISSUE_ROOT = BaseApplicationImpl.getApplication().getFilesDir().getPath() + "/mini_tissue/";
  public static final String PATH_GAMEPKG_ROOT = BaseApplicationImpl.getApplication().getFilesDir().getPath() + "/minigame/";
  public static final String PATH_WXAPKG_ROOT = BaseApplicationImpl.getApplication().getFilesDir().getPath() + "/mini/";
  public static final String SUFFIX_WXAPKG = ".qapkg";
  private static final String TAG = "ApkgManager";
  public static volatile long downloadDuration;
  private static volatile ApkgManager sInstance;
  private String basePageFrameStr;
  private String subRoot = "";
  
  private void deleteOldPkg(MiniAppConfig paramMiniAppConfig, String paramString)
  {
    ThreadManagerV2.executeOnFileThread(new ApkgManager.4(this, paramMiniAppConfig, paramString));
  }
  
  private void downloadApkgByResumableDownloader(MiniAppConfig paramMiniAppConfig, boolean paramBoolean, ApkgManager.OnGetApkgInfoListener paramOnGetApkgInfoListener, String paramString)
  {
    String str;
    Object localObject2;
    Object localObject1;
    Object localObject3;
    if (paramMiniAppConfig.config.firstPage != null)
    {
      str = paramMiniAppConfig.config.firstPage.subPkgName;
      localObject2 = paramMiniAppConfig.config.subpkgs.iterator();
      localObject1 = null;
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (SubPkgInfo)((Iterator)localObject2).next();
        if ((localObject3 != null) && (((SubPkgInfo)localObject3).subPkgName != null) && (str.equals(((SubPkgInfo)localObject3).subPkgName))) {
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
        localObject3 = paramMiniAppConfig.config.downloadUrl;
      }
      downloadApkgByResumableDownloader(paramMiniAppConfig, paramBoolean, paramOnGetApkgInfoListener, paramString, (String)localObject3, (String)localObject2, str);
      return;
      localObject1 = paramMiniAppConfig.config.firstPage.pagePath;
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
  
  private void downloadApkgByResumableDownloader(MiniAppConfig paramMiniAppConfig, boolean paramBoolean, ApkgManager.OnGetApkgInfoListener paramOnGetApkgInfoListener, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    String str = PATH_WXAPKG_ROOT + File.separator + paramMiniAppConfig.config.appId + '_' + paramMiniAppConfig.config.version + ".qapkg";
    long l = System.currentTimeMillis();
    if (TextUtils.isEmpty(paramString2)) {
      if (paramOnGetApkgInfoListener != null)
      {
        paramOnGetApkgInfoListener.onGetApkgInfo(null, 1, "apkUrl is Null!");
        QLog.e("ApkgManager", 1, "downloadApkgByResumableDownloader apkUrl is null!");
      }
    }
    do
    {
      return;
      MiniReportManager.reportEventType(paramMiniAppConfig, 619, "0");
      MiniappDownloadUtil.getInstance().downloadApkg(paramMiniAppConfig, false, paramString2, str, true, new ApkgManager.6(this, paramOnGetApkgInfoListener, paramMiniAppConfig, str, paramString1, paramString3, paramString4, l), Downloader.DownloadMode.StrictMode, getHeader(paramString2, paramMiniAppConfig));
    } while (!paramBoolean);
    deleteOldPkg(paramMiniAppConfig, paramString1);
  }
  
  public static String getApkgFolderPath(MiniAppInfo paramMiniAppInfo)
  {
    Object localObject;
    if ((paramMiniAppInfo == null) || (TextUtils.isEmpty(paramMiniAppInfo.appId))) {
      localObject = "";
    }
    String str;
    do
    {
      return localObject;
      if ((!paramMiniAppInfo.isEngineTypeMiniGame()) || (!GameWnsUtils.enablePersistentDebugVersion()) || (!BaseApplicationImpl.getApplication().getSharedPreferences("persistent_debug_version_" + BaseApplicationImpl.getApplication().getRuntime().getAccount(), 4).getBoolean("persistent", false))) {
        break;
      }
      str = getPkgRoot(paramMiniAppInfo) + paramMiniAppInfo.appId + "_debug";
      localObject = str;
    } while (new File(str).exists());
    if (paramMiniAppInfo.verType == 3) {
      return getPkgRoot(paramMiniAppInfo) + MD5.toMD5(paramMiniAppInfo.appId) + "_" + paramMiniAppInfo.version;
    }
    return getPkgRoot(paramMiniAppInfo) + paramMiniAppInfo.appId + "_debug";
  }
  
  private void getApkgInfoByConfig(MiniAppConfig paramMiniAppConfig, boolean paramBoolean, ApkgManager.OnGetApkgInfoListener paramOnGetApkgInfoListener)
  {
    Object localObject1 = null;
    if ((paramMiniAppConfig == null) || (paramMiniAppConfig.config == null)) {
      return;
    }
    Object localObject2 = paramMiniAppConfig.config.version;
    if (QLog.isColorLevel()) {
      QLog.d("ApkgManager", 2, "getApkgInfoByConfig version:" + (String)localObject2);
    }
    String str = getApkgFolderPath(paramMiniAppConfig.config);
    if (paramMiniAppConfig.config.verType != 3)
    {
      QLog.d("ApkgManager", 1, "verType is not online, delete unPackFolderPath." + paramMiniAppConfig.config.verType);
      if (new File(str).exists()) {
        FileUtils.delete(str, false);
      }
    }
    if (new File(str).exists())
    {
      try
      {
        localObject2 = ApkgInfo.loadApkgInfoFromFolderPath(str, null, paramMiniAppConfig);
        localObject1 = localObject2;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QLog.e("ApkgManager", 1, "loadApkgInfoFromFolderPath exception!", localThrowable);
          continue;
          paramOnGetApkgInfoListener = "";
        }
        FileUtils.delete(str, false);
      }
      if (localObject1 != null)
      {
        if (paramOnGetApkgInfoListener != null) {
          paramOnGetApkgInfoListener.onGetApkgInfo(localObject1, 0, "");
        }
        if (paramMiniAppConfig.launchParam != null)
        {
          paramOnGetApkgInfoListener = paramMiniAppConfig.launchParam.entryPath;
          MiniAppReportManager2.reportPageView("cache_apkg_hit", "hit", paramOnGetApkgInfoListener, paramMiniAppConfig);
          MiniAppStartState.setApkgDownload(paramMiniAppConfig.config.appId, true);
          return;
        }
      }
    }
    downloadApkgByResumableDownloader(paramMiniAppConfig, paramBoolean, paramOnGetApkgInfoListener, str);
    if (paramMiniAppConfig.launchParam != null) {}
    for (paramOnGetApkgInfoListener = paramMiniAppConfig.launchParam.entryPath;; paramOnGetApkgInfoListener = "")
    {
      MiniAppReportManager2.reportPageView("cache_apkg_hit", "unhit", paramOnGetApkgInfoListener, paramMiniAppConfig);
      MiniAppStartState.setApkgDownload(paramMiniAppConfig.config.appId, false);
      return;
    }
  }
  
  @NonNull
  public static String getGpkgPluginFolderPath(@NonNull MiniGamePluginInfo paramMiniGamePluginInfo)
  {
    return PATH_GAMEPKG_ROOT + MD5.toMD5(paramMiniGamePluginInfo.id) + "_plugin_" + paramMiniGamePluginInfo.version;
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
        String str = getSKey();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("uin=").append("o").append(paramString).append(";").append("skey=").append(str).append(";");
        paramMiniAppConfig.put("cookie", localStringBuilder.toString());
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          QLog.e("ApkgManager", 1, "getHeader error. " + paramString);
        }
      }
      return paramMiniAppConfig;
    }
    return null;
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
      return PATH_GAMEPKG_ROOT;
    }
    return PATH_WXAPKG_ROOT;
  }
  
  private static String getSKey()
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if (localObject1 == null) {
      localObject1 = "";
    }
    Object localObject2;
    do
    {
      return localObject1;
      localObject2 = (TicketManager)((AppRuntime)localObject1).getManager(2);
      if (localObject2 == null) {
        break;
      }
      localObject1 = ((TicketManager)localObject2).GetSkey(((AppRuntime)localObject1).getAccount(), 16L, null);
      if ((localObject1 == null) || (((Ticket)localObject1)._sig == null)) {
        break;
      }
      localObject2 = new String(((Ticket)localObject1)._sig);
      localObject1 = localObject2;
    } while (!QLog.isColorLevel());
    QLog.i("ApkgManager", 2, "get skey sucess.: " + (String)localObject2);
    return localObject2;
    return "";
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
    int i;
    if (bool)
    {
      i = 0;
      MiniReportManager.reportEventType(paramMiniAppConfig, 622, null, null, null, i);
      if (!bool) {
        break label109;
      }
      paramString1 = ApkgInfo.loadApkgInfoFromFolderPath(paramString2, paramString4, paramMiniAppConfig);
      if ((paramString3 == null) || (paramString1 == null)) {
        break label92;
      }
      downloadSubPack(paramString1, paramString3, new ApkgManager.3(this, paramOnGetApkgInfoListener));
    }
    label92:
    label109:
    while (paramOnGetApkgInfoListener == null)
    {
      do
      {
        return;
        i = 1;
        break;
      } while (paramOnGetApkgInfoListener == null);
      paramOnGetApkgInfoListener.onGetApkgInfo(paramString1, 0, "");
      return;
    }
    paramOnGetApkgInfoListener.onGetApkgInfo(null, 3, ajjy.a(2131634489));
  }
  
  private void onInitApkgInfo(ApkgManager.OnInitApkgListener paramOnInitApkgListener, int paramInt, ApkgInfo paramApkgInfo, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApkgManager", 2, "onInitApkgInfo :" + paramInt + "|" + paramString);
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
    String str2 = getApkgFolderPath(paramApkgInfo.appConfig.config);
    String str1;
    if ("/__APP__/".equals(paramString))
    {
      this.subRoot = "";
      str1 = paramApkgInfo.appConfig.config.downloadUrl;
      if (QLog.isColorLevel()) {
        QLog.d("ApkgManager", 1, "downloadSubPack | downPage=" + paramString + "; subPackDownloadUrl=" + str1);
      }
      if (!TextUtils.isEmpty(str1)) {
        break label136;
      }
      QLog.e("ApkgManager", 1, "subPackDownloadUrl is null, return.");
      if (paramOnInitApkgListener != null) {
        paramOnInitApkgListener.onInitApkgInfo(1, paramApkgInfo, null);
      }
    }
    label136:
    do
    {
      return;
      this.subRoot = paramApkgInfo.getRootPath(paramString);
      str1 = getSubPkgDownloadUrl(paramApkgInfo, this.subRoot);
      break;
      if (("/__APP__/".equals(paramString)) || (!new File(str2, this.subRoot).exists())) {
        break label178;
      }
    } while (paramOnInitApkgListener == null);
    paramOnInitApkgListener.onInitApkgInfo(0, paramApkgInfo, null);
    return;
    label178:
    if (!TextUtils.isEmpty(str1))
    {
      str2 = PATH_WXAPKG_ROOT + File.separator + paramApkgInfo.appConfig.config.appId + '_' + paramApkgInfo.appConfig.config.version + ".qapkg";
      MiniReportManager.reportEventType(paramApkgInfo.appConfig, 613, paramString, null, null, 0, "0", 0L, null);
      MiniappDownloadUtil.getInstance().downloadApkg(paramApkgInfo.appConfig, true, str1, str2, true, new ApkgManager.5(this, paramOnInitApkgListener, paramApkgInfo, paramString, str2), Downloader.DownloadMode.StrictMode, getHeader(str1, paramApkgInfo.appConfig));
      return;
    }
    paramOnInitApkgListener.onInitApkgInfo(1, paramApkgInfo, null);
  }
  
  public void getApkgInfoByConfig(MiniAppConfig paramMiniAppConfig, ApkgManager.OnInitApkgListener paramOnInitApkgListener)
  {
    getApkgInfoByConfig(paramMiniAppConfig, true, paramOnInitApkgListener);
  }
  
  public void getApkgInfoByConfig(MiniAppConfig paramMiniAppConfig, boolean paramBoolean, ApkgManager.OnInitApkgListener paramOnInitApkgListener)
  {
    long l = System.currentTimeMillis();
    MiniReportManager.reportEventType(paramMiniAppConfig, 12, null, null, null, 0);
    getApkgInfoByConfig(paramMiniAppConfig, paramBoolean, new ApkgManager.1(this, paramOnInitApkgListener, l, paramMiniAppConfig));
  }
  
  public String getBasePageFrameStr()
  {
    this.basePageFrameStr = AppLoaderFactory.getAppLoaderManager().getBasePageFrameStr();
    if (this.basePageFrameStr == null) {
      this.basePageFrameStr = JSUtil.assetFile2Str(BaseApplicationImpl.getApplication(), "qvip_pay_miniapp_page_frame.html");
    }
    return this.basePageFrameStr;
  }
  
  public String getWARemoteDebugJsStr()
  {
    return AppLoaderFactory.getAppLoaderManager().waRemoteDebugJsStr();
  }
  
  public String getWAWebviewJsStr()
  {
    return AppLoaderFactory.getAppLoaderManager().waWebviewJsStr();
  }
  
  public String getWaConsoleJsStr()
  {
    return AppLoaderFactory.getAppLoaderManager().waConsoleJsStr();
  }
  
  public String getWaServiceJsStr()
  {
    return AppLoaderFactory.getAppLoaderManager().waServiceJsStr();
  }
  
  public void initApkgByConfig(MiniAppConfig paramMiniAppConfig, ApkgManager.OnInitApkgListener paramOnInitApkgListener)
  {
    getApkgInfoByConfig(paramMiniAppConfig, paramOnInitApkgListener);
  }
  
  public void preloadFlutterPkg(MiniAppConfig paramMiniAppConfig, String paramString)
  {
    QLog.i("ApkgManager", 1, "preloadFlutterPkg appid:" + paramMiniAppConfig.config.appId + " name:" + paramMiniAppConfig.config.name + " url:" + paramString);
    Object localObject = MiniSdkLauncher.convert(paramMiniAppConfig.config);
    if (((com.tencent.qqmini.sdk.launcher.model.MiniAppInfo)localObject).verType == 3) {}
    for (localObject = new StringBuilder(PATH_APKG_TISSUE_ROOT).append(bdyv.c(((com.tencent.qqmini.sdk.launcher.model.MiniAppInfo)localObject).appId)).append("_").append(((com.tencent.qqmini.sdk.launcher.model.MiniAppInfo)localObject).version).toString() + "_maintmp"; new File((String)localObject).exists(); localObject = new StringBuilder(PATH_APKG_TISSUE_ROOT).append(((com.tencent.qqmini.sdk.launcher.model.MiniAppInfo)localObject).appId).append("_debug").toString() + "_maintmp") {
      return;
    }
    String str = PATH_WXAPKG_ROOT + File.separator + paramMiniAppConfig.config.appId + '_' + paramMiniAppConfig.config.version + "_flutter1" + ".qapkg";
    MiniappDownloadUtil.getInstance().downloadApkg(paramMiniAppConfig, false, paramString, str, true, new ApkgManager.2(this, paramMiniAppConfig, str, (String)localObject), Downloader.DownloadMode.StrictMode, getHeader(paramString, paramMiniAppConfig));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.ApkgManager
 * JD-Core Version:    0.7.0.1
 */