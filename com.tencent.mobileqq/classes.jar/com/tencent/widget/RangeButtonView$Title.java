package com.tencent.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;

public class RangeButtonView$Title
{
  float jdField_a_of_type_Float;
  Point jdField_a_of_type_AndroidGraphicsPoint;
  String jdField_a_of_type_JavaLangString;
  
  public RangeButtonView$Title(String paramString, float paramFloat)
  {
    this(paramString, paramFloat, null);
  }
  
  public RangeButtonView$Title(String paramString, float paramFloat, Point paramPoint)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Float = paramFloat;
    this.jdField_a_of_type_AndroidGraphicsPoint = paramPoint;
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public int a()
  {
    return (int)RangeButtonView.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Float);
  }
  
  public void a(Canvas paramCanvas, Paint paramPaint, RangeButtonView.RangeButtonParams paramRangeButtonParams)
  {
    if (this.jdField_a_of_type_AndroidGraphicsPoint == null) {
      return;
    }
    paramPaint.setTextSize(this.jdField_a_of_type_Float);
    int i = paramPaint.getColor();
    paramPaint.setColor(paramRangeButtonParams.a);
    paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidGraphicsPoint.x, this.jdField_a_of_type_AndroidGraphicsPoint.y, paramPaint);
    paramPaint.setColor(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.RangeButtonView.Title
 * JD-Core Version:    0.7.0.1
 */