package com.tencent.mobileqq.togetherui.writetogether;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import berb;
import berc;
import berd;
import bere;
import berf;
import berg;
import berh;
import beri;
import berj;
import com.tencent.mobileqq.R.styleable;

public class SavingAnimView
  extends View
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Path jdField_a_of_type_AndroidGraphicsPath;
  private PathMeasure jdField_a_of_type_AndroidGraphicsPathMeasure;
  private berj jdField_a_of_type_Berj;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float = 1.0F;
  private int jdField_b_of_type_Int;
  private ValueAnimator jdField_b_of_type_AndroidAnimationValueAnimator;
  private Path jdField_b_of_type_AndroidGraphicsPath;
  private PathMeasure jdField_b_of_type_AndroidGraphicsPathMeasure;
  private float jdField_c_of_type_Float = 1.0F;
  private int jdField_c_of_type_Int;
  private ValueAnimator jdField_c_of_type_AndroidAnimationValueAnimator;
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int;
  private ValueAnimator jdField_d_of_type_AndroidAnimationValueAnimator;
  private float jdField_e_of_type_Float;
  private int jdField_e_of_type_Int;
  
  public SavingAnimView(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }
  
  public SavingAnimView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public SavingAnimView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(int paramInt)
  {
    if (paramInt == 0) {
      if (this.jdField_a_of_type_Int == 3) {}
    }
    do
    {
      do
      {
        do
        {
          return;
          this.jdField_a_of_type_Int = paramInt;
          return;
          if (paramInt != 1) {
            break;
          }
        } while (this.jdField_a_of_type_Int != 0);
        this.jdField_a_of_type_Int = paramInt;
        g();
        return;
        if (paramInt != 2) {
          break;
        }
      } while (this.jdField_a_of_type_Int != 1);
      this.jdField_a_of_type_Int = paramInt;
      h();
      return;
      if (paramInt != 3) {
        break;
      }
      if (this.jdField_a_of_type_Int == 1)
      {
        this.jdField_a_of_type_AndroidAnimationValueAnimator.end();
        h();
        i();
        this.jdField_a_of_type_Int = paramInt;
      }
    } while (this.jdField_a_of_type_Int != 2);
    this.jdField_a_of_type_Int = paramInt;
    i();
    return;
    throw new IllegalStateException("[setState] unknown state");
  }
  
  private void a(@ColorInt int paramInt1, @Dimension int paramInt2)
  {
    setLayerType(1, null);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramInt1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.ROUND);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(paramInt2);
    this.jdField_e_of_type_Int = paramInt2;
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    int m = paramContext.getResources().getColor(2131167194);
    int k = paramContext.getResources().getDimensionPixelOffset(2131299220);
    int j = k;
    int i = m;
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SavingAnimView);
      i = paramContext.getColor(1, m);
      j = paramContext.getDimensionPixelOffset(0, k);
      paramContext.recycle();
    }
    a(i, j);
    c();
    d();
    e();
    f();
  }
  
  private void b(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
    if (paramInt == 1) {
      this.jdField_d_of_type_AndroidAnimationValueAnimator.setDuration(300L);
    }
    for (;;)
    {
      this.jdField_d_of_type_AndroidAnimationValueAnimator.start();
      return;
      this.jdField_d_of_type_AndroidAnimationValueAnimator.setDuration(500L);
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new AccelerateInterpolator());
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(300L);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new berb(this));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new berc(this));
  }
  
  private void d()
  {
    this.jdField_b_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.jdField_b_of_type_AndroidAnimationValueAnimator.setDuration(500L);
    this.jdField_b_of_type_AndroidAnimationValueAnimator.setRepeatMode(1);
    this.jdField_b_of_type_AndroidAnimationValueAnimator.setRepeatCount(-1);
    this.jdField_b_of_type_AndroidAnimationValueAnimator.setInterpolator(new LinearInterpolator());
    this.jdField_b_of_type_AndroidAnimationValueAnimator.addUpdateListener(new berd(this));
    this.jdField_b_of_type_AndroidAnimationValueAnimator.addListener(new bere(this));
  }
  
  private void e()
  {
    this.jdField_c_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.jdField_c_of_type_AndroidAnimationValueAnimator.setInterpolator(new LinearInterpolator());
    this.jdField_c_of_type_AndroidAnimationValueAnimator.setDuration(500L);
    this.jdField_c_of_type_AndroidAnimationValueAnimator.addUpdateListener(new berf(this));
    this.jdField_c_of_type_AndroidAnimationValueAnimator.addListener(new berg(this));
  }
  
  private void f()
  {
    this.jdField_d_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.jdField_d_of_type_AndroidAnimationValueAnimator.setDuration(500L);
    this.jdField_d_of_type_AndroidAnimationValueAnimator.addUpdateListener(new berh(this));
    this.jdField_d_of_type_AndroidAnimationValueAnimator.addListener(new beri(this));
  }
  
  private void g()
  {
    this.jdField_b_of_type_AndroidAnimationValueAnimator.setRepeatCount(-1);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
    b(0);
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void h()
  {
    this.jdField_b_of_type_AndroidAnimationValueAnimator.start();
  }
  
  private void i()
  {
    this.jdField_b_of_type_AndroidAnimationValueAnimator.setRepeatCount(1);
  }
  
  public void a()
  {
    a(1);
  }
  
  public void b()
  {
    a(3);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.jdField_b_of_type_AndroidAnimationValueAnimator.removeAllListeners();
    this.jdField_b_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
    this.jdField_d_of_type_AndroidAnimationValueAnimator.removeAllListeners();
    this.jdField_d_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
    this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllListeners();
    this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
    this.jdField_c_of_type_AndroidAnimationValueAnimator.removeAllListeners();
    this.jdField_c_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    float f1 = this.jdField_a_of_type_AndroidGraphicsPathMeasure.getLength();
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    float f2 = (this.jdField_a_of_type_Float + 1.0F - 0.25F) % 1.0F;
    float f3 = (this.jdField_b_of_type_Float + 1.0F - 0.25F) % 1.0F;
    if (f2 >= f3)
    {
      this.jdField_a_of_type_AndroidGraphicsPathMeasure.getSegment(f2 * f1, f1, this.jdField_a_of_type_AndroidGraphicsPath, true);
      this.jdField_a_of_type_AndroidGraphicsPathMeasure.getSegment(0.0F, f3 * f1, this.jdField_a_of_type_AndroidGraphicsPath, true);
    }
    for (;;)
    {
      paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_b_of_type_AndroidGraphicsPath.reset();
      f1 = this.jdField_b_of_type_AndroidGraphicsPathMeasure.getLength();
      f2 = this.jdField_c_of_type_Float;
      this.jdField_b_of_type_AndroidGraphicsPathMeasure.getSegment(0.0F, f1 * f2, this.jdField_b_of_type_AndroidGraphicsPath, true);
      paramCanvas.drawPath(this.jdField_b_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
      return;
      this.jdField_a_of_type_AndroidGraphicsPathMeasure.getSegment(f2 * f1, f1 * f3, this.jdField_a_of_type_AndroidGraphicsPath, true);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_b_of_type_Int = (paramInt1 / 2);
    this.jdField_c_of_type_Int = (paramInt2 / 2);
    paramInt1 = Math.min(paramInt1, paramInt2) / 2 - this.jdField_e_of_type_Int / 2;
    Path localPath = new Path();
    localPath.moveTo(paramInt1, paramInt1);
    localPath.addCircle(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, paramInt1, Path.Direction.CW);
    this.jdField_a_of_type_AndroidGraphicsPathMeasure = new PathMeasure(localPath, true);
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    localPath = new Path();
    localPath.moveTo(this.jdField_b_of_type_Int - paramInt1 * 0.5F, this.jdField_c_of_type_Int);
    localPath.lineTo(this.jdField_b_of_type_Int - paramInt1 * 0.1F, this.jdField_c_of_type_Int + paramInt1 * 0.4F);
    localPath.lineTo(this.jdField_b_of_type_Int + paramInt1 * 0.6F, this.jdField_c_of_type_Int - paramInt1 * 0.3F);
    this.jdField_b_of_type_AndroidGraphicsPathMeasure = new PathMeasure(localPath, false);
    this.jdField_b_of_type_AndroidGraphicsPath = new Path();
  }
  
  public void setOnAnimationStateListener(berj paramberj)
  {
    this.jdField_a_of_type_Berj = paramberj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.togetherui.writetogether.SavingAnimView
 * JD-Core Version:    0.7.0.1
 */