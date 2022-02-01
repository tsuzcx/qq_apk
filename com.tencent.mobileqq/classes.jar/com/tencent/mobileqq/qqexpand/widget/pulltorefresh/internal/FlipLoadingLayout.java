package com.tencent.mobileqq.qqexpand.widget.pulltorefresh.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import com.tencent.mobileqq.qqexpand.widget.pulltorefresh.PullToRefreshBase.Mode;
import com.tencent.mobileqq.qqexpand.widget.pulltorefresh.PullToRefreshBase.Orientation;

@SuppressLint({"ViewConstructor"})
public class FlipLoadingLayout
  extends LoadingLayout
{
  private final Animation f;
  private final Animation g;
  
  public FlipLoadingLayout(Context paramContext, PullToRefreshBase.Mode paramMode, PullToRefreshBase.Orientation paramOrientation, TypedArray paramTypedArray)
  {
    super(paramContext, paramMode, paramOrientation, paramTypedArray);
    int i;
    if (paramMode == PullToRefreshBase.Mode.PULL_FROM_START) {
      i = -180;
    } else {
      i = 180;
    }
    float f1 = i;
    this.f = new RotateAnimation(0.0F, f1, 1, 0.5F, 1, 0.5F);
    this.f.setInterpolator(a);
    this.f.setDuration(150L);
    this.f.setFillAfter(true);
    this.g = new RotateAnimation(f1, 0.0F, 1, 0.5F, 1, 0.5F);
    this.g.setInterpolator(a);
    this.g.setDuration(150L);
    this.g.setFillAfter(true);
  }
  
  private float getDrawableRotationAngle()
  {
    int i = FlipLoadingLayout.1.a[this.d.ordinal()];
    if (i != 1)
    {
      if ((i == 2) && (this.e == PullToRefreshBase.Orientation.HORIZONTAL)) {
        return 270.0F;
      }
      return 0.0F;
    }
    if (this.e == PullToRefreshBase.Orientation.HORIZONTAL) {
      return 90.0F;
    }
    return 180.0F;
  }
  
  protected void a(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      int i = paramDrawable.getIntrinsicHeight();
      int j = paramDrawable.getIntrinsicWidth();
      paramDrawable = this.b.getLayoutParams();
      int k = Math.max(i, j);
      paramDrawable.height = k;
      paramDrawable.width = k;
      this.b.requestLayout();
      this.b.setScaleType(ImageView.ScaleType.MATRIX);
      Matrix localMatrix = new Matrix();
      localMatrix.postTranslate((paramDrawable.width - j) / 2.0F, (paramDrawable.height - i) / 2.0F);
      localMatrix.postRotate(getDrawableRotationAngle(), paramDrawable.width / 2.0F, paramDrawable.height / 2.0F);
      this.b.setImageMatrix(localMatrix);
    }
  }
  
  protected void b(float paramFloat) {}
  
  protected int getDefaultDrawableResId()
  {
    return 2130839618;
  }
  
  protected void i()
  {
    if (this.f == this.b.getAnimation()) {
      this.b.startAnimation(this.g);
    }
  }
  
  protected void j()
  {
    this.b.clearAnimation();
    this.b.setVisibility(4);
    this.c.setVisibility(0);
  }
  
  protected void k()
  {
    this.b.startAnimation(this.f);
  }
  
  protected void l()
  {
    this.b.clearAnimation();
    this.c.setVisibility(8);
    this.b.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.pulltorefresh.internal.FlipLoadingLayout
 * JD-Core Version:    0.7.0.1
 */