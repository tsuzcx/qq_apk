package com.tencent.mobileqq.troop.widget;

import ajsc;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mobileqq.R.styleable;

public class EllipsizingTextView
  extends TextView
{
  private int jdField_a_of_type_Int = 1;
  private ajsc jdField_a_of_type_Ajsc;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  public EllipsizingTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.EllipsizingTextView);
      int i = 0;
      int j = paramContext.getIndexCount();
      if (i < j)
      {
        int k = paramContext.getIndex(i);
        switch (k)
        {
        }
        for (;;)
        {
          i += 1;
          break;
          this.jdField_b_of_type_Int = paramContext.getDimensionPixelOffset(k, this.jdField_b_of_type_Int);
          continue;
          this.jdField_a_of_type_Int = paramContext.getInt(k, this.jdField_a_of_type_Int);
          continue;
          this.jdField_a_of_type_Boolean = paramContext.getBoolean(k, this.jdField_a_of_type_Boolean);
        }
      }
      paramContext.recycle();
    }
  }
  
  private ajsc a()
  {
    if (this.jdField_a_of_type_Ajsc == null) {
      this.jdField_a_of_type_Ajsc = new ajsc(this);
    }
    return this.jdField_a_of_type_Ajsc;
  }
  
  public void a()
  {
    this.c = true;
  }
  
  public int getLineCount()
  {
    return a().a();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    Object localObject = getPaint();
    ((TextPaint)localObject).setColor(getCurrentTextColor());
    ((TextPaint)localObject).drawableState = getDrawableState();
    localObject = a();
    ((ajsc)localObject).a(getText(), this, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_Boolean);
    if (getEllipsize() == TextUtils.TruncateAt.END)
    {
      ((ajsc)localObject).a(paramCanvas, TextUtils.TruncateAt.END);
      return;
    }
    if (getEllipsize() == TextUtils.TruncateAt.MIDDLE)
    {
      ((ajsc)localObject).a(paramCanvas, TextUtils.TruncateAt.MIDDLE);
      return;
    }
    super.onDraw(paramCanvas);
  }
  
  public void setEndStrWidth(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void setMaxLines(int paramInt)
  {
    super.setMaxLines(paramInt);
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.EllipsizingTextView
 * JD-Core Version:    0.7.0.1
 */