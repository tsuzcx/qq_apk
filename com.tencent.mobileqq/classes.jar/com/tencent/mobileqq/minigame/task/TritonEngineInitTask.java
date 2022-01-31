package com.tencent.mobileqq.minigame.task;

import alud;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import bgzf;
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
import com.tencent.mobileqq.minigame.manager.EngineInstanceManager;
import com.tencent.mobileqq.minigame.manager.EngineVersion;
import com.tencent.mobileqq.minigame.manager.GameEngineWrapper;
import com.tencent.mobileqq.minigame.manager.InstalledEngine;
import com.tencent.mobileqq.minigame.utils.GameLog;
import com.tencent.mobileqq.minigame.utils.GameSoLoader;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.mobileqq.triton.sdk.APIProxy;
import com.tencent.mobileqq.triton.sdk.IQQEnv;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.mobileqq.triton.sdk.TTEngineBuilder;
import java.io.File;

public class TritonEngineInitTask
  extends AsyncTask
{
  public static final int ENG_NOT_LOAD = -1;
  public static final int ERR_ENGINE_NEED_UPDATE = 101;
  public static final int ERR_ENGINE_NULL = 105;
  public static final int ERR_ENGINE_TIMEOUT = 103;
  public static final int ERR_ENGINE_VERSION = 104;
  public static final int ERR_INIT_ENGINE = 109;
  public static final int ERR_INIT_NDK = 108;
  public static final int ERR_INTERNAL = 102;
  public static final int ERR_LOAD_JAR = 106;
  public static final int ERR_LOAD_SO = 107;
  public static final int ERR_UNKNOWN = 100;
  public static final int SUCCEED = 0;
  public final String LOG_TAG = toString();
  private APIProxy mAPIProxy;
  private MiniAppConfig mAppConfig;
  private int mEngineLoadResult = -1;
  private GameEngineWrapper mGameEngine;
  private bgzf mInspectorAgentWrapper;
  private IQQEnv mQQEnv;
  
  public TritonEngineInitTask(Context paramContext, bgzf parambgzf, IQQEnv paramIQQEnv, APIProxy paramAPIProxy)
  {
    super(paramContext);
    GameLog.getInstance().i(this.LOG_TAG, "new TritonEngineInitTask");
    this.mInspectorAgentWrapper = parambgzf;
    this.mQQEnv = paramIQQEnv;
    this.mAPIProxy = paramAPIProxy;
    this.mGameEngine = new GameEngineWrapper();
  }
  
  private String getTritonDexPath(InstalledEngine paramInstalledEngine)
  {
    if ((paramInstalledEngine == null) || (TextUtils.isEmpty(paramInstalledEngine.engineDir))) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder().append(paramInstalledEngine.engineDir);
    if (paramInstalledEngine.engineDir.endsWith(File.separator)) {}
    for (paramInstalledEngine = "";; paramInstalledEngine = File.separator) {
      return paramInstalledEngine + "triton.jar";
    }
  }
  
  private boolean hasNewEngineDex(InstalledEngine paramInstalledEngine)
  {
    if (!GameWnsUtils.gameEnableDexLoader()) {}
    do
    {
      return false;
      paramInstalledEngine = getTritonDexPath(paramInstalledEngine);
    } while (TextUtils.isEmpty(paramInstalledEngine));
    return new File(paramInstalledEngine).exists();
  }
  
  private boolean isGameSatisfy(InstalledEngine paramInstalledEngine, MiniAppConfig paramMiniAppConfig)
  {
    boolean bool = true;
    if (paramInstalledEngine == null)
    {
      GameLog.getInstance().e(this.LOG_TAG, "[MiniEng]isGameSatisfy engine == null");
      return false;
    }
    if (paramMiniAppConfig == null)
    {
      GameLog.getInstance().e(this.LOG_TAG, "[MiniEng]isGameSatisfy gameConfig == null");
      return false;
    }
    paramMiniAppConfig = paramMiniAppConfig.config;
    if (paramMiniAppConfig == null)
    {
      GameLog.getInstance().e(this.LOG_TAG, "[MiniEng]isGameSatisfy info == null");
      return false;
    }
    paramMiniAppConfig = paramMiniAppConfig.baselibMiniVersion;
    GameLog.getInstance().i(this.LOG_TAG, "[MiniEng]isGameSatisfy minVersion=" + paramMiniAppConfig);
    if (TextUtils.isEmpty(paramMiniAppConfig)) {
      return true;
    }
    paramMiniAppConfig = new EngineVersion(paramMiniAppConfig);
    if (paramInstalledEngine.engineVersion.compareTo(paramMiniAppConfig) >= 0) {}
    for (;;)
    {
      GameLog.getInstance().i(this.LOG_TAG, "[MiniEng]isGameSatisfy minEngineVersion=" + paramMiniAppConfig + ",engineVersion=" + paramInstalledEngine.engineVersion + ",ret=" + bool);
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
          GameLog.getInstance().i(this.LOG_TAG, "[MiniEng] installedEngine == null, loadEngineTask is reset?");
          i = 105;
          return i;
        }
        Object localObject1 = new TTEngineBuilder();
        ((TTEngineBuilder)localObject1).setApiProxy(this.mAPIProxy).setQQEnv(this.mQQEnv).setDiskIoExecutor(new TritonEngineInitTask.1(this)).setLog(GameLog.getInstance()).setSoLoader(new GameSoLoader(paramInstalledEngine));
        Object localObject2 = getClass().getClassLoader();
        if (hasNewEngineDex(paramInstalledEngine))
        {
          GameLog.getInstance().i(this.LOG_TAG, "[MiniEng] TTEngineBuilder create TTEngine from dex");
          MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 1003, "1");
          localObject2 = ((TTEngineBuilder)localObject1).createInstance(new MiniAppClassloader(getTritonDexPath(paramInstalledEngine), this.mContext.getApplicationInfo().nativeLibraryDir, getClass().getClassLoader()));
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 1004, "1");
            localObject1 = localObject2;
          }
          if (localObject1 == null)
          {
            GameLog.getInstance().e(this.LOG_TAG, "[MiniEng] TTEngineBuilder create TTEngine return null");
            i = 106;
          }
        }
        else
        {
          GameLog.getInstance().i(this.LOG_TAG, "[MiniEng] TTEngineBuilder create TTEngine from local lib");
          localObject1 = ((TTEngineBuilder)localObject1).createInstance((ClassLoader)localObject2);
          continue;
        }
        this.mGameEngine.setBaseEngine((ITTEngine)localObject1);
        long l = System.currentTimeMillis();
        GameLog.getInstance().i(this.LOG_TAG, "[MiniEng] initEngine");
        i = ((ITTEngine)localObject1).initEngine(this.mContext, null, this.mInspectorAgentWrapper);
        if (i != 0)
        {
          GameLog.getInstance().e(this.LOG_TAG, "[MiniEng] initEngine fail");
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
          break label399;
        }
      }
      finally {}
      int i = 108;
      continue;
      label399:
      i = 109;
    }
  }
  
  private void loadTritonEngine(InstalledEngine paramInstalledEngine)
  {
    if (this.mAppConfig == null)
    {
      if (this.mEngineLoadResult != -1)
      {
        GameLog.getInstance().w(this.LOG_TAG, "[MiniEng] engine already loaded! status=" + this.mEngineLoadResult);
        return;
      }
      this.mEngineLoadResult = loadEngine(paramInstalledEngine);
      if (this.mEngineLoadResult == 0)
      {
        onTaskSucceed();
        return;
      }
      onTaskFailed(this.mEngineLoadResult, alud.a(2131705442));
      return;
    }
    if (isGameSatisfy(paramInstalledEngine, this.mAppConfig))
    {
      MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 1012, "1");
      if (this.mEngineLoadResult != -1)
      {
        GameLog.getInstance().w(this.LOG_TAG, "[MiniEng] engine already loaded! status=" + this.mEngineLoadResult);
        return;
      }
      this.mEngineLoadResult = loadEngine(paramInstalledEngine);
      if (this.mEngineLoadResult == 0)
      {
        onTaskSucceed();
        return;
      }
      MiniProgramLpReportDC04239.reportPageView(this.mAppConfig, "1", null, "load_fail", "load_baselib_fail");
      MiniAppReportManager2.reportPageView("2launch_fail", "load_baselib_fail", null, this.mAppConfig);
      onTaskFailed(this.mEngineLoadResult, alud.a(2131705442));
      return;
    }
    if ((this.mAppConfig != null) && (this.mAppConfig.config != null) && (!TextUtils.isEmpty(this.mAppConfig.config.appId))) {
      MiniAppStartState.setBaseLibLoad(this.mAppConfig.config.appId, false);
    }
    onTaskFailed(104, "请升级QQ版本");
  }
  
  public void executeAsync()
  {
    loadTritonEngine(EngineInstanceManager.g().getEngineInstance());
  }
  
  public MiniAppConfig getAppConfig()
  {
    return this.mAppConfig;
  }
  
  public ITTEngine getGameEngine()
  {
    return this.mGameEngine;
  }
  
  public void reset()
  {
    try
    {
      GameLog.getInstance().i(this.LOG_TAG, "[MiniEng]" + this + " reset ");
      this.mAppConfig = null;
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
    this.mAppConfig = paramMiniAppConfig;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.task.TritonEngineInitTask
 * JD-Core Version:    0.7.0.1
 */