package com.tencent.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;

public class BorderTextView
  extends SimpleTextView
{
  private int a = 0;
  private float b = 0.0F;
  private Paint c;
  private int d = 0;
  
  public BorderTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public BorderTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public BorderTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.c == null) {
      this.c = new Paint();
    }
    this.c.setStyle(Paint.Style.STROKE);
    this.c.setColor(this.d);
    this.c.setStrokeWidth(this.a);
    int i = this.a;
    RectF localRectF = new RectF(i, i, getMeasuredWidth() - this.a, getMeasuredHeight() - this.a);
    float f = this.b;
    paramCanvas.drawRoundRect(localRectF, f, f, this.c);
  }
  
  public void setBorderColor(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setBorderWidth(int paramInt)
  {
    this.a = paramInt;
    this.b = paramInt;
  }
  
  public void setRadius(float paramFloat)
  {
    this.b = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.BorderTextView
 * JD-Core Version:    0.7.0.1
 */