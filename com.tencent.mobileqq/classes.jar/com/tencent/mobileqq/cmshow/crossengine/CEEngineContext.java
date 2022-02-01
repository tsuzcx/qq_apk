package com.tencent.mobileqq.cmshow.crossengine;

import android.content.Context;
import android.os.Handler;
import com.tencent.crossengine.CEApplication;
import com.tencent.mobileqq.cmshow.engine.EngineContext;
import com.tencent.mobileqq.cmshow.engine.EngineType;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/crossengine/CEEngineContext;", "Lcom/tencent/mobileqq/cmshow/engine/EngineContext;", "context", "Landroid/content/Context;", "ceApplication", "Lcom/tencent/crossengine/CEApplication;", "scene", "Lcom/tencent/mobileqq/cmshow/engine/scene/Scene;", "(Landroid/content/Context;Lcom/tencent/crossengine/CEApplication;Lcom/tencent/mobileqq/cmshow/engine/scene/Scene;)V", "asyncHandler", "Landroid/os/Handler;", "getAsyncHandler", "()Landroid/os/Handler;", "asyncHandler$delegate", "Lkotlin/Lazy;", "baseJSReady", "", "getBaseJSReady", "()Z", "setBaseJSReady", "(Z)V", "getCeApplication", "()Lcom/tencent/crossengine/CEApplication;", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CEEngineContext
  extends EngineContext
{
  private volatile boolean e;
  @NotNull
  private final Lazy f;
  @NotNull
  private final CEApplication g;
  
  public CEEngineContext(@NotNull Context paramContext, @NotNull CEApplication paramCEApplication, @NotNull Scene paramScene)
  {
    super(paramContext, paramScene, EngineType.CE);
    this.g = paramCEApplication;
    this.f = LazyKt.lazy((Function0)new CEEngineContext.asyncHandler.2(paramScene));
  }
  
  public final void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public final boolean a()
  {
    return this.e;
  }
  
  @NotNull
  public final Handler b()
  {
    return (Handler)this.f.getValue();
  }
  
  @NotNull
  public final CEApplication c()
  {
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.crossengine.CEEngineContext
 * JD-Core Version:    0.7.0.1
 */