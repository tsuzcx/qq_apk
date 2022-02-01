package com.tencent.mobileqq.triton.internal.render.monitor;

import android.opengl.GLES30;
import com.tencent.mobileqq.triton.engine.ScreenShotCallback;
import com.tencent.mobileqq.triton.internal.lifecycle.ValueHolder;
import com.tencent.mobileqq.triton.internal.utils.Logger;
import com.tencent.mobileqq.triton.render.RenderContext.SwapListener;
import java.nio.Buffer;
import java.nio.IntBuffer;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/internal/render/monitor/ScreenShootMonitor;", "Lcom/tencent/mobileqq/triton/render/RenderContext$SwapListener;", "screenShotCallbackValueHolder", "Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;", "Lcom/tencent/mobileqq/triton/engine/ScreenShotCallback;", "canvasWidthHolder", "", "canvasHeightHolder", "mainThreadExecutor", "Ljava/util/concurrent/Executor;", "worker", "(Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;)V", "needTakeScreenShot", "", "pendingCallback", "Ljava/util/concurrent/CopyOnWriteArrayList;", "createScreenShot", "", "x", "y", "w", "h", "onGetScreenShot", "result", "Lkotlin/Result;", "Landroid/graphics/Bitmap;", "(Ljava/lang/Object;)V", "onSwap", "Companion", "Triton_release"}, k=1, mv={1, 1, 16})
public final class ScreenShootMonitor
  implements RenderContext.SwapListener
{
  public static final ScreenShootMonitor.Companion Companion = new ScreenShootMonitor.Companion(null);
  private static final String TAG = "ScreenShootMonitor";
  private final ValueHolder<Integer> canvasHeightHolder;
  private final ValueHolder<Integer> canvasWidthHolder;
  private final Executor mainThreadExecutor;
  private volatile boolean needTakeScreenShot;
  private final CopyOnWriteArrayList<ScreenShotCallback> pendingCallback;
  private final ValueHolder<ScreenShotCallback> screenShotCallbackValueHolder;
  private final Executor worker;
  
  public ScreenShootMonitor(@NotNull ValueHolder<ScreenShotCallback> paramValueHolder, @NotNull ValueHolder<Integer> paramValueHolder1, @NotNull ValueHolder<Integer> paramValueHolder2, @NotNull Executor paramExecutor1, @NotNull Executor paramExecutor2)
  {
    this.screenShotCallbackValueHolder = paramValueHolder;
    this.canvasWidthHolder = paramValueHolder1;
    this.canvasHeightHolder = paramValueHolder2;
    this.mainThreadExecutor = paramExecutor1;
    this.worker = paramExecutor2;
    this.pendingCallback = new CopyOnWriteArrayList();
    this.screenShotCallbackValueHolder.observe((Function1)new ScreenShootMonitor.1(this));
  }
  
  private final void createScreenShot(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt1 >= 0) && (paramInt2 >= 0) && (paramInt3 >= 0) && (paramInt4 >= 0) && (paramInt1 < paramInt3) && (paramInt2 < paramInt4)) {}
    try
    {
      localObject1 = new int[paramInt3 * paramInt4];
      localObject2 = IntBuffer.wrap((int[])localObject1);
      ((IntBuffer)localObject2).position(0);
      GLES30.glReadPixels(paramInt1, paramInt2, paramInt3, paramInt4, 6408, 5121, (Buffer)localObject2);
      this.worker.execute((Runnable)new ScreenShootMonitor.createScreenShot.1(this, paramInt3, paramInt4, (int[])localObject1));
      return;
    }
    catch (Exception localException)
    {
      Object localObject1;
      Throwable localThrowable = (Throwable)localException;
      Logger.e("ScreenShootMonitor", "createScreenShot exception ", localThrowable);
      Object localObject2 = Result.Companion;
      onGetScreenShot(Result.constructor-impl(ResultKt.createFailure(localThrowable)));
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("createScreenShot params error x=");
    ((StringBuilder)localObject1).append(paramInt1);
    ((StringBuilder)localObject1).append(" y=");
    ((StringBuilder)localObject1).append(paramInt2);
    ((StringBuilder)localObject1).append(" w=");
    ((StringBuilder)localObject1).append(paramInt3);
    ((StringBuilder)localObject1).append(" h=");
    ((StringBuilder)localObject1).append(paramInt4);
    Logger.e$default("ScreenShootMonitor", ((StringBuilder)localObject1).toString(), null, 4, null);
    return;
  }
  
  private final void onGetScreenShot(Object paramObject)
  {
    this.mainThreadExecutor.execute((Runnable)new ScreenShootMonitor.onGetScreenShot.1(this, paramObject));
  }
  
  public void onSwap()
  {
    if (this.needTakeScreenShot)
    {
      this.needTakeScreenShot = false;
      createScreenShot(0, 0, ((Number)this.canvasWidthHolder.getValue()).intValue(), ((Number)this.canvasHeightHolder.getValue()).intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.render.monitor.ScreenShootMonitor
 * JD-Core Version:    0.7.0.1
 */