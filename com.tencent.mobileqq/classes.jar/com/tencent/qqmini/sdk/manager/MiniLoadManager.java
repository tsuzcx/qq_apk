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
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new MiniLoadManager();
      }
      return sInstance;
    }
    finally {}
  }
  
  public void attachDownloadListener(MiniLoadManager.MiniLoadListener paramMiniLoadListener)
  {
    QMLog.i("MiniLoadManager", "[MiniEng]attachDownloadListener " + paramMiniLoadListener);
    this.mDownLoadListener = paramMiniLoadListener;
    this.mMiniAppEngineLoadTask.setDownloadListener(paramMiniLoadListener);
    boolean bool;
    if (this.mMiniAppEngineLoadTask.isDone())
    {
      QMLog.i("MiniLoadManager", "[MiniEng]attachDownloadListener after mMiniAppEngineLoadTask isDone");
      if (paramMiniLoadListener != null)
      {
        bool = this.mMiniAppEngineLoadTask.isSucceed();
        if (this.mMiniAppEngineLoadTask.msg != null) {
          break label88;
        }
      }
    }
    label88:
    for (String str = "";; str = this.mMiniAppEngineLoadTask.msg)
    {
      paramMiniLoadListener.onEngineLoad(bool, str);
      return;
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
    QMLog.i("MiniLoadManager", "[MiniEng]detachDownloadListener in:" + paramMiniLoadListener + ",current:" + this.mDownLoadListener);
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
    if ((localInstalledEngine != null) && (localInstalledEngine.isVerify)) {
      return localInstalledEngine.engineDir + "/";
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
    QMLog.i("MiniLoadManager", "[MiniEng]" + paramBaseTask + " done! succ:" + paramBaseTask.isSucceed() + ", listener=" + this.mMiniAppEngineLoadTask);
    if ((paramBaseTask instanceof MiniAppEngineLoadTask))
    {
      if (paramBaseTask.isSucceed()) {
        break label97;
      }
      if (this.mDownLoadListener != null) {
        this.mDownLoadListener.onEngineLoad(false, ((MiniAppEngineLoadTask)paramBaseTask).msg);
      }
    }
    for (this.baseDownloadEngineLoaded = false;; this.baseDownloadEngineLoaded = true)
    {
      super.onTaskDone(paramBaseTask);
      return;
      label97:
      if (this.mDownLoadListener != null) {
        this.mDownLoadListener.onEngineLoad(true, "");
      }
    }
  }
  
  public void setDownloadEngineChannel(EngineChannel paramEngineChannel)
  {
    this.mMiniAppEngineLoadTask.setEngineChannel(paramEngineChannel);
    QMLog.i("MiniLoadManager", "[MiniEng]setDownloadEngineChannel " + paramEngineChannel + ", " + AppLoaderFactory.g().getProcessName());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.MiniLoadManager
 * JD-Core Version:    0.7.0.1
 */