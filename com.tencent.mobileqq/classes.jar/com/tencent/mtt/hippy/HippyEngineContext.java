package com.tencent.mtt.hippy;

import com.tencent.mtt.hippy.a.n;
import com.tencent.mtt.hippy.bridge.a;
import com.tencent.mtt.hippy.common.ThreadExecutor;
import com.tencent.mtt.hippy.dom.DomManager;
import com.tencent.mtt.hippy.modules.HippyModuleManager;
import com.tencent.mtt.hippy.uimanager.RenderManager;
import com.tencent.mtt.hippy.utils.TimeMonitor;

public abstract interface HippyEngineContext
{
  public abstract void addEngineLifecycleEventListener(HippyEngineLifecycleEventListener paramHippyEngineLifecycleEventListener);
  
  public abstract void addInstanceLifecycleEventListener(HippyInstanceLifecycleEventListener paramHippyInstanceLifecycleEventListener);
  
  public abstract a getBridgeManager();
  
  public abstract n getDevSupportManager();
  
  public abstract DomManager getDomManager();
  
  public abstract int getEngineId();
  
  public abstract HippyGlobalConfigs getGlobalConfigs();
  
  public abstract HippyRootView getInstance(int paramInt);
  
  public abstract HippyModuleManager getModuleManager();
  
  public abstract RenderManager getRenderManager();
  
  public abstract TimeMonitor getStartTimeMonitor();
  
  public abstract ThreadExecutor getThreadExecutor();
  
  public abstract void handleException(Throwable paramThrowable);
  
  public abstract void removeEngineLifecycleEventListener(HippyEngineLifecycleEventListener paramHippyEngineLifecycleEventListener);
  
  public abstract void removeInstanceLifecycleEventListener(HippyInstanceLifecycleEventListener paramHippyInstanceLifecycleEventListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.HippyEngineContext
 * JD-Core Version:    0.7.0.1
 */