package com.tencent.mobileqq.cmshow.brickengine;

import android.content.Context;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRenderInterfaceImpl;
import com.tencent.mobileqq.cmshow.engine.EngineContext;
import com.tencent.mobileqq.cmshow.engine.EngineState;
import com.tencent.mobileqq.cmshow.engine.ICMShowEngine;
import com.tencent.mobileqq.cmshow.engine.model.BusinessConfig;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import java.util.concurrent.locks.Lock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/brickengine/BKCMShowEngine;", "Lcom/tencent/mobileqq/cmshow/engine/ICMShowEngine;", "context", "Landroid/content/Context;", "scene", "Lcom/tencent/mobileqq/cmshow/engine/scene/Scene;", "(Landroid/content/Context;Lcom/tencent/mobileqq/cmshow/engine/scene/Scene;)V", "TAG", "", "businessConfig", "Lcom/tencent/mobileqq/cmshow/engine/model/BusinessConfig;", "getBusinessConfig", "()Lcom/tencent/mobileqq/cmshow/engine/model/BusinessConfig;", "businessConfig$delegate", "Lkotlin/Lazy;", "engineContext", "Lcom/tencent/mobileqq/cmshow/engine/EngineContext;", "renderService", "Lcom/tencent/mobileqq/cmshow/brickengine/BKRenderService;", "getRenderService", "()Lcom/tencent/mobileqq/cmshow/brickengine/BKRenderService;", "resourceService", "Lcom/tencent/mobileqq/cmshow/brickengine/BKResourceService;", "getResourceService", "()Lcom/tencent/mobileqq/cmshow/brickengine/BKResourceService;", "scriptService", "Lcom/tencent/mobileqq/cmshow/brickengine/BKScriptService;", "getScriptService", "()Lcom/tencent/mobileqq/cmshow/brickengine/BKScriptService;", "state", "Lcom/tencent/mobileqq/cmshow/engine/EngineState;", "getState", "()Lcom/tencent/mobileqq/cmshow/engine/EngineState;", "destroy", "", "start", "stop", "CONSTANT", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class BKCMShowEngine
  implements ICMShowEngine
{
  public static final BKCMShowEngine.CONSTANT a;
  private final Context jdField_a_of_type_AndroidContentContext;
  @NotNull
  private final BKRenderService jdField_a_of_type_ComTencentMobileqqCmshowBrickengineBKRenderService;
  @NotNull
  private final BKResourceService jdField_a_of_type_ComTencentMobileqqCmshowBrickengineBKResourceService;
  @NotNull
  private final BKScriptService jdField_a_of_type_ComTencentMobileqqCmshowBrickengineBKScriptService;
  private final EngineContext jdField_a_of_type_ComTencentMobileqqCmshowEngineEngineContext;
  private final String jdField_a_of_type_JavaLangString;
  @NotNull
  private final Lazy jdField_a_of_type_KotlinLazy;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqCmshowBrickengineBKCMShowEngine$CONSTANT = new BKCMShowEngine.CONSTANT(null);
  }
  
  public BKCMShowEngine(@NotNull Context paramContext, @NotNull Scene paramScene)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    paramContext = new StringBuilder();
    paramContext.append("[cmshow][BKCMShowEngine][");
    paramContext.append(paramScene);
    paramContext.append(']');
    this.jdField_a_of_type_JavaLangString = paramContext.toString();
    this.jdField_a_of_type_ComTencentMobileqqCmshowEngineEngineContext = new EngineContext(this.jdField_a_of_type_AndroidContentContext, paramScene);
    this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineBKRenderService = new BKRenderService(this.jdField_a_of_type_ComTencentMobileqqCmshowEngineEngineContext);
    this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineBKScriptService = new BKScriptService(this.jdField_a_of_type_ComTencentMobileqqCmshowEngineEngineContext);
    this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineBKResourceService = new BKResourceService(this.jdField_a_of_type_ComTencentMobileqqCmshowEngineEngineContext);
    this.jdField_a_of_type_KotlinLazy = LazyKt.lazy((Function0)new BKCMShowEngine.businessConfig.2(this));
  }
  
  @NotNull
  public BKRenderService a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineBKRenderService;
  }
  
  @NotNull
  public BKResourceService a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineBKResourceService;
  }
  
  @NotNull
  public BKScriptService a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineBKScriptService;
  }
  
  @NotNull
  public EngineState a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqCmshowEngineEngineContext.a();
  }
  
  @NotNull
  public BusinessConfig a()
  {
    return (BusinessConfig)this.jdField_a_of_type_KotlinLazy.getValue();
  }
  
  public void a()
  {
    Lock localLock = (Lock)this.jdField_a_of_type_ComTencentMobileqqCmshowEngineEngineContext.a();
    localLock.lock();
    try
    {
      if ((a() == EngineState.INITIALIZED) || (a() == EngineState.STOPPED))
      {
        localObject1 = a().a(a().a());
        if (localObject1 != null) {
          ((ApolloRenderInterfaceImpl)localObject1).b();
        }
        this.jdField_a_of_type_ComTencentMobileqqCmshowEngineEngineContext.a(EngineState.STARTED);
      }
      Object localObject1 = Unit.INSTANCE;
      return;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public void b()
  {
    Lock localLock = (Lock)this.jdField_a_of_type_ComTencentMobileqqCmshowEngineEngineContext.a();
    localLock.lock();
    try
    {
      if (a() == EngineState.STARTED)
      {
        localObject1 = a().a(a().a());
        if (localObject1 != null) {
          ((ApolloRenderInterfaceImpl)localObject1).a(0L);
        }
        this.jdField_a_of_type_ComTencentMobileqqCmshowEngineEngineContext.a(EngineState.STOPPED);
      }
      Object localObject1 = Unit.INSTANCE;
      return;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public void c()
  {
    Lock localLock = (Lock)this.jdField_a_of_type_ComTencentMobileqqCmshowEngineEngineContext.a();
    localLock.lock();
    try
    {
      if (a() != EngineState.DESTROYED)
      {
        a().a();
        a().a();
        a().a();
        this.jdField_a_of_type_ComTencentMobileqqCmshowEngineEngineContext.a(EngineState.DESTROYED);
      }
      Unit localUnit = Unit.INSTANCE;
      return;
    }
    finally
    {
      localLock.unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.BKCMShowEngine
 * JD-Core Version:    0.7.0.1
 */