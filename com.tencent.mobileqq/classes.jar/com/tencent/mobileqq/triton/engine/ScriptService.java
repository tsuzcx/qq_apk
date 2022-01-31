package com.tencent.mobileqq.triton.engine;

import android.os.SystemClock;
import com.tencent.mobileqq.triton.jni.JNICaller.TTEngine;
import com.tencent.mobileqq.triton.render.RenderContext;
import com.tencent.mobileqq.triton.sdk.IQQEnv;
import com.tencent.mobileqq.triton.touch.TouchEventManager;
import com.tencent.mobileqq.triton.utils.FpsStabilizer;

public class ScriptService
  implements JSThread.IListener
{
  private static final boolean LOG_LOOPER_TIME_COST = false;
  private static final String TAG = "ScriptService";
  private static long mCurrentDrawCallCount = 0L;
  private final TTEngine mEngine;
  private long mEngineStartTime;
  private final FpsStabilizer mFpsStabilizer = new FpsStabilizer();
  private JSThread mJSThread;
  
  public ScriptService(TTEngine paramTTEngine)
  {
    this.mEngine = paramTTEngine;
    this.mJSThread = new JSThread(paramTTEngine, this);
    this.mJSThread.start();
  }
  
  public static long getCurrentDrawCallCount()
  {
    return mCurrentDrawCallCount;
  }
  
  private void onPrepareJsRuntime()
  {
    long l = SystemClock.uptimeMillis();
    this.mEngine.getQQEnv().reportDC04266(1005, null);
    this.mEngine.createTTApp();
    if ((this.mEngine.getJsRuntimeLoader() != null) && (this.mEngine.getJsRuntimeLoader().initJsRuntime())) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.mEngine.getQQEnv().reportDC04266(1006, null);
      }
      TTLog.i("ScriptService", "injectJS BaseLib cost time:" + (SystemClock.uptimeMillis() - l) + "ms");
      return;
    }
  }
  
  public void onDestroy()
  {
    if (this.mJSThread != null)
    {
      this.mJSThread.shutdown();
      this.mJSThread = null;
    }
  }
  
  public void onExit()
  {
    JNICaller.TTEngine.nativeDiposeTTApp(this.mEngine);
  }
  
  public void onPause()
  {
    TTLog.i("ScriptService", "============onPause==============");
    if (this.mJSThread != null)
    {
      this.mJSThread.onPause();
      this.mEngine.getQQEnv().reportDC04902("game_end", 0L);
    }
  }
  
  public boolean onPrepare()
  {
    onPrepareJsRuntime();
    this.mEngineStartTime = SystemClock.uptimeMillis();
    return false;
  }
  
  public void onResume()
  {
    TTLog.i("ScriptService", "============onResume==============");
    if (this.mJSThread != null) {
      this.mJSThread.onResume();
    }
  }
  
  void onTargetFpsChange(int paramInt)
  {
    if (paramInt >= this.mEngine.getDisplayRefreshRate())
    {
      this.mFpsStabilizer.setTargetFps(0.0F);
      return;
    }
    this.mFpsStabilizer.setTargetFps(paramInt);
  }
  
  public boolean onVSync()
  {
    long l1 = SystemClock.uptimeMillis();
    this.mEngine.getQQEnv().reportDC04902("game_start", 0L);
    if (this.mEngine.getRenderContext() != null) {}
    for (TouchEventManager localTouchEventManager = this.mEngine.getRenderContext().getTouchEventManager();; localTouchEventManager = null)
    {
      if (localTouchEventManager != null) {
        localTouchEventManager.flushTouchEvents();
      }
      long l2 = l1 - this.mEngineStartTime;
      if (this.mFpsStabilizer.shouldDoFrame(l2))
      {
        JNICaller.TTEngine.nativeOnVSync(this.mEngine, l2);
        JNICaller.TTEngine.nativeCanvasPresent(this.mEngine);
        mCurrentDrawCallCount = JNICaller.TTEngine.nativeGetCurrentFrameDrawCallCount(this.mEngine);
        l2 = SystemClock.uptimeMillis();
        this.mEngine.getQQEnv().reportDC04902("draw_frame", l2 - l1);
      }
      SystemClock.uptimeMillis();
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.triton.engine.ScriptService
 * JD-Core Version:    0.7.0.1
 */