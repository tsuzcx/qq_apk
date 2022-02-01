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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/crossengine/CECMShowOffscreenEngine;", "Lcom/tencent/mobileqq/cmshow/engine/ICMShowEngine;", "context", "Landroid/content/Context;", "scene", "Lcom/tencent/mobileqq/cmshow/engine/scene/Scene;", "(Landroid/content/Context;Lcom/tencent/mobileqq/cmshow/engine/scene/Scene;)V", "TAG", "", "businessConfig", "Lcom/tencent/mobileqq/cmshow/engine/model/BusinessConfig;", "getBusinessConfig", "()Lcom/tencent/mobileqq/cmshow/engine/model/BusinessConfig;", "businessConfig$delegate", "Lkotlin/Lazy;", "ceEngineContext", "Lcom/tencent/mobileqq/cmshow/crossengine/CEEngineContext;", "ceRenderService", "Lcom/tencent/mobileqq/cmshow/crossengine/CERenderService;", "ceResourceService", "Lcom/tencent/mobileqq/cmshow/crossengine/CEResourceService;", "ceScriptService", "Lcom/tencent/mobileqq/cmshow/crossengine/CEScriptService;", "renderService", "Lcom/tencent/mobileqq/cmshow/engine/render/IRenderService;", "getRenderService", "()Lcom/tencent/mobileqq/cmshow/engine/render/IRenderService;", "resourceService", "Lcom/tencent/mobileqq/cmshow/engine/resource/IResourceService;", "getResourceService", "()Lcom/tencent/mobileqq/cmshow/engine/resource/IResourceService;", "scriptService", "Lcom/tencent/mobileqq/cmshow/engine/script/IScriptService;", "getScriptService", "()Lcom/tencent/mobileqq/cmshow/engine/script/IScriptService;", "state", "Lcom/tencent/mobileqq/cmshow/engine/EngineState;", "getState", "()Lcom/tencent/mobileqq/cmshow/engine/EngineState;", "destroy", "", "handleBubbleTypeChange", "oldValue", "", "newValue", "initEngine", "ceApp", "Lcom/tencent/crossengine/CEApplication;", "start", "stop", "Companion", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CECMShowOffscreenEngine
  implements ICMShowEngine
{
  private static CEApplication jdField_a_of_type_ComTencentCrossengineCEApplication;
  public static final CECMShowOffscreenEngine.Companion a;
  private static final CEFontPixelsFactory jdField_a_of_type_ComTencentMobileqqCmshowCrossengineUtilCEFontPixelsFactory;
  @Nullable
  private static ICMShowView jdField_a_of_type_ComTencentMobileqqCmshowEngineRenderICMShowView;
  private static List<CERenderService> jdField_a_of_type_JavaUtilList = (List)new ArrayList();
  private static Map<String, CECMShowOffscreenEngine> jdField_a_of_type_JavaUtilMap;
  private static final ReentrantLock jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock = new ReentrantLock();
  private static volatile boolean jdField_a_of_type_Boolean;
  private final Context jdField_a_of_type_AndroidContentContext;
  private CEEngineContext jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEEngineContext;
  private CERenderService jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCERenderService;
  private CEResourceService jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEResourceService;
  private CEScriptService jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEScriptService;
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
    jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCECMShowOffscreenEngine$Companion = new CECMShowOffscreenEngine.Companion(null);
    jdField_a_of_type_ComTencentMobileqqCmshowCrossengineUtilCEFontPixelsFactory = new CEFontPixelsFactory();
    jdField_a_of_type_JavaUtilMap = (Map)new LinkedHashMap();
  }
  
  public CECMShowOffscreenEngine(@NotNull Context paramContext, @NotNull Scene paramScene)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqCmshowEngineSceneScene = paramScene;
    paramContext = new StringBuilder();
    paramContext.append("[cmshow][CECMShowOffscreenEngine][");
    paramContext.append(this.jdField_a_of_type_ComTencentMobileqqCmshowEngineSceneScene);
    paramContext.append(']');
    this.jdField_a_of_type_JavaLangString = paramContext.toString();
    paramContext = this.jdField_a_of_type_JavaLangString;
    paramScene = new StringBuilder();
    paramScene.append("create new ");
    paramScene.append(this);
    paramScene.append(", tryInitCEApplication");
    QLog.i(paramContext, 1, paramScene.toString());
    jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCECMShowOffscreenEngine$Companion.a((Function2)new CECMShowOffscreenEngine.1(this));
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
    this.jdField_a_of_type_KotlinLazy = LazyKt.lazy((Function0)new CECMShowOffscreenEngine.businessConfig.2(this));
  }
  
  private final void a(int paramInt1, int paramInt2)
  {
    jdField_a_of_type_ComTencentMobileqqCmshowCrossengineUtilCEFontPixelsFactory.a(paramInt2);
  }
  
  /* Error */
  private final void b(CEApplication paramCEApplication)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 150	com/tencent/mobileqq/cmshow/crossengine/CECMShowOffscreenEngine:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4: astore_2
    //   5: new 131	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   12: astore_3
    //   13: aload_3
    //   14: aload_0
    //   15: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   18: pop
    //   19: aload_3
    //   20: ldc 237
    //   22: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: pop
    //   26: aload_2
    //   27: iconst_1
    //   28: aload_3
    //   29: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 160	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   35: aload_0
    //   36: new 239	com/tencent/mobileqq/cmshow/crossengine/CEEngineContext
    //   39: dup
    //   40: aload_0
    //   41: getfield 127	com/tencent/mobileqq/cmshow/crossengine/CECMShowOffscreenEngine:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   44: aload_1
    //   45: aload_0
    //   46: getfield 129	com/tencent/mobileqq/cmshow/crossengine/CECMShowOffscreenEngine:jdField_a_of_type_ComTencentMobileqqCmshowEngineSceneScene	Lcom/tencent/mobileqq/cmshow/engine/scene/Scene;
    //   49: invokespecial 242	com/tencent/mobileqq/cmshow/crossengine/CEEngineContext:<init>	(Landroid/content/Context;Lcom/tencent/crossengine/CEApplication;Lcom/tencent/mobileqq/cmshow/engine/scene/Scene;)V
    //   52: putfield 244	com/tencent/mobileqq/cmshow/crossengine/CECMShowOffscreenEngine:jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEEngineContext	Lcom/tencent/mobileqq/cmshow/crossengine/CEEngineContext;
    //   55: aload_0
    //   56: getfield 244	com/tencent/mobileqq/cmshow/crossengine/CECMShowOffscreenEngine:jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEEngineContext	Lcom/tencent/mobileqq/cmshow/crossengine/CEEngineContext;
    //   59: astore_1
    //   60: aload_1
    //   61: ifnonnull +6 -> 67
    //   64: invokestatic 175	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   67: aload_0
    //   68: new 246	com/tencent/mobileqq/cmshow/crossengine/CERenderService
    //   71: dup
    //   72: aload_1
    //   73: invokespecial 249	com/tencent/mobileqq/cmshow/crossengine/CERenderService:<init>	(Lcom/tencent/mobileqq/cmshow/crossengine/CEEngineContext;)V
    //   76: putfield 172	com/tencent/mobileqq/cmshow/crossengine/CECMShowOffscreenEngine:jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCERenderService	Lcom/tencent/mobileqq/cmshow/crossengine/CERenderService;
    //   79: getstatic 234	com/tencent/mobileqq/cmshow/crossengine/CECMShowOffscreenEngine:jdField_a_of_type_Boolean	Z
    //   82: ifeq +22 -> 104
    //   85: aload_0
    //   86: getfield 172	com/tencent/mobileqq/cmshow/crossengine/CECMShowOffscreenEngine:jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCERenderService	Lcom/tencent/mobileqq/cmshow/crossengine/CERenderService;
    //   89: astore_1
    //   90: aload_1
    //   91: ifnonnull +6 -> 97
    //   94: invokestatic 175	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   97: aload_1
    //   98: invokevirtual 251	com/tencent/mobileqq/cmshow/crossengine/CERenderService:a	()V
    //   101: goto +46 -> 147
    //   104: getstatic 115	com/tencent/mobileqq/cmshow/crossengine/CECMShowOffscreenEngine:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   107: checkcast 253	java/util/concurrent/locks/Lock
    //   110: astore_1
    //   111: aload_1
    //   112: invokeinterface 256 1 0
    //   117: getstatic 110	com/tencent/mobileqq/cmshow/crossengine/CECMShowOffscreenEngine:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   120: astore_2
    //   121: aload_0
    //   122: getfield 172	com/tencent/mobileqq/cmshow/crossengine/CECMShowOffscreenEngine:jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCERenderService	Lcom/tencent/mobileqq/cmshow/crossengine/CERenderService;
    //   125: astore_3
    //   126: aload_3
    //   127: ifnonnull +6 -> 133
    //   130: invokestatic 175	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   133: aload_2
    //   134: aload_3
    //   135: invokeinterface 260 2 0
    //   140: pop
    //   141: aload_1
    //   142: invokeinterface 263 1 0
    //   147: aload_0
    //   148: getfield 244	com/tencent/mobileqq/cmshow/crossengine/CECMShowOffscreenEngine:jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEEngineContext	Lcom/tencent/mobileqq/cmshow/crossengine/CEEngineContext;
    //   151: astore_1
    //   152: aload_1
    //   153: ifnonnull +6 -> 159
    //   156: invokestatic 175	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   159: aload_0
    //   160: new 265	com/tencent/mobileqq/cmshow/crossengine/CEScriptService
    //   163: dup
    //   164: aload_1
    //   165: invokespecial 266	com/tencent/mobileqq/cmshow/crossengine/CEScriptService:<init>	(Lcom/tencent/mobileqq/cmshow/crossengine/CEEngineContext;)V
    //   168: putfield 181	com/tencent/mobileqq/cmshow/crossengine/CECMShowOffscreenEngine:jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEScriptService	Lcom/tencent/mobileqq/cmshow/crossengine/CEScriptService;
    //   171: aload_0
    //   172: getfield 244	com/tencent/mobileqq/cmshow/crossengine/CECMShowOffscreenEngine:jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEEngineContext	Lcom/tencent/mobileqq/cmshow/crossengine/CEEngineContext;
    //   175: astore_1
    //   176: aload_1
    //   177: ifnonnull +6 -> 183
    //   180: invokestatic 175	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   183: aload_0
    //   184: new 268	com/tencent/mobileqq/cmshow/crossengine/CEResourceService
    //   187: dup
    //   188: aload_1
    //   189: checkcast 270	com/tencent/mobileqq/cmshow/engine/EngineContext
    //   192: invokespecial 273	com/tencent/mobileqq/cmshow/crossengine/CEResourceService:<init>	(Lcom/tencent/mobileqq/cmshow/engine/EngineContext;)V
    //   195: putfield 187	com/tencent/mobileqq/cmshow/crossengine/CECMShowOffscreenEngine:jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEResourceService	Lcom/tencent/mobileqq/cmshow/crossengine/CEResourceService;
    //   198: getstatic 115	com/tencent/mobileqq/cmshow/crossengine/CECMShowOffscreenEngine:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   201: checkcast 253	java/util/concurrent/locks/Lock
    //   204: astore_1
    //   205: aload_1
    //   206: invokeinterface 256 1 0
    //   211: getstatic 103	com/tencent/mobileqq/cmshow/crossengine/CECMShowOffscreenEngine:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   214: new 275	com/tencent/mobileqq/cmshow/crossengine/CECMShowOffscreenEngine$initEngine$2$1
    //   217: dup
    //   218: aload_0
    //   219: getfield 129	com/tencent/mobileqq/cmshow/crossengine/CECMShowOffscreenEngine:jdField_a_of_type_ComTencentMobileqqCmshowEngineSceneScene	Lcom/tencent/mobileqq/cmshow/engine/scene/Scene;
    //   222: invokespecial 278	com/tencent/mobileqq/cmshow/crossengine/CECMShowOffscreenEngine$initEngine$2$1:<init>	(Lcom/tencent/mobileqq/cmshow/engine/scene/Scene;)V
    //   225: invokeinterface 284 1 0
    //   230: aload_0
    //   231: invokeinterface 288 3 0
    //   236: checkcast 2	com/tencent/mobileqq/cmshow/crossengine/CECMShowOffscreenEngine
    //   239: astore_2
    //   240: aload_1
    //   241: invokeinterface 263 1 0
    //   246: return
    //   247: astore_2
    //   248: aload_1
    //   249: invokeinterface 263 1 0
    //   254: aload_2
    //   255: athrow
    //   256: astore_2
    //   257: aload_1
    //   258: invokeinterface 263 1 0
    //   263: aload_2
    //   264: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	265	0	this	CECMShowOffscreenEngine
    //   0	265	1	paramCEApplication	CEApplication
    //   4	236	2	localObject1	Object
    //   247	8	2	localObject2	Object
    //   256	8	2	localObject3	Object
    //   12	123	3	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   211	240	247	finally
    //   117	126	256	finally
    //   130	133	256	finally
    //   133	141	256	finally
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
          }
          Object localObject2 = Unit.INSTANCE;
        }
        finally
        {
          ((Lock)localObject1).unlock();
        }
      }
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCERenderService;
    if (localObject1 != null) {
      ((CERenderService)localObject1).e();
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
          }
          Object localObject2 = Unit.INSTANCE;
        }
        finally
        {
          ((Lock)localObject1).unlock();
        }
      }
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCERenderService;
    if (localObject1 != null) {
      ((CERenderService)localObject1).f();
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
          Object localObject2;
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
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEEngineContext;
            if (localObject2 != null)
            {
              localObject2 = ((CEEngineContext)localObject2).a();
              if (localObject2 != null) {
                ((CEApplication)localObject2).destoryWorld((String)new CECMShowOffscreenEngine.destroy.1.1(this.jdField_a_of_type_ComTencentMobileqqCmshowEngineSceneScene).get());
              }
            }
            localObject2 = (Lock)jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock;
            ((Lock)localObject2).lock();
          }
          try
          {
            CECMShowOffscreenEngine localCECMShowOffscreenEngine = (CECMShowOffscreenEngine)jdField_a_of_type_JavaUtilMap.remove(new CECMShowOffscreenEngine.destroy.1.2.1(this.jdField_a_of_type_ComTencentMobileqqCmshowEngineSceneScene).get());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.crossengine.CECMShowOffscreenEngine
 * JD-Core Version:    0.7.0.1
 */