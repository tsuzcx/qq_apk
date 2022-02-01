package com.tencent.mobileqq.kandian.base.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class TriangleView
  extends View
{
  Paint a = new Paint();
  Path b;
  Paint c;
  
  public TriangleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a.setColor(-2013265920);
    this.b = new Path();
    this.c = new Paint();
    this.c.setColor(-2013265920);
    this.c.setStrokeWidth(1.0F);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = getMeasuredHeight();
    this.b.moveTo(0, 0.0F);
    this.b.lineTo(i + 0, i);
    this.b.lineTo(i * 2 + 0, 0.0F);
    this.b.close();
    paramCanvas.drawPath(this.b, this.a);
  }
  
  public void setColor(int paramInt)
  {
    this.a.setColor(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.TriangleView
 * JD-Core Version:    0.7.0.1
 */