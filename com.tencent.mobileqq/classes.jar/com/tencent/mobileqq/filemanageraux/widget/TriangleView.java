package com.tencent.mobileqq.filemanageraux.widget;

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
    this.a.setColor(-1);
    this.b = new Path();
    this.c = new Paint();
    this.c.setColor(-2170912);
    this.c.setStrokeWidth(2.0F);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = getMeasuredHeight();
    Path localPath = this.b;
    float f1 = i + 150;
    localPath.moveTo(f1, 0.0F);
    localPath = this.b;
    float f2 = '';
    float f3 = i;
    localPath.lineTo(f2, f3);
    localPath = this.b;
    float f4 = i * 2 + 150;
    localPath.lineTo(f4, f3);
    this.b.close();
    paramCanvas.drawPath(this.b, this.a);
    this.c.setStrokeWidth(1.0F);
    paramCanvas.drawLine(f1, 0.0F, f2, f3, this.c);
    paramCanvas.drawLine(f1, 0.0F, f4, f3, this.c);
    this.c.setStrokeWidth(2.0F);
    paramCanvas.drawLine(0.0F, f3, f2, f3, this.c);
    paramCanvas.drawLine(f4, f3, getMeasuredWidth(), f3, this.c);
  }
  
  public void setColor(int paramInt)
  {
    this.a.setColor(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.widget.TriangleView
 * JD-Core Version:    0.7.0.1
 */