package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Interpolator;

public class ImageAnimationView
  extends View
{
  float jdField_a_of_type_Float;
  long jdField_a_of_type_Long = 0L;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(6);
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener;
  Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator;
  boolean jdField_a_of_type_Boolean = false;
  float jdField_b_of_type_Float;
  private long jdField_b_of_type_Long = 1000L;
  private Rect jdField_b_of_type_AndroidGraphicsRect;
  float jdField_c_of_type_Float;
  private Rect jdField_c_of_type_AndroidGraphicsRect;
  float jdField_d_of_type_Float;
  private Rect jdField_d_of_type_AndroidGraphicsRect;
  private Rect e = new Rect();
  
  public ImageAnimationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    Animation.AnimationListener localAnimationListener = this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener;
    if (localAnimationListener != null) {
      localAnimationListener.onAnimationStart(null);
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(Bitmap paramBitmap, Rect paramRect1, Rect paramRect2, Rect paramRect3, Rect paramRect4, long paramLong)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_a_of_type_AndroidGraphicsRect = paramRect1;
    this.jdField_b_of_type_AndroidGraphicsRect = paramRect2;
    this.jdField_c_of_type_AndroidGraphicsRect = paramRect3;
    this.jdField_d_of_type_AndroidGraphicsRect = paramRect4;
    this.jdField_b_of_type_Long = paramLong;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.jdField_a_of_type_Long > 0L)
    {
      long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
      float f2 = (float)l / (float)this.jdField_b_of_type_Long;
      Interpolator localInterpolator = this.jdField_a_of_type_AndroidViewAnimationInterpolator;
      float f1 = f2;
      if (localInterpolator != null) {
        f1 = localInterpolator.getInterpolation(f2);
      }
      f2 = 1.0F - f1;
      if ((l <= this.jdField_b_of_type_Long) && (this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_Float = (this.jdField_a_of_type_AndroidGraphicsRect.top * f2 + this.jdField_b_of_type_AndroidGraphicsRect.top * f1);
        this.jdField_b_of_type_Float = (this.jdField_a_of_type_AndroidGraphicsRect.bottom * f2 + this.jdField_b_of_type_AndroidGraphicsRect.bottom * f1);
        this.jdField_c_of_type_Float = (this.jdField_a_of_type_AndroidGraphicsRect.left * f2 + this.jdField_b_of_type_AndroidGraphicsRect.left * f1);
        this.jdField_d_of_type_Float = (this.jdField_a_of_type_AndroidGraphicsRect.right * f2 + this.jdField_b_of_type_AndroidGraphicsRect.right * f1);
        this.e.set((int)this.jdField_c_of_type_Float, (int)this.jdField_a_of_type_Float, (int)this.jdField_d_of_type_Float, (int)this.jdField_b_of_type_Float);
        this.jdField_a_of_type_Float = (this.jdField_c_of_type_AndroidGraphicsRect.top * f2 + this.jdField_d_of_type_AndroidGraphicsRect.top * f1);
        this.jdField_b_of_type_Float = (this.jdField_c_of_type_AndroidGraphicsRect.bottom * f2 + this.jdField_d_of_type_AndroidGraphicsRect.bottom * f1);
        this.jdField_c_of_type_Float = (this.jdField_c_of_type_AndroidGraphicsRect.left * f2 + this.jdField_d_of_type_AndroidGraphicsRect.left * f1);
        this.jdField_d_of_type_Float = (this.jdField_c_of_type_AndroidGraphicsRect.right * f2 + this.jdField_d_of_type_AndroidGraphicsRect.right * f1);
        this.jdField_a_of_type_AndroidGraphicsRectF.set(this.jdField_c_of_type_Float, this.jdField_a_of_type_Float, this.jdField_d_of_type_Float, this.jdField_b_of_type_Float);
      }
      else if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener.onAnimationEnd(null);
      }
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.e, this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
      invalidate();
    }
  }
  
  public void setAnimationListener(Animation.AnimationListener paramAnimationListener)
  {
    this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = paramAnimationListener;
  }
  
  public void setInterpolator(Interpolator paramInterpolator)
  {
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = paramInterpolator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ImageAnimationView
 * JD-Core Version:    0.7.0.1
 */