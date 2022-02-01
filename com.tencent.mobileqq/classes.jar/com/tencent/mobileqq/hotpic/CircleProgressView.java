package com.tencent.mobileqq.hotpic;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

public class CircleProgressView
  extends View
{
  private int jdField_a_of_type_Int;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private int jdField_b_of_type_Int;
  private Paint jdField_b_of_type_AndroidGraphicsPaint = new Paint();
  private int c = 50;
  private int d = 0;
  
  public CircleProgressView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CircleProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CircleProgressView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
    b();
  }
  
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat * paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setARGB(255, 18, 183, 245);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setARGB(89, 78, 76, 67);
  }
  
  private void b()
  {
    setMeasureSize(a(getContext(), 50.0F), a(getContext(), 50.0F));
    setCircleWidth(a(getContext(), 2.0F));
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    float f1 = getWidth() / 2;
    int i = this.c;
    float f2 = f1 - i;
    RectF localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
    float f3 = f1 - f2;
    localRectF.left = (f3 - i / 2);
    localRectF.top = (f3 - i / 2);
    f2 += f1;
    localRectF.right = (i / 2 + f2);
    localRectF.bottom = (f2 + i / 2);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(i);
    paramCanvas.drawCircle(f1, f1, f1, this.jdField_b_of_type_AndroidGraphicsPaint);
    paramCanvas.save();
    paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, 270.0F, this.d * 3.6F, false, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.restore();
    postInvalidateDelayed(20L);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    setMeasuredDimension(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
  }
  
  public void setCircleWidth(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setMeasureSize(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public void setProgress(int paramInt)
  {
    int i;
    if (paramInt >= 0)
    {
      i = paramInt;
      if (paramInt <= 100) {}
    }
    else
    {
      i = 0;
    }
    this.d = i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.CircleProgressView
 * JD-Core Version:    0.7.0.1
 */