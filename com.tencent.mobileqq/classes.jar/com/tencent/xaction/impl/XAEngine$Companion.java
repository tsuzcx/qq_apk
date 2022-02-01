package com.tencent.xaction.impl;

import android.os.Handler;
import android.view.View;
import com.tencent.xaction.api.IMemoryLruCache;
import com.tencent.xaction.api.base.BaseAnim;
import com.tencent.xaction.api.util.GsonAdapter;
import com.tencent.xaction.manager.ViewManager;
import com.tencent.xaction.openapi.api.IPublicRuleManager;
import com.tencent.xaction.openapi.api.ISubscribeNotify;
import com.tencent.xaction.openapi.api.IXAEngine;
import com.tencent.xaction.trigger.BaseTrigger;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/impl/XAEngine$Companion;", "", "()V", "TAG", "", "availClassSize", "", "getAvailClassSize", "()J", "setAvailClassSize", "(J)V", "cache", "Lcom/tencent/xaction/api/IMemoryLruCache;", "threadPoolExecutor", "Ljava/util/concurrent/ExecutorService;", "getThreadPoolExecutor", "()Ljava/util/concurrent/ExecutorService;", "uiHandler", "Landroid/os/Handler;", "getUiHandler", "()Landroid/os/Handler;", "setUiHandler", "(Landroid/os/Handler;)V", "viewManager", "Lcom/tencent/xaction/manager/ViewManager;", "getViewManager", "()Lcom/tencent/xaction/manager/ViewManager;", "setViewManager", "(Lcom/tencent/xaction/manager/ViewManager;)V", "getCache", "pauseAll", "", "registerAnim", "", "name", "clazz", "Ljava/lang/Class;", "Lcom/tencent/xaction/api/base/BaseAnim;", "registerDrawable", "clazzName", "registerTrigger", "Lcom/tencent/xaction/trigger/BaseTrigger;", "resumeAll", "subscribeNotify", "tag", "status", "view", "Landroid/view/View;", "engine", "Lcom/tencent/xaction/openapi/api/IXAEngine;", "XActionCore_release"}, k=1, mv={1, 1, 16})
public final class XAEngine$Companion
{
  @NotNull
  public final ExecutorService a()
  {
    return XAEngine.access$getThreadPoolExecutor$cp();
  }
  
  public final void a(@NotNull String paramString1, @NotNull String paramString2, @NotNull View paramView, @NotNull IXAEngine paramIXAEngine)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "status");
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    Intrinsics.checkParameterIsNotNull(paramIXAEngine, "engine");
    paramIXAEngine = paramIXAEngine.getRuleManager().getRuleValue("$SUBSCRIBE");
    if ((paramIXAEngine instanceof ISubscribeNotify)) {
      ((ISubscribeNotify)paramIXAEngine).notify(paramString1, paramString2, paramView);
    }
  }
  
  @JvmStatic
  public final boolean a(@NotNull String paramString, @NotNull Class<BaseAnim> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    Intrinsics.checkParameterIsNotNull(paramClass, "clazz");
    if (GsonAdapter.a.a().containsKey(paramString)) {
      return false;
    }
    ((Map)GsonAdapter.a.a()).put(paramString, paramClass);
    return true;
  }
  
  @JvmStatic
  public final boolean a(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "name");
    Intrinsics.checkParameterIsNotNull(paramString2, "clazzName");
    if (GsonAdapter.a.c().containsKey(paramString1)) {
      return false;
    }
    ((Map)GsonAdapter.a.c()).put(paramString1, paramString2);
    return true;
  }
  
  public final long b()
  {
    return XAEngine.access$getAvailClassSize$cp();
  }
  
  @JvmStatic
  public final boolean b(@NotNull String paramString, @NotNull Class<BaseTrigger> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    Intrinsics.checkParameterIsNotNull(paramClass, "clazz");
    if (GsonAdapter.a.b().containsKey(paramString)) {
      return false;
    }
    ((Map)GsonAdapter.a.b()).put(paramString, paramClass);
    return true;
  }
  
  @NotNull
  public final Handler c()
  {
    return XAEngine.access$getUiHandler$cp();
  }
  
  @NotNull
  public final ViewManager d()
  {
    return XAEngine.access$getViewManager$cp();
  }
  
  @NotNull
  public final IMemoryLruCache e()
  {
    if (XAEngine.access$getCache$cp() == null) {
      XAEngine.access$setCache$cp((IMemoryLruCache)new MemoryLruCacheImpl(((Companion)this).b()));
    }
    IMemoryLruCache localIMemoryLruCache = XAEngine.access$getCache$cp();
    if (localIMemoryLruCache != null) {
      return localIMemoryLruCache;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.xaction.api.IMemoryLruCache");
  }
  
  @JvmStatic
  public final void f()
  {
    XATimeline.a.a(true);
  }
  
  @JvmStatic
  public final void g()
  {
    XATimeline.a.a(false);
    XATimeline.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.impl.XAEngine.Companion
 * JD-Core Version:    0.7.0.1
 */