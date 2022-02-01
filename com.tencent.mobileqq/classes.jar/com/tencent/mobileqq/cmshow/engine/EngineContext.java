package com.tencent.mobileqq.cmshow.engine;

import android.content.Context;
import com.tencent.mobileqq.cmshow.engine.render.IRenderService;
import com.tencent.mobileqq.cmshow.engine.resource.IResourceService;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import com.tencent.mobileqq.cmshow.engine.script.IScriptService;
import com.tencent.mobileqq.cmshow.engine.statistic.IStatisticService;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/engine/EngineContext;", "", "context", "Landroid/content/Context;", "scene", "Lcom/tencent/mobileqq/cmshow/engine/scene/Scene;", "engineType", "Lcom/tencent/mobileqq/cmshow/engine/EngineType;", "(Landroid/content/Context;Lcom/tencent/mobileqq/cmshow/engine/scene/Scene;Lcom/tencent/mobileqq/cmshow/engine/EngineType;)V", "getContext", "()Landroid/content/Context;", "getEngineType", "()Lcom/tencent/mobileqq/cmshow/engine/EngineType;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "getLock", "()Ljava/util/concurrent/locks/ReentrantLock;", "renderService", "Lcom/tencent/mobileqq/cmshow/engine/render/IRenderService;", "getRenderService", "()Lcom/tencent/mobileqq/cmshow/engine/render/IRenderService;", "setRenderService", "(Lcom/tencent/mobileqq/cmshow/engine/render/IRenderService;)V", "resourceService", "Lcom/tencent/mobileqq/cmshow/engine/resource/IResourceService;", "getResourceService", "()Lcom/tencent/mobileqq/cmshow/engine/resource/IResourceService;", "setResourceService", "(Lcom/tencent/mobileqq/cmshow/engine/resource/IResourceService;)V", "getScene", "()Lcom/tencent/mobileqq/cmshow/engine/scene/Scene;", "scriptService", "Lcom/tencent/mobileqq/cmshow/engine/script/IScriptService;", "getScriptService", "()Lcom/tencent/mobileqq/cmshow/engine/script/IScriptService;", "setScriptService", "(Lcom/tencent/mobileqq/cmshow/engine/script/IScriptService;)V", "state", "Lcom/tencent/mobileqq/cmshow/engine/EngineState;", "getState", "()Lcom/tencent/mobileqq/cmshow/engine/EngineState;", "setState", "(Lcom/tencent/mobileqq/cmshow/engine/EngineState;)V", "statisticService", "Lcom/tencent/mobileqq/cmshow/engine/statistic/IStatisticService;", "getStatisticService", "()Lcom/tencent/mobileqq/cmshow/engine/statistic/IStatisticService;", "setStatisticService", "(Lcom/tencent/mobileqq/cmshow/engine/statistic/IStatisticService;)V", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public class EngineContext
{
  @NotNull
  public IRenderService a;
  @NotNull
  public IScriptService b;
  @NotNull
  public IResourceService c;
  @NotNull
  public IStatisticService d;
  @NotNull
  private final ReentrantLock e;
  @NotNull
  private volatile EngineState f;
  @NotNull
  private final Context g;
  @NotNull
  private final Scene h;
  @NotNull
  private final EngineType i;
  
  public EngineContext(@NotNull Context paramContext, @NotNull Scene paramScene, @NotNull EngineType paramEngineType)
  {
    this.g = paramContext;
    this.h = paramScene;
    this.i = paramEngineType;
    this.e = new ReentrantLock();
    this.f = EngineState.INITIALIZING;
  }
  
  public final void a(@NotNull EngineState paramEngineState)
  {
    Intrinsics.checkParameterIsNotNull(paramEngineState, "<set-?>");
    this.f = paramEngineState;
  }
  
  public final void a(@NotNull IRenderService paramIRenderService)
  {
    Intrinsics.checkParameterIsNotNull(paramIRenderService, "<set-?>");
    this.a = paramIRenderService;
  }
  
  public final void a(@NotNull IResourceService paramIResourceService)
  {
    Intrinsics.checkParameterIsNotNull(paramIResourceService, "<set-?>");
    this.c = paramIResourceService;
  }
  
  public final void a(@NotNull IScriptService paramIScriptService)
  {
    Intrinsics.checkParameterIsNotNull(paramIScriptService, "<set-?>");
    this.b = paramIScriptService;
  }
  
  public final void a(@NotNull IStatisticService paramIStatisticService)
  {
    Intrinsics.checkParameterIsNotNull(paramIStatisticService, "<set-?>");
    this.d = paramIStatisticService;
  }
  
  @NotNull
  public final ReentrantLock d()
  {
    return this.e;
  }
  
  @NotNull
  public final EngineState e()
  {
    return this.f;
  }
  
  @NotNull
  public final IRenderService f()
  {
    IRenderService localIRenderService = this.a;
    if (localIRenderService == null) {
      Intrinsics.throwUninitializedPropertyAccessException("renderService");
    }
    return localIRenderService;
  }
  
  @NotNull
  public final IScriptService g()
  {
    IScriptService localIScriptService = this.b;
    if (localIScriptService == null) {
      Intrinsics.throwUninitializedPropertyAccessException("scriptService");
    }
    return localIScriptService;
  }
  
  @NotNull
  public final IResourceService h()
  {
    IResourceService localIResourceService = this.c;
    if (localIResourceService == null) {
      Intrinsics.throwUninitializedPropertyAccessException("resourceService");
    }
    return localIResourceService;
  }
  
  @NotNull
  public final IStatisticService i()
  {
    IStatisticService localIStatisticService = this.d;
    if (localIStatisticService == null) {
      Intrinsics.throwUninitializedPropertyAccessException("statisticService");
    }
    return localIStatisticService;
  }
  
  @NotNull
  public final Context j()
  {
    return this.g;
  }
  
  @NotNull
  public final Scene k()
  {
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.EngineContext
 * JD-Core Version:    0.7.0.1
 */