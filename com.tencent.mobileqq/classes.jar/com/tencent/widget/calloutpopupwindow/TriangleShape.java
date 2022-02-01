package com.tencent.widget.calloutpopupwindow;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.drawable.shapes.Shape;

public class TriangleShape
  extends Shape
{
  Path a = new Path();
  private int b;
  
  public TriangleShape(int paramInt)
  {
    this.b = paramInt;
  }
  
  private void a(float paramFloat1, float paramFloat2, int paramInt)
  {
    PointF localPointF1 = null;
    PointF localPointF3;
    PointF localPointF2;
    if (paramInt == 33)
    {
      localPointF1 = new PointF(0.0F, paramFloat2);
      localPointF3 = new PointF(paramFloat1, paramFloat2);
      localPointF2 = new PointF(paramFloat1 / 2.0F, 0.0F);
    }
    else if (paramInt == 34)
    {
      localPointF1 = new PointF(0.0F, 0.0F);
      localPointF3 = new PointF(paramFloat1, 0.0F);
      localPointF2 = new PointF(paramFloat1 / 2.0F, paramFloat2);
    }
    else if (paramInt == 35)
    {
      localPointF1 = new PointF(0.0F, 0.0F);
      localPointF3 = new PointF(0.0F, paramFloat2);
      localPointF2 = new PointF(paramFloat1, paramFloat2 / 2.0F);
    }
    else if (paramInt == 36)
    {
      localPointF1 = new PointF(paramFloat1, 0.0F);
      localPointF3 = new PointF(0.0F, paramFloat2 / 2.0F);
      localPointF2 = new PointF(paramFloat1, paramFloat2);
    }
    else
    {
      localPointF3 = null;
      localPointF2 = localPointF3;
    }
    if (localPointF1 != null) {
      this.a.moveTo(localPointF1.x, localPointF1.y);
    }
    if (localPointF3 != null) {
      this.a.lineTo(localPointF3.x, localPointF3.y);
    }
    if (localPointF2 != null) {
      this.a.lineTo(localPointF2.x, localPointF2.y);
    }
  }
  
  public void draw(Canvas paramCanvas, Paint paramPaint)
  {
    a(getWidth(), getHeight(), this.b);
    paramCanvas.drawPath(this.a, paramPaint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.calloutpopupwindow.TriangleShape
 * JD-Core Version:    0.7.0.1
 */