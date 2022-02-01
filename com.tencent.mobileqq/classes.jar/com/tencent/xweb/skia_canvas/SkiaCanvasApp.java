package com.tencent.xweb.skia_canvas;

import androidx.annotation.NonNull;

public class SkiaCanvasApp
{
  private final long mNativePeer;
  private final IXWebWorkingHandler mWorkingHandler;
  
  static {}
  
  public SkiaCanvasApp(long paramLong1, long paramLong2, @NonNull IXWebWorkingHandler paramIXWebWorkingHandler)
  {
    this.mWorkingHandler = paramIXWebWorkingHandler;
    if (this.mWorkingHandler.isRunOnWorkingThread())
    {
      this.mNativePeer = init(paramLong1, paramLong2);
      VSyncRenderer.initRenderer(this.mWorkingHandler);
      return;
    }
    throw new IllegalStateException("SkiaCanvasApp must be created and used on working thread.");
  }
  
  private long init(long paramLong1, long paramLong2)
  {
    return nativeInit(paramLong1, paramLong2);
  }
  
  private native long nativeInit(long paramLong1, long paramLong2);
  
  private native void nativeOnJSContextDestroying(long paramLong);
  
  void checkAndPostOnWorkingThread(Runnable paramRunnable)
  {
    if (this.mWorkingHandler.isRunOnWorkingThread())
    {
      paramRunnable.run();
      return;
    }
    this.mWorkingHandler.post(paramRunnable);
  }
  
  boolean isRunOnWorkingThread()
  {
    return this.mWorkingHandler.isRunOnWorkingThread();
  }
  
  public void onJSContextDestroying()
  {
    if (this.mWorkingHandler.isRunOnWorkingThread())
    {
      nativeOnJSContextDestroying(this.mNativePeer);
      return;
    }
    throw new IllegalStateException("Thread during destroy is not matched with init.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.SkiaCanvasApp
 * JD-Core Version:    0.7.0.1
 */