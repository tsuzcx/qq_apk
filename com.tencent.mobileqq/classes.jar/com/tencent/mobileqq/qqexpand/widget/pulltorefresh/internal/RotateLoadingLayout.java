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
  private float jdField_a_of_type_Float;
  private final Matrix jdField_a_of_type_AndroidGraphicsMatrix;
  private final Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private final boolean jdField_a_of_type_Boolean;
  private float b;
  
  public RotateLoadingLayout(Context paramContext, PullToRefreshBase.Mode paramMode, PullToRefreshBase.Orientation paramOrientation, TypedArray paramTypedArray)
  {
    super(paramContext, paramMode, paramOrientation, paramTypedArray);
    this.jdField_a_of_type_Boolean = paramTypedArray.getBoolean(R.styleable.r, true);
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
    Matrix localMatrix = this.jdField_a_of_type_AndroidGraphicsMatrix;
    if (localMatrix != null)
    {
      localMatrix.reset();
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
  
  protected int b()
  {
    return 2130841642;
  }
  
  protected void b(float paramFloat)
  {
    if (this.jdField_a_of_type_Boolean) {
      paramFloat *= 90.0F;
    } else {
      paramFloat = Math.max(0.0F, Math.min(180.0F, paramFloat * 360.0F - 180.0F));
    }
    this.jdField_a_of_type_AndroidGraphicsMatrix.setRotate(paramFloat, this.jdField_a_of_type_Float, this.b);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageMatrix(this.jdField_a_of_type_AndroidGraphicsMatrix);
  }
  
  protected void i() {}
  
  protected void j()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
  }
  
  protected void k() {}
  
  protected void l()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.pulltorefresh.internal.RotateLoadingLayout
 * JD-Core Version:    0.7.0.1
 */