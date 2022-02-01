package com.tencent.mobileqq.cmshow.crossengine;

import android.content.Context;
import com.tencent.crossengine.CEApplication;
import com.tencent.crossengine.CEApplication.Builder;
import com.tencent.crossengine.CEJSEventListener;
import com.tencent.crossengine.CELifeCycle;
import com.tencent.crossengine.font.FontPixelsFactory;
import com.tencent.crossengine.log.LogDelegate;
import com.tencent.mobileqq.apollo.utils.CrossEngineResManager.LoadListener;
import com.tencent.mobileqq.cmshow.crossengine.util.CEFontPixelsFactory;
import com.tencent.mobileqq.cmshow.crossengine.util.CELogger;
import com.tencent.mobileqq.cmshow.engine.EngineContext;
import com.tencent.mobileqq.cmshow.engine.EngineState;
import com.tencent.mobileqq.cmshow.engine.ICMShowEngine;
import com.tencent.mobileqq.cmshow.engine.model.BusinessConfig;
import com.tencent.mobileqq.cmshow.engine.render.IRenderService;
import com.tencent.mobileqq.cmshow.engine.resource.IResourceService;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import com.tencent.mobileqq.cmshow.engine.script.IScriptService;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.locks.Lock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/crossengine/CECMShowEngine;", "Lcom/tencent/mobileqq/cmshow/engine/ICMShowEngine;", "context", "Landroid/content/Context;", "scene", "Lcom/tencent/mobileqq/cmshow/engine/scene/Scene;", "(Landroid/content/Context;Lcom/tencent/mobileqq/cmshow/engine/scene/Scene;)V", "TAG", "", "businessConfig", "Lcom/tencent/mobileqq/cmshow/engine/model/BusinessConfig;", "getBusinessConfig", "()Lcom/tencent/mobileqq/cmshow/engine/model/BusinessConfig;", "businessConfig$delegate", "Lkotlin/Lazy;", "ceApplication", "Lcom/tencent/crossengine/CEApplication;", "ceEngineContext", "Lcom/tencent/mobileqq/cmshow/crossengine/CEEngineContext;", "ceFontPixelsFactory", "Lcom/tencent/mobileqq/cmshow/crossengine/util/CEFontPixelsFactory;", "ceRenderService", "Lcom/tencent/mobileqq/cmshow/crossengine/CERenderService;", "ceResourceService", "Lcom/tencent/mobileqq/cmshow/crossengine/CEResourceService;", "ceScriptService", "Lcom/tencent/mobileqq/cmshow/crossengine/CEScriptService;", "renderService", "Lcom/tencent/mobileqq/cmshow/engine/render/IRenderService;", "getRenderService", "()Lcom/tencent/mobileqq/cmshow/engine/render/IRenderService;", "resourceService", "Lcom/tencent/mobileqq/cmshow/engine/resource/IResourceService;", "getResourceService", "()Lcom/tencent/mobileqq/cmshow/engine/resource/IResourceService;", "scriptService", "Lcom/tencent/mobileqq/cmshow/engine/script/IScriptService;", "getScriptService", "()Lcom/tencent/mobileqq/cmshow/engine/script/IScriptService;", "state", "Lcom/tencent/mobileqq/cmshow/engine/EngineState;", "getState", "()Lcom/tencent/mobileqq/cmshow/engine/EngineState;", "destroy", "", "handleBubbleTypeChange", "oldValue", "", "newValue", "initEngine", "start", "stop", "Companion", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CECMShowEngine
  implements ICMShowEngine
{
  public static final CECMShowEngine.Companion a;
  private final Context jdField_a_of_type_AndroidContentContext;
  private CEApplication jdField_a_of_type_ComTencentCrossengineCEApplication;
  private CEEngineContext jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEEngineContext;
  private CERenderService jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCERenderService;
  private CEResourceService jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEResourceService;
  private CEScriptService jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEScriptService;
  private CEFontPixelsFactory jdField_a_of_type_ComTencentMobileqqCmshowCrossengineUtilCEFontPixelsFactory;
  @NotNull
  private final IRenderService jdField_a_of_type_ComTencentMobileqqCmshowEngineRenderIRenderService;
  @NotNull
  private final IResourceService jdField_a_of_type_ComTencentMobileqqCmshowEngineResourceIResourceService;
  private final Scene jdField_a_of_type_ComTencentMobileqqCmshowEngineSceneScene;
  @NotNull
  private final IScriptService jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptIScriptService;
  private final String jdField_a_of_type_JavaLangString;
  @NotNull
  private final Lazy jdField_a_of_type_KotlinLazy;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCECMShowEngine$Companion = new CECMShowEngine.Companion(null);
  }
  
  public CECMShowEngine(@NotNull Context paramContext, @NotNull Scene paramScene)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqCmshowEngineSceneScene = paramScene;
    paramContext = new StringBuilder();
    paramContext.append("[cmshow][CECMShowEngine][");
    paramContext.append(this.jdField_a_of_type_ComTencentMobileqqCmshowEngineSceneScene);
    paramContext.append(']');
    this.jdField_a_of_type_JavaLangString = paramContext.toString();
    if (CEEngineHelper.a.a()) {
      d();
    } else {
      CEEngineHelper.a.a((CrossEngineResManager.LoadListener)new CECMShowEngine.1(this));
    }
    paramContext = this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCERenderService;
    if (paramContext == null) {
      Intrinsics.throwNpe();
    }
    this.jdField_a_of_type_ComTencentMobileqqCmshowEngineRenderIRenderService = ((IRenderService)paramContext);
    paramContext = this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEScriptService;
    if (paramContext == null) {
      Intrinsics.throwNpe();
    }
    this.jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptIScriptService = ((IScriptService)paramContext);
    paramContext = this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEResourceService;
    if (paramContext == null) {
      Intrinsics.throwNpe();
    }
    this.jdField_a_of_type_ComTencentMobileqqCmshowEngineResourceIResourceService = ((IResourceService)paramContext);
    this.jdField_a_of_type_KotlinLazy = LazyKt.lazy((Function0)new CECMShowEngine.businessConfig.2(this));
  }
  
  private final void a(int paramInt1, int paramInt2)
  {
    CEFontPixelsFactory localCEFontPixelsFactory = this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineUtilCEFontPixelsFactory;
    if (localCEFontPixelsFactory != null) {
      localCEFontPixelsFactory.a(paramInt2);
    }
  }
  
  private final void d()
  {
    Object localObject = (CELifeCycle)new CECMShowEngine.initEngine.ceLifeCycle.1(this);
    this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineUtilCEFontPixelsFactory = new CEFontPixelsFactory();
    this.jdField_a_of_type_ComTencentCrossengineCEApplication = CEApplication.Builder.createBuilder().withContext(this.jdField_a_of_type_AndroidContentContext).setAssetsPath(this.jdField_a_of_type_ComTencentMobileqqCmshowEngineSceneScene.assetsPath$cmshow_impl_release()).setLifeCycle((CELifeCycle)localObject).setStartUpWorld(this.jdField_a_of_type_ComTencentMobileqqCmshowEngineSceneScene.worldPath$cmshow_impl_release()).setLogger((LogDelegate)new CELogger()).setFontPixelsFactory((FontPixelsFactory)this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineUtilCEFontPixelsFactory).build();
    localObject = this.jdField_a_of_type_AndroidContentContext;
    CEApplication localCEApplication = this.jdField_a_of_type_ComTencentCrossengineCEApplication;
    if (localCEApplication == null) {
      Intrinsics.throwNpe();
    }
    this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEEngineContext = new CEEngineContext((Context)localObject, localCEApplication, this.jdField_a_of_type_ComTencentMobileqqCmshowEngineSceneScene);
    localObject = this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEEngineContext;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCERenderService = new CERenderService((CEEngineContext)localObject);
    localObject = this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEEngineContext;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEScriptService = new CEScriptService((CEEngineContext)localObject);
    localObject = this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEEngineContext;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEResourceService = new CEResourceService((EngineContext)localObject);
    localObject = this.jdField_a_of_type_ComTencentCrossengineCEApplication;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    ((CEApplication)localObject).setCEJSEventListener((CEJSEventListener)new CECMShowEngine.initEngine.1(this));
    localObject = this.jdField_a_of_type_ComTencentCrossengineCEApplication;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    ((CEApplication)localObject).startGame();
  }
  
  @NotNull
  public EngineState a()
  {
    CEEngineContext localCEEngineContext = this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEEngineContext;
    if (localCEEngineContext == null) {
      Intrinsics.throwNpe();
    }
    return localCEEngineContext.a();
  }
  
  @NotNull
  public BusinessConfig a()
  {
    return (BusinessConfig)this.jdField_a_of_type_KotlinLazy.getValue();
  }
  
  @NotNull
  public IRenderService a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqCmshowEngineRenderIRenderService;
  }
  
  @NotNull
  public IResourceService a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqCmshowEngineResourceIResourceService;
  }
  
  @NotNull
  public IScriptService a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptIScriptService;
  }
  
  public void a()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEEngineContext;
    if (localObject1 != null)
    {
      localObject1 = ((CEEngineContext)localObject1).a();
      if (localObject1 != null)
      {
        localObject1 = (Lock)localObject1;
        ((Lock)localObject1).lock();
        try
        {
          if ((a() == EngineState.INITIALIZED) || (a() == EngineState.STOPPED))
          {
            QLog.d(this.jdField_a_of_type_JavaLangString, 4, "start[resume]");
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEEngineContext;
            if (localObject2 != null) {
              ((CEEngineContext)localObject2).a(EngineState.STARTED);
            }
            localObject2 = this.jdField_a_of_type_ComTencentCrossengineCEApplication;
            if (localObject2 != null) {
              ((CEApplication)localObject2).resume();
            }
          }
          Object localObject2 = Unit.INSTANCE;
          return;
        }
        finally
        {
          ((Lock)localObject1).unlock();
        }
      }
    }
  }
  
  public void b()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEEngineContext;
    if (localObject1 != null)
    {
      localObject1 = ((CEEngineContext)localObject1).a();
      if (localObject1 != null)
      {
        localObject1 = (Lock)localObject1;
        ((Lock)localObject1).lock();
        try
        {
          if (a() == EngineState.STARTED)
          {
            QLog.d(this.jdField_a_of_type_JavaLangString, 4, "stop[pause]");
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEEngineContext;
            if (localObject2 != null) {
              ((CEEngineContext)localObject2).a(EngineState.STOPPED);
            }
            localObject2 = this.jdField_a_of_type_ComTencentCrossengineCEApplication;
            if (localObject2 != null) {
              ((CEApplication)localObject2).pause();
            }
          }
          Object localObject2 = Unit.INSTANCE;
          return;
        }
        finally
        {
          ((Lock)localObject1).unlock();
        }
      }
    }
  }
  
  public void c()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEEngineContext;
    if (localObject1 != null)
    {
      localObject1 = ((CEEngineContext)localObject1).a();
      if (localObject1 != null)
      {
        localObject1 = (Lock)localObject1;
        ((Lock)localObject1).lock();
        try
        {
          if (a() != EngineState.DESTROYED)
          {
            QLog.d(this.jdField_a_of_type_JavaLangString, 4, "destroy");
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEEngineContext;
            if (localObject2 != null) {
              ((CEEngineContext)localObject2).a(EngineState.DESTROYED);
            }
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCERenderService;
            if (localObject2 != null) {
              ((CERenderService)localObject2).g();
            }
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEScriptService;
            if (localObject2 != null) {
              ((CEScriptService)localObject2).b();
            }
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEResourceService;
            if (localObject2 != null) {
              ((CEResourceService)localObject2).a();
            }
            localObject2 = this.jdField_a_of_type_ComTencentCrossengineCEApplication;
            if (localObject2 != null) {
              ((CEApplication)localObject2).destroy();
            }
            localObject2 = this.jdField_a_of_type_ComTencentCrossengineCEApplication;
            if (localObject2 != null) {
              ((CEApplication)localObject2).exit();
            }
          }
          Object localObject2 = Unit.INSTANCE;
          return;
        }
        finally
        {
          ((Lock)localObject1).unlock();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.crossengine.CECMShowEngine
 * JD-Core Version:    0.7.0.1
 */