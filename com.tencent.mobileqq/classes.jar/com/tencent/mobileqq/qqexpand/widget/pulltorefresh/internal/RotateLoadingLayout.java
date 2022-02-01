package com.tencent.mobileqq.qqexpand.widget.pulltorefresh.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mobileqq.qqexpand.api.R.styleable;
import com.tencent.mobileqq.qqexpand.widget.pulltorefresh.PullToRefreshBase.Mode;
import com.tencent.mobileqq.qqexpand.widget.pulltorefresh.PullToRefreshBase.Orientation;

public class RotateLoadingLayout
  extends LoadingLayout
{
  private final Animation f;
  private final Matrix g;
  private final boolean h;
  private float i;
  private float j;
  
  public RotateLoadingLayout(Context paramContext, PullToRefreshBase.Mode paramMode, PullToRefreshBase.Orientation paramOrientation, TypedArray paramTypedArray)
  {
    super(paramContext, paramMode, paramOrientation, paramTypedArray);
    this.h = paramTypedArray.getBoolean(R.styleable.bi, true);
    this.b.setScaleType(ImageView.ScaleType.MATRIX);
    this.g = new Matrix();
    this.b.setImageMatrix(this.g);
    this.f = new RotateAnimation(0.0F, 720.0F, 1, 0.5F, 1, 0.5F);
    this.f.setInterpolator(a);
    this.f.setDuration(1200L);
    this.f.setRepeatCount(-1);
    this.f.setRepeatMode(1);
  }
  
  private void a()
  {
    Matrix localMatrix = this.g;
    if (localMatrix != null)
    {
      localMatrix.reset();
      this.b.setImageMatrix(this.g);
    }
  }
  
  public void a(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      this.i = Math.round(paramDrawable.getIntrinsicWidth() / 2.0F);
      this.j = Math.round(paramDrawable.getIntrinsicHeight() / 2.0F);
    }
  }
  
  protected void b(float paramFloat)
  {
    if (this.h) {
      paramFloat *= 90.0F;
    } else {
      paramFloat = Math.max(0.0F, Math.min(180.0F, paramFloat * 360.0F - 180.0F));
    }
    this.g.setRotate(paramFloat, this.i, this.j);
    this.b.setImageMatrix(this.g);
  }
  
  protected int getDefaultDrawableResId()
  {
    return 2130842557;
  }
  
  protected void i() {}
  
  protected void j()
  {
    this.b.startAnimation(this.f);
  }
  
  protected void k() {}
  
  protected void l()
  {
    this.b.clearAnimation();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.pulltorefresh.internal.RotateLoadingLayout
 * JD-Core Version:    0.7.0.1
 */