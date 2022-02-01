package com.tencent.xaction.impl;

import com.tencent.xaction.api.IMemoryLruCache;
import com.tencent.xaction.api.IView;
import com.tencent.xaction.api.IViewManager;
import com.tencent.xaction.api.base.BaseAnim;
import com.tencent.xaction.api.base.DecorDrawableState;
import com.tencent.xaction.api.util.GsonAdapter;
import com.tencent.xaction.trigger.BaseTrigger;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/impl/XAEngine$Companion;", "", "()V", "TAG", "", "availClassSize", "", "getAvailClassSize", "()J", "setAvailClassSize", "(J)V", "cache", "Lcom/tencent/xaction/api/IMemoryLruCache;", "threadPoolExecutor", "Ljava/util/concurrent/ExecutorService;", "getThreadPoolExecutor", "()Ljava/util/concurrent/ExecutorService;", "viewManager", "Lcom/tencent/xaction/api/IViewManager;", "getViewManager", "()Lcom/tencent/xaction/api/IViewManager;", "setViewManager", "(Lcom/tencent/xaction/api/IViewManager;)V", "getCache", "pauseAll", "", "registerAnim", "", "name", "clazz", "Ljava/lang/Class;", "Lcom/tencent/xaction/api/base/BaseAnim;", "registerDrawable", "Lcom/tencent/xaction/api/base/DecorDrawableState;", "registerTrigger", "Lcom/tencent/xaction/trigger/BaseTrigger;", "registerView", "Lcom/tencent/xaction/api/IView;", "resumeAll", "XActionEngine_release"}, k=1, mv={1, 1, 16})
public final class XAEngine$Companion
{
  public final long a()
  {
    return XAEngine.access$getAvailClassSize$cp();
  }
  
  @NotNull
  public final IMemoryLruCache a()
  {
    if (XAEngine.access$getCache$cp() == null) {
      XAEngine.access$setCache$cp((IMemoryLruCache)new MemoryLruCacheImpl(((Companion)this).a()));
    }
    IMemoryLruCache localIMemoryLruCache = XAEngine.access$getCache$cp();
    if (localIMemoryLruCache == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.xaction.api.IMemoryLruCache");
    }
    return localIMemoryLruCache;
  }
  
  @NotNull
  public final IViewManager a()
  {
    return XAEngine.access$getViewManager$cp();
  }
  
  @NotNull
  public final ExecutorService a()
  {
    return XAEngine.access$getThreadPoolExecutor$cp();
  }
  
  @JvmStatic
  public final void a()
  {
    XATimeline.a.a(true);
  }
  
  @JvmStatic
  public final boolean a(@NotNull String paramString, @NotNull Class<? extends IView> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    Intrinsics.checkParameterIsNotNull(paramClass, "clazz");
    return ((Companion)this).a().a(paramString, paramClass);
  }
  
  @JvmStatic
  public final void b()
  {
    XATimeline.a.a(false);
    XATimeline.a.a();
  }
  
  @JvmStatic
  public final boolean b(@NotNull String paramString, @NotNull Class<BaseAnim> paramClass)
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
  public final boolean c(@NotNull String paramString, @NotNull Class<BaseTrigger> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    Intrinsics.checkParameterIsNotNull(paramClass, "clazz");
    if (GsonAdapter.a.b().containsKey(paramString)) {
      return false;
    }
    ((Map)GsonAdapter.a.b()).put(paramString, paramClass);
    return true;
  }
  
  @JvmStatic
  public final boolean d(@NotNull String paramString, @NotNull Class<? extends DecorDrawableState> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    Intrinsics.checkParameterIsNotNull(paramClass, "clazz");
    if (GsonAdapter.a.c().containsKey(paramString)) {
      return false;
    }
    ((Map)GsonAdapter.a.c()).put(paramString, paramClass);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.xaction.impl.XAEngine.Companion
 * JD-Core Version:    0.7.0.1
 */