package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;
import android.widget.TextView;

public class InterestLabelTextView
  extends TextView
{
  RoundRectShape a = null;
  ShapeDrawable b = null;
  
  public InterestLabelTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public InterestLabelTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public InterestLabelTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    RectF localRectF = new RectF(2.0F, 2.0F, 2.0F, 2.0F);
    this.a = new RoundRectShape(new float[] { 6.0F, 6.0F, 6.0F, 6.0F, 6.0F, 6.0F, 6.0F, 6.0F, 6.0F, 6.0F, 6.0F, 6.0F }, localRectF, new float[] { 3.0F, 3.0F, 3.0F, 3.0F, 3.0F, 3.0F, 3.0F, 3.0F, 3.0F, 3.0F, 3.0F, 3.0F });
    this.b = new ShapeDrawable(this.a);
    this.b.getPaint().setColor(-16777216);
    setBackgroundDrawable(this.b);
  }
  
  public void setColorFormat(int paramInt)
  {
    this.b.getPaint().setColor(paramInt);
    setTextColor(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.InterestLabelTextView
 * JD-Core Version:    0.7.0.1
 */