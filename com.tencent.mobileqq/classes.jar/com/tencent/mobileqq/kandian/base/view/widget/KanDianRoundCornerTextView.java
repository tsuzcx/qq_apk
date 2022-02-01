package com.tencent.mobileqq.kandian.base.view.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.PaintDrawable;
import android.util.AttributeSet;
import android.widget.TextView;

public class KanDianRoundCornerTextView
  extends TextView
{
  private int a = 0;
  private String b = "#000000";
  private float c = 0.4F;
  
  public KanDianRoundCornerTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public KanDianRoundCornerTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public KanDianRoundCornerTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void setCorner(int paramInt)
  {
    if (paramInt < 0) {
      return;
    }
    this.a = paramInt;
    PaintDrawable localPaintDrawable = new PaintDrawable();
    localPaintDrawable.setCornerRadius(this.a);
    localPaintDrawable.setColorFilter(Color.parseColor(this.b), PorterDuff.Mode.SRC_ATOP);
    localPaintDrawable.setAlpha((int)(this.c * 255.0F));
    setBackgroundDrawable(localPaintDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.KanDianRoundCornerTextView
 * JD-Core Version:    0.7.0.1
 */