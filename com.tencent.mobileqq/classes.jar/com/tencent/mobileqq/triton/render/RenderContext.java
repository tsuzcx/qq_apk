package com.tencent.mobileqq.triton.render;

import android.content.Context;
import android.view.Surface;
import androidx.annotation.AnyThread;
import com.tencent.mobileqq.triton.annotation.JNIModule;
import com.tencent.mobileqq.triton.engine.ScreenShotCallback;
import com.tencent.mobileqq.triton.internal.lifecycle.LifeCycleOwner;
import com.tencent.mobileqq.triton.internal.lifecycle.ValueHolder;
import com.tencent.mobileqq.triton.internal.lifecycle.ValueHolder.Companion;
import com.tencent.mobileqq.triton.internal.render.monitor.BlackScreenMonitor;
import com.tencent.mobileqq.triton.internal.render.monitor.FPSMonitor;
import com.tencent.mobileqq.triton.internal.render.monitor.FirstScreenMonitor;
import com.tencent.mobileqq.triton.internal.render.monitor.ScreenShootMonitor;
import com.tencent.mobileqq.triton.internal.touch.TouchProviderBridge;
import com.tencent.mobileqq.triton.internal.utils.Logger;
import com.tencent.mobileqq.triton.jni.JNICaller.RenderContext;
import com.tencent.mobileqq.triton.lifecycle.LifeCycle;
import com.tencent.mobileqq.triton.utils.TritonKeep;
import com.tencent.mobileqq.triton.view.GameView;
import com.tencent.mobileqq.triton.view.GameView.SurfaceCallback;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JNIModule
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/render/RenderContext;", "", "onInitEnd", "Lkotlin/Function0;", "", "lifeCycleOwner", "Lcom/tencent/mobileqq/triton/internal/lifecycle/LifeCycleOwner;", "nativeTTAppHandle", "", "currentFPSHolder", "Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;", "", "lastBlackTimeHolder", "firstFameCallbackHolder", "", "accumulatedDrawCallHolder", "screenShotCallbackValueHolder", "Lcom/tencent/mobileqq/triton/engine/ScreenShotCallback;", "context", "Landroid/content/Context;", "worker", "Ljava/util/concurrent/Executor;", "mainThreadExecutor", "touchProviderBridge", "Lcom/tencent/mobileqq/triton/internal/touch/TouchProviderBridge;", "enableOpenglEs3", "(Lkotlin/jvm/functions/Function0;Lcom/tencent/mobileqq/triton/internal/lifecycle/LifeCycleOwner;JLcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;Landroid/content/Context;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;Lcom/tencent/mobileqq/triton/internal/touch/TouchProviderBridge;Z)V", "canvasHeightHolder", "", "canvasWidthHolder", "displayDensity", "supportES3", "swapListeners", "", "Lcom/tencent/mobileqq/triton/render/RenderContext$SwapListener;", "touchEventManager", "getTouchEventManager", "()Lcom/tencent/mobileqq/triton/internal/touch/TouchProviderBridge;", "attachGameView", "gameView", "Lcom/tencent/mobileqq/triton/view/GameView;", "attachSurface", "destroyRenderContext", "initRenderContext", "surface", "Landroid/view/Surface;", "nExit", "nInitRenderContext", "width", "height", "scale", "nOnPause", "nOnResume", "nSurfaceChanged", "nSurfaceDestroyed", "nUpdateRenderContext", "onDestroy", "onRenderContextInit", "onSwapBuffer", "setFixedSize", "surfaceChanged", "Companion", "SwapListener", "Triton_release"}, k=1, mv={1, 1, 16})
@TritonKeep
public final class RenderContext
{
  public static final RenderContext.Companion Companion = new RenderContext.Companion(null);
  private static final String TAG = "RenderContext";
  private final ValueHolder<Integer> canvasHeightHolder;
  private final ValueHolder<Integer> canvasWidthHolder;
  private float displayDensity;
  private final LifeCycleOwner lifeCycleOwner;
  private final long nativeTTAppHandle;
  private final Function0<Unit> onInitEnd;
  private final boolean supportES3;
  private final List<RenderContext.SwapListener> swapListeners;
  @NotNull
  private final TouchProviderBridge touchEventManager;
  
