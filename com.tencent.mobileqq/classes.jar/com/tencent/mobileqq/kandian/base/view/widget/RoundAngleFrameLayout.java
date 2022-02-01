package com.tencent.mobileqq.kandian.base.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class RoundAngleFrameLayout
  extends FrameLayout
{
  private float jdField_a_of_type_Float;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private float jdField_b_of_type_Float;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  private float c;
  private float d;
  
  public RoundAngleFrameLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RoundAngleFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RoundAngleFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setXfermode(null);
  }
  
  private void a(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Float > 0.0F)
    {
      Path localPath = new Path();
      localPath.moveTo(0.0F, this.jdField_a_of_type_Float);
      localPath.lineTo(0.0F, 0.0F);
      localPath.lineTo(this.jdField_a_of_type_Float, 0.0F);
      float f = this.jdField_a_of_type_Float;
      localPath.arcTo(new RectF(0.0F, 0.0F, f * 2.0F, f * 2.0F), -90.0F, -90.0F);
      localPath.close();
      paramCanvas.drawPath(localPath, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  private void b(Canvas paramCanvas)
  {
    if (this.jdField_b_of_type_Float > 0.0F)
    {
      int i = getWidth();
      Path localPath = new Path();
      float f1 = i;
      localPath.moveTo(f1 - this.jdField_b_of_type_Float, 0.0F);
      localPath.lineTo(f1, 0.0F);
      localPath.lineTo(f1, this.jdField_b_of_type_Float);
      float f2 = this.jdField_b_of_type_Float;
      localPath.arcTo(new RectF(f1 - f2 * 2.0F, 0.0F, f1, f2 * 2.0F), 0.0F, -90.0F);
      localPath.close();
      paramCanvas.drawPath(localPath, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  private void c(Canvas paramCanvas)
  {
    if (this.c > 0.0F)
    {
      int i = getHeight();
      Path localPath = new Path();
      float f1 = i;
      localPath.moveTo(0.0F, f1 - this.c);
      localPath.lineTo(0.0F, f1);
      localPath.lineTo(this.c, f1);
      float f2 = this.c;
      localPath.arcTo(new RectF(0.0F, f1 - f2 * 2.0F, f2 * 2.0F, f1), 90.0F, 90.0F);
      localPath.close();
      paramCanvas.drawPath(localPath, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  private void d(Canvas paramCanvas)
  {
    if (this.d > 0.0F)
    {
      int i = getHeight();
      int j = getWidth();
      Path localPath = new Path();
      float f1 = j;
      float f3 = this.d;
      float f2 = i;
      localPath.moveTo(f1 - f3, f2);
      localPath.lineTo(f1, f2);
      localPath.lineTo(f1, f2 - this.d);
      f3 = this.d;
      localPath.arcTo(new RectF(f1 - f3 * 2.0F, f2 - f3 * 2.0F, f1, f2), 0.0F, 90.0F);
      localPath.close();
      paramCanvas.drawPath(localPath, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    paramCanvas.saveLayer(new RectF(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight()), this.jdField_b_of_type_AndroidGraphicsPaint, 31);
    super.dispatchDraw(paramCanvas);
    a(paramCanvas);
    b(paramCanvas);
    c(paramCanvas);
    d(paramCanvas);
    paramCanvas.restore();
  }
  
  public void setRadius(int paramInt)
  {
    float f = paramInt;
    this.jdField_a_of_type_Float = f;
    this.jdField_b_of_type_Float = f;
    this.c = f;
    this.d = f;
  }
  
  public void setRadius(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_Float = paramInt1;
    this.jdField_b_of_type_Float = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.RoundAngleFrameLayout
 * JD-Core Version:    0.7.0.1
 */