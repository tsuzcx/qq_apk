package com.tencent.mobileqq.qwallet.hb.emoji.impl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.util.DisplayUtil;

public class NumberProgressBar
  extends View
{
  protected float a;
  protected int a;
  protected final Paint a;
  private Rect a;
  protected final RectF a;
  protected String a;
  protected int b = -1;
  
  public NumberProgressBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NumberProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = DisplayUtil.a(paramContext, 5.0F);
    this.jdField_a_of_type_JavaLangString = "xx";
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    float f1 = Math.min(paramCanvas.getHeight(), paramCanvas.getWidth()) / 2 - this.jdField_a_of_type_Int / 2;
    float f2 = paramCanvas.getWidth();
    f1 *= 2.0F;
    f2 = (f2 - f1) / 2.0F;
    float f3 = (paramCanvas.getHeight() - f1) / 2.0F;
    float f4 = this.jdField_a_of_type_Int / 2;
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.ROUND);
    this.jdField_a_of_type_AndroidGraphicsRectF.set(f2 + f4, f3 + f4, f2 + f1 - f4, f3 + f1 - f4);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(1073741823);
    paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, 0.0F, 360.0F, false, this.jdField_a_of_type_AndroidGraphicsPaint);
    int i = this.b;
    if (i != 0)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(i);
      paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, -90.0F, -this.jdField_a_of_type_Float, false, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    else
    {
      paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, -90.0F, -this.jdField_a_of_type_Float, false, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    double d = this.jdField_a_of_type_Float;
    Double.isNaN(d);
    i = -(int)(d / 3.6D);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append("%");
    localObject = ((StringBuilder)localObject).toString();
    this.jdField_a_of_type_AndroidGraphicsPaint.setShader(null);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(DisplayUtil.c(getContext(), 16.0F));
    this.jdField_a_of_type_AndroidGraphicsPaint.getTextBounds((String)localObject, 0, ((String)localObject).length(), this.jdField_a_of_type_AndroidGraphicsRect);
    i = this.jdField_a_of_type_AndroidGraphicsRect.width();
    int j = this.jdField_a_of_type_AndroidGraphicsRect.height();
    String str = this.jdField_a_of_type_JavaLangString;
    if ((str != null) && (!str.isEmpty()))
    {
      paramCanvas.drawText((String)localObject, (paramCanvas.getWidth() - i) / 2, (paramCanvas.getHeight() + j) / 2, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(DisplayUtil.c(getContext(), 16.0F));
      return;
    }
    paramCanvas.drawText((String)localObject, (paramCanvas.getWidth() - i) / 2, (paramCanvas.getHeight() + j) / 2, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public void setProgress(float paramFloat)
  {
    this.jdField_a_of_type_Float = (paramFloat * -360.0F);
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.emoji.impl.NumberProgressBar
 * JD-Core Version:    0.7.0.1
 */