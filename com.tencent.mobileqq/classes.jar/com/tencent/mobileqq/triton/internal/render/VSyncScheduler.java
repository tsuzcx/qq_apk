package com.tencent.mobileqq.triton.internal.render;

import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import androidx.annotation.MainThread;
import com.tencent.mobileqq.triton.internal.lifecycle.ValueHolder;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/internal/render/VSyncScheduler;", "", "vSyncListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "drawingTimeNanos", "", "targetFps", "Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;", "", "scheduleExecutor", "Ljava/util/concurrent/Executor;", "(Lkotlin/jvm/functions/Function1;Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;Ljava/util/concurrent/Executor;)V", "callbackMainLoop", "Ljava/lang/Runnable;", "fpsStabilizer", "Lcom/tencent/mobileqq/triton/internal/render/FpsStabilizer;", "lastFrameTimeNanos", "pendingVSyncCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "requestResetFrameDuration", "", "totalDrawTimeNanos", "vSyncCallback", "Landroid/view/Choreographer$FrameCallback;", "getDefaultFrameDuration", "startScheduleVSync", "stopScheduleVSync", "Companion", "Triton_release"}, k=1, mv={1, 1, 16})
public final class VSyncScheduler
{
  public static final VSyncScheduler.Companion Companion = new VSyncScheduler.Companion(null);
  private static final int MAX_PENDING_VSYNC = 1;
  private final Runnable callbackMainLoop;
  private final FpsStabilizer fpsStabilizer;
  private long lastFrameTimeNanos;
  private final AtomicInteger pendingVSyncCount;
  private volatile boolean requestResetFrameDuration;
  private final Executor scheduleExecutor;
  private final ValueHolder<Float> targetFps;
  private long totalDrawTimeNanos;
  private final Choreographer.FrameCallback vSyncCallback;
  private final Function1<Long, Unit> vSyncListener;
  
  public VSyncScheduler(@NotNull Function1<? super Long, Unit> paramFunction1, @NotNull ValueHolder<Float> paramValueHolder, @NotNull Executor paramExecutor)
  {
    this.vSyncListener = paramFunction1;
    this.targetFps = paramValueHolder;
    this.scheduleExecutor = paramExecutor;
    this.pendingVSyncCount = new AtomicInteger();
    this.fpsStabilizer = new FpsStabilizer();
    this.callbackMainLoop = ((Runnable)new VSyncScheduler.callbackMainLoop.1(this));
    this.vSyncCallback = ((Choreographer.FrameCallback)new VSyncScheduler.vSyncCallback.1(this));
    this.targetFps.observe((Function1)new VSyncScheduler.1(this));
  }
  
  private final long getDefaultFrameDuration()
  {
    float f = ((Number)this.targetFps.getValue()).floatValue();
    if (f > 0) {
      return ((float)TimeUnit.SECONDS.toNanos(1L) / f);
    }
    return TimeUnit.SECONDS.toNanos(1L) / 60;
  }
  
  @MainThread
  public final void startScheduleVSync()
  {
    Choreographer.getInstance().postFrameCallback(this.vSyncCallback);
  }
  
  @MainThread
  public final void stopScheduleVSync()
  {
    Choreographer.getInstance().removeFrameCallback(this.vSyncCallback);
    this.requestResetFrameDuration = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.render.VSyncScheduler
 * JD-Core Version:    0.7.0.1
 */