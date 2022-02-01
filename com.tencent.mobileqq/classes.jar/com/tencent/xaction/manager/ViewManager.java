package com.tencent.xaction.manager;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.xaction.api.IDecorView;
import com.tencent.xaction.api.IView;
import com.tencent.xaction.api.IViewManager;
import com.tencent.xaction.api.data.ViewData;
import com.tencent.xaction.impl.XAEngine;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/manager/ViewManager;", "Lcom/tencent/xaction/api/IViewManager;", "()V", "viewMap", "Ljava/util/HashMap;", "", "Ljava/lang/Class;", "Lcom/tencent/xaction/api/IView;", "Lkotlin/collections/HashMap;", "buildFactory", "context", "Landroid/content/Context;", "viewData", "Lcom/tencent/xaction/api/data/ViewData;", "viewLayout", "Landroid/view/ViewGroup;", "engine", "Lcom/tencent/xaction/impl/XAEngine;", "register", "", "key", "clazz", "XActionEngine_release"}, k=1, mv={1, 1, 16})
public final class ViewManager
  implements IViewManager
{
  private final HashMap<String, Class<? extends IView>> a = new HashMap();
  
  @Nullable
  public IView a(@NotNull Context paramContext, @NotNull ViewData paramViewData, @Nullable ViewGroup paramViewGroup, @NotNull XAEngine paramXAEngine)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramViewData, "viewData");
    Intrinsics.checkParameterIsNotNull(paramXAEngine, "engine");
    paramViewData = (Class)this.a.get(paramViewData.getType());
    if (paramViewData != null)
    {
      paramViewData = paramViewData.getDeclaredConstructor(new Class[] { Context.class });
      Intrinsics.checkExpressionValueIsNotNull(paramViewData, "clazz.getDeclaredConstru…a\n            )\n        )");
      paramContext = paramViewData.newInstance(new Object[] { paramContext });
      if (paramContext == null) {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.xaction.api.IView");
      }
    }
    else
    {
      return null;
    }
    paramContext = (IView)paramContext;
    paramContext.a().a(paramXAEngine, paramViewGroup);
    return paramContext;
  }
  
  public boolean a(@NotNull String paramString, @NotNull Class<? extends IView> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    Intrinsics.checkParameterIsNotNull(paramClass, "clazz");
    if (this.a.containsKey(paramString)) {
      return false;
    }
    this.a.put(paramString, paramClass);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.xaction.manager.ViewManager
 * JD-Core Version:    0.7.0.1
 */