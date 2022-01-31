package com.tencent.mobileqq.subaccount;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

public class UpArrowView
  extends View
{
  int jdField_a_of_type_Int;
  Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  int b;
  int c;
  
  public UpArrowView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public UpArrowView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public UpArrowView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  public void a()
  {
    this.b = Color.argb(255, 255, 255, 255);
    this.c = Color.argb(255, 229, 230, 231);
    this.jdField_a_of_type_Int = Color.argb(255, 222, 222, 222);
    setDuplicateParentStateEnabled(true);
    int i = getResources().getColor(2131494255);
    if (this.b != i) {
      this.b = i;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((isSelected()) || (isPressed())) {
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.c);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      int i = getWidth();
      int j = getHeight();
      Path localPath = new Path();
      localPath.moveTo(0.0F, j);
      localPath.lineTo(i / 2, 0.0F);
      localPath.lineTo(i, j);
      localPath.close();
      paramCanvas.drawPath(localPath, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(getResources().getDisplayMetrics().density * 0.67F);
      paramCanvas.drawLine(0.0F, j, i / 2, 0.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.drawLine(i / 2, 0.0F, i, j, this.jdField_a_of_type_AndroidGraphicsPaint);
      return;
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.b);
    }
  }
  
  public void setPressed(boolean paramBoolean)
  {
    super.setPressed(paramBoolean);
    invalidate();
  }
  
  public void setSelected(boolean paramBoolean)
  {
    super.setSelected(paramBoolean);
    invalidate();
  }
  
  public void setTheme(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.b = Color.argb(255, 24, 50, 87);
      this.c = Color.argb(255, 14, 35, 65);
      this.jdField_a_of_type_Int = Color.argb(255, 13, 33, 62);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.subaccount.UpArrowView
 * JD-Core Version:    0.7.0.1
 */