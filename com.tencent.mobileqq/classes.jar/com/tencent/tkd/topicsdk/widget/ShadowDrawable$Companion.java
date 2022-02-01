package com.tencent.tkd.topicsdk.widget;

import android.graphics.drawable.Drawable;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/widget/ShadowDrawable$Companion;", "", "()V", "SHAPE_CIRCLE", "", "SHAPE_ROUND", "setShadowDrawable", "", "view", "Landroid/view/View;", "drawable", "Landroid/graphics/drawable/Drawable;", "shapeRadius", "shadowColor", "shadowRadius", "offsetX", "offsetY", "bgColor", "shape", "", "topicsdk-widget_release"}, k=1, mv={1, 1, 16})
public final class ShadowDrawable$Companion
{
  public final void a(@NotNull View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    ShadowDrawable localShadowDrawable = new ShadowDrawable.Builder().f(paramInt1).a(paramInt2).b(paramInt3).c(paramInt4).d(paramInt5).e(paramInt6).a();
    paramView.setLayerType(1, null);
    paramView.setBackgroundDrawable((Drawable)localShadowDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.ShadowDrawable.Companion
 * JD-Core Version:    0.7.0.1
 */