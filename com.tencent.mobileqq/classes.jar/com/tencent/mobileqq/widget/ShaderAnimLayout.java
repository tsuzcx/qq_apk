package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Region.Op;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;

public class ShaderAnimLayout
  extends RelativeLayout
{
  float a = 0.0F;
  boolean b = false;
  private Animation c = new ShaderAnimLayout.1(this);
  private boolean d = false;
  private Path e = new Path();
  private Animation.AnimationListener f = new ShaderAnimLayout.2(this);
  
  public ShaderAnimLayout(Context paramContext)
  {
    super(paramContext);
    h();
  }
  
  public ShaderAnimLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    h();
  }
  
  public ShaderAnimLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    h();
  }
  
  private void h()
  {
    if (!this.d)
    {
      this.c.setDuration(200L);
      this.c.setInterpolator(new LinearInterpolator());
      this.d = true;
    }
  }
  
  public void a()
  {
    if (getVisibility() != 0)
    {
      this.b = false;
      this.c.setAnimationListener(null);
      clearAnimation();
      setVisibility(0);
      startAnimation(this.c);
    }
  }
  
  public void b()
  {
    this.b = false;
    this.c.setAnimationListener(null);
    clearAnimation();
    setVisibility(0);
    startAnimation(this.c);
  }
  
  public void c()
  {
    clearAnimation();
    this.c.setAnimationListener(null);
    this.b = false;
    setVisibility(0);
    this.a = 1.0F;
  }
  
  public void d()
  {
    clearAnimation();
    this.c.setAnimationListener(null);
    this.b = true;
    setVisibility(8);
    this.a = 0.0F;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    this.e.reset();
    this.e.addRect(getWidth() * (1.0F - this.a), 0.0F, getWidth(), getBottom(), Path.Direction.CW);
    paramCanvas.clipPath(this.e, Region.Op.INTERSECT);
    super.dispatchDraw(paramCanvas);
  }
  
  public void e()
  {
    if (getVisibility() == 0)
    {
      this.b = true;
      clearAnimation();
      this.c.setAnimationListener(this.f);
      startAnimation(this.c);
    }
  }
  
  public void f()
  {
    this.b = true;
    clearAnimation();
    this.c.setAnimationListener(this.f);
    startAnimation(this.c);
  }
  
  public void g()
  {
    setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ShaderAnimLayout
 * JD-Core Version:    0.7.0.1
 */