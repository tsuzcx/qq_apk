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
    if ((paramMiniAppInfo != null) && (paramMiniAppInfo.appId != null))
    {
      if ((this.miniGamePkg != null) && (paramMiniAppInfo.appId.equals(this.miniGamePkg.appId)))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[Gpkg] loadGpkgByConfig appid ");
        ((StringBuilder)localObject).append(paramMiniAppInfo.appId);
        ((StringBuilder)localObject).append(" has loaded.");
        QMLog.i("GpkgLoadAsyncTask", ((StringBuilder)localObject).toString());
        onTaskSucceed();
        return;
      }
      localObject = this.mLoadingAppId;
      if ((localObject != null) && (((String)localObject).equals(paramMiniAppInfo.appId)))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[Gpkg] loadGpkgByConfig appid ");
        ((StringBuilder)localObject).append(paramMiniAppInfo.appId);
        ((StringBuilder)localObject).append(" is loading.");
        QMLog.i("GpkgLoadAsyncTask", ((StringBuilder)localObject).toString());
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[Gpkg] start loadGpkgByConfig appid:");
      ((StringBuilder)localObject).append(paramMiniAppInfo.appId);
      QMLog.i("GpkgLoadAsyncTask", ((StringBuilder)localObject).toString());
      this.mLoadingAppId = paramMiniAppInfo.appId;
      this.miniGamePkg = null;
      GpkgManager.getGpkgInfoByConfig(paramMiniAppInfo, new GpkgLoadAsyncTask.1(this, System.currentTimeMillis()));
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[Gpkg] loadGpkgByConfig failed ");
    ((StringBuilder)localObject).append(paramMiniAppInfo);
    QMLog.e("GpkgLoadAsyncTask", ((StringBuilder)localObject).toString());
    onTaskFailed(2002, "配置错误");
  }
  
  public void executeAsync()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("executeAsync(). ");
    localStringBuilder.append(this.miniAppInfo);
    QMLog.i("GpkgLoadAsyncTask", localStringBuilder.toString());
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
  protected List<TaskExecutionStatics> getSubTaskExecutionStatics()
  {
    Object localObject1 = this.mGpkgInitResult;
    int j = 1;
    int i;
    if (localObject1 == null)
    {
      this.mGpkgInitResult = new GpkgManager.Info();
      i = 1;
    }
    else
    {
      i = 0;
    }
    if (this.mGpkgInitResult.plugin == null) {
      this.mGpkgInitResult.plugin = new GpkgManager.Info();
    } else {
      j = 0;
    }
    long l = this.mGpkgInitResult.plugin.timeCostMs;
    if (j != 0) {
      localObject1 = TaskExecutionStatics.Status.CACHED;
    } else {
      localObject1 = TaskExecutionStatics.Status.SUCCESS;
    }
    Object localObject2 = this.mGpkgInitResult.plugin.message;
    String str = "";
    if (localObject2 != null)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("|| ");
      ((StringBuilder)localObject2).append(this.mGpkgInitResult.plugin.message);
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    else
    {
      localObject2 = "";
    }
    localObject1 = new TaskExecutionStatics("DownloadPlugin", 0L, l, (TaskExecutionStatics.Status)localObject1, (String)localObject2, getStaticsFormDownload(this.mGpkgInitResult.plugin));
    ArrayList localArrayList = getStaticsFormDownload(this.mGpkgInitResult);
    localArrayList.add(localObject1);
    l = this.mGpkgInitResult.timeCostMs;
    if (i != 0) {
      localObject1 = TaskExecutionStatics.Status.CACHED;
    } else {
      localObject1 = TaskExecutionStatics.Status.SUCCESS;
    }
    localObject2 = str;
    if (this.mGpkgInitResult.message != null) {
      localObject2 = this.mGpkgInitResult.message;
    }
    return Collections.singletonList(new TaskExecutionStatics("DownloadGpkg", 0L, l, (TaskExecutionStatics.Status)localObject1, (String)localObject2, localArrayList));
  }
  
  public long getTotalRunDurationMs()
  {
    return getRunDurationMs();
  }
  
  public void reset()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[Gpkg]");
    localStringBuilder.append(this);
    localStringBuilder.append(" reset ");
    QMLog.i("GpkgLoadAsyncTask", localStringBuilder.toString());
    super.reset();
    this.miniGamePkg = null;
    this.mLoadingAppId = null;
  }
  
  public void setMiniAppInfo(MiniAppInfo paramMiniAppInfo)
  {
    this.miniAppInfo = paramMiniAppInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.task.GpkgLoadAsyncTask
 * JD-Core Version:    0.7.0.1
 */