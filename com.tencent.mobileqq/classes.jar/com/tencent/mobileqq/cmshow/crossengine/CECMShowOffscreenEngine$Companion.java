package com.tencent.mobileqq.cmshow.crossengine;

import android.content.Context;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.crossengine.CEApplication;
import com.tencent.crossengine.CEApplication.Builder;
import com.tencent.crossengine.CEJSEventListener;
import com.tencent.crossengine.CELifeCycle;
import com.tencent.crossengine.FrameCallback;
import com.tencent.crossengine.RenderContext;
import com.tencent.crossengine.font.FontPixelsFactory;
import com.tencent.crossengine.log.LogDelegate;
import com.tencent.crossengine.offscreen.OffscreenWorldCallback;
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
  private final CEApplication a()
  {
    Object localObject2 = new CECMShowOffscreenEngine.Companion.genCEApplication.ceLifeCycle.1();
    Object localObject1 = new CECMShowOffscreenEngine.Companion.genCEApplication.jsEventHandler.1();
    CECMShowOffscreenEngine.Companion.genCEApplication.frameCallback.1 local1 = new CECMShowOffscreenEngine.Companion.genCEApplication.frameCallback.1();
    CECMShowOffscreenEngine.Companion.genCEApplication.offscreenCallback.1 local11 = new CECMShowOffscreenEngine.Companion.genCEApplication.offscreenCallback.1();
    localObject2 = CEApplication.Builder.createBuilder().withContext((Context)BaseApplicationImpl.getApplication()).setAssetsPath(ApolloConstant.j).setLifeCycle((CELifeCycle)localObject2).setStartUpWorld("Contents/World/EmptyScene.nda").setLogger((LogDelegate)new CELogger()).setOffscreenMode(true).setFontPixelsFactory((FontPixelsFactory)CECMShowOffscreenEngine.a()).build();
    ((CEApplication)localObject2).setCEJSEventListener((CEJSEventListener)localObject1);
    ((CEApplication)localObject2).setFrameCallback((FrameCallback)local1);
    ((CEApplication)localObject2).setOffscreenWorldCallback((OffscreenWorldCallback)local11);
    ((CEApplication)localObject2).startGame();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("genCEApplication:");
    ((StringBuilder)localObject1).append(localObject2);
    QLog.i("[cmshow][CECMShowOffscreenEngine]", 1, ((StringBuilder)localObject1).toString());
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "application");
    return localObject2;
  }
  
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
  
  private final void a()
  {
    if (CECMShowOffscreenEngine.a() == null) {
      CECMShowOffscreenEngine.a(((Companion)this).a());
    }
    Companion localCompanion = (Companion)this;
    if (localCompanion.a() == null)
    {
      CEApplication localCEApplication = CECMShowOffscreenEngine.a();
      if (localCEApplication == null) {
        Intrinsics.throwNpe();
      }
      localCompanion.a((ICMShowView)localCompanion.a(localCEApplication));
    }
  }
  
  private final void b()
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
    localObject1 = (Lock)CECMShowOffscreenEngine.a();
    ((Lock)localObject1).lock();
    try
    {
      CECMShowOffscreenEngine.a().clear();
      CECMShowOffscreenEngine.a().clear();
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
    return CECMShowOffscreenEngine.a();
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
  
  public final boolean a()
  {
    return CECMShowOffscreenEngine.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.crossengine.CECMShowOffscreenEngine.Companion
 * JD-Core Version:    0.7.0.1
 */