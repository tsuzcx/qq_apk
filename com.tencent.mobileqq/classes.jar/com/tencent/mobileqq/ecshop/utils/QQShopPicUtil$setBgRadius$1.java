package com.tencent.mobileqq.ecshop.utils;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/ecshop/utils/QQShopPicUtil$setBgRadius$1", "Landroid/view/ViewOutlineProvider;", "getOutline", "", "view", "Landroid/view/View;", "outline", "Landroid/graphics/Outline;", "qqshop-feature-impl_release"}, k=1, mv={1, 1, 16})
public final class QQShopPicUtil$setBgRadius$1
  extends ViewOutlineProvider
{
  QQShopPicUtil$setBgRadius$1(float paramFloat) {}
  
  public void getOutline(@NotNull View paramView, @NotNull Outline paramOutline)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    Intrinsics.checkParameterIsNotNull(paramOutline, "outline");
    paramOutline.setRoundRect(0, 0, paramView.getWidth(), paramView.getHeight(), this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.utils.QQShopPicUtil.setBgRadius.1
 * JD-Core Version:    0.7.0.1
 */