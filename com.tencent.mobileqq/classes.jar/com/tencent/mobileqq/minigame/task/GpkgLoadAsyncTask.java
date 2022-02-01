package com.tencent.mobileqq.minigame.task;

import amtj;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.tfs.AsyncTask;
import com.tencent.mobileqq.mini.tfs.TaskExecutionStatics;
import com.tencent.mobileqq.mini.tfs.TaskExecutionStatics.Status;
import com.tencent.mobileqq.minigame.gpkg.GpkgManager;
import com.tencent.mobileqq.minigame.gpkg.GpkgManager.Info;
import com.tencent.mobileqq.minigame.gpkg.MiniGamePkg;
import com.tencent.mobileqq.minigame.manager.GameRuntimeLoader.GameRuntimeProgressListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GpkgLoadAsyncTask
  extends AsyncTask
{
  private final String LOG_TAG = toString();
  private GpkgManager.Info mGpkgInitResult;
  private String mLoadingAppId;
  private GameRuntimeLoader.GameRuntimeProgressListener mProgressListener;
  private MiniAppConfig miniAppConfig;
  private MiniGamePkg miniGamePkg;
  
  public GpkgLoadAsyncTask(Context paramContext)
  {
    super(paramContext);
  }
  
  private ArrayList<TaskExecutionStatics> getStaticsFormDownload(GpkgManager.Info paramInfo)
  {
    ArrayList localArrayList = new ArrayList(4);
    localArrayList.add(new TaskExecutionStatics("Queue", paramInfo.queueTimeMs));
    localArrayList.add(new TaskExecutionStatics("Dns", paramInfo.dnsTimeMs));
    localArrayList.add(new TaskExecutionStatics("Conn", paramInfo.connectionTimeMs));
    localArrayList.add(new TaskExecutionStatics("Download", paramInfo.receiveTimeMs));
    return localArrayList;
  }
  
  public void executeAsync()
  {
    if ((this.miniAppConfig == null) || (this.miniAppConfig.config == null) || (this.miniAppConfig.config.appId == null))
    {
      String str = this.LOG_TAG;
      StringBuilder localStringBuilder = new StringBuilder().append("[Gpkg] loadGpkgByConfig failed ").append(this.miniAppConfig).append(",");
      if (this.miniAppConfig != null) {}
      for (Object localObject = this.miniAppConfig.config;; localObject = "")
      {
        QLog.e(str, 1, localObject);
        onTaskFailed(2002, amtj.a(2131704428));
        return;
      }
    }
    if ((this.miniGamePkg != null) && (this.miniAppConfig.config.appId.equals(this.miniGamePkg.appId)))
    {
      QLog.e(this.LOG_TAG, 1, "[Gpkg] loadGpkgByConfig appid " + this.miniAppConfig.config.appId + " has loaded.");
      onTaskSucceed();
      return;
    }
    if ((this.mLoadingAppId != null) && (this.mLoadingAppId.equals(this.miniAppConfig.config.appId)))
    {
      QLog.w(this.LOG_TAG, 1, "[Gpkg] loadGpkgByConfig appid " + this.miniAppConfig.config.appId + " is loading.");
      return;
    }
    QLog.i(this.LOG_TAG, 1, "[Gpkg] start loadGpkgByConfig appid:" + this.miniAppConfig.config.appId);
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
  
  @NonNull
  public String getName()
  {
    return "GpkgLoadAsyncTask";
  }
  
  @Nullable
  public List<TaskExecutionStatics> getSubTaskExecutionStatics()
  {
    if (this.mGpkgInitResult == null) {
      this.mGpkgInitResult = new GpkgManager.Info();
    }
    for (int i = 1;; i = 0)
    {
      if (this.mGpkgInitResult.plugin == null) {
        this.mGpkgInitResult.plugin = new GpkgManager.Info();
      }
      for (int j = 1;; j = 0)
      {
        long l = this.mGpkgInitResult.plugin.timeCostMs;
        Object localObject;
        label109:
        ArrayList localArrayList;
        if (j != 0)
        {
          localObject = TaskExecutionStatics.Status.CACHED;
          if (this.mGpkgInitResult.plugin.message == null) {
            break label220;
          }
          str = "|| " + this.mGpkgInitResult.plugin.message;
          localObject = new TaskExecutionStatics("DownloadPlugin", 0L, l, (TaskExecutionStatics.Status)localObject, str, getStaticsFormDownload(this.mGpkgInitResult.plugin));
          localArrayList = getStaticsFormDownload(this.mGpkgInitResult);
          localArrayList.add(localObject);
          l = this.mGpkgInitResult.timeCostMs;
          if (i == 0) {
            break label227;
          }
          localObject = TaskExecutionStatics.Status.CACHED;
          label172:
          if (this.mGpkgInitResult.message == null) {
            break label235;
          }
        }
        label220:
        label227:
        label235:
        for (String str = this.mGpkgInitResult.message;; str = "")
        {
          return Collections.singletonList(new TaskExecutionStatics("DownloadGpkg", 0L, l, (TaskExecutionStatics.Status)localObject, str, localArrayList));
          localObject = TaskExecutionStatics.Status.SUCCESS;
          break;
          str = "";
          break label109;
          localObject = TaskExecutionStatics.Status.SUCCESS;
          break label172;
        }
      }
    }
  }
  
  public long getTotalRunDurationMs()
  {
    return getRunDurationMs();
  }
  
  public void reset()
  {
    QLog.i(this.LOG_TAG, 1, "[Gpkg]" + this + " reset ");
    super.reset();
    this.miniGamePkg = null;
    this.mLoadingAppId = null;
    this.mProgressListener = null;
  }
  
  public void setMiniAppConfig(MiniAppConfig paramMiniAppConfig)
  {
    this.miniAppConfig = paramMiniAppConfig;
  }
  
  public void setProgressListener(GameRuntimeLoader.GameRuntimeProgressListener paramGameRuntimeProgressListener)
  {
    this.mProgressListener = paramGameRuntimeProgressListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.task.GpkgLoadAsyncTask
 * JD-Core Version:    0.7.0.1
 */