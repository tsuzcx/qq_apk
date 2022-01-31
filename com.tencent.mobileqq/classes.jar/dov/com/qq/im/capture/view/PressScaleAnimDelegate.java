package dov.com.qq.im.capture.view;

import amze;
import amzf;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.qphone.base.util.QLog;

public final class PressScaleAnimDelegate
{
  private static final Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator = new LinearInterpolator();
  private final amzf jdField_a_of_type_Amzf;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private final View jdField_a_of_type_AndroidViewView;
  
  PressScaleAnimDelegate(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Amzf = new amzf(paramView);
  }
  
  public static void a(View paramView, long paramLong, View.OnClickListener paramOnClickListener)
  {
    if (paramView == null) {
      return;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.75F, 0.5F, 0.75F, 1.0F });
    paramView = new amze(paramView, paramOnClickListener);
    localValueAnimator.setDuration(paramLong);
    localValueAnimator.setInterpolator(jdField_a_of_type_AndroidViewAnimationInterpolator);
    localValueAnimator.addUpdateListener(paramView);
    localValueAnimator.addListener(paramView);
    localValueAnimator.start();
  }
  
  void a()
  {
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.removeUpdateListener(this.jdField_a_of_type_Amzf);
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.75F, 0.5F, 0.75F, 1.0F });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(200L);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(jdField_a_of_type_AndroidViewAnimationInterpolator);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(this.jdField_a_of_type_Amzf);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  void a(Canvas paramCanvas)
  {
    int i = this.jdField_a_of_type_AndroidViewView.getPaddingLeft();
    int j = this.jdField_a_of_type_AndroidViewView.getRight() - this.jdField_a_of_type_AndroidViewView.getLeft() - this.jdField_a_of_type_AndroidViewView.getPaddingRight();
    int m = this.jdField_a_of_type_AndroidViewView.getPaddingTop();
    int n = this.jdField_a_of_type_AndroidViewView.getBottom();
    int i1 = this.jdField_a_of_type_AndroidViewView.getTop();
    int i2 = this.jdField_a_of_type_AndroidViewView.getPaddingBottom();
    int k = (i + j) / 2;
    m = (m + (n - i1 - i2)) / 2;
    paramCanvas.scale(this.jdField_a_of_type_Amzf.a, this.jdField_a_of_type_Amzf.a, k, m);
    if (QLog.isColorLevel()) {
      QLog.d("PressScaleAnimDelegate ", 2, "draw, left=" + i + ",right=" + j + ",centerX=" + k + ",centerY=" + m + ",scale=" + this.jdField_a_of_type_Amzf.a);
    }
  }
  
  boolean a()
  {
    return this.jdField_a_of_type_Amzf.a != 1.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.view.PressScaleAnimDelegate
 * JD-Core Version:    0.7.0.1
 */