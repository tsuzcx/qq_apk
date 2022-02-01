package com.tencent.xaction.api;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.xaction.api.data.ViewData;
import com.tencent.xaction.impl.XAEngine;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/api/IViewManager;", "", "buildFactory", "Lcom/tencent/xaction/api/IView;", "context", "Landroid/content/Context;", "viewData", "Lcom/tencent/xaction/api/data/ViewData;", "viewLayout", "Landroid/view/ViewGroup;", "engine", "Lcom/tencent/xaction/impl/XAEngine;", "register", "", "key", "", "clazz", "Ljava/lang/Class;", "XActionEngine_release"}, k=1, mv={1, 1, 16})
public abstract interface IViewManager
{
  @Nullable
  public abstract IView a(@NotNull Context paramContext, @NotNull ViewData paramViewData, @Nullable ViewGroup paramViewGroup, @NotNull XAEngine paramXAEngine);
  
  public abstract boolean a(@NotNull String paramString, @NotNull Class<? extends IView> paramClass);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.xaction.api.IViewManager
 * JD-Core Version:    0.7.0.1
 */