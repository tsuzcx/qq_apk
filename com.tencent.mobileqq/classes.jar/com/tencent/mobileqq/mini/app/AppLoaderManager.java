package com.tencent.mobileqq.mini.app;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.MiniAppInterface;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntimeContainer;
import com.tencent.mobileqq.mini.appbrand.JsErrorGuard;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.launch.AppBrandProxy;
import com.tencent.mobileqq.mini.report.MiniAppReportManager2;
import com.tencent.mobileqq.mini.report.MiniGdtReporter;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.report.MiniProgramReportHelper;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.mini.sdk.BaseLibInfo;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.tfs.BaseTask;
import com.tencent.mobileqq.mini.tfs.TaskFlowEngine;
import com.tencent.mobileqq.mini.tfs.mini.ApkgLoadAsyncTask;
import com.tencent.mobileqq.mini.tfs.mini.BaselibLoadAsyncTask;
import com.tencent.mobileqq.mini.tfs.mini.InitAppRuntimeTask;
import com.tencent.mobileqq.mini.tfs.mini.JsPluginEngineTask;
import com.tencent.mobileqq.mini.tfs.mini.MiniTask.RuntimeContainerInitTask;
import com.tencent.mobileqq.mini.tfs.mini.MiniTask.RuntimeCreateTask;
import com.tencent.mobileqq.mini.tfs.mini.PageCreateAsyncTask;
import com.tencent.mobileqq.mini.tfs.mini.PageInitAsyncTask;
import com.tencent.mobileqq.mini.tfs.mini.PagePreloadTask;
import com.tencent.mobileqq.mini.tfs.mini.ServiceCreateAsyncTask;
import com.tencent.mobileqq.mini.tfs.mini.ServiceInitAppTask;
import com.tencent.mobileqq.mini.tfs.mini.ServiceInitAsyncTask;
import com.tencent.mobileqq.mini.tfs.mini.TbsAsyncTask;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class AppLoaderManager
  extends TaskFlowEngine
  implements Handler.Callback, BaseAppLoaderManager
{
  public static final String TAG = "miniapp-start";
  public static final String TAG_CHROMIUM = "miniapp-chromium";
  public static final String TAG_JS = "miniapp-JS";
  public static final String TAG_PROCESSOR = "miniapp-process";
  public static MiniAppInterface sMiniAppInterface;
  private final int APP_LOAD_TIME_OUT = 30000;
  private final int SERVICE_INIT_TIME_OUT = 20000;
  private final int X5_LOAD_TIME_OUT = 30000;
  ApkgLoadAsyncTask apkgLoadTask;
  BaselibLoadAsyncTask baselibLoadTask;
  PagePreloadTask firstPageTask;
  InitAppRuntimeTask initAppRuntimeTask;
  JsPluginEngineTask jsPluginEngineTask;
  private ApkgInfo mApkgInfo;
  private Context mContext;
  private Handler mHandler;
  private boolean mIsTbsCompleted;
  private boolean mIsWebviewInited;
  private List<Handler> mListeners = new Vector();
  private String mLoadingAppId;
  private MiniAppConfig mMiniConfig;
  MiniTask.RuntimeContainerInitTask mRuntimeContainerInitTask;
  MiniTask.RuntimeCreateTask mRuntimeCreateTask;
  ServiceInitAppTask mServiceInitAppTask;
  private boolean mStarted;
  private String mWARemoteDebugStr;
  private String mWAWebviewStr;
  PageCreateAsyncTask pageCreateTask;
  PageInitAsyncTask pageInitTask;
  ServiceCreateAsyncTask serviceCreateTask;
  ServiceInitAsyncTask serviceInitTask;
  TbsAsyncTask tbsTask;
  
  public AppLoaderManager()
  {
    Object localObject3 = null;
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("miniapp-start", 5);
        localObject1 = localHandlerThread;
        localObject3 = localHandlerThread;
        localHandlerThread.start();
        if ((localHandlerThread == null) || (!localHandlerThread.isAlive())) {
          continue;
        }
        this.mHandler = new Handler(localHandlerThread.getLooper(), this);
      }
      catch (Exception localException)
      {
        localObject3 = localObject1;
        QLog.e("miniapp-start", 1, "create thread error!", localException);
        if ((localObject1 == null) || (!localObject1.isAlive())) {
          continue;
        }
        this.mHandler = new Handler(localObject1.getLooper(), this);
        continue;
        this.mHandler = new Handler(Looper.getMainLooper(), this);
        continue;
      }
      finally
      {
        if (localObject3 == null) {
          break label195;
        }
      }
      initTask();
      return;
      this.mHandler = new Handler(Looper.getMainLooper(), this);
    }
    if (localObject3.isAlive()) {}
    label195:
    for (this.mHandler = new Handler(localObject3.getLooper(), this);; this.mHandler = new Handler(Looper.getMainLooper(), this)) {
      throw localObject2;
    }
  }
  
  private MiniAppConfig getMiniConfig()
  {
    if ((this.apkgLoadTask != null) && (this.apkgLoadTask.getApkgInfo() != null)) {
      return this.apkgLoadTask.getApkgInfo().appConfig;
    }
    return this.mMiniConfig;
  }
  
  private String getPagePath()
  {
    MiniAppConfig localMiniAppConfig = getMiniConfig();
    if ((localMiniAppConfig != null) && (localMiniAppConfig.launchParam != null)) {
      return localMiniAppConfig.launchParam.entryPath;
    }
    return "";
  }
  
  private void onAppRouteDone()
  {
    if (this.mHandler.hasMessages(318))
    {
      this.mHandler.removeMessages(318);
      MiniReportManager.reportEventType(getMiniConfig(), 608, getPagePath(), null, null, 0);
    }
  }
  
  public void addListener(Handler paramHandler)
  {
    this.mListeners.add(paramHandler);
  }
  
  public BaseLibInfo getBaseLibInfo()
  {
    if (this.baselibLoadTask != null) {
      return this.baselibLoadTask.getBaseLibInfo();
    }
    return new BaseLibInfo("", "");
  }
  
  public String getBasePageFrameStr()
  {
    if (this.baselibLoadTask != null) {
      return this.baselibLoadTask.getBasePageFrameStr();
    }
    return "";
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public MiniAppInterface getMiniAppInterface()
  {
    return sMiniAppInterface;
  }
  
  public String getMiniAppWebviewStr()
  {
    if (this.baselibLoadTask != null) {
      return this.baselibLoadTask.getMiniappWebviewStr();
    }
    return "";
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    QLog.d("miniapp-start", 1, "handleMessage " + paramMessage.what);
    switch (paramMessage.what)
    {
    }
    do
    {
      return false;
      int i = QbSdk.getTbsVersion(this.mContext);
      QLog.d("miniapp-start", 1, "X5安装超时 tbsVersion=" + i);
      nofityObservers(paramMessage);
      return false;
      QLog.d("miniapp-start", 1, "X5安装失败");
      nofityObservers(paramMessage);
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("miniapp-start", 2, "X5_DOWNLOAD_PROGRESS " + paramMessage.what);
      }
      nofityObservers(paramMessage);
      return false;
      QLog.d("miniapp-start", 1, "BaseLib加载失败");
      nofityObservers(paramMessage);
      return false;
      QLog.d("miniapp-start", 1, "Apkg加载失败");
      nofityObservers(paramMessage);
      return false;
      QLog.d("miniapp-start", 1, "APP_EVENT_APPROUTE_DONE");
      nofityObservers(paramMessage);
      return false;
      QLog.e("miniapp-start", 1, "APP_LOAD_TIMEOUT 小程序加载超时");
      MiniReportManager.reportEventType(getMiniConfig(), 610, getPagePath(), null, null, 0);
      return false;
      QLog.d("miniapp-start", 1, "MSG_WHAT_APP_EVEN_JSCORE_INIT_FINISH");
      return false;
      QLog.e("miniapp-start", 1, "Service Init Timeout!");
    } while (this.serviceInitTask == null);
    if ((this.serviceInitTask.appBrandRuntime != null) && (this.serviceInitTask.appBrandRuntime.activity != null) && (this.serviceInitTask.appBrandRuntime.mJsErrorGuard != null))
    {
      this.serviceInitTask.appBrandRuntime.mJsErrorGuard.startShowX5Guide();
      return false;
    }
    this.serviceInitTask.isTimeout = true;
    return false;
  }
  
  public boolean hasPreload()
  {
    return (this.serviceInitTask != null) && (this.serviceInitTask.isDone()) && (this.pageInitTask != null) && (this.pageInitTask.isDone());
  }
  
  public void initTask()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    this.baselibLoadTask = new BaselibLoadAsyncTask(localBaseApplicationImpl);
    this.tbsTask = new TbsAsyncTask(localBaseApplicationImpl);
    this.serviceCreateTask = new ServiceCreateAsyncTask(localBaseApplicationImpl);
    this.serviceInitTask = new ServiceInitAsyncTask(localBaseApplicationImpl);
    this.pageCreateTask = new PageCreateAsyncTask(localBaseApplicationImpl);
    this.pageInitTask = new PageInitAsyncTask(localBaseApplicationImpl);
    this.initAppRuntimeTask = new InitAppRuntimeTask(localBaseApplicationImpl);
    this.apkgLoadTask = new ApkgLoadAsyncTask(localBaseApplicationImpl);
    this.firstPageTask = new PagePreloadTask(localBaseApplicationImpl);
    this.jsPluginEngineTask = new JsPluginEngineTask(localBaseApplicationImpl);
    this.mRuntimeContainerInitTask = new MiniTask.RuntimeContainerInitTask(localBaseApplicationImpl, AppBrandRuntimeContainer.g());
    this.mRuntimeCreateTask = new MiniTask.RuntimeCreateTask(localBaseApplicationImpl, AppBrandRuntimeContainer.g());
    this.mServiceInitAppTask = new ServiceInitAppTask(localBaseApplicationImpl);
    this.initAppRuntimeTask.addDependTask(this.jsPluginEngineTask.addDependTask(this.mRuntimeCreateTask)).addDependTask(this.firstPageTask).addDependTask(this.apkgLoadTask).addDependTask(this.serviceInitTask.addDependTask(this.baselibLoadTask).addDependTask(this.serviceCreateTask.addDependTask(this.tbsTask).addDependTask(this.mRuntimeCreateTask).addDependTask(this.pageCreateTask))).addDependTask(this.pageInitTask.addDependTask(this.serviceInitTask).addDependTask(this.pageCreateTask.addDependTask(this.mRuntimeCreateTask).addDependTask(this.tbsTask).addDependTask(this.baselibLoadTask)));
    this.mServiceInitAppTask.addDependTask(this.serviceInitTask);
    initTasks(new BaseTask[] { this.initAppRuntimeTask, this.mRuntimeContainerInitTask, this.mServiceInitAppTask });
  }
  
  public boolean isTbsCompleted()
  {
    return (this.tbsTask != null) && (this.tbsTask.isSucceed());
  }
  
  public void loadApkgByConfig(MiniAppConfig paramMiniAppConfig)
  {
    this.tbsTask.needDownloadForeground(true);
    this.mStarted = false;
    ApkgInfo localApkgInfo = this.apkgLoadTask.getApkgInfo();
    if ((localApkgInfo != null) && ((localApkgInfo.appConfig == null) || (!localApkgInfo.appConfig.equals(paramMiniAppConfig)) || (AppBrandRuntimeContainer.g().getAppBrandRunTime(localApkgInfo.appConfig.config) == null)))
    {
      if (AppBrandRuntimeContainer.g().getEmptyAppRuntime() == null)
      {
        resetTaskAndDepends(this.mRuntimeCreateTask);
        resetTaskAndDepends(this.firstPageTask);
      }
      resetTaskAndDepends(this.apkgLoadTask);
      start(this.mContext);
    }
    if ((this.serviceInitTask != null) && (this.serviceInitTask.isTimeout)) {
      this.mHandler.postDelayed(new AppLoaderManager.1(this), 1000L);
    }
    this.apkgLoadTask.loadApkgByConfig(paramMiniAppConfig);
  }
  
  public void nofityObservers(Message paramMessage)
  {
    if (paramMessage == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = new Vector(this.mListeners).iterator();
      while (localIterator.hasNext())
      {
        Handler localHandler = (Handler)localIterator.next();
        try
        {
          Message localMessage = new Message();
          localMessage.copyFrom(paramMessage);
          localHandler.sendMessage(localMessage);
        }
        catch (Exception localException)
        {
          QLog.e("miniapp-start", 1, "", localException);
        }
      }
    }
  }
  
  public void notifyMessage(Message paramMessage)
  {
    if (paramMessage == null) {}
    do
    {
      return;
      this.mHandler.sendMessage(paramMessage);
    } while (317 != paramMessage.what);
    onAppRouteDone();
  }
  
  public void onBaseLibUpdateResult(int paramInt)
  {
    QLog.d("miniapp-start", 1, "onBaseLibUpdateResult ret=" + paramInt);
    if (this.baselibLoadTask == null) {}
    while ((this.baselibLoadTask.isBaseLibInit()) || (this.baselibLoadTask.getStatus() == 2)) {
      return;
    }
    if (paramInt == 0)
    {
      this.baselibLoadTask.run();
      return;
    }
    this.baselibLoadTask.onBaseLibUpdateFaild(paramInt);
  }
  
  public void onBaselibUpdated(Context paramContext, MiniAppConfig paramMiniAppConfig)
  {
    AppBrandTask.runTaskOnUiThread(new AppLoaderManager.2(this, paramContext, paramMiniAppConfig));
  }
  
  public void onFakeApkgInfo(MiniAppConfig paramMiniAppConfig, String paramString1, String paramString2)
  {
    paramMiniAppConfig = new ApkgInfo(null, paramMiniAppConfig);
    paramMiniAppConfig.updateConfigStr(paramString1);
    this.mServiceInitAppTask.startFakeApkgInfo(paramMiniAppConfig, paramString2);
  }
  
  public void onTaskBegin(BaseTask paramBaseTask)
  {
    super.onTaskBegin(paramBaseTask);
    if (((paramBaseTask instanceof ServiceInitAsyncTask)) && (Build.VERSION.SDK_INT < 21))
    {
      paramBaseTask = Message.obtain();
      paramBaseTask.what = 322;
      this.mHandler.sendMessageDelayed(paramBaseTask, 20000L);
    }
  }
  
  public void onTaskDone(BaseTask paramBaseTask)
  {
    if (paramBaseTask == null) {
      return;
    }
    if ((hasPreload()) && ((this.apkgLoadTask == null) || (this.apkgLoadTask.getStatus() == 1))) {
      MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 627, "0");
    }
    Object localObject;
    int i;
    if ((paramBaseTask instanceof TbsAsyncTask)) {
      if (!paramBaseTask.isSucceed())
      {
        localObject = this.mHandler;
        if (!((TbsAsyncTask)paramBaseTask).mIsTimeout) {
          break label87;
        }
        i = 306;
        ((Handler)localObject).sendEmptyMessage(i);
      }
    }
    for (;;)
    {
      super.onTaskDone(paramBaseTask);
      return;
      label87:
      i = 305;
      break;
      if ((paramBaseTask instanceof BaselibLoadAsyncTask))
      {
        if (!paramBaseTask.isSucceed())
        {
          this.mHandler.sendEmptyMessage(310);
          MiniGdtReporter.report(getMiniConfig(), 310);
        }
        else
        {
          this.mWAWebviewStr = ((BaselibLoadAsyncTask)paramBaseTask).getWaWebviewJs();
          this.mWARemoteDebugStr = ((BaselibLoadAsyncTask)paramBaseTask).waRemoteDebugJs();
          this.mHandler.sendEmptyMessage(311);
        }
      }
      else if ((paramBaseTask instanceof ApkgLoadAsyncTask))
      {
        if (!paramBaseTask.isSucceed())
        {
          localObject = Message.obtain();
          ((Message)localObject).what = 315;
          ((Message)localObject).obj = ((ApkgLoadAsyncTask)paramBaseTask).errorMsg;
          this.mHandler.sendMessage((Message)localObject);
          MiniGdtReporter.report(getMiniConfig(), 315);
        }
      }
      else if ((paramBaseTask instanceof ServiceInitAsyncTask))
      {
        this.mHandler.removeMessages(322);
      }
      else if ((paramBaseTask instanceof InitAppRuntimeTask))
      {
        this.mStarted = false;
        if (!paramBaseTask.isSucceed())
        {
          MiniProgramLpReportDC04239.reportPageView(getMiniConfig(), "0", null, "show_fail", "load_pkg_fail");
          MiniAppReportManager2.reportPageView("2launch_fail", "load_pkg_fail", null, getMiniConfig());
        }
      }
    }
  }
  
  public void preloadNextRuntime()
  {
    if ((!this.initAppRuntimeTask.isDone()) || (this.mStarted)) {
      return;
    }
    resetTaskAndDepends(this.baselibLoadTask);
    resetTaskAndDepends(this.mRuntimeCreateTask);
    resetTaskAndDepends(this.initAppRuntimeTask);
    resetTaskAndDepends(this.firstPageTask);
    resetTaskAndDepends(this.apkgLoadTask);
    resetTaskAndDepends(this.mServiceInitAppTask);
    start();
  }
  
  public void removeListner(Handler paramHandler)
  {
    this.mListeners.remove(paramHandler);
  }
  
  public void setMiniAppInterface(MiniAppInterface paramMiniAppInterface)
  {
    sMiniAppInterface = paramMiniAppInterface;
  }
  
  public void start(Context paramContext)
  {
    for (;;)
    {
      try
      {
        AppBrandProxy.g().setPreloadType("preload_app");
        boolean bool = this.mStarted;
        if (bool) {
          return;
        }
        MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 626, "0");
        QLog.i("miniapp-start", 1, "AppLoaderManager start");
        this.mStarted = true;
        if (paramContext != null)
        {
          paramContext = paramContext.getApplicationContext();
          this.mContext = paramContext;
          start();
        }
        else
        {
          paramContext = BaseApplicationImpl.getApplication();
        }
      }
      finally {}
    }
  }
  
  public void startTbs(Context paramContext)
  {
    if ((this.tbsTask != null) && (this.tbsTask.getStatus() != 2)) {
      this.tbsTask.run();
    }
  }
  
  public String waConsoleJsStr()
  {
    if (this.baselibLoadTask != null) {
      return this.baselibLoadTask.getWaConsoleJs();
    }
    return "";
  }
  
  public String waRemoteDebugJsStr()
  {
    String str1 = null;
    if (this.baselibLoadTask != null) {
      str1 = this.baselibLoadTask.waRemoteDebugJs();
    }
    String str2 = str1;
    if (TextUtils.isEmpty(str1)) {
      str2 = this.mWARemoteDebugStr;
    }
    return str2;
  }
  
  public String waServiceJsStr()
  {
    if (this.baselibLoadTask != null) {
      return this.baselibLoadTask.getWaServiceJs();
    }
    return "";
  }
  
  public String waWebviewJsStr()
  {
    String str1 = null;
    if (this.baselibLoadTask != null) {
      str1 = this.baselibLoadTask.getWaWebviewJs();
    }
    String str2 = str1;
    if (TextUtils.isEmpty(str1)) {
      str2 = this.mWAWebviewStr;
    }
    return str2;
  }
  
  public String waWorkerStr()
  {
    if (this.baselibLoadTask != null) {
      return this.baselibLoadTask.getWaWorkerStr();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.AppLoaderManager
 * JD-Core Version:    0.7.0.1
 */