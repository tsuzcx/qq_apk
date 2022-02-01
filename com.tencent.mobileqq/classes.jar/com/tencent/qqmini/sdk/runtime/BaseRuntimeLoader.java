package com.tencent.qqmini.sdk.runtime;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
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
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@MiniKeep
public abstract class BaseRuntimeLoader
  extends TaskFlowEngine
  implements Handler.Callback, IMiniLifecycle, BaseRuntime.RuntimeMsgObserver
{
  public static final String TAG = "BaseRuntimeLoader";
  private boolean hasTaskFailed;
  private boolean isSucceed;
  private Map<String, BaseTask> mActivatedTasks;
  private final AppStateManager mAppStateManager;
  protected Context mContext;
  private final AppRuntimeEventCenter mEventCenter;
  protected Handler mHandler;
  protected boolean mIsRunning;
  protected MiniAppInfo mMiniAppInfo;
  protected boolean mNeedReloadPage;
  protected BaseRuntime mRuntime;
  protected BaseRuntimeLoader.OnAppRuntimeLoadListener mRuntimeLoadListener;
  protected boolean runtimeLoadCompleted;
  
  /* Error */
  public BaseRuntimeLoader(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 45	com/tencent/qqmini/sdk/task/TaskFlowEngine:<init>	()V
    //   4: aload_0
    //   5: new 47	com/tencent/qqmini/sdk/runtime/AppRuntimeEventCenter
    //   8: dup
    //   9: invokespecial 48	com/tencent/qqmini/sdk/runtime/AppRuntimeEventCenter:<init>	()V
    //   12: putfield 50	com/tencent/qqmini/sdk/runtime/BaseRuntimeLoader:mEventCenter	Lcom/tencent/qqmini/sdk/runtime/AppRuntimeEventCenter;
    //   15: aload_0
    //   16: new 52	com/tencent/qqmini/sdk/runtime/AppStateManager
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 55	com/tencent/qqmini/sdk/runtime/AppStateManager:<init>	(Lcom/tencent/qqmini/sdk/runtime/BaseRuntimeLoader;)V
    //   24: putfield 57	com/tencent/qqmini/sdk/runtime/BaseRuntimeLoader:mAppStateManager	Lcom/tencent/qqmini/sdk/runtime/AppStateManager;
    //   27: aload_0
    //   28: iconst_0
    //   29: putfield 59	com/tencent/qqmini/sdk/runtime/BaseRuntimeLoader:mIsRunning	Z
    //   32: aload_0
    //   33: iconst_0
    //   34: putfield 61	com/tencent/qqmini/sdk/runtime/BaseRuntimeLoader:mNeedReloadPage	Z
    //   37: aload_0
    //   38: iconst_0
    //   39: putfield 63	com/tencent/qqmini/sdk/runtime/BaseRuntimeLoader:runtimeLoadCompleted	Z
    //   42: aload_0
    //   43: iconst_0
    //   44: putfield 65	com/tencent/qqmini/sdk/runtime/BaseRuntimeLoader:isSucceed	Z
    //   47: aload_0
    //   48: iconst_0
    //   49: putfield 67	com/tencent/qqmini/sdk/runtime/BaseRuntimeLoader:hasTaskFailed	Z
    //   52: aload_0
    //   53: aload_1
    //   54: putfield 69	com/tencent/qqmini/sdk/runtime/BaseRuntimeLoader:mContext	Landroid/content/Context;
    //   57: aload_0
    //   58: new 71	java/util/HashMap
    //   61: dup
    //   62: invokespecial 72	java/util/HashMap:<init>	()V
    //   65: putfield 74	com/tencent/qqmini/sdk/runtime/BaseRuntimeLoader:mActivatedTasks	Ljava/util/Map;
    //   68: aload_0
    //   69: getfield 50	com/tencent/qqmini/sdk/runtime/BaseRuntimeLoader:mEventCenter	Lcom/tencent/qqmini/sdk/runtime/AppRuntimeEventCenter;
    //   72: aload_0
    //   73: getfield 57	com/tencent/qqmini/sdk/runtime/BaseRuntimeLoader:mAppStateManager	Lcom/tencent/qqmini/sdk/runtime/AppStateManager;
    //   76: invokevirtual 78	com/tencent/qqmini/sdk/runtime/AppRuntimeEventCenter:addObserver	(Ljava/util/Observer;)V
    //   79: aload_0
    //   80: aload_0
    //   81: aload_0
    //   82: getfield 69	com/tencent/qqmini/sdk/runtime/BaseRuntimeLoader:mContext	Landroid/content/Context;
    //   85: invokevirtual 82	com/tencent/qqmini/sdk/runtime/BaseRuntimeLoader:createRuntime	(Landroid/content/Context;)Lcom/tencent/qqmini/sdk/launcher/core/BaseRuntime;
    //   88: putfield 84	com/tencent/qqmini/sdk/runtime/BaseRuntimeLoader:mRuntime	Lcom/tencent/qqmini/sdk/launcher/core/BaseRuntime;
    //   91: aload_0
    //   92: getfield 84	com/tencent/qqmini/sdk/runtime/BaseRuntimeLoader:mRuntime	Lcom/tencent/qqmini/sdk/launcher/core/BaseRuntime;
    //   95: aload_0
    //   96: invokevirtual 90	com/tencent/qqmini/sdk/launcher/core/BaseRuntime:setRuntimeMsgObserver	(Lcom/tencent/qqmini/sdk/launcher/core/BaseRuntime$RuntimeMsgObserver;)V
    //   99: aconst_null
    //   100: astore_3
    //   101: aconst_null
    //   102: astore_1
    //   103: new 92	android/os/HandlerThread
    //   106: dup
    //   107: ldc 94
    //   109: iconst_5
    //   110: invokespecial 97	android/os/HandlerThread:<init>	(Ljava/lang/String;I)V
    //   113: astore_2
    //   114: aload_2
    //   115: invokevirtual 100	android/os/HandlerThread:start	()V
    //   118: aload_2
    //   119: invokevirtual 104	android/os/HandlerThread:isAlive	()Z
    //   122: ifeq +22 -> 144
    //   125: aload_0
    //   126: new 106	android/os/Handler
    //   129: dup
    //   130: aload_2
    //   131: invokevirtual 110	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   134: aload_0
    //   135: invokespecial 113	android/os/Handler:<init>	(Landroid/os/Looper;Landroid/os/Handler$Callback;)V
    //   138: putfield 115	com/tencent/qqmini/sdk/runtime/BaseRuntimeLoader:mHandler	Landroid/os/Handler;
    //   141: goto +101 -> 242
    //   144: new 106	android/os/Handler
    //   147: dup
    //   148: invokestatic 120	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   151: aload_0
    //   152: invokespecial 113	android/os/Handler:<init>	(Landroid/os/Looper;Landroid/os/Handler$Callback;)V
    //   155: astore_1
    //   156: aload_0
    //   157: aload_1
    //   158: putfield 115	com/tencent/qqmini/sdk/runtime/BaseRuntimeLoader:mHandler	Landroid/os/Handler;
    //   161: goto +81 -> 242
    //   164: astore_1
    //   165: aload_2
    //   166: astore_3
    //   167: aload_1
    //   168: astore_2
    //   169: aload_3
    //   170: astore_1
    //   171: goto +76 -> 247
    //   174: astore_3
    //   175: goto +12 -> 187
    //   178: astore_2
    //   179: goto +68 -> 247
    //   182: astore_1
    //   183: aload_3
    //   184: astore_2
    //   185: aload_1
    //   186: astore_3
    //   187: aload_2
    //   188: astore_1
    //   189: ldc 15
    //   191: ldc 122
    //   193: aload_3
    //   194: invokestatic 128	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   197: aload_2
    //   198: ifnull +29 -> 227
    //   201: aload_2
    //   202: invokevirtual 104	android/os/HandlerThread:isAlive	()Z
    //   205: ifeq +22 -> 227
    //   208: aload_0
    //   209: new 106	android/os/Handler
    //   212: dup
    //   213: aload_2
    //   214: invokevirtual 110	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   217: aload_0
    //   218: invokespecial 113	android/os/Handler:<init>	(Landroid/os/Looper;Landroid/os/Handler$Callback;)V
    //   221: putfield 115	com/tencent/qqmini/sdk/runtime/BaseRuntimeLoader:mHandler	Landroid/os/Handler;
    //   224: goto +18 -> 242
    //   227: new 106	android/os/Handler
    //   230: dup
    //   231: invokestatic 120	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   234: aload_0
    //   235: invokespecial 113	android/os/Handler:<init>	(Landroid/os/Looper;Landroid/os/Handler$Callback;)V
    //   238: astore_1
    //   239: goto -83 -> 156
    //   242: aload_0
    //   243: invokespecial 131	com/tencent/qqmini/sdk/runtime/BaseRuntimeLoader:initTask	()V
    //   246: return
    //   247: aload_1
    //   248: ifnull +29 -> 277
    //   251: aload_1
    //   252: invokevirtual 104	android/os/HandlerThread:isAlive	()Z
    //   255: ifeq +22 -> 277
    //   258: aload_0
    //   259: new 106	android/os/Handler
    //   262: dup
    //   263: aload_1
    //   264: invokevirtual 110	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   267: aload_0
    //   268: invokespecial 113	android/os/Handler:<init>	(Landroid/os/Looper;Landroid/os/Handler$Callback;)V
    //   271: putfield 115	com/tencent/qqmini/sdk/runtime/BaseRuntimeLoader:mHandler	Landroid/os/Handler;
    //   274: goto +18 -> 292
    //   277: aload_0
    //   278: new 106	android/os/Handler
    //   281: dup
    //   282: invokestatic 120	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   285: aload_0
    //   286: invokespecial 113	android/os/Handler:<init>	(Landroid/os/Looper;Landroid/os/Handler$Callback;)V
    //   289: putfield 115	com/tencent/qqmini/sdk/runtime/BaseRuntimeLoader:mHandler	Landroid/os/Handler;
    //   292: goto +5 -> 297
    //   295: aload_2
    //   296: athrow
    //   297: goto -2 -> 295
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	300	0	this	BaseRuntimeLoader
    //   0	300	1	paramContext	Context
    //   113	56	2	localObject1	Object
    //   178	1	2	localObject2	Object
    //   184	112	2	localException1	java.lang.Exception
    //   100	70	3	localObject3	Object
    //   174	10	3	localException2	java.lang.Exception
    //   186	8	3	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   114	118	164	finally
    //   114	118	174	java/lang/Exception
    //   103	114	178	finally
    //   189	197	178	finally
    //   103	114	182	java/lang/Exception
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader
 * JD-Core Version:    0.7.0.1
 */