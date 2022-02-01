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
  private final Animation a;
  private final Animation b;
  
  public FlipLoadingLayout(Context paramContext, PullToRefreshBase.Mode paramMode, PullToRefreshBase.Orientation paramOrientation, TypedArray paramTypedArray)
  {
    super(paramContext, paramMode, paramOrientation, paramTypedArray);
    int i;
    if (paramMode == PullToRefreshBase.Mode.PULL_FROM_START) {
      i = -180;
    } else {
      i = 180;
    }
    float f = i;
    this.jdField_a_of_type_AndroidViewAnimationAnimation = new RotateAnimation(0.0F, f, 1, 0.5F, 1, 0.5F);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setInterpolator(jdField_a_of_type_AndroidViewAnimationInterpolator);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(150L);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
    this.b = new RotateAnimation(f, 0.0F, 1, 0.5F, 1, 0.5F);
    this.b.setInterpolator(jdField_a_of_type_AndroidViewAnimationInterpolator);
    this.b.setDuration(150L);
    this.b.setFillAfter(true);
  }
  
  private float a()
  {
    int i = FlipLoadingLayout.1.a[this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$Mode.ordinal()];
    if (i != 1)
    {
      if ((i == 2) && (this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$Orientation == PullToRefreshBase.Orientation.HORIZONTAL)) {
        return 270.0F;
      }
      return 0.0F;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshPullToRefreshBase$Orientation == PullToRefreshBase.Orientation.HORIZONTAL) {
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
      paramDrawable = this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      int k = Math.max(i, j);
      paramDrawable.height = k;
      paramDrawable.width = k;
      this.jdField_a_of_type_AndroidWidgetImageView.requestLayout();
      this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.MATRIX);
      Matrix localMatrix = new Matrix();
      localMatrix.postTranslate((paramDrawable.width - j) / 2.0F, (paramDrawable.height - i) / 2.0F);
      localMatrix.postRotate(a(), paramDrawable.width / 2.0F, paramDrawable.height / 2.0F);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageMatrix(localMatrix);
    }
  }
  
  protected int b()
  {
    return 2130839429;
  }
  
  protected void b(float paramFloat) {}
  
  protected void i()
  {
    if (this.jdField_a_of_type_AndroidViewAnimationAnimation == this.jdField_a_of_type_AndroidWidgetImageView.getAnimation()) {
      this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.b);
    }
  }
  
  protected void j()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
  }
  
  protected void k()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
  }
  
  protected void l()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.pulltorefresh.internal.FlipLoadingLayout
 * JD-Core Version:    0.7.0.1
 */