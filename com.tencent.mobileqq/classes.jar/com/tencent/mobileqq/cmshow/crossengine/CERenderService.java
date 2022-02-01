package com.tencent.mobileqq.cmshow.crossengine;

import android.os.Handler;
import com.tencent.crossengine.CEApplication;
import com.tencent.mobileqq.apollo.config.CmShowWnsUtils;
import com.tencent.mobileqq.apollo.debug.utils.ApolloDebugUtils;
import com.tencent.mobileqq.apollo.meme.action.MemeAction;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/crossengine/CERenderService;", "Lcom/tencent/mobileqq/cmshow/engine/render/IRenderService;", "engineContext", "Lcom/tencent/mobileqq/cmshow/crossengine/CEEngineContext;", "(Lcom/tencent/mobileqq/cmshow/crossengine/CEEngineContext;)V", "TAG", "", "ceOffscreenRenderView", "Lcom/tencent/mobileqq/cmshow/engine/render/ICMShowView;", "getCeOffscreenRenderView", "()Lcom/tencent/mobileqq/cmshow/engine/render/ICMShowView;", "ceOffscreenRenderView$delegate", "Lkotlin/Lazy;", "engineInit", "", "frameCount", "", "hasStartRecord", "initOffscreenWorld", "isRecording", "offscreenWorldCreated", "recordListener", "Lcom/tencent/mobileqq/cmshow/engine/render/IRecordFrameListener;", "renderConfig", "Lcom/tencent/mobileqq/cmshow/engine/model/RenderConfig;", "surfaceHeight", "surfaceListener", "Lcom/tencent/mobileqq/cmshow/engine/render/ISurfaceStateListener;", "surfaceReady", "surfaceWidth", "touchListener", "Lcom/tencent/mobileqq/cmshow/engine/render/ITouchListener;", "destroy", "", "destroy$cmshow_impl_release", "evaluateBusinessScript", "getRecordFrameListener", "getRenderView", "initFinished", "offscreenSurfaceReady", "onFrameCallback", "worldName", "pixels", "", "width", "height", "byteLength", "pause", "pause$cmshow_impl_release", "resizeOffscreenWorld", "resume", "resume$cmshow_impl_release", "setConfig", "setRecordFrameListener", "listener", "setRecording", "setSurfaceListener", "setTouchListener", "Companion", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CERenderService
  implements IRenderService
{
  public static final CERenderService.Companion a = new CERenderService.Companion(null);
  private final String b;
  private ISurfaceStateListener c;
  private IRecordFrameListener d;
  private ITouchListener e;
  private RenderConfig f;
  private boolean g;
  private boolean h;
  private boolean i;
  private boolean j;
  private boolean k;
  private volatile boolean l;
  private int m;
  private int n;
  private int o;
  private final Lazy p;
  private final CEEngineContext q;
  
  public CERenderService(@NotNull CEEngineContext paramCEEngineContext)
  {
    this.q = paramCEEngineContext;
    paramCEEngineContext = new StringBuilder();
    paramCEEngineContext.append("[cmshow][CECMShowOffscreenEngine][CERenderService][");
    paramCEEngineContext.append(this.q.k());
    paramCEEngineContext.append(']');
    this.b = paramCEEngineContext.toString();
    this.p = LazyKt.lazy((Function0)new CERenderService.ceOffscreenRenderView.2(this));
    paramCEEngineContext = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("create ");
    localStringBuilder.append(this);
    localStringBuilder.append(" for ");
    localStringBuilder.append(this.q.k());
    QLog.i(paramCEEngineContext, 1, localStringBuilder.toString());
    this.q.a((IRenderService)this);
  }
  
  private final ICMShowView j()
  {
    return (ICMShowView)this.p.getValue();
  }
  
  private final void k()
  {
    if ((this.h) && (this.g))
    {
      localObject1 = this.q.c();
      localObject2 = (String)new CERenderService.initOffscreenWorld.1(this.q.k()).get();
      String str = this.q.k().worldPath$cmshow_impl_release();
      int i1 = this.m;
      int i2 = this.n;
      RenderConfig localRenderConfig = this.f;
      if (localRenderConfig == null) {
        Intrinsics.throwNpe();
      }
      boolean bool;
      if (localRenderConfig.f == RenderMode.OFF_SCREEN) {
        bool = true;
      } else {
        bool = false;
      }
      ((CEApplication)localObject1).createOffScreenWorld((String)localObject2, str, i1, i2, bool);
      localObject1 = this.q.k().preloadScripts$cmshow_impl_release();
      if (localObject1 != null)
      {
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          this.q.c().runWorldScriptFile((String)new CERenderService.initOffscreenWorld.2.1(this.q.k()).get(), (String)localObject2);
        }
      }
      localObject1 = this.f;
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      if (((RenderConfig)localObject1).f != RenderMode.OFF_SCREEN)
      {
        this.k = true;
        this.q.c().evaluateWorldJs((String)new CERenderService.initOffscreenWorld.3(this.q.k()).get(), "ce.FrameRecorder.StartRecord(-1);");
      }
      localObject1 = this.b;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onSurfaceReady initOffscreenWorld StartRecord : ");
      ((StringBuilder)localObject2).append(this.m);
      ((StringBuilder)localObject2).append(", ");
      ((StringBuilder)localObject2).append(this.n);
      ((StringBuilder)localObject2).append(", scene: ");
      ((StringBuilder)localObject2).append(this.q.k());
      QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      this.i = true;
      if (this.j) {
        l();
      }
      return;
    }
    Object localObject1 = this.b;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("initOffscreenWorld engintInit: ");
    ((StringBuilder)localObject2).append(this.g);
    ((StringBuilder)localObject2).append(", surfaceReady: ");
    ((StringBuilder)localObject2).append(this.h);
    ((StringBuilder)localObject2).append(", scene: ");
    ((StringBuilder)localObject2).append(this.q.k());
    QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
  }
  
  private final void l()
  {
    MqqHandler localMqqHandler = ThreadManager.getSubThreadHandler();
    Runnable localRunnable = (Runnable)new CERenderService.evaluateBusinessScript.1(this);
    Long localLong = CmShowWnsUtils.D();
    Intrinsics.checkExpressionValueIsNotNull(localLong, "CmShowWnsUtils.getCEOffscreenEvlJSDelayTime()");
    localMqqHandler.postDelayed(localRunnable, localLong.longValue());
  }
  
  @NotNull
  public ICMShowView a()
  {
    return j();
  }
  
  public void a(@NotNull RenderConfig paramRenderConfig)
  {
    Intrinsics.checkParameterIsNotNull(paramRenderConfig, "renderConfig");
    this.f = paramRenderConfig;
  }
  
  public void a(@Nullable IRecordFrameListener paramIRecordFrameListener)
  {
    this.d = paramIRecordFrameListener;
  }
  
  public void a(@Nullable ISurfaceStateListener paramISurfaceStateListener)
  {
    this.c = paramISurfaceStateListener;
  }
  
  public void a(@Nullable ITouchListener paramITouchListener)
  {
    this.e = paramITouchListener;
  }
  
  public final void a(@NotNull String paramString, @NotNull byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "worldName");
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "pixels");
    boolean bool = this.l;
    Object localObject1;
    if ((this.q.k() == Scene.MEME_PLAYER) && (ApolloDebugUtils.a("test_ce_meme_player_save_frame_callback", false)))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("/sdcard/cmshow/ce/frameCallback/");
      ((StringBuilder)localObject1).append(this.q.k());
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject2 = b();
      if (localObject2 != null)
      {
        localObject2 = ((IRecordFrameListener)localObject2).a();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append('/');
        localStringBuilder.append(this.o);
        localStringBuilder.append('_');
        localStringBuilder.append(((MemeAction)localObject2).h());
        localStringBuilder.append("_isRecording_");
        localStringBuilder.append(bool);
        localStringBuilder.append(".png");
        localObject1 = localStringBuilder.toString();
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append('/');
        ((StringBuilder)localObject2).append(this.o);
        ((StringBuilder)localObject2).append(".png");
        localObject1 = ((StringBuilder)localObject2).toString();
      }
      this.o += 1;
      ThreadManager.excute((Runnable)new CERenderService.onFrameCallback.1((String)localObject1, paramArrayOfByte, paramInt1, paramInt2, paramInt3), 64, null, true);
    }
    if (!bool)
    {
      paramArrayOfByte = this.b;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onFrameCallback, ");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(" is not recording, return");
      QLog.d(paramArrayOfByte, 1, ((StringBuilder)localObject1).toString());
      return;
    }
    paramString = this.f;
    if (paramString == null) {
      Intrinsics.throwNpe();
    }
    if (paramString.f == RenderMode.ON_SCREEN) {
      return;
    }
    this.q.b().post((Runnable)new CERenderService.onFrameCallback.2(this, paramArrayOfByte, paramInt3, paramInt2));
  }
  
  public void a(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  @Nullable
  public IRecordFrameListener b()
  {
    return this.d;
  }
  
  public final void c()
  {
    String str = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initFinished, scene: ");
    localStringBuilder.append(this.q.k());
    QLog.d(str, 1, localStringBuilder.toString());
    this.g = true;
    k();
  }
  
  public final void d()
  {
    String str = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("offscreenWorldCreated, scene: ");
    localStringBuilder.append(this.q.k());
    QLog.d(str, 1, localStringBuilder.toString());
    this.j = true;
    if ((this.h) && (this.g) && (this.i)) {
      l();
    }
  }
  
  public final void e()
  {
    String str = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("offscreenSurfaceReady, scene: ");
    localStringBuilder.append(this.q.k());
    QLog.d(str, 1, localStringBuilder.toString());
    ThreadManager.getUIHandlerV2().post((Runnable)new CERenderService.offscreenSurfaceReady.1(this));
  }
  
  public final void f()
  {
    String str = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resizeOffscreenWorld : ");
    localStringBuilder.append(this.m);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.n);
    QLog.d(str, 1, localStringBuilder.toString());
    this.q.c().resizeOffscreenWorld((String)new CERenderService.resizeOffscreenWorld.1(this.q.k()).get(), this.m, this.n);
  }
  
  public final void g()
  {
    if ((this.i) && (this.j) && (!this.k))
    {
      String str = this.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("resume , start recor, ");
      localStringBuilder.append(this.q.k());
      QLog.d(str, 1, localStringBuilder.toString());
      this.k = true;
      this.q.c().evaluateWorldJs((String)new CERenderService.resume.1(this.q.k()).get(), "ce.FrameRecorder.StartRecord(-1);");
    }
  }
  
  public final void h()
  {
    if (this.k)
    {
      String str = this.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pause , stop record, ");
      localStringBuilder.append(this.q.k());
      QLog.d(str, 1, localStringBuilder.toString());
      this.k = false;
      this.q.c().evaluateWorldJs((String)new CERenderService.pause.1(this.q.k()).get(), "ce.FrameRecorder.StopRecord(true);");
    }
  }
  
  public final void i()
  {
    Object localObject = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("destroy ");
    localStringBuilder.append(this);
    localStringBuilder.append(" for ");
    localStringBuilder.append(this.q.k());
    QLog.i((String)localObject, 1, localStringBuilder.toString());
    if (this.k)
    {
      localObject = this.b;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("destroy , stop record, ");
      localStringBuilder.append(this.q.k());
      QLog.d((String)localObject, 1, localStringBuilder.toString());
      this.q.c().evaluateWorldJs((String)new CERenderService.destroy.1(this.q.k()).get(), "ce.FrameRecorder.StopRecord(true);");
    }
    this.h = false;
    this.k = false;
    this.i = false;
    this.j = false;
    this.l = false;
    localObject = j().getView();
    if (localObject != null)
    {
      ((CECMShowOffscreenView)localObject).c();
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.cmshow.crossengine.CECMShowOffscreenView");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.crossengine.CERenderService
 * JD-Core Version:    0.7.0.1
 */