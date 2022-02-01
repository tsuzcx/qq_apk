package com.tencent.mobileqq.olympic.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import ayyn;
import ayyo;
import ayyp;
import ayyq;
import ayyr;
import ayys;
import ayyt;
import ayyu;
import ayyv;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;

public class ScanIconAnimateView
  extends View
{
  public float a;
  AnimatorSet jdField_a_of_type_AndroidAnimationAnimatorSet;
  ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  DrawFilter jdField_a_of_type_AndroidGraphicsDrawFilter;
  Paint jdField_a_of_type_AndroidGraphicsPaint;
  public ayyv a;
  private boolean jdField_a_of_type_Boolean;
  public float b;
  ValueAnimator jdField_b_of_type_AndroidAnimationValueAnimator;
  Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  Paint jdField_b_of_type_AndroidGraphicsPaint;
  public float c;
  ValueAnimator c;
  public float d;
  ValueAnimator d;
  public float e;
  ValueAnimator e;
  public float f;
  ValueAnimator f;
  ValueAnimator g;
  
  public ScanIconAnimateView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ScanIconAnimateView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ScanIconAnimateView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_b_of_type_Float = 0.5F;
    this.jdField_c_of_type_Float = 1.0F;
    this.jdField_d_of_type_Float = 0.0F;
    this.jdField_e_of_type_Float = 1.0F;
    this.jdField_f_of_type_Float = 1.0F;
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    try
    {
      paramContext = BitmapFactory.decodeResource(getResources(), 2130843347);
      Bitmap localBitmap = BitmapFactory.decodeResource(getResources(), 2130843349);
      int i = AIOUtils.dp2px(32.0F, getResources());
      this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createScaledBitmap(paramContext, i * 2, i * 2, true);
      this.jdField_b_of_type_AndroidGraphicsBitmap = Bitmap.createScaledBitmap(localBitmap, i, i, true);
      this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
      this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
      this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      this.jdField_a_of_type_AndroidGraphicsDrawFilter = new PaintFlagsDrawFilter(0, 3);
      this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe("", new Keyframe[] { Keyframe.ofFloat(0.0F, 0.0F), Keyframe.ofFloat(0.1333333F, 8.0F), Keyframe.ofFloat(0.2F, -6.0F), Keyframe.ofFloat(0.2666667F, 3.0F), Keyframe.ofFloat(0.3333333F, 0.0F), Keyframe.ofFloat(0.6666667F, 0.0F), Keyframe.ofFloat(1.0F, 0.0F) }) });
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(1500L);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setRepeatCount(-1);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new ayyn(this));
      this.jdField_b_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe("", new Keyframe[] { Keyframe.ofFloat(0.0F, -90.0F), Keyframe.ofFloat(0.2F, 40.0F), Keyframe.ofFloat(0.4F, -20.0F), Keyframe.ofFloat(0.6F, 5.0F), Keyframe.ofFloat(0.8F, -5.0F), Keyframe.ofFloat(0.9F, 3.0F), Keyframe.ofFloat(1.0F, 0.0F) }) });
      this.jdField_b_of_type_AndroidAnimationValueAnimator.setDuration(1000L);
      this.jdField_b_of_type_AndroidAnimationValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
      this.jdField_b_of_type_AndroidAnimationValueAnimator.addUpdateListener(new ayyo(this));
      this.jdField_c_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.5F, 1.0F, 1.0F, 1.0F, 0.5F, 0.5F });
      this.jdField_c_of_type_AndroidAnimationValueAnimator.setDuration(1000L);
      this.jdField_c_of_type_AndroidAnimationValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
      this.jdField_c_of_type_AndroidAnimationValueAnimator.addUpdateListener(new ayyp(this));
      this.jdField_d_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F });
      this.jdField_d_of_type_AndroidAnimationValueAnimator.setDuration(1000L);
      this.jdField_d_of_type_AndroidAnimationValueAnimator.addUpdateListener(new ayyq(this));
      this.jdField_e_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F });
      this.jdField_e_of_type_AndroidAnimationValueAnimator.setDuration(1000L);
      this.jdField_e_of_type_AndroidAnimationValueAnimator.addUpdateListener(new ayyr(this));
      this.jdField_f_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe("", new Keyframe[] { Keyframe.ofFloat(0.0F, 0.0F), Keyframe.ofFloat(0.6F, 1.0F), Keyframe.ofFloat(0.8F, 1.08F), Keyframe.ofFloat(0.9F, 1.0F), Keyframe.ofFloat(1.0F, 1.0F) }) });
      this.jdField_f_of_type_AndroidAnimationValueAnimator.setDuration(1000L);
      this.jdField_f_of_type_AndroidAnimationValueAnimator.addUpdateListener(new ayys(this));
      this.g = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe("", new Keyframe[] { Keyframe.ofFloat(0.0F, 0.0F), Keyframe.ofFloat(0.6F, 0.0F), Keyframe.ofFloat(0.9F, 1.0F), Keyframe.ofFloat(1.0F, 1.0F) }) });
      this.g.setDuration(1000L);
      this.g.addUpdateListener(new ayyt(this));
      this.jdField_a_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.setDuration(1000L);
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.playTogether(new Animator[] { this.jdField_b_of_type_AndroidAnimationValueAnimator, this.jdField_c_of_type_AndroidAnimationValueAnimator, this.jdField_e_of_type_AndroidAnimationValueAnimator, this.jdField_d_of_type_AndroidAnimationValueAnimator, this.jdField_f_of_type_AndroidAnimationValueAnimator, this.g });
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.addListener(new ayyu(this));
      return;
    }
    catch (OutOfMemoryError paramContext)
    {
      QLog.d("ScanIconAnimateView", 1, "init failed ", paramContext);
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanIconAnimateView", 2, "startPendulumAnim ");
    }
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  public boolean a()
  {
    boolean bool = this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning();
    if (QLog.isColorLevel()) {
      QLog.d("ScanIconAnimateView", 2, "isPendulumRunning = " + bool);
    }
    return bool;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanIconAnimateView", 2, "stopPendulumAnim ");
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    this.jdField_a_of_type_Float = 0.0F;
    invalidate();
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanIconAnimateView", 2, "startPopUpAnim ");
    }
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.start();
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanIconAnimateView", 2, "stopPopUpAnim ");
    }
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.save();
    this.jdField_b_of_type_AndroidGraphicsPaint.setAlpha((int)(this.jdField_e_of_type_Float * 255.0F));
    paramCanvas.scale(this.jdField_f_of_type_Float, this.jdField_f_of_type_Float, AIOUtils.dp2px(16.0F, getResources()), AIOUtils.dp2px(16.0F, getResources()));
    paramCanvas.drawBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap, 0.0F, 0.0F, this.jdField_b_of_type_AndroidGraphicsPaint);
    paramCanvas.restore();
    paramCanvas.save();
    paramCanvas.translate(0.0F, this.jdField_d_of_type_Float);
    paramCanvas.scale(this.jdField_b_of_type_Float, this.jdField_b_of_type_Float, AIOUtils.dp2px(16.0F, getResources()), AIOUtils.dp2px(23.0F, getResources()));
    paramCanvas.rotate(this.jdField_a_of_type_Float, AIOUtils.dp2px(16.0F, getResources()), AIOUtils.dp2px(23.0F, getResources()));
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha((int)(this.jdField_c_of_type_Float * 255.0F));
    paramCanvas.setDrawFilter(this.jdField_a_of_type_AndroidGraphicsDrawFilter);
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, AIOUtils.dp2px(-16.0F, getResources()), AIOUtils.dp2px(-23.0F, getResources()), this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.restore();
  }
  
  public void setPopUpListener(ayyv paramayyv)
  {
    this.jdField_a_of_type_Ayyv = paramayyv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.view.ScanIconAnimateView
 * JD-Core Version:    0.7.0.1
 */