package com.tencent.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;

public class BaselineTextView
  extends TextView
{
  public BaselineTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    paramCanvas.translate(0.0F, getHeight() - getBaseline() - getPaddingBottom());
    super.onDraw(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.widget.BaselineTextView
 * JD-Core Version:    0.7.0.1
 */