package com.tencent.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;

public class RangeButtonView$Title
{
  Point point;
  String text;
  float textSize;
  
  public RangeButtonView$Title(String paramString, float paramFloat)
  {
    this(paramString, paramFloat, null);
  }
  
  public RangeButtonView$Title(String paramString, float paramFloat, Point paramPoint)
  {
    this.text = paramString;
    this.textSize = paramFloat;
    this.point = paramPoint;
  }
  
  public void draw(Canvas paramCanvas, Paint paramPaint, RangeButtonView.RangeButtonParams paramRangeButtonParams)
  {
    if (this.point == null) {
      return;
    }
    paramPaint.setTextSize(this.textSize);
    int i = paramPaint.getColor();
    paramPaint.setColor(paramRangeButtonParams.titleColor);
    paramCanvas.drawText(this.text, this.point.x, this.point.y, paramPaint);
    paramPaint.setColor(i);
  }
  
  public float getTextSize()
  {
    return this.textSize;
  }
  
  public int getTextWidth()
  {
    return (int)RangeButtonView.measureTextWidth(this.text, this.textSize);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.RangeButtonView.Title
 * JD-Core Version:    0.7.0.1
 */