package com.tencent.mobileqq.triton.engine;

import android.os.SystemClock;
import com.tencent.mobileqq.triton.jni.JNICaller.TTEngine;
import com.tencent.mobileqq.triton.render.RenderContext;
import com.tencent.mobileqq.triton.sdk.IQQEnv;
import com.tencent.mobileqq.triton.touch.TouchEventManager;
import com.tencent.mobileqq.triton.utils.FpsStabilizer;
import java.util.concurrent.TimeUnit;

public class ScriptService
  implements JSThread.IListener
{
  private static final long FRAME_MAX_DURATION_NANOS = TimeUnit.MILLISECONDS.toNanos(1500L);
  private static final long LIVE_LOG_DURATION = TimeUnit.SECONDS.toNanos(5L);
  private static final boolean LOG_LOOPER_TIME_COST = false;
  private static final String TAG = "ScriptService";
  private static long mCurrentDrawCallCount = 0L;
  private int mDrawCallsSinceLastLiveLog = 0;
  private final TTEngine mEngine;
  private final FpsStabilizer mFpsStabilizer = new FpsStabilizer();
  private JSThread mJSThread;
  private long mLastDrawTimeNanos;
  private int mLastLiveLogProcessedMessages = 0;
  private long mLastLiveLogTimeNanos;
  private long mTotalDrawTimeNanos;
  private int mVSyncsSinceLastLiveLog = 0;
  
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
  
  private void printLiveLog(long paramLong)
  {
    if (paramLong - this.mLastLiveLogTimeNanos > LIVE_LOG_DURATION)
    {
      int i = this.mEngine.getProcessedMessageCount();
      TTLog.i("ScriptService", "JSThread liveLog in 5s Frame=[" + this.mVSyncsSinceLastLiveLog + "] DrawCall=[" + this.mDrawCallsSinceLastLiveLog + "] Message=[" + (i - this.mLastLiveLogProcessedMessages) + "]");
      this.mVSyncsSinceLastLiveLog = 0;
      this.mDrawCallsSinceLastLiveLog = 0;
      this.mLastLiveLogTimeNanos = paramLong;
      this.mLastLiveLogProcessedMessages = i;
    }
  }
  
  public boolean isJSThread()
  {
    return (this.mJSThread != null) && (this.mJSThread.isJSThread());
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
    long l3 = System.nanoTime();
    long l2 = l3 - this.mLastDrawTimeNanos;
    long l1 = l2;
    if (l2 > FRAME_MAX_DURATION_NANOS) {
      l1 = TimeUnit.SECONDS.toNanos(1L) / this.mEngine.getTargetFPS();
    }
    this.mLastDrawTimeNanos = l3;
    this.mTotalDrawTimeNanos = (l1 + this.mTotalDrawTimeNanos);
    if (this.mFpsStabilizer.shouldDoFrame(this.mTotalDrawTimeNanos))
    {
      this.mEngine.getQQEnv().reportDC04902("game_start", 0L);
      if (this.mEngine.getRenderContext() == null) {
        break label205;
      }
    }
    label205:
    for (TouchEventManager localTouchEventManager = this.mEngine.getRenderContext().getTouchEventManager();; localTouchEventManager = null)
    {
      if (localTouchEventManager != null) {
        localTouchEventManager.flushTouchEvents();
      }
      JNICaller.TTEngine.nativeOnVSync(this.mEngine, this.mTotalDrawTimeNanos);
      JNICaller.TTEngine.nativeCanvasPresent(this.mEngine);
      mCurrentDrawCallCount = JNICaller.TTEngine.nativeGetCurrentFrameDrawCallCount(this.mEngine);
      l1 = (System.nanoTime() - l3) / 1000000L;
      this.mEngine.getQQEnv().reportDC04902("draw_frame", l1);
      this.mVSyncsSinceLastLiveLog += 1;
      this.mDrawCallsSinceLastLiveLog = ((int)(this.mDrawCallsSinceLastLiveLog + mCurrentDrawCallCount));
      printLiveLog(l3);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.triton.engine.ScriptService
 * JD-Core Version:    0.7.0.1
 */