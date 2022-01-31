package com.tencent.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import bbdh;

public class TriangleView
  extends View
{
  Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  Path jdField_a_of_type_AndroidGraphicsPath = new Path();
  boolean jdField_a_of_type_Boolean = true;
  
  public TriangleView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TriangleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TriangleView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setPathEffect(new CornerPathEffect(bbdh.a(paramContext, 2.0F)));
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.jdField_a_of_type_Boolean)
    {
      int i = getWidth();
      int j = getHeight();
      float f = i * 0.55F;
      this.jdField_a_of_type_AndroidGraphicsPath.moveTo(i / 2.0F - f / 2.0F, j / 2.0F - f * 1.73205F / 6.0F);
      this.jdField_a_of_type_AndroidGraphicsPath.lineTo(i / 2.0F + f / 2.0F, j / 2.0F - f * 1.73205F / 6.0F);
      this.jdField_a_of_type_AndroidGraphicsPath.lineTo(i / 2.0F, j / 2.0F + f * 1.73205F / 3.0F);
      this.jdField_a_of_type_AndroidGraphicsPath.close();
      this.jdField_a_of_type_Boolean = false;
    }
    paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public void setColor(int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.widget.TriangleView
 * JD-Core Version:    0.7.0.1
 */