package dov.com.qq.im.story.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class CircleProgressBar
  extends View
{
  private int jdField_a_of_type_Int = -1;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private int b = -16777216;
  private int c = 0;
  private int d = 10;
  private int e = 0;
  private int f = 100;
  private int g;
  
  public CircleProgressBar(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public CircleProgressBar(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public CircleProgressBar(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    float f1 = this.g / 2;
    float f2 = this.g / 2;
    float f3 = this.g / 2 - this.d / 2;
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.d);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
    paramCanvas.drawCircle(f1, f2, f3, this.jdField_a_of_type_AndroidGraphicsPaint);
    RectF localRectF = new RectF(this.d / 2, this.d / 2, this.g - this.d / 2, this.g - this.d / 2);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.b);
    paramCanvas.drawArc(localRectF, -90.0F, this.e * 360 / this.f, false, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.c);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    paramCanvas.drawCircle(f1, f2, this.g / 2 - this.d, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.g = getMeasuredWidth();
  }
  
  public void setCircleBackgroundColor(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setCircleCenterColor(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setCircleProgressColor(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setCircleWidth(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setCurrentProgress(int paramInt)
  {
    if (paramInt == this.e) {
      return;
    }
    this.e = paramInt;
    invalidate();
  }
  
  public void setMaxProgress(int paramInt)
  {
    this.f = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.qq.im.story.view.CircleProgressBar
 * JD-Core Version:    0.7.0.1
 */