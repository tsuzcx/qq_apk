package com.tencent.view;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.ttpic.baseutils.log.LogUtils;

public final class FilterEngineFactory
{
  private static volatile FilterEngineFactory sIntance;
  private Handler handler;
  private FilterContext mFilterContext = null;
  private HandlerThread mGlThread;
  private String mThreadOwner;
  
  private FilterEngineFactory()
  {
    initGlThread();
  }
  
  public static void destroyInstance()
  {
    if (sIntance != null)
    {
      LogUtils.d("FilterEngine", "destroyInstance()");
      sIntance.destroy();
    }
  }
  
  public static FilterEngineFactory getInstance()
  {
    if (sIntance == null) {
      try
      {
        if (sIntance == null) {
          sIntance = new FilterEngineFactory();
        }
      }
      finally {}
    }
    return sIntance;
  }
  
  private void initGlThread()
  {
    FilterEngineFactory.2 local2 = new FilterEngineFactory.2(this);
    this.mGlThread = new HandlerThread("FILTER_ENGINE_FACTORY");
    this.mGlThread.start();
    this.handler = new Handler(this.mGlThread.getLooper());
    this.handler.post(local2);
  }
  
  public void destroy()
  {
    queue(new FilterEngineFactory.1(this));
  }
  
  public Looper getLooper()
  {
    HandlerThread localHandlerThread = this.mGlThread;
    if (localHandlerThread == null) {
      return null;
    }
    return localHandlerThread.getLooper();
  }
  
  public void queue(Runnable paramRunnable)
  {
    this.handler.post(paramRunnable);
  }
  
  public boolean usecurruntContext()
  {
    FilterContext localFilterContext = this.mFilterContext;
    if (localFilterContext != null) {
      return localFilterContext.usecurruntContext();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.view.FilterEngineFactory
 * JD-Core Version:    0.7.0.1
 */