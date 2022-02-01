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
    paramTTEngine = new StringBuilder();
    paramTTEngine.append("JSThread_");
    paramTTEngine.append(getId());
    setName(paramTTEngine.toString());
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("JSThread (tid:");
    ((StringBuilder)localObject).append(this.jsThreadId);
    ((StringBuilder)localObject).append(") run start");
    Logger.e("JSThread", ((StringBuilder)localObject).toString());
    localObject = this.mListener;
    if (localObject == null) {
      return;
    }
    ((JSThread.IListener)localObject).onPrepare();
    try
    {
      while (!this.mQuitThread)
      {
        JNICaller.RenderContext.nUpdateRenderContext(this.mTritonEngine.getRenderContext(), this.mTritonEngine.getNativeTTAppHandle());
        JNICaller.TTEngine.runLoop(this.mTritonEngine, true);
        JNICaller.TTEngine.runLoop(this.mTritonEngine, false);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("JSThread (tid: ");
        ((StringBuilder)localObject).append(this.jsThreadId);
        ((StringBuilder)localObject).append(") runLoop is interrupted loopQuit=");
        ((StringBuilder)localObject).append(this.mQuitThread);
        Logger.i("JSThread", ((StringBuilder)localObject).toString());
      }
      StringBuilder localStringBuilder2;
      StringBuilder localStringBuilder1;
      return;
    }
    catch (Exception localException)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("JSThread (tid:");
      localStringBuilder2.append(this.jsThreadId);
      localStringBuilder2.append(") run error ");
      localStringBuilder2.append(localException.getMessage());
      Logger.e("JSThread", localStringBuilder2.toString());
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("JSThread (tid:");
      localStringBuilder1.append(this.jsThreadId);
      localStringBuilder1.append(") run exit");
      Logger.e("JSThread", localStringBuilder1.toString());
      this.mListener.onExit();
    }
  }
  
  public void shutdown()
  {
    this.mQuitThread = true;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("JSThread (tid:");
    localStringBuilder.append(this.jsThreadId);
    localStringBuilder.append(") shutdown");
    Logger.e("JSThread", localStringBuilder.toString());
    JNICaller.TTEngine.interruptLoop(this.mTritonEngine);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.engine.JSThread
 * JD-Core Version:    0.7.0.1
 */