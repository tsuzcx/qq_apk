package com.tencent.xaction.api;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.xaction.impl.XAEngine;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/api/IDecorView;", "Lcom/tencent/xaction/api/IStyle;", "drawable", "Landroid/graphics/drawable/Drawable;", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "setDrawable", "(Landroid/graphics/drawable/Drawable;)V", "getProxy", "Landroid/view/View;", "init", "", "engine", "Lcom/tencent/xaction/impl/XAEngine;", "viewLayout", "Landroid/view/ViewGroup;", "setProxy", "view", "isStyle", "", "XActionEngine_release"}, k=1, mv={1, 1, 16})
public abstract interface IDecorView
  extends IStyle
{
  @Nullable
  public abstract Drawable a();
  
  @Nullable
  public abstract View a();
  
  public abstract void a(@Nullable Drawable paramDrawable);
  
  public abstract void a(@Nullable View paramView, boolean paramBoolean);
  
  public abstract void a(@NotNull XAEngine paramXAEngine, @Nullable ViewGroup paramViewGroup);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.xaction.api.IDecorView
 * JD-Core Version:    0.7.0.1
 */