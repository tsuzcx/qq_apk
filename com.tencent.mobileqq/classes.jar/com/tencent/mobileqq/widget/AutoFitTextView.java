package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;
import bcjx;

public class AutoFitTextView
  extends TextView
{
  private float jdField_a_of_type_Float;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private bcjx jdField_a_of_type_Bcjx;
  
  public AutoFitTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidGraphicsPaint.set(getPaint());
  }
  
  private void a(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramInt <= 0)) {
      return;
    }
    if (this.jdField_a_of_type_Float == 0.0F) {
      this.jdField_a_of_type_Float = getTextSize();
    }
    if (this.jdField_a_of_type_Bcjx != null) {}
    float f1;
    for (paramInt = this.jdField_a_of_type_Bcjx.a();; paramInt = getWidth())
    {
      int i = getPaddingLeft();
      int j = getPaddingRight();
      int k = getCompoundDrawablePadding();
      Rect localRect = new Rect();
      this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(this.jdField_a_of_type_Float);
      this.jdField_a_of_type_AndroidGraphicsPaint.getTextBounds(paramString, 0, paramString.length(), localRect);
      float f2 = localRect.width();
      f1 = this.jdField_a_of_type_Float;
      while (f2 > paramInt - i - j - k)
      {
        f1 -= 1.0F;
        this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(f1);
        f2 = this.jdField_a_of_type_AndroidGraphicsPaint.measureText(paramString);
      }
    }
    setTextSize(0, f1);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    a(getText().toString(), getWidth());
  }
  
  public void setOnGetMaxWidthCallback(bcjx parambcjx)
  {
    this.jdField_a_of_type_Bcjx = parambcjx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.AutoFitTextView
 * JD-Core Version:    0.7.0.1
 */