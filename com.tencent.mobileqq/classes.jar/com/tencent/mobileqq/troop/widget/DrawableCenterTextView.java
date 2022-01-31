package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;

public class DrawableCenterTextView
  extends TextView
{
  public DrawableCenterTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public DrawableCenterTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public DrawableCenterTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    Object localObject = getCompoundDrawables();
    if (localObject != null)
    {
      localObject = localObject[0];
      if (localObject != null)
      {
        float f1 = getPaint().measureText(getText().toString());
        int i = getCompoundDrawablePadding();
        float f2 = ((Drawable)localObject).getIntrinsicWidth();
        float f3 = i;
        paramCanvas.translate((getWidth() - (f2 + f1 + f3)) / 2.0F, 0.0F);
      }
    }
    super.onDraw(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.DrawableCenterTextView
 * JD-Core Version:    0.7.0.1
 */