package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.Button;

public class ProgressButton
  extends Button
{
  public float a;
  public int a;
  public Paint a;
  public float b;
  private int b;
  
  public ProgressButton(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_Int = 100;
    a();
  }
  
  public ProgressButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_Int = 100;
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    int i = getResources().getColorStateList(2131494244).getDefaultColor();
    if (this.jdField_b_of_type_Int == -1)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(i);
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_b_of_type_Int);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Float == 0.0F) {
      this.jdField_a_of_type_Float = (getWidth() / this.jdField_a_of_type_Int);
    }
    paramCanvas.drawRoundRect(new RectF(0.0F, 0.0F, this.jdField_a_of_type_Float * this.jdField_b_of_type_Float, getHeight()), 5.0F, 5.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
    super.onDraw(paramCanvas);
  }
  
  public void setMacProgress(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setProgress(int paramInt)
  {
    this.jdField_b_of_type_Float = paramInt;
    invalidate();
  }
  
  public void setProgressColor(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_b_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProgressButton
 * JD-Core Version:    0.7.0.1
 */