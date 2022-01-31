package com.tencent.mobileqq.microapp.appbrand.ui;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

final class f$b
  implements f.a
{
  public int a(Object paramObject)
  {
    return ((Scroller)paramObject).getCurrX();
  }
  
  public Object a(Context paramContext, Interpolator paramInterpolator)
  {
    if (paramInterpolator != null) {
      return new Scroller(paramContext, paramInterpolator);
    }
    return new Scroller(paramContext);
  }
  
  public void a(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    ((Scroller)paramObject).startScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  public int b(Object paramObject)
  {
    return ((Scroller)paramObject).getCurrY();
  }
  
  public boolean c(Object paramObject)
  {
    return ((Scroller)paramObject).computeScrollOffset();
  }
  
  public void d(Object paramObject)
  {
    ((Scroller)paramObject).abortAnimation();
  }
  
  public int e(Object paramObject)
  {
    return ((Scroller)paramObject).getFinalX();
  }
  
  public int f(Object paramObject)
  {
    return ((Scroller)paramObject).getFinalY();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.ui.f.b
 * JD-Core Version:    0.7.0.1
 */