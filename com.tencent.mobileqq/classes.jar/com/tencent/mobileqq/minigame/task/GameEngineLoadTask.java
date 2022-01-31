package com.tencent.mobileqq.minigame.task;

import ajya;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import bewd;
import bfko;
import com.qq.taf.jce.HexUtil;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.report.MiniAppReportManager2;
import com.tencent.mobileqq.mini.report.MiniAppStartState;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.report.MiniProgramReportHelper;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.mini.tfs.AsyncTask;
import com.tencent.mobileqq.mini.util.MiniAppClassloader;
import com.tencent.mobileqq.mini.utils.DebugUtil;
import com.tencent.mobileqq.mini.utils.FileUtils;
import com.tencent.mobileqq.minigame.api.APIProxyImpl;
import com.tencent.mobileqq.minigame.api.QQEnvImp;
import com.tencent.mobileqq.minigame.manager.EngineChannel;
import com.tencent.mobileqq.minigame.manager.EngineChannel.Receiver;
import com.tencent.mobileqq.minigame.manager.EngineVersion;
import com.tencent.mobileqq.minigame.manager.GameEngineWrapper;
import com.tencent.mobileqq.minigame.manager.GameLoadManager.GameLoadListener;
import com.tencent.mobileqq.minigame.manager.InstalledEngine;
import com.tencent.mobileqq.minigame.utils.GameLog;
import com.tencent.mobileqq.minigame.utils.GameSoLoader;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.mobileqq.minigame.utils.thread.TTHandleThread;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.mobileqq.triton.sdk.TTEngineBuilder;
import com.tencent.qphone.base.util.MD5;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

