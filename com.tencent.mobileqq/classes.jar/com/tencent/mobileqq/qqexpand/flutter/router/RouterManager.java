package com.tencent.mobileqq.qqexpand.flutter.router;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/flutter/router/RouterManager;", "", "()V", "mIsInitial", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mNativeRouters", "Ljava/util/HashMap;", "", "Lcom/tencent/mobileqq/qqexpand/flutter/router/BaseRouter;", "Lkotlin/collections/HashMap;", "addNativeRouter", "", "addRouter", "router", "getIsRouterInitial", "", "getRouter", "Companion", "qqexpand_impl_release"}, k=1, mv={1, 1, 16})
public final class RouterManager
{
  public static final RouterManager.Companion a = new RouterManager.Companion(null);
  private static final Lazy d = LazyKt.lazy((Function0)RouterManager.Companion.instance.2.INSTANCE);
  private HashMap<String, BaseRouter> b = new HashMap();
  private AtomicBoolean c = new AtomicBoolean(false);
  
  private final void a(BaseRouter paramBaseRouter)
  {
    if (TextUtils.isEmpty((CharSequence)paramBaseRouter.a()))
    {
      QLog.d("RouterManager", 1, "add router name is empty");
      return;
    }
    if (!this.b.containsKey(paramBaseRouter.a())) {
      ((Map)this.b).put(paramBaseRouter.a(), paramBaseRouter);
    }
  }
  
  @JvmStatic
  @NotNull
  public static final RouterManager d()
  {
    return a.a();
  }
  
  @Nullable
  public final BaseRouter a(@Nullable String paramString)
  {
    if (!TextUtils.isEmpty((CharSequence)paramString))
    {
      Map localMap = (Map)this.b;
      if (localMap != null)
      {
        if (localMap.containsKey(paramString)) {
          return (BaseRouter)((Map)this.b).get(paramString);
        }
      }
      else {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
      }
    }
    return null;
  }
  
  public final void a()
  {
    this.c.set(true);
    a((BaseRouter)new ExpandRouter());
  }
  
  public final boolean b()
  {
    return this.c.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.router.RouterManager
 * JD-Core Version:    0.7.0.1
 */