package com.tencent.mobileqq.triton.engine;

import android.os.SystemClock;
import com.tencent.mobileqq.triton.internal.lifecycle.ValueHolder;
import com.tencent.mobileqq.triton.internal.render.VSyncScheduler;
import com.tencent.mobileqq.triton.internal.statistic.FrameCallbackHelper;
import com.tencent.mobileqq.triton.internal.touch.TouchProviderBridge;
import com.tencent.mobileqq.triton.internal.utils.Logger;
import com.tencent.mobileqq.triton.jni.JNICaller.TTEngine;
import com.tencent.mobileqq.triton.render.RenderContext;
import com.tencent.mobileqq.triton.statistic.FrameCallback;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/engine/ScriptService;", "Lcom/tencent/mobileqq/triton/engine/JSThread$IListener;", "mEngine", "Lcom/tencent/mobileqq/triton/engine/TTEngine;", "targetFPSHolder", "Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;", "", "frameCallback", "Lcom/tencent/mobileqq/triton/statistic/FrameCallback;", "accumulatedDrawCallsHolder", "", "currentDrawCallsHolder", "accumulatedFramesHolder", "debugEnabled", "", "(Lcom/tencent/mobileqq/triton/engine/TTEngine;Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;Z)V", "isJSThread", "()Z", "mDebugEnabled", "mDrawCallsSinceLastLiveLog", "", "mFrameCallback", "Lcom/tencent/mobileqq/triton/internal/statistic/FrameCallbackHelper;", "mJSThread", "Lcom/tencent/mobileqq/triton/engine/JSThread;", "mLastLiveLogProcessedMessages", "mLiveLogRunnable", "Ljava/lang/Runnable;", "mStartLatch", "Ljava/util/concurrent/CountDownLatch;", "mVSyncScheduler", "Lcom/tencent/mobileqq/triton/internal/render/VSyncScheduler;", "mVSyncsSinceLastLiveLog", "awaitStart", "", "onDestroy", "onExit", "onPause", "onPrepare", "onPrepareJsRuntime", "onResume", "onVSync", "drawTime", "printLiveLog", "Companion", "Triton_release"}, k=1, mv={1, 1, 16})
public final class ScriptService
  implements JSThread.IListener
{
  public static final ScriptService.Companion Companion = new ScriptService.Companion(null);
  private static final long LIVE_LOG_DURATION_MS = TimeUnit.SECONDS.toMillis(5L);
  private static final boolean LOG_LOOPER_TIME_COST = false;
  private static final String TAG = "ScriptService";
  private final ValueHolder<Long> accumulatedDrawCallsHolder;
  private final ValueHolder<Long> accumulatedFramesHolder;
  private final ValueHolder<Long> currentDrawCallsHolder;
  private final boolean mDebugEnabled;
  private int mDrawCallsSinceLastLiveLog;
  private final TTEngine mEngine;
  private final FrameCallbackHelper mFrameCallback;
  private final JSThread mJSThread;
  private int mLastLiveLogProcessedMessages;
  private final Runnable mLiveLogRunnable;
  private final CountDownLatch mStartLatch;
  private final VSyncScheduler mVSyncScheduler;
  private int mVSyncsSinceLastLiveLog;
  
  public ScriptService(@NotNull TTEngine paramTTEngine, @NotNull ValueHolder<Float> paramValueHolder, @NotNull ValueHolder<FrameCallback> paramValueHolder1, @NotNull ValueHolder<Long> paramValueHolder2, @NotNull ValueHolder<Long> paramValueHolder3, @NotNull ValueHolder<Long> paramValueHolder4, boolean paramBoolean)
  {
    this.mEngine = paramTTEngine;
    this.accumulatedDrawCallsHolder = paramValueHolder2;
    this.currentDrawCallsHolder = paramValueHolder3;
    this.accumulatedFramesHolder = paramValueHolder4;
    this.mStartLatch = new CountDownLatch(1);
    this.mFrameCallback = new FrameCallbackHelper(paramValueHolder1);
    this.mDebugEnabled = paramBoolean;
    this.mJSThread = new JSThread(this.mEngine, (JSThread.IListener)this);
    this.mJSThread.start();
    this.mVSyncScheduler = new VSyncScheduler((Function1)new ScriptService.1((ScriptService)this), paramValueHolder, (Executor)new ScriptService.2(this));
    this.mLiveLogRunnable = ((Runnable)new ScriptService.3(this));
    this.mLiveLogRunnable.run();
  }
  
  private final void onPrepareJsRuntime()
  {
    long l = SystemClock.uptimeMillis();
    this.mEngine.createTTApp();
    this.mStartLatch.countDown();
    this.mEngine.getJsRuntimeLoader().initJsRuntime();
    Logger.i$default("ScriptService", "injectJS BaseLib cost time:" + (SystemClock.uptimeMillis() - l) + "ms", null, 4, null);
  }
  
  private final void onVSync(long paramLong)
  {
    this.mFrameCallback.onFrameBegin(paramLong);
    SystemClock.uptimeMillis();
    Object localObject = this.accumulatedFramesHolder;
    ((ValueHolder)localObject).setValue(Long.valueOf(((Number)((ValueHolder)localObject).getValue()).longValue() + 1L));
    if (this.mEngine.getRenderContext() != null) {}
    for (localObject = this.mEngine.getRenderContext().getTouchEventManager();; localObject = null)
    {
      if (localObject != null) {
        ((TouchProviderBridge)localObject).flushTouchEvents();
      }
      JNICaller.TTEngine.nativeOnVSync(this.mEngine, paramLong);
      paramLong = JNICaller.TTEngine.nativeGetCurrentFrameDrawCallCount(this.mEngine);
      this.currentDrawCallsHolder.setValue(Long.valueOf(paramLong));
      localObject = this.accumulatedDrawCallsHolder;
      ((ValueHolder)localObject).setValue(Long.valueOf(((Number)((ValueHolder)localObject).getValue()).longValue() + paramLong));
      JNICaller.TTEngine.nativeCanvasPresent(this.mEngine);
      this.mFrameCallback.onFrameEnd();
      this.mVSyncsSinceLastLiveLog += 1;
      this.mDrawCallsSinceLastLiveLog += (int)paramLong;
      return;
    }
  }
  
  private final void printLiveLog()
  {
    try
    {
      i = this.mEngine.getProcessedMessageCount();
      Logger.i$default("ScriptService", "JSThread liveLog in 5s Frame=[" + this.mVSyncsSinceLastLiveLog + "] DrawCall=[" + this.mDrawCallsSinceLastLiveLog + "] Message=[" + (i - this.mLastLiveLogProcessedMessages) + ']', null, 4, null);
      this.mVSyncsSinceLastLiveLog = 0;
      this.mDrawCallsSinceLastLiveLog = 0;
      this.mLastLiveLogProcessedMessages = i;
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        int i = this.mEngine.getProcessedMessageCount();
      }
    }
  }
  
  public final void awaitStart()
  {
    long l = SystemClock.uptimeMillis();
    for (;;)
    {
      if (this.mStartLatch.getCount() != 0L) {}
      try
      {
        this.mStartLatch.await(1L, TimeUnit.SECONDS);
        label28:
        if (this.mStartLatch.getCount() == 0L) {
          continue;
        }
        Logger.w$default("ScriptService", "awaitStart cost too long!!! " + (SystemClock.uptimeMillis() - l) + "ms", null, 4, null);
        continue;
        Logger.i$default("ScriptService", "awaitStartCostTime:" + (SystemClock.uptimeMillis() - l) + "ms", null, 4, null);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        break label28;
      }
    }
  }
  
  public final boolean isJSThread()
  {
    return (this.mJSThread != null) && (this.mJSThread.isJSThread());
  }
  
  public final void onDestroy()
  {
    JSThread localJSThread = this.mJSThread;
    if (localJSThread == null) {
      Intrinsics.throwNpe();
    }
    localJSThread.shutdown();
    try
    {
      this.mJSThread.join();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      Logger.e("ScriptService", "onDestroy join jsThread failed ", (Throwable)localInterruptedException);
    }
  }
  
  public void onExit()
  {
    JNICaller.TTEngine.nativeDiposeTTApp(this.mEngine);
  }
  
  public final void onPause()
  {
    Logger.i$default("ScriptService", "============onPause==============", null, 4, null);
    this.mVSyncScheduler.stopScheduleVSync();
    JSThread localJSThread = this.mJSThread;
    if (localJSThread == null) {
      Intrinsics.throwNpe();
    }
    localJSThread.onPause();
  }
  
  public boolean onPrepare()
  {
    onPrepareJsRuntime();
    return false;
  }
  
  public final void onResume()
  {
    Logger.i$default("ScriptService", "============onResume==============", null, 4, null);
    JSThread localJSThread = this.mJSThread;
    if (localJSThread == null) {
      Intrinsics.throwNpe();
    }
    localJSThread.onResume();
    this.mVSyncScheduler.startScheduleVSync();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.engine.ScriptService
 * JD-Core Version:    0.7.0.1
 */