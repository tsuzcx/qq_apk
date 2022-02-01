package com.tencent.mobileqq.minigame.manager;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.tfs.BaseTask;
import com.tencent.mobileqq.minigame.splash.SplashMiniGameData;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PreloadManager
  implements GameRuntimeLoader.GameRuntimeListener
{
  public static final int PRELOAD_STATE_ERROR = 3;
  public static final int PRELOAD_STATE_LOADED = 2;
  public static final int PRELOAD_STATE_LOADING = 1;
  public static final int PRELOAD_STATE_NONE = 0;
  private static final String TAG = "PreloadManager";
  private static PreloadManager instance;
  private MiniAppConfig mMiniAppConfig;
  private PreloadManager.PreloadListener mPreloadListener;
  private GameRuntimeLoader mPreloadRuntimeLoader;
  private volatile float mProgress = 0.0F;
  public String mSlashPic;
  public String mStartBtnPic;
  private int mState = 0;
  
  public static PreloadManager g()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new PreloadManager();
      }
      return instance;
    }
    finally {}
  }
  
  private void initData(SplashMiniGameData paramSplashMiniGameData)
  {
    MiniAppInfo localMiniAppInfo = new MiniAppInfo();
    localMiniAppInfo.appId = paramSplashMiniGameData.appId;
    localMiniAppInfo.setEngineType(1);
    localMiniAppInfo.setReportType(1);
    localMiniAppInfo.baselibMiniVersion = "1.2.0";
    localMiniAppInfo.desc = paramSplashMiniGameData.desc;
    localMiniAppInfo.developerDesc = paramSplashMiniGameData.developerDesc;
    localMiniAppInfo.downloadUrl = paramSplashMiniGameData.downloadUrl;
    localMiniAppInfo.fileSize = paramSplashMiniGameData.fileSize;
    localMiniAppInfo.iconUrl = paramSplashMiniGameData.iconUrl;
    localMiniAppInfo.name = paramSplashMiniGameData.name;
    localMiniAppInfo.verType = 3;
    localMiniAppInfo.version = paramSplashMiniGameData.version;
    localMiniAppInfo.downloadFileDomainList = paramSplashMiniGameData.downloadFileDomianList;
    localMiniAppInfo.requestDomainList = paramSplashMiniGameData.requestDomianList;
    localMiniAppInfo.whiteList = new ArrayList();
    localMiniAppInfo.whiteList.add("reportSubmitForm");
    localMiniAppInfo.whiteList.add("requestPayment");
    localMiniAppInfo.whiteList.add("requestMidasPayment");
    localMiniAppInfo.whiteList.add("openUrl");
    LaunchParam localLaunchParam = new LaunchParam();
    localLaunchParam.miniAppId = localMiniAppInfo.appId;
    localLaunchParam.scene = 2004;
    this.mMiniAppConfig = new MiniAppConfig(localMiniAppInfo);
    this.mMiniAppConfig.launchParam = localLaunchParam;
    this.mSlashPic = paramSplashMiniGameData.picLocalPath;
    paramSplashMiniGameData = new File(this.mSlashPic).getParent() + File.separator + "startbtn.png";
    if (new File(paramSplashMiniGameData).exists()) {
      this.mStartBtnPic = paramSplashMiniGameData;
    }
  }
  
  public MiniAppConfig getMiniAppConfig()
  {
    return this.mMiniAppConfig;
  }
  
  public float getProgress()
  {
    return this.mProgress;
  }
  
  public int getState()
  {
    QLog.e("PreloadManager", 1, "michael getState = " + this.mState);
    return this.mState;
  }
  
  public void onEngineLoad(boolean paramBoolean, String paramString, int paramInt)
  {
    QLog.e("PreloadManager", 1, "onEngineLoad success" + paramBoolean);
    if (!paramBoolean) {
      this.mState = 3;
    }
    if (this.mPreloadListener != null) {
      this.mPreloadListener.onPreloadEngineLoad(paramBoolean, paramString, paramInt);
    }
  }
  
  public void onGpkgLoad(boolean paramBoolean, String paramString)
  {
    QLog.e("PreloadManager", 1, "onGpkgLoad success" + paramBoolean);
    if (!paramBoolean) {
      this.mState = 3;
    }
    for (;;)
    {
      if (this.mPreloadListener != null) {
        this.mPreloadListener.onPreloadGpkgLoad(paramBoolean, paramString);
      }
      return;
      if (this.mPreloadRuntimeLoader != null) {
        this.mPreloadRuntimeLoader.getGameInfoManager().setMiniAppConfig(this.mMiniAppConfig);
      }
    }
  }
  
  public void onInitRuntimeDone()
  {
    QLog.e("PreloadManager", 1, "onInitRuntimeDone");
    this.mState = 2;
    this.mProgress = 100.0F;
    if (this.mPreloadListener != null) {
      this.mPreloadListener.onPreloadInitRuntimeDone();
    }
    this.mPreloadListener = null;
  }
  
  public void onJsPluginEngineLoad(boolean paramBoolean, String paramString)
  {
    QLog.e("PreloadManager", 1, "onJsPluginEngineLoad success" + paramBoolean);
  }
  
  public void onTaskProgress(BaseTask paramBaseTask, float paramFloat, String paramString)
  {
    QLog.e("PreloadManager", 1, "onTaskProgress progress" + paramFloat);
    this.mProgress = paramFloat;
    if (this.mPreloadListener != null) {
      this.mPreloadListener.onPreloadTaskProgress(paramBaseTask, paramFloat, paramString);
    }
  }
  
  public void setListener(PreloadManager.PreloadListener paramPreloadListener)
  {
    this.mPreloadListener = paramPreloadListener;
  }
  
  public void start(SplashMiniGameData paramSplashMiniGameData)
  {
    initData(paramSplashMiniGameData);
    this.mState = 1;
    this.mPreloadRuntimeLoader = GameRuntimeLoaderManager.g().obtain(BaseApplicationImpl.getApplication()).registerListener(this).prepareGameRuntime(this.mMiniAppConfig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.PreloadManager
 * JD-Core Version:    0.7.0.1
 */