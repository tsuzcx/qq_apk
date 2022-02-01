package com.tencent.mtt.hippy;

import com.tencent.mtt.hippy.bridge.a.a;
import com.tencent.mtt.hippy.bridge.bundleloader.HippyBundleLoader;
import com.tencent.mtt.hippy.utils.ContextHolder;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.mtt.hippy.utils.UIThreadUtils;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class HippyEngine
{
  private static final AtomicInteger sIdCounter = new AtomicInteger();
  volatile HippyEngine.EngineState mCurrentState = HippyEngine.EngineState.UNINIT;
  final CopyOnWriteArrayList<HippyEngine.EngineListener> mEventListeners = new CopyOnWriteArrayList();
  protected int mGroupId;
  private final int mID = sIdCounter.getAndIncrement();
  HippyEngine.ModuleListener mModuleListener;
  
  static
  {
    a.a();
  }
  
  public static HippyEngine create(HippyEngine.EngineInitParams paramEngineInitParams)
  {
    if (paramEngineInitParams != null)
    {
      paramEngineInitParams.check();
      LogUtils.enableDebugLog(paramEngineInitParams.enableLog);
      ContextHolder.initAppContext(paramEngineInitParams.context);
      if (paramEngineInitParams.groupId == -1) {
        return new HippyNormalEngineManager(paramEngineInitParams, null);
      }
      return new HippySingleThreadEngineManager(paramEngineInitParams, null);
    }
    throw new RuntimeException("Hippy: initParams must no be null");
  }
  
  private void listenInUIThread(HippyEngine.EngineListener paramEngineListener)
  {
    HippyEngine.EngineInitStatus localEngineInitStatus;
    if (this.mCurrentState == HippyEngine.EngineState.INITED) {
      localEngineInitStatus = HippyEngine.EngineInitStatus.STATUS_OK;
    }
    for (Object localObject = null;; localObject = ((StringBuilder)localObject).toString())
    {
      paramEngineListener.onInitialized(localEngineInitStatus, (String)localObject);
      return;
      if ((this.mCurrentState != HippyEngine.EngineState.INITERRORED) && (this.mCurrentState != HippyEngine.EngineState.DESTROYED))
      {
        this.mEventListeners.add(paramEngineListener);
        return;
      }
      localEngineInitStatus = HippyEngine.EngineInitStatus.STATUS_WRONG_STATE;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("engine state=");
      ((StringBuilder)localObject).append(this.mCurrentState);
    }
  }
  
  public abstract void destroyEngine();
  
  public abstract void destroyModule(HippyRootView paramHippyRootView);
  
  public abstract HippyEngineContext getEngineContext();
  
  public HippyEngine.EngineState getEngineState()
  {
    return this.mCurrentState;
  }
  
  public int getGroupId()
  {
    return this.mGroupId;
  }
  
  public int getId()
  {
    return this.mID;
  }
  
  public abstract void initEngine(HippyEngine.EngineListener paramEngineListener);
  
  public abstract boolean isDebugMode();
  
  protected void listen(HippyEngine.EngineListener paramEngineListener)
  {
    if (UIThreadUtils.isOnUiThread())
    {
      listenInUIThread(paramEngineListener);
      return;
    }
    UIThreadUtils.runOnUiThread(new HippyEngine.1(this, paramEngineListener));
  }
  
  public abstract HippyRootView loadModule(HippyEngine.ModuleLoadParams paramModuleLoadParams);
  
  public abstract HippyRootView loadModule(HippyEngine.ModuleLoadParams paramModuleLoadParams, HippyEngine.ModuleListener paramModuleListener);
  
  public abstract HippyRootView loadModule(HippyEngine.ModuleLoadParams paramModuleLoadParams, HippyEngine.ModuleListener paramModuleListener, HippyRootView.OnLoadCompleteListener paramOnLoadCompleteListener);
  
  public abstract boolean onBackPressed(HippyEngine.BackPressHandler paramBackPressHandler);
  
  public abstract void onEnginePause();
  
  public abstract void onEngineResume();
  
  public abstract void preloadModule(HippyBundleLoader paramHippyBundleLoader);
  
  public abstract void sendEvent(String paramString, Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.HippyEngine
 * JD-Core Version:    0.7.0.1
 */