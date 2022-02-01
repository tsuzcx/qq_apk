package com.tencent.mobileqq.winkpublish.view.widget;

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
import com.tencent.mobileqq.winkpublish.util.ReflectionUtil;

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
    a();
  }
  
  public ShaderAnimLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public ShaderAnimLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    if (!this.d)
    {
      this.c.setDuration(200L);
      this.c.setInterpolator(new LinearInterpolator());
      this.d = true;
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    this.e.reset();
    this.e.addRect(getWidth() * (1.0F - this.a), 0.0F, getWidth(), getBottom(), Path.Direction.CW);
    try
    {
      paramCanvas.clipPath(this.e, Region.Op.INTERSECT);
    }
    catch (Exception localException)
    {
      label55:
      break label55;
    }
    ReflectionUtil.a(this, 1, null);
    super.dispatchDraw(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.view.widget.ShaderAnimLayout
 * JD-Core Version:    0.7.0.1
 */