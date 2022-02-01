package com.tencent.qqmini.minigame.manager;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.triton.sdk.EnvConfig;
import com.tencent.mobileqq.triton.sdk.Version;
import com.tencent.qqmini.minigame.utils.GameLog;
import com.tencent.qqmini.minigame.utils.LogFilterUtil;
import com.tencent.qqmini.minigame.utils.MD5FileUtil;
import com.tencent.qqmini.sdk.core.ReportConst;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.FileInfo;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.core.utils.ZipUtil;
import com.tencent.qqmini.sdk.ipc.AppBrandCmdProxy;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;
import com.tencent.qqmini.sdk.manager.BaseLibManager;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import java.io.File;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;

public class GameEnvManager
{
  private static final String LOCAL_TRITON_PATH = "mini/libs";
  private static final String TAG = "GameEnvManager[MiniEng]";
  private static final String TRITON_ONLINE_TIMESTAMP = "TritonTimeStamp";
  private static final String TRITON_ONLINE_VERSION = "TritonVersion";
  private static final String TRITON_PATH_BASE = AppLoaderFactory.g().getContext().getFilesDir().getPath() + "/mini/.triton";
  private static volatile String currentTritonPath;
  private static volatile Version currentTritonVersion;
  
  private static String calcMD5(String paramString)
  {
    long l = System.currentTimeMillis();
    Object localObject = new File(paramString);
    if (((File)localObject).exists()) {}
    for (;;)
    {
      try
      {
        localObject = MD5FileUtil.getFileMD5String((File)localObject);
        if (localObject == null) {
          continue;
        }
      }
      catch (IOException localIOException)
      {
        str = "";
        continue;
      }
      GameLog.getInstance().d("GameEnvManager[MiniEng]", "calcMD5 " + paramString + ", md5:" + (String)localObject + ", cost:" + (System.currentTimeMillis() - l));
      return localObject;
      localObject = "";
      continue;
      String str = "";
    }
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
    GameLog.getInstance().i("GameEnvManager[MiniEng]", "checkShouldDownload localVersion:" + localVersion1 + ", onlineVersion:" + localVersion2 + ", targetVersion:" + paramVersion + ", ret:" + bool1);
    return bool1;
  }
  
  public static void checkTritonUpdate()
  {
    ThreadManager.executeOnComputationThreadPool(new GameEnvManager.1());
  }
  