  public RenderContext(@NotNull Function0<Unit> paramFunction0, @NotNull LifeCycleOwner paramLifeCycleOwner, long paramLong, @NotNull ValueHolder<Float> paramValueHolder, @NotNull ValueHolder<Long> paramValueHolder1, @NotNull ValueHolder<Boolean> paramValueHolder2, @NotNull ValueHolder<Long> paramValueHolder3, @NotNull ValueHolder<ScreenShotCallback> paramValueHolder4, @NotNull Context paramContext, @NotNull Executor paramExecutor1, @NotNull Executor paramExecutor2, @NotNull TouchProviderBridge paramTouchProviderBridge, boolean paramBoolean)
  {
    this.onInitEnd = paramFunction0;
    this.lifeCycleOwner = paramLifeCycleOwner;
    this.nativeTTAppHandle = paramLong;
    paramFunction0 = Integer.valueOf(0);
    if ((paramBoolean) && (RenderContext.Companion.access$checkOpenGLES30(Companion, paramContext))) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    this.supportES3 = paramBoolean;
    this.canvasWidthHolder = ValueHolder.Companion.just(paramFunction0);
    this.canvasHeightHolder = ValueHolder.Companion.just(paramFunction0);
    this.touchEventManager = paramTouchProviderBridge;
    paramFunction0 = new StringBuilder();
    paramFunction0.append("initialize:");
    paramFunction0.append(this);
    Logger.e$default("RenderContext", paramFunction0.toString(), null, 4, null);
    this.swapListeners = ((List)new CopyOnWriteArrayList((Collection)CollectionsKt.listOf(new RenderContext.SwapListener[] { (RenderContext.SwapListener)new FPSMonitor(paramValueHolder), (RenderContext.SwapListener)new BlackScreenMonitor(paramValueHolder1, this.canvasWidthHolder, this.canvasHeightHolder, paramExecutor1), (RenderContext.SwapListener)new FirstScreenMonitor(paramValueHolder2, paramValueHolder3), (RenderContext.SwapListener)new ScreenShootMonitor(paramValueHolder4, this.canvasWidthHolder, this.canvasHeightHolder, paramExecutor2, paramExecutor1) })));
  }
  
  private final void attachSurface(GameView paramGameView)
  {
    paramGameView.setSurfaceCallback((GameView.SurfaceCallback)new RenderContext.attachSurface.1(this, paramGameView));
    this.swapListeners.add(new RenderContext.attachSurface.2(paramGameView));
  }
  
  @TritonKeep
  private final void onRenderContextInit()
  {
    this.onInitEnd.invoke();
  }
  
  @TritonKeep
  private final void onSwapBuffer()
  {
    Iterator localIterator = this.swapListeners.iterator();
    while (localIterator.hasNext()) {
      ((RenderContext.SwapListener)localIterator.next()).onSwap();
    }
  }
  
  @AnyThread
  public final void attachGameView(@NotNull GameView paramGameView)
  {
    Intrinsics.checkParameterIsNotNull(paramGameView, "gameView");
    this.displayDensity = paramGameView.getDisplayDensity();
    this.touchEventManager.attachView(paramGameView, this.displayDensity);
    attachSurface(paramGameView);
    this.lifeCycleOwner.observeLifeCycle((LifeCycle)new RenderContext.attachGameView.1(paramGameView));
  }
  
  public final void destroyRenderContext()
  {
    JNICaller.RenderContext.nSurfaceDestroyed(this, this.nativeTTAppHandle);
  }
  
  @NotNull
  public final TouchProviderBridge getTouchEventManager()
  {
    return this.touchEventManager;
  }
  
  public final void initRenderContext(@NotNull GameView paramGameView, @NotNull Surface paramSurface)
  {
    Intrinsics.checkParameterIsNotNull(paramGameView, "gameView");
    Intrinsics.checkParameterIsNotNull(paramSurface, "surface");
    long l = this.nativeTTAppHandle;
    boolean bool = this.supportES3;
    int i = (int)(paramGameView.getWidth() / this.displayDensity);
    float f1 = paramGameView.getHeight();
    float f2 = this.displayDensity;
    JNICaller.RenderContext.nInitRenderContext(this, l, paramSurface, bool, i, (int)(f1 / f2), f2);
  }
  
  public final native void nExit(long paramLong);
  
  public final native void nInitRenderContext(long paramLong, @Nullable Surface paramSurface, boolean paramBoolean, int paramInt1, int paramInt2, float paramFloat);
  
  public final native void nOnPause(long paramLong);
  
  public final native void nOnResume(long paramLong);
  
  public final native void nSurfaceChanged(long paramLong, @Nullable Surface paramSurface);
  
  public final native void nSurfaceDestroyed(long paramLong);
  
  public final native void nUpdateRenderContext(long paramLong);
  
  public final void onDestroy()
  {
    JNICaller.RenderContext.nExit(this, this.nativeTTAppHandle);
    this.swapListeners.clear();
  }
  
  @TritonKeep
  public final void setFixedSize(int paramInt1, int paramInt2)
  {
    this.canvasWidthHolder.setValue(Integer.valueOf(paramInt1));
    this.canvasHeightHolder.setValue(Integer.valueOf(paramInt2));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setFixedSize mCanvasWidth=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", mCanvasHeight=");
    localStringBuilder.append(paramInt2);
    Logger.i$default("RenderContext", localStringBuilder.toString(), null, 4, null);
  }
  
  public final void surfaceChanged(@Nullable Surface paramSurface)
  {
    JNICaller.RenderContext.nSurfaceChanged(this, this.nativeTTAppHandle, paramSurface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.triton.render.RenderContext
 * JD-Core Version:    0.7.0.1
 */