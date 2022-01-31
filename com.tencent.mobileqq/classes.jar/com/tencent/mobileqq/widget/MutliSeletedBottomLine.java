package com.tencent.mobileqq.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import bdaq;

public class MutliSeletedBottomLine
  extends View
{
  private final float jdField_a_of_type_Float = 0.2F;
  private int jdField_a_of_type_Int;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private boolean jdField_a_of_type_Boolean;
  private final float b = 1.0F;
  private final float c = 2.0F;
  private final float d = 6.0F;
  private float e;
  private float f = 29.0F;
  
  public MutliSeletedBottomLine(Context paramContext, int paramInt, boolean paramBoolean)
  {
    super(paramContext);
    this.e = paramInt;
    this.f = bdaq.a(paramContext, 29.0F);
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = ((int)(paramInt / 8.0F));
  }
  
  @SuppressLint({"ResourceAsColor"})
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(getResources().getColor(2131165253));
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    float f1;
    int i;
    if (!this.jdField_a_of_type_Boolean)
    {
      f1 = 0.2F;
      i = 0;
      label43:
      if (i >= this.jdField_a_of_type_Int) {
        return;
      }
      if (this.jdField_a_of_type_Boolean) {
        break label133;
      }
    }
    label133:
    for (double d1 = f1 + i / this.jdField_a_of_type_Int * 0.8D;; d1 = f1 - i / this.jdField_a_of_type_Int * 0.8D)
    {
      float f2 = (float)d1;
      this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha((int)(f2 * 255.0F));
      paramCanvas.drawCircle(i * 8.0F + 2.0F, this.f / 2.0F, 2.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
      i += 1;
      break label43;
      f1 = 1.0F;
      break;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    setMeasuredDimension((int)this.e, getMeasuredHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.MutliSeletedBottomLine
 * JD-Core Version:    0.7.0.1
 */