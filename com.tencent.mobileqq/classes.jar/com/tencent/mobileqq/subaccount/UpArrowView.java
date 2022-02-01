package com.tencent.mobileqq.subaccount;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class UpArrowView
  extends View
{
  int jdField_a_of_type_Int;
  Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  int b;
  
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
    this.jdField_a_of_type_Int = Color.argb(255, 255, 255, 255);
    this.b = Color.argb(255, 241, 242, 249);
    setDuplicateParentStateEnabled(true);
    int i = getResources().getColor(2131167116);
    if (this.jdField_a_of_type_Int != i) {
      this.jdField_a_of_type_Int = i;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((!isSelected()) && (!isPressed())) {
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
    } else {
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.b);
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    int i = getWidth();
    int j = getHeight();
    Path localPath = new Path();
    float f = j;
    localPath.moveTo(0.0F, f);
    localPath.lineTo(i / 2, 0.0F);
    localPath.lineTo(i, f);
    localPath.close();
    paramCanvas.drawPath(localPath, this.jdField_a_of_type_AndroidGraphicsPaint);
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
      this.jdField_a_of_type_Int = Color.argb(255, 0, 0, 0);
      this.b = Color.argb(255, 31, 31, 31);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.subaccount.UpArrowView
 * JD-Core Version:    0.7.0.1
 */