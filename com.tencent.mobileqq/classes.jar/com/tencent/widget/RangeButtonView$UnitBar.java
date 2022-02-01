package com.tencent.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import java.util.ArrayList;
import java.util.Iterator;

class RangeButtonView$UnitBar
{
  private int centerY;
  private int endX;
  private float height;
  private int startX;
  private int unitNum;
  private ArrayList<Point> unitPoints = new ArrayList();
  
  public RangeButtonView$UnitBar(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.startX = paramInt1;
    this.endX = paramInt2;
    this.centerY = paramInt3;
    this.unitNum = paramInt4;
    this.unitPoints = calculatePoints(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public ArrayList<Point> calculatePoints(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ArrayList localArrayList = new ArrayList(paramInt4);
    int j = (int)((paramInt2 - paramInt1) / (paramInt4 - 1.0F));
    paramInt2 = paramInt1;
    paramInt1 = 0;
    while (paramInt1 < paramInt4)
    {
      int i;
      if (paramInt1 == 0) {
        i = 0;
      } else {
        i = j;
      }
      Point localPoint = new Point(paramInt2 + i, paramInt3);
      localArrayList.add(localPoint);
      paramInt2 = localPoint.x;
      paramInt1 += 1;
    }
    return localArrayList;
  }
  
  public void drawBar(Canvas paramCanvas, Paint paramPaint, RangeButtonView.RangeButtonParams paramRangeButtonParams)
  {
    int i = paramPaint.getColor();
    float f1 = paramPaint.getStrokeWidth();
    paramPaint.setColor(paramRangeButtonParams.lineColor);
    paramPaint.setStrokeWidth(paramRangeButtonParams.lineWeight);
    float f2 = this.startX;
    int j = this.centerY;
    paramCanvas.drawLine(f2, j, this.endX, j, paramPaint);
    paramRangeButtonParams = this.unitPoints.iterator();
    while (paramRangeButtonParams.hasNext())
    {
      Point localPoint = (Point)paramRangeButtonParams.next();
      paramCanvas.drawLine(localPoint.x, localPoint.y - this.height / 2.0F, localPoint.x, localPoint.y + this.height / 2.0F, paramPaint);
    }
    paramPaint.setColor(i);
    paramPaint.setStrokeWidth(f1);
  }
  
  public int getCenterY()
  {
    return this.centerY;
  }
  
  public float getHeight()
  {
    return this.height;
  }
  
  public int getUintSpace()
  {
    return (int)((this.endX - this.startX) / (this.unitNum - 1.0F));
  }
  
  public int getUnitNum()
  {
    return this.unitNum;
  }
  
  public ArrayList<Point> getUnitPoints()
  {
    return this.unitPoints;
  }
  
  public void setHeight(float paramFloat)
  {
    this.height = paramFloat;
  }
  
  public void setUnitNum(int paramInt)
  {
    this.unitNum = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.RangeButtonView.UnitBar
 * JD-Core Version:    0.7.0.1
 */