package com.tencent.qqmini.sdk.runtime;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.ViewGroup;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.launcher.IMiniLifecycle;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime.RuntimeMsgObserver;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.MiniProgramReportHelper;
import com.tencent.qqmini.sdk.task.BaseTask;
import com.tencent.qqmini.sdk.task.TaskFlowEngine;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@MiniKeep
public abstract class BaseRuntimeLoader
  extends TaskFlowEngine
  implements Handler.Callback, IMiniLifecycle, BaseRuntime.RuntimeMsgObserver
{
  public static final String TAG = "BaseRuntimeLoader";
  private boolean hasTaskFailed = false;
  private boolean isSucceed = false;
  private Map<String, BaseTask> mActivatedTasks;
  private final AppStateManager mAppStateManager = new AppStateManager(this);
  protected Context mContext;
  private final AppRuntimeEventCenter mEventCenter = new AppRuntimeEventCenter();
  protected boolean mIsRunning = false;
  protected MiniAppInfo mMiniAppInfo;
  protected boolean mNeedReloadPage = false;
  protected BaseRuntime mRuntime;
  protected BaseRuntimeLoader.OnAppRuntimeLoadListener mRuntimeLoadListener;
  protected boolean runtimeLoadCompleted = false;
  
  public BaseRuntimeLoader(Context paramContext)
  {
    this.mContext = paramContext;
    this.mActivatedTasks = new HashMap();
    this.mEventCenter.addObserver(this.mAppStateManager);
    this.mRuntime = createRuntime(this.mContext);
    this.mRuntime.setRuntimeMsgObserver(this);
    initTask();
  }
  
  private final void initTask()
  {
    BaseTask[] arrayOfBaseTask = createTasks();
    initTasks(arrayOfBaseTask);
    if (arrayOfBaseTask != null)
    {
      int j = arrayOfBaseTask.length;
      int i = 0;
      while (i < j)
      {
        registTaskName(arrayOfBaseTask[i]);
        i += 1;
      }
    }
  }
  
  private void registTaskName(BaseTask paramBaseTask)
  {
    if (paramBaseTask == null) {
      return;
    }
    addTask(paramBaseTask);
    paramBaseTask = paramBaseTask.getDependTasks();
    if ((paramBaseTask != null) && (paramBaseTask.size() > 0))
    {
      paramBaseTask = paramBaseTask.iterator();
      while (paramBaseTask.hasNext()) {
        registTaskName((BaseTask)paramBaseTask.next());
      }
    }
  }
  
  private void restartFailTaskIfNeed()
  {
    try
    {
      boolean bool = this.hasTaskFailed;
      if (!bool) {
        return;
      }
      this.hasTaskFailed = false;
      Iterator localIterator = this.mAllTasks.iterator();
      while (localIterator.hasNext())
      {
        BaseTask localBaseTask = (BaseTask)localIterator.next();
        if (!localBaseTask.isSucceed())
        {
          localBaseTask.reset();
          executeTask(localBaseTask);
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void addRuntimeStateObserver(AppRuntimeEventCenter.RuntimeStateObserver paramRuntimeStateObserver)
  {
    this.mEventCenter.addObserver(paramRuntimeStateObserver);
  }
  
  public void addTask(BaseTask paramBaseTask)
  {
    if (paramBaseTask == null) {
      return;
    }
    String str = paramBaseTask.getClass().getCanonicalName();
    if (this.mActivatedTasks.containsKey(str)) {
      return;
    }
    this.mActivatedTasks.put(str, paramBaseTask);
  }
  
  protected abstract BaseRuntime createRuntime(Context paramContext);
  
  public abstract BaseTask[] createTasks();
  
  public void destroy()
  {
    pause();
    this.mRuntimeLoadListener = null;
    this.mEventCenter.deleteObservers();
    BaseRuntime localBaseRuntime = this.mRuntime;
    if (localBaseRuntime != null) {
      localBaseRuntime.onRuntimeDestroy();
    }
  }
  
  public boolean dismissLoadingAfterLoaded()
  {
    return false;
  }
  
  public AppStateManager getAppStateManager()
  {
    return this.mAppStateManager;
  }
  
  public MiniAppInfo getMiniAppInfo()
  {
    return this.mMiniAppInfo;
  }
  
  public MiniAppInfo getMiniAppInfoForReport()
  {
    MiniAppInfo localMiniAppInfo2 = this.mMiniAppInfo;
    MiniAppInfo localMiniAppInfo1 = localMiniAppInfo2;
    if (localMiniAppInfo2 == null) {
      localMiniAppInfo1 = MiniProgramReportHelper.miniAppConfigForPreload();
    }
    return localMiniAppInfo1;
  }
  
  public BaseRuntime getRuntime()
  {
    return this.mRuntime;
  }
  
  public BaseTask getTask(Class paramClass)
  {
    return (BaseTask)this.mActivatedTasks.get(paramClass.getCanonicalName());
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleMessage ");
    localStringBuilder.append(paramMessage.what);
    QMLog.d("BaseRuntimeLoader", localStringBuilder.toString());
    return false;
  }
  
  public boolean isLoadSucceed()
  {
    return (this.runtimeLoadCompleted) && (this.isSucceed);
  }
  
  protected void markHasTaskFailed(boolean paramBoolean)
  {
    this.hasTaskFailed = paramBoolean;
  }
  
  public boolean needReloadPage()
  {
    return this.mNeedReloadPage;
  }
  
  public void notifyRuntimeEvent(int paramInt, Object... paramVarArgs)
  {
    AppRuntimeEventCenter.MiniAppStateMessage localMiniAppStateMessage = AppRuntimeEventCenter.MiniAppStateMessage.obtainMessage(paramInt, this);
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
      localMiniAppStateMessage.obj = paramVarArgs[0];
    }
    this.mEventCenter.notifyChange(localMiniAppStateMessage);
  }
  
  public void onAttachActivity(Activity paramActivity, Bundle paramBundle, ViewGroup paramViewGroup)
  {
    paramBundle = new StringBuilder();
    paramBundle.append(" [MiniLifecycle] onAttachActivity isLoadSucceed=");
    paramBundle.append(isLoadSucceed());
    QMLog.e("BaseRuntimeLoader", paramBundle.toString());
    this.mRuntime.onRuntimeAttachActivity(paramActivity, paramViewGroup);
  }
  
  public void onDetachActivity(Activity paramActivity)
  {
    MiniAppInfo localMiniAppInfo = this.mMiniAppInfo;
    if ((localMiniAppInfo != null) && (localMiniAppInfo.isInternalApp()))
    {
      onDetachActivity(paramActivity, false);
      return;
    }
    onDetachActivity(paramActivity, true);
  }
  
  public void onDetachActivity(Activity paramActivity, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" [MiniLifecycle] onDetachActivity needDestroy=");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" isLoadSucceed=");
    localStringBuilder.append(isLoadSucceed());
    QMLog.e("BaseRuntimeLoader", localStringBuilder.toString());
    this.mRuntime.onRuntimeDetachActivity(paramActivity);
    notifyRuntimeEvent(62, new Object[0]);
    if (paramBoolean)
    {
      AppRuntimeLoaderManager.g().removeRuntimeLoader(this);
      destroy();
    }
  }
  
  @Deprecated
  public void onIntentUpdate(Intent paramIntent) {}
  
  public void onMiniPause()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" [MiniLifecycle] onMiniPause isLoadSucceed=");
    localStringBuilder.append(isLoadSucceed());
    QMLog.e("BaseRuntimeLoader", localStringBuilder.toString());
    this.mRuntime.onRuntimePause();
    notifyRuntimeEvent(24, new Object[0]);
  }
  
  public void onMiniResume()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" [MiniLifecycle] onMiniResume isLoadSucceed=");
    localStringBuilder.append(isLoadSucceed());
    QMLog.e("BaseRuntimeLoader", localStringBuilder.toString());
    this.mRuntime.onRuntimeResume();
    notifyRuntimeEvent(21, new Object[0]);
  }
  
  public void onMiniStart()
  {
    QMLog.e("BaseRuntimeLoader", " [MiniLifecycle] onMiniStart");
    this.mRuntime.onRuntimeStart();
  }
  
  public void onMiniStop()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" [MiniLifecycle] onMiniStop isLoadSucceed=");
    localStringBuilder.append(isLoadSucceed());
    QMLog.e("BaseRuntimeLoader", localStringBuilder.toString());
    this.mRuntime.onRuntimeStop();
    notifyRuntimeEvent(22, new Object[0]);
  }
  
  protected void onRuntimeLoadResult(int paramInt, String paramString)
  {
    boolean bool = true;
    this.runtimeLoadCompleted = true;
    if (paramInt != 0) {
      bool = false;
    }
    this.isSucceed = bool;
    BaseRuntimeLoader.OnAppRuntimeLoadListener localOnAppRuntimeLoadListener = this.mRuntimeLoadListener;
    if (localOnAppRuntimeLoadListener != null) {
      localOnAppRuntimeLoadListener.onResult(paramInt, paramString, this);
    }
  }
  
  public void onRuntimeMessage(int paramInt, Object paramObject)
  {
    notifyRuntimeEvent(paramInt, new Object[] { paramObject });
  }
  
  public void onTaskDone(BaseTask paramBaseTask)
  {
    if (paramBaseTask == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(toSimpleString());
    localStringBuilder.append(" onTaskDone ");
    localStringBuilder.append(paramBaseTask);
    localStringBuilder.append(" isSucc=");
    localStringBuilder.append(paramBaseTask.isSucceed());
    QMLog.d("BaseRuntimeLoader", localStringBuilder.toString());
    if (!paramBaseTask.isSucceed()) {
      markHasTaskFailed(true);
    }
    super.onTaskDone(paramBaseTask);
  }
  
  public void pause()
  {
    this.mIsRunning = false;
    super.pause();
  }
  
  public void removeRuntimeStateObserver(AppRuntimeEventCenter.RuntimeStateObserver paramRuntimeStateObserver)
  {
    this.mEventCenter.deleteObserver(paramRuntimeStateObserver);
  }
  
  public void resetAndStart(MiniAppInfo paramMiniAppInfo) {}
  
  public void setMiniAppInfo(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {
      return;
    }
    if (paramMiniAppInfo.apkgInfo == null)
    {
      MiniAppInfo localMiniAppInfo = this.mMiniAppInfo;
      if (localMiniAppInfo != null) {
        paramMiniAppInfo.apkgInfo = localMiniAppInfo.apkgInfo;
      }
    }
    this.mMiniAppInfo = paramMiniAppInfo;
    restartFailTaskIfNeed();
  }
  
  public void setRuntime(BaseRuntime paramBaseRuntime)
  {
    this.mRuntime = paramBaseRuntime;
  }
  
  public void setRuntimeLoadListener(BaseRuntimeLoader.OnAppRuntimeLoadListener paramOnAppRuntimeLoadListener)
  {
    this.mRuntimeLoadListener = paramOnAppRuntimeLoadListener;
  }
  
  public void start()
  {
    if (this.mIsRunning) {
      return;
    }
    this.mIsRunning = true;
    this.runtimeLoadCompleted = false;
    this.isSucceed = false;
    this.mNeedReloadPage = false;
    super.start();
    notifyRuntimeEvent(2, new Object[0]);
  }
  
  public void startLoadMiniAppContent(boolean paramBoolean)
  {
    this.mRuntime.onLoadMiniAppInfo(this.mMiniAppInfo, paramBoolean, null);
  }
  
  public void startUpdateMiniAppInfo()
  {
    BaseRuntime localBaseRuntime = this.mRuntime;
    if (localBaseRuntime == null) {
      return;
    }
    localBaseRuntime.onUpdateMiniAppInfo(this.mMiniAppInfo);
  }
  
  public String toSimpleString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RuntimeLoader(");
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append(")@");
    localStringBuilder.append(hashCode());
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{Runtime:");
    Object localObject = this.mRuntime;
    String str = "N/A";
    if (localObject != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.mRuntime.getClass().getSimpleName());
      ((StringBuilder)localObject).append("@");
      ((StringBuilder)localObject).append(this.mRuntime.hashCode());
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = "N/A";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" AppInfo=");
    MiniAppInfo localMiniAppInfo = this.mMiniAppInfo;
    localObject = str;
    if (localMiniAppInfo != null) {
      localObject = localMiniAppInfo.toSimpleString();
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public void updateMiniAppInfo(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {
      return;
    }
    paramMiniAppInfo.apkgInfo = this.mMiniAppInfo.apkgInfo;
    this.mMiniAppInfo = paramMiniAppInfo;
    startUpdateMiniAppInfo();
  }
  
  public void updateMiniAppInfoFromReload(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {
      return;
    }
    this.mNeedReloadPage = false;
    paramMiniAppInfo.apkgInfo = this.mMiniAppInfo.apkgInfo;
    this.mMiniAppInfo = paramMiniAppInfo;
    startLoadMiniAppContent(true);
  }
  
  protected void updateMiniGameInfo(MiniAppInfo paramMiniAppInfo)
  {
    this.mMiniAppInfo = paramMiniAppInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader
 * JD-Core Version:    0.7.0.1
 */