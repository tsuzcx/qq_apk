package com.tencent.xaction.api.data;

import android.view.ViewGroup;
import com.tencent.xaction.api.IDecorView;
import com.tencent.xaction.api.base.DecorView;
import com.tencent.xaction.impl.XAEngine;
import com.tencent.xaction.view.XAEmptyView;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/api/data/Component$Companion;", "", "()V", "linkComponent", "Lcom/tencent/xaction/api/IDecorView;", "engine", "Lcom/tencent/xaction/impl/XAEngine;", "it", "Lcom/tencent/xaction/api/data/ViewData;", "viewLayout", "Landroid/view/ViewGroup;", "XActionEngine_release"}, k=1, mv={1, 1, 16})
public final class Component$Companion
{
  @Nullable
  public final IDecorView a(@NotNull XAEngine paramXAEngine, @NotNull ViewData paramViewData, @NotNull ViewGroup paramViewGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramXAEngine, "engine");
    Intrinsics.checkParameterIsNotNull(paramViewData, "it");
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "viewLayout");
    Object localObject1 = paramXAEngine.findComponentById(paramViewData.getComptId());
    if (localObject1 != null)
    {
      if (localObject1 == null) {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.xaction.api.data.Component");
      }
    }
    else {
      return null;
    }
    localObject1 = ((Component)localObject1).a();
    ((Component)localObject1).a(paramViewData.getId());
    Object localObject2 = ((Component)localObject1).getStyle();
    if (localObject2 == null) {
      Intrinsics.throwNpe();
    }
    ((ViewData)localObject2).setId(paramViewData.getId());
    localObject2 = new XAEmptyView();
    ((XAEmptyView)localObject2).a().a(((Component)localObject1).a(), true);
    ((XAEmptyView)localObject2).a().a(paramXAEngine, paramViewGroup);
    ((XAEmptyView)localObject2).a().setStyle(paramViewData);
    return (IDecorView)localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.xaction.api.data.Component.Companion
 * JD-Core Version:    0.7.0.1
 */