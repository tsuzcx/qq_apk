package com.tencent.mobileqq.kandian.base.image;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.view.View;

public class PublicDrawableUtil
{
  public static GradientDrawable a(View paramView, float paramFloat, @ColorInt int paramInt)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    localGradientDrawable.setCornerRadius(paramFloat);
    localGradientDrawable.setColor(paramInt);
    if (paramView != null) {
      a(paramView, localGradientDrawable);
    }
    return localGradientDrawable;
  }
  
  public static GradientDrawable a(View paramView, float paramFloat, @ColorInt int paramInt1, int paramInt2)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    if (paramFloat > 0.0F) {
      localGradientDrawable.setCornerRadius(paramFloat);
    }
    localGradientDrawable.setStroke(paramInt2, paramInt1);
    if (paramView != null) {
      a(paramView, localGradientDrawable);
    }
    return localGradientDrawable;
  }
  
  public static void a(@NonNull View paramView, @NonNull Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT < 16)
    {
      paramView.setBackgroundDrawable(paramDrawable);
      return;
    }
    paramView.setBackground(paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.image.PublicDrawableUtil
 * JD-Core Version:    0.7.0.1
 */