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
  }
  
  public int getBridgeType()
  {
    return 1;
  }
  
  public ThreadExecutor getThreadExecutor()
  {
    if (this.mThreadExecutor == null) {
      synchronized (this.mLock)
      {
        if (this.mThreadExecutor == null)
        {
          this.mThreadExecutor = new ThreadExecutor(-1);
          this.mThreadExecutor.setUncaughtExceptionHandler(this);
        }
      }
    }
    return this.mThreadExecutor;
  }
  
  public void handleThreadUncaughtException(Thread arg1, Throwable paramThrowable, Integer paramInteger)
  {
    super.handleThreadUncaughtException(???, paramThrowable, paramInteger);
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
  
  protected void onDestroy()
  {
    super.onDestroy();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.HippyNormalEngineManager
 * JD-Core Version:    0.7.0.1
 */