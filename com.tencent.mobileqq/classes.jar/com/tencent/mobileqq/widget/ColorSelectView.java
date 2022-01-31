package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import baxn;

public class ColorSelectView
  extends View
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  
  public ColorSelectView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public ColorSelectView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public ColorSelectView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.b = baxn.a(getContext(), 5.0F);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = getMeasuredWidth();
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    paramCanvas.drawCircle(i / 2, i / 2, (i - this.b) / 2, this.jdField_a_of_type_AndroidGraphicsPaint);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-15550475);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_a_of_type_Float);
      paramCanvas.drawCircle(i / 2, i / 2, i / 2 - this.jdField_a_of_type_Float, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  public void setColor(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    invalidate();
  }
  
  public void setSelect(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ColorSelectView
 * JD-Core Version:    0.7.0.1
 */