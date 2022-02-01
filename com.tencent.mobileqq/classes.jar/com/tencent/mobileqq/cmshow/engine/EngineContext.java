package com.tencent.mobileqq.cmshow.engine;

import android.content.Context;
import com.tencent.mobileqq.cmshow.engine.render.IRenderService;
import com.tencent.mobileqq.cmshow.engine.resource.IResourceService;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import com.tencent.mobileqq.cmshow.engine.script.IScriptService;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/engine/EngineContext;", "", "context", "Landroid/content/Context;", "scene", "Lcom/tencent/mobileqq/cmshow/engine/scene/Scene;", "(Landroid/content/Context;Lcom/tencent/mobileqq/cmshow/engine/scene/Scene;)V", "getContext", "()Landroid/content/Context;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "getLock", "()Ljava/util/concurrent/locks/ReentrantLock;", "renderService", "Lcom/tencent/mobileqq/cmshow/engine/render/IRenderService;", "getRenderService", "()Lcom/tencent/mobileqq/cmshow/engine/render/IRenderService;", "setRenderService", "(Lcom/tencent/mobileqq/cmshow/engine/render/IRenderService;)V", "resourceService", "Lcom/tencent/mobileqq/cmshow/engine/resource/IResourceService;", "getResourceService", "()Lcom/tencent/mobileqq/cmshow/engine/resource/IResourceService;", "setResourceService", "(Lcom/tencent/mobileqq/cmshow/engine/resource/IResourceService;)V", "getScene", "()Lcom/tencent/mobileqq/cmshow/engine/scene/Scene;", "scriptService", "Lcom/tencent/mobileqq/cmshow/engine/script/IScriptService;", "getScriptService", "()Lcom/tencent/mobileqq/cmshow/engine/script/IScriptService;", "setScriptService", "(Lcom/tencent/mobileqq/cmshow/engine/script/IScriptService;)V", "state", "Lcom/tencent/mobileqq/cmshow/engine/EngineState;", "getState", "()Lcom/tencent/mobileqq/cmshow/engine/EngineState;", "setState", "(Lcom/tencent/mobileqq/cmshow/engine/EngineState;)V", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public class EngineContext
{
  @NotNull
  private final Context jdField_a_of_type_AndroidContentContext;
  @NotNull
  private volatile EngineState jdField_a_of_type_ComTencentMobileqqCmshowEngineEngineState;
  @NotNull
  public IRenderService a;
  @NotNull
  public IResourceService a;
  @NotNull
  private final Scene jdField_a_of_type_ComTencentMobileqqCmshowEngineSceneScene;
  @NotNull
  public IScriptService a;
  @NotNull
  private final ReentrantLock jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock;
  
  public EngineContext(@NotNull Context paramContext, @NotNull Scene paramScene)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqCmshowEngineSceneScene = paramScene;
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock = new ReentrantLock();
    this.jdField_a_of_type_ComTencentMobileqqCmshowEngineEngineState = EngineState.INITIALIZING;
  }
  
  @NotNull
  public final Context a()
  {
    return this.jdField_a_of_type_AndroidContentContext;
  }
  
  @NotNull
  public final EngineState a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqCmshowEngineEngineState;
  }
  
  @NotNull
  public final IRenderService a()
  {
    IRenderService localIRenderService = this.jdField_a_of_type_ComTencentMobileqqCmshowEngineRenderIRenderService;
    if (localIRenderService == null) {
      Intrinsics.throwUninitializedPropertyAccessException("renderService");
    }
    return localIRenderService;
  }
  
  @NotNull
  public final Scene a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqCmshowEngineSceneScene;
  }
  
  @NotNull
  public final IScriptService a()
  {
    IScriptService localIScriptService = this.jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptIScriptService;
    if (localIScriptService == null) {
      Intrinsics.throwUninitializedPropertyAccessException("scriptService");
    }
    return localIScriptService;
  }
  
  @NotNull
  public final ReentrantLock a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock;
  }
  
  public final void a(@NotNull EngineState paramEngineState)
  {
    Intrinsics.checkParameterIsNotNull(paramEngineState, "<set-?>");
    this.jdField_a_of_type_ComTencentMobileqqCmshowEngineEngineState = paramEngineState;
  }
  
  public final void a(@NotNull IRenderService paramIRenderService)
  {
    Intrinsics.checkParameterIsNotNull(paramIRenderService, "<set-?>");
    this.jdField_a_of_type_ComTencentMobileqqCmshowEngineRenderIRenderService = paramIRenderService;
  }
  
  public final void a(@NotNull IResourceService paramIResourceService)
  {
    Intrinsics.checkParameterIsNotNull(paramIResourceService, "<set-?>");
    this.jdField_a_of_type_ComTencentMobileqqCmshowEngineResourceIResourceService = paramIResourceService;
  }
  
  public final void a(@NotNull IScriptService paramIScriptService)
  {
    Intrinsics.checkParameterIsNotNull(paramIScriptService, "<set-?>");
    this.jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptIScriptService = paramIScriptService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.EngineContext
 * JD-Core Version:    0.7.0.1
 */