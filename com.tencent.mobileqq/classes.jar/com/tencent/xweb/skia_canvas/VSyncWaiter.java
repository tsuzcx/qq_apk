package com.tencent.xweb.skia_canvas;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import android.view.Choreographer;

public class VSyncWaiter
{
  private static final String TAG = "VSyncWaiter";
  private volatile Handler mWorkingHandler;
  
  public static VSyncWaiter getInstance()
  {
    return VSyncWaiter.Holder.INSTANCE;
  }
  
  private void initWorkingThread()
  {
    if (this.mWorkingHandler == null)
    {
      Log.d("VSyncWaiter", "current Thread do not have looper, create working thread instead.");
      HandlerThread localHandlerThread = new HandlerThread("SkiaCanvasVSyncWaiterThread", -2);
      localHandlerThread.start();
      this.mWorkingHandler = new Handler(localHandlerThread.getLooper());
    }
  }
  
  private void runVSyncCallback(VSyncWaiter.VSyncWaiterCallback paramVSyncWaiterCallback)
  {
    Choreographer.getInstance().postFrameCallback(new VSyncWaiter.2(this, paramVSyncWaiterCallback));
  }
  
  public void asyncWaitForVSync(VSyncWaiter.VSyncWaiterCallback paramVSyncWaiterCallback)
  {
    if (Looper.myLooper() != null)
    {
      runVSyncCallback(paramVSyncWaiterCallback);
      return;
    }
    initWorkingThread();
    this.mWorkingHandler.post(new VSyncWaiter.1(this, paramVSyncWaiterCallback));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.VSyncWaiter
 * JD-Core Version:    0.7.0.1
 */