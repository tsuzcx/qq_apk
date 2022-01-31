package com.tencent.mobileqq.businessCard.helpers;

import abvp;
import android.graphics.RectF;
import android.view.View;

public final class ViewHelper
{
  public static float a(View paramView)
  {
    if (AnimatorProxy.a) {
      return AnimatorProxy.a(paramView).a();
    }
    return abvp.a(paramView);
  }
  
  public static void a(RectF paramRectF, View paramView)
  {
    if (AnimatorProxy.a) {
      AnimatorProxy.a(paramView).a(paramRectF, paramView);
    }
  }
  
  public static void a(View paramView, float paramFloat)
  {
    if (AnimatorProxy.a)
    {
      AnimatorProxy.a(paramView).a(paramFloat);
      return;
    }
    abvp.c(paramView, paramFloat);
  }
  
  public static float b(View paramView)
  {
    if (AnimatorProxy.a) {
      return AnimatorProxy.a(paramView).b();
    }
    return abvp.b(paramView);
  }
  
  public static void b(View paramView, float paramFloat)
  {
    if (AnimatorProxy.a)
    {
      AnimatorProxy.a(paramView).d(paramFloat);
      return;
    }
    abvp.d(paramView, paramFloat);
  }
  
  public static void c(View paramView, float paramFloat)
  {
    if (AnimatorProxy.a)
    {
      AnimatorProxy.a(paramView).e(paramFloat);
      return;
    }
    abvp.e(paramView, paramFloat);
  }
  
  public static void d(View paramView, float paramFloat)
  {
    if (AnimatorProxy.a)
    {
      AnimatorProxy.a(paramView).b(paramFloat);
      return;
    }
    abvp.a(paramView, paramFloat);
  }
  
  public static void e(View paramView, float paramFloat)
  {
    if (AnimatorProxy.a)
    {
      AnimatorProxy.a(paramView).c(paramFloat);
      return;
    }
    abvp.b(paramView, paramFloat);
  }
  
  public static void f(View paramView, float paramFloat)
  {
    if (AnimatorProxy.a)
    {
      AnimatorProxy.a(paramView).f(paramFloat);
      return;
    }
    abvp.f(paramView, paramFloat);
  }
  
  public static void g(View paramView, float paramFloat)
  {
    if (AnimatorProxy.a)
    {
      AnimatorProxy.a(paramView).g(paramFloat);
      return;
    }
    abvp.g(paramView, paramFloat);
  }
  
  public static void h(View paramView, float paramFloat)
  {
    if (AnimatorProxy.a)
    {
      AnimatorProxy.a(paramView).h(paramFloat);
      return;
    }
    abvp.h(paramView, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.helpers.ViewHelper
 * JD-Core Version:    0.7.0.1
 */