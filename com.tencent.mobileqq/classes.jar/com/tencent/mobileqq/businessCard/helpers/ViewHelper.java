package com.tencent.mobileqq.businessCard.helpers;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.View;
import aphr;

public final class ViewHelper
{
  public static void computeRect(RectF paramRectF, View paramView)
  {
    if (aphr.a) {
      aphr.a(paramView).a(paramRectF, paramView);
    }
  }
  
  public static float getAlpha(View paramView)
  {
    if (aphr.a) {
      return aphr.a(paramView).a();
    }
    return ViewHelper.Honeycomb.getAlpha(paramView);
  }
  
  public static Matrix getMatrix(View paramView)
  {
    if (aphr.a) {
      return aphr.a(paramView).a();
    }
    return ViewHelper.Honeycomb.getMatrix(paramView);
  }
  
  public static float getPivotX(View paramView)
  {
    if (aphr.a) {
      return aphr.a(paramView).b();
    }
    return ViewHelper.Honeycomb.getPivotX(paramView);
  }
  
  public static float getPivotY(View paramView)
  {
    if (aphr.a) {
      return aphr.a(paramView).c();
    }
    return ViewHelper.Honeycomb.getPivotY(paramView);
  }
  
  public static float getScaleX(View paramView)
  {
    if (aphr.a) {
      return aphr.a(paramView).d();
    }
    return ViewHelper.Honeycomb.getScaleX(paramView);
  }
  
  public static float getScaleY(View paramView)
  {
    if (aphr.a) {
      return aphr.a(paramView).e();
    }
    return ViewHelper.Honeycomb.getScaleY(paramView);
  }
  
  public static float getScrollX(View paramView)
  {
    if (aphr.a) {
      return aphr.a(paramView).a();
    }
    return ViewHelper.Honeycomb.getScrollX(paramView);
  }
  
  public static float getScrollY(View paramView)
  {
    if (aphr.a) {
      return aphr.a(paramView).b();
    }
    return ViewHelper.Honeycomb.getScrollY(paramView);
  }
  
  public static float getTranslationX(View paramView)
  {
    if (aphr.a) {
      return aphr.a(paramView).f();
    }
    return ViewHelper.Honeycomb.getTranslationX(paramView);
  }
  
  public static float getTranslationY(View paramView)
  {
    if (aphr.a) {
      return aphr.a(paramView).g();
    }
    return ViewHelper.Honeycomb.getTranslationY(paramView);
  }
  
  public static float getX(View paramView)
  {
    if (aphr.a) {
      return aphr.a(paramView).h();
    }
    return ViewHelper.Honeycomb.getX(paramView);
  }
  
  public static void setAlpha(View paramView, float paramFloat)
  {
    if (aphr.a)
    {
      aphr.a(paramView).a(paramFloat);
      return;
    }
    ViewHelper.Honeycomb.setAlpha(paramView, paramFloat);
  }
  
  public static void setPivotX(View paramView, float paramFloat)
  {
    if (aphr.a)
    {
      aphr.a(paramView).b(paramFloat);
      return;
    }
    ViewHelper.Honeycomb.setPivotX(paramView, paramFloat);
  }
  
  public static void setPivotY(View paramView, float paramFloat)
  {
    if (aphr.a)
    {
      aphr.a(paramView).c(paramFloat);
      return;
    }
    ViewHelper.Honeycomb.setPivotY(paramView, paramFloat);
  }
  
  public static void setScaleX(View paramView, float paramFloat)
  {
    if (aphr.a)
    {
      aphr.a(paramView).d(paramFloat);
      return;
    }
    ViewHelper.Honeycomb.setScaleX(paramView, paramFloat);
  }
  
  public static void setScaleY(View paramView, float paramFloat)
  {
    if (aphr.a)
    {
      aphr.a(paramView).e(paramFloat);
      return;
    }
    ViewHelper.Honeycomb.setScaleY(paramView, paramFloat);
  }
  
  public static void setScrollX(View paramView, int paramInt)
  {
    if (aphr.a)
    {
      aphr.a(paramView).a(paramInt);
      return;
    }
    ViewHelper.Honeycomb.setScrollX(paramView, paramInt);
  }
  
  public static void setScrollY(View paramView, int paramInt)
  {
    if (aphr.a)
    {
      aphr.a(paramView).b(paramInt);
      return;
    }
    ViewHelper.Honeycomb.setScrollY(paramView, paramInt);
  }
  
  public static void setTranslationX(View paramView, float paramFloat)
  {
    if (aphr.a)
    {
      aphr.a(paramView).f(paramFloat);
      return;
    }
    ViewHelper.Honeycomb.setTranslationX(paramView, paramFloat);
  }
  
  public static void setTranslationY(View paramView, float paramFloat)
  {
    if (aphr.a)
    {
      aphr.a(paramView).g(paramFloat);
      return;
    }
    ViewHelper.Honeycomb.setTranslationY(paramView, paramFloat);
  }
  
  public static void setX(View paramView, float paramFloat)
  {
    if (aphr.a)
    {
      aphr.a(paramView).h(paramFloat);
      return;
    }
    ViewHelper.Honeycomb.setX(paramView, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.helpers.ViewHelper
 * JD-Core Version:    0.7.0.1
 */