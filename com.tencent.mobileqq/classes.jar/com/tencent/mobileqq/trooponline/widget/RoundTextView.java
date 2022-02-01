package com.tencent.mobileqq.trooponline.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mobileqq.R.styleable;

public class RoundTextView
  extends TextView
{
  protected int a = -1;
  protected Paint b;
  protected RectF c;
  
  public RoundTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public RoundTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RoundTextView);
    this.a = paramContext.getColor(0, 2131168464);
    paramContext.recycle();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.b == null)
    {
      this.b = new Paint();
      this.b.setAntiAlias(true);
    }
    this.b.setColor(this.a);
    if (this.c == null) {
      this.c = new RectF();
    }
    this.c.set(0.0F, 0.0F, getMeasuredWidth(), getMeasuredHeight());
    paramCanvas.drawRoundRect(this.c, getMeasuredHeight() / 2, getMeasuredHeight() / 2, this.b);
    super.onDraw(paramCanvas);
  }
  
  public void setRoundBgColor(int paramInt)
  {
    this.a = paramInt;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.trooponline.widget.RoundTextView
 * JD-Core Version:    0.7.0.1
 */