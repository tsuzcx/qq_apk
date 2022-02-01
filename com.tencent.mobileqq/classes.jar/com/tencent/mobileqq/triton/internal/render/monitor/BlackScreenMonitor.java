package com.tencent.mobileqq.triton.internal.render.monitor;

import android.opengl.GLES30;
import com.tencent.mobileqq.triton.internal.lifecycle.ValueHolder;
import com.tencent.mobileqq.triton.internal.utils.Logger;
import com.tencent.mobileqq.triton.render.RenderContext.SwapListener;
import java.nio.Buffer;
import java.nio.IntBuffer;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/internal/render/monitor/BlackScreenMonitor;", "Lcom/tencent/mobileqq/triton/render/RenderContext$SwapListener;", "lastBlackTimeHolder", "Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;", "", "canvasWidthHolder", "", "canvasHeightHolder", "mWorker", "Ljava/util/concurrent/Executor;", "(Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;Ljava/util/concurrent/Executor;)V", "lastCheckBlackTime", "checkBlackScreen", "", "onSwap", "Companion", "Triton_release"}, k=1, mv={1, 1, 16})
public final class BlackScreenMonitor
  implements RenderContext.SwapListener
{
  private static final long CHECK_BLACK_INTERVAL = 2000L;
  public static final BlackScreenMonitor.Companion Companion = new BlackScreenMonitor.Companion(null);
  private static final String TAG = "BlackScreenMonitor";
  private final ValueHolder<Integer> canvasHeightHolder;
  private final ValueHolder<Integer> canvasWidthHolder;
  private final ValueHolder<Long> lastBlackTimeHolder;
  private long lastCheckBlackTime;
  private final Executor mWorker;
  
  public BlackScreenMonitor(@NotNull ValueHolder<Long> paramValueHolder, @NotNull ValueHolder<Integer> paramValueHolder1, @NotNull ValueHolder<Integer> paramValueHolder2, @NotNull Executor paramExecutor)
  {
    this.lastBlackTimeHolder = paramValueHolder;
    this.canvasWidthHolder = paramValueHolder1;
    this.canvasHeightHolder = paramValueHolder2;
    this.mWorker = paramExecutor;
  }
  
  private final void checkBlackScreen()
  {
    long l = System.currentTimeMillis();
    if (l - this.lastCheckBlackTime >= 2000L)
    {
      this.lastCheckBlackTime = l;
      int i = ((Number)this.canvasWidthHolder.getValue()).intValue() / 2 - 64;
      int j = ((Number)this.canvasHeightHolder.getValue()).intValue() / 2 - 64;
      if ((i >= 0) && (j >= 0)) {}
      try
      {
        localObject = new int[16384];
        IntBuffer localIntBuffer = IntBuffer.wrap((int[])localObject);
        localIntBuffer.position(0);
        GLES30.glReadPixels(i, j, 128, 128, 6408, 5121, (Buffer)localIntBuffer);
        this.mWorker.execute((Runnable)new BlackScreenMonitor.checkBlackScreen.1(this, (int[])localObject, l));
        return;
      }
      catch (Exception localException)
      {
        Object localObject;
        Logger.e("BlackScreenMonitor", "checkBlackScreen exception ", (Throwable)localException);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkBlackScreen params error x=");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" y=");
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append(" w=");
      ((StringBuilder)localObject).append(128);
      ((StringBuilder)localObject).append(" h=");
      ((StringBuilder)localObject).append(128);
      Logger.e$default("BlackScreenMonitor", ((StringBuilder)localObject).toString(), null, 4, null);
      return;
    }
  }
  
  public void onSwap()
  {
    checkBlackScreen();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.render.monitor.BlackScreenMonitor
 * JD-Core Version:    0.7.0.1
 */