package com.tencent.mobileqq.cmshow.crossengine;

import android.content.Context;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.crossengine.CEApplication;
import com.tencent.crossengine.CEApplicationBuilder;
import com.tencent.crossengine.CEJSEventListener;
import com.tencent.crossengine.CELifeCycle;
import com.tencent.crossengine.FrameCallback;
import com.tencent.crossengine.RenderContext;
import com.tencent.crossengine.font.FontPixelsFactory;
import com.tencent.crossengine.log.LogDelegate;
import com.tencent.crossengine.offscreen.OffscreenWorldCallback;
import com.tencent.mobileqq.apollo.config.CmShowWnsUtils;
import com.tencent.mobileqq.apollo.listener.OnApolloViewListener;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.CrossEngineResManager.LoadListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.cmshow.crossengine.util.CELogger;
import com.tencent.mobileqq.cmshow.engine.EngineHelper;
import com.tencent.mobileqq.cmshow.engine.render.ICMShowView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/crossengine/CECMShowOffscreenEngine$Companion;", "", "()V", "TAG_PRE", "", "ceApplication", "Lcom/tencent/crossengine/CEApplication;", "ceFontPixelsFactory", "Lcom/tencent/mobileqq/cmshow/crossengine/util/CEFontPixelsFactory;", "ceInit", "", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "onScreenRenderView", "Lcom/tencent/mobileqq/cmshow/engine/render/ICMShowView;", "getOnScreenRenderView", "()Lcom/tencent/mobileqq/cmshow/engine/render/ICMShowView;", "setOnScreenRenderView", "(Lcom/tencent/mobileqq/cmshow/engine/render/ICMShowView;)V", "renderServiceMap", "", "Lcom/tencent/mobileqq/cmshow/crossengine/CERenderService;", "worldMap", "", "Lcom/tencent/mobileqq/cmshow/crossengine/CECMShowOffscreenEngine;", "genCEApplication", "genOnScreenView", "Lcom/tencent/mobileqq/cmshow/crossengine/CECMShowView;", "ceApp", "handleOnGameEnd", "", "initCEApplicationAndOnScreenView", "isEngineInited", "tryInitCEApplication", "doAfterDone", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "success", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CECMShowOffscreenEngine$Companion
{
  private final CECMShowView a(CEApplication paramCEApplication)
  {
    Object localObject = BaseApplicationImpl.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplicationImpl.getApplication()");
    localObject = (Context)localObject;
    RenderContext localRenderContext = paramCEApplication.getRenderContext();
    Intrinsics.checkExpressionValueIsNotNull(localRenderContext, "ceApp.renderContext");
    paramCEApplication = paramCEApplication.getTouchProcessor();
    Intrinsics.checkExpressionValueIsNotNull(paramCEApplication, "ceApp.touchProcessor");
    paramCEApplication = new CECMShowView((Context)localObject, localRenderContext, paramCEApplication, (OnApolloViewListener)new CECMShowOffscreenEngine.Companion.genOnScreenView.view.1());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("genOnScreenView:");
    ((StringBuilder)localObject).append(paramCEApplication);
    QLog.i("[cmshow][CECMShowOffscreenEngine]", 1, ((StringBuilder)localObject).toString());
    return paramCEApplication;
  }
  
  private final void c()
  {
    if (CECMShowOffscreenEngine.d() == null) {
      CECMShowOffscreenEngine.a(((Companion)this).d());
    }
    Companion localCompanion = (Companion)this;
    if (localCompanion.a() == null)
    {
      CEApplication localCEApplication = CECMShowOffscreenEngine.d();
      if (localCEApplication == null) {
        Intrinsics.throwNpe();
      }
      localCompanion.a((ICMShowView)localCompanion.a(localCEApplication));
    }
  }
  
  private final CEApplication d()
  {
    Object localObject = new CECMShowOffscreenEngine.Companion.genCEApplication.ceLifeCycle.1();
    CECMShowOffscreenEngine.Companion.genCEApplication.jsEventHandler.1 local1 = new CECMShowOffscreenEngine.Companion.genCEApplication.jsEventHandler.1();
    CECMShowOffscreenEngine.Companion.genCEApplication.frameCallback.1 local11 = new CECMShowOffscreenEngine.Companion.genCEApplication.frameCallback.1();
    CECMShowOffscreenEngine.Companion.genCEApplication.offscreenCallback.1 local12 = new CECMShowOffscreenEngine.Companion.genCEApplication.offscreenCallback.1();
    localObject = CEApplicationBuilder.createBuilder().withContext((Context)BaseApplicationImpl.getApplication()).setAssetsPath(ApolloConstant.k).setLifeCycle((CELifeCycle)localObject).setStartUpWorld("Contents/World/EmptyScene.nda").setLogger((LogDelegate)new CELogger()).setOffscreenMode(true).setFontPixelsFactory((FontPixelsFactory)CECMShowOffscreenEngine.o()).setEnableGPUSkinning(false).build();
    ((CEApplication)localObject).setCEJSEventListener((CEJSEventListener)local1);
    ((CEApplication)localObject).setFrameCallback((FrameCallback)local11);
    ((CEApplication)localObject).setOffscreenWorldCallback((OffscreenWorldCallback)local12);
    ((CEApplication)localObject).setEnableGPUSkinning(false);
    boolean bool = CmShowWnsUtils.al();
    ((CEApplication)localObject).setOptimizeSpineUpdate(bool);
    try
    {
      ((CEApplication)localObject).startGame();
    }
    catch (Throwable localThrowable)
    {
      QLog.e("[cmshow][CECMShowOffscreenEngine]", 1, "genCEApplication error", localThrowable);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("genCEApplication:");
    localStringBuilder.append(localObject);
    localStringBuilder.append(", ");
    localStringBuilder.append("optimizeSpineUpdate:");
    localStringBuilder.append(bool);
    QLog.i("[cmshow][CECMShowOffscreenEngine]", 1, localStringBuilder.toString());
    Intrinsics.checkExpressionValueIsNotNull(localObject, "application");
    return localObject;
  }
  
  private final void e()
  {
    CECMShowOffscreenEngine.a(false);
    Object localObject2 = (Companion)this;
    Object localObject1 = ((Companion)localObject2).a();
    if (localObject1 != null) {
      localObject1 = ((ICMShowView)localObject1).getView();
    } else {
      localObject1 = null;
    }
    ThreadManager.getUIHandler().post((Runnable)new CECMShowOffscreenEngine.Companion.handleOnGameEnd.1((View)localObject1));
    CECMShowOffscreenEngine.a((CEApplication)null);
    ((Companion)localObject2).a((ICMShowView)null);
    localObject1 = (Lock)CECMShowOffscreenEngine.p();
    ((Lock)localObject1).lock();
    try
    {
      CECMShowOffscreenEngine.h().clear();
      CECMShowOffscreenEngine.n().clear();
      localObject2 = Unit.INSTANCE;
      return;
    }
    finally
    {
      ((Lock)localObject1).unlock();
    }
  }
  
  @Nullable
  public final ICMShowView a()
  {
    return CECMShowOffscreenEngine.b();
  }
  
  public final void a(@Nullable ICMShowView paramICMShowView)
  {
    CECMShowOffscreenEngine.a(paramICMShowView);
  }
  
  public final void a(@NotNull Function2<? super Boolean, ? super CEApplication, Unit> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction2, "doAfterDone");
    if (CEEngineHelper.a.a())
    {
      EngineHelper.a.a((Function0)new CECMShowOffscreenEngine.Companion.tryInitCEApplication.1(paramFunction2));
      return;
    }
    CEEngineHelper.a.a((CrossEngineResManager.LoadListener)new CECMShowOffscreenEngine.Companion.tryInitCEApplication.2(paramFunction2));
  }
  
  public final boolean b()
  {
    return CECMShowOffscreenEngine.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.crossengine.CECMShowOffscreenEngine.Companion
 * JD-Core Version:    0.7.0.1
 */