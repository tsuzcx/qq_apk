package com.tencent.mobileqq.widget;

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
    setGravity(16);
  }
  
  public DrawableCenterTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setGravity(16);
  }
  
  public DrawableCenterTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setGravity(16);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    Object localObject2 = getCompoundDrawables();
    Object localObject1;
    float f1;
    int i;
    float f2;
    if (localObject2 != null)
    {
      localObject1 = localObject2[0];
      localObject2 = localObject2[2];
      if ((localObject1 != null) || (localObject2 != null))
      {
        f1 = getPaint().measureText(getText().toString());
        i = getCompoundDrawablePadding();
        f2 = f1 + i;
        if ((localObject1 == null) || (localObject2 != null)) {
          break label101;
        }
        f1 = f2 + localObject1.getIntrinsicWidth();
      }
    }
    for (;;)
    {
      paramCanvas.translate((getWidth() - f1) / 2.0F, 0.0F);
      super.onDraw(paramCanvas);
      return;
      label101:
      if ((localObject2 != null) && (localObject1 == null))
      {
        f1 = f2 + ((Drawable)localObject2).getIntrinsicWidth();
        setPadding(0, 0, (int)(getWidth() - f1), 0);
      }
      else
      {
        f1 = f2;
        if (localObject1 != null)
        {
          f1 = f2;
          if (localObject2 != null)
          {
            int j = ((Drawable)localObject2).getIntrinsicWidth();
            f1 = f2 + (localObject1.getIntrinsicWidth() + j + i);
            setPadding(0, 0, (int)(getWidth() - f1), 0);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.DrawableCenterTextView
 * JD-Core Version:    0.7.0.1
 */