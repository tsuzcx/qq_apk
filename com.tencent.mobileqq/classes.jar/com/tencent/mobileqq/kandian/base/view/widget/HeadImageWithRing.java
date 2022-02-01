package com.tencent.mobileqq.kandian.base.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;

public class HeadImageWithRing
  extends KanDianUrlRoundCornerImageView
{
  boolean a;
  Paint b;
  int c;
  int d;
  int e;
  int f;
  
  public HeadImageWithRing(Context paramContext)
  {
    super(paramContext);
  }
  
  public HeadImageWithRing(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public HeadImageWithRing(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.a)
    {
      int i = this.f;
      paramCanvas.drawCircle(i, i, this.c, this.b);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.c = ((int)((getMeasuredWidth() - getPaddingLeft() - getPaddingRight() - this.d) * 0.5F));
    double d1 = getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
    Double.isNaN(d1);
    double d2 = getPaddingLeft();
    Double.isNaN(d2);
    this.f = ((int)(d1 * 0.5D + d2));
    this.b = new Paint(1);
    this.b.setColor(this.e);
    this.b.setStrokeWidth(this.d);
    this.b.setStyle(Paint.Style.STROKE);
  }
  
  public void setAttrs(int paramInt1, int paramInt2)
  {
    this.d = paramInt1;
    this.e = paramInt2;
  }
  
  public void setDrawRing(boolean paramBoolean)
  {
    this.a = paramBoolean;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.HeadImageWithRing
 * JD-Core Version:    0.7.0.1
 */