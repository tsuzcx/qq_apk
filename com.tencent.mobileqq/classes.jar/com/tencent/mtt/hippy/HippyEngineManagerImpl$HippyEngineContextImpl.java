package com.tencent.mtt.hippy;

import com.tencent.mtt.hippy.a.n;
import com.tencent.mtt.hippy.adapter.exception.HippyExceptionHandlerAdapter;
import com.tencent.mtt.hippy.bridge.a;
import com.tencent.mtt.hippy.bridge.b;
import com.tencent.mtt.hippy.common.HippyJsException;
import com.tencent.mtt.hippy.common.ThreadExecutor;
import com.tencent.mtt.hippy.dom.DomManager;
import com.tencent.mtt.hippy.modules.HippyModuleManager;
import com.tencent.mtt.hippy.modules.HippyModuleManagerImpl;
import com.tencent.mtt.hippy.uimanager.RenderManager;
import com.tencent.mtt.hippy.utils.TimeMonitor;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class HippyEngineManagerImpl$HippyEngineContextImpl
  implements HippyEngineContext
{
  private a mBridgeManager;
  private DomManager mDomManager;
  volatile CopyOnWriteArrayList<HippyEngineLifecycleEventListener> mEngineLifecycleEventListeners;
  volatile CopyOnWriteArrayList<HippyInstanceLifecycleEventListener> mInstanceLifecycleEventListeners;
  private HippyModuleManager mModuleManager;
  RenderManager mRenderManager;
  
  public HippyEngineManagerImpl$HippyEngineContextImpl(HippyEngineManagerImpl paramHippyEngineManagerImpl, boolean paramBoolean, String paramString)
  {
    this.mModuleManager = new HippyModuleManagerImpl(this, paramHippyEngineManagerImpl.mAPIProviders);
    this.mBridgeManager = new b(this, paramHippyEngineManagerImpl.mCoreBundleLoader, paramHippyEngineManagerImpl.getBridgeType(), paramHippyEngineManagerImpl.mEnableHippyBuffer, paramBoolean, paramString, HippyEngineManagerImpl.access$200(paramHippyEngineManagerImpl), HippyEngineManagerImpl.access$300(paramHippyEngineManagerImpl));
    this.mRenderManager = new RenderManager(this, paramHippyEngineManagerImpl.mAPIProviders);
    this.mDomManager = new DomManager(this);
  }
  
  public void addEngineLifecycleEventListener(HippyEngineLifecycleEventListener paramHippyEngineLifecycleEventListener)
  {
    if (this.mEngineLifecycleEventListeners == null) {}
    try
    {
      if (this.mEngineLifecycleEventListeners == null) {
        this.mEngineLifecycleEventListeners = new CopyOnWriteArrayList();
      }
      this.mEngineLifecycleEventListeners.add(paramHippyEngineLifecycleEventListener);
      return;
    }
    finally {}
  }
  
  public void addInstanceLifecycleEventListener(HippyInstanceLifecycleEventListener paramHippyInstanceLifecycleEventListener)
  {
    if (this.mInstanceLifecycleEventListeners == null) {}
    try
    {
      if (this.mInstanceLifecycleEventListeners == null) {
        this.mInstanceLifecycleEventListeners = new CopyOnWriteArrayList();
      }
      this.mInstanceLifecycleEventListeners.add(paramHippyInstanceLifecycleEventListener);
      return;
    }
    finally {}
  }
  
  public void destroy()
  {
    if (this.mBridgeManager != null) {
      this.mBridgeManager.a();
    }
    if (this.mModuleManager != null) {
      this.mModuleManager.destroy();
    }
    if (this.mDomManager != null) {
      this.mDomManager.b();
    }
    if (this.mRenderManager != null) {
      this.mRenderManager.a();
    }
    if (this.mInstanceLifecycleEventListeners != null) {
      this.mInstanceLifecycleEventListeners.clear();
    }
    if (this.mEngineLifecycleEventListeners != null) {
      this.mEngineLifecycleEventListeners.clear();
    }
  }
  
  public a getBridgeManager()
  {
    return this.mBridgeManager;
  }
  
  public n getDevSupportManager()
  {
    return this.this$0.mDevSupportManager;
  }
  
  public DomManager getDomManager()
  {
    return this.mDomManager;
  }
  
  public int getEngineId()
  {
    return this.this$0.getId();
  }
  
  public HippyGlobalConfigs getGlobalConfigs()
  {
    return this.this$0.mGlobalConfigs;
  }
  
  public HippyRootView getInstance(int paramInt)
  {
    Iterator localIterator = this.this$0.mInstances.iterator();
    while (localIterator.hasNext())
    {
      HippyRootView localHippyRootView = (HippyRootView)localIterator.next();
      if (localHippyRootView.getId() == paramInt) {
        return localHippyRootView;
      }
    }
    return null;
  }
  
  public HippyModuleManager getModuleManager()
  {
    return this.mModuleManager;
  }
  
  public RenderManager getRenderManager()
  {
    return this.mRenderManager;
  }
  
  public TimeMonitor getStartTimeMonitor()
  {
    return this.this$0.mStartTimeMonitor;
  }
  
  public ThreadExecutor getThreadExecutor()
  {
    return this.this$0.getThreadExecutor();
  }
  
  public void handleException(Throwable paramThrowable)
  {
    if ((this.this$0.mDebugMode) && (this.this$0.mDevSupportManager != null))
    {
      this.this$0.mDevSupportManager.a(paramThrowable);
      return;
    }
    if ((paramThrowable instanceof HippyJsException))
    {
      this.this$0.mGlobalConfigs.getExceptionHandler().handleJsException((HippyJsException)paramThrowable);
      this.this$0.mEngineContext.getBridgeManager().a((HippyJsException)paramThrowable);
      return;
    }
    this.this$0.mGlobalConfigs.getExceptionHandler().handleNativeException(new RuntimeException(paramThrowable), true);
  }
  
  public void removeEngineLifecycleEventListener(HippyEngineLifecycleEventListener paramHippyEngineLifecycleEventListener)
  {
    if (this.mEngineLifecycleEventListeners != null) {
      this.mEngineLifecycleEventListeners.remove(paramHippyEngineLifecycleEventListener);
    }
  }
  
  public void removeInstanceLifecycleEventListener(HippyInstanceLifecycleEventListener paramHippyInstanceLifecycleEventListener)
  {
    if (this.mInstanceLifecycleEventListeners != null) {
      this.mInstanceLifecycleEventListeners.remove(paramHippyInstanceLifecycleEventListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.HippyEngineManagerImpl.HippyEngineContextImpl
 * JD-Core Version:    0.7.0.1
 */