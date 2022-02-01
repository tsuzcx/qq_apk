package com.tencent.mobileqq.cmshow.crossengine;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Landroid/os/Handler;", "invoke"}, k=3, mv={1, 1, 16})
final class CEEngineContext$asyncHandler$2
  extends Lambda
  implements Function0<Handler>
{
  CEEngineContext$asyncHandler$2(Scene paramScene)
  {
    super(0);
  }
  
  @NotNull
  public final Handler invoke()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[CE-AsyncHandler(");
    ((StringBuilder)localObject).append(this.$scene);
    ((StringBuilder)localObject).append(")]");
    localObject = new HandlerThread(((StringBuilder)localObject).toString());
    ((HandlerThread)localObject).start();
    return new Handler(((HandlerThread)localObject).getLooper());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.crossengine.CEEngineContext.asyncHandler.2
 * JD-Core Version:    0.7.0.1
 */