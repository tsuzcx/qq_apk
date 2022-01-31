package com.tencent.mobileqq.triton.engine;

import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import androidx.annotation.MainThread;
import com.tencent.mobileqq.triton.jni.JNICaller.RenderContext;
import com.tencent.mobileqq.triton.jni.JNICaller.TTEngine;
import java.util.concurrent.atomic.AtomicInteger;

public class JSThread
  extends Thread
{
  private static final int MAX_PENDING_VSYNC = 1;
  private static final String TAG = "JSThread";
  private static long sJSThreadId = -1L;
  private Runnable mCallbackMainLoop = new JSThread.1(this);
  private JSThread.IListener mListener;
  private final AtomicInteger mPendingVSyncCount = new AtomicInteger();
  private volatile boolean mQuitThread = false;
  private TTEngine mTritonEngine;
  private Choreographer.FrameCallback mVsyncCallback = new JSThread.2(this);
  
  public JSThread(TTEngine paramTTEngine, JSThread.IListener paramIListener)
  {
    this.mTritonEngine = paramTTEngine;
    this.mListener = paramIListener;
    setPriority(10);
    setName("JSThread_" + getId());
  }
  
  public static boolean isJSThread()
  {
    return sJSThreadId == Thread.currentThread().getId();
  }
  
  @MainThread
  private void startScheduleVSync()
  {
    Choreographer.getInstance().postFrameCallback(this.mVsyncCallback);
  }
  
  @MainThread
  private void stopScheduleVSync()
  {
    Choreographer.getInstance().removeFrameCallback(this.mVsyncCallback);
  }
  
  public void onPause()
  {
    stopScheduleVSync();
    if (this.mTritonEngine.getRenderContext() != null) {
      JNICaller.RenderContext.nOnPause(this.mTritonEngine.getRenderContext(), this.mTritonEngine.getNativeTTAppHandle());
    }
  }
  
  public void onResume()
  {
    startScheduleVSync();
    if (this.mTritonEngine.getRenderContext() != null) {
      JNICaller.RenderContext.nOnResume(this.mTritonEngine.getRenderContext(), this.mTritonEngine.getNativeTTAppHandle());
    }
  }
  
  public void run()
  {
    sJSThreadId = getId();
    if (this.mListener == null) {
      return;
    }
    this.mListener.onPrepare();
    try
    {
      boolean bool;
      do
      {
        JNICaller.RenderContext.nUpdateRenderContext(this.mTritonEngine.getRenderContext(), this.mTritonEngine.getNativeTTAppHandle());
        JNICaller.TTEngine.runLoop(this.mTritonEngine, true);
        bool = this.mQuitThread;
        JNICaller.TTEngine.runLoop(this.mTritonEngine, false);
      } while (!bool);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        TTLog.e("JSThread", "JSThread run error " + localException.getMessage());
      }
    }
    TTLog.e("JSThread", "JSThread run exit");
    this.mListener.onExit();
  }
  
  public void shutdown()
  {
    this.mQuitThread = true;
    JNICaller.TTEngine.interruptLoop(this.mTritonEngine);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.triton.engine.JSThread
 * JD-Core Version:    0.7.0.1
 */