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
  private float jdField_a_of_type_Float = 0.0F;
  private int jdField_a_of_type_Int = 3;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
  private boolean jdField_a_of_type_Boolean = false;
  
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
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(getResources().getColor(2131167394));
      this.jdField_a_of_type_Int = ((int)(getResources().getDisplayMetrics().density * 1.5F));
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_a_of_type_Int);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean != paramBoolean)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)) {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130850766);
      }
      postInvalidate();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Object localObject = new RectF();
    int i = this.jdField_a_of_type_Int;
    ((RectF)localObject).left = i;
    ((RectF)localObject).top = i;
    ((RectF)localObject).right = (getWidth() - this.jdField_a_of_type_Int);
    ((RectF)localObject).bottom = (getHeight() - this.jdField_a_of_type_Int);
    paramCanvas.drawArc((RectF)localObject, 270.0F, this.jdField_a_of_type_Float, false, this.jdField_a_of_type_AndroidGraphicsPaint);
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      if (localObject != null)
      {
        ((Drawable)localObject).setState(getDrawableState());
        i = getWidth();
        int j = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
        int k = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight();
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(i - j, 0, getWidth(), k);
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      }
    }
  }
  
  public void setProgress(float paramFloat)
  {
    float f;
    if (paramFloat < 0.0F)
    {
      f = 0.0F;
    }
    else
    {
      f = paramFloat;
      if (paramFloat > 1.0F) {
        f = 1.0F;
      }
    }
    paramFloat = f * 360.0F;
    if (this.jdField_a_of_type_Float != paramFloat)
    {
      this.jdField_a_of_type_Float = paramFloat;
      postInvalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ArcImageView
 * JD-Core Version:    0.7.0.1
 */