package com.tencent.mobileqq.minigame.task;

import ajjy;
import android.content.Context;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.tfs.AsyncTask;
import com.tencent.mobileqq.minigame.gpkg.GpkgManager;
import com.tencent.mobileqq.minigame.gpkg.MiniGamePkg;
import com.tencent.mobileqq.minigame.manager.GameLoadManager.GameLoadListener;
import com.tencent.qphone.base.util.QLog;

public class GpkgLoadAsyncTask
  extends AsyncTask
{
  public static final String LOG_TAG = "GameLoadManager";
  private GameLoadManager.GameLoadListener gameLoadListener;
  private String mLoadingAppId;
  private MiniAppConfig miniAppConfig;
  private MiniGamePkg miniGamePkg;
  
  public GpkgLoadAsyncTask(Context paramContext)
  {
    super(paramContext);
  }
  
  public void executeAsync()
  {
    if ((this.miniAppConfig == null) || (this.miniAppConfig.config == null) || (this.miniAppConfig.config.appId == null))
    {
      StringBuilder localStringBuilder = new StringBuilder().append("[Gpkg] loadGpkgByConfig failed ").append(this.miniAppConfig).append(",");
      if (this.miniAppConfig != null) {}
      for (Object localObject = this.miniAppConfig.config;; localObject = "")
      {
        QLog.e("GameLoadManager", 1, localObject);
        onTaskFailed(2002, ajjy.a(2131639520));
        return;
      }
    }
    if ((this.miniGamePkg != null) && (this.miniAppConfig.config.appId.equals(this.miniGamePkg.appId)))
    {
      QLog.e("GameLoadManager", 1, "[Gpkg] loadGpkgByConfig appid " + this.miniAppConfig.config.appId + " has loaded.");
      onTaskSucceed();
      return;
    }
    if ((this.mLoadingAppId != null) && (this.mLoadingAppId.equals(this.miniAppConfig.config.appId)))
    {
      QLog.w("GameLoadManager", 1, "[Gpkg] loadGpkgByConfig appid " + this.miniAppConfig.config.appId + " is loading.");
      return;
    }
    QLog.i("GameLoadManager", 1, "[Gpkg] start loadGpkgByConfig appid:" + this.miniAppConfig.config.appId);
    this.mLoadingAppId = this.miniAppConfig.config.appId;
    this.miniGamePkg = null;
    long l = System.currentTimeMillis();
    GpkgManager.getGpkgInfoByConfig(this.miniAppConfig, new GpkgLoadAsyncTask.1(this, l));
  }
  
  public MiniAppConfig getAppConfig()
  {
    return this.miniAppConfig;
  }
  
  public MiniGamePkg getGpkgInfo()
  {
    return this.miniGamePkg;
  }
  
  public void onTaskSucceed()
  {
    super.onTaskSucceed();
  }
  
  public void reset()
  {
    QLog.i("GameLoadManager", 1, "[Gpkg]" + this + " reset ");
    super.reset();
    this.miniGamePkg = null;
    this.mLoadingAppId = null;
  }
  
  public void setGameLoadListener(GameLoadManager.GameLoadListener paramGameLoadListener)
  {
    this.gameLoadListener = paramGameLoadListener;
  }
  
  public void setMiniAppConfig(MiniAppConfig paramMiniAppConfig)
  {
    this.miniAppConfig = paramMiniAppConfig;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.task.GpkgLoadAsyncTask
 * JD-Core Version:    0.7.0.1
 */