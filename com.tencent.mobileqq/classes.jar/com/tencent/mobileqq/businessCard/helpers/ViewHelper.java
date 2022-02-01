package com.tencent.mobileqq.businessCard.helpers;

import android.view.View;

public final class ViewHelper
{
  public static void a(View paramView, float paramFloat)
  {
    if (AnimatorProxy.a)
    {
      AnimatorProxy.a(paramView).a(paramFloat);
      return;
    }
    ViewHelper.Honeycomb.c(paramView, paramFloat);
  }
  
  public static void b(View paramView, float paramFloat)
  {
    if (AnimatorProxy.a)
    {
      AnimatorProxy.a(paramView).d(paramFloat);
      return;
    }
    ViewHelper.Honeycomb.d(paramView, paramFloat);
  }
  
  public static void c(View paramView, float paramFloat)
  {
    if (AnimatorProxy.a)
    {
      AnimatorProxy.a(paramView).e(paramFloat);
      return;
    }
    ViewHelper.Honeycomb.e(paramView, paramFloat);
  }
  
  public static void d(View paramView, float paramFloat)
  {
    if (AnimatorProxy.a)
    {
      AnimatorProxy.a(paramView).b(paramFloat);
      return;
    }
    ViewHelper.Honeycomb.a(paramView, paramFloat);
  }
  
  public static void e(View paramView, float paramFloat)
  {
    if (AnimatorProxy.a)
    {
      AnimatorProxy.a(paramView).c(paramFloat);
      return;
    }
    ViewHelper.Honeycomb.b(paramView, paramFloat);
  }
  
  public static void f(View paramView, float paramFloat)
  {
    if (AnimatorProxy.a)
    {
      AnimatorProxy.a(paramView).g(paramFloat);
      return;
    }
    ViewHelper.Honeycomb.f(paramView, paramFloat);
  }
  
  public static void g(View paramView, float paramFloat)
  {
    if (AnimatorProxy.a)
    {
      AnimatorProxy.a(paramView).h(paramFloat);
      return;
    }
    ViewHelper.Honeycomb.g(paramView, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.helpers.ViewHelper
 * JD-Core Version:    0.7.0.1
 */