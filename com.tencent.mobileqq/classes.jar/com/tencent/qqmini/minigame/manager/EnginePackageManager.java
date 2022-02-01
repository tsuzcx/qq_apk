package com.tencent.qqmini.minigame.manager;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.triton.model.Version;
import com.tencent.qqmini.minigame.api.MiniEnginePackage;
import com.tencent.qqmini.minigame.utils.GameLog;
import com.tencent.qqmini.minigame.utils.MD5FileUtil;
import com.tencent.qqmini.sdk.core.ReportConst;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.FileInfo;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.core.utils.ZipUtil;
import com.tencent.qqmini.sdk.ipc.AppBrandCmdProxy;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;
import com.tencent.qqmini.sdk.manager.BaseLibManager;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.utils.GameWnsUtils;
import java.io.File;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;

public class EnginePackageManager
{
  private static final String LOCAL_TRITON_PATH = "mini/libs";
  private static final String TAG = "GameEnvManager[MiniEng]";
  private static final String TRITON_ONLINE_TIMESTAMP = "TritonTimeStamp";
  private static final String TRITON_ONLINE_VERSION = "TritonVersion";
  private static final String TRITON_PATH_BASE;
  private static volatile String currentTritonPath;
  private static volatile Version currentTritonVersion;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppLoaderFactory.g().getContext().getFilesDir().getPath());
    localStringBuilder.append("/mini/triton");
    TRITON_PATH_BASE = localStringBuilder.toString();
  }
  
  private static String calcMD5(String paramString)
  {
    long l = System.currentTimeMillis();
    Object localObject4 = new File(paramString);
    boolean bool = ((File)localObject4).exists();
    localObject3 = "";
    Object localObject1 = localObject3;
    if (bool) {}
    try
    {
      localObject4 = MD5FileUtil.getFileMD5String((File)localObject4);
      localObject1 = localObject3;
      if (localObject4 != null) {
        localObject1 = localObject4;
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Object localObject2 = localObject3;
      }
    }
    localObject3 = GameLog.getInstance();
    localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("calcMD5 ");
    ((StringBuilder)localObject4).append(paramString);
    ((StringBuilder)localObject4).append(", md5:");
    ((StringBuilder)localObject4).append(localObject1);
    ((StringBuilder)localObject4).append(", cost:");
    ((StringBuilder)localObject4).append(System.currentTimeMillis() - l);
    ((GameLog)localObject3).d("GameEnvManager[MiniEng]", ((StringBuilder)localObject4).toString());
    return localObject1;
  }
  
  private static boolean checkShouldDownload(Version paramVersion)
  {
    boolean bool2 = false;
    if (paramVersion == null) {
      return false;
    }
    Version localVersion1 = getLocalTritonVersion();
    Version localVersion2 = getOnlineTritonVersion();
    boolean bool1 = bool2;
    if (paramVersion.compareTo(localVersion1) > 0)
    {
      bool1 = bool2;
      if (paramVersion.compareTo(localVersion2) > 0) {
        bool1 = true;
      }
    }
    GameLog localGameLog = GameLog.getInstance();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkShouldDownload localVersion:");
    localStringBuilder.append(localVersion1);
    localStringBuilder.append(", onlineVersion:");
    localStringBuilder.append(localVersion2);
    localStringBuilder.append(", targetVersion:");
    localStringBuilder.append(paramVersion);
    localStringBuilder.append(", ret:");
    localStringBuilder.append(bool1);
    localGameLog.i("GameEnvManager[MiniEng]", localStringBuilder.toString());
    return bool1;
  }
  
  public static void checkTritonUpdate()
  {
    ThreadManager.executeOnComputationThreadPool(new EnginePackageManager.1());
  }
  
  private static void checkTritonUpdateOnMainProcess()
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_mini_app_config", new MiniAppInfo());
    AppBrandCmdProxy.g().sendCmd("cmd_update_triton_engine", localBundle, null);
  }
  
  private static void deleteOldVersionTritonEngine()
  {
    ThreadManager.executeOnDiskIOThreadPool(new EnginePackageManager.3());
  }
  
  private static void downloadLatestTritonEngine(BaseLibInfo paramBaseLibInfo, Version paramVersion)
  {
    if (paramBaseLibInfo == null) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(TRITON_PATH_BASE);
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(paramBaseLibInfo.baseLibVersion);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(System.nanoTime());
    ((StringBuilder)localObject).append(".zip");
    localObject = ((StringBuilder)localObject).toString();
    ((DownloaderProxy)ProxyManager.get(DownloaderProxy.class)).download(paramBaseLibInfo.baseLibUrl, null, (String)localObject, 60, new EnginePackageManager.2(paramBaseLibInfo, paramVersion, (String)localObject));
    MiniReportManager.reportEventType(ReportConst.miniAppConfigForPreload(), 4, "1");
  }
  
  private static boolean enableLoadEngineFromDex()
  {
    if (!GameWnsUtils.gameEnableDexLoader()) {
      return false;
    }
    ChannelProxy localChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
    if ((localChannelProxy != null) && (localChannelProxy.isGooglePlayVersion()))
    {
      int i;
      if (WnsConfig.getConfig("qqminiapp", "mini_app_google_play_load_so_switch", 0) == 1) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0) {
        return false;
      }
    }
    return true;
  }
  
  public static MiniEnginePackage getEnginePackage()
  {
    String str = getJsPath();
    return new MiniEnginePackage(getJsVersionByPath(str), new File(str), getTritonVersion(), new File(getTritonPath()), getTritonDexPath(getTritonPath()), GameWnsUtils.getGlobalConfig());
  }
  
  private static String getInnerJsPath()
  {
    return BaseLibManager.g().installMiniGameInnerJsLib();
  }
  
  @NonNull
  private static String getJsPath()
  {
    String str1 = StorageUtil.getPreference().getString("downloadUrl", "mini");
    String str2 = StorageUtil.getPreference().getString("version", "1.22.0.00008");
    str1 = BaseLibManager.g().getBaseLibDir(str1, str2);
    str2 = getInnerJsPath();
    str1 = getNewestBaseLib(getTritonPath(), getNewestBaseLib(str1, str2));
    if (str1 != null) {
      return str1;
    }
    return BaseLibManager.g().getBaseLibDir("mini", "1.22.0.00008");
  }
  
  private static Version getJsVersionByPath(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Version localVersion = new Version("", 0L);
    Object localObject = new File(paramString);
    paramString = localVersion;
    if (((File)localObject).exists())
    {
      localObject = ((File)localObject).getName();
      paramString = localVersion;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("_");
        paramString = localVersion;
        if (localObject.length > 1) {
          paramString = new Version(localObject[1], 0L);
        }
      }
    }
    return paramString;
  }
  
  @NonNull
  private static String getLocalTritonPath()
  {
    String str = ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getSoPath();
    if (!TextUtils.isEmpty(str)) {
      return str;
    }
    return "mini/libs";
  }
  
  private static Version getLocalTritonVersion()
  {
    Version localVersion = getTritonVersionFromJSONStr("{\n    \"triton_info\": {\n        \"version\": \"1.8.0.74.062e92e\",\n        \"timestamp\": 1609833458180\n    }\n}");
    GameLog localGameLog = GameLog.getInstance();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getLocalTritonVersion:");
    localStringBuilder.append(localVersion);
    localGameLog.i("GameEnvManager[MiniEng]", localStringBuilder.toString());
    return localVersion;
  }
  
  private static String getNewestBaseLib(String paramString1, String paramString2)
  {
    boolean bool1 = BaseLibManager.g().isBaseLibDirValid4MiniGame(paramString1);
    boolean bool2 = BaseLibManager.g().isBaseLibDirValid4MiniGame(paramString2);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("path1 = ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(", valid1 = ");
    ((StringBuilder)localObject).append(bool1);
    QMLog.i("GameEnvManager[MiniEng]", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("path2 = ");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(", valid2 = ");
    ((StringBuilder)localObject).append(bool2);
    QMLog.i("GameEnvManager[MiniEng]", ((StringBuilder)localObject).toString());
    if ((bool1) && (bool2))
    {
      Version localVersion = getJsVersionByPath(paramString1);
      localObject = getJsVersionByPath(paramString2);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("version1 = ");
      localStringBuilder.append(localVersion);
      localStringBuilder.append(", ");
      localStringBuilder.append("version2 = ");
      localStringBuilder.append(localObject);
      QMLog.i("GameEnvManager[MiniEng]", localStringBuilder.toString());
      if ((localVersion != null) && (localObject != null))
      {
        if (localVersion.compareTo((Version)localObject) >= 0) {
          return paramString1;
        }
        return paramString2;
      }
      if (localVersion != null) {
        return paramString1;
      }
      if (localObject != null) {
        paramString1 = paramString2;
      }
      return paramString1;
    }
    if (bool1) {
      return paramString1;
    }
    if (bool2) {
      return paramString2;
    }
    return null;
  }
  
  private static String getOnlineTritonPath()
  {
    return getOnlineTritonPathByVersion(getOnlineTritonVersion());
  }
  
  private static String getOnlineTritonPathByVersion(Version paramVersion)
  {
    if (paramVersion == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(TRITON_PATH_BASE);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramVersion.getVersion());
    localStringBuilder.append("_");
    localStringBuilder.append(paramVersion.getTimeStamp());
    return localStringBuilder.toString();
  }
  
  private static Version getOnlineTritonVersion()
  {
    Version localVersion = new Version(StorageUtil.getPreference().getString("TritonVersion", ""), StorageUtil.getPreference().getLong("TritonTimeStamp", -1L));
    GameLog localGameLog = GameLog.getInstance();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getOnlineTritonVersion:");
    localStringBuilder.append(localVersion);
    localGameLog.i("GameEnvManager[MiniEng]", localStringBuilder.toString());
    return localVersion;
  }
  
  @Nullable
  private static File getTritonDexPath(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) && (!enableLoadEngineFromDex())) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    if (paramString.endsWith(File.separator)) {
      paramString = "";
    } else {
      paramString = File.separator;
    }
    localStringBuilder.append(paramString);
    localStringBuilder.append("triton.jar");
    paramString = new File(localStringBuilder.toString());
    if (!paramString.exists()) {
      return null;
    }
    return paramString;
  }
  
  @NonNull
  private static String getTritonPath()
  {
    try
    {
      if (!TextUtils.isEmpty(currentTritonPath))
      {
        localObject1 = currentTritonPath;
        return localObject1;
      }
      Object localObject1 = getLocalTritonVersion();
      Version localVersion = getOnlineTritonVersion();
      if (((Version)localObject1).compareTo(localVersion) >= 0)
      {
        currentTritonPath = getLocalTritonPath();
        currentTritonVersion = (Version)localObject1;
      }
      else
      {
        currentTritonPath = getOnlineTritonPath();
        currentTritonVersion = localVersion;
      }
      checkTritonUpdateOnMainProcess();
      localObject1 = currentTritonPath;
      return localObject1;
    }
    finally {}
  }
  
  private static Version getTritonVersion()
  {
    try
    {
      if (currentTritonVersion == null) {
        getTritonPath();
      }
      Version localVersion = currentTritonVersion;
      return localVersion;
    }
    finally {}
  }
  
  private static Version getTritonVersionByBaseLib(BaseLibInfo paramBaseLibInfo)
  {
    if ((paramBaseLibInfo != null) && (!TextUtils.isEmpty(paramBaseLibInfo.baseLibDesc)))
    {
      paramBaseLibInfo = getTritonVersionFromJSONStr(paramBaseLibInfo.baseLibDesc);
      GameLog localGameLog = GameLog.getInstance();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getTritonVersionByBaseLib:");
      localStringBuilder.append(paramBaseLibInfo);
      localGameLog.i("GameEnvManager[MiniEng]", localStringBuilder.toString());
      return paramBaseLibInfo;
    }
    return null;
  }
  
  private static Version getTritonVersionByFileInfo(FileInfo paramFileInfo)
  {
    if ((paramFileInfo != null) && (!TextUtils.isEmpty(paramFileInfo.getName())))
    {
      Version localVersion = new Version("", 0L);
      try
      {
        Object localObject = paramFileInfo.getName().split("_");
        if (localObject.length == 2)
        {
          localObject = new Version(localObject[0], Long.parseLong(localObject[1]));
          return localObject;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        GameLog localGameLog = GameLog.getInstance();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getTritonVersionByFileInfo error.");
        localStringBuilder.append(paramFileInfo.getPath());
        localGameLog.e("GameEnvManager[MiniEng]", localStringBuilder.toString(), localNumberFormatException);
      }
      return localVersion;
    }
    return null;
  }
  
  private static Version getTritonVersionFromJSONStr(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      Object localObject = new JSONObject(paramString).optJSONObject("triton_info");
      if (localObject != null)
      {
        localObject = new Version(((JSONObject)localObject).optString("version"), ((JSONObject)localObject).optLong("timestamp"));
        return localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      GameLog localGameLog = GameLog.getInstance();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getTritonVersionByBaseLib content:");
      localStringBuilder.append(paramString);
      localGameLog.e("GameEnvManager[MiniEng]", localStringBuilder.toString(), localThrowable);
    }
    return null;
  }
  
  private static boolean isVerifyListValid(File paramFile, boolean paramBoolean, JSONArray paramJSONArray)
  {
    int i = 0;
    while (i < paramJSONArray.length())
    {
      String str;
      if (paramJSONArray.get(i) == null)
      {
        GameLog.getInstance().e("GameEnvManager[MiniEng]", "配置文件格式异常！！请使用json工具检测");
      }
      else
      {
        Object localObject2 = (JSONObject)paramJSONArray.get(i);
        str = ((JSONObject)localObject2).optString("name");
        if (!TextUtils.isEmpty(str))
        {
          Object localObject1 = new File(paramFile, str);
          if ((!((File)localObject1).exists()) || (!((File)localObject1).isFile())) {
            break label318;
          }
          int j = ((JSONObject)localObject2).optInt("length");
          if ((j > 0) && (((File)localObject1).length() != j))
          {
            paramFile = GameLog.getInstance();
            paramJSONArray = new StringBuilder();
            paramJSONArray.append("verifyEngine file ");
            paramJSONArray.append(str);
            paramJSONArray.append(" length fail, config_length:");
            paramJSONArray.append(j);
            paramJSONArray.append(", local_length:");
            paramJSONArray.append(((File)localObject1).length());
            paramFile.w("GameEnvManager[MiniEng]", paramJSONArray.toString());
            return false;
          }
          localObject2 = ((JSONObject)localObject2).optString("md5");
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject1 = calcMD5(((File)localObject1).getAbsolutePath());
            if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!((String)localObject2).equalsIgnoreCase((String)localObject1)))
            {
              paramFile = GameLog.getInstance();
              paramJSONArray = new StringBuilder();
              paramJSONArray.append("verifyEngine file ");
              paramJSONArray.append(str);
              paramJSONArray.append(" md5 fail, config_md5:");
              paramJSONArray.append((String)localObject2);
              paramJSONArray.append(", local_md5:");
              paramJSONArray.append((String)localObject1);
              paramFile.w("GameEnvManager[MiniEng]", paramJSONArray.toString());
              return false;
            }
          }
        }
      }
      i += 1;
      continue;
      label318:
      paramFile = GameLog.getInstance();
      paramJSONArray = new StringBuilder();
      paramJSONArray.append("verifyEngine file ");
      paramJSONArray.append(str);
      paramJSONArray.append(" not found");
      paramFile.w("GameEnvManager[MiniEng]", paramJSONArray.toString());
      return false;
    }
    return paramBoolean;
  }
  
  private static void onDownloadLatestTritonEngineSuccess(Version paramVersion, String paramString)
  {
    for (;;)
    {
      try
      {
        Object localObject2 = getOnlineTritonPathByVersion(paramVersion);
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append("_");
        ((StringBuilder)localObject1).append(System.nanoTime());
        localObject1 = ((StringBuilder)localObject1).toString();
        MiniReportManager.reportEventType(ReportConst.miniAppConfigForPreload(), 6, "1");
        int j = ZipUtil.unZipFolder(paramString, (String)localObject1);
        boolean bool2 = verifyEngine((String)localObject1);
        Object localObject3 = GameLog.getInstance();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("download ");
        localStringBuilder.append(paramVersion);
        localStringBuilder.append(", unzip:");
        if (j == 0)
        {
          bool1 = true;
          localStringBuilder.append(bool1);
          localStringBuilder.append(" verify:");
          localStringBuilder.append(bool2);
          ((GameLog)localObject3).i("GameEnvManager[MiniEng]", localStringBuilder.toString());
          localObject3 = ReportConst.miniAppConfigForPreload();
          if ((j != 0) || (!bool2)) {
            break label518;
          }
          i = 0;
          MiniReportManager.reportEventType((MiniAppInfo)localObject3, 7, null, null, null, i, "1", 0L, null);
          if ((j == 0) && (bool2))
          {
            localObject3 = getOnlineTritonVersion();
            if (paramVersion.compareTo((Version)localObject3) > 0)
            {
              if (FileUtils.rename((String)localObject1, (String)localObject2))
              {
                StorageUtil.getPreference().edit().putString("TritonVersion", paramVersion.getVersion()).putLong("TritonTimeStamp", paramVersion.getTimeStamp()).commit();
                localObject3 = GameLog.getInstance();
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("[安装小游戏新版本so] 安装成功, path:");
                localStringBuilder.append((String)localObject2);
                localStringBuilder.append(", 更新线上版本至:");
                localStringBuilder.append(paramVersion);
                ((GameLog)localObject3).i("GameEnvManager[MiniEng]", localStringBuilder.toString());
                deleteOldVersionTritonEngine();
              }
              else
              {
                FileUtils.deleteFile((String)localObject2);
                localObject3 = GameLog.getInstance();
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("[安装小游戏新版本so] 安装失败, rename fail. ");
                localStringBuilder.append(paramVersion);
                localStringBuilder.append(" from ");
                localStringBuilder.append((String)localObject1);
                localStringBuilder.append(" to ");
                localStringBuilder.append((String)localObject2);
                ((GameLog)localObject3).i("GameEnvManager[MiniEng]", localStringBuilder.toString());
              }
            }
            else
            {
              localObject2 = GameLog.getInstance();
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("[安装小游戏新版本so] 跳过安装, 已存在更高或相同版本, latestVersion ");
              localStringBuilder.append(localObject3);
              localStringBuilder.append(" targetVersion ");
              localStringBuilder.append(paramVersion);
              ((GameLog)localObject2).i("GameEnvManager[MiniEng]", localStringBuilder.toString());
            }
          }
          else
          {
            GameLog.getInstance().i("GameEnvManager[MiniEng]", "[安装小游戏新版本so] 解压或校验失败!");
          }
          FileUtils.deleteFile(paramString);
          FileUtils.deleteFile((String)localObject1);
          return;
        }
      }
      finally {}
      boolean bool1 = false;
      continue;
      label518:
      int i = 1;
    }
  }
  
  private static boolean verifyEngine(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject1 = new File(paramString);
    if (((File)localObject1).exists())
    {
      if (((File)localObject1).isFile()) {
        return false;
      }
      try
      {
        Object localObject2 = new File((File)localObject1, "verify.json");
        boolean bool = ((File)localObject2).exists();
        if ((bool) && (((File)localObject2).isFile()))
        {
          localObject2 = FileUtils.readFileToString((File)localObject2);
          if (TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject1 = GameLog.getInstance();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("verifyEngine ");
            ((StringBuilder)localObject2).append(paramString);
            ((StringBuilder)localObject2).append(" verify.json has no content, skip!");
            ((GameLog)localObject1).i("GameEnvManager[MiniEng]", ((StringBuilder)localObject2).toString());
            return true;
          }
          if (QMLog.isColorLevel())
          {
            GameLog localGameLog = GameLog.getInstance();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("verifyEngine ");
            localStringBuilder.append(paramString);
            localStringBuilder.append(" content:");
            localStringBuilder.append((String)localObject2);
            localGameLog.d("GameEnvManager[MiniEng]", localStringBuilder.toString());
          }
          localObject2 = new JSONObject((String)localObject2);
          if (!((JSONObject)localObject2).has("verify_list"))
          {
            localObject1 = GameLog.getInstance();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("verifyEngine ");
            ((StringBuilder)localObject2).append(paramString);
            ((StringBuilder)localObject2).append(" verify.json has no verify_list, skip!");
            ((GameLog)localObject1).i("GameEnvManager[MiniEng]", ((StringBuilder)localObject2).toString());
            return true;
          }
          return isVerifyListValid((File)localObject1, true, ((JSONObject)localObject2).getJSONArray("verify_list"));
        }
        localObject1 = GameLog.getInstance();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("verifyEngine ");
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append(" has no verify.json, skip!");
        ((GameLog)localObject1).i("GameEnvManager[MiniEng]", ((StringBuilder)localObject2).toString());
        return true;
      }
      catch (Throwable paramString)
      {
        GameLog.getInstance().e("GameEnvManager[MiniEng]", "verifyEngine exception.", paramString);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.manager.EnginePackageManager
 * JD-Core Version:    0.7.0.1
 */