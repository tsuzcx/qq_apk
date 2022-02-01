package com.tencent.mobileqq.minigame.manager;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import bjkf;
import com.qq.taf.jce.HexUtil;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.downloader.Downloader.DownloadMode;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.mini.apkg.BaseLibManager;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.launch.AppBrandProxy;
import com.tencent.mobileqq.mini.report.MiniProgramReportHelper;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.mini.reuse.MiniappDownloadUtil;
import com.tencent.mobileqq.mini.sdk.BaseLibInfo;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.mobileqq.mini.utils.MiniAppGlobal;
import com.tencent.mobileqq.minigame.api.QQMiniEnginePackage;
import com.tencent.mobileqq.minigame.utils.GameLog;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.mobileqq.triton.model.Version;
import com.tencent.qphone.base.util.MD5;
import cooperation.qzone.QUA;
import java.io.File;
import java.io.IOException;
import npo;
import org.json.JSONArray;
import org.json.JSONObject;

public class GameEnvManager
{
  public static final int ERROR_DOWNLOAD_FAIL = -4;
  public static final int ERROR_RENAME_FAIL = -1;
  public static final int ERROR_UNZIP_FAIL = -3;
  public static final int ERROR_VERSION_CHECK_FAIL = -2;
  private static final String LOCAL_TRITON_PATH = "mini/libs";
  public static final int SUCCESS = 0;
  private static final String TAG = "GameEnvManager[MiniEng]";
  private static final String TRITON_ONLINE_TIMESTAMP = "TritonTimeStamp";
  private static final String TRITON_ONLINE_VERSION = "TritonVersion";
  private static final String TRITON_PATH_BASE = BaseApplicationImpl.getApplication().getFilesDir().getPath() + "/mini/.triton";
  private static volatile String currentTritonPath;
  private static volatile Version currentTritonVersion;
  
