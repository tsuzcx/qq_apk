package com.tencent.qqmini.sdk.widget.media.danmu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

public class BorderTextView
  extends TextView
{
  private int borderColor;
  
  public BorderTextView(Context paramContext, int paramInt)
  {
    this(paramContext, null, paramInt);
  }
  
  public BorderTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    this.borderColor = paramInt;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    Paint localPaint = new Paint();
    localPaint.setColor(this.borderColor);
    localPaint.setStrokeWidth(5.0F);
    paramCanvas.drawLine(0.0F, 0.0F, getWidth(), 0.0F, localPaint);
    paramCanvas.drawLine(0.0F, 0.0F, 0.0F, getHeight(), localPaint);
    paramCanvas.drawLine(getWidth(), 0.0F, getWidth(), getHeight(), localPaint);
    paramCanvas.drawLine(0.0F, getHeight(), getWidth(), getHeight(), localPaint);
    super.onDraw(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.danmu.BorderTextView
 * JD-Core Version:    0.7.0.1
 */