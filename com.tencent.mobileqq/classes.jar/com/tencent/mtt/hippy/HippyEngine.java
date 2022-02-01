package com.tencent.mtt.hippy;

import android.content.Context;
import com.tencent.mtt.hippy.bridge.bundleloader.HippyBundleLoader;
import com.tencent.mtt.hippy.utils.ContextHolder;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.mtt.hippy.utils.UIThreadUtils;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class HippyEngine
{
  public static final int STATUS_ERR_BRIDGE = -50;
  public static final int STATUS_ERR_DEVSERVER = -100;
  public static final int STATUS_ERR_RUN_BUNDLE = -600;
  public static final int STATUS_INIT_EXCEPTION = -200;
  public static final int STATUS_OK = 0;
  public static final int STATUS_REPEAT_LOAD = -700;
  public static final int STATUS_VARIABLE_UNINIT = -500;
  public static final int STATUS_WRONG_STATE = -150;
  public static final int STATUS_WRONG_STATE_LISTEN = -151;
  private static final AtomicInteger sIdCounter = new AtomicInteger();
  volatile HippyEngine.EngineState mCurrentState = HippyEngine.EngineState.UNINIT;
  final CopyOnWriteArrayList<HippyEngine.EngineListener> mEventListeners = new CopyOnWriteArrayList();
  private int mID = sIdCounter.getAndIncrement();
  HippyEngine.ModuleListener mModuleListener;
  
  public static HippyEngine create(HippyEngine.EngineInitParams paramEngineInitParams)
  {
    if (paramEngineInitParams == null) {
      throw new RuntimeException("Hippy: initParams must no be null");
    }
    paramEngineInitParams.check();
    LogUtils.enableDebugLog(paramEngineInitParams.enableLog);
    if (paramEngineInitParams.appContext != null) {
      ContextHolder.initAppContext(paramEngineInitParams.appContext);
    }
    for (;;)
    {
      switch (HippyEngine.2.$SwitchMap$com$tencent$mtt$hippy$HippyEngine$EngineMode[paramEngineInitParams.engineMode.ordinal()])
      {
      default: 
        return null;
        if (paramEngineInitParams.context != null) {
          ContextHolder.initAppContext(paramEngineInitParams.context.getApplicationContext());
        }
        break;
      }
    }
    return new HippyNormalEngineManager(paramEngineInitParams, null);
    return new HippySingleThreadEngineManager(paramEngineInitParams, null);
  }
  
  private void listenInUIThread(HippyEngine.EngineListener paramEngineListener)
  {
    if (this.mCurrentState == HippyEngine.EngineState.INITED)
    {
      paramEngineListener.onInitialized(0, null);
      return;
    }
    if ((this.mCurrentState == HippyEngine.EngineState.INITERRORED) || (this.mCurrentState == HippyEngine.EngineState.DESTROYED))
    {
      paramEngineListener.onInitialized(-150, "engine state=" + this.mCurrentState);
      return;
    }
    this.mEventListeners.add(paramEngineListener);
  }
  
  public abstract void destroyEngine();
  
  public abstract void destroyModule(HippyRootView paramHippyRootView);
  
  public abstract HippyEngineContext getEngineContext();
  
  public HippyEngine.EngineState getEngineState()
  {
    return this.mCurrentState;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.HippyEngine
 * JD-Core Version:    0.7.0.1
 */