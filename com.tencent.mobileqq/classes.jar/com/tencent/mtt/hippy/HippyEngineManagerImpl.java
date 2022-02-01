package com.tencent.mtt.hippy;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mtt.hippy.a.g;
import com.tencent.mtt.hippy.a.n;
import com.tencent.mtt.hippy.adapter.exception.HippyExceptionHandlerAdapter;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorAdapter;
import com.tencent.mtt.hippy.adapter.thirdparty.HippyThirdPartyAdapter;
import com.tencent.mtt.hippy.bridge.a;
import com.tencent.mtt.hippy.bridge.bundleloader.HippyAssetBundleLoader;
import com.tencent.mtt.hippy.bridge.bundleloader.HippyBundleLoader;
import com.tencent.mtt.hippy.bridge.bundleloader.HippyFileBundleLoader;
import com.tencent.mtt.hippy.bridge.bundleloader.HippyRemoteBundleLoader;
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
import java.io.InputStream;
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
  final List<HippyAPIProvider> mAPIProviders;
  HippyBundleLoader mCoreBundleLoader;
  final boolean mDebugMode;
  boolean mDevManagerInited = false;
  n mDevSupportManager;
  boolean mEnableHippyBuffer;
  HippyEngineManagerImpl.HippyEngineContextImpl mEngineContext;
  final HippyGlobalConfigs mGlobalConfigs;
  final Handler mHandler = new HippyEngineManagerImpl.1(this, Looper.getMainLooper());
  boolean mHasReportEngineLoadResult = false;
  final CopyOnWriteArrayList<HippyRootView> mInstances = new CopyOnWriteArrayList();
  final HippyBundleLoader mPreloadBundleLoader;
  final String mServerBundleName;
  private final String mServerHost;
  final TimeMonitor mStartTimeMonitor;
  private final HippyThirdPartyAdapter mThirdPartyAdapter;
  
  HippyEngineManagerImpl(HippyEngine.EngineInitParams paramEngineInitParams, HippyBundleLoader paramHippyBundleLoader)
  {
    Object localObject;
    if (!TextUtils.isEmpty(paramEngineInitParams.coreJSAssetsPath)) {
      localObject = new HippyAssetBundleLoader(paramEngineInitParams.context, paramEngineInitParams.coreJSAssetsPath, TextUtils.isEmpty(paramEngineInitParams.codeCacheTag) ^ true, paramEngineInitParams.codeCacheTag);
    } else if (!TextUtils.isEmpty(paramEngineInitParams.coreJSFilePath)) {
      localObject = new HippyFileBundleLoader(paramEngineInitParams.coreJSFilePath, TextUtils.isEmpty(paramEngineInitParams.codeCacheTag) ^ true, paramEngineInitParams.codeCacheTag);
    } else {
      localObject = null;
    }
    this.mGlobalConfigs = new HippyGlobalConfigs(paramEngineInitParams);
    this.mCoreBundleLoader = ((HippyBundleLoader)localObject);
    this.mPreloadBundleLoader = paramHippyBundleLoader;
    this.mAPIProviders = paramEngineInitParams.providers;
    this.mDebugMode = paramEngineInitParams.debugMode;
    if (paramEngineInitParams.debugMode)
    {
      paramEngineInitParams.getClass();
      paramHippyBundleLoader = "index.bundle";
    }
    else
    {
      paramHippyBundleLoader = "";
    }
    this.mServerBundleName = paramHippyBundleLoader;
    this.mStartTimeMonitor = new TimeMonitor(paramEngineInitParams.debugMode ^ true);
    this.mEnableHippyBuffer = paramEngineInitParams.enableBuffer;
    this.mServerHost = paramEngineInitParams.debugServerHost;
    this.mGroupId = paramEngineInitParams.groupId;
    this.mThirdPartyAdapter = paramEngineInitParams.thirdPartyAdapter;
  }
  
  private void internalLoadInstance(HippyRootView paramHippyRootView)
  {
    Object localObject1;
    if ((this.mEngineContext != null) && (paramHippyRootView != null))
    {
      LogUtils.d("HippyEngineManagerImpl", "in internalLoadInstance");
      if (this.mEngineContext.mInstanceLifecycleEventListeners != null)
      {
        localObject1 = this.mEngineContext.mInstanceLifecycleEventListeners.iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((HippyInstanceLifecycleEventListener)((Iterator)localObject1).next()).onInstanceLoad(paramHippyRootView.getId());
        }
      }
      paramHippyRootView.attachToEngine(this.mEngineContext);
      localObject1 = paramHippyRootView.getLaunchParams();
      localObject2 = ((HippyInstanceContext)paramHippyRootView.getContext()).getBundleLoader();
      if ((!this.mDebugMode) && (localObject2 != null)) {
        if (localObject2 != null)
        {
          paramHippyRootView.getTimeMonitor().startEvent("waitLoadBundle");
          this.mEngineContext.getBridgeManager().a(paramHippyRootView.getId(), (HippyBundleLoader)localObject2, this.mModuleListener, paramHippyRootView);
        }
        else
        {
          localObject1 = HippyEngine.ModuleLoadStatus.STATUS_VARIABLE_NULL;
        }
      }
    }
    for (Object localObject2 = "load module error. loader==null";; localObject2 = ((StringBuilder)localObject2).toString())
    {
      notifyModuleLoaded((HippyEngine.ModuleLoadStatus)localObject1, (String)localObject2, paramHippyRootView);
      return;
      LogUtils.d("HippyEngineManagerImpl", "in internalLoadInstance before loadInstance");
      this.mEngineContext.getBridgeManager().a(paramHippyRootView.getName(), paramHippyRootView.getId(), (HippyMap)localObject1);
      if (this.mDebugMode) {
        notifyModuleLoaded(HippyEngine.ModuleLoadStatus.STATUS_OK, null, paramHippyRootView);
      }
      return;
      localObject1 = HippyEngine.ModuleLoadStatus.STATUS_VARIABLE_NULL;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("load module error. mEngineContext=");
      ((StringBuilder)localObject2).append(this.mEngineContext);
      ((StringBuilder)localObject2).append(", HippyRootView instance=");
      ((StringBuilder)localObject2).append(paramHippyRootView);
    }
  }
  
  private void notifyModuleLoaded(HippyEngine.ModuleLoadStatus paramModuleLoadStatus, String paramString, HippyRootView paramHippyRootView)
  {
    if (this.mModuleListener != null) {
      if (UIThreadUtils.isOnUiThread())
      {
        if (this.mModuleListener != null)
        {
          this.mModuleListener.onLoadCompleted(paramModuleLoadStatus, paramString, paramHippyRootView);
          this.mModuleListener = null;
        }
      }
      else {
        UIThreadUtils.runOnUiThread(new HippyEngineManagerImpl.4(this, paramModuleLoadStatus, paramString, paramHippyRootView));
      }
    }
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
    HippyEngineManagerImpl.HippyEngineContextImpl localHippyEngineContextImpl = this.mEngineContext;
    if (localHippyEngineContextImpl != null) {
      localHippyEngineContextImpl.destroy();
    }
  }
  
  private void restartEngineInBackground()
  {
    try
    {
      if (this.mCurrentState == HippyEngine.EngineState.DESTROYED)
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("restartEngineInBackground... error STATUS_WRONG_STATE, state=");
        ((StringBuilder)localObject1).append(this.mCurrentState);
        localObject1 = ((StringBuilder)localObject1).toString();
        LogUtils.e("HippyEngineManagerImpl", (String)localObject1);
        notifyEngineInitialized(HippyEngine.EngineInitStatus.STATUS_WRONG_STATE, new Throwable((String)localObject1));
        return;
      }
      this.mStartTimeMonitor.begine();
      this.mStartTimeMonitor.startEvent("initInstance");
      if (this.mCurrentState != HippyEngine.EngineState.INITING) {
        this.mCurrentState = HippyEngine.EngineState.ONRESTART;
      }
      resetEngine();
      this.mEngineContext = new HippyEngineManagerImpl.HippyEngineContextImpl(this, this.mDebugMode, this.mServerHost);
      this.mEngineContext.getBridgeManager().a(new HippyEngineManagerImpl.6(this));
      return;
    }
    finally {}
  }
  
  public void destroyEngine()
  {
    HippyEngineManagerImpl.HippyEngineContextImpl localHippyEngineContextImpl = this.mEngineContext;
    if (localHippyEngineContextImpl == null) {
      return;
    }
    localHippyEngineContextImpl.destroyBridge(new HippyEngineManagerImpl.2(this));
  }
  
  public void destroyModule(HippyRootView paramHippyRootView)
  {
    if (paramHippyRootView != null)
    {
      if (!this.mInstances.contains(paramHippyRootView)) {
        return;
      }
      paramHippyRootView.setOnResumeAndPauseListener(null);
      paramHippyRootView.setOnSizeChangedListener(null);
      Object localObject = this.mDevSupportManager;
      if (localObject != null) {
        ((n)localObject).b(paramHippyRootView);
      }
      localObject = this.mEngineContext;
      if ((localObject != null) && (((HippyEngineManagerImpl.HippyEngineContextImpl)localObject).getBridgeManager() != null)) {
        this.mEngineContext.getBridgeManager().c(paramHippyRootView.getId());
      }
      localObject = this.mEngineContext;
      if ((localObject != null) && (((HippyEngineManagerImpl.HippyEngineContextImpl)localObject).mInstanceLifecycleEventListeners != null))
      {
        localObject = this.mEngineContext.mInstanceLifecycleEventListeners.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((HippyInstanceLifecycleEventListener)((Iterator)localObject).next()).onInstanceDestroy(paramHippyRootView.getId());
        }
      }
      paramHippyRootView.destroy();
      this.mInstances.remove(paramHippyRootView);
    }
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
  
  public void handleThreadUncaughtException(Thread paramThread, Throwable paramThrowable, Integer paramInteger)
  {
    if (this.mDebugMode)
    {
      paramThread = this.mDevSupportManager;
      if (paramThread != null)
      {
        paramThread.a(paramThrowable);
        return;
      }
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
        this.mCoreBundleLoader = new HippyRemoteBundleLoader(this.mDevSupportManager.a(this.mServerBundleName));
        ((HippyRemoteBundleLoader)this.mCoreBundleLoader).setIsDebugMode(true);
      }
      LogUtils.d("HippyEngineManagerImpl", "start restartEngineInBackground...");
      restartEngineInBackground();
      return;
    }
    catch (Throwable paramEngineListener)
    {
      this.mCurrentState = HippyEngine.EngineState.INITERRORED;
      notifyEngineInitialized(HippyEngine.EngineInitStatus.STATUS_INIT_EXCEPTION, paramEngineListener);
    }
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
    } else if ((localHippyBundleLoader instanceof HippyFileBundleLoader)) {
      localModuleLoadParams.jsFilePath = paramHippyRootViewParams.getBundleLoader().getRawPath();
    }
    localModuleLoadParams.jsParams = paramHippyRootViewParams.getLaunchParams();
    localModuleLoadParams.nativeParams = paramHippyRootViewParams.getNativeParams();
    localModuleLoadParams.hippyContext = paramHippyRootViewParams.getInstanceContext();
    localModuleLoadParams.bundleLoader = paramHippyRootViewParams.getBundleLoader();
    return loadModule(localModuleLoadParams, paramModuleListener, paramOnLoadCompleteListener);
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
    if (paramModuleLoadParams != null)
    {
      if (paramModuleLoadParams.context != null)
      {
        if ((!this.mDebugMode) && (TextUtils.isEmpty(paramModuleLoadParams.jsAssetsPath)) && (TextUtils.isEmpty(paramModuleLoadParams.jsFilePath))) {
          throw new RuntimeException("Hippy: loadModule debugMode=true, loadParams.jsAssetsPath and jsFilePath both null!");
        }
        if (paramModuleLoadParams.jsParams == null) {
          paramModuleLoadParams.jsParams = new HippyMap();
        }
        if (paramModuleLoadParams.hippyContext != null) {
          paramModuleLoadParams.hippyContext.setModuleParams(paramModuleLoadParams);
        }
        HippyMap localHippyMap;
        String str;
        if (!TextUtils.isEmpty(paramModuleLoadParams.jsAssetsPath))
        {
          localHippyMap = paramModuleLoadParams.jsParams;
          str = paramModuleLoadParams.jsAssetsPath;
        }
        else
        {
          localHippyMap = paramModuleLoadParams.jsParams;
          str = paramModuleLoadParams.jsFilePath;
        }
        localHippyMap.pushString("sourcePath", str);
        this.mModuleListener = paramModuleListener;
        paramModuleLoadParams = new HippyRootView(paramModuleLoadParams);
        if (this.mCurrentState == HippyEngine.EngineState.DESTROYED)
        {
          notifyModuleLoaded(HippyEngine.ModuleLoadStatus.STATUS_ENGINE_UNINIT, "load module error wrong state, Engine destroyed", paramModuleLoadParams);
          return paramModuleLoadParams;
        }
        if (paramOnLoadCompleteListener != null) {
          paramModuleLoadParams.setOnLoadCompleteListener(paramOnLoadCompleteListener);
        }
        paramModuleLoadParams.setTimeMonitor(new TimeMonitor(this.mDebugMode ^ true));
        paramModuleLoadParams.getTimeMonitor().begine();
        paramModuleLoadParams.getTimeMonitor().startEvent("waitEngine");
        paramModuleLoadParams.setOnResumeAndPauseListener(this);
        paramModuleLoadParams.setOnSizeChangedListener(this);
        paramModuleLoadParams.attachEngineManager(this);
        this.mInstances.add(paramModuleLoadParams);
        this.mDevSupportManager.a(paramModuleLoadParams);
        if ((!this.mDevManagerInited) && (this.mDebugMode)) {
          this.mDevManagerInited = true;
        }
        LogUtils.d("HippyEngineManagerImpl", "internalLoadInstance start...");
        if (this.mCurrentState == HippyEngine.EngineState.INITED)
        {
          internalLoadInstance(paramModuleLoadParams);
          return paramModuleLoadParams;
        }
        paramModuleListener = HippyEngine.ModuleLoadStatus.STATUS_ENGINE_UNINIT;
        paramOnLoadCompleteListener = new StringBuilder();
        paramOnLoadCompleteListener.append("error wrong state, Engine state not INITED, state:");
        paramOnLoadCompleteListener.append(this.mCurrentState);
        notifyModuleLoaded(paramModuleListener, paramOnLoadCompleteListener.toString(), paramModuleLoadParams);
        return paramModuleLoadParams;
      }
      throw new RuntimeException("Hippy: loadModule loadParams.context must no be null");
    }
    throw new RuntimeException("Hippy: loadModule loadParams must no be null");
  }
  
  void notifyEngineInitialized(HippyEngine.EngineInitStatus paramEngineInitStatus, Throwable paramThrowable)
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
      if (this.mCurrentState == HippyEngine.EngineState.INITED) {
        i = 0;
      } else {
        i = 1;
      }
      reportEngineLoadResult(i, paramThrowable);
      Iterator localIterator = this.mEventListeners.iterator();
      while (localIterator.hasNext())
      {
        HippyEngine.EngineListener localEngineListener = (HippyEngine.EngineListener)localIterator.next();
        String str;
        if (paramThrowable == null) {
          str = null;
        } else {
          str = paramThrowable.toString();
        }
        localEngineListener.onInitialized(paramEngineInitStatus, str);
      }
      this.mEventListeners.clear();
      return;
    }
    UIThreadUtils.runOnUiThread(new HippyEngineManagerImpl.5(this, paramThrowable, paramEngineInitStatus));
  }
  
  public boolean onBackPress(DeviceEventModule.InvokeDefaultBackPress paramInvokeDefaultBackPress)
  {
    return onBackPressed(new HippyEngineManagerImpl.3(this, paramInvokeDefaultBackPress));
  }
  
  public boolean onBackPressed(HippyEngine.BackPressHandler paramBackPressHandler)
  {
    HippyEngineManagerImpl.HippyEngineContextImpl localHippyEngineContextImpl = this.mEngineContext;
    if ((localHippyEngineContextImpl != null) && (localHippyEngineContextImpl.getModuleManager().getNativeModule(DeviceEventModule.class) != null)) {
      return ((DeviceEventModule)this.mEngineContext.getModuleManager().getNativeModule(DeviceEventModule.class)).onBackPressed(paramBackPressHandler);
    }
    return false;
  }
  
  protected void onDestroy()
  {
    this.mCurrentState = HippyEngine.EngineState.DESTROYED;
    Object localObject = this.mInstances.iterator();
    while (((Iterator)localObject).hasNext()) {
      destroyInstance((HippyRootView)((Iterator)localObject).next());
    }
    this.mEventListeners.clear();
    resetEngine();
    localObject = this.mGlobalConfigs;
    if (localObject != null) {
      ((HippyGlobalConfigs)localObject).destroyIfNeed();
    }
    this.mExtendDatas.clear();
  }
  
  public void onDevBundleLoadReady(InputStream paramInputStream) {}
  
  public void onDevBundleReLoad()
  {
    restartEngineInBackground();
  }
  
  public void onEnginePause()
  {
    Object localObject = this.mEngineContext;
    if ((localObject != null) && (((HippyEngineManagerImpl.HippyEngineContextImpl)localObject).mEngineLifecycleEventListeners != null))
    {
      localObject = this.mInstances.iterator();
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
    Object localObject = this.mEngineContext;
    if ((localObject != null) && (((HippyEngineManagerImpl.HippyEngineContextImpl)localObject).mEngineLifecycleEventListeners != null))
    {
      localObject = this.mInstances.iterator();
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
    notifyEngineInitialized(HippyEngine.EngineInitStatus.STATUS_ERR_DEVSERVER, paramThrowable);
  }
  
  public void onInstancePause(int paramInt)
  {
    Object localObject = this.mEngineContext;
    if (localObject == null) {
      return;
    }
    if (((HippyEngineManagerImpl.HippyEngineContextImpl)localObject).mInstanceLifecycleEventListeners != null)
    {
      localObject = this.mEngineContext.mInstanceLifecycleEventListeners.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((HippyInstanceLifecycleEventListener)((Iterator)localObject).next()).onInstancePause(paramInt);
      }
    }
    if (this.mEngineContext.getBridgeManager() != null) {
      this.mEngineContext.getBridgeManager().b(paramInt);
    }
  }
  
  public void onInstanceResume(int paramInt)
  {
    Object localObject = this.mEngineContext;
    if (localObject == null) {
      return;
    }
    if (((HippyEngineManagerImpl.HippyEngineContextImpl)localObject).mInstanceLifecycleEventListeners != null)
    {
      localObject = this.mEngineContext.mInstanceLifecycleEventListeners.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((HippyInstanceLifecycleEventListener)((Iterator)localObject).next()).onInstanceResume(paramInt);
      }
    }
    if (this.mEngineContext.getBridgeManager() != null) {
      this.mEngineContext.getBridgeManager().a(paramInt);
    }
  }
  
  public void onSizeChanged(HippyRootView paramHippyRootView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    getThreadExecutor().postOnDomThread(new HippyEngineManagerImpl.7(this, paramHippyRootView, paramInt1, paramInt2));
  }
  
  public HippyInstanceContext preCreateInstanceContext(Context paramContext)
  {
    return new HippyInstanceContext(paramContext);
  }
  
  public void preloadModule(HippyBundleLoader paramHippyBundleLoader)
  {
    HippyEngineManagerImpl.HippyEngineContextImpl localHippyEngineContextImpl = this.mEngineContext;
    if ((localHippyEngineContextImpl != null) && (localHippyEngineContextImpl.getBridgeManager() != null)) {
      this.mEngineContext.getBridgeManager().a(-1, paramHippyBundleLoader, null, null);
    }
  }
  
  public void sendEvent(String paramString, Object paramObject)
  {
    HippyEngineManagerImpl.HippyEngineContextImpl localHippyEngineContextImpl = this.mEngineContext;
    if ((localHippyEngineContextImpl != null) && (localHippyEngineContextImpl.getModuleManager() != null)) {
      ((EventDispatcher)this.mEngineContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveNativeEvent(paramString, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.HippyEngineManagerImpl
 * JD-Core Version:    0.7.0.1
 */