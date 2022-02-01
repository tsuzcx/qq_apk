package com.tencent.mobileqq.cmshow.brickengine;

import android.content.Context;
import android.util.Pair;
import com.tencent.mobileqq.apollo.config.CmShowWnsUtils;
import com.tencent.mobileqq.apollo.listener.OnApolloViewListener;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloEngine;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRender;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRenderInterfaceImpl;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloTextureView;
import com.tencent.mobileqq.cmshow.brickengine.apollo.IRenderRunner;
import com.tencent.mobileqq.cmshow.engine.EngineContext;
import com.tencent.mobileqq.cmshow.engine.EngineState;
import com.tencent.mobileqq.cmshow.engine.model.RenderConfig;
import com.tencent.mobileqq.cmshow.engine.render.ICMShowView;
import com.tencent.mobileqq.cmshow.engine.render.IRecordFrameListener;
import com.tencent.mobileqq.cmshow.engine.render.IRenderService;
import com.tencent.mobileqq.cmshow.engine.render.IRenderService.DefaultImpls;
import com.tencent.mobileqq.cmshow.engine.render.ISurfaceStateListener;
import com.tencent.mobileqq.cmshow.engine.render.ITouchListener;
import com.tencent.mobileqq.cmshow.engine.render.RenderMode;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import com.tencent.mobileqq.cmshow.engine.script.Script;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/brickengine/BKRenderService;", "Lcom/tencent/mobileqq/cmshow/engine/render/IRenderService;", "engineContext", "Lcom/tencent/mobileqq/cmshow/engine/EngineContext;", "(Lcom/tencent/mobileqq/cmshow/engine/EngineContext;)V", "TAG", "", "apolloViewListener", "com/tencent/mobileqq/cmshow/brickengine/BKRenderService$apolloViewListener$1", "Lcom/tencent/mobileqq/cmshow/brickengine/BKRenderService$apolloViewListener$1;", "cmshowView", "Lcom/tencent/mobileqq/cmshow/engine/render/ICMShowView;", "getCmshowView", "()Lcom/tencent/mobileqq/cmshow/engine/render/ICMShowView;", "cmshowView$delegate", "Lkotlin/Lazy;", "hasCreateView", "", "recordListener", "Lcom/tencent/mobileqq/cmshow/engine/render/IRecordFrameListener;", "renderConfig", "Lcom/tencent/mobileqq/cmshow/engine/model/RenderConfig;", "surfaceStateListener", "Lcom/tencent/mobileqq/cmshow/engine/render/ISurfaceStateListener;", "touchListener", "Lcom/tencent/mobileqq/cmshow/engine/render/ITouchListener;", "createSurfaceVIew", "Lcom/tencent/mobileqq/cmshow/brickengine/apollo/ApolloSurfaceView;", "createTextureView", "Lcom/tencent/mobileqq/cmshow/brickengine/apollo/ApolloTextureView;", "destroy", "", "destroy$cmshow_impl_release", "getApolloRender", "Lcom/tencent/mobileqq/cmshow/brickengine/apollo/ApolloRender;", "view", "getJsState", "", "getJsState$cmshow_impl_release", "getRecordFrameListener", "getRenderInterfaceImpl", "Lcom/tencent/mobileqq/cmshow/brickengine/apollo/ApolloRenderInterfaceImpl;", "getRenderInterfaceImpl$cmshow_impl_release", "getRenderView", "renderJs", "script", "Lcom/tencent/mobileqq/cmshow/engine/script/Script;", "renderJs$cmshow_impl_release", "setBubbleType", "bubbleType", "", "setBubbleType$cmshow_impl_release", "setConfig", "config", "setRecordFrameListener", "listener", "setSurfaceListener", "setTouchListener", "Companion", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class BKRenderService
  implements IRenderService
{
  @Deprecated
  public static final BKRenderService.Companion a = new BKRenderService.Companion(null);
  private final String b;
  private ISurfaceStateListener c;
  private IRecordFrameListener d;
  private ITouchListener e;
  private RenderConfig f;
  private final BKRenderService.apolloViewListener.1 g;
  private boolean h;
  private final Lazy i;
  private final EngineContext j;
  
  public BKRenderService(@NotNull EngineContext paramEngineContext)
  {
    this.j = paramEngineContext;
    paramEngineContext = new StringBuilder();
    paramEngineContext.append("[cmshow][BKCMShowEngine][BKRenderService][");
    paramEngineContext.append(this.j.k());
    paramEngineContext.append(']');
    this.b = paramEngineContext.toString();
    this.g = new BKRenderService.apolloViewListener.1(this);
    this.i = LazyKt.lazy((Function0)new BKRenderService.cmshowView.2(this));
    paramEngineContext = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("create ");
    localStringBuilder.append(this);
    localStringBuilder.append(" for ");
    localStringBuilder.append(this.j.k());
    QLog.i(paramEngineContext, 1, localStringBuilder.toString());
    this.j.a((IRenderService)this);
  }
  
  private final ApolloRender b(ICMShowView paramICMShowView)
  {
    if ((paramICMShowView instanceof ApolloTextureView)) {
      return ((ApolloTextureView)paramICMShowView).getRender();
    }
    if ((paramICMShowView instanceof ApolloSurfaceView)) {
      return ((ApolloSurfaceView)paramICMShowView).getRender();
    }
    return null;
  }
  
  private final ICMShowView e()
  {
    return (ICMShowView)this.i.getValue();
  }
  
  private final ApolloTextureView f()
  {
    Object localObject2 = this.j.j();
    Object localObject1 = null;
    localObject2 = new ApolloTextureView((Context)localObject2, null);
    Object localObject3 = this.f;
    boolean bool3 = false;
    if (localObject3 != null) {
      bool1 = ((RenderConfig)localObject3).c;
    } else {
      bool1 = false;
    }
    ((ApolloTextureView)localObject2).setDestroyOnAsync(bool1);
    localObject3 = this.f;
    if (localObject3 != null)
    {
      localObject3 = ((RenderConfig)localObject3).f;
      if (localObject3 != null)
      {
        bool1 = ((RenderMode)localObject3).isOffscreen();
        break label89;
      }
    }
    boolean bool1 = false;
    label89:
    int k;
    if (bool1)
    {
      localObject3 = this.f;
      if (localObject3 != null)
      {
        BKRenderService.Companion localCompanion = a;
        if (localObject3 != null) {
          localObject1 = ((RenderConfig)localObject3).g;
        }
        ((RenderConfig)localObject3).g = localCompanion.a((Pair)localObject1);
      }
      localObject1 = this.f;
      if (localObject1 != null)
      {
        localObject1 = ((RenderConfig)localObject1).g;
        if (localObject1 != null)
        {
          localObject1 = (Integer)((Pair)localObject1).first;
          if (localObject1 != null)
          {
            k = ((Integer)localObject1).intValue();
            break label182;
          }
        }
      }
      k = 0;
      label182:
      localObject1 = this.f;
      if (localObject1 != null)
      {
        localObject1 = ((RenderConfig)localObject1).g;
        if (localObject1 != null)
        {
          localObject1 = (Integer)((Pair)localObject1).second;
          if (localObject1 != null)
          {
            m = ((Integer)localObject1).intValue();
            break label231;
          }
        }
      }
      int m = 0;
      label231:
      ((ApolloTextureView)localObject2).setOffscreenSize(k, m);
    }
    localObject1 = this.f;
    if (localObject1 != null) {
      bool2 = ((RenderConfig)localObject1).d;
    } else {
      bool2 = false;
    }
    ((ApolloTextureView)localObject2).setDumplicateCreateRenderThread(bool2);
    localObject1 = this.f;
    if (localObject1 != null) {
      k = ((RenderConfig)localObject1).b;
    } else {
      k = 0;
    }
    ((ApolloTextureView)localObject2).setInitHeight(k);
    localObject1 = this.f;
    boolean bool2 = bool3;
    if (localObject1 != null) {
      bool2 = ((RenderConfig)localObject1).e;
    }
    ((ApolloTextureView)localObject2).mIsDrawerView = bool2;
    ((ApolloTextureView)localObject2).init((OnApolloViewListener)this.g, bool1);
    return localObject2;
  }
  
  private final ApolloSurfaceView g()
  {
    ApolloSurfaceView localApolloSurfaceView = new ApolloSurfaceView(this.j.j(), null, true);
    int k = 0;
    localApolloSurfaceView.mRenderMode = 0;
    localApolloSurfaceView.init((OnApolloViewListener)this.g, 0);
    RenderConfig localRenderConfig = this.f;
    if (localRenderConfig != null) {
      k = localRenderConfig.b;
    }
    localApolloSurfaceView.setInitHeight(k);
    return localApolloSurfaceView;
  }
  
  @Nullable
  public final ApolloRenderInterfaceImpl a(@NotNull ICMShowView paramICMShowView)
  {
    Intrinsics.checkParameterIsNotNull(paramICMShowView, "view");
    if ((paramICMShowView instanceof ApolloTextureView)) {
      return ((ApolloTextureView)paramICMShowView).getRenderImpl();
    }
    if ((paramICMShowView instanceof ApolloSurfaceView)) {
      return ((ApolloSurfaceView)paramICMShowView).getRenderImpl();
    }
    return null;
  }
  
  @NotNull
  public ICMShowView a()
  {
    return e();
  }
  
  public final void a(int paramInt)
  {
    if (!this.h)
    {
      QLog.w(this.b, 1, "setBubbleType error on !hasCreateView");
      return;
    }
    ApolloRender localApolloRender = b(e());
    if (localApolloRender != null) {
      localApolloRender.setBubbleType(paramInt);
    }
  }
  
  public void a(@NotNull RenderConfig paramRenderConfig)
  {
    Intrinsics.checkParameterIsNotNull(paramRenderConfig, "config");
    this.f = paramRenderConfig;
  }
  
  public void a(@Nullable IRecordFrameListener paramIRecordFrameListener)
  {
    this.d = paramIRecordFrameListener;
    if (this.h)
    {
      paramIRecordFrameListener = b(e());
      if (paramIRecordFrameListener != null) {
        paramIRecordFrameListener.setRecordFrameListener(this.d);
      }
    }
  }
  
  public void a(@Nullable ISurfaceStateListener paramISurfaceStateListener)
  {
    this.c = paramISurfaceStateListener;
  }
  
  public void a(@Nullable ITouchListener paramITouchListener)
  {
    this.e = paramITouchListener;
  }
  
  public final void a(@NotNull Script paramScript)
  {
    Intrinsics.checkParameterIsNotNull(paramScript, "script");
    Object localObject2;
    if (!this.h)
    {
      localObject1 = this.b;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("renderJs error on !hasCreateView, script: ");
      ((StringBuilder)localObject2).append(paramScript);
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      return;
    }
    Object localObject1 = e();
    if (localObject1 != null)
    {
      localObject1 = (IRenderRunner)localObject1;
      if (CmShowWnsUtils.F())
      {
        long l = ((IRenderRunner)localObject1).getRenderThreadId();
        localObject2 = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "Thread.currentThread()");
        if ((l == ((Thread)localObject2).getId()) && ((this.j.e() == EngineState.INITIALIZED) || (this.j.e() == EngineState.STARTED)))
        {
          if (QLog.isColorLevel())
          {
            localObject1 = this.b;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("renderJs directly on GLThread, content:");
            ((StringBuilder)localObject2).append(paramScript.e());
            QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
          }
          paramScript.b();
          localObject1 = b(e());
          if (localObject1 != null)
          {
            localObject1 = ((ApolloRender)localObject1).getSavaWrapper();
            if (localObject1 != null) {
              ((ApolloEngine)localObject1).execScriptString(paramScript.e());
            }
          }
          paramScript.j();
          return;
        }
      }
      ((IRenderRunner)localObject1).runRenderTask(paramScript);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.cmshow.brickengine.apollo.IRenderRunner");
  }
  
  public void a(boolean paramBoolean)
  {
    IRenderService.DefaultImpls.a(this, paramBoolean);
  }
  
  @Nullable
  public IRecordFrameListener b()
  {
    return this.d;
  }
  
  public final void c()
  {
    Object localObject = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("destroy ");
    localStringBuilder.append(this);
    localStringBuilder.append(" for ");
    localStringBuilder.append(this.j.k());
    QLog.i((String)localObject, 1, localStringBuilder.toString());
    if (!this.h) {
      return;
    }
    localObject = b(e());
    if (localObject != null)
    {
      ((ApolloRender)localObject).queueDestroy();
      if ((((ApolloRender)localObject).isOffscreen()) && (this.j.k() == Scene.MEME_PLAYER))
      {
        QLog.w(this.b, 1, "call surfaceDestroyed on destroy MEME_PLAYER RenderService");
        localObject = e();
        if (localObject != null) {
          ((ApolloTextureView)localObject).surfaceDestroyed(null);
        } else {
          throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloTextureView");
        }
      }
    }
    localObject = a(e());
    if (localObject != null) {
      ((ApolloRenderInterfaceImpl)localObject).c();
    }
  }
  
  public final long d()
  {
    if (this.h)
    {
      ICMShowView localICMShowView = e();
      if (localICMShowView != null) {
        return ((IRenderRunner)localICMShowView).getLuaState();
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.cmshow.brickengine.apollo.IRenderRunner");
    }
    return -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.BKRenderService
 * JD-Core Version:    0.7.0.1
 */