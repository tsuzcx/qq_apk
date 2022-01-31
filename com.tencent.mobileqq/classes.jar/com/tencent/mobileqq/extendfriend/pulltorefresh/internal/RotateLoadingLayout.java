package com.tencent.mobileqq.extendfriend.pulltorefresh.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import aqcl;
import com.tencent.mobileqq.extendfriend.pulltorefresh.PullToRefreshBase.Mode;
import com.tencent.mobileqq.extendfriend.pulltorefresh.PullToRefreshBase.Orientation;

public class RotateLoadingLayout
  extends aqcl
{
  private float jdField_a_of_type_Float;
  private final Matrix jdField_a_of_type_AndroidGraphicsMatrix;
  private final Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private final boolean jdField_a_of_type_Boolean;
  private float b;
  
  public RotateLoadingLayout(Context paramContext, PullToRefreshBase.Mode paramMode, PullToRefreshBase.Orientation paramOrientation, TypedArray paramTypedArray)
  {
    super(paramContext, paramMode, paramOrientation, paramTypedArray);
    this.jdField_a_of_type_Boolean = paramTypedArray.getBoolean(18, true);
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.MATRIX);
    this.jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
    this.jdField_a_of_type_AndroidWidgetImageView.setImageMatrix(this.jdField_a_of_type_AndroidGraphicsMatrix);
    this.jdField_a_of_type_AndroidViewAnimationAnimation = new RotateAnimation(0.0F, 720.0F, 1, 0.5F, 1, 0.5F);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setInterpolator(jdField_a_of_type_AndroidViewAnimationInterpolator);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(1200L);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setRepeatCount(-1);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setRepeatMode(1);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsMatrix != null)
    {
      this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
      this.jdField_a_of_type_AndroidWidgetImageView.setImageMatrix(this.jdField_a_of_type_AndroidGraphicsMatrix);
    }
  }
  
  public void a(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      this.jdField_a_of_type_Float = Math.round(paramDrawable.getIntrinsicWidth() / 2.0F);
      this.b = Math.round(paramDrawable.getIntrinsicHeight() / 2.0F);
    }
  }
  
  public int b()
  {
    return 2130841253;
  }
  
  public void b(float paramFloat)
  {
    if (this.jdField_a_of_type_Boolean) {}
    for (paramFloat = 90.0F * paramFloat;; paramFloat = Math.max(0.0F, Math.min(180.0F, 360.0F * paramFloat - 180.0F)))
    {
      this.jdField_a_of_type_AndroidGraphicsMatrix.setRotate(paramFloat, this.jdField_a_of_type_Float, this.b);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageMatrix(this.jdField_a_of_type_AndroidGraphicsMatrix);
      return;
    }
  }
  
  public void i() {}
  
  public void j()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
  }
  
  public void k() {}
  
  public void l()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.pulltorefresh.internal.RotateLoadingLayout
 * JD-Core Version:    0.7.0.1
 */