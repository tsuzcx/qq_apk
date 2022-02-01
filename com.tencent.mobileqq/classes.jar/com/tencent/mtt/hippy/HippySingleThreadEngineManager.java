package com.tencent.mtt.hippy;

import com.tencent.mtt.hippy.bridge.bundleloader.HippyBundleLoader;
import com.tencent.mtt.hippy.common.ThreadExecutor;
import com.tencent.mtt.hippy.common.ThreadExecutorManager;
import com.tencent.mtt.hippy.utils.LogUtils;

public class HippySingleThreadEngineManager
  extends HippyEngineManagerImpl
{
  private boolean mIsDestroyed = false;
  private final Object mLock = new Object();
  private ThreadExecutor mThreadExecutor = null;
  
  HippySingleThreadEngineManager(HippyEngine.EngineInitParams paramEngineInitParams, HippyBundleLoader paramHippyBundleLoader)
  {
    super(paramEngineInitParams, paramHippyBundleLoader);
    ThreadExecutorManager.getInstance().add(this);
  }
  
  public int getBridgeType()
  {
    return 2;
  }
  
  public ThreadExecutor getThreadExecutor()
  {
    ??? = ThreadExecutorManager.getInstance().getThreadExecutor(this.mGroupId);
    if (??? == null) {
      synchronized (this.mLock)
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("SingleThreadEngineManager group threadExecutor == null, isDestroyed=");
        ((StringBuilder)localObject2).append(this.mIsDestroyed);
        LogUtils.e("Hippy", ((StringBuilder)localObject2).toString());
        if (this.mThreadExecutor == null)
        {
          this.mThreadExecutor = new ThreadExecutor(-1);
          this.mThreadExecutor.setUncaughtExceptionHandler(this);
        }
        localObject2 = this.mThreadExecutor;
        return localObject2;
      }
    }
    return ???;
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
  
  public void onDestroy()
  {
    super.onDestroy();
    ThreadExecutorManager.getInstance().remove(this);
    synchronized (this.mLock)
    {
      this.mIsDestroyed = true;
      if (this.mThreadExecutor != null)
      {
        this.mThreadExecutor.destroy();
        this.mThreadExecutor = null;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.HippySingleThreadEngineManager
 * JD-Core Version:    0.7.0.1
 */