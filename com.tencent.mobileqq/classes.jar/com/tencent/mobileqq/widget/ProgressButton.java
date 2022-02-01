package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.support.annotation.ColorInt;
import android.util.AttributeSet;
import android.widget.Button;
import bgtn;

public class ProgressButton
  extends Button
{
  protected float a;
  protected int a;
  protected Paint a;
  protected ClipDrawable a;
  protected float b;
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
    int i = getResources().getColorStateList(2131167019).getDefaultColor();
    if (this.jdField_b_of_type_Int == -1)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(i);
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_b_of_type_Int);
  }
  
  public ClipDrawable a(@ColorInt int paramInt)
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableClipDrawable != null) {
      return this.jdField_a_of_type_AndroidGraphicsDrawableClipDrawable;
    }
    float f = bgtn.a(50.0F);
    ShapeDrawable localShapeDrawable = new ShapeDrawable(new RoundRectShape(new float[] { f, f, f, f, f, f, f, f }, null, null));
    localShapeDrawable.getPaint().setColor(paramInt);
    return new ClipDrawable(localShapeDrawable, 8388611, 1);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableClipDrawable != null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableClipDrawable.setBounds(0, 0, getWidth(), getHeight());
      this.jdField_a_of_type_AndroidGraphicsDrawableClipDrawable.setLevel((int)(10000 / this.jdField_a_of_type_Int * this.jdField_b_of_type_Float));
      this.jdField_a_of_type_AndroidGraphicsDrawableClipDrawable.draw(paramCanvas);
    }
    for (;;)
    {
      super.onDraw(paramCanvas);
      return;
      if (this.jdField_a_of_type_Float == 0.0F) {
        this.jdField_a_of_type_Float = (getWidth() / this.jdField_a_of_type_Int);
      }
      paramCanvas.drawRoundRect(new RectF(0.0F, 0.0F, this.jdField_a_of_type_Float * this.jdField_b_of_type_Float, getHeight()), 5.0F, 5.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
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
  
  public void setProgressDrawable(ClipDrawable paramClipDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableClipDrawable = paramClipDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProgressButton
 * JD-Core Version:    0.7.0.1
 */