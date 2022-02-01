package com.tencent.mobileqq.cmshow.brickengine;

import android.content.Context;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRenderInterfaceImpl;
import com.tencent.mobileqq.cmshow.engine.EngineContext;
import com.tencent.mobileqq.cmshow.engine.EngineState;
import com.tencent.mobileqq.cmshow.engine.EngineType;
import com.tencent.mobileqq.cmshow.engine.ICMShowEngine;
import com.tencent.mobileqq.cmshow.engine.model.BusinessConfig;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import com.tencent.mobileqq.cmshow.engine.statistic.StatisticService;
import java.util.concurrent.locks.Lock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/brickengine/BKCMShowEngine;", "Lcom/tencent/mobileqq/cmshow/engine/ICMShowEngine;", "context", "Landroid/content/Context;", "scene", "Lcom/tencent/mobileqq/cmshow/engine/scene/Scene;", "(Landroid/content/Context;Lcom/tencent/mobileqq/cmshow/engine/scene/Scene;)V", "TAG", "", "businessConfig", "Lcom/tencent/mobileqq/cmshow/engine/model/BusinessConfig;", "getBusinessConfig", "()Lcom/tencent/mobileqq/cmshow/engine/model/BusinessConfig;", "businessConfig$delegate", "Lkotlin/Lazy;", "engineContext", "Lcom/tencent/mobileqq/cmshow/engine/EngineContext;", "renderService", "Lcom/tencent/mobileqq/cmshow/brickengine/BKRenderService;", "getRenderService", "()Lcom/tencent/mobileqq/cmshow/brickengine/BKRenderService;", "resourceService", "Lcom/tencent/mobileqq/cmshow/brickengine/BKResourceService;", "getResourceService", "()Lcom/tencent/mobileqq/cmshow/brickengine/BKResourceService;", "scriptService", "Lcom/tencent/mobileqq/cmshow/brickengine/BKScriptService;", "getScriptService", "()Lcom/tencent/mobileqq/cmshow/brickengine/BKScriptService;", "state", "Lcom/tencent/mobileqq/cmshow/engine/EngineState;", "getState", "()Lcom/tencent/mobileqq/cmshow/engine/EngineState;", "statisticService", "Lcom/tencent/mobileqq/cmshow/engine/statistic/StatisticService;", "getStatisticService", "()Lcom/tencent/mobileqq/cmshow/engine/statistic/StatisticService;", "destroy", "", "start", "stop", "CONSTANT", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class BKCMShowEngine
  implements ICMShowEngine
{
  public static final BKCMShowEngine.CONSTANT a = new BKCMShowEngine.CONSTANT(null);
  private final String b;
  private final EngineContext c;
  @NotNull
  private final BKRenderService d;
  @NotNull
  private final BKScriptService e;
  @NotNull
  private final BKResourceService f;
  @NotNull
  private final StatisticService g;
  @NotNull
  private final Lazy h;
  private final Context i;
  
  public BKCMShowEngine(@NotNull Context paramContext, @NotNull Scene paramScene)
  {
    this.i = paramContext;
    paramContext = new StringBuilder();
    paramContext.append("[cmshow][BKCMShowEngine][");
    paramContext.append(paramScene);
    paramContext.append(']');
    this.b = paramContext.toString();
    this.c = new EngineContext(this.i, paramScene, EngineType.BK);
    this.d = new BKRenderService(this.c);
    this.e = new BKScriptService(this.c);
    this.f = new BKResourceService(this.c);
    this.g = new StatisticService(this.c);
    this.h = LazyKt.lazy((Function0)new BKCMShowEngine.businessConfig.2(this));
  }
  
  @NotNull
  public EngineState a()
  {
    return this.c.e();
  }
  
  @NotNull
  public BKRenderService b()
  {
    return this.d;
  }
  
  @NotNull
  public BKScriptService d()
  {
    return this.e;
  }
  
  @NotNull
  public BKResourceService f()
  {
    return this.f;
  }
  
  @NotNull
  public StatisticService h()
  {
    return this.g;
  }
  
  @NotNull
  public BusinessConfig j()
  {
    return (BusinessConfig)this.h.getValue();
  }
  
  public void k()
  {
    Lock localLock = (Lock)this.c.d();
    localLock.lock();
    try
    {
      if ((a() == EngineState.INITIALIZED) || (a() == EngineState.STOPPED))
      {
        localObject1 = b().a(b().a());
        if (localObject1 != null) {
          ((ApolloRenderInterfaceImpl)localObject1).b();
        }
        this.c.a(EngineState.STARTED);
      }
      Object localObject1 = Unit.INSTANCE;
      return;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public void l()
  {
    Lock localLock = (Lock)this.c.d();
    localLock.lock();
    try
    {
      if (a() == EngineState.STARTED)
      {
        localObject1 = b().a(b().a());
        if (localObject1 != null) {
          ((ApolloRenderInterfaceImpl)localObject1).a(0L);
        }
        this.c.a(EngineState.STOPPED);
      }
      Object localObject1 = Unit.INSTANCE;
      return;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public void m()
  {
    Lock localLock = (Lock)this.c.d();
    localLock.lock();
    try
    {
      if (a() != EngineState.DESTROYED)
      {
        b().c();
        d().c();
        f().b();
        this.c.a(EngineState.DESTROYED);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.BKCMShowEngine
 * JD-Core Version:    0.7.0.1
 */