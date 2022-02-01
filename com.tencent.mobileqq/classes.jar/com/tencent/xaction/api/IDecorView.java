package com.tencent.xaction.api;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.xaction.openapi.api.IPublicDecorView;
import com.tencent.xaction.openapi.api.IXAEngine;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/api/IDecorView;", "Lcom/tencent/xaction/openapi/api/IPublicDecorView;", "Lcom/tencent/xaction/api/IStyle;", "bindData", "", "destroy", "getProxy", "Landroid/view/View;", "init", "engine", "Lcom/tencent/xaction/openapi/api/IXAEngine;", "viewLayout", "Landroid/view/ViewGroup;", "setProxy", "view", "isStyle", "", "XActionCore_release"}, k=1, mv={1, 1, 16})
public abstract interface IDecorView
  extends IStyle, IPublicDecorView
{
  public abstract void destroy();
  
  @Nullable
  public abstract View getProxy();
  
  public abstract void init(@NotNull IXAEngine paramIXAEngine, @Nullable ViewGroup paramViewGroup);
  
  public abstract void setProxy(@Nullable View paramView, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.api.IDecorView
 * JD-Core Version:    0.7.0.1
 */