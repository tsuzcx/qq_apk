package com.tencent.mobileqq.cmshow.crossengine;

import android.content.Context;
import com.tencent.crossengine.CEApplication;
import com.tencent.mobileqq.cmshow.crossengine.util.CEFontPixelsFactory;
import com.tencent.mobileqq.cmshow.engine.EngineState;
import com.tencent.mobileqq.cmshow.engine.ICMShowEngine;
import com.tencent.mobileqq.cmshow.engine.model.BusinessConfig;
import com.tencent.mobileqq.cmshow.engine.render.ICMShowView;
import com.tencent.mobileqq.cmshow.engine.render.IRenderService;
import com.tencent.mobileqq.cmshow.engine.resource.IResourceService;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import com.tencent.mobileqq.cmshow.engine.script.IScriptService;
import com.tencent.mobileqq.cmshow.engine.statistic.IStatisticService;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/crossengine/CECMShowOffscreenEngine;", "Lcom/tencent/mobileqq/cmshow/engine/ICMShowEngine;", "context", "Landroid/content/Context;", "scene", "Lcom/tencent/mobileqq/cmshow/engine/scene/Scene;", "(Landroid/content/Context;Lcom/tencent/mobileqq/cmshow/engine/scene/Scene;)V", "TAG", "", "businessConfig", "Lcom/tencent/mobileqq/cmshow/engine/model/BusinessConfig;", "getBusinessConfig", "()Lcom/tencent/mobileqq/cmshow/engine/model/BusinessConfig;", "businessConfig$delegate", "Lkotlin/Lazy;", "ceEngineContext", "Lcom/tencent/mobileqq/cmshow/crossengine/CEEngineContext;", "ceRenderService", "Lcom/tencent/mobileqq/cmshow/crossengine/CERenderService;", "ceResourceService", "Lcom/tencent/mobileqq/cmshow/crossengine/CEResourceService;", "ceScriptService", "Lcom/tencent/mobileqq/cmshow/crossengine/CEScriptService;", "ceStatisticService", "Lcom/tencent/mobileqq/cmshow/engine/statistic/IStatisticService;", "renderService", "Lcom/tencent/mobileqq/cmshow/engine/render/IRenderService;", "getRenderService", "()Lcom/tencent/mobileqq/cmshow/engine/render/IRenderService;", "resourceService", "Lcom/tencent/mobileqq/cmshow/engine/resource/IResourceService;", "getResourceService", "()Lcom/tencent/mobileqq/cmshow/engine/resource/IResourceService;", "scriptService", "Lcom/tencent/mobileqq/cmshow/engine/script/IScriptService;", "getScriptService", "()Lcom/tencent/mobileqq/cmshow/engine/script/IScriptService;", "state", "Lcom/tencent/mobileqq/cmshow/engine/EngineState;", "getState", "()Lcom/tencent/mobileqq/cmshow/engine/EngineState;", "statisticService", "getStatisticService", "()Lcom/tencent/mobileqq/cmshow/engine/statistic/IStatisticService;", "destroy", "", "handleBubbleTypeChange", "oldValue", "", "newValue", "initEngine", "ceApp", "Lcom/tencent/crossengine/CEApplication;", "start", "stop", "Companion", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CECMShowOffscreenEngine
  implements ICMShowEngine
{
  public static final CECMShowOffscreenEngine.Companion a = new CECMShowOffscreenEngine.Companion(null);
  private static final CEFontPixelsFactory o = new CEFontPixelsFactory();
  private static CEApplication p;
  @Nullable
  private static ICMShowView q;
  private static Map<String, CECMShowOffscreenEngine> r = (Map)new LinkedHashMap();
  private static List<CERenderService> s = (List)new ArrayList();
  private static final ReentrantLock t = new ReentrantLock();
  private static volatile boolean u;
  private final String b;
  private CEEngineContext c;
  private CERenderService d;
  private CEScriptService e;
  private CEResourceService f;
  private IStatisticService g;
  @NotNull
  private final IRenderService h;
  @NotNull
  private final IScriptService i;
  @NotNull
  private final IResourceService j;
  @NotNull
  private final IStatisticService k;
  @NotNull
  private final Lazy l;
  private final Context m;
  private final Scene n;
  
  public CECMShowOffscreenEngine(@NotNull Context paramContext, @NotNull Scene paramScene)
  {
    this.m = paramContext;
    this.n = paramScene;
    paramContext = new StringBuilder();
    paramContext.append("[cmshow][CECMShowOffscreenEngine][");
    paramContext.append(this.n);
    paramContext.append(']');
    this.b = paramContext.toString();
    paramContext = this.b;
    paramScene = new StringBuilder();
    paramScene.append("create new ");
    paramScene.append(this);
    paramScene.append(", tryInitCEApplication");
    QLog.i(paramContext, 1, paramScene.toString());
    a.a((Function2)new CECMShowOffscreenEngine.1(this));
    paramContext = this.d;
    if (paramContext == null) {
      Intrinsics.throwNpe();
    }
    this.h = ((IRenderService)paramContext);
    paramContext = this.e;
    if (paramContext == null) {
      Intrinsics.throwNpe();
    }
    this.i = ((IScriptService)paramContext);
    paramContext = this.f;
    if (paramContext == null) {
      Intrinsics.throwNpe();
    }
    this.j = ((IResourceService)paramContext);
    paramContext = this.g;
    if (paramContext == null) {
      Intrinsics.throwNpe();
    }
    this.k = paramContext;
    this.l = LazyKt.lazy((Function0)new CECMShowOffscreenEngine.businessConfig.2(this));
  }
  
  private final void a(int paramInt1, int paramInt2)
  {
    o.a(paramInt2);
  }
  
  /* Error */
  private final void b(CEApplication paramCEApplication)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 174	com/tencent/mobileqq/cmshow/crossengine/CECMShowOffscreenEngine:b	Ljava/lang/String;
    //   4: astore_2
    //   5: new 155	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   12: astore_3
    //   13: aload_3
    //   14: aload_0
    //   15: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   18: pop
    //   19: aload_3
    //   20: ldc_w 256
    //   23: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: aload_2
    //   28: iconst_1
    //   29: aload_3
    //   30: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokestatic 183	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   36: aload_0
    //   37: new 258	com/tencent/mobileqq/cmshow/crossengine/CEEngineContext
    //   40: dup
    //   41: aload_0
    //   42: getfield 151	com/tencent/mobileqq/cmshow/crossengine/CECMShowOffscreenEngine:m	Landroid/content/Context;
    //   45: aload_1
    //   46: aload_0
    //   47: getfield 153	com/tencent/mobileqq/cmshow/crossengine/CECMShowOffscreenEngine:n	Lcom/tencent/mobileqq/cmshow/engine/scene/Scene;
    //   50: invokespecial 261	com/tencent/mobileqq/cmshow/crossengine/CEEngineContext:<init>	(Landroid/content/Context;Lcom/tencent/crossengine/CEApplication;Lcom/tencent/mobileqq/cmshow/engine/scene/Scene;)V
    //   53: putfield 263	com/tencent/mobileqq/cmshow/crossengine/CECMShowOffscreenEngine:c	Lcom/tencent/mobileqq/cmshow/crossengine/CEEngineContext;
    //   56: aload_0
    //   57: getfield 263	com/tencent/mobileqq/cmshow/crossengine/CECMShowOffscreenEngine:c	Lcom/tencent/mobileqq/cmshow/crossengine/CEEngineContext;
    //   60: astore_1
    //   61: aload_1
    //   62: ifnonnull +6 -> 68
    //   65: invokestatic 198	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   68: aload_0
    //   69: new 265	com/tencent/mobileqq/cmshow/crossengine/CERenderService
    //   72: dup
    //   73: aload_1
    //   74: invokespecial 268	com/tencent/mobileqq/cmshow/crossengine/CERenderService:<init>	(Lcom/tencent/mobileqq/cmshow/crossengine/CEEngineContext;)V
    //   77: putfield 195	com/tencent/mobileqq/cmshow/crossengine/CECMShowOffscreenEngine:d	Lcom/tencent/mobileqq/cmshow/crossengine/CERenderService;
    //   80: getstatic 252	com/tencent/mobileqq/cmshow/crossengine/CECMShowOffscreenEngine:u	Z
    //   83: ifeq +22 -> 105
    //   86: aload_0
    //   87: getfield 195	com/tencent/mobileqq/cmshow/crossengine/CECMShowOffscreenEngine:d	Lcom/tencent/mobileqq/cmshow/crossengine/CERenderService;
    //   90: astore_1
    //   91: aload_1
    //   92: ifnonnull +6 -> 98
    //   95: invokestatic 198	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   98: aload_1
    //   99: invokevirtual 270	com/tencent/mobileqq/cmshow/crossengine/CERenderService:c	()V
    //   102: goto +46 -> 148
    //   105: getstatic 139	com/tencent/mobileqq/cmshow/crossengine/CECMShowOffscreenEngine:t	Ljava/util/concurrent/locks/ReentrantLock;
    //   108: checkcast 272	java/util/concurrent/locks/Lock
    //   111: astore_1
    //   112: aload_1
    //   113: invokeinterface 275 1 0
    //   118: getstatic 134	com/tencent/mobileqq/cmshow/crossengine/CECMShowOffscreenEngine:s	Ljava/util/List;
    //   121: astore_2
    //   122: aload_0
    //   123: getfield 195	com/tencent/mobileqq/cmshow/crossengine/CECMShowOffscreenEngine:d	Lcom/tencent/mobileqq/cmshow/crossengine/CERenderService;
    //   126: astore_3
    //   127: aload_3
    //   128: ifnonnull +6 -> 134
    //   131: invokestatic 198	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   134: aload_2
    //   135: aload_3
    //   136: invokeinterface 279 2 0
    //   141: pop
    //   142: aload_1
    //   143: invokeinterface 282 1 0
    //   148: aload_0
    //   149: getfield 263	com/tencent/mobileqq/cmshow/crossengine/CECMShowOffscreenEngine:c	Lcom/tencent/mobileqq/cmshow/crossengine/CEEngineContext;
    //   152: astore_1
    //   153: aload_1
    //   154: ifnonnull +6 -> 160
    //   157: invokestatic 198	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   160: aload_0
    //   161: new 284	com/tencent/mobileqq/cmshow/crossengine/CEScriptService
    //   164: dup
    //   165: aload_1
    //   166: invokespecial 285	com/tencent/mobileqq/cmshow/crossengine/CEScriptService:<init>	(Lcom/tencent/mobileqq/cmshow/crossengine/CEEngineContext;)V
    //   169: putfield 204	com/tencent/mobileqq/cmshow/crossengine/CECMShowOffscreenEngine:e	Lcom/tencent/mobileqq/cmshow/crossengine/CEScriptService;
    //   172: aload_0
    //   173: getfield 263	com/tencent/mobileqq/cmshow/crossengine/CECMShowOffscreenEngine:c	Lcom/tencent/mobileqq/cmshow/crossengine/CEEngineContext;
    //   176: astore_1
    //   177: aload_1
    //   178: ifnonnull +6 -> 184
    //   181: invokestatic 198	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   184: aload_0
    //   185: new 287	com/tencent/mobileqq/cmshow/crossengine/CEResourceService
    //   188: dup
    //   189: aload_1
    //   190: checkcast 289	com/tencent/mobileqq/cmshow/engine/EngineContext
    //   193: invokespecial 292	com/tencent/mobileqq/cmshow/crossengine/CEResourceService:<init>	(Lcom/tencent/mobileqq/cmshow/engine/EngineContext;)V
    //   196: putfield 210	com/tencent/mobileqq/cmshow/crossengine/CECMShowOffscreenEngine:f	Lcom/tencent/mobileqq/cmshow/crossengine/CEResourceService;
    //   199: aload_0
    //   200: getfield 263	com/tencent/mobileqq/cmshow/crossengine/CECMShowOffscreenEngine:c	Lcom/tencent/mobileqq/cmshow/crossengine/CEEngineContext;
    //   203: astore_1
    //   204: aload_1
    //   205: ifnonnull +6 -> 211
    //   208: invokestatic 198	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   211: aload_0
    //   212: new 294	com/tencent/mobileqq/cmshow/engine/statistic/StatisticService
    //   215: dup
    //   216: aload_1
    //   217: checkcast 289	com/tencent/mobileqq/cmshow/engine/EngineContext
    //   220: invokespecial 295	com/tencent/mobileqq/cmshow/engine/statistic/StatisticService:<init>	(Lcom/tencent/mobileqq/cmshow/engine/EngineContext;)V
    //   223: checkcast 297	com/tencent/mobileqq/cmshow/engine/statistic/IStatisticService
    //   226: putfield 216	com/tencent/mobileqq/cmshow/crossengine/CECMShowOffscreenEngine:g	Lcom/tencent/mobileqq/cmshow/engine/statistic/IStatisticService;
    //   229: getstatic 139	com/tencent/mobileqq/cmshow/crossengine/CECMShowOffscreenEngine:t	Ljava/util/concurrent/locks/ReentrantLock;
    //   232: checkcast 272	java/util/concurrent/locks/Lock
    //   235: astore_1
    //   236: aload_1
    //   237: invokeinterface 275 1 0
    //   242: getstatic 127	com/tencent/mobileqq/cmshow/crossengine/CECMShowOffscreenEngine:r	Ljava/util/Map;
    //   245: new 299	com/tencent/mobileqq/cmshow/crossengine/CECMShowOffscreenEngine$initEngine$2$1
    //   248: dup
    //   249: aload_0
    //   250: getfield 153	com/tencent/mobileqq/cmshow/crossengine/CECMShowOffscreenEngine:n	Lcom/tencent/mobileqq/cmshow/engine/scene/Scene;
    //   253: invokespecial 302	com/tencent/mobileqq/cmshow/crossengine/CECMShowOffscreenEngine$initEngine$2$1:<init>	(Lcom/tencent/mobileqq/cmshow/engine/scene/Scene;)V
    //   256: invokeinterface 308 1 0
    //   261: aload_0
    //   262: invokeinterface 312 3 0
    //   267: checkcast 2	com/tencent/mobileqq/cmshow/crossengine/CECMShowOffscreenEngine
    //   270: astore_2
    //   271: aload_1
    //   272: invokeinterface 282 1 0
    //   277: return
    //   278: astore_2
    //   279: aload_1
    //   280: invokeinterface 282 1 0
    //   285: aload_2
    //   286: athrow
    //   287: astore_2
    //   288: aload_1
    //   289: invokeinterface 282 1 0
    //   294: aload_2
    //   295: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	296	0	this	CECMShowOffscreenEngine
    //   0	296	1	paramCEApplication	CEApplication
    //   4	267	2	localObject1	Object
    //   278	8	2	localObject2	Object
    //   287	8	2	localObject3	Object
    //   12	124	3	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   242	271	278	finally
    //   118	127	287	finally
    //   131	134	287	finally
    //   134	142	287	finally
  }
  
  @NotNull
  public EngineState a()
  {
    CEEngineContext localCEEngineContext = this.c;
    if (localCEEngineContext == null) {
      Intrinsics.throwNpe();
    }
    return localCEEngineContext.e();
  }
  
  @NotNull
  public IRenderService c()
  {
    return this.h;
  }
  
  @NotNull
  public IScriptService e()
  {
    return this.i;
  }
  
  @NotNull
  public IResourceService g()
  {
    return this.j;
  }
  
  @NotNull
  public IStatisticService i()
  {
    return this.k;
  }
  
  @NotNull
  public BusinessConfig j()
  {
    return (BusinessConfig)this.l.getValue();
  }
  
  public void k()
  {
    Object localObject1 = this.c;
    if (localObject1 != null)
    {
      localObject1 = ((CEEngineContext)localObject1).d();
      if (localObject1 != null)
      {
        localObject1 = (Lock)localObject1;
        ((Lock)localObject1).lock();
        try
        {
          if ((a() == EngineState.INITIALIZED) || (a() == EngineState.STOPPED))
          {
            QLog.d(this.b, 4, "start[resume]");
            localObject2 = this.c;
            if (localObject2 != null) {
              ((CEEngineContext)localObject2).a(EngineState.STARTED);
            }
          }
          Object localObject2 = Unit.INSTANCE;
        }
        finally
        {
          ((Lock)localObject1).unlock();
        }
      }
    }
    localObject1 = this.d;
    if (localObject1 != null) {
      ((CERenderService)localObject1).g();
    }
  }
  
  public void l()
  {
    Object localObject1 = this.c;
    if (localObject1 != null)
    {
      localObject1 = ((CEEngineContext)localObject1).d();
      if (localObject1 != null)
      {
        localObject1 = (Lock)localObject1;
        ((Lock)localObject1).lock();
        try
        {
          if (a() == EngineState.STARTED)
          {
            QLog.d(this.b, 4, "stop[pause]");
            localObject2 = this.c;
            if (localObject2 != null) {
              ((CEEngineContext)localObject2).a(EngineState.STOPPED);
            }
          }
          Object localObject2 = Unit.INSTANCE;
        }
        finally
        {
          ((Lock)localObject1).unlock();
        }
      }
    }
    localObject1 = this.d;
    if (localObject1 != null) {
      ((CERenderService)localObject1).h();
    }
  }
  
  public void m()
  {
    Object localObject1 = this.c;
    if (localObject1 != null)
    {
      localObject1 = ((CEEngineContext)localObject1).d();
      if (localObject1 != null)
      {
        localObject1 = (Lock)localObject1;
        ((Lock)localObject1).lock();
        try
        {
          Object localObject2;
          if (a() != EngineState.DESTROYED)
          {
            QLog.d(this.b, 4, "destroy");
            localObject2 = this.c;
            if (localObject2 != null) {
              ((CEEngineContext)localObject2).a(EngineState.DESTROYED);
            }
            localObject2 = this.d;
            if (localObject2 != null) {
              ((CERenderService)localObject2).i();
            }
            localObject2 = this.e;
            if (localObject2 != null) {
              ((CEScriptService)localObject2).d();
            }
            localObject2 = this.f;
            if (localObject2 != null) {
              ((CEResourceService)localObject2).b();
            }
            localObject2 = this.c;
            if (localObject2 != null)
            {
              localObject2 = ((CEEngineContext)localObject2).c();
              if (localObject2 != null) {
                ((CEApplication)localObject2).destoryWorld((String)new CECMShowOffscreenEngine.destroy.1.1(this.n).get());
              }
            }
            localObject2 = (Lock)t;
            ((Lock)localObject2).lock();
          }
          try
          {
            CECMShowOffscreenEngine localCECMShowOffscreenEngine = (CECMShowOffscreenEngine)r.remove(new CECMShowOffscreenEngine.destroy.1.2.1(this.n).get());
          }
          finally {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.crossengine.CECMShowOffscreenEngine
 * JD-Core Version:    0.7.0.1
 */