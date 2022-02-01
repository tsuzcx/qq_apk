package com.tencent.mobileqq.triton.engine;

import com.tencent.mobileqq.triton.internal.utils.Logger;
import com.tencent.mobileqq.triton.jni.JNICaller.RenderContext;
import com.tencent.mobileqq.triton.jni.JNICaller.TTEngine;

public class JSThread
  extends Thread
{
  private static final String TAG = "JSThread";
  private long jsThreadId = -1L;
  private final JSThread.IListener mListener;
  private volatile boolean mQuitThread = false;
  private final TTEngine mTritonEngine;
  
  public JSThread(TTEngine paramTTEngine, JSThread.IListener paramIListener)
  {
    this.mTritonEngine = paramTTEngine;
    this.mListener = paramIListener;
    setPriority(10);
    setName("JSThread_" + getId());
  }
  
  public boolean isJSThread()
  {
    return this.jsThreadId == Thread.currentThread().getId();
  }
  
  public void onPause()
  {
    if (this.mTritonEngine.getRenderContext() != null) {
      JNICaller.RenderContext.nOnPause(this.mTritonEngine.getRenderContext(), this.mTritonEngine.getNativeTTAppHandle());
    }
  }
  
  public void onResume()
  {
    if (this.mTritonEngine.getRenderContext() != null) {
      JNICaller.RenderContext.nOnResume(this.mTritonEngine.getRenderContext(), this.mTritonEngine.getNativeTTAppHandle());
    }
  }
  
  public void run()
  {
    this.jsThreadId = getId();
    Logger.e("JSThread", "JSThread (tid:" + this.jsThreadId + ") run start");
    if (this.mListener == null) {
      return;
    }
    this.mListener.onPrepare();
    try
    {
      while (!this.mQuitThread)
      {
        JNICaller.RenderContext.nUpdateRenderContext(this.mTritonEngine.getRenderContext(), this.mTritonEngine.getNativeTTAppHandle());
        JNICaller.TTEngine.runLoop(this.mTritonEngine, true);
        JNICaller.TTEngine.runLoop(this.mTritonEngine, false);
        Logger.i("JSThread", "JSThread (tid: " + this.jsThreadId + ") runLoop is interrupted loopQuit=" + this.mQuitThread);
      }
      return;
    }
    catch (Exception localException)
    {
      Logger.e("JSThread", "JSThread (tid:" + this.jsThreadId + ") run error " + localException.getMessage());
      Logger.e("JSThread", "JSThread (tid:" + this.jsThreadId + ") run exit");
      this.mListener.onExit();
    }
  }
  
  public void shutdown()
  {
    this.mQuitThread = true;
    Logger.e("JSThread", "JSThread (tid:" + this.jsThreadId + ") shutdown");
    JNICaller.TTEngine.interruptLoop(this.mTritonEngine);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.engine.JSThread
 * JD-Core Version:    0.7.0.1
 */