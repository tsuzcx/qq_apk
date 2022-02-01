package com.tencent.qqmini.sdk.manager;

import android.content.Context;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.action.EngineChannel;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;
import com.tencent.qqmini.sdk.task.BaseTask;
import com.tencent.qqmini.sdk.task.MiniAppEngineLoadTask;
import com.tencent.qqmini.sdk.task.TaskFlowEngine;

public class MiniLoadManager
  extends TaskFlowEngine
{
  public static final String LOG_TAG = "MiniLoadManager";
  private static volatile MiniLoadManager sInstance;
  private boolean baseDownloadEngineLoaded;
  private MiniLoadManager.MiniLoadListener mDownLoadListener;
  private MiniAppEngineLoadTask mMiniAppEngineLoadTask;
  
  public static MiniLoadManager g()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new MiniLoadManager();
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  public void attachDownloadListener(MiniLoadManager.MiniLoadListener paramMiniLoadListener)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[MiniEng]attachDownloadListener ");
    ((StringBuilder)localObject).append(paramMiniLoadListener);
    QMLog.i("MiniLoadManager", ((StringBuilder)localObject).toString());
    this.mDownLoadListener = paramMiniLoadListener;
    this.mMiniAppEngineLoadTask.setDownloadListener(paramMiniLoadListener);
    if (this.mMiniAppEngineLoadTask.isDone())
    {
      QMLog.i("MiniLoadManager", "[MiniEng]attachDownloadListener after mMiniAppEngineLoadTask isDone");
      if (paramMiniLoadListener != null)
      {
        boolean bool = this.mMiniAppEngineLoadTask.isSucceed();
        if (this.mMiniAppEngineLoadTask.msg == null) {
          localObject = "";
        } else {
          localObject = this.mMiniAppEngineLoadTask.msg;
        }
        paramMiniLoadListener.onEngineLoad(bool, (String)localObject);
      }
    }
  }
  
  public void configTask(Context paramContext, BaseRuntimeLoader paramBaseRuntimeLoader)
  {
    QMLog.i("MiniLoadManager", "[MiniEng]configTask MiniAppEngineLoadTask");
    this.mMiniAppEngineLoadTask = new MiniAppEngineLoadTask(paramContext, paramBaseRuntimeLoader);
    initTasks(new BaseTask[] { this.mMiniAppEngineLoadTask });
  }
  
  public void detachDownloadListener(MiniLoadManager.MiniLoadListener paramMiniLoadListener)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[MiniEng]detachDownloadListener in:");
    localStringBuilder.append(paramMiniLoadListener);
    localStringBuilder.append(",current:");
    localStringBuilder.append(this.mDownLoadListener);
    QMLog.i("MiniLoadManager", localStringBuilder.toString());
    if ((paramMiniLoadListener != null) && (paramMiniLoadListener.equals(this.mDownLoadListener)))
    {
      this.mDownLoadListener = null;
      this.mMiniAppEngineLoadTask.setDownloadListener(null);
      return;
    }
    QMLog.w("MiniLoadManager", "[MiniEng]detachDownloadListener failed");
  }
  
  public String getBaseEnginePath()
  {
    InstalledEngine localInstalledEngine = this.mMiniAppEngineLoadTask.getEngine();
    if ((localInstalledEngine != null) && (localInstalledEngine.isVerify))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localInstalledEngine.engineDir);
      localStringBuilder.append("/");
      return localStringBuilder.toString();
    }
    return null;
  }
  
  public String getEngineVersion()
  {
    InstalledEngine localInstalledEngine = this.mMiniAppEngineLoadTask.getEngine();
    if ((localInstalledEngine != null) && (localInstalledEngine.isVerify)) {
      return String.valueOf(localInstalledEngine.engineVersion);
    }
    return "";
  }
  
  public void onTaskDone(BaseTask paramBaseTask)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[MiniEng]");
    ((StringBuilder)localObject).append(paramBaseTask);
    ((StringBuilder)localObject).append(" done! succ:");
    ((StringBuilder)localObject).append(paramBaseTask.isSucceed());
    ((StringBuilder)localObject).append(", listener=");
    ((StringBuilder)localObject).append(this.mMiniAppEngineLoadTask);
    QMLog.i("MiniLoadManager", ((StringBuilder)localObject).toString());
    if ((paramBaseTask instanceof MiniAppEngineLoadTask)) {
      if (!paramBaseTask.isSucceed())
      {
        localObject = this.mDownLoadListener;
        if (localObject != null) {
          ((MiniLoadManager.MiniLoadListener)localObject).onEngineLoad(false, ((MiniAppEngineLoadTask)paramBaseTask).msg);
        }
        this.baseDownloadEngineLoaded = false;
      }
      else
      {
        localObject = this.mDownLoadListener;
        if (localObject != null) {
          ((MiniLoadManager.MiniLoadListener)localObject).onEngineLoad(true, "");
        }
        this.baseDownloadEngineLoaded = true;
      }
    }
    super.onTaskDone(paramBaseTask);
  }
  
  public void setDownloadEngineChannel(EngineChannel paramEngineChannel)
  {
    this.mMiniAppEngineLoadTask.setEngineChannel(paramEngineChannel);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[MiniEng]setDownloadEngineChannel ");
    localStringBuilder.append(paramEngineChannel);
    localStringBuilder.append(", ");
    localStringBuilder.append(AppLoaderFactory.g().getProcessName());
    QMLog.i("MiniLoadManager", localStringBuilder.toString());
  }
  
  @Deprecated
  public void start()
  {
    QMLog.w("MiniLoadManager", "[MiniEng]start does nothing, use start(MiniAppConfig) instead");
  }
  
  public void startDownload(MiniLoadManager.MiniLoadListener paramMiniLoadListener)
  {
    this.baseDownloadEngineLoaded = false;
    resetTaskAndDepends(this.mMiniAppEngineLoadTask);
    attachDownloadListener(paramMiniLoadListener);
    super.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.MiniLoadManager
 * JD-Core Version:    0.7.0.1
 */