  private static void checkTritonUpdateOnMainProcess()
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_mini_app_config", new MiniAppInfo());
    AppBrandCmdProxy.g().sendCmd("cmd_update_triton_engine", localBundle, null);
  }
  
  private static void deleteOldVersionTritonEngine()
  {
    ThreadManager.executeOnDiskIOThreadPool(new GameEnvManager.3());
  }
  
  private static void downloadLatestTritonEngine(BaseLibInfo paramBaseLibInfo, Version paramVersion)
  {
    if (paramBaseLibInfo == null) {
      return;
    }
    String str = TRITON_PATH_BASE + File.separator + paramBaseLibInfo.baseLibVersion + "_" + System.nanoTime() + ".zip";
    ((DownloaderProxy)ProxyManager.get(DownloaderProxy.class)).download(paramBaseLibInfo.baseLibUrl, null, str, 60, new GameEnvManager.2(paramBaseLibInfo, paramVersion, str));
    MiniReportManager.reportEventType(ReportConst.miniAppConfigForPreload(), 4, "1");
  }
  
  public static EnvConfig getEnvConfig()
  {
    try
    {
      EnvConfig localEnvConfig = new EnvConfig();
      localEnvConfig.setTritonPath(getTritonPath());
      localEnvConfig.setTritonVersion(getTritonVersion());
      String str = getJsPath();
      localEnvConfig.setJSPath(str);
      localEnvConfig.setJSVersion(getJsVersionByPath(str));
      localEnvConfig.setLogConfig(LogFilterUtil.getLogWhiteList(), LogFilterUtil.getLogBlackList());
      return localEnvConfig;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private static String getInnerJsPath()
  {
    try
    {
      String str = BaseLibManager.g().installMiniGameInnerJsLib();
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private static String getJsPath()
  {
    String str1 = StorageUtil.getPreference().getString("downloadUrl", "mini");
    String str2 = StorageUtil.getPreference().getString("version", "1.17.0.00206");
    str1 = BaseLibManager.g().getBaseLibDir(str1, str2);
    str2 = getInnerJsPath();
    return getNewestBaseLib(getTritonPath(), getNewestBaseLib(str1, str2));
  }
  
  private static Version getJsVersionByPath(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = null;
    }
    Version localVersion;
    Object localObject;
    do
    {
      do
      {
        do
        {
          do
          {
            return paramString;
            localVersion = new Version();
            localObject = new File(paramString);
            paramString = localVersion;
          } while (!((File)localObject).exists());
          localObject = ((File)localObject).getName();
          paramString = localVersion;
        } while (TextUtils.isEmpty((CharSequence)localObject));
        localObject = ((String)localObject).split("_");
        paramString = localVersion;
      } while (localObject == null);
      paramString = localVersion;
    } while (localObject.length <= 1);
    localVersion.setVersion(localObject[1]);
    return localVersion;
  }
  
  private static String getLocalTritonPath()
  {
    MiniAppProxy localMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
    if (!TextUtils.isEmpty(localMiniAppProxy.getSoPath())) {
      return localMiniAppProxy.getSoPath();
    }
    return "mini/libs";
  }
  
  private static Version getLocalTritonVersion()
  {
    Version localVersion = getTritonVersionFromJSONStr("{\n    \"triton_info\": {\n        \"version\": \"1.5.1.47.23024d6\",\n        \"timestamp\": 1594302534582\n    }\n}");
    GameLog.getInstance().i("GameEnvManager[MiniEng]", "getLocalTritonVersion:" + localVersion);
    return localVersion;
  }
  
  private static String getNewestBaseLib(String paramString1, String paramString2)
  {
    boolean bool1 = BaseLibManager.g().isBaseLibDirValid4MiniGame(paramString1);
    boolean bool2 = BaseLibManager.g().isBaseLibDirValid4MiniGame(paramString2);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("path1 = ").append(paramString1).append(", valid1 = ").append(bool1);
    QMLog.i("GameEnvManager[MiniEng]", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("path2 = ").append(paramString2).append(", valid2 = ").append(bool2);
    QMLog.i("GameEnvManager[MiniEng]", ((StringBuilder)localObject).toString());
    if ((bool1) && (bool2))
    {
      localObject = getJsVersionByPath(paramString1);
      localVersion = getJsVersionByPath(paramString2);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("version1 = ").append(localObject).append(", ").append("version2 = ").append(localVersion);
      QMLog.i("GameEnvManager[MiniEng]", localStringBuilder.toString());
      if ((localObject != null) && (localVersion != null)) {
        if (((Version)localObject).compareTo(localVersion) < 0) {}
      }
    }
    while (bool1)
    {
      Version localVersion;
      do
      {
        StringBuilder localStringBuilder;
        return paramString1;
        return paramString2;
      } while ((localObject != null) || (localVersion == null));
      return paramString2;
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
    return TRITON_PATH_BASE + File.separator + paramVersion.getVersion() + "_" + paramVersion.getTimeStamp();
  }
  
  private static Version getOnlineTritonVersion()
  {
    Version localVersion = new Version();
    localVersion.setVersion(StorageUtil.getPreference().getString("TritonVersion", ""));
    localVersion.setTimeStamp(StorageUtil.getPreference().getLong("TritonTimeStamp", -1L));
    GameLog.getInstance().i("GameEnvManager[MiniEng]", "getOnlineTritonVersion:" + localVersion);
    return localVersion;
  }
  
  /* Error */
  private static String getTritonPath()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 415	com/tencent/qqmini/minigame/manager/GameEnvManager:currentTritonPath	Ljava/lang/String;
    //   6: invokestatic 341	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifne +12 -> 21
    //   12: getstatic 415	com/tencent/qqmini/minigame/manager/GameEnvManager:currentTritonPath	Ljava/lang/String;
    //   15: astore_0
    //   16: ldc 2
    //   18: monitorexit
    //   19: aload_0
    //   20: areturn
    //   21: invokestatic 89	com/tencent/qqmini/minigame/manager/GameEnvManager:getLocalTritonVersion	()Lcom/tencent/mobileqq/triton/sdk/Version;
    //   24: astore_0
    //   25: invokestatic 141	com/tencent/qqmini/minigame/manager/GameEnvManager:getOnlineTritonVersion	()Lcom/tencent/mobileqq/triton/sdk/Version;
    //   28: astore_1
    //   29: aload_0
    //   30: aload_1
    //   31: invokevirtual 147	com/tencent/mobileqq/triton/sdk/Version:compareTo	(Lcom/tencent/mobileqq/triton/sdk/Version;)I
    //   34: iflt +23 -> 57
    //   37: invokestatic 417	com/tencent/qqmini/minigame/manager/GameEnvManager:getLocalTritonPath	()Ljava/lang/String;
    //   40: putstatic 415	com/tencent/qqmini/minigame/manager/GameEnvManager:currentTritonPath	Ljava/lang/String;
    //   43: aload_0
    //   44: putstatic 419	com/tencent/qqmini/minigame/manager/GameEnvManager:currentTritonVersion	Lcom/tencent/mobileqq/triton/sdk/Version;
    //   47: invokestatic 421	com/tencent/qqmini/minigame/manager/GameEnvManager:checkTritonUpdateOnMainProcess	()V
    //   50: getstatic 415	com/tencent/qqmini/minigame/manager/GameEnvManager:currentTritonPath	Ljava/lang/String;
    //   53: astore_0
    //   54: goto -38 -> 16
    //   57: invokestatic 423	com/tencent/qqmini/minigame/manager/GameEnvManager:getOnlineTritonPath	()Ljava/lang/String;
    //   60: putstatic 415	com/tencent/qqmini/minigame/manager/GameEnvManager:currentTritonPath	Ljava/lang/String;
    //   63: aload_1
    //   64: putstatic 419	com/tencent/qqmini/minigame/manager/GameEnvManager:currentTritonVersion	Lcom/tencent/mobileqq/triton/sdk/Version;
    //   67: goto -20 -> 47
    //   70: astore_0
    //   71: ldc 2
    //   73: monitorexit
    //   74: aload_0
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   15	39	0	localObject1	Object
    //   70	5	0	localObject2	Object
    //   28	36	1	localVersion	Version
    // Exception table:
    //   from	to	target	type
    //   3	16	70	finally
    //   21	47	70	finally
    //   47	54	70	finally
    //   57	67	70	finally
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
    if ((paramBaseLibInfo == null) || (TextUtils.isEmpty(paramBaseLibInfo.baseLibDesc))) {
      return null;
    }
    paramBaseLibInfo = getTritonVersionFromJSONStr(paramBaseLibInfo.baseLibDesc);
    GameLog.getInstance().i("GameEnvManager[MiniEng]", "getTritonVersionByBaseLib:" + paramBaseLibInfo);
    return paramBaseLibInfo;
  }
  
  private static Version getTritonVersionByFileInfo(FileInfo paramFileInfo)
  {
    Object localObject;
    if ((paramFileInfo == null) || (TextUtils.isEmpty(paramFileInfo.getName()))) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      Version localVersion = new Version();
      try
      {
        String[] arrayOfString = paramFileInfo.getName().split("_");
        localObject = localVersion;
        if (arrayOfString != null)
        {
          localObject = localVersion;
          if (arrayOfString.length == 2)
          {
            localVersion.setVersion(arrayOfString[0]);
            localVersion.setTimeStamp(Long.parseLong(arrayOfString[1]));
            return localVersion;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        GameLog.getInstance().e("GameEnvManager[MiniEng]", "getTritonVersionByFileInfo error." + paramFileInfo.getPath(), localThrowable);
      }
    }
    return new Version();
  }
  
  private static Version getTritonVersionFromJSONStr(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString).optJSONObject("triton_info");
      Version localVersion2 = new Version();
      localVersion1 = localVersion2;
      if (localJSONObject != null)
      {
        localVersion2.setVersion(localJSONObject.optString("version"));
        localVersion2.setTimeStamp(localJSONObject.optLong("timestamp"));
        localVersion1 = localVersion2;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Version localVersion1;
        GameLog.getInstance().e("GameEnvManager[MiniEng]", "getTritonVersionByBaseLib content:" + paramString, localThrowable);
        Object localObject = null;
      }
    }
    return localVersion1;
  }
  
  private static void onDownloadLatestTritonEngineSuccess(Version paramVersion, String paramString)
  {
    for (;;)
    {
      try
      {
        String str1 = getOnlineTritonPathByVersion(paramVersion);
        String str2 = str1 + "_" + System.nanoTime();
        MiniReportManager.reportEventType(ReportConst.miniAppConfigForPreload(), 6, "1");
        int j = ZipUtil.unZipFolder(paramString, str2);
        boolean bool2 = verifyEngine(str2);
        Object localObject = GameLog.getInstance();
        StringBuilder localStringBuilder = new StringBuilder().append("download ").append(paramVersion).append(", unzip:");
        boolean bool1;
        if (j == 0)
        {
          bool1 = true;
          ((GameLog)localObject).i("GameEnvManager[MiniEng]", bool1 + " verify:" + bool2);
          localObject = ReportConst.miniAppConfigForPreload();
          if ((j == 0) && (bool2))
          {
            i = 0;
            MiniReportManager.reportEventType((MiniAppInfo)localObject, 7, null, null, null, i, "1", 0L, null);
            if ((j != 0) || (!bool2)) {
              break label405;
            }
            localObject = getOnlineTritonVersion();
            if (paramVersion.compareTo((Version)localObject) <= 0) {
              break label362;
            }
            if (!FileUtils.rename(str2, str1)) {
              continue;
            }
            StorageUtil.getPreference().edit().putString("TritonVersion", paramVersion.getVersion()).putLong("TritonTimeStamp", paramVersion.getTimeStamp()).commit();
            GameLog.getInstance().i("GameEnvManager[MiniEng]", "[安装小游戏新版本so] 安装成功, path:" + str1 + ", 更新线上版本至:" + paramVersion);
            deleteOldVersionTritonEngine();
            FileUtils.deleteFile(paramString);
            FileUtils.deleteFile(str2);
          }
        }
        else
        {
          bool1 = false;
          continue;
        }
        int i = 1;
        continue;
        FileUtils.deleteFile(str1);
        GameLog.getInstance().i("GameEnvManager[MiniEng]", "[安装小游戏新版本so] 安装失败, rename fail. " + paramVersion + " from " + str2 + " to " + str1);
        continue;
        GameLog.getInstance().i("GameEnvManager[MiniEng]", "[安装小游戏新版本so] 跳过安装, 已存在更高或相同版本, latestVersion " + localObject + " targetVersion " + paramVersion);
      }
      finally {}
      label362:
      continue;
      label405:
      GameLog.getInstance().i("GameEnvManager[MiniEng]", "[安装小游戏新版本so] 解压或校验失败!");
    }
  }
  
  private static boolean verifyEngine(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    File localFile = new File(paramString);
    if ((!localFile.exists()) || (localFile.isFile())) {
      return false;
    }
    boolean bool;
    try
    {
      localObject1 = new File(localFile, "verify.json");
      if ((((File)localObject1).exists()) && (((File)localObject1).isFile())) {
        break label122;
      }
      GameLog.getInstance().i("GameEnvManager[MiniEng]", "verifyEngine " + paramString + " has no verify.json, skip!");
      return true;
    }
    catch (Throwable paramString)
    {
      GameLog.getInstance().e("GameEnvManager[MiniEng]", "verifyEngine exception.", paramString);
      bool = false;
    }
    return bool;
    label122:
    Object localObject1 = FileUtils.readFileToString((File)localObject1);
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      GameLog.getInstance().i("GameEnvManager[MiniEng]", "verifyEngine " + paramString + " verify.json has no content, skip!");
      return true;
    }
    if (QMLog.isColorLevel()) {
      GameLog.getInstance().d("GameEnvManager[MiniEng]", "verifyEngine " + paramString + " content:" + (String)localObject1);
    }
    localObject1 = new JSONObject((String)localObject1);
    if (!((JSONObject)localObject1).has("verify_list"))
    {
      GameLog.getInstance().i("GameEnvManager[MiniEng]", "verifyEngine " + paramString + " verify.json has no verify_list, skip!");
      return true;
    }
    paramString = ((JSONObject)localObject1).getJSONArray("verify_list");
    int i = 0;
    for (;;)
    {
      if (i < paramString.length())
      {
        if (paramString.get(i) == null)
        {
          GameLog.getInstance().e("GameEnvManager[MiniEng]", "配置文件格式异常！！请使用json工具检测");
          break label610;
        }
        Object localObject3 = (JSONObject)paramString.get(i);
        localObject1 = ((JSONObject)localObject3).optString("name");
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label610;
        }
        Object localObject2 = new File(localFile, (String)localObject1);
        if ((!((File)localObject2).exists()) || (!((File)localObject2).isFile()))
        {
          GameLog.getInstance().w("GameEnvManager[MiniEng]", "verifyEngine file " + (String)localObject1 + " not found");
          bool = false;
          break;
        }
        int j = ((JSONObject)localObject3).optInt("length");
        if ((j > 0) && (((File)localObject2).length() != j))
        {
          GameLog.getInstance().w("GameEnvManager[MiniEng]", "verifyEngine file " + (String)localObject1 + " length fail, config_length:" + j + ", local_length:" + ((File)localObject2).length());
          bool = false;
          break;
        }
        localObject3 = ((JSONObject)localObject3).optString("md5");
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          break label610;
        }
        localObject2 = calcMD5(((File)localObject2).getAbsolutePath());
        if ((TextUtils.isEmpty((CharSequence)localObject2)) || (((String)localObject3).equalsIgnoreCase((String)localObject2))) {
          break label610;
        }
        GameLog.getInstance().w("GameEnvManager[MiniEng]", "verifyEngine file " + (String)localObject1 + " md5 fail, config_md5:" + (String)localObject3 + ", local_md5:" + (String)localObject2);
        bool = false;
        break;
      }
      bool = true;
      break;
      label610:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.manager.GameEnvManager
 * JD-Core Version:    0.7.0.1
 */