package com.tencent.qqmini.minigame.task;

import android.content.Context;
import android.support.annotation.Nullable;
import com.tencent.qqmini.minigame.gpkg.GpkgManager;
import com.tencent.qqmini.minigame.gpkg.GpkgManager.Info;
import com.tencent.qqmini.minigame.gpkg.MiniGamePkg;
import com.tencent.qqmini.sdk.annotation.ClassTag;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;
import com.tencent.qqmini.sdk.task.AsyncTask;
import com.tencent.qqmini.sdk.task.TaskExecutionStatics;
import com.tencent.qqmini.sdk.task.TaskExecutionStatics.Status;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ClassTag(tag="GpkgLoadAsyncTask")
public class GpkgLoadAsyncTask
  extends AsyncTask
{
  public static final String LOG_TAG = "GpkgLoadAsyncTask";
  private GpkgManager.Info mGpkgInitResult;
  private String mLoadingAppId;
  private MiniAppInfo miniAppInfo;
  private MiniGamePkg miniGamePkg;
  
  public GpkgLoadAsyncTask(Context paramContext, BaseRuntimeLoader paramBaseRuntimeLoader)
  {
    super(paramContext, paramBaseRuntimeLoader);
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
  
  private void loadGpkgByMiniAppInfo(MiniAppInfo paramMiniAppInfo)
  {
    if ((paramMiniAppInfo == null) || (paramMiniAppInfo.appId == null))
    {
      QMLog.e("GpkgLoadAsyncTask", "[Gpkg] loadGpkgByConfig failed " + paramMiniAppInfo);
      onTaskFailed(2002, "配置错误");
      return;
    }
    if ((this.miniGamePkg != null) && (paramMiniAppInfo.appId.equals(this.miniGamePkg.appId)))
    {
      QMLog.i("GpkgLoadAsyncTask", "[Gpkg] loadGpkgByConfig appid " + paramMiniAppInfo.appId + " has loaded.");
      onTaskSucceed();
      return;
    }
    if ((this.mLoadingAppId != null) && (this.mLoadingAppId.equals(paramMiniAppInfo.appId)))
    {
      QMLog.i("GpkgLoadAsyncTask", "[Gpkg] loadGpkgByConfig appid " + paramMiniAppInfo.appId + " is loading.");
      return;
    }
    QMLog.i("GpkgLoadAsyncTask", "[Gpkg] start loadGpkgByConfig appid:" + paramMiniAppInfo.appId);
    this.mLoadingAppId = paramMiniAppInfo.appId;
    this.miniGamePkg = null;
    GpkgManager.getGpkgInfoByConfig(paramMiniAppInfo, new GpkgLoadAsyncTask.1(this, System.currentTimeMillis()));
  }
  
  public void executeAsync()
  {
    QMLog.i("GpkgLoadAsyncTask", "executeAsync(). " + this.miniAppInfo);
    loadGpkgByMiniAppInfo(this.miniAppInfo);
  }
  
  public MiniGamePkg getGpkgInfo()
  {
    return this.miniGamePkg;
  }
  
  public MiniAppInfo getMiniAppInfo()
  {
    return this.miniAppInfo;
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
    QMLog.i("GpkgLoadAsyncTask", "[Gpkg]" + this + " reset ");
    super.reset();
    this.miniGamePkg = null;
    this.mLoadingAppId = null;
  }
  
  public void setMiniAppInfo(MiniAppInfo paramMiniAppInfo)
  {
    this.miniAppInfo = paramMiniAppInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.task.GpkgLoadAsyncTask
 * JD-Core Version:    0.7.0.1
 */