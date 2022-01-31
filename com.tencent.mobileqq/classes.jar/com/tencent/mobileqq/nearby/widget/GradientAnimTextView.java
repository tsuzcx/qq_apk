package com.tencent.mobileqq.nearby.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import atya;
import com.tencent.mobileqq.R.styleable;

public class GradientAnimTextView
  extends TextView
{
  private int jdField_a_of_type_Int;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private LinearGradient jdField_a_of_type_AndroidGraphicsLinearGradient;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private int b;
  private int c = -1;
  private int d = -1;
  
  public GradientAnimTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public GradientAnimTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.GradientAnimTextView);
    this.c = paramContext.getColor(1, -1);
    this.d = paramContext.getColor(0, -1);
    paramContext.recycle();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if ((this.jdField_a_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning())) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator == null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofInt(new int[] { 0, this.jdField_a_of_type_Int * 2 });
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(1500L);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new LinearInterpolator());
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setRepeatCount(-1);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new atya(this));
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
    }
    if (this.jdField_a_of_type_AndroidGraphicsMatrix != null)
    {
      this.jdField_a_of_type_AndroidGraphicsMatrix.setTranslate(this.b, 0.0F);
      this.jdField_a_of_type_AndroidGraphicsLinearGradient.setLocalMatrix(this.jdField_a_of_type_AndroidGraphicsMatrix);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.c == -1) || (this.d == -2)) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Int != 0);
      this.jdField_a_of_type_Int = getMeasuredWidth();
    } while (this.jdField_a_of_type_Int <= 0);
    this.jdField_a_of_type_AndroidGraphicsPaint = getPaint();
    float f1 = this.jdField_a_of_type_Int * -2;
    float f2 = this.jdField_a_of_type_Int;
    paramInt1 = this.c;
    paramInt2 = this.d;
    paramInt3 = this.c;
    paramInt4 = this.d;
    Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
    this.jdField_a_of_type_AndroidGraphicsLinearGradient = new LinearGradient(f1, 0.0F, f2, 0.0F, new int[] { paramInt1, paramInt2, paramInt3, paramInt4 }, null, localTileMode);
    this.jdField_a_of_type_AndroidGraphicsPaint.setShader(this.jdField_a_of_type_AndroidGraphicsLinearGradient);
    this.jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  }
  
  public void setGradientAnimColor(int paramInt1, int paramInt2)
  {
    this.c = paramInt1;
    this.d = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.widget.GradientAnimTextView
 * JD-Core Version:    0.7.0.1
 */