package com.tencent.mobileqq.portal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import awmx;
import bdob;

public class ImageAlphaSwitchView
  extends View
{
  public float a;
  int jdField_a_of_type_Int;
  public Bitmap a;
  Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  public Transformation a;
  public bdob<Float> a;
  int b;
  public Bitmap b;
  int c = 3;
  
  public ImageAlphaSwitchView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidViewAnimationTransformation = new Transformation();
    this.jdField_a_of_type_Bdob = null;
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
  }
  
  public ImageAlphaSwitchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidViewAnimationTransformation = new Transformation();
    this.jdField_a_of_type_Bdob = null;
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
  }
  
  private void a()
  {
    bdob localbdob = new bdob(Float.valueOf(0.0F), Float.valueOf(255.0F), new awmx(this));
    if (this.jdField_a_of_type_Bdob != null) {
      this.jdField_a_of_type_Bdob.cancel();
    }
    this.jdField_a_of_type_Bdob = localbdob;
    localbdob.setDuration(500L);
    localbdob.start();
    invalidate();
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null)
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
      this.jdField_b_of_type_AndroidGraphicsBitmap = null;
      this.jdField_a_of_type_Float = 0.0F;
      invalidate();
      return;
    }
    this.jdField_b_of_type_AndroidGraphicsBitmap = paramBitmap;
    a();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    boolean bool = false;
    super.onDraw(paramCanvas);
    this.jdField_a_of_type_Int = getWidth();
    this.jdField_b_of_type_Int = getHeight();
    int i;
    int m;
    int j;
    if (this.jdField_b_of_type_AndroidGraphicsBitmap != null)
    {
      i = this.jdField_b_of_type_AndroidGraphicsBitmap.getWidth();
      k = this.jdField_b_of_type_AndroidGraphicsBitmap.getHeight();
      m = this.jdField_b_of_type_Int * i / k;
      j = this.jdField_b_of_type_Int;
      if (m <= this.jdField_a_of_type_Int) {
        break label415;
      }
      m = this.jdField_a_of_type_Int;
      j = m * k / i;
    }
    label404:
    label410:
    label415:
    for (int k = (this.jdField_b_of_type_Int - j) / 2;; k = 0)
    {
      if (this.c == 3) {
        i = 0;
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha((int)this.jdField_a_of_type_Float);
        this.jdField_a_of_type_AndroidGraphicsRect.set(i, k, m + i, j);
        paramCanvas.drawBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap, null, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
        if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
        {
          i = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
          k = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
          m = this.jdField_b_of_type_Int * i / k;
          j = this.jdField_b_of_type_Int;
          if (m <= this.jdField_a_of_type_Int) {
            break label404;
          }
          m = this.jdField_a_of_type_Int;
          j = this.jdField_a_of_type_Int * k / i;
        }
        for (k = (this.jdField_b_of_type_Int - j) / 2;; k = 0)
        {
          if (this.c == 3) {
            i = 0;
          }
          for (;;)
          {
            this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(255 - (int)this.jdField_a_of_type_Float);
            this.jdField_a_of_type_AndroidGraphicsRect.set(i, k, m + i, j);
            paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, null, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
            if (this.jdField_a_of_type_Bdob != null) {
              bool = this.jdField_a_of_type_Bdob.getTransformation(AnimationUtils.currentAnimationTimeMillis(), this.jdField_a_of_type_AndroidViewAnimationTransformation);
            }
            if (bool) {
              invalidate();
            }
            return;
            if (this.c == 17)
            {
              i = (this.jdField_a_of_type_Int - m) / 2;
              break;
            }
            if (this.c != 5) {
              break label410;
            }
            i = this.jdField_a_of_type_Int - m;
            break;
            if (this.c == 17) {
              i = (this.jdField_a_of_type_Int - m) / 2;
            } else if (this.c == 5) {
              i = this.jdField_a_of_type_Int - m;
            } else {
              i = 0;
            }
          }
        }
        i = 0;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setGravity(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setImage(Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_Bdob != null) {
      this.jdField_a_of_type_Bdob.cancel();
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_b_of_type_AndroidGraphicsBitmap = null;
    this.jdField_a_of_type_Float = 0.0F;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.portal.ImageAlphaSwitchView
 * JD-Core Version:    0.7.0.1
 */