package com.tencent.mtt.hippy;

import com.tencent.mtt.hippy.bridge.bundleloader.HippyBundleLoader;
import com.tencent.mtt.hippy.common.ThreadExecutor;

public class HippySingleThreadEngineManager
  extends HippyEngineManagerImpl
{
  private static volatile int sEngineNum = 0;
  private static Object sLock = new Object();
  private static volatile ThreadExecutor sThreadExecutor = null;
  
  HippySingleThreadEngineManager(HippyEngine.EngineInitParams arg1, HippyBundleLoader paramHippyBundleLoader)
  {
    super(???, paramHippyBundleLoader);
    synchronized (sLock)
    {
      sEngineNum += 1;
      return;
    }
  }
  
  public void destroyEngine()
  {
    super.destroyEngine();
    synchronized (sLock)
    {
      sEngineNum -= 1;
      if ((sEngineNum == 0) && (sThreadExecutor != null))
      {
        sThreadExecutor.destroy();
        sThreadExecutor = null;
      }
      return;
    }
  }
  
  public int getBridgeType()
  {
    return 2;
  }
  
  public ThreadExecutor getThreadExecutor()
  {
    synchronized (sLock)
    {
      if (sThreadExecutor == null) {
        sThreadExecutor = new ThreadExecutor();
      }
      ThreadExecutor localThreadExecutor = sThreadExecutor;
      return localThreadExecutor;
    }
  }
  
  public void handleThreadUncaughtException(Thread arg1, Throwable paramThrowable)
  {
    super.handleThreadUncaughtException(???, paramThrowable);
    if ((this.mDebugMode) && (this.mDevSupportManager != null)) {
      synchronized (sLock)
      {
        if (sThreadExecutor != null)
        {
          sThreadExecutor.destroy();
          sThreadExecutor = null;
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.HippySingleThreadEngineManager
 * JD-Core Version:    0.7.0.1
 */