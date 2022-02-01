package com.tencent.mtt.hippy;

import com.tencent.mtt.hippy.a.n;
import com.tencent.mtt.hippy.adapter.exception.HippyExceptionHandlerAdapter;
import com.tencent.mtt.hippy.bridge.a;
import com.tencent.mtt.hippy.bridge.b;
import com.tencent.mtt.hippy.common.Callback;
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
    this.mBridgeManager = new b(this, paramHippyEngineManagerImpl.mCoreBundleLoader, paramHippyEngineManagerImpl.getBridgeType(), paramHippyEngineManagerImpl.mEnableHippyBuffer, paramBoolean, paramString, paramHippyEngineManagerImpl.mGroupId, HippyEngineManagerImpl.access$200(paramHippyEngineManagerImpl));
    this.mRenderManager = new RenderManager(this, paramHippyEngineManagerImpl.mAPIProviders);
    this.mDomManager = new DomManager(this);
  }
  
  public void addEngineLifecycleEventListener(HippyEngineLifecycleEventListener paramHippyEngineLifecycleEventListener)
  {
    if (this.mEngineLifecycleEventListeners == null) {
      try
      {
        if (this.mEngineLifecycleEventListeners == null) {
          this.mEngineLifecycleEventListeners = new CopyOnWriteArrayList();
        }
      }
      finally {}
    }
    this.mEngineLifecycleEventListeners.add(paramHippyEngineLifecycleEventListener);
  }
  
  public void addInstanceLifecycleEventListener(HippyInstanceLifecycleEventListener paramHippyInstanceLifecycleEventListener)
  {
    if (this.mInstanceLifecycleEventListeners == null) {
      try
      {
        if (this.mInstanceLifecycleEventListeners == null) {
          this.mInstanceLifecycleEventListeners = new CopyOnWriteArrayList();
        }
      }
      finally {}
    }
    this.mInstanceLifecycleEventListeners.add(paramHippyInstanceLifecycleEventListener);
  }
  
  public void destroy()
  {
    Object localObject = this.mBridgeManager;
    if (localObject != null) {
      ((a)localObject).a();
    }
    localObject = this.mModuleManager;
    if (localObject != null) {
      ((HippyModuleManager)localObject).destroy();
    }
    localObject = this.mDomManager;
    if (localObject != null) {
      ((DomManager)localObject).b();
    }
    localObject = this.mRenderManager;
    if (localObject != null) {
      ((RenderManager)localObject).a();
    }
    if (this.mInstanceLifecycleEventListeners != null) {
      this.mInstanceLifecycleEventListeners.clear();
    }
    if (this.mEngineLifecycleEventListeners != null) {
      this.mEngineLifecycleEventListeners.clear();
    }
  }
  
  public void destroyBridge(Callback<Boolean> paramCallback)
  {
    this.mBridgeManager.b(paramCallback);
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
      HippyExceptionHandlerAdapter localHippyExceptionHandlerAdapter = this.this$0.mGlobalConfigs.getExceptionHandler();
      paramThrowable = (HippyJsException)paramThrowable;
      localHippyExceptionHandlerAdapter.handleJsException(paramThrowable);
      this.this$0.mEngineContext.getBridgeManager().a(paramThrowable);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.HippyEngineManagerImpl.HippyEngineContextImpl
 * JD-Core Version:    0.7.0.1
 */