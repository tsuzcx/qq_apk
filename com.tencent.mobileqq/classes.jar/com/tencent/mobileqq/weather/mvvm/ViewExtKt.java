package com.tencent.mobileqq.weather.mvvm;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.DrawableRes;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"getDrawableCompat", "Landroid/graphics/drawable/Drawable;", "Landroid/content/res/Resources;", "id", "", "setBackgroundDrawableCompat", "", "Landroid/view/View;", "background", "qq-weather-impl_release"}, k=2, mv={1, 1, 16})
public final class ViewExtKt
{
  @NotNull
  public static final Drawable a(@NotNull Resources paramResources, @DrawableRes int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramResources, "$this$getDrawableCompat");
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramResources = paramResources.getDrawable(paramInt, null);
      Intrinsics.checkExpressionValueIsNotNull(paramResources, "getDrawable(id, null)");
      return paramResources;
    }
    paramResources = paramResources.getDrawable(paramInt);
    Intrinsics.checkExpressionValueIsNotNull(paramResources, "getDrawable(id)");
    return paramResources;
  }
  
  public static final void a(@NotNull View paramView, @Nullable Drawable paramDrawable)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "$this$setBackgroundDrawableCompat");
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramView.setBackground(paramDrawable);
      return;
    }
    paramView.setBackgroundDrawable(paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.weather.mvvm.ViewExtKt
 * JD-Core Version:    0.7.0.1
 */