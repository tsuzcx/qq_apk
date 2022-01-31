package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ImageView;

public class ArcImageView
  extends ImageView
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 3;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private boolean jdField_a_of_type_Boolean;
  
  public ArcImageView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public ArcImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public ArcImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    try
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(getResources().getColor(2131492969));
      this.jdField_a_of_type_Int = ((int)(getResources().getDisplayMetrics().density * 1.5F));
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_a_of_type_Int);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean != paramBoolean)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)) {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130846051);
      }
      postInvalidate();
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    RectF localRectF = new RectF();
    localRectF.left = this.jdField_a_of_type_Int;
    localRectF.top = this.jdField_a_of_type_Int;
    localRectF.right = (getWidth() - this.jdField_a_of_type_Int);
    localRectF.bottom = (getHeight() - this.jdField_a_of_type_Int);
    paramCanvas.drawArc(localRectF, 270.0F, this.jdField_a_of_type_Float, false, this.jdField_a_of_type_AndroidGraphicsPaint);
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null))
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setState(getDrawableState());
      int i = getWidth();
      int j = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
      int k = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(i - j, 0, getWidth(), k);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    }
  }
  
  public void setProgress(float paramFloat)
  {
    float f;
    if (paramFloat < 0.0F) {
      f = 0.0F;
    }
    for (;;)
    {
      paramFloat = 360.0F * f;
      if (this.jdField_a_of_type_Float != paramFloat)
      {
        this.jdField_a_of_type_Float = paramFloat;
        postInvalidate();
      }
      return;
      f = paramFloat;
      if (paramFloat > 1.0F) {
        f = 1.0F;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ArcImageView
 * JD-Core Version:    0.7.0.1
 */