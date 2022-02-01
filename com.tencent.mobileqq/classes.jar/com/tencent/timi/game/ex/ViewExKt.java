package com.tencent.timi.game.ex;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Build.VERSION;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"colorBg", "Landroid/graphics/drawable/GradientDrawable;", "Landroid/view/View;", "colors", "", "", "corner", "leftTop", "", "rightTop", "leftBottom", "rightBottom", "cornerColorBg", "radius", "getLocationXInWindow", "getLocationXOnScreen", "getLocationYInWindow", "getLocationYOnScreen", "leftCircleDrawable", "", "Landroid/widget/TextView;", "size", "color", "removeFromParent", "setOnFocusGetListener", "listener", "Lkotlin/Function1;", "setOnFocusLoseListener", "setVisibility", "isShow", "", "setVisibleOrInvisible", "transformAsBitmap", "Landroid/graphics/Bitmap;", "colorRes", "(Landroid/view/View;Ljava/lang/Integer;)Landroid/graphics/Bitmap;", "timi-game-impl_release"}, k=2, mv={1, 1, 16})
public final class ViewExKt
{
  public static final int a(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "$this$getLocationXOnScreen");
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    return arrayOfInt[0];
  }
  
  @NotNull
  public static final GradientDrawable a(@NotNull GradientDrawable paramGradientDrawable, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    Intrinsics.checkParameterIsNotNull(paramGradientDrawable, "$this$corner");
    paramGradientDrawable.setCornerRadii(new float[] { paramFloat1, paramFloat1, paramFloat2, paramFloat2, paramFloat4, paramFloat4, paramFloat3, paramFloat3 });
    return paramGradientDrawable;
  }
  
  @NotNull
  public static final GradientDrawable a(@NotNull View paramView, int paramInt, @NotNull int... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "$this$cornerColorBg");
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "colors");
    GradientDrawable localGradientDrawable = new GradientDrawable();
    if (paramVarArgs.length > 1)
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        localGradientDrawable.setColors(paramVarArgs);
        paramVarArgs = localGradientDrawable;
      }
      else
      {
        paramVarArgs = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, paramVarArgs);
      }
    }
    else
    {
      localGradientDrawable.setColor(paramVarArgs[0]);
      paramVarArgs = localGradientDrawable;
    }
    paramVarArgs.setCornerRadius(paramInt);
    paramView.setBackgroundDrawable((Drawable)paramVarArgs);
    return paramVarArgs;
  }
  
  @NotNull
  public static final GradientDrawable a(@NotNull View paramView, @NotNull int... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "$this$colorBg");
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "colors");
    GradientDrawable localGradientDrawable = new GradientDrawable();
    if (paramVarArgs.length > 1)
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        localGradientDrawable.setColors(paramVarArgs);
        paramVarArgs = localGradientDrawable;
      }
      else
      {
        paramVarArgs = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, paramVarArgs);
      }
    }
    else
    {
      localGradientDrawable.setColor(paramVarArgs[0]);
      paramVarArgs = localGradientDrawable;
    }
    paramView.setBackgroundDrawable((Drawable)paramVarArgs);
    return paramVarArgs;
  }
  
  public static final void a(@NotNull View paramView, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "$this$setVisibility");
    if (paramBoolean)
    {
      paramView.setVisibility(0);
      return;
    }
    paramView.setVisibility(8);
  }
  
  public static final int b(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "$this$getLocationYOnScreen");
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    return arrayOfInt[1];
  }
  
  public static final int c(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "$this$getLocationXInWindow");
    int[] arrayOfInt = new int[2];
    paramView.getLocationInWindow(arrayOfInt);
    return arrayOfInt[0];
  }
  
  public static final int d(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "$this$getLocationYInWindow");
    int[] arrayOfInt = new int[2];
    paramView.getLocationInWindow(arrayOfInt);
    return arrayOfInt[1];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.ex.ViewExKt
 * JD-Core Version:    0.7.0.1
 */