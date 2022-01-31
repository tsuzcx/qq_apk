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
  protected int a;
  protected Paint a;
  protected RectF a;
  
  public RoundTextView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = -1;
  }
  
  public RoundTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = -1;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RoundTextView);
    this.jdField_a_of_type_Int = paramContext.getColor(0, 2131492969);
    paramContext.recycle();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_AndroidGraphicsPaint == null)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
      this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_AndroidGraphicsRectF == null) {
      this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    }
    this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, getMeasuredWidth(), getMeasuredHeight());
    paramCanvas.drawRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, getMeasuredHeight() / 2, getMeasuredHeight() / 2, this.jdField_a_of_type_AndroidGraphicsPaint);
    super.onDraw(paramCanvas);
  }
  
  public void setRoundBgColor(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.trooponline.widget.RoundTextView
 * JD-Core Version:    0.7.0.1
 */