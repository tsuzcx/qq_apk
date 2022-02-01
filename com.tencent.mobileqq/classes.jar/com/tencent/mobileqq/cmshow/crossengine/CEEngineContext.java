package com.tencent.mobileqq.cmshow.crossengine;

import android.content.Context;
import com.tencent.crossengine.CEApplication;
import com.tencent.mobileqq.cmshow.engine.EngineContext;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/crossengine/CEEngineContext;", "Lcom/tencent/mobileqq/cmshow/engine/EngineContext;", "context", "Landroid/content/Context;", "ceApplication", "Lcom/tencent/crossengine/CEApplication;", "scene", "Lcom/tencent/mobileqq/cmshow/engine/scene/Scene;", "(Landroid/content/Context;Lcom/tencent/crossengine/CEApplication;Lcom/tencent/mobileqq/cmshow/engine/scene/Scene;)V", "baseJSReady", "", "getBaseJSReady", "()Z", "setBaseJSReady", "(Z)V", "getCeApplication", "()Lcom/tencent/crossengine/CEApplication;", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CEEngineContext
  extends EngineContext
{
  @NotNull
  private final CEApplication jdField_a_of_type_ComTencentCrossengineCEApplication;
  private volatile boolean jdField_a_of_type_Boolean;
  
  public CEEngineContext(@NotNull Context paramContext, @NotNull CEApplication paramCEApplication, @NotNull Scene paramScene)
  {
    super(paramContext, paramScene);
    this.jdField_a_of_type_ComTencentCrossengineCEApplication = paramCEApplication;
  }
  
  @NotNull
  public final CEApplication a()
  {
    return this.jdField_a_of_type_ComTencentCrossengineCEApplication;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public final boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.crossengine.CEEngineContext
 * JD-Core Version:    0.7.0.1
 */