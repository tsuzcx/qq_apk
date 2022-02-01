package com.tencent.mobileqq.troop.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import bfwa;
import bfwb;
import bfwc;

public class RedDotAnimateView
  extends View
{
  public float a;
  public int a;
  AnimatorSet jdField_a_of_type_AndroidAnimationAnimatorSet;
  ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  Paint jdField_a_of_type_AndroidGraphicsPaint;
  public float b;
  int jdField_b_of_type_Int;
  ValueAnimator jdField_b_of_type_AndroidAnimationValueAnimator;
  Paint jdField_b_of_type_AndroidGraphicsPaint;
  public int c;
  ValueAnimator c;
  int d = 255;
  
  public RedDotAnimateView(Context paramContext)
  {
    super(paramContext);
    this.jdField_c_of_type_Int = 76;
    a();
  }
  
  public RedDotAnimateView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_c_of_type_Int = 76;
    a();
  }
  
  void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(Color.rgb(241, 54, 27));
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(Color.rgb(241, 54, 27));
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_c_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe("", new Keyframe[] { Keyframe.ofFloat(0.0F, 0.0F), Keyframe.ofFloat(0.3333333F, 1.9F), Keyframe.ofFloat(0.5F, 0.58F), Keyframe.ofFloat(0.6666667F, 1.25F), Keyframe.ofFloat(1.0F, 1.0F) }) });
    this.jdField_c_of_type_AndroidAnimationValueAnimator.setDuration(1600L);
    this.jdField_c_of_type_AndroidAnimationValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    this.jdField_c_of_type_AndroidAnimationValueAnimator.addUpdateListener(new bfwa(this));
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe("", new Keyframe[] { Keyframe.ofFloat(0.0F, 0.0F), Keyframe.ofFloat(0.1333333F, 0.0F), Keyframe.ofFloat(0.3333333F, 3.0F), Keyframe.ofFloat(0.5F, 1.4F), Keyframe.ofFloat(0.6666667F, 2.08F), Keyframe.ofFloat(1.0F, 2.08F) }) });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(1600L);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new bfwb(this));
    this.jdField_b_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe("", new Keyframe[] { Keyframe.ofFloat(0.0F, 0.3F), Keyframe.ofFloat(0.1333333F, 0.3F), Keyframe.ofFloat(0.3333333F, 0.3F), Keyframe.ofFloat(0.5F, 0.3F), Keyframe.ofFloat(0.6666667F, 0.3F), Keyframe.ofFloat(1.0F, 0.0F) }) });
    this.jdField_b_of_type_AndroidAnimationValueAnimator.setDuration(1600L);
    this.jdField_b_of_type_AndroidAnimationValueAnimator.setInterpolator(new LinearInterpolator());
    this.jdField_b_of_type_AndroidAnimationValueAnimator.addUpdateListener(new bfwc(this));
    this.jdField_a_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.setDuration(1600L);
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.playTogether(new Animator[] { this.jdField_c_of_type_AndroidAnimationValueAnimator, this.jdField_a_of_type_AndroidAnimationValueAnimator, this.jdField_b_of_type_AndroidAnimationValueAnimator });
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.start();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.jdField_b_of_type_Int == 0) {
      this.jdField_b_of_type_Int = getHeight();
    }
    if (this.jdField_a_of_type_Int == 0) {
      this.jdField_a_of_type_Int = getWidth();
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(this.d);
    paramCanvas.drawCircle(this.jdField_a_of_type_Int / 2, this.jdField_b_of_type_Int / 2, this.jdField_b_of_type_Float, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_b_of_type_AndroidGraphicsPaint.setAlpha(this.jdField_c_of_type_Int);
    paramCanvas.drawCircle(this.jdField_a_of_type_Int / 2, this.jdField_b_of_type_Int / 2, this.jdField_a_of_type_Float, this.jdField_b_of_type_AndroidGraphicsPaint);
  }
  
  public void setStaticRedDot(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_c_of_type_Int = 0;
    this.jdField_b_of_type_Float = (this.jdField_a_of_type_Int / 2);
    invalidate();
  }
  
  public void setVisibleAndZeroRadius()
  {
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_b_of_type_Float = 0.0F;
    setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.RedDotAnimateView
 * JD-Core Version:    0.7.0.1
 */