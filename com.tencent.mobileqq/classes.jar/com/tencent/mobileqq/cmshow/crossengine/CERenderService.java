package com.tencent.mobileqq.cmshow.crossengine;

import com.tencent.crossengine.CEApplication;
import com.tencent.mobileqq.apollo.config.CmShowWnsUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.cmshow.engine.model.RenderConfig;
import com.tencent.mobileqq.cmshow.engine.render.ICMShowView;
import com.tencent.mobileqq.cmshow.engine.render.IRecordFrameListener;
import com.tencent.mobileqq.cmshow.engine.render.IRenderService;
import com.tencent.mobileqq.cmshow.engine.render.ISurfaceStateListener;
import com.tencent.mobileqq.cmshow.engine.render.ITouchListener;
import com.tencent.mobileqq.cmshow.engine.render.RenderMode;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty0;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/crossengine/CERenderService;", "Lcom/tencent/mobileqq/cmshow/engine/render/IRenderService;", "engineContext", "Lcom/tencent/mobileqq/cmshow/crossengine/CEEngineContext;", "(Lcom/tencent/mobileqq/cmshow/crossengine/CEEngineContext;)V", "TAG", "", "ceOffscreenRenderView", "Lcom/tencent/mobileqq/cmshow/engine/render/ICMShowView;", "getCeOffscreenRenderView", "()Lcom/tencent/mobileqq/cmshow/engine/render/ICMShowView;", "ceOffscreenRenderView$delegate", "Lkotlin/Lazy;", "ceRenderView", "getCeRenderView", "ceRenderView$delegate", "engintInit", "", "frameCount", "", "hasStartRecord", "initOffscreenWorld", "isRecording", "offscreenWorldCreated", "recordListener", "Lcom/tencent/mobileqq/cmshow/engine/render/IRecordFrameListener;", "renderConfig", "Lcom/tencent/mobileqq/cmshow/engine/model/RenderConfig;", "surfaceHight", "surfaceListener", "Lcom/tencent/mobileqq/cmshow/engine/render/ISurfaceStateListener;", "surfaceReady", "surfaceWidth", "touchListener", "Lcom/tencent/mobileqq/cmshow/engine/render/ITouchListener;", "destroy", "", "destroy$cmshow_impl_release", "evaluateBusinessScript", "getRecordFrameListener", "getRenderView", "initFinished", "onFrameCallback", "worldName", "pixels", "", "width", "height", "byteLength", "pause", "pause$cmshow_impl_release", "resizeOffscreenWorld", "resume", "resume$cmshow_impl_release", "setConfig", "setRecordFrameListener", "listener", "setRecording", "setSurfaceListener", "setTouchListener", "Companion", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CERenderService
  implements IRenderService
{
  public static final CERenderService.Companion a;
  private int jdField_a_of_type_Int;
  private final CEEngineContext jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEEngineContext;
  private RenderConfig jdField_a_of_type_ComTencentMobileqqCmshowEngineModelRenderConfig;
  private IRecordFrameListener jdField_a_of_type_ComTencentMobileqqCmshowEngineRenderIRecordFrameListener;
  private ISurfaceStateListener jdField_a_of_type_ComTencentMobileqqCmshowEngineRenderISurfaceStateListener;
  private ITouchListener jdField_a_of_type_ComTencentMobileqqCmshowEngineRenderITouchListener;
  private final String jdField_a_of_type_JavaLangString;
  private final Lazy jdField_a_of_type_KotlinLazy;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private final Lazy jdField_b_of_type_KotlinLazy;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  private boolean e;
  private boolean f;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCERenderService$Companion = new CERenderService.Companion(null);
  }
  
  public CERenderService(@NotNull CEEngineContext paramCEEngineContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEEngineContext = paramCEEngineContext;
    paramCEEngineContext = new StringBuilder();
    paramCEEngineContext.append("[cmshow][CECMShowOffscreenEngine][CERenderService][");
    paramCEEngineContext.append(this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEEngineContext.a());
    paramCEEngineContext.append(']');
    this.jdField_a_of_type_JavaLangString = paramCEEngineContext.toString();
    this.jdField_a_of_type_KotlinLazy = LazyKt.lazy((Function0)new CERenderService.ceRenderView.2(this));
    this.jdField_b_of_type_KotlinLazy = LazyKt.lazy((Function0)new CERenderService.ceOffscreenRenderView.2(this));
    paramCEEngineContext = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("create ");
    localStringBuilder.append(this);
    localStringBuilder.append(" for ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEEngineContext.a());
    QLog.i(paramCEEngineContext, 1, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEEngineContext.a((IRenderService)this);
  }
  
  private final ICMShowView b()
  {
    return (ICMShowView)this.jdField_a_of_type_KotlinLazy.getValue();
  }
  
  private final ICMShowView c()
  {
    return (ICMShowView)this.jdField_b_of_type_KotlinLazy.getValue();
  }
  
  private final void h()
  {
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Boolean))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEEngineContext.a();
      localObject2 = (String)new CERenderService.initOffscreenWorld.1(this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEEngineContext.a()).get();
      String str = this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEEngineContext.a().worldPath$cmshow_impl_release();
      int i = this.jdField_a_of_type_Int;
      int j = this.jdField_b_of_type_Int;
      RenderConfig localRenderConfig = this.jdField_a_of_type_ComTencentMobileqqCmshowEngineModelRenderConfig;
      if (localRenderConfig == null) {
        Intrinsics.throwNpe();
      }
      boolean bool;
      if (localRenderConfig.a == RenderMode.OFF_SCREEN) {
        bool = true;
      } else {
        bool = false;
      }
      ((CEApplication)localObject1).createOffScreenWorld((String)localObject2, str, i, j, bool);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEEngineContext.a().preloadScripts$cmshow_impl_release();
      if (localObject1 != null)
      {
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEEngineContext.a().runWorldScriptFile((String)new CERenderService.initOffscreenWorld.2.1(this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEEngineContext.a()).get(), (String)localObject2);
        }
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqCmshowEngineModelRenderConfig;
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      if (((RenderConfig)localObject1).a != RenderMode.OFF_SCREEN)
      {
        this.e = true;
        this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEEngineContext.a().evaluateWorldJs((String)new CERenderService.initOffscreenWorld.3(this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEEngineContext.a()).get(), "ce.FrameRecorder.StartRecord(-1);");
      }
      localObject1 = this.jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onSurfaceReady initOffscreenWorld StartRecord : ");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_Int);
      ((StringBuilder)localObject2).append(", ");
      ((StringBuilder)localObject2).append(this.jdField_b_of_type_Int);
      ((StringBuilder)localObject2).append(", scene: ");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEEngineContext.a());
      QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      this.c = true;
      if (this.d) {
        c();
      }
      return;
    }
    Object localObject1 = this.jdField_a_of_type_JavaLangString;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("initOffscreenWorld engintInit: ");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_Boolean);
    ((StringBuilder)localObject2).append(", surfaceReady: ");
    ((StringBuilder)localObject2).append(this.jdField_b_of_type_Boolean);
    ((StringBuilder)localObject2).append(", scene: ");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEEngineContext.a());
    QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
  }
  
  @NotNull
  public ICMShowView a()
  {
    if (CmShowWnsUtils.x()) {
      return c();
    }
    return b();
  }
  
  @Nullable
  public IRecordFrameListener a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqCmshowEngineRenderIRecordFrameListener;
  }
  
  public final void a()
  {
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initFinished, scene: ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEEngineContext.a());
    QLog.d(str, 1, localStringBuilder.toString());
    this.jdField_a_of_type_Boolean = true;
    h();
  }
  
  public void a(@NotNull RenderConfig paramRenderConfig)
  {
    Intrinsics.checkParameterIsNotNull(paramRenderConfig, "renderConfig");
    this.jdField_a_of_type_ComTencentMobileqqCmshowEngineModelRenderConfig = paramRenderConfig;
  }
  
  public void a(@Nullable IRecordFrameListener paramIRecordFrameListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqCmshowEngineRenderIRecordFrameListener = paramIRecordFrameListener;
  }
  
  public void a(@Nullable ISurfaceStateListener paramISurfaceStateListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqCmshowEngineRenderISurfaceStateListener = paramISurfaceStateListener;
  }
  
  public void a(@Nullable ITouchListener paramITouchListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqCmshowEngineRenderITouchListener = paramITouchListener;
  }
  
  public final void a(@NotNull String paramString, @NotNull byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "worldName");
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "pixels");
    if (!this.f)
    {
      paramArrayOfByte = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onFrameCallback, ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" is not recording, return");
      QLog.d(paramArrayOfByte, 1, localStringBuilder.toString());
      return;
    }
    paramString = this.jdField_a_of_type_ComTencentMobileqqCmshowEngineModelRenderConfig;
    if (paramString == null) {
      Intrinsics.throwNpe();
    }
    if (paramString.a == RenderMode.ON_SCREEN) {
      return;
    }
    paramString = this.jdField_a_of_type_ComTencentMobileqqCmshowEngineRenderIRecordFrameListener;
    if (paramString != null) {
      paramString.a(paramArrayOfByte, paramInt3 / paramInt2 / 4, paramInt2);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public final void b()
  {
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("offscreenWorldCreated, scene: ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEEngineContext.a());
    QLog.d(str, 1, localStringBuilder.toString());
    this.d = true;
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Boolean) && (this.c)) {
      c();
    }
  }
  
  public final void c()
  {
    MqqHandler localMqqHandler = ThreadManager.getSubThreadHandler();
    Runnable localRunnable = (Runnable)new CERenderService.evaluateBusinessScript.1(this);
    Long localLong = CmShowWnsUtils.a();
    Intrinsics.checkExpressionValueIsNotNull(localLong, "CmShowWnsUtils.getCEOffscreenEvlJSDelayTime()");
    localMqqHandler.postDelayed(localRunnable, localLong.longValue());
  }
  
  public final void d()
  {
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resizeOffscreenWorld : ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    QLog.d(str, 1, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEEngineContext.a().resizeOffscreenWorld((String)new CERenderService.resizeOffscreenWorld.1(this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEEngineContext.a()).get(), this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
  }
  
  public final void e()
  {
    if ((this.c) && (this.d) && (!this.e))
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("resume , start recor, ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEEngineContext.a());
      QLog.d(str, 1, localStringBuilder.toString());
      this.e = true;
      this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEEngineContext.a().evaluateWorldJs((String)new CERenderService.resume.1(this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEEngineContext.a()).get(), "ce.FrameRecorder.StartRecord(-1);");
    }
  }
  
  public final void f()
  {
    if (this.e)
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pause , stop record, ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEEngineContext.a());
      QLog.d(str, 1, localStringBuilder.toString());
      this.e = false;
      this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEEngineContext.a().evaluateWorldJs((String)new CERenderService.pause.1(this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEEngineContext.a()).get(), "ce.FrameRecorder.StopRecord(true);");
    }
  }
  
  public final void g()
  {
    Object localObject = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("destroy ");
    localStringBuilder.append(this);
    localStringBuilder.append(" for ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEEngineContext.a());
    QLog.i((String)localObject, 1, localStringBuilder.toString());
    if (this.e)
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("destroy , stop record, ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEEngineContext.a());
      QLog.d((String)localObject, 1, localStringBuilder.toString());
      this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEEngineContext.a().evaluateWorldJs((String)new CERenderService.destroy.1(this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEEngineContext.a()).get(), "ce.FrameRecorder.StopRecord(true);");
    }
    this.jdField_b_of_type_Boolean = false;
    this.e = false;
    this.c = false;
    this.d = false;
    this.f = false;
    if (CmShowWnsUtils.x())
    {
      localObject = c().getView();
      if (localObject != null)
      {
        ((CECMShowOffscreenView)localObject).a();
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.cmshow.crossengine.CECMShowOffscreenView");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.crossengine.CERenderService
 * JD-Core Version:    0.7.0.1
 */