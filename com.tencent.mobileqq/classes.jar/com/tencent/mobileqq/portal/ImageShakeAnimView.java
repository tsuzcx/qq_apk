package com.tencent.mobileqq.portal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import awip;
import bdjs;

public class ImageShakeAnimView
  extends View
{
  public float a;
  int jdField_a_of_type_Int = 0;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  public Transformation a;
  bdjs<Float> jdField_a_of_type_Bdjs = null;
  public boolean a;
  public float b;
  int b;
  int c = 0;
  int d = 0;
  
  public ImageShakeAnimView(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_b_of_type_Float = 1.0F;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewAnimationTransformation = new Transformation();
    a(null);
  }
  
  public ImageShakeAnimView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_b_of_type_Float = 1.0F;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewAnimationTransformation = new Transformation();
    a(null);
  }
  
  private void a(Integer paramInteger)
  {
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = PortalManager.a("", true);
      return;
    }
    catch (OutOfMemoryError paramInteger)
    {
      paramInteger.printStackTrace();
    }
  }
  
  public void a()
  {
    float f;
    bdjs localbdjs;
    if (this.jdField_a_of_type_Boolean)
    {
      f = 720.0F;
      localbdjs = new bdjs(Float.valueOf(0.0F), Float.valueOf(f), new awip(this));
      if (this.jdField_a_of_type_Bdjs != null) {
        this.jdField_a_of_type_Bdjs.cancel();
      }
      this.jdField_a_of_type_Bdjs = localbdjs;
      if (!this.jdField_a_of_type_Boolean) {
        break label88;
      }
    }
    label88:
    for (long l = 720L;; l = 500L)
    {
      localbdjs.setDuration(l);
      localbdjs.start();
      invalidate();
      return;
      f = 500.0F;
      break;
    }
  }
  
  public boolean a(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {}
    do
    {
      return false;
      if (this.jdField_a_of_type_Int == 0)
      {
        this.jdField_a_of_type_Int = getWidth();
        this.jdField_b_of_type_Int = getHeight();
      }
      paramCanvas.save();
      paramCanvas.translate(this.c, this.d);
      paramCanvas.scale(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_a_of_type_Int / 2, 0.0F);
      this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int * this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() / this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth());
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, null, this.jdField_a_of_type_AndroidGraphicsRect, null);
      paramCanvas.restore();
    } while (this.jdField_a_of_type_Bdjs == null);
    return this.jdField_a_of_type_Bdjs.getTransformation(AnimationUtils.currentAnimationTimeMillis(), this.jdField_a_of_type_AndroidViewAnimationTransformation);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (a(paramCanvas)) {
      invalidate();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Int = getWidth();
      this.jdField_b_of_type_Int = getHeight();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.portal.ImageShakeAnimView
 * JD-Core Version:    0.7.0.1
 */