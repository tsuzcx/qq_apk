package dov.com.qq.im.story.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import dov.com.qq.im.capture.view.QIMCircleProgress;

class AEAnimationQIMCircleProgress
  extends AnimationQIMCircleProgress
{
  private static final int[] a = new int[9];
  private RectF b;
  private Paint f;
  
  static
  {
    a[0] = Color.parseColor("#B380CF");
    a[1] = Color.parseColor("#FD86A2");
    a[2] = Color.parseColor("#F78A92");
    a[3] = Color.parseColor("#FB785A");
    a[4] = Color.parseColor("#FF904B");
    a[5] = Color.parseColor("#F8BF72");
    a[6] = Color.parseColor("#8190E0");
    a[7] = Color.parseColor("#5F7EFB");
    a[8] = Color.parseColor("#B380CF");
  }
  
  public AEAnimationQIMCircleProgress(Context paramContext)
  {
    super(paramContext);
  }
  
  public AEAnimationQIMCircleProgress(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void f()
  {
    if (this.jdField_f_of_type_AndroidGraphicsPaint != null) {
      return;
    }
    this.jdField_f_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_f_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_f_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_f_of_type_AndroidGraphicsPaint.setStrokeWidth(this.c);
    SweepGradient localSweepGradient = new SweepGradient(this.jdField_b_of_type_AndroidGraphicsRectF.centerX(), this.jdField_b_of_type_AndroidGraphicsRectF.centerY(), a, null);
    this.jdField_f_of_type_AndroidGraphicsPaint.setShader(localSweepGradient);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    float f1 = -0.005555556F * QIMCircleProgress.a;
    f();
    float f2 = (this.e - f1) * 360.0F / QIMCircleProgress.a - 4.0F;
    if (f2 > 0.0F) {
      paramCanvas.drawArc(this.jdField_b_of_type_AndroidGraphicsRectF, 2.0F + (f1 * 360.0F / QIMCircleProgress.a - 90.0F), f2, false, this.jdField_f_of_type_AndroidGraphicsPaint);
    }
    if (this.jdField_b_of_type_Int != 2) {
      a(paramCanvas);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_b_of_type_AndroidGraphicsRectF = new RectF(this.c + this.jdField_f_of_type_Float, this.c + this.jdField_f_of_type_Float, paramInt1 - this.c - this.jdField_f_of_type_Float, paramInt2 - this.c - this.jdField_f_of_type_Float);
    this.i = getWidth();
    this.j = getHeight();
  }
  
  public void setStrokeWidth(float paramFloat)
  {
    super.setStrokeWidth(paramFloat);
    if (this.jdField_f_of_type_AndroidGraphicsPaint != null) {
      this.jdField_f_of_type_AndroidGraphicsPaint.setStrokeWidth(this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.story.view.AEAnimationQIMCircleProgress
 * JD-Core Version:    0.7.0.1
 */