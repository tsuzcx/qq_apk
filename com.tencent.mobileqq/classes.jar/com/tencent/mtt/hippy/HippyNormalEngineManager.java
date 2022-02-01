package com.tencent.mtt.hippy;

import com.tencent.mtt.hippy.bridge.bundleloader.HippyBundleLoader;
import com.tencent.mtt.hippy.common.ThreadExecutor;

public final class HippyNormalEngineManager
  extends HippyEngineManagerImpl
{
  private Object mLock = new Object();
  private volatile ThreadExecutor mThreadExecutor;
  
  HippyNormalEngineManager(HippyEngine.EngineInitParams paramEngineInitParams, HippyBundleLoader paramHippyBundleLoader)
  {
    super(paramEngineInitParams, paramHippyBundleLoader);
  }
  
  public void destroyEngine()
  {
    super.destroyEngine();
    synchronized (this.mLock)
    {
      if (this.mThreadExecutor != null)
      {
        this.mThreadExecutor.destroy();
        this.mThreadExecutor = null;
      }
      return;
    }
  }
  
  public int getBridgeType()
  {
    return 1;
  }
  
  public ThreadExecutor getThreadExecutor()
  {
    if (this.mThreadExecutor == null) {}
    synchronized (this.mLock)
    {
      if (this.mThreadExecutor == null)
      {
        this.mThreadExecutor = new ThreadExecutor();
        this.mThreadExecutor.setUncaughtExceptionHandler(this);
      }
      return this.mThreadExecutor;
    }
  }
  
  public void handleThreadUncaughtException(Thread arg1, Throwable paramThrowable)
  {
    super.handleThreadUncaughtException(???, paramThrowable);
    if ((this.mDebugMode) && (this.mDevSupportManager != null)) {
      synchronized (this.mLock)
      {
        if (this.mThreadExecutor != null)
        {
          this.mThreadExecutor.destroy();
          this.mThreadExecutor = null;
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.HippyNormalEngineManager
 * JD-Core Version:    0.7.0.1
 */