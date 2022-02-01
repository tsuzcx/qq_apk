package com.tencent.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.tencent.mobileqq.activity.aio.AIOUtils;

public class RoundBGTextView
  extends SingleLineTextView
{
  private int a = 0;
  private Paint b;
  private int c = 0;
  
  public RoundBGTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public RoundBGTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RoundBGTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.b == null) {
      this.b = new Paint();
    }
    this.b.setStyle(Paint.Style.FILL);
    this.b.setColor(this.c);
    RectF localRectF = new RectF(0.0F, 0.0F, getMeasuredWidth(), getMeasuredHeight());
    int i = this.a;
    paramCanvas.drawRoundRect(localRectF, i, i, this.b);
    super.onDraw(paramCanvas);
  }
  
  public void setBgColor(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setRoundCornerSize(int paramInt)
  {
    this.a = AIOUtils.b(paramInt, getResources());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.RoundBGTextView
 * JD-Core Version:    0.7.0.1
 */