package com.tencent.mobileqq.cmshow.brickengine;

import android.util.Pair;
import com.tencent.mobileqq.apollo.config.CmShowWnsUtils;
import com.tencent.mobileqq.apollo.listener.OnApolloViewListener;
import com.tencent.mobileqq.apollo.render.IRenderRunner;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloEngine;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRender;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRenderInterfaceImpl;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloTextureView;
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
  public static final BKRenderService.Companion a;
  private final BKRenderService.apolloViewListener.1 jdField_a_of_type_ComTencentMobileqqCmshowBrickengineBKRenderService$apolloViewListener$1;
  private final EngineContext jdField_a_of_type_ComTencentMobileqqCmshowEngineEngineContext;
  private RenderConfig jdField_a_of_type_ComTencentMobileqqCmshowEngineModelRenderConfig;
  private IRecordFrameListener jdField_a_of_type_ComTencentMobileqqCmshowEngineRenderIRecordFrameListener;
  private ISurfaceStateListener jdField_a_of_type_ComTencentMobileqqCmshowEngineRenderISurfaceStateListener;
  private ITouchListener jdField_a_of_type_ComTencentMobileqqCmshowEngineRenderITouchListener;
  private final String jdField_a_of_type_JavaLangString;
  private final Lazy jdField_a_of_type_KotlinLazy;
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqCmshowBrickengineBKRenderService$Companion = new BKRenderService.Companion(null);
  }
  
  public BKRenderService(@NotNull EngineContext paramEngineContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqCmshowEngineEngineContext = paramEngineContext;
    paramEngineContext = new StringBuilder();
    paramEngineContext.append("[cmshow][BKCMShowEngine][BKRenderService][");
    paramEngineContext.append(this.jdField_a_of_type_ComTencentMobileqqCmshowEngineEngineContext.a());
    paramEngineContext.append(']');
    this.jdField_a_of_type_JavaLangString = paramEngineContext.toString();
    this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineBKRenderService$apolloViewListener$1 = new BKRenderService.apolloViewListener.1(this);
    this.jdField_a_of_type_KotlinLazy = LazyKt.lazy((Function0)new BKRenderService.cmshowView.2(this));
    paramEngineContext = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("create ");
    localStringBuilder.append(this);
    localStringBuilder.append(" for ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqCmshowEngineEngineContext.a());
    QLog.i(paramEngineContext, 1, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentMobileqqCmshowEngineEngineContext.a((IRenderService)this);
  }
  
  private final ApolloRender a(ICMShowView paramICMShowView)
  {
    if ((paramICMShowView instanceof ApolloTextureView)) {
      return ((ApolloTextureView)paramICMShowView).getRender();
    }
    if ((paramICMShowView instanceof ApolloSurfaceView)) {
      return ((ApolloSurfaceView)paramICMShowView).getRender();
    }
    return null;
  }
  
  private final ApolloSurfaceView a()
  {
    ApolloSurfaceView localApolloSurfaceView = new ApolloSurfaceView(this.jdField_a_of_type_ComTencentMobileqqCmshowEngineEngineContext.a(), null, true);
    int i = 0;
    localApolloSurfaceView.mRenderMode = 0;
    localApolloSurfaceView.init((OnApolloViewListener)this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineBKRenderService$apolloViewListener$1, 0);
    RenderConfig localRenderConfig = this.jdField_a_of_type_ComTencentMobileqqCmshowEngineModelRenderConfig;
    if (localRenderConfig != null) {
      i = localRenderConfig.jdField_a_of_type_Int;
    }
    localApolloSurfaceView.setInitHeight(i);
    return localApolloSurfaceView;
  }
  
  private final ApolloTextureView a()
  {
    ApolloTextureView localApolloTextureView = new ApolloTextureView(this.jdField_a_of_type_ComTencentMobileqqCmshowEngineEngineContext.a(), null);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqCmshowEngineModelRenderConfig;
    boolean bool3 = false;
    if (localObject != null) {
      bool1 = ((RenderConfig)localObject).b;
    } else {
      bool1 = false;
    }
    localApolloTextureView.setDestroyOnAsync(bool1);
    localObject = this.jdField_a_of_type_ComTencentMobileqqCmshowEngineModelRenderConfig;
    if (localObject != null)
    {
      localObject = ((RenderConfig)localObject).jdField_a_of_type_ComTencentMobileqqCmshowEngineRenderRenderMode;
      if (localObject != null)
      {
        bool1 = ((RenderMode)localObject).isOffscreen();
        break label82;
      }
    }
    boolean bool1 = false;
    label82:
    int i;
    if (bool1)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqCmshowEngineModelRenderConfig;
      if (localObject != null)
      {
        localObject = ((RenderConfig)localObject).jdField_a_of_type_AndroidUtilPair;
        if (localObject != null)
        {
          localObject = (Integer)((Pair)localObject).first;
          if (localObject != null)
          {
            i = ((Integer)localObject).intValue();
            break label135;
          }
        }
      }
      i = 0;
      label135:
      localObject = this.jdField_a_of_type_ComTencentMobileqqCmshowEngineModelRenderConfig;
      if (localObject != null)
      {
        localObject = ((RenderConfig)localObject).jdField_a_of_type_AndroidUtilPair;
        if (localObject != null)
        {
          localObject = (Integer)((Pair)localObject).second;
          if (localObject != null)
          {
            j = ((Integer)localObject).intValue();
            break label184;
          }
        }
      }
      int j = 0;
      label184:
      localApolloTextureView.setOffscreenSize(i, j);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqCmshowEngineModelRenderConfig;
    if (localObject != null) {
      bool2 = ((RenderConfig)localObject).c;
    } else {
      bool2 = false;
    }
    localApolloTextureView.setDumplicateCreateRenderThread(bool2);
    localObject = this.jdField_a_of_type_ComTencentMobileqqCmshowEngineModelRenderConfig;
    if (localObject != null) {
      i = ((RenderConfig)localObject).jdField_a_of_type_Int;
    } else {
      i = 0;
    }
    localApolloTextureView.setInitHeight(i);
    localObject = this.jdField_a_of_type_ComTencentMobileqqCmshowEngineModelRenderConfig;
    boolean bool2 = bool3;
    if (localObject != null) {
      bool2 = ((RenderConfig)localObject).d;
    }
    localApolloTextureView.mIsDrawerView = bool2;
    localApolloTextureView.init((OnApolloViewListener)this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineBKRenderService$apolloViewListener$1, bool1);
    return localApolloTextureView;
  }
  
  private final ICMShowView b()
  {
    return (ICMShowView)this.jdField_a_of_type_KotlinLazy.getValue();
  }
  
  public final long a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      ICMShowView localICMShowView = b();
      if (localICMShowView != null) {
        return ((IRenderRunner)localICMShowView).getLuaState();
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.apollo.render.IRenderRunner");
    }
    return -1L;
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
    return b();
  }
  
  @Nullable
  public IRecordFrameListener a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqCmshowEngineRenderIRecordFrameListener;
  }
  
  public final void a()
  {
    Object localObject = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("destroy ");
    localStringBuilder.append(this);
    localStringBuilder.append(" for ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqCmshowEngineEngineContext.a());
    QLog.i((String)localObject, 1, localStringBuilder.toString());
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    localObject = a(b());
    if (localObject != null)
    {
      ((ApolloRender)localObject).queueDestroy();
      if ((((ApolloRender)localObject).isOffscreen()) && (this.jdField_a_of_type_ComTencentMobileqqCmshowEngineEngineContext.a() == Scene.MEME_PLAYER))
      {
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "call surfaceDestroyed on destroy MEME_PLAYER RenderService");
        localObject = b();
        if (localObject != null) {
          ((ApolloTextureView)localObject).surfaceDestroyed(null);
        } else {
          throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloTextureView");
        }
      }
    }
    localObject = a(b());
    if (localObject != null) {
      ((ApolloRenderInterfaceImpl)localObject).c();
    }
  }
  
  public final void a(int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setBubbleType error on !hasCreateView");
      return;
    }
    ApolloRender localApolloRender = a(b());
    if (localApolloRender != null) {
      localApolloRender.setBubbleType(paramInt);
    }
  }
  
  public void a(@NotNull RenderConfig paramRenderConfig)
  {
    Intrinsics.checkParameterIsNotNull(paramRenderConfig, "config");
    this.jdField_a_of_type_ComTencentMobileqqCmshowEngineModelRenderConfig = paramRenderConfig;
  }
  
  public void a(@Nullable IRecordFrameListener paramIRecordFrameListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqCmshowEngineRenderIRecordFrameListener = paramIRecordFrameListener;
    if (this.jdField_a_of_type_Boolean)
    {
      paramIRecordFrameListener = a(b());
      if (paramIRecordFrameListener != null) {
        paramIRecordFrameListener.setRecordFrameListener(this.jdField_a_of_type_ComTencentMobileqqCmshowEngineRenderIRecordFrameListener);
      }
    }
  }
  
  public void a(@Nullable ISurfaceStateListener paramISurfaceStateListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqCmshowEngineRenderISurfaceStateListener = paramISurfaceStateListener;
  }
  
  public void a(@Nullable ITouchListener paramITouchListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqCmshowEngineRenderITouchListener = paramITouchListener;
  }
  
  public final void a(@NotNull Script paramScript)
  {
    Intrinsics.checkParameterIsNotNull(paramScript, "script");
    Object localObject2;
    if (!this.jdField_a_of_type_Boolean)
    {
      localObject1 = this.jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("renderJs error on !hasCreateView, script: ");
      ((StringBuilder)localObject2).append(paramScript);
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      return;
    }
    Object localObject1 = b();
    if (localObject1 != null)
    {
      localObject1 = (IRenderRunner)localObject1;
      if (CmShowWnsUtils.y())
      {
        long l = ((IRenderRunner)localObject1).getRenderThreadId();
        localObject2 = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "Thread.currentThread()");
        if ((l == ((Thread)localObject2).getId()) && ((this.jdField_a_of_type_ComTencentMobileqqCmshowEngineEngineContext.a() == EngineState.INITIALIZED) || (this.jdField_a_of_type_ComTencentMobileqqCmshowEngineEngineContext.a() == EngineState.STARTED)))
        {
          if (QLog.isColorLevel())
          {
            localObject1 = this.jdField_a_of_type_JavaLangString;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("renderJs directly on GLThread, content:");
            ((StringBuilder)localObject2).append(paramScript.a());
            QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
          }
          localObject1 = a(b());
          if (localObject1 != null)
          {
            localObject1 = ((ApolloRender)localObject1).getSavaWrapper();
            if (localObject1 != null) {
              ((ApolloEngine)localObject1).execScriptString(paramScript.a());
            }
          }
          return;
        }
      }
      ((IRenderRunner)localObject1).runRenderTask(paramScript.a(), paramScript.a());
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.apollo.render.IRenderRunner");
  }
  
  public void a(boolean paramBoolean)
  {
    IRenderService.DefaultImpls.a(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.BKRenderService
 * JD-Core Version:    0.7.0.1
 */