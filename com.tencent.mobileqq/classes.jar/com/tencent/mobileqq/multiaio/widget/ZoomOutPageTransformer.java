package com.tencent.mobileqq.multiaio.widget;

import android.support.annotation.NonNull;
import android.view.View;

public class ZoomOutPageTransformer
  implements MultiAIOBaseViewPager.PageTransformer
{
  public static float a = 0.85F;
  private static float b = 1.0F;
  private static float c = 0.75F;
  private float d = 3.4028235E+38F;
  private float e = 3.4028235E+38F;
  
  public void a(@NonNull View paramView, float paramFloat)
  {
    paramView.getWidth();
    paramView.getHeight();
    Object localObject1 = (MultiAIOBaseViewPager)paramView.getParent();
    int i = ((MultiAIOBaseViewPager)localObject1).getMeasuredWidth() - ((MultiAIOBaseViewPager)localObject1).getPaddingLeft() - ((MultiAIOBaseViewPager)localObject1).getPaddingRight();
    float f2 = ((MultiAIOBaseViewPager)localObject1).getPaddingLeft();
    float f1 = i;
    f2 /= f1;
    float f3 = (((MultiAIOBaseViewPager)localObject1).getPaddingLeft() - i - ((MultiAIOBaseViewPager)localObject1).b()) / f1;
    f1 = (((MultiAIOBaseViewPager)localObject1).getPaddingLeft() + i + ((MultiAIOBaseViewPager)localObject1).b()) / f1;
    if (paramFloat < f3)
    {
      f1 = this.d;
      paramFloat = this.e;
    }
    else if (paramFloat <= f1)
    {
      paramFloat = Math.abs(paramFloat - f2);
      double d1 = a;
      double d2 = paramFloat;
      Double.isNaN(d2);
      d2 *= 1.570796326794897D;
      double d3 = Math.cos(d2);
      double d4 = b - a;
      Double.isNaN(d4);
      Double.isNaN(d1);
      f1 = (float)(d1 + d3 * d4);
      this.d = Math.min(f1, this.d);
      d1 = c;
      d2 = Math.cos(d2);
      d3 = 1.0F - c;
      Double.isNaN(d3);
      Double.isNaN(d1);
      paramFloat = (float)(d1 + d2 * d3);
      this.e = Math.min(paramFloat, this.e);
    }
    else
    {
      f1 = this.d;
      paramFloat = this.e;
    }
    paramView.setScaleX(f1);
    paramView.setScaleY(f1);
    Object localObject2 = paramView.getTag(2131371609);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = paramView.findViewById(2131371609);
      if (localObject1 == null) {
        return;
      }
      paramView.setTag(2131371609, localObject1);
    }
    paramView = (View)localObject1;
    paramView.setAlpha(1.0F - paramFloat);
    paramView.setBackgroundColor(-16777216);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.widget.ZoomOutPageTransformer
 * JD-Core Version:    0.7.0.1
 */