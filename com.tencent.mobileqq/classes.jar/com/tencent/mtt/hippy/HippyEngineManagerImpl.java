package com.tencent.mtt.hippy;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mtt.hippy.a.g;
import com.tencent.mtt.hippy.a.n;
import com.tencent.mtt.hippy.adapter.exception.HippyExceptionHandlerAdapter;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorAdapter;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorEvent;
import com.tencent.mtt.hippy.adapter.sharedpreferences.HippySharedPreferencesAdapter;
import com.tencent.mtt.hippy.adapter.thirdparty.HippyThirdPartyAdapter;
import com.tencent.mtt.hippy.bridge.bundleloader.HippyAssetBundleLoader;
import com.tencent.mtt.hippy.bridge.bundleloader.HippyBundleLoader;
import com.tencent.mtt.hippy.bridge.bundleloader.HippyFileBundleLoader;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.common.ThreadExecutor;
import com.tencent.mtt.hippy.common.ThreadExecutor.UncaughtExceptionHandler;
import com.tencent.mtt.hippy.dom.DomManager;
import com.tencent.mtt.hippy.modules.HippyModuleManager;
import com.tencent.mtt.hippy.modules.javascriptmodules.EventDispatcher;
import com.tencent.mtt.hippy.modules.nativemodules.deviceevent.DeviceEventModule;
import com.tencent.mtt.hippy.modules.nativemodules.deviceevent.DeviceEventModule.InvokeDefaultBackPress;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.mtt.hippy.utils.TimeMonitor;
import com.tencent.mtt.hippy.utils.UIThreadUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class HippyEngineManagerImpl
  extends HippyEngineManager
  implements HippyRootView.OnResumeAndPauseListener, HippyRootView.OnSizeChangedListener, g, ThreadExecutor.UncaughtExceptionHandler
{
  static final int MSG_ENGINE_INIT_TIMEOUT = 100;
  static final String TAG = "HippyEngineManagerImpl";
  List<HippyAPIProvider> mAPIProviders;
  HippyBundleLoader mCoreBundleLoader;
  boolean mDebugMode;
  boolean mDevManagerInited = false;
  n mDevSupportManager;
  boolean mEnableHippyBuffer = false;
  HippyEngineManagerImpl.HippyEngineContextImpl mEngineContext;
  HippyGlobalConfigs mGlobalConfigs;
  private int mGroupId;
  Handler mHandler = new HippyEngineManagerImpl.1(this, Looper.getMainLooper());
  boolean mHasReportEngineLoadResult = false;
  final CopyOnWriteArrayList<HippyRootView> mInstances = new CopyOnWriteArrayList();
  HippyBundleLoader mPreloadBundleLoader;
  String mServerBundleName;
  private String mServerHost;
  TimeMonitor mStartTimeMonitor;
  private HippyThirdPartyAdapter mThirdPartyAdapter;
  
  HippyEngineManagerImpl(HippyEngine.EngineInitParams paramEngineInitParams, HippyBundleLoader paramHippyBundleLoader)
  {
    Object localObject1 = null;
    Object localObject2;
    if (!TextUtils.isEmpty(paramEngineInitParams.coreJSAssetsPath))
    {
      localObject1 = paramEngineInitParams.context;
      localObject2 = paramEngineInitParams.coreJSAssetsPath;
      if (!TextUtils.isEmpty(paramEngineInitParams.codeCacheTag))
      {
        bool1 = true;
        localObject1 = new HippyAssetBundleLoader((Context)localObject1, (String)localObject2, bool1, paramEngineInitParams.codeCacheTag);
        label103:
        localObject2 = new HippyGlobalConfigs(paramEngineInitParams);
        this.mGlobalConfigs = ((HippyGlobalConfigs)localObject2);
        this.mCoreBundleLoader = ((HippyBundleLoader)localObject1);
        this.mPreloadBundleLoader = paramHippyBundleLoader;
        this.mAPIProviders = paramEngineInitParams.providers;
        this.mDebugMode = paramEngineInitParams.debugMode;
        if (!paramEngineInitParams.debugMode) {
          break label298;
        }
        paramHippyBundleLoader = paramEngineInitParams.debugBundleName;
        label158:
        this.mServerBundleName = paramHippyBundleLoader;
        if (paramEngineInitParams.debugMode) {
          break label304;
        }
      }
    }
    label298:
    label304:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.mStartTimeMonitor = new TimeMonitor(bool1);
      this.mEnableHippyBuffer = paramEngineInitParams.enableBuffer;
      this.mServerHost = paramEngineInitParams.debugServerHost;
      this.mGroupId = paramEngineInitParams.groupId;
      this.mThirdPartyAdapter = paramEngineInitParams.thirdPartyAdapter;
      com.tencent.mtt.hippy.bridge.a.a.a(((HippyGlobalConfigs)localObject2).getContext(), ((HippyGlobalConfigs)localObject2).getSharedPreferencesAdapter().getSharedPreferences(), ((HippyGlobalConfigs)localObject2).getSoLoaderAdapter());
      return;
      bool1 = false;
      break;
      if (TextUtils.isEmpty(paramEngineInitParams.coreJSFilePath)) {
        break label103;
      }
      localObject1 = paramEngineInitParams.coreJSFilePath;
      if (!TextUtils.isEmpty(paramEngineInitParams.codeCacheTag)) {}
      for (bool1 = true;; bool1 = false)
      {
        localObject1 = new HippyFileBundleLoader((String)localObject1, bool1, paramEngineInitParams.codeCacheTag);
        break;
      }
      paramHippyBundleLoader = "";
      break label158;
    }
  }
  
  private void internalLoadInstance(HippyRootView paramHippyRootView)
  {
    if ((this.mEngineContext == null) || (paramHippyRootView == null)) {
      notifyModuleLoaded(-500, "load module error. mEngineContext=" + this.mEngineContext + ", HippyRootView instance=" + paramHippyRootView, paramHippyRootView);
    }
    do
    {
      return;
      LogUtils.d("HippyEngineManagerImpl", "in internalLoadInstance");
      if (this.mEngineContext.mInstanceLifecycleEventListeners != null)
      {
        localObject = this.mEngineContext.mInstanceLifecycleEventListeners.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((HippyInstanceLifecycleEventListener)((Iterator)localObject).next()).onInstanceLoad(paramHippyRootView.getId());
        }
      }
      paramHippyRootView.attachToEngine(this.mEngineContext);
      Object localObject = paramHippyRootView.getLaunchParams();
      HippyBundleLoader localHippyBundleLoader = ((HippyInstanceContext)paramHippyRootView.getContext()).getBundleLoader();
      if ((!this.mDebugMode) && (localHippyBundleLoader != null))
      {
        if (localHippyBundleLoader == null) {
          break;
        }
        paramHippyRootView.getTimeMonitor().startEvent(HippyEngineMonitorEvent.MODULE_LOAD_EVENT_WAIT_LOAD_BUNDLE);
        this.mEngineContext.getBridgeManager().a(paramHippyRootView.getId(), localHippyBundleLoader, this.mModuleListener, paramHippyRootView);
      }
      LogUtils.d("HippyEngineManagerImpl", "in internalLoadInstance before loadInstance");
      this.mEngineContext.getBridgeManager().a(paramHippyRootView.getName(), paramHippyRootView.getId(), (HippyMap)localObject);
    } while (!this.mDebugMode);
    notifyModuleLoaded(0, null, paramHippyRootView);
    return;
    notifyModuleLoaded(-500, "load module error. loader null", paramHippyRootView);
  }
  
  private void notifyModuleLoaded(int paramInt, String paramString, HippyRootView paramHippyRootView)
  {
    if (this.mModuleListener != null)
    {
      if (!UIThreadUtils.isOnUiThread()) {
        break label38;
      }
      if (this.mModuleListener != null)
      {
        this.mModuleListener.onInitialized(paramInt, paramString, paramHippyRootView);
        this.mModuleListener = null;
      }
    }
    return;
    label38:
    UIThreadUtils.runOnUiThread(new HippyEngineManagerImpl.3(this, paramInt, paramString, paramHippyRootView));
  }
  
  private void reportEngineLoadResult(int paramInt, Throwable paramThrowable)
  {
    this.mHandler.removeMessages(100);
    if ((!this.mDebugMode) && (!this.mHasReportEngineLoadResult))
    {
      this.mHasReportEngineLoadResult = true;
      this.mGlobalConfigs.getEngineMonitorAdapter().reportEngineLoadResult(paramInt, this.mStartTimeMonitor.getTotalTime(), this.mStartTimeMonitor.getEvents(), paramThrowable);
    }
  }
  
  private void resetEngine()
  {
    if (this.mEngineContext != null) {
      this.mEngineContext.destroy();
    }
  }
  
  /* Error */
  private void restartEngineInBackground()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 365	com/tencent/mtt/hippy/HippyEngineManagerImpl:mCurrentState	Lcom/tencent/mtt/hippy/HippyEngine$EngineState;
    //   6: getstatic 370	com/tencent/mtt/hippy/HippyEngine$EngineState:DESTROYED	Lcom/tencent/mtt/hippy/HippyEngine$EngineState;
    //   9: if_acmpne +52 -> 61
    //   12: new 206	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   19: ldc_w 372
    //   22: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_0
    //   26: getfield 365	com/tencent/mtt/hippy/HippyEngineManagerImpl:mCurrentState	Lcom/tencent/mtt/hippy/HippyEngine$EngineState;
    //   29: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   32: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: astore_1
    //   36: ldc 19
    //   38: aload_1
    //   39: invokestatic 375	com/tencent/mtt/hippy/utils/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   42: pop
    //   43: aload_0
    //   44: sipush -150
    //   47: new 377	java/lang/Throwable
    //   50: dup
    //   51: aload_1
    //   52: invokespecial 379	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   55: invokevirtual 382	com/tencent/mtt/hippy/HippyEngineManagerImpl:notifyEngineInitialized	(ILjava/lang/Throwable;)V
    //   58: aload_0
    //   59: monitorexit
    //   60: return
    //   61: aload_0
    //   62: getfield 133	com/tencent/mtt/hippy/HippyEngineManagerImpl:mStartTimeMonitor	Lcom/tencent/mtt/hippy/utils/TimeMonitor;
    //   65: invokevirtual 385	com/tencent/mtt/hippy/utils/TimeMonitor:begine	()V
    //   68: aload_0
    //   69: getfield 133	com/tencent/mtt/hippy/HippyEngineManagerImpl:mStartTimeMonitor	Lcom/tencent/mtt/hippy/utils/TimeMonitor;
    //   72: getstatic 388	com/tencent/mtt/hippy/adapter/monitor/HippyEngineMonitorEvent:ENGINE_LOAD_EVENT_INIT_INSTANCE	Ljava/lang/String;
    //   75: invokevirtual 293	com/tencent/mtt/hippy/utils/TimeMonitor:startEvent	(Ljava/lang/String;)V
    //   78: aload_0
    //   79: getfield 365	com/tencent/mtt/hippy/HippyEngineManagerImpl:mCurrentState	Lcom/tencent/mtt/hippy/HippyEngine$EngineState;
    //   82: getstatic 391	com/tencent/mtt/hippy/HippyEngine$EngineState:INITING	Lcom/tencent/mtt/hippy/HippyEngine$EngineState;
    //   85: if_acmpeq +10 -> 95
    //   88: aload_0
    //   89: getstatic 394	com/tencent/mtt/hippy/HippyEngine$EngineState:ONRESTART	Lcom/tencent/mtt/hippy/HippyEngine$EngineState;
    //   92: putfield 365	com/tencent/mtt/hippy/HippyEngineManagerImpl:mCurrentState	Lcom/tencent/mtt/hippy/HippyEngine$EngineState;
    //   95: aload_0
    //   96: invokespecial 396	com/tencent/mtt/hippy/HippyEngineManagerImpl:resetEngine	()V
    //   99: aload_0
    //   100: new 236	com/tencent/mtt/hippy/HippyEngineManagerImpl$HippyEngineContextImpl
    //   103: dup
    //   104: aload_0
    //   105: aload_0
    //   106: getfield 121	com/tencent/mtt/hippy/HippyEngineManagerImpl:mDebugMode	Z
    //   109: invokespecial 399	com/tencent/mtt/hippy/HippyEngineManagerImpl$HippyEngineContextImpl:<init>	(Lcom/tencent/mtt/hippy/HippyEngineManagerImpl;Z)V
    //   112: putfield 204	com/tencent/mtt/hippy/HippyEngineManagerImpl:mEngineContext	Lcom/tencent/mtt/hippy/HippyEngineManagerImpl$HippyEngineContextImpl;
    //   115: aload_0
    //   116: getfield 204	com/tencent/mtt/hippy/HippyEngineManagerImpl:mEngineContext	Lcom/tencent/mtt/hippy/HippyEngineManagerImpl$HippyEngineContextImpl;
    //   119: invokevirtual 297	com/tencent/mtt/hippy/HippyEngineManagerImpl$HippyEngineContextImpl:getBridgeManager	()Lcom/tencent/mtt/hippy/bridge/a;
    //   122: new 401	com/tencent/mtt/hippy/HippyEngineManagerImpl$5
    //   125: dup
    //   126: aload_0
    //   127: invokespecial 404	com/tencent/mtt/hippy/HippyEngineManagerImpl$5:<init>	(Lcom/tencent/mtt/hippy/HippyEngineManagerImpl;)V
    //   130: invokeinterface 407 2 0
    //   135: goto -77 -> 58
    //   138: astore_1
    //   139: aload_0
    //   140: monitorexit
    //   141: aload_1
    //   142: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	this	HippyEngineManagerImpl
    //   35	17	1	str	String
    //   138	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	58	138	finally
    //   61	95	138	finally
    //   95	135	138	finally
  }
  
  public void destroyEngine()
  {
    this.mCurrentState = HippyEngine.EngineState.DESTROYED;
    Iterator localIterator = this.mInstances.iterator();
    while (localIterator.hasNext()) {
      destroyInstance((HippyRootView)localIterator.next());
    }
    this.mEventListeners.clear();
    resetEngine();
    if (this.mGlobalConfigs != null) {
      this.mGlobalConfigs.destroyIfNeed();
    }
    this.mExtendDatas.clear();
  }
  
  public void destroyModule(HippyRootView paramHippyRootView)
  {
    if ((paramHippyRootView == null) || (!this.mInstances.contains(paramHippyRootView))) {
      return;
    }
    paramHippyRootView.setOnResumeAndPauseListener(null);
    paramHippyRootView.setOnSizeChangedListener(null);
    if (this.mDevSupportManager != null) {
      this.mDevSupportManager.b(paramHippyRootView);
    }
    if ((this.mEngineContext != null) && (this.mEngineContext.getBridgeManager() != null)) {
      this.mEngineContext.getBridgeManager().c(paramHippyRootView.getId());
    }
    if ((this.mEngineContext != null) && (this.mEngineContext.mInstanceLifecycleEventListeners != null))
    {
      Iterator localIterator = this.mEngineContext.mInstanceLifecycleEventListeners.iterator();
      while (localIterator.hasNext()) {
        ((HippyInstanceLifecycleEventListener)localIterator.next()).onInstanceDestroy(paramHippyRootView.getId());
      }
    }
    paramHippyRootView.destroy();
    this.mInstances.remove(paramHippyRootView);
  }
  
  public abstract int getBridgeType();
  
  @Deprecated
  public HippyEngineManagerImpl.HippyEngineContextImpl getCurrentEngineContext()
  {
    return getEngineContext();
  }
  
  public HippyEngineManagerImpl.HippyEngineContextImpl getEngineContext()
  {
    return this.mEngineContext;
  }
  
  public abstract ThreadExecutor getThreadExecutor();
  
  public void handleThreadUncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    if ((this.mDebugMode) && (this.mDevSupportManager != null))
    {
      this.mDevSupportManager.a(paramThrowable);
      return;
    }
    this.mGlobalConfigs.getExceptionHandler().handleNativeException(new RuntimeException(paramThrowable), false);
  }
  
  public void initEngine(HippyEngine.EngineListener paramEngineListener)
  {
    if (this.mCurrentState != HippyEngine.EngineState.UNINIT)
    {
      if (paramEngineListener != null) {
        listen(paramEngineListener);
      }
      return;
    }
    this.mCurrentState = HippyEngine.EngineState.INITING;
    if (paramEngineListener != null) {
      this.mEventListeners.add(paramEngineListener);
    }
    this.mGlobalConfigs.getEngineMonitorAdapter().reportEngineLoadStart();
    this.mHandler.removeMessages(100);
    try
    {
      this.mDevSupportManager = new n(this.mGlobalConfigs, this.mDebugMode, this.mServerHost, this.mServerBundleName);
      this.mDevSupportManager.a(this);
      if (this.mDebugMode)
      {
        this.mDevSupportManager.a(null);
        return;
      }
    }
    catch (Throwable paramEngineListener)
    {
      this.mCurrentState = HippyEngine.EngineState.INITERRORED;
      notifyEngineInitialized(-200, paramEngineListener);
      return;
    }
    LogUtils.d("HippyEngineManagerImpl", "start restartEngineInBackground...");
    restartEngineInBackground();
  }
  
  public boolean isDebugMode()
  {
    return this.mDebugMode;
  }
  
  @Deprecated
  public HippyRootView loadInstance(HippyRootViewParams paramHippyRootViewParams)
  {
    return loadInstance(paramHippyRootViewParams, null, null);
  }
  
  @Deprecated
  public HippyRootView loadInstance(HippyRootViewParams paramHippyRootViewParams, HippyEngine.ModuleListener paramModuleListener)
  {
    return loadInstance(paramHippyRootViewParams, paramModuleListener, null);
  }
  
  @Deprecated
  public HippyRootView loadInstance(HippyRootViewParams paramHippyRootViewParams, HippyEngine.ModuleListener paramModuleListener, HippyRootView.OnLoadCompleteListener paramOnLoadCompleteListener)
  {
    HippyEngine.ModuleLoadParams localModuleLoadParams = new HippyEngine.ModuleLoadParams();
    localModuleLoadParams.context = paramHippyRootViewParams.getActivity();
    localModuleLoadParams.componentName = paramHippyRootViewParams.getName();
    HippyBundleLoader localHippyBundleLoader = paramHippyRootViewParams.getBundleLoader();
    if ((localHippyBundleLoader instanceof HippyAssetBundleLoader)) {
      localModuleLoadParams.jsAssetsPath = paramHippyRootViewParams.getBundleLoader().getRawPath();
    }
    for (;;)
    {
      localModuleLoadParams.jsParams = paramHippyRootViewParams.getLaunchParams();
      localModuleLoadParams.nativeParams = paramHippyRootViewParams.getNativeParams();
      localModuleLoadParams.hippyContext = paramHippyRootViewParams.getInstanceContext();
      localModuleLoadParams.bundleLoader = paramHippyRootViewParams.getBundleLoader();
      return loadModule(localModuleLoadParams, paramModuleListener, paramOnLoadCompleteListener);
      if ((localHippyBundleLoader instanceof HippyFileBundleLoader)) {
        localModuleLoadParams.jsFilePath = paramHippyRootViewParams.getBundleLoader().getRawPath();
      }
    }
  }
  
  public HippyRootView loadModule(HippyEngine.ModuleLoadParams paramModuleLoadParams)
  {
    return loadModule(paramModuleLoadParams, null, null);
  }
  
  public HippyRootView loadModule(HippyEngine.ModuleLoadParams paramModuleLoadParams, HippyEngine.ModuleListener paramModuleListener)
  {
    return loadModule(paramModuleLoadParams, paramModuleListener, null);
  }
  
  public HippyRootView loadModule(HippyEngine.ModuleLoadParams paramModuleLoadParams, HippyEngine.ModuleListener paramModuleListener, HippyRootView.OnLoadCompleteListener paramOnLoadCompleteListener)
  {
    if (paramModuleLoadParams == null) {
      throw new RuntimeException("Hippy: loadModule loadParams must no be null");
    }
    if (paramModuleLoadParams.context == null) {
      throw new RuntimeException("Hippy: loadModule loadParams.context must no be null");
    }
    if ((!this.mDebugMode) && (TextUtils.isEmpty(paramModuleLoadParams.jsAssetsPath)) && (TextUtils.isEmpty(paramModuleLoadParams.jsFilePath))) {
      throw new RuntimeException("Hippy: loadModule debugMode=true, loadParams.jsAssetsPath and jsFilePath both null!");
    }
    if (paramModuleLoadParams.jsParams == null) {
      paramModuleLoadParams.jsParams = new HippyMap();
    }
    if (paramModuleLoadParams.hippyContext != null) {
      paramModuleLoadParams.hippyContext.setModuleParams(paramModuleLoadParams);
    }
    if (!TextUtils.isEmpty(paramModuleLoadParams.jsAssetsPath)) {
      paramModuleLoadParams.jsParams.pushString("sourcePath", paramModuleLoadParams.jsAssetsPath);
    }
    for (;;)
    {
      this.mModuleListener = paramModuleListener;
      paramModuleLoadParams = new HippyRootView(paramModuleLoadParams);
      if (this.mCurrentState != HippyEngine.EngineState.DESTROYED) {
        break;
      }
      notifyModuleLoaded(-150, "load module error wrong state, Engine destroyed", paramModuleLoadParams);
      return paramModuleLoadParams;
      paramModuleLoadParams.jsParams.pushString("sourcePath", paramModuleLoadParams.jsFilePath);
    }
    if (paramOnLoadCompleteListener != null) {
      paramModuleLoadParams.setOnLoadCompleteListener(paramOnLoadCompleteListener);
    }
    boolean bool;
    if (!this.mDebugMode)
    {
      bool = true;
      paramModuleLoadParams.setTimeMonitor(new TimeMonitor(bool));
      paramModuleLoadParams.getTimeMonitor().begine();
      paramModuleLoadParams.getTimeMonitor().startEvent(HippyEngineMonitorEvent.MODULE_LOAD_EVENT_WAIT_ENGINE);
      paramModuleLoadParams.setOnResumeAndPauseListener(this);
      paramModuleLoadParams.setOnSizeChangedListener(this);
      paramModuleLoadParams.attachEngineManager(this);
      this.mInstances.add(paramModuleLoadParams);
      this.mDevSupportManager.a(paramModuleLoadParams);
      if ((!this.mDevManagerInited) && (this.mDebugMode)) {
        this.mDevManagerInited = true;
      }
      LogUtils.d("HippyEngineManagerImpl", "internalLoadInstance start...");
      if (this.mCurrentState != HippyEngine.EngineState.INITED) {
        break label314;
      }
      internalLoadInstance(paramModuleLoadParams);
    }
    for (;;)
    {
      return paramModuleLoadParams;
      bool = false;
      break;
      label314:
      notifyModuleLoaded(-150, "error wrong state, Engine state not INITED, state:" + this.mCurrentState, paramModuleLoadParams);
    }
  }
  
  void notifyEngineInitialized(int paramInt, Throwable paramThrowable)
  {
    this.mHandler.removeMessages(100);
    if (this.mPreloadBundleLoader != null)
    {
      LogUtils.d("HippyEngineManagerImpl", "preload bundle loader");
      preloadModule(this.mPreloadBundleLoader);
    }
    if (UIThreadUtils.isOnUiThread())
    {
      this.mStartTimeMonitor.end();
      int i;
      label73:
      HippyEngine.EngineListener localEngineListener;
      if (this.mCurrentState == HippyEngine.EngineState.INITED)
      {
        i = 0;
        reportEngineLoadResult(i, paramThrowable);
        Iterator localIterator = this.mEventListeners.iterator();
        if (!localIterator.hasNext()) {
          break label129;
        }
        localEngineListener = (HippyEngine.EngineListener)localIterator.next();
        if (paramThrowable != null) {
          break label120;
        }
      }
      label120:
      for (String str = null;; str = paramThrowable.toString())
      {
        localEngineListener.onInitialized(paramInt, str);
        break label73;
        i = 1;
        break;
      }
      label129:
      this.mEventListeners.clear();
      return;
    }
    UIThreadUtils.runOnUiThread(new HippyEngineManagerImpl.4(this, paramThrowable, paramInt));
  }
  
  public boolean onBackPress(DeviceEventModule.InvokeDefaultBackPress paramInvokeDefaultBackPress)
  {
    return onBackPressed(new HippyEngineManagerImpl.2(this, paramInvokeDefaultBackPress));
  }
  
  public boolean onBackPressed(HippyEngine.BackPressHandler paramBackPressHandler)
  {
    if ((this.mEngineContext != null) && (this.mEngineContext.getModuleManager().getNativeModule(DeviceEventModule.class) != null)) {
      return ((DeviceEventModule)this.mEngineContext.getModuleManager().getNativeModule(DeviceEventModule.class)).onBackPressed(paramBackPressHandler);
    }
    return false;
  }
  
  public void onDevBundleLoadReady(File paramFile)
  {
    this.mCoreBundleLoader = new HippyFileBundleLoader(paramFile.getAbsolutePath());
    restartEngineInBackground();
  }
  
  public void onEnginePause()
  {
    if ((this.mEngineContext != null) && (this.mEngineContext.mEngineLifecycleEventListeners != null))
    {
      Object localObject = this.mInstances.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((HippyRootView)((Iterator)localObject).next()).onPause();
      }
      localObject = this.mEngineContext.getDomManager();
      if (localObject != null) {
        ((DomManager)localObject).onEnginePause();
      }
      localObject = this.mEngineContext.mEngineLifecycleEventListeners.iterator();
      while (((Iterator)localObject).hasNext())
      {
        HippyEngineLifecycleEventListener localHippyEngineLifecycleEventListener = (HippyEngineLifecycleEventListener)((Iterator)localObject).next();
        if (!(localHippyEngineLifecycleEventListener instanceof DomManager)) {
          localHippyEngineLifecycleEventListener.onEnginePause();
        }
      }
    }
  }
  
  public void onEngineResume()
  {
    if ((this.mEngineContext != null) && (this.mEngineContext.mEngineLifecycleEventListeners != null))
    {
      Object localObject = this.mInstances.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((HippyRootView)((Iterator)localObject).next()).onResume();
      }
      localObject = this.mEngineContext.mEngineLifecycleEventListeners.iterator();
      while (((Iterator)localObject).hasNext())
      {
        HippyEngineLifecycleEventListener localHippyEngineLifecycleEventListener = (HippyEngineLifecycleEventListener)((Iterator)localObject).next();
        if (!(localHippyEngineLifecycleEventListener instanceof DomManager)) {
          localHippyEngineLifecycleEventListener.onEngineResume();
        }
      }
      localObject = this.mEngineContext.getDomManager();
      if (localObject != null) {
        ((DomManager)localObject).onEngineResume();
      }
    }
  }
  
  public void onInitDevError(Throwable paramThrowable)
  {
    this.mCurrentState = HippyEngine.EngineState.INITED;
    this.mDevManagerInited = false;
    notifyEngineInitialized(-100, paramThrowable);
  }
  
  public void onInstancePause(int paramInt)
  {
    if (this.mEngineContext == null) {}
    do
    {
      return;
      if (this.mEngineContext.mInstanceLifecycleEventListeners != null)
      {
        Iterator localIterator = this.mEngineContext.mInstanceLifecycleEventListeners.iterator();
        while (localIterator.hasNext()) {
          ((HippyInstanceLifecycleEventListener)localIterator.next()).onInstancePause(paramInt);
        }
      }
    } while (this.mEngineContext.getBridgeManager() == null);
    this.mEngineContext.getBridgeManager().b(paramInt);
  }
  
  public void onInstanceResume(int paramInt)
  {
    if (this.mEngineContext == null) {}
    do
    {
      return;
      if (this.mEngineContext.mInstanceLifecycleEventListeners != null)
      {
        Iterator localIterator = this.mEngineContext.mInstanceLifecycleEventListeners.iterator();
        while (localIterator.hasNext()) {
          ((HippyInstanceLifecycleEventListener)localIterator.next()).onInstanceResume(paramInt);
        }
      }
    } while (this.mEngineContext.getBridgeManager() == null);
    this.mEngineContext.getBridgeManager().a(paramInt);
  }
  
  public void onSizeChanged(HippyRootView paramHippyRootView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    getThreadExecutor().postOnDomThread(new HippyEngineManagerImpl.6(this, paramHippyRootView, paramInt1, paramInt2));
  }
  
  public HippyInstanceContext preCreateInstanceContext(Context paramContext)
  {
    return new HippyInstanceContext(paramContext);
  }
  
  public void preloadModule(HippyBundleLoader paramHippyBundleLoader)
  {
    if ((this.mEngineContext != null) && (this.mEngineContext.getBridgeManager() != null)) {
      this.mEngineContext.getBridgeManager().a(-1, paramHippyBundleLoader, null, null);
    }
  }
  
  public void sendEvent(String paramString, Object paramObject)
  {
    if ((this.mEngineContext != null) && (this.mEngineContext.getModuleManager() != null)) {
      ((EventDispatcher)this.mEngineContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveNativeEvent(paramString, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.HippyEngineManagerImpl
 * JD-Core Version:    0.7.0.1
 */