package com.tencent.xaction.view;

import android.view.ViewGroup;
import com.tencent.xaction.api.IView;
import com.tencent.xaction.api.base.DecorView;
import com.tencent.xaction.api.data.ViewData;
import com.tencent.xaction.impl.XAEngine;
import com.tencent.xaction.openapi.api.IXAEngine;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/view/Component$Companion;", "", "()V", "linkComponent", "Lcom/tencent/xaction/api/IView;", "engine", "Lcom/tencent/xaction/impl/XAEngine;", "viewData", "Lcom/tencent/xaction/api/data/ViewData;", "viewLayout", "Landroid/view/ViewGroup;", "XActionCore_release"}, k=1, mv={1, 1, 16})
public final class Component$Companion
{
  @Nullable
  public final IView a(@NotNull XAEngine paramXAEngine, @NotNull ViewData paramViewData, @NotNull ViewGroup paramViewGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramXAEngine, "engine");
    Intrinsics.checkParameterIsNotNull(paramViewData, "viewData");
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "viewLayout");
    Component localComponent = paramXAEngine.findComponentById(paramViewData.getComptId());
    if (localComponent != null)
    {
      localComponent = localComponent.clone();
      Object localObject = localComponent.getDecor();
      if (localObject != null)
      {
        localObject = (DecorView)localObject;
        ((DecorView)localObject).a(true);
        ((DecorView)localObject).setStyle(paramViewData);
        ((DecorView)localObject).a((IXAEngine)paramXAEngine, paramViewGroup);
        ((DecorView)localObject).a(((DecorView)localObject).b(), true);
        return (IView)localComponent;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.xaction.api.base.DecorView");
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.view.Component.Companion
 * JD-Core Version:    0.7.0.1
 */