public class GameEngineLoadTask
  extends AsyncTask
  implements EngineChannel.Receiver
{
  public static final int ENG_NOT_LOAD = -1;
  public static final int ERR_ENGINE_NEED_UPDATE = 101;
  public static final int ERR_ENGINE_NULL = 105;
  public static final int ERR_ENGINE_TIMEOUT = 103;
  public static final int ERR_ENGINE_VERSION = 104;
  public static final int ERR_INIT_ENGINE = 109;
  public static final int ERR_INIT_NDK = 108;
  public static final int ERR_INTERNAL = 102;
  public static final int ERR_INVALID_OP = 1;
  public static final int ERR_LOAD_JAR = 106;
  public static final int ERR_LOAD_SO = 107;
  public static final int ERR_UNKNOWN = 100;
  private static final int INSTALL_ENGINE_REQUEST_COUNT_MAX = 2;
  public static final String LOG_TAG = "EngineLoadTask";
  public static final int SUCCEED = 0;
  private static final int UPGRADE_ENGINE_REQUEST_COUNT_MAX = 1;
  private static volatile GameEngineLoadTask instance;
  private AtomicInteger ackCount;
  public volatile boolean allowPostProgress;
  private MiniAppConfig appConfig;
  private int installEngineRequestCount;
  private InstalledEngine mEngine;
  private EngineChannel mEngineChannel;
  private int mEngineLoadResult = -1;
  private GameEngineWrapper mGameEngine = new GameEngineWrapper();
  private GameLoadManager.GameLoadListener mGameLoadListener;
  private bewd mInspectorAgentWrapper;
  private int upgradeEngineRequestCount;
  
  private GameEngineLoadTask(Context paramContext)
  {
    super(paramContext);
    GameLog.getInstance().i("EngineLoadTask", "GameEngineLoadTask constructor");
  }
  
  private String calcMD5(String paramString)
  {
    long l = System.currentTimeMillis();
    try
    {
      String str1 = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString));
      GameLog.getInstance().d("EngineLoadTask", "[MiniEng] calcMD5 " + paramString + ", md5:" + str1 + ", cost:" + (System.currentTimeMillis() - l));
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
          String str4 = bfko.a((File)localObject);
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
        GameLog.getInstance().e("EngineLoadTask", "[MiniEng] calcMD5 " + paramString + ", exception:", localOutOfMemoryError);
        String str3 = "";
      }
    }
  }
  
  public static GameEngineLoadTask g(Context paramContext)
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new GameEngineLoadTask(paramContext);
      }
      return instance;
    }
    finally {}
  }
  
  private String getTritonDexPath()
  {
    if (QQEnvImp.isUseLocalSDKResource()) {}
    for (String str = "/sdcard/game/";; str = getBaseEnginePath()) {
      return str + "triton.jar";
    }
  }
  
  private boolean hasNewEngineDex()
  {
    if (!GameWnsUtils.gameEnableDexLoader()) {}
    while (TextUtils.isEmpty(getBaseEnginePath())) {
      return false;
    }
    return new File(getTritonDexPath()).exists();
  }
  
  private void initOutChannel()
  {
    EngineChannel localEngineChannel = new EngineChannel();
    localEngineChannel.setName("GameEngine(" + Process.myPid() + ")");
    localEngineChannel.setReceiver(this);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("engineChannel", localEngineChannel);
    sendCommand(1, localBundle);
  }
  
  private boolean isGameSatisfy(InstalledEngine paramInstalledEngine, MiniAppConfig paramMiniAppConfig)
  {
    boolean bool = true;
    if (paramInstalledEngine == null)
    {
      GameLog.getInstance().e("EngineLoadTask", "[MiniEng]isGameSatisfy engine == null");
      return false;
    }
    if (paramMiniAppConfig == null)
    {
      GameLog.getInstance().e("EngineLoadTask", "[MiniEng]isGameSatisfy gameConfig == null");
      return false;
    }
    paramMiniAppConfig = paramMiniAppConfig.config;
    if (paramMiniAppConfig == null)
    {
      GameLog.getInstance().e("EngineLoadTask", "[MiniEng]isGameSatisfy info == null");
      return false;
    }
    paramMiniAppConfig = paramMiniAppConfig.baselibMiniVersion;
    GameLog.getInstance().i("EngineLoadTask", "[MiniEng]isGameSatisfy minVersion=" + paramMiniAppConfig);
    if (TextUtils.isEmpty(paramMiniAppConfig)) {
      return true;
    }
    paramMiniAppConfig = new EngineVersion(paramMiniAppConfig);
    if (paramInstalledEngine.engineVersion.compareTo(paramMiniAppConfig) >= 0) {}
    for (;;)
    {
      GameLog.getInstance().i("EngineLoadTask", "[MiniEng]isGameSatisfy minEngineVersion=" + paramMiniAppConfig + ",engineVersion=" + paramInstalledEngine.engineVersion + ",ret=" + bool);
      return bool;
      bool = false;
    }
  }
  
  private int loadEngine(InstalledEngine paramInstalledEngine)
  {
    for (;;)
    {
      try
      {
        MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 1014, "1");
        if (paramInstalledEngine == null)
        {
          GameLog.getInstance().i("EngineLoadTask", "[MiniEng] installedEngine == null, loadEngineTask is reset?");
          i = 105;
          return i;
        }
        Object localObject1 = new TTEngineBuilder();
        APIProxyImpl localAPIProxyImpl = new APIProxyImpl();
        ((TTEngineBuilder)localObject1).setApiProxy(localAPIProxyImpl).setQQEnv(new QQEnvImp()).setDiskIoExecutor(new GameEngineLoadTask.2(this)).setLog(GameLog.getInstance()).setSoLoader(new GameSoLoader(paramInstalledEngine));
        Object localObject2 = getClass().getClassLoader();
        if (hasNewEngineDex())
        {
          GameLog.getInstance().i("EngineLoadTask", "[MiniEng] TTEngineBuilder create TTEngine from dex");
          MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 1003, "1");
          localObject2 = ((TTEngineBuilder)localObject1).createInstance(new MiniAppClassloader(getTritonDexPath(), this.mContext.getApplicationInfo().nativeLibraryDir, getClass().getClassLoader()));
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 1004, "1");
            localObject1 = localObject2;
          }
          localAPIProxyImpl.setTTEngine((ITTEngine)localObject1);
          this.mGameEngine.setBaseEngine((ITTEngine)localObject1);
          if (localObject1 == null)
          {
            GameLog.getInstance().e("EngineLoadTask", "[MiniEng] TTEngineBuilder create TTEngine return null");
            i = 106;
          }
        }
        else
        {
          GameLog.getInstance().i("EngineLoadTask", "[MiniEng] TTEngineBuilder create TTEngine from local lib");
          localObject1 = ((TTEngineBuilder)localObject1).createInstance((ClassLoader)localObject2);
          continue;
        }
        long l = System.currentTimeMillis();
        GameLog.getInstance().i("EngineLoadTask", "[MiniEng] initEngine");
        this.mInspectorAgentWrapper = new bewd();
        i = ((ITTEngine)localObject1).initEngine(this.mContext, null, this.mInspectorAgentWrapper);
        if (i != 0)
        {
          GameLog.getInstance().e("EngineLoadTask", "[MiniEng] initEngine fail");
          paramInstalledEngine.loadStatus = 2;
          if (i == 1001) {
            i = 107;
          }
        }
        else
        {
          paramInstalledEngine.loadStatus = 3;
          QLog.e("[minigame][timecost] ", 1, "[MiniEng] step[initTTEngine] cost time " + (System.currentTimeMillis() - l) + ", includes steps[load so, cache jssdk]");
          MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 1015, "1");
          i = 0;
          continue;
        }
        if (i != 2001) {
          break label419;
        }
      }
      finally {}
      int i = 108;
      continue;
      label419:
      i = 109;
    }
  }
  
  private void rebindChannelIfNecessary()
  {
    TTHandleThread.getInstance().postDelayed(new GameEngineLoadTask.1(this), 100L);
  }
  
  private void sendCommand(int paramInt, Bundle paramBundle)
  {
    paramBundle.putInt("baseLibType", 2);
    paramBundle.putInt("enginePid", Process.myPid());
    GameLog.getInstance().i("EngineLoadTask", "[MiniEng]installEngineRequestCount, " + this.installEngineRequestCount + " upgradeEngineRequestCount, " + this.upgradeEngineRequestCount + "," + paramInt);
    if (paramInt == 5) {
      this.upgradeEngineRequestCount += 1;
    }
    if (paramInt == 3) {
      this.installEngineRequestCount += 1;
    }
    if (this.mEngineChannel != null)
    {
      this.mEngineChannel.send(paramInt, paramBundle);
      return;
    }
    GameLog.getInstance().w("EngineLoadTask", "[MiniEng]" + this + "failed sendCommand mEngineChannel is null");
  }
  
  private boolean verifyEngine(InstalledEngine paramInstalledEngine)
  {
    if ((paramInstalledEngine == null) || (TextUtils.isEmpty(paramInstalledEngine.engineDir))) {
      return false;
    }
    File localFile = new File(paramInstalledEngine.engineDir);
    if ((!localFile.exists()) || (localFile.isFile())) {
      return false;
    }
    boolean bool;
    try
    {
      localObject1 = new File(localFile, "verify.json");
      if ((((File)localObject1).exists()) && (((File)localObject1).isFile())) {
        break label134;
      }
      GameLog.getInstance().i("EngineLoadTask", "[MiniEng]verifyEngine " + paramInstalledEngine + " has no verify.json, skip!");
      return true;
    }
    catch (Throwable paramInstalledEngine)
    {
      GameLog.getInstance().e("EngineLoadTask", "[MiniEng]verifyEngine exception.", paramInstalledEngine);
      bool = false;
    }
    return bool;
    label134:
    Object localObject1 = FileUtils.readFileToString((File)localObject1);
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      GameLog.getInstance().i("EngineLoadTask", "[MiniEng]verifyEngine " + paramInstalledEngine + " verify.json has no content, skip!");
      return true;
    }
    if (QLog.isColorLevel()) {
      GameLog.getInstance().d("EngineLoadTask", "[MiniEng]verifyEngine " + paramInstalledEngine + " content:" + (String)localObject1);
    }
    localObject1 = new JSONObject((String)localObject1);
    if (!((JSONObject)localObject1).has("verify_list"))
    {
      GameLog.getInstance().i("EngineLoadTask", "[MiniEng]verifyEngine " + paramInstalledEngine + " verify.json has no verify_list, skip!");
      return true;
    }
    paramInstalledEngine = ((JSONObject)localObject1).getJSONArray("verify_list");
    int i = 0;
    for (;;)
    {
      if (i < paramInstalledEngine.length())
      {
        if (paramInstalledEngine.get(i) == null)
        {
          GameLog.getInstance().e("EngineLoadTask", "[MiniEng]配置文件格式异常！！请使用json工具检测");
          break label627;
        }
        Object localObject3 = (JSONObject)paramInstalledEngine.get(i);
        localObject1 = ((JSONObject)localObject3).optString("name");
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label627;
        }
        Object localObject2 = new File(localFile, (String)localObject1);
        if ((!((File)localObject2).exists()) || (!((File)localObject2).isFile()))
        {
          GameLog.getInstance().w("EngineLoadTask", "[MiniEng] verifyEngine file " + (String)localObject1 + " not found");
          bool = false;
          break;
        }
        int j = ((JSONObject)localObject3).optInt("length");
        if ((j > 0) && (((File)localObject2).length() != j))
        {
          GameLog.getInstance().w("EngineLoadTask", "[MiniEng] verifyEngine file " + (String)localObject1 + " length fail, config_length:" + j + ", local_length:" + ((File)localObject2).length());
          bool = false;
          break;
        }
        localObject3 = ((JSONObject)localObject3).optString("md5");
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          break label627;
        }
        localObject2 = calcMD5(((File)localObject2).getAbsolutePath());
        if ((TextUtils.isEmpty((CharSequence)localObject2)) || (((String)localObject3).equalsIgnoreCase((String)localObject2))) {
          break label627;
        }
        GameLog.getInstance().w("EngineLoadTask", "[MiniEng] verifyEngine file " + (String)localObject1 + " md5 fail, config_md5:" + (String)localObject3 + ", local_md5:" + (String)localObject2);
        bool = false;
        break;
      }
      bool = true;
      break;
      label627:
      i += 1;
    }
  }
  
  public void executeAsync()
  {
    this.ackCount = new AtomicInteger(0);
    if (this.mEngineChannel == null)
    {
      rebindChannelIfNecessary();
      return;
    }
    initOutChannel();
    rebindChannelIfNecessary();
  }
  
  public MiniAppConfig getAppConfig()
  {
    return this.appConfig;
  }
  
  public String getBaseEnginePath()
  {
    InstalledEngine localInstalledEngine = getEngine();
    if (localInstalledEngine != null)
    {
      if (localInstalledEngine.isVerify) {
        return localInstalledEngine.engineDir + "/";
      }
      GameLog.getInstance().e("EngineLoadTask", "[MiniEng] getBaseEnginePath failed, engine:" + localInstalledEngine + DebugUtil.getStackTrace());
    }
    return null;
  }
  
  public InstalledEngine getEngine()
  {
    return this.mEngine;
  }
  
  public ITTEngine getGameEngine()
  {
    return this.mGameEngine;
  }
  
  public bewd getInspectorAgentWrapper()
  {
    return this.mInspectorAgentWrapper;
  }
  
  public void onReceiveData(int paramInt, Bundle paramBundle)
  {
    GameLog.getInstance().i("EngineLoadTask", "[MiniEng] onReceiveData what=" + paramInt);
    if (paramBundle != null) {
      paramBundle.setClassLoader(getClass().getClassLoader());
    }
    if (paramInt == 55) {
      this.ackCount.getAndIncrement();
    }
    if (paramInt == 51) {
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getParcelableArrayList("installedEngineList");
        if (paramBundle != null)
        {
          paramInt = paramBundle.size();
          GameLog.getInstance().i("EngineLoadTask", "[MiniEng] getInstalledEngineList success " + paramInt);
          if (paramInt > 0)
          {
            paramBundle = (InstalledEngine)paramBundle.get(0);
            if (!verifyEngine(paramBundle))
            {
              GameLog.getInstance().e("EngineLoadTask", "[MiniEng] verifyEngine fail. " + paramBundle);
              onTaskFailed(this.mEngineLoadResult, "加载引擎失败");
            }
          }
        }
      }
    }
    do
    {
      String str;
      float f;
      do
      {
        do
        {
          return;
          if (this.appConfig == null)
          {
            this.mEngine = paramBundle;
            if (this.mEngineLoadResult != -1)
            {
              GameLog.getInstance().w("EngineLoadTask", "[MiniEng] engine already loaded! status=" + this.mEngineLoadResult);
              return;
            }
            this.mEngineLoadResult = loadEngine(this.mEngine);
            if (this.mEngineLoadResult == 0)
            {
              onTaskSucceed();
              return;
            }
            onTaskFailed(this.mEngineLoadResult, ajya.a(2131705058));
            return;
          }
          if (isGameSatisfy(paramBundle, this.appConfig))
          {
            this.mEngine = paramBundle;
            MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 1012, "1");
            if (this.mEngineLoadResult != -1)
            {
              GameLog.getInstance().w("EngineLoadTask", "[MiniEng] engine already loaded! status=" + this.mEngineLoadResult);
              return;
            }
            this.mEngineLoadResult = loadEngine(this.mEngine);
            if (this.mEngineLoadResult == 0)
            {
              onTaskSucceed();
              return;
            }
            MiniProgramLpReportDC04239.reportPageView(this.appConfig, "1", null, "load_fail", "load_baselib_fail");
            MiniAppReportManager2.reportPageView("2launch_fail", "load_baselib_fail", null, this.appConfig);
            onTaskFailed(this.mEngineLoadResult, ajya.a(2131705058));
            return;
          }
          if ((this.appConfig != null) && (this.appConfig.config != null) && (!TextUtils.isEmpty(this.appConfig.config.appId))) {
            MiniAppStartState.setBaseLibLoad(this.appConfig.config.appId, false);
          }
          GameLog.getInstance().i("EngineLoadTask", "[MiniEng] engine version is too low, send cmd WHAT_UPGRADE_ENGINE");
          if (this.upgradeEngineRequestCount >= 1)
          {
            GameLog.getInstance().i("EngineLoadTask", "[MiniEng]upgradeEngineRequestCount reaches max 1");
            onTaskFailed(104, "请升级QQ版本");
            return;
          }
          sendCommand(5, new Bundle());
          return;
          if ((this.appConfig != null) && (this.appConfig.config != null) && (!TextUtils.isEmpty(this.appConfig.config.appId))) {
            MiniAppStartState.setBaseLibLoad(this.appConfig.config.appId, false);
          }
          GameLog.getInstance().i("EngineLoadTask", "[MiniEng] no engine installed, send cmd WHAT_INSTALL_LATEST_ENGINE");
          if (this.installEngineRequestCount >= 2)
          {
            GameLog.getInstance().i("EngineLoadTask", "[MiniEng]installEngineRequestCount reaches max 2");
            onTaskFailed(103, ajya.a(2131705057));
            return;
          }
          sendCommand(3, new Bundle());
          return;
          GameLog.getInstance().i("EngineLoadTask", "[MiniEng] getInstalledEngineList gameEngineList is null");
          onTaskFailed(102, ajya.a(2131705056));
          return;
          GameLog.getInstance().i("EngineLoadTask", "[MiniEng] getInstalledEngineList data is null");
          onTaskFailed(102, ajya.a(2131705059));
          return;
          if (paramInt == 52)
          {
            GameLog.getInstance().i("EngineLoadTask", "[MiniEng]EVENT_INSTALL_LATEST_ENGINE_BEGIN");
            return;
          }
          if (paramInt != 53) {
            break;
          }
        } while (paramBundle == null);
        str = paramBundle.getString("engineInstallerMessage");
        f = paramBundle.getFloat("engineInstallerProgress");
        GameLog.getInstance().i("EngineLoadTask", "[MiniEng]EVENT_INSTALL_LATEST_ENGINE_PROCESS " + str + this.mGameLoadListener + ",allowPostProgress:" + this.allowPostProgress);
      } while ((this.mGameLoadListener == null) || (!this.allowPostProgress));
      this.mGameLoadListener.onTaskProgress(this, f, str);
      return;
    } while (paramInt != 54);
    GameLog.getInstance().i("EngineLoadTask", "[MiniEng]EVENT_INSTALL_LATEST_ENGINE_FINISH");
    sendCommand(1, new Bundle());
  }
  
  public void reset()
  {
    try
    {
      GameLog.getInstance().i("EngineLoadTask", "[MiniEng]" + this + " reset ");
      this.installEngineRequestCount = 0;
      this.upgradeEngineRequestCount = 0;
      this.appConfig = null;
      this.mEngine = null;
      this.allowPostProgress = false;
      this.ackCount = null;
      this.mEngineLoadResult = -1;
      super.reset();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setAppConfig(MiniAppConfig paramMiniAppConfig)
  {
    this.appConfig = paramMiniAppConfig;
  }
  
  public void setEngineChannel(EngineChannel paramEngineChannel)
  {
    this.mEngineChannel = paramEngineChannel;
  }
  
  public void setGameLoadListener(GameLoadManager.GameLoadListener paramGameLoadListener)
  {
    this.mGameLoadListener = paramGameLoadListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.task.GameEngineLoadTask
 * JD-Core Version:    0.7.0.1
 */