  private static String calcMD5(String paramString)
  {
    long l = System.currentTimeMillis();
    try
    {
      String str1 = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString));
      GameLog.getInstance().d("GameEnvManager[MiniEng]", "calcMD5 " + paramString + ", md5:" + str1 + ", cost:" + (System.currentTimeMillis() - l));
      return str1;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        Object localObject = new File(paramString);
        if (!((File)localObject).exists()) {
          break;
        }
        try
        {
          String str4 = bjkf.a((File)localObject);
          localObject = str4;
          if (str4 == null) {
            localObject = "";
          }
        }
        catch (IOException localIOException)
        {
          String str2 = "";
        }
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        GameLog.getInstance().e("GameEnvManager[MiniEng]", "calcMD5 " + paramString + ", exception:", localOutOfMemoryError);
        String str3 = "";
      }
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
    ThreadManagerV2.excute(new GameEnvManager.1(), 16, null, false);
  }
  
  private static void checkTritonUpdateOnMainProcess()
  {
    AppBrandProxy.g().sendCmd("cmd_update_triton_engine", null, null);
  }
  
  private static void deleteOldVersionTritonEngine()
  {
    ThreadManagerV2.executeOnFileThread(new GameEnvManager.3());
  }
  
  public static void downloadLatestTritonEngine(BaseLibInfo paramBaseLibInfo, Version paramVersion, GameEnvManager.IDownloadListener paramIDownloadListener)
  {
    if (paramBaseLibInfo == null) {
      return;
    }
    String str = TRITON_PATH_BASE + File.separator + paramBaseLibInfo.baseLibVersion + "_" + System.nanoTime() + ".zip";
    MiniappDownloadUtil.getInstance().download(paramBaseLibInfo.baseLibUrl, str, true, new GameEnvManager.2(paramBaseLibInfo, paramIDownloadListener, paramVersion, str), Downloader.DownloadMode.StrictMode, null);
    MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 4, "1");
  }
  
  private static boolean enableLoadEngineFromDex()
  {
    return GameWnsUtils.gameEnableDexLoader();
  }
  
  public static QQMiniEnginePackage getEnginePackage()
  {
    return new QQMiniEnginePackage(new File(getJsPath()), getTritonVersion(), getJsVersionByPath(getJsPath()), new File(getTritonPath()), getTritonDexPath(getTritonPath()), getGlobalConfig());
  }
  
  private static String getGlobalConfig()
  {
    return "self = GameGlobal = __TT__GLOBAL__ = global = window = this;\nself.__ttObjdec__ = {};\nself.wx = self.wx || {};\nself.WeixinNativeBuffer = Triton.WeixinNativeBuffer;\nvar __wxConfig = __wxConfig || {};\n__wxConfig.env = {};\n__wxConfig.env.USER_DATA_PATH = '" + MiniAppGlobal.STR_WXFILE + "usr';\n__wxConfig.platform = 'android';\n__wxConfig.QUA = '" + QUA.getQUA3() + "';\nwx.env = __wxConfig.env;\nvar __qqConfig = __wxConfig || {};\n";
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
    String str2 = StorageUtil.getPreference().getString("version", "1.19.0.00043");
    str1 = BaseLibManager.g().getBaseLibDir(str1, str2);
    str2 = getInnerJsPath();
    return getNewestBaseLib(getTritonPath(), getNewestBaseLib(str1, str2));
  }
  
  private static Version getJsVersionByPath(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new Version("", 0L);
    }
    paramString = new File(paramString);
    if (paramString.exists())
    {
      paramString = paramString.getName();
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = paramString.split("_");
        if (paramString.length > 1) {
          return new Version(paramString[1], 0L);
        }
      }
    }
    return new Version("", 0L);
  }
  
  private static String getLocalTritonPath()
  {
    return "mini/libs";
  }
  
  private static Version getLocalTritonVersion()
  {
    Version localVersion = getTritonVersionFromJSONStr("{\n    \"triton_info\": {\n        \"version\": \"1.8.0.64.bf85a90\",\n        \"timestamp\": 1598590401113\n    }\n}");
    GameLog.getInstance().i("GameEnvManager[MiniEng]", "getLocalTritonVersion:" + localVersion);
    return localVersion;
  }
  
  private static String getNewestBaseLib(String paramString1, String paramString2)
  {
    boolean bool1 = BaseLibManager.g().isBaseLibDirValid4MiniGame(paramString1);
    boolean bool2 = BaseLibManager.g().isBaseLibDirValid4MiniGame(paramString2);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getNewestBaseLib path1 = ").append(paramString1).append(", valid1 = ").append(bool1).append(", path2 = ").append(paramString2).append(", valid2 = ").append(bool2);
    GameLog.getInstance().i("GameEnvManager[MiniEng]", ((StringBuilder)localObject).toString());
    if ((bool1) && (bool2))
    {
      localObject = getJsVersionByPath(paramString1);
      localVersion = getJsVersionByPath(paramString2);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getNewestBaseLib version1 = ").append(localObject).append(", ").append("version2 = ").append(localVersion);
      GameLog.getInstance().i("GameEnvManager[MiniEng]", localStringBuilder.toString());
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
    return paramString2;
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
    Version localVersion = new Version(StorageUtil.getPreference().getString("TritonVersion", ""), StorageUtil.getPreference().getLong("TritonTimeStamp", -1L));
    GameLog.getInstance().i("GameEnvManager[MiniEng]", "getOnlineTritonVersion:" + localVersion);
    return localVersion;
  }
  
  private static File getTritonDexPath(String paramString)
  {
    if (!enableLoadEngineFromDex()) {}
    while (TextUtils.isEmpty(paramString)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder().append(paramString);
    if (paramString.endsWith(File.separator)) {}
    for (paramString = "";; paramString = File.separator) {
      return new File(paramString + "triton.jar");
    }
  }
  
  /* Error */
  private static String getTritonPath()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 429	com/tencent/mobileqq/minigame/manager/GameEnvManager:currentTritonPath	Ljava/lang/String;
    //   6: invokestatic 363	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifne +12 -> 21
    //   12: getstatic 429	com/tencent/mobileqq/minigame/manager/GameEnvManager:currentTritonPath	Ljava/lang/String;
    //   15: astore_0
    //   16: ldc 2
    //   18: monitorexit
    //   19: aload_0
    //   20: areturn
    //   21: invokestatic 89	com/tencent/mobileqq/minigame/manager/GameEnvManager:getLocalTritonVersion	()Lcom/tencent/mobileqq/triton/model/Version;
    //   24: astore_0
    //   25: invokestatic 163	com/tencent/mobileqq/minigame/manager/GameEnvManager:getOnlineTritonVersion	()Lcom/tencent/mobileqq/triton/model/Version;
    //   28: astore_1
    //   29: aload_0
    //   30: ifnull +31 -> 61
    //   33: aload_0
    //   34: aload_1
    //   35: invokevirtual 169	com/tencent/mobileqq/triton/model/Version:compareTo	(Lcom/tencent/mobileqq/triton/model/Version;)I
    //   38: iflt +23 -> 61
    //   41: invokestatic 431	com/tencent/mobileqq/minigame/manager/GameEnvManager:getLocalTritonPath	()Ljava/lang/String;
    //   44: putstatic 429	com/tencent/mobileqq/minigame/manager/GameEnvManager:currentTritonPath	Ljava/lang/String;
    //   47: aload_0
    //   48: putstatic 433	com/tencent/mobileqq/minigame/manager/GameEnvManager:currentTritonVersion	Lcom/tencent/mobileqq/triton/model/Version;
    //   51: invokestatic 435	com/tencent/mobileqq/minigame/manager/GameEnvManager:checkTritonUpdateOnMainProcess	()V
    //   54: getstatic 429	com/tencent/mobileqq/minigame/manager/GameEnvManager:currentTritonPath	Ljava/lang/String;
    //   57: astore_0
    //   58: goto -42 -> 16
    //   61: invokestatic 437	com/tencent/mobileqq/minigame/manager/GameEnvManager:getOnlineTritonPath	()Ljava/lang/String;
    //   64: putstatic 429	com/tencent/mobileqq/minigame/manager/GameEnvManager:currentTritonPath	Ljava/lang/String;
    //   67: aload_1
    //   68: putstatic 433	com/tencent/mobileqq/minigame/manager/GameEnvManager:currentTritonVersion	Lcom/tencent/mobileqq/triton/model/Version;
    //   71: goto -20 -> 51
    //   74: astore_0
    //   75: ldc 2
    //   77: monitorexit
    //   78: aload_0
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   15	43	0	localObject1	Object
    //   74	5	0	localObject2	Object
    //   28	40	1	localVersion	Version
    // Exception table:
    //   from	to	target	type
    //   3	16	74	finally
    //   21	29	74	finally
    //   33	51	74	finally
    //   51	58	74	finally
    //   61	71	74	finally
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
    if ((paramFileInfo == null) || (TextUtils.isEmpty(paramFileInfo.d()))) {
      return null;
    }
    try
    {
      Object localObject = paramFileInfo.d().split("_");
      if (localObject.length == 2)
      {
        localObject = new Version(localObject[0], Long.parseLong(localObject[1]));
        return localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      GameLog.getInstance().e("GameEnvManager[MiniEng]", "getTritonVersionByFileInfo error." + paramFileInfo.c(), localThrowable);
      return new Version("", 0L);
    }
    Version localVersion = new Version("", 0L);
    return localVersion;
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
        paramString = (String)localObject;
      }
      else
      {
        localObject = new Version("", 0L);
        paramString = (String)localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      GameLog.getInstance().e("GameEnvManager[MiniEng]", "getTritonVersionByBaseLib content:" + paramString, localThrowable);
      paramString = null;
    }
    return paramString;
  }
  
  private static void onDownloadLatestTritonEngineSuccess(Version paramVersion, String paramString, GameEnvManager.IDownloadListener paramIDownloadListener)
  {
    for (;;)
    {
      try
      {
        String str1 = getOnlineTritonPathByVersion(paramVersion);
        String str2 = str1 + "_" + System.nanoTime();
        MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 6, "1");
        int j = npo.a(paramString, str2);
        boolean bool2 = verifyEngine(str2);
        Object localObject = GameLog.getInstance();
        StringBuilder localStringBuilder = new StringBuilder().append("download ").append(paramVersion).append(", unzip:");
        boolean bool1;
        if (j == 0)
        {
          bool1 = true;
          ((GameLog)localObject).i("GameEnvManager[MiniEng]", bool1 + " verify:" + bool2);
          localObject = MiniProgramReportHelper.miniAppConfigForPreload();
          if ((j == 0) && (bool2))
          {
            i = 0;
            MiniReportManager.reportEventType((MiniAppConfig)localObject, 7, null, null, null, i, "1", 0L, null);
            if ((j != 0) || (!bool2)) {
              break label454;
            }
            localObject = getOnlineTritonVersion();
            if (paramVersion.compareTo((Version)localObject) <= 0) {
              break label396;
            }
            if (!com.tencent.mobileqq.mini.appbrand.utils.FileUtils.rename(str2, str1)) {
              continue;
            }
            StorageUtil.getPreference().edit().putString("TritonVersion", paramVersion.getVersion()).putLong("TritonTimeStamp", paramVersion.getTimeStamp()).commit();
            GameLog.getInstance().i("GameEnvManager[MiniEng]", "[安装小游戏新版本so] 安装成功, path:" + str1 + ", 更新线上版本至:" + paramVersion);
            deleteOldVersionTritonEngine();
            if (paramIDownloadListener != null) {
              paramIDownloadListener.onDownloadResult(0, "安装成功");
            }
            FileUtil.deleteFile(paramString);
            FileUtil.deleteFile(str2);
          }
        }
        else
        {
          bool1 = false;
          continue;
        }
        int i = 1;
        continue;
        FileUtil.deleteFile(str1);
        GameLog.getInstance().i("GameEnvManager[MiniEng]", "[安装小游戏新版本so] 安装失败, rename fail. " + paramVersion + " from " + str2 + " to " + str1);
        if (paramIDownloadListener == null) {
          continue;
        }
        paramIDownloadListener.onDownloadResult(-1, "安装失败");
        continue;
        GameLog.getInstance().i("GameEnvManager[MiniEng]", "[安装小游戏新版本so] 跳过安装, 已存在更高或相同版本, latestVersion " + localObject + " targetVersion " + paramVersion);
      }
      finally {}
      label396:
      if (paramIDownloadListener != null)
      {
        paramIDownloadListener.onDownloadResult(-2, "已存在更高或相同版本");
        continue;
        label454:
        GameLog.getInstance().i("GameEnvManager[MiniEng]", "[安装小游戏新版本so] 解压或校验失败!");
        if (paramIDownloadListener != null) {
          paramIDownloadListener.onDownloadResult(-3, "解压或校验失败");
        }
      }
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
    Object localObject1 = com.tencent.mobileqq.mini.utils.FileUtils.readFileToString((File)localObject1);
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      GameLog.getInstance().i("GameEnvManager[MiniEng]", "verifyEngine " + paramString + " verify.json has no content, skip!");
      return true;
    }
    if (QLog.isColorLevel()) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.GameEnvManager
 * JD-Core Version:    0.7.0.1
 */