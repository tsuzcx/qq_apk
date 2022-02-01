package com.tencent.mobileqq.mvvm;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"setBackgroundDrawableCompat", "", "Landroid/view/View;", "background", "Landroid/graphics/drawable/Drawable;", "setOnClickListener", "listener", "Lkotlin/Function0;", "AQQLiteApp_release"}, k=2, mv={1, 1, 16})
public final class ViewExtKt
{
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.mvvm.ViewExtKt
 * JD-Core Version:    0.7.0.1
 */