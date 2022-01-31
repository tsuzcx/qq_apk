package com.tencent.mobileqq.extendfriend.pulltorefresh.internal;

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
import ants;
import com.tencent.mobileqq.extendfriend.pulltorefresh.PullToRefreshBase.Mode;
import com.tencent.mobileqq.extendfriend.pulltorefresh.PullToRefreshBase.Orientation;

@SuppressLint({"ViewConstructor"})
public class FlipLoadingLayout
  extends ants
{
  private final Animation a;
  private final Animation b;
  
  public FlipLoadingLayout(Context paramContext, PullToRefreshBase.Mode paramMode, PullToRefreshBase.Orientation paramOrientation, TypedArray paramTypedArray)
  {
    super(paramContext, paramMode, paramOrientation, paramTypedArray);
    if (paramMode == PullToRefreshBase.Mode.PULL_FROM_START) {}
    for (int i = -180;; i = 180)
    {
      this.jdField_a_of_type_AndroidViewAnimationAnimation = new RotateAnimation(0.0F, i, 1, 0.5F, 1, 0.5F);
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setInterpolator(jdField_a_of_type_AndroidViewAnimationInterpolator);
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(150L);
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
      this.b = new RotateAnimation(i, 0.0F, 1, 0.5F, 1, 0.5F);
      this.b.setInterpolator(jdField_a_of_type_AndroidViewAnimationInterpolator);
      this.b.setDuration(150L);
      this.b.setFillAfter(true);
      return;
    }
  }
  
  private float a()
  {
    switch (antr.a[this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$Mode.ordinal()])
    {
    }
    do
    {
      return 0.0F;
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$Orientation == PullToRefreshBase.Orientation.HORIZONTAL) {
        return 90.0F;
      }
      return 180.0F;
    } while (this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$Orientation != PullToRefreshBase.Orientation.HORIZONTAL);
    return 270.0F;
  }
  
  public void a(Drawable paramDrawable)
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
  
  public int b()
  {
    return 2130839140;
  }
  
  public void b(float paramFloat) {}
  
  public void i()
  {
    if (this.jdField_a_of_type_AndroidViewAnimationAnimation == this.jdField_a_of_type_AndroidWidgetImageView.getAnimation()) {
      this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.b);
    }
  }
  
  public void j()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
  }
  
  public void k()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
  }
  
  public void l()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.pulltorefresh.internal.FlipLoadingLayout
 * JD-Core Version:    0.7.0.1
 */