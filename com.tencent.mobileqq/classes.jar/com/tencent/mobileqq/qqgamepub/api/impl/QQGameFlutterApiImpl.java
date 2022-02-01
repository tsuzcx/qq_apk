package com.tencent.mobileqq.qqgamepub.api.impl;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.mobileqq.app.AppOpenConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.flutter.api.IQFlutterInstallService;
import com.tencent.mobileqq.flutter.api.IQFlutterRouterService;
import com.tencent.mobileqq.flutter.download.InstallCallback;
import com.tencent.mobileqq.flutter.router.PageRouter;
import com.tencent.mobileqq.flutter.router.SerializableMap;
import com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil;
import com.tencent.mobileqq.qqgamepub.api.IQQGameFlutterApi;
import com.tencent.mobileqq.qqgamepub.api.IQQGamePreDownloadService;
import com.tencent.mobileqq.qqgamepub.config.DnFlutterConfig;
import com.tencent.mobileqq.qqgamepub.data.DownloadParam;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import java.io.File;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqgamepub/api/impl/QQGameFlutterApiImpl;", "Lcom/tencent/mobileqq/qqgamepub/api/IQQGameFlutterApi;", "Lcom/tencent/mobileqq/flutter/download/InstallCallback;", "()V", "DEBUG_RES_DIR", "", "DNFLUTTER_RES_PATH", "MAX_HEAP_LIMIT", "", "RES_ZIP_SUFFIX", "mDynamicInfo", "Lcom/tencent/mobileqq/qqgamepub/config/DnFlutterConfig;", "mMaxMemory", "", "mResFilePath", "checkDnFlutterRes", "", "task", "Lcom/tencent/mobileqq/vip/DownloadTask;", "checkDnflutterConfig", "", "config", "cleanExpireRes", "packName", "currVersion", "deleteResFile", "resFilePath", "downloadDnFlutterRes", "getConfigVerResFilePath", "getDnFlutterConfig", "getDynamicInfo", "getDynamicIsEnable", "isAppInstalled", "isEngineInstalled", "isFlutterEnabled", "isFlutterInstall", "jointnResFilePath", "pckName", "version", "resUrl", "onProgress", "progress", "onResult", "success", "installDir", "isEngineExist", "isAppExist", "preloadFlutter", "reportDownload", "retCode", "httpCode", "reportDynamicEntry", "isSwitchOn", "isFileExits", "isMd5Match", "reportFlutterInstallState", "pageRouter", "Lcom/tencent/mobileqq/flutter/router/PageRouter;", "startFlutterPage", "context", "Landroid/content/Context;", "bundle", "Landroid/os/Bundle;", "updateConfig", "updateDnFlutter", "Companion", "qqgamepubaccount-impl_release"}, k=1, mv={1, 1, 16})
public final class QQGameFlutterApiImpl
  implements InstallCallback, IQQGameFlutterApi
{
  public static final QQGameFlutterApiImpl.Companion Companion = new QQGameFlutterApiImpl.Companion(null);
  @NotNull
  public static final String KEY_CONFIG = "config";
  @NotNull
  public static final String KEY_DOWNLOAD_START_TIME = "downloadStartTime";
  @NotNull
  public static final String KEY_IS_ENABLE = "isEnable";
  @NotNull
  public static final String KEY_MD5 = "md5";
  @NotNull
  public static final String KEY_RESOURCE_LOCALPATH = "resourceLocalPath";
  public static final int RET_DOWNLOAD_FAIL = 1;
  public static final int RET_DOWNLOAD_FAIL_MD5 = 2;
  public static final int RET_DOWNLOAD_SUCC = 0;
  @NotNull
  public static final String TAG = "QQGameFlutterUtilsImpl";
  private final String DEBUG_RES_DIR;
  private final String DNFLUTTER_RES_PATH;
  private final int MAX_HEAP_LIMIT = 209715200;
  private final String RES_ZIP_SUFFIX;
  private DnFlutterConfig mDynamicInfo;
  private long mMaxMemory;
  private String mResFilePath;
  
  public QQGameFlutterApiImpl()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppOpenConstants.a);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("qflutter");
    this.DEBUG_RES_DIR = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    Object localObject = MobileQQ.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "MobileQQ.getContext()");
    localObject = ((BaseApplication)localObject).getFilesDir();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "MobileQQ.getContext().filesDir");
    localStringBuilder.append(((File)localObject).getPath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("dnflutter");
    localStringBuilder.append(File.separator);
    this.DNFLUTTER_RES_PATH = localStringBuilder.toString();
    this.RES_ZIP_SUFFIX = ".zip";
  }
  
  private final boolean checkDnflutterConfig(DnFlutterConfig paramDnFlutterConfig)
  {
    int i = paramDnFlutterConfig.b;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i == 1)
    {
      String str = paramDnFlutterConfig.d;
      Intrinsics.checkExpressionValueIsNotNull(str, "resourceUrl");
      if (((CharSequence)str).length() > 0) {
        i = 1;
      } else {
        i = 0;
      }
      bool1 = bool2;
      if (i != 0)
      {
        str = paramDnFlutterConfig.e;
        Intrinsics.checkExpressionValueIsNotNull(str, "resourceMd5");
        if (((CharSequence)str).length() > 0) {
          i = 1;
        } else {
          i = 0;
        }
        bool1 = bool2;
        if (i != 0)
        {
          paramDnFlutterConfig = paramDnFlutterConfig.c;
          Intrinsics.checkExpressionValueIsNotNull(paramDnFlutterConfig, "version");
          if (((CharSequence)paramDnFlutterConfig).length() > 0) {
            i = 1;
          } else {
            i = 0;
          }
          bool1 = bool2;
          if (i != 0) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private final void cleanExpireRes(String paramString1, String paramString2)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.DNFLUTTER_RES_PATH);
    ((StringBuilder)localObject1).append(paramString1);
    paramString1 = new File(((StringBuilder)localObject1).toString());
    if (paramString1.exists()) {
      if (paramString1.isDirectory())
      {
        localObject1 = paramString1.listFiles();
        int j = 1;
        if (localObject1 != null)
        {
          if (localObject1.length == 0) {
            i = 1;
          } else {
            i = 0;
          }
          if (i == 0)
          {
            i = 0;
            break label94;
          }
        }
        int i = 1;
        label94:
        if (i != 0)
        {
          paramString1.delete();
          return;
        }
        int k = localObject1.length;
        i = 0;
        while (i < k)
        {
          Object localObject2 = localObject1[i];
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "childFile");
          if (((File)localObject2).getPath() != null)
          {
            String str = ((File)localObject2).getPath();
            Intrinsics.checkExpressionValueIsNotNull(str, "childFile.path");
            if (!StringsKt.endsWith$default(str, paramString2, false, 2, null))
            {
              localObject2 = ((File)localObject2).getPath();
              Intrinsics.checkExpressionValueIsNotNull(localObject2, "childFile.path");
              deleteResFile((String)localObject2);
            }
          }
          i += 1;
        }
        paramString2 = paramString1.listFiles();
        i = j;
        if (paramString2 != null)
        {
          if (paramString2.length == 0) {
            i = 1;
          } else {
            i = 0;
          }
          if (i != 0) {
            i = j;
          } else {
            i = 0;
          }
        }
        if (i != 0) {
          paramString1.delete();
        }
      }
      else
      {
        paramString1.delete();
      }
    }
  }
  
  private final void deleteResFile(String paramString)
  {
    FileUtils.delete(paramString, false);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(" delete ");
      QLog.d("QQGameFlutterUtilsImpl", 1, localStringBuilder.toString());
    }
  }
  
  private final void downloadDnFlutterRes()
  {
    DownloadParam localDownloadParam = new DownloadParam();
    Bundle localBundle = new Bundle();
    Object localObject = getDnFlutterConfig();
    localBundle.putString("md5", ((DnFlutterConfig)localObject).e);
    localBundle.putString("downloadStartTime", String.valueOf(SystemClock.elapsedRealtime()));
    localDownloadParam.url = ((DnFlutterConfig)localObject).d;
    localObject = this.mResFilePath;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mResFilePath");
    }
    localDownloadParam.filePath = ((String)localObject);
    ((IQQGamePreDownloadService)QRoute.api(IQQGamePreDownloadService.class)).startDownload(localDownloadParam, (DownloadListener)new QQGameFlutterApiImpl.downloadDnFlutterRes.1(this), localBundle);
  }
  
  private final String getConfigVerResFilePath()
  {
    Object localObject = this.mResFilePath;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mResFilePath");
    }
    localObject = new File((String)localObject);
    if (((File)localObject).exists())
    {
      localObject = ((File)localObject).getPath();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "resFile.path");
      return localObject;
    }
    return "";
  }
  
  private final DnFlutterConfig getDnFlutterConfig()
  {
    DnFlutterConfig localDnFlutterConfig = this.mDynamicInfo;
    if (localDnFlutterConfig == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mDynamicInfo");
    }
    return localDnFlutterConfig;
  }
  
  private final boolean getDynamicIsEnable()
  {
    DnFlutterConfig localDnFlutterConfig = getDnFlutterConfig();
    int i = localDnFlutterConfig.a;
    boolean bool3 = false;
    boolean bool4 = true;
    boolean bool1;
    boolean bool2;
    if (i == 1)
    {
      String str = getConfigVerResFilePath();
      if (((CharSequence)str).length() > 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        if (StringsKt.equals(MD5Utils.encodeFileHexStr(str), localDnFlutterConfig.e, true))
        {
          bool1 = true;
          bool2 = true;
        }
        else
        {
          FileUtils.deleteFile(str);
          bool1 = false;
          bool2 = false;
        }
        bool3 = true;
      }
      else
      {
        bool1 = false;
        bool2 = false;
      }
    }
    else
    {
      bool1 = false;
      bool2 = false;
      bool4 = false;
    }
    reportDynamicEntry(bool4, bool3, bool1);
    return bool2;
  }
  
  private final boolean isFlutterEnabled()
  {
    Object localObject = QRoute.api(IQQGameConfigUtil.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "QRoute.api(IQQGameConfigUtil::class.java)");
    if (!((IQQGameConfigUtil)localObject).isFlutterPreLoad())
    {
      QLog.w("QQGameFlutterUtilsImpl", 4, "[isFlutterEnabled] master switch off");
      return false;
    }
    if (this.mMaxMemory == 0L) {
      this.mMaxMemory = Runtime.getRuntime().maxMemory();
    }
    if (this.mMaxMemory < this.MAX_HEAP_LIMIT)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[isFlutterEnable] heap limit not supported, heap=");
      ((StringBuilder)localObject).append(this.mMaxMemory);
      QLog.w("QQGameFlutterUtilsImpl", 1, ((StringBuilder)localObject).toString());
      return false;
    }
    return true;
  }
  
  private final boolean isFlutterInstall()
  {
    boolean bool1 = ((IQQGameFlutterApi)QRoute.api(IQQGameFlutterApi.class)).isAppInstalled();
    boolean bool2 = ((IQQGameFlutterApi)QRoute.api(IQQGameFlutterApi.class)).isEngineInstalled();
    return (bool1) && (bool2);
  }
  
  private final String jointnResFilePath(String paramString1, String paramString2, String paramString3)
  {
    int i = ((CharSequence)paramString1).length();
    int j = 1;
    if (i == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0)
    {
      if (((CharSequence)paramString2).length() == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0)
      {
        if (((CharSequence)paramString3).length() == 0) {
          i = j;
        } else {
          i = 0;
        }
        if (i == 0)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.DNFLUTTER_RES_PATH);
          localStringBuilder.append(paramString1);
          localStringBuilder.append(File.separator);
          localStringBuilder.append(paramString2);
          localStringBuilder.append(File.separator);
          localStringBuilder.append(MD5Utils.toMD5(paramString3));
          localStringBuilder.append(this.RES_ZIP_SUFFIX);
          return localStringBuilder.toString();
        }
      }
    }
    return "";
  }
  
  private final void reportDynamicEntry(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int k = 0;
    int i;
    if (paramBoolean2) {
      i = 0;
    } else {
      i = 2;
    }
    if (!paramBoolean3) {
      k = 4;
    }
    int j = paramBoolean1 ^ true | i | k;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportDynamicEntry ret is ");
      localStringBuilder.append(j);
      QLog.d("QQGameFlutterUtilsImpl", 1, localStringBuilder.toString());
    }
    GamePubAccountHelper.d(GamePubAccountHelper.a()).h("769").e("1").f("160").d("76933").c("208843").a(j).a();
  }
  
  private final void reportFlutterInstallState(PageRouter paramPageRouter)
  {
    if (paramPageRouter == null) {
      return;
    }
    String str2 = paramPageRouter.b;
    String str3 = paramPageRouter.a;
    paramPageRouter = paramPageRouter.c;
    if ((paramPageRouter != null) && (paramPageRouter.getMap() != null)) {
      paramPageRouter = (String)paramPageRouter.getMap().get("uniquePagePath");
    } else {
      paramPageRouter = "";
    }
    boolean bool = isFlutterInstall();
    String str1;
    if (bool) {
      str1 = "1";
    } else {
      str1 = "0";
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("flutter install state :");
      localStringBuilder.append(bool);
      localStringBuilder.append(" pageName=");
      localStringBuilder.append(str2);
      localStringBuilder.append(" entryPoint=");
      localStringBuilder.append(str3);
      localStringBuilder.append(" uniquePagepath=");
      localStringBuilder.append(paramPageRouter);
      QLog.d("QQGameFlutterUtilsImpl", 1, localStringBuilder.toString());
    }
    GamePubAccountHelper.c(GamePubAccountHelper.a()).c("208646").d("76933").a(11, str2).a(12, str3).a(13, paramPageRouter).a(14, str1).a();
  }
  
  private final void updateConfig(DnFlutterConfig paramDnFlutterConfig)
  {
    this.mDynamicInfo = paramDnFlutterConfig;
    paramDnFlutterConfig = this.mDynamicInfo;
    if (paramDnFlutterConfig == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mDynamicInfo");
    }
    paramDnFlutterConfig = paramDnFlutterConfig.g;
    Intrinsics.checkExpressionValueIsNotNull(paramDnFlutterConfig, "mDynamicInfo.packageName");
    Object localObject1 = this.mDynamicInfo;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mDynamicInfo");
    }
    localObject1 = ((DnFlutterConfig)localObject1).c;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "mDynamicInfo.version");
    Object localObject2 = this.mDynamicInfo;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mDynamicInfo");
    }
    localObject2 = ((DnFlutterConfig)localObject2).e;
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "mDynamicInfo.resourceMd5");
    this.mResFilePath = jointnResFilePath(paramDnFlutterConfig, (String)localObject1, (String)localObject2);
  }
  
  public final void checkDnFlutterRes(@NotNull DownloadTask paramDownloadTask)
  {
    Intrinsics.checkParameterIsNotNull(paramDownloadTask, "task");
    Object localObject1 = (File)paramDownloadTask.g.get(paramDownloadTask.h);
    Object localObject2 = paramDownloadTask.b().getString("md5");
    if ((localObject1 != null) && (((File)localObject1).exists()))
    {
      String str = MD5Utils.encodeFileHexStr(((File)localObject1).getPath());
      Intrinsics.checkExpressionValueIsNotNull(str, "fileMd5");
      int i;
      if (((CharSequence)str).length() > 0) {
        i = 1;
      } else {
        i = 0;
      }
      if ((i != 0) && (StringsKt.equals(str, (String)localObject2, true)))
      {
        QLog.d("QQGameFlutterUtilsImpl", 1, "download dnflutter succ");
        localObject2 = getDnFlutterConfig();
        localObject1 = ((DnFlutterConfig)localObject2).g;
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "dnFlutterConfig.packageName");
        localObject2 = ((DnFlutterConfig)localObject2).c;
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "dnFlutterConfig.version");
        cleanExpireRes((String)localObject1, (String)localObject2);
        reportDownload(paramDownloadTask, 0, paramDownloadTask.H);
        return;
      }
      reportDownload(paramDownloadTask, 2, paramDownloadTask.H);
      boolean bool = ((File)localObject1).delete();
      paramDownloadTask = new StringBuilder();
      paramDownloadTask.append("download dnflutter ,md5 is illegal,and delete file:");
      paramDownloadTask.append(bool);
      QLog.d("QQGameFlutterUtilsImpl", 1, paramDownloadTask.toString());
    }
  }
  
  @NotNull
  public String getDynamicInfo(@NotNull DnFlutterConfig paramDnFlutterConfig)
  {
    Intrinsics.checkParameterIsNotNull(paramDnFlutterConfig, "config");
    if (!checkDnflutterConfig(paramDnFlutterConfig)) {
      return "";
    }
    Object localObject = new JSONObject();
    boolean bool = getDynamicIsEnable();
    try
    {
      ((JSONObject)localObject).put("isEnable", bool);
      if (bool)
      {
        ((JSONObject)localObject).put("config", new JSONObject(paramDnFlutterConfig.h));
        ((JSONObject)localObject).put("resourceLocalPath", getConfigVerResFilePath());
      }
      paramDnFlutterConfig = ((JSONObject)localObject).toString();
      Intrinsics.checkExpressionValueIsNotNull(paramDnFlutterConfig, "dynamicJson.toString()");
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getDynamicInfo is ");
        ((StringBuilder)localObject).append(paramDnFlutterConfig);
        QLog.d("QQGameFlutterUtilsImpl", 1, ((StringBuilder)localObject).toString());
      }
      return paramDnFlutterConfig;
    }
    catch (JSONException paramDnFlutterConfig)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getDynamicInfo err ,");
      ((StringBuilder)localObject).append(paramDnFlutterConfig.getMessage());
      QLog.e("QQGameFlutterUtilsImpl", 1, ((StringBuilder)localObject).toString());
    }
    return "";
  }
  
  public boolean isAppInstalled()
  {
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if ((localObject != null) && ((localObject instanceof BaseQQAppInterface)))
    {
      localObject = ((AppRuntime)localObject).getRuntimeService(IQFlutterInstallService.class, "all");
      Intrinsics.checkExpressionValueIsNotNull(localObject, "it.getRuntimeService(\n  …ant.ALL\n                )");
      return ((IQFlutterInstallService)localObject).isAppInstalled();
    }
    return false;
  }
  
  public boolean isEngineInstalled()
  {
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if ((localObject != null) && ((localObject instanceof BaseQQAppInterface)))
    {
      localObject = ((AppRuntime)localObject).getRuntimeService(IQFlutterInstallService.class, "all");
      Intrinsics.checkExpressionValueIsNotNull(localObject, "it.getRuntimeService(\n  …ant.ALL\n                )");
      return ((IQFlutterInstallService)localObject).isEngineInstalled();
    }
    return false;
  }
  
  public void onProgress(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[preloadFlutter] onProgress =");
      localStringBuilder.append(paramInt);
      QLog.d("QQGameFlutterUtilsImpl", 1, localStringBuilder.toString());
    }
  }
  
  public void onResult(boolean paramBoolean1, @Nullable String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[preloadFlutter] onResult success=");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(",installDir=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(',');
      localStringBuilder.append("isEngineExist=");
      localStringBuilder.append(paramBoolean2);
      localStringBuilder.append(",isAppExist=");
      localStringBuilder.append(paramBoolean3);
      QLog.d("QQGameFlutterUtilsImpl", 1, localStringBuilder.toString());
    }
  }
  
  public void preloadFlutter()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGameFlutterUtilsImpl", 2, "[preloadFlutter] ");
    }
    if (!isFlutterEnabled())
    {
      QLog.w("QQGameFlutterUtilsImpl", 1, "[preloadFlutter] flutter not enabled");
      return;
    }
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if ((localAppRuntime != null) && ((localAppRuntime instanceof BaseQQAppInterface))) {
      ThreadManager.excute((Runnable)new QQGameFlutterApiImpl.preloadFlutter..inlined.let.lambda.1(localAppRuntime, this), 16, null, false);
    }
  }
  
  public final void reportDownload(@NotNull DownloadTask paramDownloadTask, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramDownloadTask, "task");
    Object localObject = paramDownloadTask.b().getString("downloadStartTime");
    if (localObject != null) {
      localObject = Long.valueOf(Long.parseLong((String)localObject));
    } else {
      localObject = null;
    }
    if (localObject != null)
    {
      ((Number)localObject).longValue();
      long l = SystemClock.elapsedRealtime() - ((Long)localObject).longValue();
      WadlReportBuilder localWadlReportBuilder = GamePubAccountHelper.d(GamePubAccountHelper.a()).h("769").e("1").f("160").d("76933").c("208842");
      if (l > 0L) {
        localObject = String.valueOf(l);
      } else {
        localObject = "0";
      }
      localWadlReportBuilder.a(17, (String)localObject).a(34, paramDownloadTask.h).a(paramInt1).a(35, String.valueOf(paramInt2)).a();
    }
  }
  
  public void startFlutterPage(@Nullable Context paramContext, @Nullable PageRouter paramPageRouter, @Nullable Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGameFlutterUtilsImpl", 4, "-->startQQGameFlutter");
    }
    Object localObject;
    if (paramPageRouter != null)
    {
      localObject = paramPageRouter.c;
      if (localObject != null)
      {
        localObject = ((SerializableMap)localObject).getMap();
        if (localObject != null) {
          ((Map)localObject).put("clickTime", Long.valueOf(System.currentTimeMillis()));
        }
      }
    }
    if (paramPageRouter != null)
    {
      localObject = paramPageRouter.c;
      if (localObject != null)
      {
        localObject = ((SerializableMap)localObject).getMap();
        if (localObject != null)
        {
          DnFlutterConfig localDnFlutterConfig = GamePubAccountHelper.g();
          Intrinsics.checkExpressionValueIsNotNull(localDnFlutterConfig, "GamePubAccountHelper.getDnFlutterConfig()");
          ((Map)localObject).put("dynamicInfo", getDynamicInfo(localDnFlutterConfig));
        }
      }
    }
    ((IQFlutterRouterService)QQGameHelperImpl.getAppRuntime().getRuntimeService(IQFlutterRouterService.class, "all")).openPageByMainProcess(paramContext, paramPageRouter, paramBundle);
    ThreadManagerV2.excute((Runnable)new QQGameFlutterApiImpl.startFlutterPage.1(this, paramPageRouter), 128, null, true);
  }
  
  public void updateDnFlutter(@NotNull DnFlutterConfig paramDnFlutterConfig)
  {
    Intrinsics.checkParameterIsNotNull(paramDnFlutterConfig, "config");
    if (!checkDnflutterConfig(paramDnFlutterConfig)) {
      return;
    }
    updateConfig(paramDnFlutterConfig);
    boolean bool = URLUtil.e(getDnFlutterConfig().d);
    int i = 1;
    if (!bool)
    {
      QLog.e("QQGameFlutterUtilsImpl", 1, "resourceUrl is of no avail");
      return;
    }
    if (((CharSequence)getConfigVerResFilePath()).length() != 0) {
      i = 0;
    }
    if (i != 0) {
      ThreadManager.excute((Runnable)new QQGameFlutterApiImpl.updateDnFlutter.1(this), 16, null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.api.impl.QQGameFlutterApiImpl
 * JD-Core Version:    0.7.0.1
 */