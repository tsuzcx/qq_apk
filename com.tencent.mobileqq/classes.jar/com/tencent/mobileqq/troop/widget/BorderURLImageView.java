package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.tencent.image.URLImageView;

public class BorderURLImageView
  extends URLImageView
{
  protected int a;
  protected int b = -1;
  protected Paint c = new Paint();
  protected Rect d = new Rect();
  
  public BorderURLImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public BorderURLImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public BorderURLImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.a <= 0) {
      return;
    }
    paramCanvas.getClipBounds(this.d);
    this.c.setColor(this.b);
    this.c.setStyle(Paint.Style.STROKE);
    this.c.setStrokeWidth(this.a);
    paramCanvas.drawRect(this.d, this.c);
  }
  
  public void setBorderColor(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setBorderWidth(int paramInt)
  {
    this.a = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.BorderURLImageView
 * JD-Core Version:    0.7.0.1
 */