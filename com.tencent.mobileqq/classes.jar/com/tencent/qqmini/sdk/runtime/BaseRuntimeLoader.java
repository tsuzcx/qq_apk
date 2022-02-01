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
    //   99: new 92	android/os/HandlerThread
    //   102: dup
    //   103: ldc 94
    //   105: iconst_5
    //   106: invokespecial 97	android/os/HandlerThread:<init>	(Ljava/lang/String;I)V
    //   109: astore_2
    //   110: aload_2
    //   111: astore_1
    //   112: aload_2
    //   113: invokevirtual 100	android/os/HandlerThread:start	()V
    //   116: aload_2
    //   117: ifnull +31 -> 148
    //   120: aload_2
    //   121: invokevirtual 104	android/os/HandlerThread:isAlive	()Z
    //   124: ifeq +24 -> 148
    //   127: aload_0
    //   128: new 106	android/os/Handler
    //   131: dup
    //   132: aload_2
    //   133: invokevirtual 110	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   136: aload_0
    //   137: invokespecial 113	android/os/Handler:<init>	(Landroid/os/Looper;Landroid/os/Handler$Callback;)V
    //   140: putfield 115	com/tencent/qqmini/sdk/runtime/BaseRuntimeLoader:mHandler	Landroid/os/Handler;
    //   143: aload_0
    //   144: invokespecial 118	com/tencent/qqmini/sdk/runtime/BaseRuntimeLoader:initTask	()V
    //   147: return
    //   148: aload_0
    //   149: new 106	android/os/Handler
    //   152: dup
    //   153: invokestatic 123	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   156: aload_0
    //   157: invokespecial 113	android/os/Handler:<init>	(Landroid/os/Looper;Landroid/os/Handler$Callback;)V
    //   160: putfield 115	com/tencent/qqmini/sdk/runtime/BaseRuntimeLoader:mHandler	Landroid/os/Handler;
    //   163: goto -20 -> 143
    //   166: astore_3
    //   167: aconst_null
    //   168: astore_2
    //   169: aload_2
    //   170: astore_1
    //   171: ldc 15
    //   173: ldc 125
    //   175: aload_3
    //   176: invokestatic 131	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   179: aload_2
    //   180: ifnull +29 -> 209
    //   183: aload_2
    //   184: invokevirtual 104	android/os/HandlerThread:isAlive	()Z
    //   187: ifeq +22 -> 209
    //   190: aload_0
    //   191: new 106	android/os/Handler
    //   194: dup
    //   195: aload_2
    //   196: invokevirtual 110	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   199: aload_0
    //   200: invokespecial 113	android/os/Handler:<init>	(Landroid/os/Looper;Landroid/os/Handler$Callback;)V
    //   203: putfield 115	com/tencent/qqmini/sdk/runtime/BaseRuntimeLoader:mHandler	Landroid/os/Handler;
    //   206: goto -63 -> 143
    //   209: aload_0
    //   210: new 106	android/os/Handler
    //   213: dup
    //   214: invokestatic 123	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   217: aload_0
    //   218: invokespecial 113	android/os/Handler:<init>	(Landroid/os/Looper;Landroid/os/Handler$Callback;)V
    //   221: putfield 115	com/tencent/qqmini/sdk/runtime/BaseRuntimeLoader:mHandler	Landroid/os/Handler;
    //   224: goto -81 -> 143
    //   227: astore_2
    //   228: aconst_null
    //   229: astore_1
    //   230: aload_1
    //   231: ifnull +28 -> 259
    //   234: aload_1
    //   235: invokevirtual 104	android/os/HandlerThread:isAlive	()Z
    //   238: ifeq +21 -> 259
    //   241: aload_0
    //   242: new 106	android/os/Handler
    //   245: dup
    //   246: aload_1
    //   247: invokevirtual 110	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   250: aload_0
    //   251: invokespecial 113	android/os/Handler:<init>	(Landroid/os/Looper;Landroid/os/Handler$Callback;)V
    //   254: putfield 115	com/tencent/qqmini/sdk/runtime/BaseRuntimeLoader:mHandler	Landroid/os/Handler;
    //   257: aload_2
    //   258: athrow
    //   259: aload_0
    //   260: new 106	android/os/Handler
    //   263: dup
    //   264: invokestatic 123	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   267: aload_0
    //   268: invokespecial 113	android/os/Handler:<init>	(Landroid/os/Looper;Landroid/os/Handler$Callback;)V
    //   271: putfield 115	com/tencent/qqmini/sdk/runtime/BaseRuntimeLoader:mHandler	Landroid/os/Handler;
    //   274: goto -17 -> 257
    //   277: astore_2
    //   278: goto -48 -> 230
    //   281: astore_3
    //   282: goto -113 -> 169
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	285	0	this	BaseRuntimeLoader
    //   0	285	1	paramContext	Context
    //   109	87	2	localHandlerThread	android.os.HandlerThread
    //   227	31	2	localObject1	Object
    //   277	1	2	localObject2	Object
    //   166	10	3	localException1	java.lang.Exception
    //   281	1	3	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   99	110	166	java/lang/Exception
    //   99	110	227	finally
    //   112	116	277	finally
    //   171	179	277	finally
    //   112	116	281	java/lang/Exception
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
    if (paramBaseTask == null) {}
    for (;;)
    {
      return;
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
  }
  
  /* Error */
  private void restartFailTaskIfNeed()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 67	com/tencent/qqmini/sdk/runtime/BaseRuntimeLoader:hasTaskFailed	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: iconst_0
    //   16: putfield 67	com/tencent/qqmini/sdk/runtime/BaseRuntimeLoader:hasTaskFailed	Z
    //   19: aload_0
    //   20: getfield 177	com/tencent/qqmini/sdk/runtime/BaseRuntimeLoader:mAllTasks	Ljava/util/List;
    //   23: invokeinterface 163 1 0
    //   28: astore_2
    //   29: aload_2
    //   30: invokeinterface 168 1 0
    //   35: ifeq -24 -> 11
    //   38: aload_2
    //   39: invokeinterface 172 1 0
    //   44: checkcast 149	com/tencent/qqmini/sdk/task/BaseTask
    //   47: astore_3
    //   48: aload_3
    //   49: invokevirtual 179	com/tencent/qqmini/sdk/task/BaseTask:isSucceed	()Z
    //   52: ifne -23 -> 29
    //   55: aload_3
    //   56: invokevirtual 182	com/tencent/qqmini/sdk/task/BaseTask:reset	()V
    //   59: aload_0
    //   60: aload_3
    //   61: invokevirtual 185	com/tencent/qqmini/sdk/runtime/BaseRuntimeLoader:executeTask	(Lcom/tencent/qqmini/sdk/task/BaseTask;)V
    //   64: goto -35 -> 29
    //   67: astore_2
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_2
    //   71: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	this	BaseRuntimeLoader
    //   6	2	1	bool	boolean
    //   28	11	2	localIterator	Iterator
    //   67	4	2	localObject	Object
    //   47	14	3	localBaseTask	BaseTask
    // Exception table:
    //   from	to	target	type
    //   2	7	67	finally
    //   14	29	67	finally
    //   29	64	67	finally
  }
  
  public void addRuntimeStateObserver(AppRuntimeEventCenter.RuntimeStateObserver paramRuntimeStateObserver)
  {
    this.mEventCenter.addObserver(paramRuntimeStateObserver);
  }
  
  public void addTask(BaseTask paramBaseTask)
  {
    if (paramBaseTask == null) {}
    String str;
    do
    {
      return;
      str = paramBaseTask.getClass().getCanonicalName();
    } while (this.mActivatedTasks.containsKey(str));
    this.mActivatedTasks.put(str, paramBaseTask);
  }
  
  protected abstract BaseRuntime createRuntime(Context paramContext);
  
  public abstract BaseTask[] createTasks();
  
  public void destroy()
  {
    pause();
    this.mRuntimeLoadListener = null;
    this.mEventCenter.deleteObservers();
    if (this.mRuntime != null) {
      this.mRuntime.onRuntimeDestroy();
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
    if (this.mMiniAppInfo == null) {
      return MiniProgramReportHelper.miniAppConfigForPreload();
    }
    return this.mMiniAppInfo;
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
    QMLog.d("BaseRuntimeLoader", "handleMessage " + paramMessage.what);
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
    QMLog.e("BaseRuntimeLoader", " [MiniLifecycle] onAttachActivity isLoadSucceed=" + isLoadSucceed());
    this.mRuntime.onRuntimeAttachActivity(paramActivity, paramViewGroup);
  }
  
  public void onDetachActivity(Activity paramActivity)
  {
    if ((this.mMiniAppInfo != null) && (this.mMiniAppInfo.isInternalApp()))
    {
      onDetachActivity(paramActivity, false);
      return;
    }
    onDetachActivity(paramActivity, true);
  }
  
  public void onDetachActivity(Activity paramActivity, boolean paramBoolean)
  {
    QMLog.e("BaseRuntimeLoader", " [MiniLifecycle] onDetachActivity needDestroy=" + paramBoolean + " isLoadSucceed=" + isLoadSucceed());
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
    QMLog.e("BaseRuntimeLoader", " [MiniLifecycle] onMiniPause isLoadSucceed=" + isLoadSucceed());
    this.mRuntime.onRuntimePause();
    notifyRuntimeEvent(24, new Object[0]);
  }
  
  public void onMiniResume()
  {
    QMLog.e("BaseRuntimeLoader", " [MiniLifecycle] onMiniResume isLoadSucceed=" + isLoadSucceed());
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
    QMLog.e("BaseRuntimeLoader", " [MiniLifecycle] onMiniStop isLoadSucceed=" + isLoadSucceed());
    this.mRuntime.onRuntimeStop();
    notifyRuntimeEvent(22, new Object[0]);
  }
  
  protected void onRuntimeLoadResult(int paramInt, String paramString)
  {
    boolean bool = true;
    this.runtimeLoadCompleted = true;
    if (paramInt == 0) {}
    for (;;)
    {
      this.isSucceed = bool;
      if (this.mRuntimeLoadListener != null) {
        this.mRuntimeLoadListener.onResult(paramInt, paramString, this);
      }
      return;
      bool = false;
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
    QMLog.d("BaseRuntimeLoader", toSimpleString() + " onTaskDone " + paramBaseTask + " isSucc=" + paramBaseTask.isSucceed());
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
    if ((paramMiniAppInfo.apkgInfo == null) && (this.mMiniAppInfo != null)) {
      paramMiniAppInfo.apkgInfo = this.mMiniAppInfo.apkgInfo;
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
    if (this.mRuntime == null) {
      return;
    }
    this.mRuntime.onUpdateMiniAppInfo(this.mMiniAppInfo);
  }
  
  public String toSimpleString()
  {
    return "RuntimeLoader(" + getClass().getSimpleName() + ")@" + hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("{Runtime:");
    if (this.mRuntime != null)
    {
      str = this.mRuntime.getClass().getSimpleName() + "@" + this.mRuntime.hashCode();
      localStringBuilder = localStringBuilder.append(str).append(" AppInfo=");
      if (this.mMiniAppInfo == null) {
        break label110;
      }
    }
    label110:
    for (String str = this.mMiniAppInfo.toSimpleString();; str = "N/A")
    {
      return str + "}";
      str = "N/A";
      break;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader
 * JD-Core Version:    0.7.0.1
 */